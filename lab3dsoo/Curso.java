import java.util.*;
public class Curso {
//cada curso tendra :nombre,codigo,docente titular,alumnos matriculados    
private String nombredecurso;
private String codigodecurso; 
private String docentetitular; 
private ArrayList<String>alumnosmatriculados=new ArrayList<>();  
//constructor para cada curso
public Curso(String nombredecurso,String codigodecurso,String docentetitular){
    this.nombredecurso=nombredecurso;
    this.codigodecurso=codigodecurso;
    this.docentetitular=docentetitular;
}
//getters para devolver valores
public String getCodigoCurso(){
    return codigodecurso;
}
public void agregarAlumno(String nombrealumno){
    alumnosmatriculados.add(nombrealumno);   
 }
public String getNombreCurso(){
    return nombredecurso;
}
public String getDocenteTitular(){
    return docentetitular;
}
}
