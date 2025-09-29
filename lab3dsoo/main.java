public class main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.registrarAlumnos();      
        sistema.registrarDocentes();   
        sistema.registrarCursos();    
        sistema.matricularAlumnos();
        sistema.registrarNotasParaTodosLosAlumnos();     
        sistema.promedioponderadoAlumnos();
        sistema.promediomayorAlumnos();      
        sistema.condicionAlumnos();           
    }
}