import arbolBinario.ArbolBinario;
import arbolBinario.EnlazadoArbolBinario;

public class Actividad2 {

    // Ejercicio 1
    public static boolean completo(ArbolBinario<E> arbol){
        if(arbol.esVacio()){
            return true;
        }

        if((arbol.hijoDer().esVacio() && !arbol.hijoIzq().esVacio())
                || (!arbol.hijoDer().esVacio() && arbol.hijoIzq().esVacio()) ){
            return false;
        }else{
            return completo(arbol.hijoDer()) && completo(arbol.hijoIzq());
        }
    }

    // Ejercicio 2
    public static <E> boolean identicos(ArbolBinario<E> arbolA, ArbolBinario<E> arbolB){
        if(arbolA.esVacio() && arbolB.esVacio()){
            return true;
        }
        if(arbolA.esVacio() || arbolB.esVacio()){
            return false;
        }

        if(!arbolA.raiz().equals(arbolB.raiz())){
            return false;
        }
        return identicos(arbolA.hijoIzq(), arbolB.hijoIzq()) && identicos(arbolA.hijoDer(), arbolB.hijoDer());


    }

    // Ejercicio 3
    public static <E> int numNodosNivel(ArbolBinario<E> a, int nivel) {
        if (a.esVacio()) {
            return 0;
        }
        if (nivel == 0) {
            return 1;
        }
        return numNodosNivel(a.hijoIzq(), nivel - 1)
                + numNodosNivel(a.hijoDer(), nivel - 1);

    }

    // Ejercicio 4
    public static <E> ArbolBinario<E> copiaSinHojas(ArbolBinario<E> a){
        if(a.esVacio() || (a.hijoIzq().esVacio() && a.hijoDer().esVacio())){
            return new EnlazadoArbolBinario<>();
        }else{
            return new EnlazadoArbolBinario<>(a.raiz(), copiaSinHojas(a.hijoDer()), copiaSinHojas(a.hijoIzq()));
        }
    }

    //Ejercicio 5
    public static <E> int altura(ArbolBinario<E> a){
        if(a.esVacio() || (a.hijoIzq().esVacio() && a.hijoDer().esVacio())){
            return -1;
        }
        int izquierda = altura(a.hijoIzq());

        int derecha = altura(a.hijoDer());

        if(izquierda > derecha){
            return izquierda + 1;
        }else{
            return derecha + 1;
        }

    }

    // Ejercicio 6


    //Ejercicio 8
    public static <E> ArbolBinario<E> copiaHastaNivel(ArbolBinario<E> a, int nivel){
        if (a.esVacio()) {
            return a;
        }
        if (nivel == 0) {
            return a;
        }

    }
}
