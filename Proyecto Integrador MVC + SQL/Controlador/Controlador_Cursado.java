/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cursado;
import Vista.Vista_Cursado;
import Vista.Lista_Cursado;
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
public class Controlador_Cursado implements ActionListener {

    private Cursado cursado = new Cursado();
    private Vista_Cursado vistaCursado = new Vista_Cursado();
    private Lista_Cursado listaCursado;
    private Menu menu;
    private DefaultTableModel modelo;

    public Controlador_Cursado(Lista_Cursado listaCursado, Menu menu) {
        this.listaCursado = listaCursado;
        this.menu = menu;

        this.listaCursado.getjBNuevo().addActionListener(this);
        this.listaCursado.getjBEditar().addActionListener(this);
        this.listaCursado.getjBEliminar().addActionListener(this);

        this.vistaCursado.getjBGuardar().addActionListener(this);
        this.vistaCursado.getjBCancelar().addActionListener(this);
        this.vistaCursado.getjBeditar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listaCursado.getjBNuevo()) {
            nuevo();
        } else if (e.getSource() == listaCursado.getjBEliminar()) {
            eliminar();
        } else if (e.getSource() == listaCursado.getjBEditar()) {
            cargarVistaEditar();
        } else if (e.getSource() == vistaCursado.getjBGuardar()) {
            agregar();
        } else if (e.getSource() == vistaCursado.getjBeditar()) {
            editar();
        } else if (e.getSource() == vistaCursado.getjBCancelar()) {
            vistaCursado.getjCcodigoMat().removeAllItems();
            vistaCursado.getjCdni().removeAllItems();
            vistaCursado.dispose();
        }

    }

    // Llenar combos
    public void nuevo() {
       vistaCursado.setVisible(true);
       vistaCursado.getjBGuardar().setVisible(true);
       vistaCursado.getjBeditar().setVisible(false);
       this.vistaCursado.getjLtituloCursado().setText("Agregar cursado");
       this.vistaCursado.getjCcodigoMat().setEditable(true);
       this.vistaCursado.getjCdni().setEditable(true);
           
        for (int i = 0; i < cursado.llenarComboDni().size(); i++) {
            this.vistaCursado.getjCdni().addItem(cursado.llenarComboDni().get(i));
        }
   
        for (int i = 0; i < cursado.llenarComboMateria().size(); i++) {
            this.vistaCursado.getjCcodigoMat().addItem(cursado.llenarComboMateria().get(i));
        }
    }

    public void listarCursado(JTable table) {
        
        modelo = (DefaultTableModel) listaCursado.getjTCursado().getModel();
        listaCursado.getjTCursado().setRowHeight(25);
        
        ArrayList<Cursado> lista = cursado.getAlumno().getCursado();
        Object[] columna = new Object[3];
        
        for (int i = 0; i < lista.size(); i++) {
            columna[0] = lista.get(i).getAlumno().getDni();
            columna[1] = lista.get(i).getMateria().getCodigo();
            columna[2] = lista.get(i).getNota();
            modelo.addRow(columna);
        }
        listaCursado.getjTCursado().setModel(modelo);
    }

    public void eliminar() {
        int fila = listaCursado.getjTCursado().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila!");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Se eliminará la nota asignada al alumno!", "Esta seguro que desea eliminar el cursado?", JOptionPane.YES_NO_OPTION) == 0) {
            int id = Integer.parseInt((String) listaCursado.getjTCursado().getValueAt(fila, 0).toString());
            cursado.eliminarCursado(id);
            limpiarTabla();
            listarCursado(listaCursado.getjTCursado());
            JOptionPane.showMessageDialog(null, "Eliminado!");
            }
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < listaCursado.getjTCursado().getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void cargarVistaEditar() {
        vistaCursado.getjBGuardar().setVisible(false);
        vistaCursado.getjBeditar().setVisible(true);
        this.vistaCursado.getjLtituloCursado().setText("Editar cursado");
        int fila = listaCursado.getjTCursado().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila!");
        } else {
            this.vistaCursado.getjCcodigoMat().setEditable(false);
            this.vistaCursado.getjCdni().setEditable(false);
            vistaCursado.getjCcodigoMat().addItem(Integer.valueOf(listaCursado.getjTCursado().getValueAt(fila, 0).toString()));
            vistaCursado.getjCdni().addItem(Integer.valueOf(listaCursado.getjTCursado().getValueAt(fila, 1).toString()));
            vistaCursado.getjTNota().setText(listaCursado.getjTCursado().getValueAt(fila, 2).toString());
            vistaCursado.setVisible(true);
        }

    }

    public void agregar() {
        if (Validaciones.numeroDoubleEntre(0.0,10.0, vistaCursado.getjTNota().getText())==false) {
            JOptionPane.showMessageDialog(null, "La nota debe contener estar entre 0.0 y 10.0!");
        } else {
            
            cursado.getAlumno().setDni((int) vistaCursado.getjCdni().getSelectedItem());
            cursado.getMateria().setCodigo((int) vistaCursado.getjCcodigoMat().getSelectedItem());
            cursado.setNota((double) Double.valueOf(vistaCursado.getjTNota().getText()));

            if (cursado.crearCursado(cursado) == true) {
                limpiarTabla();
                listarCursado(listaCursado.getjTCursado());
                JOptionPane.showMessageDialog(null, "Guardado con éxito!");
                vistaCursado.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error, revisar consola...");
            }
        }
    }

    public void editar() {
        if (Validaciones.numeroDoubleEntre(0.0,10.0, vistaCursado.getjTNota().getText())==false) {
            JOptionPane.showMessageDialog(null, "La nota debe contener estar entre 0.0 y 10.0!");
        } else {
            cursado.getAlumno().setDni((int) vistaCursado.getjCdni().getSelectedItem());
            cursado.getMateria().setCodigo((int) vistaCursado.getjCcodigoMat().getSelectedItem());
            cursado.setNota((double) Double.valueOf(vistaCursado.getjTNota().getText()));

            if (cursado.actualizarCursado(cursado) == true) {
                limpiarTabla();
                listarCursado(listaCursado.getjTCursado());
                JOptionPane.showMessageDialog(null, "Guardado con éxito!");
                vistaCursado.getjCcodigoMat().removeAllItems();
                vistaCursado.getjCdni().removeAllItems();
                vistaCursado.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error, revisar consola...");
            }
        }
    }

}
