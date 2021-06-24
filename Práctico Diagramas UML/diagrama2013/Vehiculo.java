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
public abstract class Vehiculo {
    private int ruedas;
    private String duenio;

    public Vehiculo(int ruedas, String duenio) {
        this.ruedas = ruedas;
        this.duenio = duenio;
    }
    
    public abstract double Precio();
    public abstract double Velocidad_Maxima();

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public abstract int getRuedas();
    public abstract void setRuedas(int ruedas);
     
    
}
