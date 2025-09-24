import java.util.*;
public class Sistema{
    private ArrayList<Alumno> alumnos=new ArrayList();
    private ArrayList<Docente> docentes=new ArrayList();
    private ArrayList<Curso> cursos=new ArrayList();
    private HashMap<String,Integer> promediosalumnos=new HashMap<>();
        //registrarAlumnos(); registra los alumnos al sistema
    public void registrarAlumnos(){
        System.out.println("Registrando alumnos al sistema");
        Scanner leer=new Scanner(System.in);
        System.out.println("ingrese la cantidad de alumnos que quiere registrar ");
        int numerodealumnos=leer.nextInt();
        for(int i=0;i<numerodealumnos;i++){
        System.out.println("ingrese el nombre del alumno :"+(+i+1));    
        String nombre=leer.nextLine();
        if(nombre!=null&& nombre instanceof String){     
        }
        else {
            System.out.println("nombre no valido, ingrese de nuevo");
            nombre=leer.nextLine();
         }
        System.out.println("ingrese el apellido del alumno :"+(+i+1));    
        String apellido=leer.nextLine();
        if(apellido!=null&& apellido instanceof String){
        }
                else {
            System.out.println("apellido no valido, ingrese de nuevo");
            apellido=leer.nextLine();
         }
        System.out.println("ingrese el codigo del alumno :"+(+i+1));    
        String codigounico=leer.nextLine();
        if(codigounico!=null&& codigounico instanceof String){
        }
                else {
            System.out.println("codigo no valido, ingrese de nuevo");
            codigounico=leer.nextLine();
         }
         Alumno nuevoalumno= new Alumno(nombre,apellido,codigounico);
        alumnos.add(nuevoalumno);
        System.out.println("alumno registrado exitosamente al sistema"); 
    } }
        //registrarDocentes() registra los docentes al sistema
    public void registrarDocente(){
        System.out.println("registrando docentes al sistema");
        Scanner leer=new Scanner(System.in);
        System.out.println("ingrese el nombre del docente");
        String nombredocente=leer.nextLine();
        System.out.println("ingrese el apellido del docente");
        String apellidocdocente=leer.nextLine();
        System.out.println("ingrese la especialidad del docente");
        String especialidaddocente=leer.nextLine();
        System.out.println("ingrese el dni del docente");
        String dnidocente=leer.nextLine();
        System.out.println("ingrese la experiencia del docente");
        String experienciadocdocente=leer.nextLine();
        Docente docente=new Docente(dnidocente, nombredocente, especialidaddocente, experienciadocdocente);
        docentes.add(docente);
        System.out.println("docente registrando exitosamente al sistema");
    }
        //registrarCursos()registra cursos disponibles al sistema
        public void registrarCurso(){
        System.out.println("Registrando cursos al sistema");
        Scanner leer=new Scanner(System.in);
        System.out.println("ingrese el nombre del curso");
        String nombrecurso=leer.nextLine();
        System.out.println("ingrese el codigo del curso");
        String codigocurso=leer.nextLine();
        System.out.println("ingrese el dni del docente asociado");
        String dnidocentededicado=leer.nextLine();
        for(Docente d:docentes) {
            if(dnidocentededicado.equals(d.getDni())){
                System.out.println("docente habilitado");
            }
            else{
                System.out.println("docente no habilitado, ingrese uno valido");
               dnidocentededicado=leer.nextLine();
            }}
      Curso curso=new Curso(nombrecurso, codigocurso,dnidocentededicado);
      cursos.add(curso);
        System.out.println("curso registrado exitosamente al sistema");  
    }
    // matricularAlumnos() matricula alumnos a cursos
    public void matricularAlumnos(){
    System.out.println("Matriculando alumnos a cursos");
    Scanner leer=new Scanner(System.in);
    System.out.println("ingrese nombre del alumno");
    String nombre=leer.nextLine();
    System.out.println("ingrese apellido del alumno");
    String apellido=leer.nextLine();
    System.out.println("ingrese codigo del alumno");
    String codigounico=leer.nextLine();
    for (Alumno alumnoindice:alumnos){
    if (codigounico.equals(alumnoindice.getCodigo())){
    System.out.println("alumno habilitado"); 
    }
    else{
    System.out.println("alumno no habilitado, ingrese uno valido");
    codigounico=leer.nextLine();
    }}
    Alumno alumnomatricular=new Alumno(nombre, apellido, codigounico);
    System.out.println("ingrese el nombre del curso a matricular ");
    String nombredecurso=leer.nextLine();
    for (Curso cursoindice:cursos){
    if (nombredecurso.equals(cursoindice.getNombreCurso())){
    System.out.println("curso habilitado");
    cursoindice.agregarAlumno(alumnomatricular.getNombre());
    alumnomatricular.agregarCurso(cursoindice.getNombreCurso()); 
    break;
    }
    System.out.println("alumno:"+alumnomatricular.getNombre()+"matriculado en :"+cursoindice);
    }}
    //registrarnotas() registra notas de alumnos por curso
    public void registrarNotasPorAlumno() {
    System.out.println("Registrando notas por alumno");
    Scanner leer = new Scanner(System.in);
    System.out.println("Ingrese el código del alumno:");
    String codigounico = leer.nextLine();
    Alumno alumnoEncontrado = null;
    for (Alumno a : alumnos) {
        if (a.getCodigo().equals(codigounico)) {
            alumnoEncontrado = a;
            break;
        }
    }
    if (alumnoEncontrado != null) {
        System.out.println("Alumno encontrado: " + alumnoEncontrado.getNombre() + " " + alumnoEncontrado.getApellido());
        alumnoEncontrado.agregarNotasACurso(); 
    } else {
        System.out.println("Alumno no encontrado.");
    }
}
    //promedioponderadoAlumnos()calcula el promedio ponderado entre todos los alumnos
    public void promedioponderadoAlumnos() {
        System.out.println("calculando promedios ponderados de los alumnos");
    for (Alumno a : alumnos) {
        int promedio = a.promedioponderadoIndividual();
        promediosalumnos.put(a.getCodigo(), promedio);
    }
}
    //promediomayorAlumnos() calcula el alumno con mayor promedio
    public void promediomayorAlumnos() {
    System.out.println("calculando el alumno con mayor promedio");
    if (promediosalumnos.isEmpty()) {
        System.out.println("No hay promedios calculados.");
        return;
    }
    String alumnoConMayorPromedio = null;
    int mayorPromedio = 0;
    for (String codigo : promediosalumnos.keySet()) {
        int promedio = promediosalumnos.get(codigo);
        if (promedio > mayorPromedio) {
            mayorPromedio = promedio;
            alumnoConMayorPromedio = codigo;
        }
    }
    System.out.println("El alumno con mayor promedio es: " + alumnoConMayorPromedio + " con un promedio de: " + mayorPromedio);
}
    //condicionAlumnos() crea un hashmap con los alumnos aprobados y desaprobados
 public void condicionAlumnos() {
    System.out.println("Determinando condicion de los alumnos (aprobado/desaprobado)");
    HashMap<String, String> condicionAlumnos = new HashMap<>();
    for (Alumno a : alumnos) {
        int promedio = a.promedioponderadoIndividual();
        if (promedio >= 11) {
            condicionAlumnos.put(a.getCodigo(), "Aprobado");
        } else {
            condicionAlumnos.put(a.getCodigo(), "Desaprobado");
        }
    }
    // Mostrar resultados
    System.out.println("Condición de los alumnos:");
    for (Alumno a : alumnos) {
        String condicion = condicionAlumnos.get(a.getCodigo());
        System.out.println(a.getNombre() + " " + a.getApellido() + " (" + a.getCodigo() + "): " + condicion);
    }
}

}

