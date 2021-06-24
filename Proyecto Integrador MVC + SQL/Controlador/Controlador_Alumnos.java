/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Vista.Vista_Alumno;
import Vista.Lista_Alumnos;
import Vista.Menu;
import Utilidades.Validaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo Valentini
 */
public class Controlador_Alumnos implements ActionListener {

// Se crean atributos: Son los objetos de las clases de modelo y vista (No tiene objetos de SQL)
// Los objetos del Modelo son:
    private Alumno alumno = new Alumno();
    
// Los objetos de la Vista son:    
    private Lista_Alumnos listaAlumno;
    private Vista_Alumno vistaAlumno = new Vista_Alumno();
    private Menu menu;

//Este objeto es para crear una tabla
    private DefaultTableModel modelo;

// Constructor - escucha de los botones
    public Controlador_Alumnos(Lista_Alumnos listaAlumno, Menu menu) {
        this.listaAlumno = listaAlumno;
        this.menu = menu;

        this.listaAlumno.getjBNuevo().addActionListener(this);
        this.listaAlumno.getjBEditar().addActionListener(this);
        this.listaAlumno.getjBEliminar().addActionListener(this);
        
        this.vistaAlumno.getjBagregar().addActionListener(this);
        this.vistaAlumno.getjBeditar().addActionListener(this);
        this.vistaAlumno.getjBcancelar().addActionListener(this);

    }

// Métodos    
// Metodo que viene implementado de ActionListener, evento que se produce al hacer click en un componente o al pulsar Enter
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == listaAlumno.getjBNuevo()) {
            nuevo();
        } else if (e.getSource() == vistaAlumno.getjBagregar()) {
            agregar();
        } else if (e.getSource() == listaAlumno.getjBEditar()) {
            cargarVistaEditar();
        } else if (e.getSource() == vistaAlumno.getjBeditar()){
            editar();
        } else if (e.getSource() == vistaAlumno.getjBcancelar()) {
            vistaAlumno.dispose();
            vistaAlumno.getjCcodInsc().removeAllItems();
        } else if (e.getSource() == listaAlumno.getjBEliminar()) {
            eliminar();
        }
    }

// Métodos que apoyan al actionPerformed
// Llenar combo
    public void nuevo() {
        vistaAlumno.setVisible(true);
        vistaAlumno.getjBagregar().setVisible(true);
        vistaAlumno.getjBeditar().setVisible(false);
        this.vistaAlumno.getjLtituloAlumno().setText("Agregar alumno");
        this.vistaAlumno.getjTDNI().setEditable(true);
           
        for (int i = 0; i < alumno.llenarCombo().size(); i++) {
            vistaAlumno.getjCcodInsc().addItem(alumno.llenarCombo().get(i));
        }
    }
    
// Carga de un nuevo alumno
    public void agregar() {
        
        if (Validaciones.cantDig(8, vistaAlumno.getjTDNI().getText())==false) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener 8 dígitos!");
        } else if (Validaciones.menosDe(12,vistaAlumno.getjTTelefono().getText())==false){
            JOptionPane.showMessageDialog(null, "Solo se permiten hasta 11 dígitos, revise teléfono!");
        } else { 
            
            alumno.setDni(Integer.valueOf(vistaAlumno.getjTDNI().getText()));
            alumno.setNombre(vistaAlumno.getjTNombre().getText());
            alumno.setApellido(vistaAlumno.getjTApellido().getText());
            alumno.setFechaNac(Date.valueOf(vistaAlumno.getjDfecNac().getText()));
            alumno.setDomicilio(vistaAlumno.getjTDomicilio().getText());
            alumno.setTelefono(vistaAlumno.getjTTelefono().getText());
            alumno.getInscripciones().setCodigo((int) vistaAlumno.getjCcodInsc().getSelectedItem());

            if (alumno.crearAlumno(alumno) == true) {
                limpiarTabla();
                listarAlumnos(listaAlumno.getjTAlumnos());
                JOptionPane.showMessageDialog(null, "Guardado con éxito!");
                vistaAlumno.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error, revisar consola...");
            }
        }
    }

