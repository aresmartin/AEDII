
package solactividad4;


public class HeapVacioExcepcion extends RuntimeException{
    public HeapVacioExcepcion(){
        super();
    }
    public HeapVacioExcepcion(String mensaje){
        super (mensaje);
    }
}
