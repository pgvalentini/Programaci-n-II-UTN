/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Ayuda;
import Vista.Lista_Alumnos;
import Vista.Lista_Carrera;
import Vista.Lista_Cursado;
import Vista.Lista_Inscripciones;
import Vista.Lista_Materias;
import Vista.Lista_Profesores;
import Vista.Menu;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Pablo Valentini
 */
public class Controlador_Menu implements ActionListener {

    private CardLayout cardLayout = new CardLayout();
    private Menu menu;

    private Lista_Alumnos listaAlumnos = new Lista_Alumnos();
    private Lista_Carrera listaCarreras = new Lista_Carrera();
    private Lista_Inscripciones listaInscripciones = new Lista_Inscripciones();
    private Lista_Profesores listaProfesores = new Lista_Profesores();
    private Lista_Materias listaMaterias = new Lista_Materias();
    private Lista_Cursado listaCursados = new Lista_Cursado();
    private Ayuda ayuda = new Ayuda();
    
    private Controlador_Alumnos controladorAlumno = new Controlador_Alumnos(listaAlumnos, menu);
    private Controlador_Carrera controladorCarrera = new Controlador_Carrera(listaCarreras, menu);
    private Controlador_Inscripciones controladorInscripcion = new Controlador_Inscripciones(listaInscripciones, menu);
    private Controlador_Profesor controladorProfesor = new Controlador_Profesor(listaProfesores, menu);
    private Controlador_Materia controladorMateria = new Controlador_Materia(listaMaterias, menu);
    private Controlador_Cursado controladorCursado = new Controlador_Cursado(listaCursados, menu);
   

    @SuppressWarnings("LeakingThisInConstructor")
    public Controlador_Menu(Menu menu) {
        this.cardLayout = (CardLayout) menu.getjPMain().getLayout();
        this.menu = menu;
        this.menu.getjLTitulo_tabla().setText("Lista de alumnos");
        this.menu.getjBLis_Alumnos().addActionListener(this);
        this.menu.getjBList_Carreras().addActionListener(this);
        this.menu.getjBList_Cursado().addActionListener(this);
        this.menu.getjBList_Inscripciones().addActionListener(this);
        this.menu.getjBList_Materias().addActionListener(this);
        this.menu.getjBList_Profesores().addActionListener(this);
        this.menu.getjBayuda().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.getjBLis_Alumnos()) {
            menu.getjLTitulo_tabla().setText("Lista de alumnos");
            listaAlumno();
            controladorAlumno.limpiarTabla();
            controladorAlumno.listarAlumnos(listaAlumnos.getjTAlumnos());

        } else if (e.getSource() == menu.getjBList_Carreras()) {
            menu.getjLTitulo_tabla().setText("Lista de carreras");
            listaCarreras();
            controladorCarrera.limpiarTabla();
            controladorCarrera.listarCarrera(listaCarreras.getjTCarreras());

        } else if (e.getSource() == menu.getjBList_Inscripciones()) {
            menu.getjLTitulo_tabla().setText("Lista de inscripciones");
            listaInscripciones();
            controladorInscripcion.limpiarTabla();
            controladorInscripcion.listarInscripciones(listaInscripciones.getjTInscripciones());

        } else if (e.getSource() == menu.getjBList_Profesores()) {
            menu.getjLTitulo_tabla().setText("Lista de profesores");
            listaProfesores();
            controladorProfesor.limpiarTabla();
            controladorProfesor.listarProfesor(listaProfesores.getjTProfesores());

        } else if (e.getSource() == menu.getjBList_Materias()) {
            menu.getjLTitulo_tabla().setText("Lista de materias");
            listaMateria();
            controladorMateria.limpiarTabla();
            controladorMateria.listarCarrera(listaMaterias.getjTMaterias());

        } else if (e.getSource() == menu.getjBList_Cursado()) {
            menu.getjLTitulo_tabla().setText("Lista de cursados");
            listaCursados();
            controladorCursado.limpiarTabla();
            controladorCursado.listarCursado(listaCursados.getjTCursado());
        
        } else if (e.getSource()==menu.getjBayuda()){
            ayuda.setVisible(true);
        }
    }

     
    public void listaAlumno() {
        menu.getjPMain().add(listaAlumnos, "listaAlumnos");
        cardLayout.show(menu.getjPMain(), "listaAlumnos");
        SwingUtilities.updateComponentTreeUI(menu);
        menu.repaint();
        controladorAlumno.listarAlumnos(listaAlumnos.getjTAlumnos());
        
    }

    public void listaCarreras() {
        menu.getjPMain().add(listaCarreras, "listaCarreras");
        cardLayout.show(menu.getjPMain(), "listaCarreras");
        SwingUtilities.updateComponentTreeUI(menu);
        menu.repaint();
        controladorCarrera.listarCarrera(listaCarreras.getjTCarreras());
    }

    public void listaInscripciones() {
        menu.getjPMain().add(listaInscripciones, "listaIns");
        cardLayout.show(menu.getjPMain(), "listaIns");
        SwingUtilities.updateComponentTreeUI(menu);
        menu.repaint();
        controladorInscripcion.listarInscripciones(listaInscripciones.getjTInscripciones());
    }

    public void listaProfesores() {
        menu.getjPMain().add(listaProfesores, "listaProf");
        cardLayout.show(menu.getjPMain(), "listaProf");
        SwingUtilities.updateComponentTreeUI(menu);
        menu.repaint();
    }

    public void listaMateria() {
        menu.getjPMain().add(listaMaterias, "listaMat");
        cardLayout.show(menu.getjPMain(), "listaMat");
        SwingUtilities.updateComponentTreeUI(menu);
        menu.repaint();
        controladorMateria.listarCarrera(listaMaterias.getjTMaterias());
    }

    public void listaCursados() {
        menu.getjPMain().add(listaCursados, "listaCur");
        cardLayout.show(menu.getjPMain(), "listaCur");
        SwingUtilities.updateComponentTreeUI(menu);
        menu.repaint();
    }
}
