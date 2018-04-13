/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catastro_bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils78.ES;

/**
 *
 * @author Usuario
 */
public class OperaBD {
    /**
    *
    * atributos para devolver el resultado de la operacion
    * @filas:.....
    */
    
    int                 filas     =-1;
    ResultSet           datos     =null;
    //ResultSetMetaData   metaDatos =null;    
    /**
    *
    * atributos para establecer la conexion a la BD
    * @url:.....
    */
    String url;
    String driver;
    String usuario;
    String contraseña;
    Connection conn=null;
    //....sql
    String sentenciaSql;

    public OperaBD(String url, String driver, String usuario, String contraseña) {
        this.url = url;
        this.driver = driver;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    //-----------------------------------------------------
    public OperaBD(String url, String driver, String usuario, String contraseña, String sentenciaSql) {
        this(url,driver,usuario,contraseña);
        this.sentenciaSql = sentenciaSql;
    }
   //----------------------------------------------------- 
    public ResultSet lanzaSql(String sql){
        //ResultSet rset = null;
        try {
            if(conn==null)
            conn=conectaOracle();
            
            Statement sentencia= conn.createStatement();
            
            //sql.toUpperCase().startsWith("SELECT");
              sql=sql.toUpperCase();
              
            if(sql.startsWith("SELECT")){
                datos=sentencia.executeQuery(sql);
                //metaDatos=datos.getMetaData();
            }
            else{
               filas=sentencia.executeUpdate(sql);
            }
            
           // conn.close();
        } catch (SQLException ex) {
            System.out.println("Error en lanzaSql: "+ex);
        }
        return datos;
    }
    //---------------------------------------------
    public void close(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error cerrando la conexion BD->"+ ex);
        }
    }
    //---------------------------------------------
    public Connection conectaOracle(){
        
   /* String cadenaConexion = 
            "jdbc:oracle:thin:@localhost:1521:XE";
    String usuario="catastro";
    String contraseña="catastro";*/
    Connection conn=null;
        try {
            //1.- Cargar el driver JDBC....
            /*DriverManager.registerDriver(
                    new oracle.jdbc.driver.OracleDriver());*/
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName(driver);
            
            //2.- Obtener la conexión.....
             conn =DriverManager.getConnection(url, usuario, contraseña);
             
            //return conn;
        }catch (ClassNotFoundException ex) {
              System.out.println("Error-> No escuentra el driver oracle "+ ex);
        }catch (SQLException ex) {
            System.out.println("Error Sql-> "+ ex);
        }
        
        return conn;
   
    }//conectaOracle 
    //---------------------------------
    public void listaSelect(){
        Connection conn =null;
        ResultSet rset;
            
        try {
            //System.out.println("select->"+ select);
            /*conn = conectaOracle();
            Statement sentencia= conn.createStatement();
            
            rset=sentencia.executeQuery(select);
            rset=resultadoConsulta(select);*/
            if(datos==null)
                System.out.println("no hay datos...que listar");
            else
            {    
                int numColum =datos.getMetaData().getColumnCount();
                while(datos.next()){
                    //System.out.println(rset.getString(1)+"->"+rset.getString(2));
                    for(int i=1;i<=numColum;i++){
                       System.out.print(datos.getString(i)+" "); 
                    }
                    System.out.println();
                }
            }
            //conn.close();
            
        } catch (SQLException ex) {
            System.out.println("Error-> conexión fallida"+ ex);
        }
    } 
    //----------------------------------------------------------
    public void insertaFila(String tabla){
        String campo,insert="insert into "+tabla+" values(";
        try {
            ArrayList<String> types=new ArrayList();
            ResultSet rset;
           
            lanzaSql("select * from user_tab_columns " +
                    "where table_name='"+tabla+"'");
            //rset=operaciones.datos;
            
            while (datos.next()){
                   campo=ES.leeDeTeclado(datos.getString("COLUMN_NAME"));
                   if( (datos.getString("data_type")).equalsIgnoreCase("VARCHAR2") )
                       insert+="'"+campo+"',";
                    else insert+=campo+",";
                        }
                insert= insert.substring(0, insert.length()-1);
                insert+=")";
                System.out.println("insert= "+insert);
                //sentencia.executeUpdate(insert);
                lanzaSql(insert);
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la tabla -> "+tabla+" ->"+ex );
        }
        
    }
    
    //---------------------------------
}
