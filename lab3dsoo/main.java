public class main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.registrarAlumnos();           
        sistema.registrarDocente();          
        sistema.registrarCurso();             
        sistema.matricularAlumnos();          
        sistema.promedioponderadoAlumnos();   
        sistema.promediomayorAlumnos();       
        sistema.condicionAlumnos();           
    }
}