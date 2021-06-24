package Controlador;

import Modelo.Modelo_Calculadora;
import Vista.Vista_Calculadora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo Valentini
 */
public class Controlador_Calculadora implements ActionListener {

    public Modelo_Calculadora m1;
    public Vista_Calculadora v1;

    public Controlador_Calculadora(Modelo_Calculadora m1, Vista_Calculadora v1) {

        this.m1 = m1;
        this.v1 = v1;

        v1.setVisible(true);

        v1.jBDivide.addActionListener(this);
        v1.jBSuma.addActionListener(this);
        v1.jBResta.addActionListener(this);
        v1.jBMultiplica.addActionListener(this);
        v1.jBPorcentaje.addActionListener(this);
        v1.jBPotencia.addActionListener(this);
        v1.jBRaiz.addActionListener(this);
        v1.jBBorrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(m1.validarDouble(v1.jTNum1.getText()) && m1.validarDouble(v1.jTNum2.getText())){
         if(ae.getSource().equals(v1.jBSuma)){
            v1.jTResultado.setText(String.valueOf(m1.suma(Double.parseDouble(v1.jTNum1.getText()),Double.parseDouble(v1.jTNum2.getText()))));
         }
         else if(ae.getSource().equals(v1.jBResta)){
           v1.jTResultado.setText(String.valueOf(m1.resta(Double.parseDouble(v1.jTNum1.getText()),Double.parseDouble(v1.jTNum2.getText()))));
         }
         else if(ae.getSource().equals(v1.jBDivide)){
             v1.jTResultado.setText(String.valueOf(m1.division(Double.parseDouble(v1.jTNum1.getText()),Double.parseDouble(v1.jTNum2.getText()))));
         }
         else if(ae.getSource().equals(v1.jBMultiplica)){
             v1.jTResultado.setText(String.valueOf(m1.multiplicacion(Double.parseDouble(v1.jTNum1.getText()),Double.parseDouble(v1.jTNum2.getText()))));
         }
         else if(ae.getSource().equals(v1.jBRaiz)){
             JOptionPane.showMessageDialog(null, "Raiz cuadrada del primer número");
             v1.jTResultado.setText(String.valueOf(m1.raiz(Double.parseDouble(v1.jTNum1.getText()))));
             v1.jTNum2.setText("");
         }
         else if(ae.getSource().equals(v1.jBPorcentaje)){
             v1.jTResultado.setText(String.valueOf(m1.porcentaje(Double.parseDouble(v1.jTNum1.getText()),Double.parseDouble(v1.jTNum2.getText()))));
         }
         else if(ae.getSource().equals(v1.jBPotencia)){
             v1.jTResultado.setText(String.valueOf(m1.potencia(Double.parseDouble(v1.jTNum1.getText()),Double.parseDouble(v1.jTNum2.getText()))));
         }
         else if(ae.getSource().equals(v1.jBBorrar)){
            v1.jTResultado.setText("");  
            v1.jTNum1.setText(""); 
            v1.jTNum2.setText(""); 
         }
      }
      else{
           JOptionPane.showMessageDialog(null, "Debe ingresar solo numeros");
           v1.jTNum1.setText("");
           v1.jTNum2.setText("");
           v1.jTResultado.setText("");
      }
    }
}
