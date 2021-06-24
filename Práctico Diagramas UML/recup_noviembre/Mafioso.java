/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recup_noviembre;

import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Mafioso extends Persona implements Investigable{
    ArrayList<Lugar> lugaresFrecuentes;
    
    public static void agregarLugar(Lugar lugar){
        
    }
    public static boolean quitarLugar(Lugar lugar){
        boolean b = true;
        return b;
    }

    @Override
    public boolean investigar() {
     return true;
    }

   
    
    
}
