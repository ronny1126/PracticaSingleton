/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronny
 */
public class ConexionSingleton {
    
    private ConexionSingleton(){
        try {
            conexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Connection conexion = null;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    private static ConexionSingleton instance = null;
    
    public void conexion() throws SQLException{
        
        try{
            CargaArchivoSingleton config = CargaArchivoSingleton.getInstance();
            String url = config.getAtributos().getProperty("jdbc.url");
            String user = config.getAtributos().getProperty("jdbc.username");
            String password = config.getAtributos().getProperty("jdbc.password");
            //System.out.println("valor url: "+url);
            //System.out.println("valor user: "+user);
            //System.out.println("valor password: "+password);
            conexion = DriverManager.getConnection(url, user, password);
            //System.out.println("EXITOSO");
        }catch(IOException error){
            System.out.println("Error en la conexion a la BD: " + error);
        }
    }
   
    public static ConexionSingleton getInstance() {
        if (instance == null){
            instance = new ConexionSingleton();
        }
        return instance;
    }   
    
}
