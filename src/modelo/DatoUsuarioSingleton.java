/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.CallableStatement;
import dao.ConexionSingleton;
import entidades.UsuarioSingleton;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author ronny
 */
public class DatoUsuarioSingleton {
    
    private DatoUsuarioSingleton() {
    
    }
    
    ConexionSingleton conexion = ConexionSingleton.getInstance();
    UsuarioSingleton usuario = UsuarioSingleton.getUsuarioSingleton();
    
    private static DatoUsuarioSingleton datoUsuarioSingleton = null;
    
    public void consulta() throws SQLException{
        try{
            CallableStatement stmt = null;       
            String sql = "select id, usuario, nombres, estado from usuarios";
            stmt = conexion.getConexion().prepareCall(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                this.usuario.setId(rs.getInt("id"));
                this.usuario.setUsuario(rs.getString("usuario"));
                this.usuario.setNombres(rs.getString("nombres"));
                this.usuario.setEstado(rs.getString("estado"));
            }
            rs.close();  
            stmt.close();
        } catch(Exception error){
            System.out.println("Error al consultar registro en BD: " + error);
        }
    }
    
    public void actualiza() throws SQLException{
        try{
            CallableStatement stmt = null;       
            String sql = "update usuarios set estado = ? where id= ?";
            stmt = conexion.getConexion().prepareCall(sql);
            stmt.setString(1, this.usuario.getEstado());
            stmt.setInt(2, this.usuario.getId());
            stmt.executeUpdate(); 
            stmt.close();
        } catch(Exception error){
            System.out.println("Error al actualizar registro en la BD: " + error);
        }
    }
    
    public static DatoUsuarioSingleton getDatoUsuarioSingleton() {
        if (datoUsuarioSingleton == null) {
            datoUsuarioSingleton = new DatoUsuarioSingleton();
        }
        return datoUsuarioSingleton;
    }
    
    @Override
    public String toString() {
        return "ID => " + this.usuario.getId() + ",    USUARIO => " + this.usuario.getUsuario() + ",    NOMBRE => " + this.usuario.getNombres() + ",    ESTADO => " + this.usuario.getEstado();
    }
    
}
