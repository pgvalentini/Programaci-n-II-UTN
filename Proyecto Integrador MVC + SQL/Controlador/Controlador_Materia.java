/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Materia;
import Vista.Vista_Materias;
import Vista.Lista_Materias;
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
public class Controlador_Materia implements ActionListener {

    private Materia materia = new Materia();
    private Vista_Materias vistaMaterias = new Vista_Materias();
    private Lista_Materias listaMaterias;
    private Menu menu;
    private DefaultTableModel modelo;

    public Controlador_Materia(Lista_Materias listaMaterias, Menu menu) {
        this.listaMaterias = listaMaterias;
        this.menu = menu;

        this.listaMaterias.getjBNuevo().addActionListener(this);
        this.listaMaterias.getjBEditar().addActionListener(this);
        this.listaMaterias.getjBEliminar().addActionListener(this);

        this.vistaMaterias.getjBGuardar().addActionListener(this);
        this.vistaMaterias.getjBCancelar().addActionListener(this);
        this.vistaMaterias.getjBeditar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listaMaterias.getjBNuevo()) {
            nuevo();
        } else if (e.getSource() == vistaMaterias.getjBGuardar()) {
            agregar();
        } else if (e.getSource() == listaMaterias.getjBEditar()) {
            cargarVistaEditar();
        } else if (e.getSource() == vistaMaterias.getjBeditar()) {
            editar();
        } else if (e.getSource() == vistaMaterias.getjBCancelar()) {
            this.vistaMaterias.getjCdni().removeAllItems();
            vistaMaterias.dispose();
        } else if (e.getSource() == listaMaterias.getjBEliminar()) {
            eliminar();
        } 

    }

    public void nuevo() {
        vistaMaterias.setVisible(true);
        vistaMaterias.getjBGuardar().setVisible(true);
        vistaMaterias.getjBeditar().setVisible(false);
        this.vistaMaterias.getjLtituloMateria().setText("Agregar materia");
        this.vistaMaterias.getjTCodigo().setEditable(true);
            
        for (int i = 0; i < materia.llenarCombo().size(); i++) {
            this.vistaMaterias.getjCdni().addItem(materia.llenarCombo().get(i));
        }
    }
    
    public void agregar() {
        if (Validaciones.soloNumeros(vistaMaterias.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "Solo se permiten números, revise código!");
        } else if (Validaciones.menosDe(12, vistaMaterias.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "El código debe contener menos de 12 dígitos!");
        } else {
            materia.setCodigo(Integer.valueOf(vistaMaterias.getjTCodigo().getText()));
            materia.setNombre(vistaMaterias.getjTNombre().getText());
            materia.getProfesor().setDni((int) vistaMaterias.getjCdni().getSelectedItem());

            if (materia.crearMateria(materia) == true) {
                limpiarTabla();
                listarCarrera(listaMaterias.getjTMaterias());
                JOptionPane.showMessageDialog(null, "Guardado con éxito!");
                vistaMaterias.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error, revisar consola...");
            }
        }
    }
    
    public void editar() {
        if (Validaciones.soloNumeros(vistaMaterias.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "Solo se permiten números, revise código!");
        } else if (Validaciones.menosDe(12, vistaMaterias.getjTCodigo().getText())==false) {
            JOptionPane.showMessageDialog(null, "El código debe contener menos de 12 dígitos!");
        } else {
        
            materia.setCodigo(Integer.valueOf(vistaMaterias.getjTCodigo().getText()));
            materia.setNombre(vistaMaterias.getjTNombre().getText());
            materia.getProfesor().setDni((int) vistaMaterias.getjCdni().getSelectedItem());

            if (materia.actualizarMateria(materia) == true) {
                limpiarTabla();
                listarCarrera(listaMaterias.getjTMaterias());
                JOptionPane.showMessageDialog(null, "Guardado con éxito");
                vistaMaterias.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error, revisar consola...");
            }
        }
    }
    
    public void cargarVistaEditar() {
        this.vistaMaterias.getjLtituloMateria().setText("Editar materia");
        vistaMaterias.getjBGuardar().setVisible(false);
        vistaMaterias.getjBeditar().setVisible(true);
        
        int fila = listaMaterias.getjTMaterias().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila!");
        } else {
            this.vistaMaterias.getjTCodigo().setEditable(false);
            vistaMaterias.getjTCodigo().setText(listaMaterias.getjTMaterias().getValueAt(fila, 0).toString());
            vistaMaterias.getjTNombre().setText(listaMaterias.getjTMaterias().getValueAt(fila, 1).toString());
            vistaMaterias.getjCdni().addItem(Integer.valueOf(listaMaterias.getjTMaterias().getValueAt(fila, 2).toString()));
            vistaMaterias.setVisible(true);
        }

    }
  
    public void eliminar() {
        int fila = listaMaterias.getjTMaterias().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila!");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Esto tambien eliminará la materia y las notas de los alumnos de las materias cursadas!", "Esta seguro que desea eliminar la materia?", JOptionPane.YES_NO_OPTION) == 0) {
            int id = Integer.parseInt((String) listaMaterias.getjTMaterias().getValueAt(fila, 0).toString());
            materia.eliminarMateria(id);
            limpiarTabla();
            listarCarrera(listaMaterias.getjTMaterias());
            JOptionPane.showMessageDialog(null, "Eliminado!");
            }
        }
    }
    
     public void listarCarrera(JTable table) {
        
        ArrayList<Materia> lista = materia.getProfesor().getMateria();
        Object[] columna = new Object[3];
        
        modelo = (DefaultTableModel) listaMaterias.getjTMaterias().getModel();
        listaMaterias.getjTMaterias().setRowHeight(25);
        
        for (int i = 0; i < lista.size(); i++) {
            columna[0] = lista.get(i).getCodigo();
            columna[1] = lista.get(i).getNombre();
            columna[2] = lista.get(i).getProfesor().getDni();

            modelo.addRow(columna);
        }
        listaMaterias.getjTMaterias().setModel(modelo);
    }


    public void limpiarTabla() {
        for (int i = 0; i < listaMaterias.getjTMaterias().getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    
}
