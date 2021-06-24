package PrimerParcial_ValentiniPablo_Grupo2;

/**
 *
 * @author Pablo Valentini
 */
public class Diagnostico {
    private String texto;
    private NivelDianostico nivelDiagnostico = new NivelDianostico(texto);
    private Tratamiento tratamiento = new Tratamiento(texto);

    public Diagnostico() {
    }

    public Diagnostico(String texto, NivelDianostico nivelDiagnostico,Tratamiento tratamiento) {
        this.texto = texto;
        this.tratamiento = tratamiento;
        this.nivelDiagnostico = nivelDiagnostico;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public NivelDianostico getNivelDiagnostico() {
        return nivelDiagnostico;
    }

    public void setNivelDiagnostico(NivelDianostico nivelDiagnostico) {
        this.nivelDiagnostico = nivelDiagnostico;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
    
    
}
