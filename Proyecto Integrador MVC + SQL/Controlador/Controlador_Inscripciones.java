/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Inscripciones;
import Vista.Vista_Inscripciones;
import Vista.Lista_Inscripciones;
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
public class Controlador_Inscripciones implements ActionListener {

// Se crean atributos: Son los objetos de las clases de modelo y vista (No tiene objetos de SQL)
// Los objetos del Modelo son:
    private Inscripciones inscripcion = new Inscripciones();
    
// Los objetos de la Vista son:    
    private Lista_Inscripciones listaInscripcion;
    private Vista_Inscripciones vistaInscripcion = new Vista_Inscripciones();
    private Menu menu;

//Este objeto es para crear una tabla
    private DefaultTableModel modelo;

// Constructor - escucha de los botones
    public Controlador_Inscripciones(Lista_Inscripciones listaInscripcion, Menu menu) {
        this.listaInscripcion = listaInscripcion;
        this.menu = menu;

        this.listaInscripcion.getjBNuevo().addActionListener(this);
        this.listaInscripcion.getjBEditar().addActionListener(this);
        this.listaInscripcion.getjBEliminar().addActionListener(this);

        this.vistaInscripcion.getjBagregar().addActionListener(this);
        this.vistaInscripcion.getjBCancelar().addActionListener(this);
        this.vistaInscripcion.getjBeditar().addActionListener(this);
       
    }

// Métodos    
// Metodo que viene implementado de ActionListener, evento que se produce al hacer click en un componente o al pulsar Enter
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == listaInscripcion.getjBNuevo()) {
            nuevo();
        } else if (e.getSource() == vistaInscripcion.getjBagregar()) {
            agregar();
        } else if (e.getSource() == listaInscripcion.getjBEditar()) {
            cargarVistaEditar();
        } else if (e.getSource() == vistaInscripcion.getjBeditar()) {
            editar();
        } else if (e.getSource() == vistaInscripcion.getjBCancelar()) {
            vistaInscripcion.getjCcodCarrera().removeAllItems();
            vistaInscripcion.dispose();
        } else if (e.getSource() == listaInscripcion.getjBEliminar()) {
            eliminar();
        } 
    }

// Métodos que apoyan al actionPerformed
    public void nuevo() {
        vistaInscripcion.setVisible(true);
        vistaInscripcion.getjBagregar().setVisible(true);
        vistaInscripcion.getjBeditar().setVisible(false);
        this.vistaInscripcion.getjLtituloInscr().setText("Agregar inscripción");
        this.vistaInscripcion.getjTCodigo().setEditable(true);
         
        for (int i = 0; i < inscripcion.llenarCombo().size(); i++) {
            this.vistaInscripcion.getjCcodCarrera().addItem(inscripcion.llenarCombo().get(i));
        }
    }

// Carga de una nueva inscripción
    public void agregar() {
        if (Validaciones.soloNumeros(vistaInscripcion.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "Solo se permiten números, revise código!");
        } else if (Validaciones.menosDe(12, vistaInscripcion.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "El código debe contener menos de 12 dígitos!");
        } else {
            inscripcion.setCodigo(Integer.valueOf(vistaInscripcion.getjTCodigo().getText()));
            inscripcion.setNombre(vistaInscripcion.getjTNombre().getText());
            inscripcion.setFecha(Date.valueOf(vistaInscripcion.getJDfecInsc().getText()));
            inscripcion.getCarrera().setCodigo((int)vistaInscripcion.getjCcodCarrera().getSelectedItem());

            if (inscripcion.crearInscripcion(inscripcion) == true) {
                limpiarTabla();
                listarInscripciones(listaInscripcion.getjTInscripciones());
                JOptionPane.showMessageDialog(null, "Guardado con éxito!");
                vistaInscripcion.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error, revisar consola...");
        }
        }
    }

