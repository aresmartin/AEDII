/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AB;

/**
 *
 * @author Yo
 */
public class main {

    public static void main(String[] args) {

        EnlazadoArbolBinario arbol1 = new EnlazadoArbolBinario("m", new EnlazadoArbolBinario(), new EnlazadoArbolBinario());
        EnlazadoArbolBinario arbol2 = new EnlazadoArbolBinario(44, new EnlazadoArbolBinario(), new EnlazadoArbolBinario());

        arbol1.setHijoIzq(new EnlazadoArbolBinario("l", new EnlazadoArbolBinario(), new EnlazadoArbolBinario()));
        arbol1.setHijoDer(new EnlazadoArbolBinario("o", new EnlazadoArbolBinario(), new EnlazadoArbolBinario()));

    }

    //es completo
    public static <E> boolean esCompleto(EnlazadoArbolBinario<E> a) {
        if (a.esVacio()) {
            return true;
        } else if (a.hijoIzq().esVacio() && a.hijoDer().esVacio()) {
            return true;
        } else if (!a.hijoIzq().esVacio() && a.hijoDer().esVacio()
                || a.hijoIzq().esVacio() && !a.hijoDer().esVacio()) {
            return false;
        }
        return esCompleto(a.hijoIzq()) && esCompleto(a.hijoDer());

    }

    public static <E> boolean identicos(EnlazadoArbolBinario<E> a, EnlazadoArbolBinario<E> b) {
        if (a.esVacio() && b.esVacio()) {
            return true;
        }
        if (!a.esVacio() && !b.esVacio()) {
            return (a.raiz().equals(b.raiz()) && identicos(a.hijoDer(), b.hijoDer())
                    && (identicos(a.hijoIzq(), b.hijoIzq())));
        } else {
            return false;
        }

    }

    public static <E> int contar(EnlazadoArbolBinario<E> a, int n) {
        if (a.esVacio()) {
            return 0;
        } else if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }
        return contar(a.hijoIzq(), n - 1) + contar(a.hijoDer(), n - 1);
    }

    public static <E> EnlazadoArbolBinario crearArbol(EnlazadoArbolBinario<E> a) {

        if (a.esVacio()) {
            return new EnlazadoArbolBinario();
        } else if (a.hijoIzq().esVacio() && a.hijoDer().esVacio()) {
            return new EnlazadoArbolBinario();
        } else {
            return new EnlazadoArbolBinario(a.raiz(), crearArbol(a.hijoIzq()), crearArbol(a.hijoDer()));
        }
    }

    public static <E> int altura(EnlazadoArbolBinario<E> a) {
        if (a.esVacio()) {
            return -1;
        }
        int izquierda = altura(a.hijoIzq());
        int derecha = altura(a.hijoDer());
        if (izquierda > derecha) {
            return izquierda + 1;
        } else {
            return derecha + 1;
        }
    }

    public static <E> boolean mismaForma(EnlazadoArbolBinario<E> a, EnlazadoArbolBinario<E> b) {

        if (a.esVacio() && b.esVacio()) {
            return true;
        }
        if (!a.esVacio() && !b.esVacio()) {
            return mismaForma(a.hijoDer(), b.hijoDer()) && mismaForma(a.hijoIzq(), b.hijoIzq());
        }

        return false;

    }

    public static <E extends Comparable<E>> boolean arbolSeleccion(EnlazadoArbolBinario<E> a) {
        if (a.esVacio()) {
            return true;
        }
        if (a.hijoDer().esVacio() && a.hijoIzq().esVacio()) {
            return true;
        }
        if (a.hijoIzq().esVacio()) {
            return a.raiz().equals(a.hijoDer().raiz()) && arbolSeleccion(a.hijoDer());
        }
        if (a.hijoDer().esVacio()) {
            return a.raiz().equals(a.hijoIzq().raiz()) && arbolSeleccion(a.hijoIzq());
        }
        E raizhi = a.hijoIzq().raiz();
        E raizhd = a.hijoDer().raiz();
        E menor = (raizhi.compareTo(raizhd) > 0) ? raizhd : raizhi;
        return a.raiz().equals(menor) && arbolSeleccion(a.hijoDer()) && arbolSeleccion(a.hijoIzq());
    }

    public static <E> boolean esCamino(EnlazadoArbolBinario<E> a, String camino) {
        if (a.esVacio()) {
            return false;
        }
        if (camino.length() == 0) {
            return true;
        }
        return a.raiz().equals(camino) && (esCamino(a.hijoDer(), camino.substring(1))
                || esCamino(a.hijoIzq(), camino.substring(1)));
    }

    public static <E> EnlazadoArbolBinario<E> copiaHastaNivel(EnlazadoArbolBinario<E> a, int n) {
        if (a.esVacio()) {
            return new EnlazadoArbolBinario();
        }
        if (n == 0) {
            return new EnlazadoArbolBinario(a.raiz(), new EnlazadoArbolBinario(), new EnlazadoArbolBinario());
        }
        return new EnlazadoArbolBinario(a.raiz(), copiaHastaNivel(a.hijoIzq(), n - 1), copiaHastaNivel(a.hijoDer(), n - 1));

    }

    //10
    public static <E> void visualizarPalabras(ArbolBinario<E> a) {
        String palabra = "";
        visualizarPalabras(a, palabra);
    }

    private static <E> void visualizarPalabras(ArbolBinario<E> a, String p) {
        if (!a.esVacio()) {
            if (a.hijoIzq().esVacio() && a.hijoDer().esVacio()) {
                System.out.println(p + a.raiz());
            }
            visualizarPalabras(a.hijoIzq(), p + a.raiz());
            visualizarPalabras(a.hijoDer(), p + a.raiz());}

    }
    
    //11
    public static <E> E padre (ArbolBinario<E> a, E elemento){
        if(a.esVacio())return null;
        if(a.raiz().equals(elemento))return null;
        if((!a.esVacio() && a.hijoIzq().raiz().equals(elemento))||
              (!a.esVacio() && a.hijoDer().raiz().equals(elemento))){
            return a.raiz();
        }      
        E aux = padre(a.hijoIzq(),elemento);
        if(aux==null){
            return padre(a.hijoDer(),elemento);
        }
        else{
            return aux;
        }
        
                //falta esta parte
    }
    
    //12
    public static <E> boolean nivelK(ArbolBinario<E> a, E elem, int k){
        if(a.esVacio())return true;
        if(a.raiz().equals(elem)&& k==0)return true;
        else if(k==0)return false;
        return nivelK(a.hijoIzq(),elem,k-1) || nivelK(a.hijoDer(),elem,k-1);
    }
    
     public static <E> int numNodos(ArbolBinario<E> a){
         if(a.esVacio())return 0;
         return 1+numNodos(a.hijoIzq())+numNodos(a.hijoDer());
     }
             
             
     public static <E> boolean esHoja(ArbolBinario<E> a){
         return a.hijoIzq().esVacio()&&a.hijoDer().esVacio();
     }

}
