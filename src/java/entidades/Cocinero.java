
package entidades;


public class Cocinero {
    
    private int idCocinero;
    private String nombre;
    private String apellido;
    private String especialidad;

    public Cocinero() {
    }

    
    public Cocinero(int idCocinero, String nombre, String apellido, String especialidad) {
        this.idCocinero = idCocinero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    
    
    public int getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(int idCocinero) {
        this.idCocinero = idCocinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    
    
}
