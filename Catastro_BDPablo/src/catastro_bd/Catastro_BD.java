/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catastro_bd;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils78.ES;

/**
 *
 * @author Usuario
 */
public class Catastro_BD {

    static String ruta = "src/datos/";

    public static void main(String[] args) {
        /*cargaTabla2("COMUNIDADES", "comunidades.txt");
        cargaTabla2("PROVINCIAS", "provincias.txt");
        cargaTabla2("POBLACIONES", "poblaciones.txt");*/
 /* objeto operaBD---------------------*/
        OperaBD operaciones = new OperaBD("jdbc:oracle:thin:@localhost:1521:XE",
                "oracle.jdbc.driver.OracleDriver",
                "catastro", "catastro");
        menu(operaciones);
    }//main
    //--------------------------------------------
    //------------------------------------------------

    static void menu(OperaBD operaciones) {
        int op;

        do {
            op = ES.leeN("---------------MENU---------------" + "\n"
                    + "Pulsa 1 Listar Provincias de una comunidad \n"
                    + "Pulsa 2 Añadir un nuevo Municipio \n"
                    + "Pulsa 3 Cambiar Municipio de Provincia\n"
                    + "Pulsa 4 Listado nº de Provincias y Municipios Por Comunidad\n"
                    + "Pulsa 5 Guardar cada comunidad con sus provincias y pueblos\n"
                    + "en un fichero de texto: Comunidad.txt.\n"
                    + "Pulsa 6 obtener (Provincia y Comunidad) a partir de poblacion \n"
                    + "Pulsa 7 Para salir\n");
            switch (op) {
                case 0:

                    break;
                case 1:
                    //listaTabla("COMUNIDADES");
                    operaciones.lanzaSql("select * from COMUNIDADES");
                    operaciones.listaSelect();
                    String comu = ES.leeDeTeclado("Abrebiatura?");

                    operaciones.lanzaSql("select * from PROVINCIAS "
                            + " where COMUNIDAD='" + comu + "'");
                    operaciones.listaSelect();

                    //listaTabla("PROVINCIAS","COMUNIDAD",comu,operaciones);
                    break;
                case 2:
                    operaciones.insertaFila("POBLACIONES");

                    break;
                case 3:
                    cambiaPuebloDeProvincia(operaciones);
                    break;
                case 4:
                    operaciones.lanzaSql("select c.nombre comunidad, pv.provincia provincia, count(pb.idpoblacion) pueblos from "
                            + "comunidades c, provincias pv, poblaciones pb "
                            + "where c.codigo= pv.comunidad and pv.idprovincia=pb.idprovincia "
                            + "group by c.nombre, pv.provincia "
                            + "union "
                            + "select c.nombre comunidad, 'zz total_pueblos' provincia, count(pb.idpoblacion) pueblos from "
                            + "comunidades c, provincias pv, poblaciones pb "
                            + "where c.codigo= pv.comunidad and pv.idprovincia=pb.idprovincia "
                            + "group by c.nombre "
                            + "order by comunidad,provincia");//,operaciones);
                    operaciones.listaSelect();

                    break;
                case 5:
                        guardaCatastro(operaciones);
                    break;
                case 6:
                    String pueblo = ES.leeDeTeclado("Nombre del pueblo?");
                    pueblo = pueblo.toUpperCase();
                    operaciones.lanzaSql("select poblacion ||'->',provincia,nombre from comunidades c, provincias pv, poblaciones pb "
                            + "where c.codigo=pv.comunidad and pv.idprovincia = pb.idprovincia and Upper(poblacion) ='" + pueblo + "'");
                    /*listaSelect("select poblacion ||'->',provincia,nombre from comunidades c, provincias pv, poblaciones pb " +
                                        "where c.codigo=pv.comunidad and pv.idprovincia = pb.idprovincia and Upper(poblacion) ='"+pueblo+"'",
                                        operaciones);*/
                    operaciones.listaSelect();

                    break;


            }//switch
        } while (op < 7);

    }//menu

