/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asociaciones_valentini;

/**
 *
 * @author Pablo Valentini
 */
public class Comprobante {
    private char tipo;
    private int numero;
    private Fecha fecha;

    public Comprobante() {
    }

    public Comprobante(char tipo, int numero, Fecha fecha) {
        this.tipo = tipo;
        this.numero = numero;
        this.fecha = fecha;
    }
    
    

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
    
}
