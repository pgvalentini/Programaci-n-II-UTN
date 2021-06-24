/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_noviembre;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Pablo Valentini
 */
public class Factura {
    private ArrayList<Empleado> emp = new ArrayList<Empleado>();
    private ArrayList<Cliente> clie = new ArrayList<Cliente>();
    private int nro_Factura;
    private Date fecha;
    private double monto;

    public Factura(ArrayList<Cliente> clie,ArrayList<Empleado> emp ,int nro_Factura, Date fecha, double monto) {
        this.nro_Factura = nro_Factura;
        this.fecha = fecha;
        this.monto = monto;
        this.emp = emp;
        this.clie = clie;
    }

    public ArrayList<Cliente> getClie() {
        return clie;
    }

    public void setClie(ArrayList<Cliente> clie) {
        this.clie = clie;
    }

    public ArrayList<Empleado> getEmp() {
        return emp;
    }

    public void setEmp(ArrayList<Empleado> emp) {
        this.emp = emp;
    }

    public int getNro_Factura() {
        return nro_Factura;
    }

    public void setNro_Factura(int nro_Factura) {
        this.nro_Factura = nro_Factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
    
}
