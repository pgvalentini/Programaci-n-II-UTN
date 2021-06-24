/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import SQL.SQL_Alumno;
import SQL.SQL_Inscripcion;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Pablo Valentini
 */
public class Inscripciones {
    private int codigo;
    private String nombre;
    private Date fecha;
    private Carrera carrera = new Carrera();
    private ArrayList<Alumno> alumno = new ArrayList<>();
    private SQL_Alumno sqlAlumno = new SQL_Alumno();
    private SQL_Inscripcion sqlInscripciones = new SQL_Inscripcion();
    

    public Inscripciones() {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    public ArrayList<Alumno> getAlumno() {
        return alumno=sqlAlumno.leer();
    }

    public void setAlumno(ArrayList<Alumno> alumno) {
        this.alumno = alumno;
    }
        
    //Crear
    public boolean crearInscripcion(Inscripciones inscripcion) {
        return sqlInscripciones.crear(inscripcion);
    }

//    //Leer
//    public ArrayList<Inscripciones> leerInscripciones() {
//        return sqlInscripciones.leer();
//    }
    
    //Actualizar
      public boolean actualizarInscripcion(Inscripciones inscripcion) {
        return sqlInscripciones.actualizar(inscripcion);
    }
      
    //Eliminar
     public boolean eliminarInscripcion(int idInscripcion) {
        return sqlInscripciones.eliminar(idInscripcion);
    }
     
    
    //LlenarCombo
    public ArrayList<Integer> llenarCombo() {
        return sqlInscripciones.llenarCombo();
    } 



}
