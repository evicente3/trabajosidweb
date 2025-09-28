import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Alumno {
//los atributos para cada alumno son :nombre,apellido,codigo unico y sus cursos    
private String nombre;
private String apellido;
private String cui;
private ArrayList<String>cursos;
private HashMap<String,ArrayList<Integer>> notascursos;
//constructor para cada alumno
public Alumno (String apellido,String cui,String nombre){
    this.nombre=nombre;
    this.apellido=apellido;
    this.cui=cui;  
this.cursos = new ArrayList<>();
this.notascursos = new HashMap<>();
}
//getters para cada atributo
public String getNombre(){
    return nombre;
}
public String getApellido(){
    return apellido;
}
public String getCodigo(){
    return cui;
}
public ArrayList<String> getCursos(){
    return cursos;
}
public void agregarCurso(String nombrecurso){
cursos.add(nombrecurso);
}
//metodo para agregar notas a un curso
public void agregarNotasACurso() {
    Scanner leer = new Scanner(System.in);
    if (cursos.isEmpty()) {
        System.out.println("El alumno no está matriculado en ningún curso.");
        return;
    }
    System.out.println("Cursos en los que está matriculado:");
    for (String curso : cursos) {
        System.out.println("- " + curso);
    }
    String nombreCurso;
    while (true) {
        System.out.print("Ingrese el nombre del curso (exacto) para ingresar notas: ");
        nombreCurso = leer.nextLine();
        if (cursos.contains(nombreCurso)) {
            break;
        } else {
            System.out.println("El alumno no está matriculado en ese curso. Intente nuevamente.");
        }
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