//Se edita la inscripción 
    public void editar() {
        if (Validaciones.soloNumeros(vistaInscripcion.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "Solo se permiten números, revise código!");
        } else if (Validaciones.menosDe(12, vistaInscripcion.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "El código debe contener menos de 12 dígitos!");
        } else {
        
            inscripcion.setCodigo(Integer.valueOf(vistaInscripcion.getjTCodigo().getText()));
            inscripcion.setNombre(vistaInscripcion.getjTNombre().getText());
            inscripcion.setFecha(Date.valueOf(vistaInscripcion.getJDfecInsc().getText()));
            inscripcion.getCarrera().setCodigo((int)vistaInscripcion.getjCcodCarrera().getSelectedItem());

            if (inscripcion.actualizarInscripcion(inscripcion) == true) {
                limpiarTabla();
                listarInscripciones(listaInscripcion.getjTInscripciones());
                JOptionPane.showMessageDialog(null, "Guardado con éxito!");
                vistaInscripcion.dispose();
            } else {
            JOptionPane.showMessageDialog(null, "Error, revisar consola...");
            }
        }
    }

//Sirve para settiar los datos de la inscripción y poder editarlo    
    public void cargarVistaEditar() {
        this.vistaInscripcion.getjLtituloInscr().setText("Editar inscripción");
        vistaInscripcion.getjBagregar().setVisible(false);
        vistaInscripcion.getjBeditar().setVisible(true);
        
        int fila = listaInscripcion.getjTInscripciones().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila!");
        } else {
            this.vistaInscripcion.getjTCodigo().setEditable(false);
            vistaInscripcion.getjTCodigo().setText(listaInscripcion.getjTInscripciones().getValueAt(fila, 0).toString());
            vistaInscripcion.getjTNombre().setText(listaInscripcion.getjTInscripciones().getValueAt(fila, 1).toString());
            vistaInscripcion.getJDfecInsc().setText(listaInscripcion.getjTInscripciones().getValueAt(fila, 2).toString());
            vistaInscripcion.getjCcodCarrera().addItem(Integer.valueOf(listaInscripcion.getjTInscripciones().getValueAt(fila, 3).toString()));
            vistaInscripcion.setVisible(true);
        }

    }

//Eliminar una inscripción 
    public void eliminar() {
        int fila = listaInscripcion.getjTInscripciones().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila!");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Esto tambien eliminará a los alumnos y las notas de las materias cursadas!", "Esta seguro que desea eliminar la inscripción?", JOptionPane.YES_NO_OPTION) == 0) {
            int id = Integer.parseInt((String) listaInscripcion.getjTInscripciones().getValueAt(fila, 0).toString());
            inscripcion.eliminarInscripcion(id);
            limpiarTabla();
            listarInscripciones(listaInscripcion.getjTInscripciones());
            JOptionPane.showMessageDialog(null, "Eliminado!");
            }
        }
    }

//Listar la tabla y limpiarla 
    public void listarInscripciones(JTable table) {

//Creamos 2 objetos Lista (Base de datos) y Arreglo (sirve para cargar el modelo)   
        ArrayList<Inscripciones> lista = inscripcion.getCarrera().getInscripciones();
        Object[] columna = new Object[4];

//Tabla Modelo (le asignamos la lista a mostrar),    
        modelo = (DefaultTableModel) listaInscripcion.getjTInscripciones().getModel();
        listaInscripcion.getjTInscripciones().setRowHeight(25);

//Recorremos todo con un for para ir cargando la Tabla Modelo     
        for (int i = 0; i < lista.size(); i++) {
            columna[0] = lista.get(i).getCodigo();
            columna[1] = lista.get(i).getNombre();
            columna[2] = lista.get(i).getFecha();
            columna[3] = lista.get(i).getCarrera().getCodigo();
            modelo.addRow(columna);
        }
        listaInscripcion.getjTInscripciones().setModel(modelo);
    }

// Limpiamos la tabla para futura muestra de datos
    public void limpiarTabla() {
        for (int i = 0; i < listaInscripcion.getjTInscripciones().getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

}
