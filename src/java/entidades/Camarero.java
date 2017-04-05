
package entidades;


public class Camarero {
    
    private int idCamarero;
    private String nombre;
    private String apellido;
    private String especialidad;

    public Camarero() {
    }

    public Camarero(int idCamarero, String nombre, String apellido, String especialidad) {
        this.idCamarero = idCamarero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }
    
    

    
    public int getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(int idCamarero) {
        this.idCamarero = idCamarero;
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
