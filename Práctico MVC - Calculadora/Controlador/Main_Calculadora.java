package Controlador;

/**
 *
 * @author Pablo Valentini
 */
import Modelo.Modelo_Calculadora;
import Vista.Vista_Calculadora;

public class Main_Calculadora {

    
    public static void main(String[] args) {
        Vista_Calculadora v1 = new Vista_Calculadora();
        Modelo_Calculadora m1 = new Modelo_Calculadora();
        Controlador_Calculadora c1 = new Controlador_Calculadora(m1, v1);
    }
    
}