    //----------------------------------
    static void cargaTabla2(String tabla, String fichero, OperaBD operaciones) {

        FileReader fr = null;
        Connection conn = null;
        Scanner scl = null, sc = null;
        String linea = "", codigo, nombre, insert = "";
        String campo = "";
        ArrayList<String> types = new ArrayList();
        ResultSet rset;
        try {
            conn = operaciones.conectaOracle();
            Statement sentencia = conn.createStatement();
            // Procesamos el fichero..............
            fr = new FileReader(ruta + fichero);
            sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                scl = new Scanner(linea);
                scl.useDelimiter(",");

                //sentencia.executeQuery("select * from "+tabla);
                rset = sentencia.executeQuery("select data_type from user_tab_columns "
                        + "where table_name='" + tabla + "'");
                while (rset.next()) {
                    types.add(rset.getString("data_type"));

                }

                insert = "insert into " + tabla + " values (";

                int i = 0;
                while (scl.hasNext()) {
                    campo = scl.next();
                    if (types.get(i).equalsIgnoreCase("VARCHAR2")) {
                        insert += "'" + campo + "',";
                    } else {
                        insert += campo + ",";
                    }
                    i++;
                }
                insert = insert.substring(0, insert.length() - 1);
                insert += ")";
                System.out.println("insert= " + insert);
                sentencia.executeUpdate(insert);
            }
            //listar comunidades.....

            System.out.println("Comunidades insertadas en BD....");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Catastro_BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Catastro_BD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
                conn.close();
            } catch (IOException ex) {
                System.out.println("Error cerrando el fichero->" + fichero + ": " + ex);
            } catch (SQLException ex) {
                System.out.println("Error cerrando conexio BD ->" + ex);
            }
        }

    }//carga TAbla
    //---------------------------------

    static void cambiaPuebloDeProvincia(OperaBD operaciones) {
        try {
            String pueblo = "", provincia = "";
            int idprovincia;
            ResultSet rset;
            pueblo = ES.leeDeTeclado("nombre del pueblo");
            provincia = ES.leeDeTeclado("nombre de la provincia");

            String ss = "select idprovincia from provincias "
                    + "where provincia ='" + provincia + "'";
            System.out.println("Sentenica->" + ss);

            operaciones.lanzaSql("select idprovincia from provincias "
                    + "where provincia ='" + provincia + "'");
            rset = operaciones.datos;
            rset.next();
            idprovincia = rset.getInt(1);

            operaciones.lanzaSql("update poblaciones set idprovincia=" + idprovincia + " "
                    + "where poblacion='" + pueblo + "'");
            System.out.println("cantidad de pueblos actualizados->" + operaciones.filas);

        } catch (SQLException ex) {
            Logger.getLogger(Catastro_BD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*------------------------------------------- 
    static void listaTabla(String tabla, String columna, String dato, OperaBD operaciones ){
        //Connection conn =null;
        ResultSet rset;
            
        try {
            /*conn = conectaOracle();
            Statement sentencia= conn.createStatement();
            
            rset=sentencia.executeQuery("select * from "+tabla+
                                        " where "+columna+"='"+dato+"'");
            
            operaciones.lanzaSql("select * from "+tabla+
                                        " where "+columna+"='"+dato+"'");
            rset=operaciones.datos;
            
            
            int numColum =rset.getMetaData().getColumnCount();
            
            while(rset.next()){
                //System.out.println(rset.getString(1)+"->"+rset.getString(2));
                for(int i=1;i<=numColum;i++){
                   System.out.print(rset.getString(i)+" "); 
                }
                System.out.println();
            }
            
            //conn.close();
            //operaciones.close();
            
        } catch (SQLException ex) {
            System.out.println("Error-> conexión fallida"+ ex);
        }
        
    }
    
    static void listaSelect(String select,OperaBD operaciones){
        Connection conn =null;
        ResultSet rset;
            
        try {
            //System.out.println("select->"+ select);
            /*conn = conectaOracle();
            Statement sentencia= conn.createStatement();
            
            rset=sentencia.executeQuery(select);
            rset=resultadoConsulta(select);
            operaciones.lanzaSql(select);
            rset=operaciones.datos;
            
            int numColum =rset.getMetaData().getColumnCount();
            while(rset.next()){
                //System.out.println(rset.getString(1)+"->"+rset.getString(2));
                for(int i=1;i<=numColum;i++){
                   System.out.print(rset.getString(i)+" "); 
                }
                System.out.println();
            }
            
            //conn.close();
            
        } catch (SQLException ex) {
            System.out.println("Error-> conexión fallida"+ ex);
        }
    } 
    
   static Connection conectaOracle(){
        
    String cadenaConexion = 
            "jdbc:oracle:thin:@localhost:1521:XE";
    String usuario="catastro";
    String contraseña="catastro";
    Connection conn=null;
        try {
            //1.- Cargar el driver JDBC....
            /*DriverManager.registerDriver(
                    new oracle.jdbc.driver.OracleDriver());*/
    // Class.forName("oracle.jdbc.driver.OracleDriver");
    //2.- Obtener la conexión.....
    //  conn =DriverManager.getConnection(cadenaConexion, usuario, contraseña);
    //return conn;
    /*   }catch (ClassNotFoundException ex) {
              System.out.println("Error-> No escuentra el driver oracle "+ ex);
        }catch (SQLException ex) {
            System.out.println("Error Sql-> "+ ex);
        }
        
        return conn;
   
    }//conectaOracle*/
    //---------------------------------- 
    static void guardaCatastro(OperaBD operaciones) {

        String nombre;
        FileWriter fw = null;
        BufferedWriter bw;
        ResultSet rsComu, rsProv, rsPob;
        String consultaComu = "Select * from COMUNIDADES";

        try {

            rsComu = operaciones.lanzaSql(consultaComu);
            while (rsComu.next()) {
                nombre = rsComu.getString("NOMBRE");
                //creamos los ficheros con los nombres de las comunidades
                fw = new FileWriter(ruta + nombre + ".txt");
                bw = new BufferedWriter(fw);
                bw.newLine();

                String codigo = rsComu.getString("CODIGO");
                rsProv = operaciones.lanzaSql("select IDPROVINCIA,PROVINCIA from PROVINCIAS"
                        + " where COMUNIDAD='" + codigo + "'");

                //rst=operaciones.datos;
                while (rsProv.next()) {
                    String provincia = rsProv.getString("PROVINCIA");
                    String idprovincia = rsProv.getString("IDPROVINCIA");
                    bw.write(provincia);
                    bw.newLine();

                    rsPob = operaciones.lanzaSql("select POBLACION from POBLACIONES "
                            + "where IDPROVINCIA=" + idprovincia);

                    while (rsPob.next()) {

                        //rset=operaciones.datos;
                        String poblacion = rsPob.getString("POBLACION");
                        bw.write(poblacion);
                        bw.newLine();
                    }
                    rsPob.close();
                }
                rsProv.close();
                bw.close();
            }
            rsComu.close();

        } catch (SQLException ex) {
            Logger.getLogger(Catastro_BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Catastro_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}//class
