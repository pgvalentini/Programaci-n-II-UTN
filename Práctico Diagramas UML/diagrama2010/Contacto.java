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
public class Contacto extends Persona {
    private Integer idContacto;
    private ContactoTipo ct;
    private ArrayList <ContactoDomicilio> domicilios;
    private ArrayList <ContactoTelefono> telefonos;

    public Contacto(Integer idContacto, ContactoTipo ct,  String nombre, String apellido, Integer idPersona) {
        super(nombre, apellido, idPersona);
        this.idContacto = idContacto;
        this.ct = ct;
    }



    public Integer getIdContacto() {
        return idContacto;
    }

    public ContactoTipo getCt() {
        return ct;
    }

    public void setCt(ContactoTipo ct) {
        this.ct = ct;
    }

    public ArrayList <ContactoDomicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(ArrayList <ContactoDomicilio> domicilios) {
        this.domicilios = domicilios;
    }

    public ArrayList <ContactoTelefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList <ContactoTelefono> telefonos) {
        this.telefonos = telefonos;
    }
    
}
