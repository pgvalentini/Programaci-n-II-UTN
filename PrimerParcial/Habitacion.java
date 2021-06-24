package PrimerParcial_ValentiniPablo_Grupo2;

import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Habitacion {
    private int numero;
    private ArrayList<Cama> camas = new ArrayList<Cama>();

    public Habitacion(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Cama> getCamas() {
        return camas;
    }

    public void setCamas(ArrayList<Cama> camas) {
        this.camas = camas;
    }
    
    public void addCama(Cama cama){
        camas.add(cama);
    }
    
    
    
}
