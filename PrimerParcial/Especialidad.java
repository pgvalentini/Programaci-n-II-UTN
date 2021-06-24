package PrimerParcial_ValentiniPablo_Grupo2;

import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Especialidad {
    private String nombre;
    private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
    private ArrayList<Medico> medicos = new ArrayList<Medico>();

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad() {
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }
    
    public void addHabitacion(Habitacion habitaciones){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void addMedico(Medico medico){
        medicos.add(medico);
    }
    
}
