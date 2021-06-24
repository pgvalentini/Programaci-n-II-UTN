/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import SQL.SQL_Carrera;
import SQL.SQL_Inscripcion;
import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Carrera {
    private int codigo;
    private String nombre;
    private String duracion;
    private ArrayList <Inscripciones> inscripciones = new ArrayList<>();
    private SQL_Inscripcion sqlInscripcion = new SQL_Inscripcion();
    private SQL_Carrera sqlCarrera = new SQL_Carrera();
    
    public Carrera() {
    }
    
    public ArrayList <Inscripciones> getInscripciones() {
        return inscripciones = sqlInscripcion.leer();
    }

    public void setInscripciones(ArrayList <Inscripciones> inscripciones) {
        this.inscripciones = inscripciones;
    }
     
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
    //Crear
    public boolean crearCarrera(Carrera carrera) {
        return sqlCarrera.crear(carrera);
    }
    
    //Leer
    public ArrayList<Carrera> leerCarrera() {
        return sqlCarrera.leer();
    }
    
    //Actualizaar
      public boolean actualizarCarrera (Carrera carrera) {
        return sqlCarrera.actualizar(carrera);
    }
      
    //Eliminar
     public boolean eliminarCarrera(int idCarrera) {
        return sqlCarrera.eliminar(idCarrera);
    }

    
}
