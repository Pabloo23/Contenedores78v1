/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catastro_bd;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
        menu();
    }//main

    /*-------------------------------------------*/
    static void menu() {
        int op;

        do {
            op = ES.leeN("---------------MENU---------------" + "\n"
                    + "Listar Provincias de una comunidad \n"
                    + "Pulsa 2 Añadir un nuevo municipio \n"
                    + "Pulsa 3 Cambiar Municipio de Provincia\n"
                    + "Pulsa 4 Listado nº de Provincias y Municipios por Comunidad\n"
                    + "Pulsa 5 Guardar cada comunidad con sus provincias y pueblos\n"
                    + "en un fichero de texto: Comunidad.txt"
                    + "Pulsa 6 Obtener (Provincias y Comunidad) a partir de una poblacion \n"
                    + "Pulsa 7 Para salir \n");
            switch (op) {
                case 1:
                    String dato = ES.leeDeTeclado("Abcomu");
                    listaTabla("PROVINCIAS", "COMUNIDAD", dato);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;

            }//switch
        } while (op < 7);

    }//menu

    //----------------------------------------------
    static Connection conectaOracle() {

        String cadenaConexion
                = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "catastro";
        String contraseña = "catastro";
        Connection conn = null;
        try {
            //1.- Cargar el driver JDBC....
            /*DriverManager.registerDriver(
                    new oracle.jdbc.driver.OracleDriver());*/
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //2.- Obtener la conexión.....
            conn = DriverManager.getConnection(cadenaConexion, usuario, contraseña);

            //return conn;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error-> No escuentra el driver oracle " + ex);
        } catch (SQLException ex) {
            System.out.println("Error Sql-> " + ex);
        }

        return conn;

    }//conectaOracle
    //----------------------------------

    static void cargaTabla(String tabla, String fichero) {

        FileReader fr = null;
        Connection conn = null;
        Scanner scl = null, sc = null;
        String linea = "", codigo, nombre, insert = "";
        try {
            conn = conectaOracle();
            Statement sentencia = conn.createStatement();
            // Procesamos el fichero..............
            fr = new FileReader(ruta + fichero);
            sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                scl = new Scanner(linea);
                scl.useDelimiter(",");
                //while(scl.hasNext())
                nombre = scl.next();
                codigo = scl.next();

                insert = "insert into " + tabla + " values "
                        + "('" + nombre + "','" + codigo + "')";

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

    /*------------------------------------*/
    //----------------------------------
    static void cargaTabla2(String tabla, String fichero) {

        FileReader fr = null;
        Connection conn = null;
        Scanner scl = null, sc = null;
        String linea = "", codigo, nombre, insert = "";
        String campo = "";
        ArrayList<String> types = new ArrayList();
        ResultSet rset;
        try {
            conn = conectaOracle();
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

    //-----------------------------------------------
    static void listaTabla(String tabla) {

        Connection conn = null;
        ResultSet rset;

        try {
            conn = conectaOracle();
            Statement sentencia = conn.createStatement();

            rset = sentencia.executeQuery("select * from " + tabla);

            while (rset.next()) {

                System.out.println(rset.getString(1) + " -> " + rset.getString(2));

            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error -> Conexión fallida" + ex);
        }

    }

    //-------------------------------------------------
    static void listaTabla(String tabla, String columna, String dato) {

        Connection conn = null;
        ResultSet rset;

        try {
            conn = conectaOracle();
            Statement sentencia = conn.createStatement();

            rset = sentencia.executeQuery("select * from " + tabla
                    + " where " + columna + "='" + dato + "'");

            while (rset.next()) {
                int i = 1;
                while (i <= rset.getMetaData().getColumnCount()) {

                    System.out.print(rset.getString(i) + " ");
                    i++;

                }
                // System.out.println(rset.getString(1)+" -> "+rset.getString(2));
                System.out.println("");

            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error -> Conexión fallida" + ex);
        }

    }

    static void altaMunicipio(String tabla1, String tabla2) {

    }

}//class
