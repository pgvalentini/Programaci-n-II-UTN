package PrimerParcial_ValentiniPablo_Grupo2;

import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Medico extends Persona{
    private int nroMatricula;
    private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

    public Medico() {
    }

    public Medico(int nroMatricula, int dni, String nombre, String Apellido, char sexo) {
        super(dni, nombre, Apellido, sexo);
        this.nroMatricula = nroMatricula;
    }

    public int getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(int nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPaciente(ArrayList<Paciente> Pacientes) {
        this.pacientes = Pacientes;
    }
    
    public void addPaciente(Paciente Paciente ){
        pacientes.add(Paciente);
    }
    
}
