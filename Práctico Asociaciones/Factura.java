/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asociaciones_valentini;

import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Factura extends Comprobante{
    private float total;
    private Cliente mcliente;
    private ArrayList <Producto> mProducto = new ArrayList();

    public Factura() {
    }

    public Factura(float total, Cliente mcliente, char tipo, int numero, Fecha fecha,ArrayList <Producto> mProducto) {
        super(tipo, numero, fecha);
        this.total = total;
        this.mcliente = mcliente;
        this.mProducto = mProducto;
    }
    
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getMcliente() {
        return mcliente;
    }

    public void setMcliente(Cliente mcliente) {
        this.mcliente = mcliente;
    }

    public ArrayList <Producto> getmProducto() {
        return mProducto;
    }

    public void setmProducto(ArrayList <Producto> mProducto) {
        this.mProducto = mProducto;
    }
    
}