//Se edita un alumno 
    public void editar() {
        if (Validaciones.soloNumeros(vistaAlumno.getjTDNI().getText())==false) {
            JOptionPane.showMessageDialog(null, "Solo se permiten números, revise DNI!");
        } else if (Validaciones.cantDig(8, vistaAlumno.getjTDNI().getText())==false) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener 8 dígitos!");
        } else if (Validaciones.soloNumeros(vistaAlumno.getjTTelefono().getText())==false){
            JOptionPane.showMessageDialog(null, "Solo se permiten números, revise teléfono!");
        } else if (Validaciones.menosDe(12,vistaAlumno.getjTTelefono().getText())==false){
            JOptionPane.showMessageDialog(null, "Solo se permiten hasta 11 dígitos, revise teléfono!");
        } else { 
            
            alumno.setDni(Integer.valueOf(vistaAlumno.getjTDNI().getText()));
            alumno.setNombre(vistaAlumno.getjTNombre().getText());
            alumno.setApellido(vistaAlumno.getjTApellido().getText());
            alumno.setFechaNac(Date.valueOf(vistaAlumno.getjDfecNac().getText()));
            alumno.setDomicilio(vistaAlumno.getjTDomicilio().getText());
            alumno.setTelefono(vistaAlumno.getjTTelefono().getText());
            alumno.getInscripciones().setCodigo((int) vistaAlumno.getjCcodInsc().getSelectedItem());

            if (alumno.actualizarAlumno(alumno) == true) {
                limpiarTabla();
                listarAlumnos(listaAlumno.getjTAlumnos());
                JOptionPane.showMessageDialog(null, "Guardado con éxito!");
                vistaAlumno.getjCcodInsc().removeAllItems();
                vistaAlumno.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error, revisar consola...");
            }
        }
    }

//Sirve para settiar los datos del alumno y poder editarlo    
    public void cargarVistaEditar() {
        this.vistaAlumno.getjLtituloAlumno().setText("Editar alumno");
        vistaAlumno.getjBeditar().setVisible(true);
        vistaAlumno.getjBagregar().setVisible(false);
        
        int fila = listaAlumno.getjTAlumnos().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila!");
        } else {
            this.vistaAlumno.getjTDNI().setEditable(false);
            vistaAlumno.getjTDNI().setText(listaAlumno.getjTAlumnos().getValueAt(fila, 0).toString());
            vistaAlumno.getjTNombre().setText(listaAlumno.getjTAlumnos().getValueAt(fila, 1).toString());
            vistaAlumno.getjTApellido().setText(listaAlumno.getjTAlumnos().getValueAt(fila, 2).toString());
            vistaAlumno.getjDfecNac().setText(listaAlumno.getjTAlumnos().getValueAt(fila, 3).toString());
            vistaAlumno.getjTDomicilio().setText(listaAlumno.getjTAlumnos().getValueAt(fila, 4).toString());
            vistaAlumno.getjTTelefono().setText(listaAlumno.getjTAlumnos().getValueAt(fila, 5).toString());
            vistaAlumno.getjCcodInsc().addItem(Integer.valueOf(listaAlumno.getjTAlumnos().getValueAt(fila, 6).toString()));
            vistaAlumno.setVisible(true);
        }
    }

//Eliminar un alumno 
    public void eliminar() {
        int fila = listaAlumno.getjTAlumnos().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila!");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Esto tambien eliminará las notas de las materias cursadas!", "Esta seguro que desea eliminar al alumno?", JOptionPane.YES_NO_OPTION) == 0) {
            int id = Integer.parseInt((String) listaAlumno.getjTAlumnos().getValueAt(fila, 0).toString());
            alumno.eliminarAlumno(id);
            limpiarTabla();
            listarAlumnos(listaAlumno.getjTAlumnos());
            JOptionPane.showMessageDialog(null, "Eliminado!");
            }
        }

    }

//Listar la tabla y limpiarla 
    public void listarAlumnos(JTable table) {
        
//Creamos 2 objetos Lista (Base de datos) y Arreglo (sirve para cargar el modelo)   
        ArrayList<Alumno> lista = alumno.getInscripciones().getAlumno();
        Object[] columna = new Object[7];

//Tabla Modelo (le asignamos la lista a mostrar),    
        modelo = (DefaultTableModel) listaAlumno.getjTAlumnos().getModel();
        listaAlumno.getjTAlumnos().setRowHeight(25);

//Recorremos todo con un for para ir cargando la Tabla Modelo     
        for (int i = 0; i < lista.size(); i++) {
            columna[0] = lista.get(i).getDni();
            columna[1] = lista.get(i).getNombre();
            columna[2] = lista.get(i).getApellido();
            columna[3] = lista.get(i).getFechaNac();
            columna[4] = lista.get(i).getDomicilio();
            columna[5] = lista.get(i).getTelefono();
            columna[6] = lista.get(i).getInscripciones().getCodigo();
            modelo.addRow(columna);
        }
        listaAlumno.getjTAlumnos().setModel(modelo);
    }

// Limpiamos la tabla para futura muestra de datos
    public void limpiarTabla() {
        for (int i = 0; i < listaAlumno.getjTAlumnos().getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

}
