import java.util.*;
public class Sistema{
    private ArrayList<Alumno> alumnos=new ArrayList();
    private ArrayList<Docente> docentes=new ArrayList();
    private ArrayList<Curso> cursos=new ArrayList();
    private HashMap<String,Integer> promediosalumnos=new HashMap<>();
        //registrarAlumnos(); registra los alumnos al sistema
   public void registrarAlumnos() {

        Scanner sc = new Scanner(System.in);
        System.out.println("----Registro Alumno ----");
        while (true) { 
        System.out.println("Introducir el numero de alumnos");
        int numeroAlumnos = sc.nextInt();
        System.out.println();
        sc.nextLine();
        if(ValidadNumeroEntrada(numeroAlumnos)){
        for (int i = 0; i < numeroAlumnos; i++) {
            String nombreAlumno = solicitarDato("Introducir Nombre del alumno " + (i+1)+" : ", "texto");
            String apellidoAlumno = solicitarDato("Introducir Apellidos del alumno "+ (i+1)+" : ", "texto");
            String cuiUnico = solicitarDato("Introducir CUI del alumno "+ (i+1)+" : ", "texto");
            System.out.println();
        Alumno alumno = new Alumno(apellidoAlumno, cuiUnico, nombreAlumno);
        alumnos.add(alumno);
        }
        break;
        }else{
            System.out.println("Numero invalido introducir Numero de Alumnos");
            }
        }
    }
        //registrarDocentes() registra los docentes al sistema
   public void registrarDocentes() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n---Registro Docente ---");
        while (true) { 
        System.out.println("Introducir el numero de Docentes");
        int numeroDocentes = sc.nextInt();
        sc.nextLine();
        if(ValidadNumeroEntrada(numeroDocentes)){
        for (int i = 0; i < numeroDocentes; i++) {
            String nombreDocente = solicitarDato("Introducir Nombre del docente "+ (i+1)+" : ", "texto");
            String apellidoDocente = solicitarDato("Introducir Apellido del docente "+ (i+1)+" : ", "texto");
            String especialidadDocente = solicitarDato("Especialidad del docente: "+ (i+1)+" : ", "texto");
            System.out.println("Introducir los Años de experiencia :");
            int añosDocente = sc.nextInt();
            sc.nextLine();
            String dniDocente = solicitarDato("Introducir el DNI del docente: "+ (i+1)+" : ", "texto");
            System.out.println();
        Docente docente = new Docente(apellidoDocente, añosDocente, dniDocente, especialidadDocente, nombreDocente);
        docentes.add(docente);
        }
        break;
        }else{
            System.out.println("Numero invalido Introducir Numero de docentes");
            }
        }
    }
        //registrarCursos()registra cursos disponibles al sistema
       public void registrarCursos () {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n---Registro Cursos---");
        System.out.println("Introducir el numero de cursos ");
        int numeroCursos = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numeroCursos; i++) {
            String nombrecurso= solicitarDato("Introducir Nombre del curso "+ (i+1)+" : ", "texto");
            String codigoCurso = solicitarDato("Intrdocuir Codigo de Curso "+ (i+1)+" : ", "texto");
            String dnidoncentededicado =solicitarDato("Introducir Dni del docende asignado "+ (i+1)+" : ", "texto");
        
        Curso curso = new Curso(nombrecurso, codigoCurso, dnidoncentededicado);
        cursos.add(curso);
        }
    }
    public boolean ValidadNumeroEntrada(int numero){
        return numero>0 ;
    }
    public boolean ValidarTexto(String texto){
        return  texto !=null && !texto.isEmpty();
    }
    private String solicitarDato(String mensaje, String tipoValidacion) {
    Scanner sc = new Scanner(System.in);
    String dato;
    while (true) {
        System.out.print(mensaje);
        dato = sc.nextLine();
        
        switch (tipoValidacion) {
            case "texto":
                if (ValidarTexto(dato)) return dato;
                System.out.println("No puede estar vacio");
                break;
                                                }
                }
    }


    // matricularAlumnos() matricula alumnos a cursos
   // ...existing code...
public void matricularAlumnos() {
    Scanner leer = new Scanner(System.in);
    if (alumnos.isEmpty() || cursos.isEmpty()) {
        System.out.println("Debe haber alumnos y cursos registrados para matricular.");
        return;
    }
    System.out.println("Matriculando todos los alumnos a al menos un curso ");
    for (Alumno alumno : alumnos) {
        System.out.println("\nAlumno: " + alumno.getNombre() + " " + alumno.getApellido() + " (" + alumno.getCodigo() + ")");
        boolean matriculado = false;
        while (!matriculado) {
            System.out.println("Cursos disponibles:");
            for (Curso curso : cursos) {
                System.out.println("- " + curso.getNombreCurso() + " (Código: " + curso.getCodigoCurso() + ")");
            }
            System.out.print("Ingrese el CÓDIGO del curso para matricular al alumno (debe ser exacto): ");
            String codigoCurso = leer.nextLine();
            boolean cursoEncontrado = false;
            for (Curso curso : cursos) {
                if (curso.getCodigoCurso().equals(codigoCurso)) {
                    curso.agregarAlumno(alumno.getCodigo());
                    alumno.agregarCurso(curso.getNombreCurso());
                    System.out.println("Alumno matriculado en: " + curso.getNombreCurso());
                    cursoEncontrado = true;
                    matriculado = true;
                    break;
                }
            }
            if (!cursoEncontrado) {
                System.out.println("Código de curso no encontrado. Intente nuevamente.");
            }
        }
    }
}
     //registrarnotasparatodoslosalumnos() registra notas de alumnos por curso
    public void registrarNotasParaTodosLosAlumnos() {
    System.out.println("---Registrando notas para todos los alumnos---");
    for (Alumno a : alumnos) {
        System.out.println("Alumno: " + a.getNombre() + " " + a.getApellido() + " (" + a.getCodigo() + ")");
        a.agregarNotasACurso();
    }
}
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
    String codigoAlumnoConMayorPromedio = null;
    int mayorPromedio = 0;
    for (String codigo : promediosalumnos.keySet()) {
        int promedio = promediosalumnos.get(codigo);
        if (promedio > mayorPromedio) {
            mayorPromedio = promedio;
            codigoAlumnoConMayorPromedio = codigo;
        }
    }
    // Buscar el alumno en la lista
    Alumno alumnoMayor = null;
    for (Alumno a : alumnos) {
        if (a.getCodigo().equals(codigoAlumnoConMayorPromedio)) {
            alumnoMayor = a;
            break;
        }
    }
    if (alumnoMayor != null) {
        System.out.println("El alumno con mayor promedio es: " + alumnoMayor.getNombre() + " " + alumnoMayor.getApellido() +
                " (" + alumnoMayor.getCodigo() + ") con un promedio de: " + mayorPromedio);
    } else {
        System.out.println("El alumno con mayor promedio es: " + codigoAlumnoConMayorPromedio + " con un promedio de: " + mayorPromedio);
    }
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

