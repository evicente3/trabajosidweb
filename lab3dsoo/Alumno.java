import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Alumno {
//los atributos para cada alumno son :nombre,apellido,codigo unico y sus cursos    
private String nombre;
private String apellido;
private String codigounico;
private ArrayList<String>cursos;
private HashMap<String,ArrayList<Integer>> notascursos;
//constructor para cada alumno
public Alumno (String nombre,String apellido,String codigounico){
    this.nombre=nombre;
    this.apellido=apellido;
    this.codigounico=codigounico;  
this.cursos = new ArrayList<>();
this.notascursos = new HashMap<>();
}
//getters para cada atributo
public String getNombre(){return nombre;}
public String getApellido(){return apellido;}
public String getCodigo(){return codigounico;}
public ArrayList<String> getCursos(){return cursos;}
public void agregarCurso(String nombrecurso){
cursos.add(nombrecurso);
}
//metodo para agregar notas a un curso
public void agregarNotasACurso() {
    Scanner leer = new Scanner(System.in);
    System.out.print("Ingrese el nombre del curso: ");
    String nombreCurso = leer.nextLine();

    if (!cursos.contains(nombreCurso)) {
        cursos.add(nombreCurso);
    }

    System.out.print("¿Cuántas notas desea ingresar para " + nombreCurso + "?: ");
    int cantidadNotas = leer.nextInt();

    ArrayList<Integer> notas = notascursos.getOrDefault(nombreCurso, new ArrayList<>());

    for (int i = 0; i < cantidadNotas; i++) {
        System.out.print("Ingrese la nota " + (i + 1) + ": ");
        int nota = leer.nextInt();
        notas.add(nota);
    }
    notascursos.put(nombreCurso, notas);
}
//metodo para sacar el promedio ponderado de todas sus notas de todos sus cursos
public int promedioponderadoIndividual() {
    if (notascursos == null || notascursos.isEmpty()) {
        return 0;
    }
    int sumaNotas = 0;
    int cantidadNotas = 0;
    for (ArrayList<Integer> notas : notascursos.values()) {
        for (int nota : notas) {
            sumaNotas += nota;
            cantidadNotas++;
        }
    }
    if (cantidadNotas == 0) return 0;
    return sumaNotas / cantidadNotas;
}
}
