/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_noviembre;


/**
 *
 * @author Pablo Valentini
 */
public class Cliente extends Persona implements Estado_Cuenta{
    public Tarjeta_de_Credito credit_Car;

    public Cliente(int dni, String nombre, String apellido, long cuit) {
        super(dni, nombre, apellido, cuit);
    }

    public Tarjeta_de_Credito getCredit_Car() {
        return credit_Car;
    }

    public void setCredit_Car(Tarjeta_de_Credito credit_Car) {
        this.credit_Car = credit_Car;
    }

    
    @Override
    public boolean problemaVerazCodeme(){
     return true;
    }
    
    @Override
    public long getCuit() {
        return cuit;
    }

    @Override
    public void setCuit(long cuit) {
        this.cuit = cuit;
    }
    
}
