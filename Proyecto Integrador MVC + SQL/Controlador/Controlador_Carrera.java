/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Carrera;
import Vista.Vista_Carrera;
import Vista.Lista_Carrera;
import Vista.Menu;
import Utilidades.Validaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo Valentini
 */
public class Controlador_Carrera implements ActionListener {

    private Carrera carrera = new Carrera();
    private Vista_Carrera vistaCarrera = new Vista_Carrera();
    private Lista_Carrera listaCarrera;
    private Menu menu;
    private DefaultTableModel modelo;

    public Controlador_Carrera(Lista_Carrera listaCarrera, Menu menu) {
        this.listaCarrera = listaCarrera;
        this.menu = menu;

        this.listaCarrera.getjBNuevo().addActionListener(this);
        this.listaCarrera.getjBEditar().addActionListener(this);
        this.listaCarrera.getjBEliminar().addActionListener(this);

        this.vistaCarrera.getjBguardar().addActionListener(this);
        this.vistaCarrera.getjBcancelar().addActionListener(this);
        this.vistaCarrera.getjBeditar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listaCarrera.getjBNuevo()) {
            vistaCarrera.setVisible(true);
            vistaCarrera.getjBguardar().setVisible(true);
            vistaCarrera.getjBeditar().setVisible(false);
            this.vistaCarrera.getjTCodigo().setEditable(true);
            this.vistaCarrera.getjLtituloCarrera().setText("Agregar carrera");
        } else if (e.getSource() == vistaCarrera.getjBguardar()) {
            agregar();
        } else if (e.getSource() == listaCarrera.getjBEditar()) {
            cargarVistaEditar();
        } else if (e.getSource() == vistaCarrera.getjBeditar()) {
            editar();
        } else if (e.getSource() == listaCarrera.getjBEliminar()) {
            eliminar();
        } else if (e.getSource() == vistaCarrera.getjBcancelar()) {
            vistaCarrera.dispose();
        } 

    }

    public void listarCarrera(JTable table) {
        modelo = (DefaultTableModel) listaCarrera.getjTCarreras().getModel();
        listaCarrera.getjTCarreras().setRowHeight(25);
        ArrayList<Carrera> lista = carrera.leerCarrera();
        Object[] columna = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            columna[0] = lista.get(i).getCodigo();
            columna[1] = lista.get(i).getNombre();
            columna[2] = lista.get(i).getDuracion();

            modelo.addRow(columna);
        }
        listaCarrera.getjTCarreras().setModel(modelo);
    }

    public void eliminar() {
        int fila = listaCarrera.getjTCarreras().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila!");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Esto tambien eliminará inscripcion de los alumnos, los alumnos y las notas de las materias cursadas!", "Esta seguro que desea eliminar la Carrera?", JOptionPane.YES_NO_OPTION) == 0) {
            int id = Integer.parseInt((String) listaCarrera.getjTCarreras().getValueAt(fila, 0).toString());
            carrera.eliminarCarrera(id);
            limpiarTabla();
            listarCarrera(listaCarrera.getjTCarreras());
            JOptionPane.showMessageDialog(null, "Eliminado!");    
            } 
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < listaCarrera.getjTCarreras().getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void cargarVistaEditar() {
        vistaCarrera.getjBguardar().setVisible(false);
        vistaCarrera.getjBeditar().setVisible(true);
        this.vistaCarrera.getjLtituloCarrera().setText("Editar carrera");
        int fila = listaCarrera.getjTCarreras().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila!");
        } else {
            this.vistaCarrera.getjTCodigo().setEditable(false);
            vistaCarrera.getjTCodigo().setText(listaCarrera.getjTCarreras().getValueAt(fila, 0).toString());
            vistaCarrera.getjTNombre().setText(listaCarrera.getjTCarreras().getValueAt(fila, 1).toString());
            vistaCarrera.getjTDuracion().setText(listaCarrera.getjTCarreras().getValueAt(fila, 2).toString());
            vistaCarrera.setVisible(true);
        }
    }

    public void agregar() {
        
        if (Validaciones.soloNumeros(vistaCarrera.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "Solo se permiten números, revise código!");
        } else if (Validaciones.menosDe(12, vistaCarrera.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "El código debe contener menos de 12 dígitos!");
        } else { 
            carrera.setCodigo(Integer.valueOf(vistaCarrera.getjTCodigo().getText()));
            carrera.setNombre(vistaCarrera.getjTNombre().getText());
            carrera.setDuracion(vistaCarrera.getjTDuracion().getText());

            if (carrera.crearCarrera(carrera) == true) {
                limpiarTabla();
                listarCarrera(listaCarrera.getjTCarreras());
                JOptionPane.showMessageDialog(null, "Guardado con éxito!");
                vistaCarrera.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error, revisar consola...");
            }
        }
    }

    public void editar() {
        if (Validaciones.soloNumeros(vistaCarrera.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "Solo se permiten números, revise código!");
        } else if (Validaciones.menosDe(12, vistaCarrera.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "El código debe contener menos de 12 dígitos!");
        } else { 
        
            carrera.setCodigo(Integer.valueOf(vistaCarrera.getjTCodigo().getText()));
            carrera.setNombre(vistaCarrera.getjTNombre().getText());
            carrera.setDuracion(vistaCarrera.getjTDuracion().getText());

            if (carrera.actualizarCarrera(carrera) == true) {
                limpiarTabla();
                listarCarrera(listaCarrera.getjTCarreras());
                JOptionPane.showMessageDialog(null, "Guardado con éxito!");
                vistaCarrera.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error, revisar consola...");
            }
        }
    }

}
