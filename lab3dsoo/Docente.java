public class Docente {
//Los atributos de cada docente son : dni,nombre,apellido,especialidad,cursodedicado
private String dni;
private String nombre;
private String apellido;    
private String especialidad;
private String experiencia;
private String cursodedicado;
//constructor para cada docente
public Docente(String dni,String nombre,String especialidad,String experiencia){
this.dni=dni;
this.nombre=nombre;
this.apellido=apellido;   
this.especialidad=especialidad;
this.experiencia=experiencia;
this.cursodedicado=null;
}
//asignar su curso dedicado a enseñar
public void setCursodedicado(String cursodedicado){
this.cursodedicado=cursodedicado;
}
//getters para obtener valores
public String getNombre(){return nombre;}
public String getApellido(){return apellido;}
public String getDni(){return dni;}
public String getEspecialidad(){return especialidad;}
public String getCursoDedicado(){
    return cursodedicado;
}
}
