/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.IOException;

/**
 *
 * @author ronny
 */
public class UsuarioSingleton {
    
    private int id;
    private String usuario;
    private String nombres;
    private String estado;
    
    private static UsuarioSingleton usuarioSingleton = null;
    
    public static UsuarioSingleton getUsuarioSingleton() {
        if (usuarioSingleton == null) {
            usuarioSingleton = new UsuarioSingleton();
        }
        return usuarioSingleton;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }   
    
}
