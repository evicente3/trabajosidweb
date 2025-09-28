public class Docente {
    private String dni;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String cursodedicado;
    private int añosDocente;

    public Docente(String apellido, int añosDocente, String dni, String especialidad, String nombre) {
        this.apellido = apellido;
        this.añosDocente = añosDocente;
        this.dni = dni;
        this.especialidad = especialidad;
        this.nombre = nombre;
        this.cursodedicado = "";
    }

    public void setCursodedicado(String cursodedicado) {
        this.cursodedicado = cursodedicado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getAñosDocente() {
        return añosDocente;
    }

    public String getCursodedicado() {
        return cursodedicado;
    }
}