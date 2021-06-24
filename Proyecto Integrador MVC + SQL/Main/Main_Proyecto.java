/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controlador.Controlador_Menu;
import Vista.Menu;


/**
 *
 * @author Pablo Valentini
 */
public class Main_Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Menu menu = new Menu();
        Controlador_Menu controladorMenu = new Controlador_Menu(menu);
        controladorMenu.listaAlumno();                                  // Inicia en el panel de alumnos
        menu.setVisible(true);
        
    }

}
