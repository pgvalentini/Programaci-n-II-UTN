/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama2010;

/**
 *
 * @author Pablo Valentini
 */
public class ContactoTipo {
    private Integer idContactoTipo;
    private String descripcion;

    public ContactoTipo(Integer idContactoTipo, String descripcion) {
        this.idContactoTipo = idContactoTipo;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdContactoTipo() {
        return idContactoTipo;
    }

    
}
