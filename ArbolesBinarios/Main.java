import arbolBinario.ArbolBinario;
import arbolBinario.ArbolVacioExcepcion;
import arbolBinario.EnlazadoArbolBinario;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final ArbolBinario<Integer> vacio = new EnlazadoArbolBinario<>();
        System.out.println(completo(vacio));
    }
    public static boolean completo(ArbolBinario vacio) throws ArbolVacioExcepcion{
        try{
            if(vacio.esVacio()){
                return true;
            }
            if(vacio.hijoDer() != null && vacio.hijoIzq() != null){
                return completo(vacio.hijoDer()) && completo(vacio.hijoIzq());
            }
        }catch (ArbolVacioExcepcion nueva){
            return false;
        }  
       return true;
    }
}
