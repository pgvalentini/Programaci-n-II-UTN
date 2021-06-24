package Modelo;

/**
 * @author Pablo Valentini
 */

public class Modelo_Calculadora {
    
    public double suma(double num1, double num2){
        return num1+num2;
    }
    public double resta(double num1, double num2){
        return num1-num2;
    }
    public double division(double num1, double num2){
        return num1/num2;
    }
    public double multiplicacion(double num1, double num2){
        return num1*num2;
    }
    public double porcentaje(double num1, double num2){
        return num1*num2/100;
    }
    public double raiz(double num1){
        return Math.sqrt(num1);
    }

    public double potencia(double num1, double num2){
        return Math.pow(num1,num2);
    }
    public boolean validarDouble(String a){
        try{
            Double.parseDouble(a);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    } 
}
