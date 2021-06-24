/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import SQL.SQL_Profesor;
import SQL.SQL_Materia;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Pablo Valentini
 */
public class Profesor {
    private int dni;
    private String nombre;
    private String apellido;
    private Date fechaNac;
    private String domicilio;
    private String telefono;
    private ArrayList<Materia> materia = new ArrayList<>();
    private SQL_Profesor sqlProfesor = new SQL_Profesor();
    private SQL_Materia sqlMateria = new SQL_Materia();

    public Profesor() {
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
    
    
    public ArrayList<Materia> getMateria() {
        return materia = sqlMateria.leer();
    }

    public void setMateria(ArrayList<Materia> materia) {
        this.materia = materia;
    }
    
    
    //Crear
    public boolean crearProfesor(Profesor profesor) {
        return sqlProfesor.crear(profesor);
    }

    //Leer
    public ArrayList<Profesor> leerProfesor() {
        return sqlProfesor.leer();
    }
       
    //Actualizaar
      public boolean actualizarProfesor (Profesor profesor) {
        return sqlProfesor.actualizar(profesor);
    }
      
    //Eliminar
     public boolean eliminarProfesor(int idProfesor) {
        return sqlProfesor.eliminar(idProfesor);
    }

    
}
