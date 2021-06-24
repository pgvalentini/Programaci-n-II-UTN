/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import SQL.SQL_Alumno;
import SQL.SQL_Cursado;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Pablo Valentini
 */
public class Alumno {
    private int dni;
    private String nombre;
    private String apellido;
    private Date fechaNac;
    private String domicilio;
    private String telefono;
    private ArrayList<Cursado> cursado = new ArrayList<Cursado>();
    private Inscripciones inscripciones = new Inscripciones();
    private SQL_Alumno sqlAlumno = new SQL_Alumno(); 
    private SQL_Cursado sqlCursado = new SQL_Cursado(); 

    
    
    public Alumno() {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Cursado> getCursado() {
        return cursado=sqlCursado.leer();
    }

    public void setCursado(ArrayList<Cursado> cursado) {
        this.cursado = cursado;
    }

    public Inscripciones getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Inscripciones inscripciones) {
        this.inscripciones = inscripciones;
    }

    //Crear
    public boolean crearAlumno(Alumno alumno){
        return sqlAlumno.crear(alumno);
    }
    
//    //Leer
//    public ArrayList<Alumno> leerAlumno(){
//        return sqlAlumno.leer();
//    }
    
    //Actualizar
    public boolean actualizarAlumno(Alumno alumno){
        return sqlAlumno.actualizar(alumno);
    }
       
    //Eliminar
    public boolean eliminarAlumno(int idAlumno){
        return sqlAlumno.eliminar(idAlumno);
    }
    
    //LlenarCombo
    public ArrayList<Integer> llenarCombo() {
        return sqlAlumno.llenarCombo();
    } 


    
}
