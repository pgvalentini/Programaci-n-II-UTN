/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import SQL.SQL_Cursado;
import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Cursado {
    private Alumno alumno = new Alumno();
    private Materia materia = new Materia();
    private double nota;
    private SQL_Cursado sqlCursado = new SQL_Cursado();

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
       
    //Crear
    public boolean crearCursado(Cursado cursado) {
        return sqlCursado.crear(cursado);
    }

//    //Leer
//    public ArrayList<Cursado> leerCursado() {
//        return sqlCursado.leer();
//    }
    
    //Actualizaar
      public boolean actualizarCursado(Cursado cursado) {
        return sqlCursado.actualizar(cursado);
    }
      
    //Eliminar
     public boolean eliminarCursado(int idCursado) {
        return sqlCursado.eliminar(idCursado);
    }
     
    //LlenarComboDNI
    public ArrayList<Integer> llenarComboDni() {
        return sqlCursado.llenarComboDni();
    }  
    
    //LlenarComboMateria
    public ArrayList<Integer> llenarComboMateria() {
        return sqlCursado.llenarComboMateria();
    }  

}
