/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author Pablo Valentini
 */
public class Validaciones {

    public static boolean cantDig(int cant,String valor) {
        return valor.length() == cant;
    }
    
    public static boolean menosDe(int cant,String valor) {
        return valor.length() < cant;
    }

    public static boolean soloNumeros(String valor) {
        try {
            Integer.parseInt(valor);
            return true;                    
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean numeroDoubleEntre(double menor, double mayor, String valor) {
        return Double.parseDouble(valor) >= menor && Double.parseDouble(valor) <= mayor;
    }

}
