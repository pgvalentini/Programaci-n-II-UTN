/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama2010;

import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Usuario extends Persona{
    private Integer idUsuario;
    private String usuario;
    private String password;
    private ArrayList <Contacto> contactos;

    public Usuario(Integer idUsuario, String usuario, String password, String nombre, String apellido, Integer idPersona) {
        super(nombre, apellido, idPersona);
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

 
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ArrayList <Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList <Contacto> contactos) {
        this.contactos = contactos;
    }


    
}
