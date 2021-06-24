/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_noviembre;

import java.util.Date;

/**
 *
 * @author Pablo Valentini
 */
public class Tarjeta_de_Credito {
    private Date fecha_Ingreso;
    private double limite;

    public Tarjeta_de_Credito(Date fecha_Ingreso, double limite) {
        this.fecha_Ingreso = fecha_Ingreso;
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public Date getFecha_Ingreso() {
        return fecha_Ingreso;
    }

    public void setFecha_Ingreso(Date fecha_Ingreso) {
        this.fecha_Ingreso = fecha_Ingreso;
    }
    
}
