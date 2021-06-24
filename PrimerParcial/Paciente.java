package PrimerParcial_ValentiniPablo_Grupo2;

/**
 *
 * @author Pablo Valentini
 */
public class Paciente extends Persona{
    Fecha fechaInternacion = new Fecha();
    Diagnostico diagnostico = new Diagnostico();
    
    public Paciente(int dni, String nombre, String Apellido, char sexo) {
        super(dni, nombre, Apellido, sexo);
    }
    
    public Paciente(){
        
    }

    public Fecha getFechaInternacion() {
        return fechaInternacion;
    }

    public void setFechaInternacion(Fecha fechaInternacion) {
        this.fechaInternacion = fechaInternacion;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }


    
}
