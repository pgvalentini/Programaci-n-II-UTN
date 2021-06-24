/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import SQL.SQL_Materia;
import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Materia {
    private String nombre;
    private int codigo;
    private ArrayList<Cursado> cursado = new ArrayList<Cursado>();
    private Profesor profesor = new Profesor();
    private SQL_Materia sqlMateria = new SQL_Materia();

    public Materia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Cursado> getCursado() {
        return cursado;
    }

    public void setCursado(ArrayList<Cursado> cursado) {
        this.cursado = cursado;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    //Crear
    public boolean crearMateria(Materia materia) {
        return sqlMateria.crear(materia);
    }

//    //Leer
//    public ArrayList<Materia> leerMateria() {
//        return sqlMateria.leer();
//    }
    
    //Actualizaar
      public boolean actualizarMateria (Materia materia) {
        return sqlMateria.actualizar(materia);
    }
      
     
     //Eliminar
     public boolean eliminarMateria(int idMateria) {
        return sqlMateria.eliminar(idMateria);
    }
    
    //Llenar combo
     public ArrayList<Integer> llenarCombo() {
        return sqlMateria.llenarCombo();
    }

    
}
