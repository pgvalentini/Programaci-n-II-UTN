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
public class Asociaciones_Valentini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cliente c1 = new Cliente();
        Producto p1 = new Producto(29, "Ñoquis", 250.00f);
        Producto p2 = new Producto(14, "Vino  ", 180.50f);
        ArrayList <Producto> prodTotal = new ArrayList();
        prodTotal.add(p1);
        prodTotal.add(p2);
        
        Factura f1 = new Factura(430.50f, c1,'A', 29, new Fecha (20,4,2021), prodTotal);
        f1.getMcliente().setRazonSocial("Pablo Valentini");
        
        
        System.out.println("-------------------------------------");
        System.out.println("FACTURA TIPO " + f1.getTipo());
        System.out.println("-------------------------------------");
        System.out.println("Fecha: "+f1.getFecha().getDia()+"/"+f1.getFecha().getMes()+"/"+f1.getFecha().getAnio());
        System.out.println("Razón Social: "+f1.getMcliente().getRazonSocial());
        System.out.println("Código "+" Descripción "+" Precio ");
        for(Producto p:f1.getmProducto()){
            System.out.print(p.getCodigo()+"        ");
            System.out.print(p.getDescripcion()+"      ");
            System.out.print(p.getPrecio()+"       ");
            System.out.println("  ");
        }
        System.out.println("TOTAL                 "+f1.getTotal());
    }
    
}
