/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recup_noviembre;

import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Persona {
    String nombre;
    String apellido;
    Foto foto;
    ArrayList<MedioDeComunicacion> comunicaciones;
    ArrayList<Perfil> perfiles = new  ArrayList<Perfil>();
}
