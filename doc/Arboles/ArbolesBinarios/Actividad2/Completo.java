import arbolBinario.ArbolBinario;
import arbolBinario.ArbolVacioExcepcion;
import arbolBinario.EnlazadoArbolBinario;

public class Completo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    ArbolBinario<Integer> arbol1 = new EnlazadoArbolBinario<>(1, new EnlazadoArbolBinario<>(), new EnlazadoArbolBinario<>());
    ArbolBinario<Integer> arbol2 = new EnlazadoArbolBinario<>();
    arbol2.setHijoDer(arbol1);
    arbol2.setHijoIzq(arbol1);
    //arbol1.setRaiz(5);
    //arbol2.setRaiz(3);
    //arbol1.setHijoDer(arbol2);
    

    
    System.out.println(esCompleto(arbol2));

    }

    public static boolean esCompleto (ArbolBinario arbol){

        try{

            if(arbol.esVacio()){
            return true;
        }

        if(arbol.hijoDer() != null && arbol.hijoIzq() != null){
            boolean comprobacion = esCompleto(arbol.hijoDer());
            comprobacion = comprobacion && esCompleto(arbol.hijoIzq()); 
            return comprobacion;
        }  
        }catch(ArbolVacioExcepcion nueva){
            return false;
        }

        return true;
    }

}