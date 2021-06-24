/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Profesor;
import Vista.Vista_Profesores;
import Vista.Lista_Profesores;
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
public class Controlador_Profesor implements ActionListener {

    private Profesor profesor = new Profesor();
    private Vista_Profesores vistaProfesor = new Vista_Profesores();

    private Lista_Profesores listaProfesor;
    private Menu menu;
    private DefaultTableModel modelo;

    public Controlador_Profesor(Lista_Profesores listaProfesor, Menu menu) {
        this.listaProfesor = listaProfesor;
        this.menu = menu;

        this.listaProfesor.getjBNuevo().addActionListener(this);
        this.listaProfesor.getjBEditar().addActionListener(this);
        this.listaProfesor.getjBEliminar().addActionListener(this);

        this.vistaProfesor.getjBGuardar().addActionListener(this);
        this.vistaProfesor.getjBCancelar().addActionListener(this);
        this.vistaProfesor.getjBeditar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listaProfesor.getjBNuevo()) {
            vistaProfesor.setVisible(true);
            vistaProfesor.getjBGuardar().setVisible(true);
            vistaProfesor.getjBeditar().setVisible(false);
            this.vistaProfesor.getjLtituloProfe().setText("Agregar profesor");
            this.vistaProfesor.getjTDNI().setEditable(true);
        } else if (e.getSource() == vistaProfesor.getjBGuardar()) {
            agregar();
        } else if (e.getSource() == listaProfesor.getjBEditar()) {
            cargarVistaEditar();
        } else if (e.getSource() == vistaProfesor.getjBeditar()) {
            editar();
        } else if (e.getSource() == vistaProfesor.getjBCancelar()) {
            vistaProfesor.dispose();
        } else if (e.getSource() == listaProfesor.getjBEliminar()) {
            eliminar();
        }
    }

    public void listarProfesor(JTable table) {
        modelo = (DefaultTableModel) listaProfesor.getjTProfesores().getModel();
        listaProfesor.getjTProfesores().setRowHeight(25);
        ArrayList<Profesor> lista = profesor.leerProfesor();
        Object[] columna = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            columna[0] = lista.get(i).getDni();
            columna[1] = lista.get(i).getNombre();
            columna[2] = lista.get(i).getApellido();
            columna[3] = lista.get(i).getFechaNac();
            columna[4] = lista.get(i).getDomicilio();
            columna[5] = lista.get(i).getTelefono();
            modelo.addRow(columna);
        }
        listaProfesor.getjTProfesores().setModel(modelo);
    }

    public void eliminar() {
        int fila = listaProfesor.getjTProfesores().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccione Una Fila!");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Esto solo eliminará al profesor (Para proteger las notas alcanzadas por los alumnos)!", "Esta seguro que desea eliminar al profesor?", JOptionPane.YES_NO_OPTION) == 0) {
                int id = Integer.parseInt((String) listaProfesor.getjTProfesores().getValueAt(fila, 0).toString());
                profesor.eliminarProfesor(id);
                limpiarTabla();
                listarProfesor(listaProfesor.getjTProfesores());
                JOptionPane.showMessageDialog(null, "Eliminado!");
            }
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < listaProfesor.getjTProfesores().getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void cargarVistaEditar() {
        this.vistaProfesor.getjLtituloProfe().setText("Editar profesor");
        vistaProfesor.getjBeditar().setVisible(true);
        vistaProfesor.getjBGuardar().setVisible(false);

        int fila = listaProfesor.getjTProfesores().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccione Una Fila!");
        } else {
            this.vistaProfesor.getjTDNI().setEditable(false);
            vistaProfesor.getjTDNI().setText(listaProfesor.getjTProfesores().getValueAt(fila, 0).toString());
            vistaProfesor.getjTNombre().setText(listaProfesor.getjTProfesores().getValueAt(fila, 1).toString());
            vistaProfesor.getjTApellido().setText(listaProfesor.getjTProfesores().getValueAt(fila, 2).toString());
            vistaProfesor.getjDfecNac().setText(listaProfesor.getjTProfesores().getValueAt(fila, 3).toString());
            vistaProfesor.getjTDomicilio().setText(listaProfesor.getjTProfesores().getValueAt(fila, 4).toString());
            vistaProfesor.getjTTelefono().setText(listaProfesor.getjTProfesores().getValueAt(fila, 5).toString());
            vistaProfesor.setVisible(true);
        }

    }

    public void agregar() {
        if (Validaciones.cantDig(8, vistaProfesor.getjTDNI().getText()) == false) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener 8 dígitos!");
        } else if (Validaciones.menosDe(12,vistaProfesor.getjTTelefono().getText()) == false) {
            JOptionPane.showMessageDialog(null, "Solo se permiten menos de 12 dígitos, revise teléfono!");
        } else {

            profesor.setDni(Integer.valueOf(vistaProfesor.getjTDNI().getText()));
            profesor.setNombre(vistaProfesor.getjTNombre().getText());
            profesor.setApellido(vistaProfesor.getjTApellido().getText());
            profesor.setFechaNac(Date.valueOf(vistaProfesor.getjDfecNac().getText()));
            profesor.setDomicilio(vistaProfesor.getjTDomicilio().getText());
            profesor.setTelefono(vistaProfesor.getjTTelefono().getText());

            if (profesor.crearProfesor(profesor) == true) {
                limpiarTabla();
                listarProfesor(listaProfesor.getjTProfesores());
                JOptionPane.showMessageDialog(null, "Guardado Con Exito!");
                vistaProfesor.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, Revisar Consola...");
            }
        }
    }

    public void editar() {
        if (Validaciones.soloNumeros(vistaProfesor.getjTDNI().getText()) == false) {
            JOptionPane.showMessageDialog(null, "Solo se permiten números, revise DNI!");
        } else if (Validaciones.cantDig(8, vistaProfesor.getjTDNI().getText()) == false) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener 8 dígitos!");
        } else if (Validaciones.soloNumeros(vistaProfesor.getjTTelefono().getText()) == false) {
            JOptionPane.showMessageDialog(null, "Solo se permiten números, revise teléfono!");
        } else if (Validaciones.menosDe(12,vistaProfesor.getjTTelefono().getText()) == false) {
            JOptionPane.showMessageDialog(null, "Solo se permiten menos de 12 dígitos, revise teléfono!");
        } else {

            profesor.setDni(Integer.valueOf(vistaProfesor.getjTDNI().getText()));
            profesor.setNombre(vistaProfesor.getjTNombre().getText());
            profesor.setApellido(vistaProfesor.getjTApellido().getText());
            profesor.setFechaNac(Date.valueOf(vistaProfesor.getjDfecNac().getText()));
            profesor.setDomicilio(vistaProfesor.getjTDomicilio().getText());
            profesor.setTelefono(vistaProfesor.getjTTelefono().getText());

            if (profesor.actualizarProfesor(profesor) == true) {
                limpiarTabla();
                listarProfesor(listaProfesor.getjTProfesores());
                JOptionPane.showMessageDialog(null, "Editado Con Exito");
                vistaProfesor.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, Revisar Consola...");
            }
        }
    }

}
