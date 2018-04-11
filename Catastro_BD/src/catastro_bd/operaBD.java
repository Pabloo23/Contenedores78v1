package catastro_bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo
 */
public class operaBD {
    
    int filas;
    ResultSet dato;
    String url,usuario,pass,driver;
    String sql;

    public operaBD(String url, String usuario, String pass, String driver) {
   
        this.url = url;
        this.usuario = usuario;
        this.pass = pass;
        this.driver = driver;
    }

    public operaBD(String url, String usuario, String pass, String driver, String sql) {
        this(url,usuario,pass,driver);
        this.sql = sql;
    }
    
     Connection conectaOracle() {

        /*String cadenaConexion
                = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "catastro";
        String contraseña = "catastro";*/
        Connection conn = null;
        try {
            //1.- Cargar el driver JDBC....
            /*DriverManager.registerDriver(
                    new oracle.jdbc.driver.OracleDriver());*/
            Class.forName(driver);

            //2.- Obtener la conexión.....
            conn = DriverManager.getConnection(url, usuario, pass);

            //return conn;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error-> No escuentra el driver oracle " + ex);
        } catch (SQLException ex) {
            System.out.println("Error Sql-> " + ex);
        }

        return conn;

    }//conectaOracle
    void  lanzaSql(String sql, Connection conn) {
        ResultSet resultSet = null;

        try {
            Statement stmt = conn.createStatement();
            
            if(sql.toUpperCase().startsWith("SELECT"))
            
            dato = stmt.executeQuery(sql);
            
            else{
            filas = stmt.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(operaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

