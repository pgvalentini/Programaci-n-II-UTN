/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama2013;

/**
 *
 * @author Pablo Valentini
 */
public class Auto extends Vehiculo implements Motor{

    int puertas;

    public Auto(int puertas, int ruedas, String duenio) {
        super(ruedas, duenio);
        this.puertas = puertas;
    }
    
    public static String Tipo(){
         String s = " ";
         return s;
    }
    
    @Override
    public double Precio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double Velocidad_Maxima() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRuedas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRuedas(int ruedas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
