package PrimerParcial_ValentiniPablo_Grupo2;

/**
 *
 * @author Pablo Valentini
 */
public abstract class Persona {
    protected int dni;
    protected String nombre;
    protected String Apellido;
    protected char sexo;

    public Persona(int dni, String nombre, String Apellido, char sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.sexo = sexo;
    }

    public Persona() {
    }
    
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    
}
