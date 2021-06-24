package PrimerParcial_ValentiniPablo_Grupo2;

/**
 *
 * @author Pablo Valentini
 */
public class Main_Clinica2021_ValentiniPablo {

   
    public static void main(String[] args) {
   
       Clinica c1 = new Clinica();
      
       Especialidad e1 = new Especialidad("Respiración");
       c1.addEspecialidad(e1);
       
       Medico m1 = new Medico(25902, 32298516, "Raul", "Perico", 'M');
       c1.getEspecialidades().get(0).addMedico(m1);
       
       Paciente p1 = new Paciente(36134791, "Belen", "Hernandez",'F');
       Paciente p2 = new Paciente(4025863, "Andrea", "Rodriguez",'F');
       Paciente p3 = new Paciente(36134791, "Pablo", "Garcia",'M');
       c1.getEspecialidades().get(0).getMedicos().get(0).addPaciente(p1);
       c1.getEspecialidades().get(0).getMedicos().get(0).addPaciente(p2);
       c1.getEspecialidades().get(0).getMedicos().get(0).addPaciente(p3);
       
       p1.getFechaInternacion().setAnio(2021);
  
        System.out.println("Especialidad: "+c1.getEspecialidades().get(0).getNombre());
        System.out.println("Medicos: "+c1.getEspecialidades().get(0).getMedicos().get(0));
        
        System.out.println("Paciente Apellido "+c1.getEspecialidades().get(0).getMedicos().get(0).getPacientes().get(0).getApellido() + " Nombre "+c1.getEspecialidades().get(0).getMedicos().get(0).getPacientes().get(0).getNombre());
        System.out.println("DNI "+c1.getEspecialidades().get(0).getMedicos().get(0).getPacientes().get(0).getDni());
        System.out.println("Paciente Apellido "+c1.getEspecialidades().get(0).getMedicos().get(0).getPacientes().get(1).getApellido() + " Nombre "+c1.getEspecialidades().get(0).getMedicos().get(0).getPacientes().get(1).getNombre());
        System.out.println("DNI "+c1.getEspecialidades().get(0).getMedicos().get(0).getPacientes().get(1).getDni());
        System.out.println("Paciente Apellido "+c1.getEspecialidades().get(0).getMedicos().get(0).getPacientes().get(2).getApellido() + " Nombre "+c1.getEspecialidades().get(0).getMedicos().get(0).getPacientes().get(2).getNombre());
        System.out.println("DNI "+c1.getEspecialidades().get(0).getMedicos().get(0).getPacientes().get(2).getDni());

        System.out.println("Año "+c1.getEspecialidades().get(0).getMedicos().get(0).getPacientes().get(0).getFechaInternacion().getAnio());
    }
    
}
