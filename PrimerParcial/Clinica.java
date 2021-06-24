package PrimerParcial_ValentiniPablo_Grupo2;

import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Clinica {
   private ArrayList<Especialidad> especialidades = new ArrayList<Especialidad>();

    public Clinica() {
    }

    public ArrayList<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }
   
   public void addEspecialidad(Especialidad especialidad){
       especialidades.add(especialidad);
   }
}
