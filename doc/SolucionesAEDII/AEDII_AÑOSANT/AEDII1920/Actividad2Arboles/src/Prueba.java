/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel Velásquez
 */
public class Prueba {

    public static void main(String[] args) {

        EnlazadoArbolBinario arbol = new EnlazadoArbolBinario("m", new EnlazadoArbolBinario(), new EnlazadoArbolBinario());
        EnlazadoArbolBinario arbol1 = new EnlazadoArbolBinario(44, new EnlazadoArbolBinario(), new EnlazadoArbolBinario());

        arbol.setHijoIzq(new EnlazadoArbolBinario("l", new EnlazadoArbolBinario(), new EnlazadoArbolBinario()));
        arbol.setHijoDer(new EnlazadoArbolBinario("o", new EnlazadoArbolBinario(), new EnlazadoArbolBinario()));

        System.out.println(esCamino(arbol, "mlo"));
    }

    //Ejercicio 1, esta bien(Definitivo)
    public static <E> boolean esCompleto(EnlazadoArbolBinario<E> arbol) {
        if (arbol.esVacio()) {
            return true;
        } else if (arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio()) {
            return true;
        } else if (arbol.hijoIzq().esVacio() || arbol.hijoDer().esVacio()) {
            return false;
        } else {
            return esCompleto(arbol.hijoIzq()) && esCompleto(arbol.hijoDer());
        }
    }

    //Ejercicio 2, está bien(Definitivo)
    public static <E> boolean sonIdenticos(EnlazadoArbolBinario<E> A, EnlazadoArbolBinario<E> B) {
        if (A.esVacio() && B.esVacio()) {
            return true;
        } else if (A.raiz().equals(B.raiz())) {
            return true;
        } else {
            return sonIdenticos(A.hijoIzq(), B.hijoIzq()) && sonIdenticos(A.hijoDer(), B.hijoDer());
        }
    }

    //Ejercicio 3, está bien(Definitivo)
    public static <E> boolean esta(EnlazadoArbolBinario<E> arbol, E elemento) {
        if (arbol.esVacio()) {
            return false;
        } else if (arbol.raiz().equals(elemento)) {
            return true;
        } else {
            return esta(arbol.hijoIzq(), elemento) || esta(arbol.hijoDer(), elemento);
        }
    }

//Ejercicio 4, está bien(Definitivo)
    public static <E> int contarNodosNivel(EnlazadoArbolBinario<E> arbol, int nivel) {
        if (arbol.esVacio()) {
            return 0;
        } else if (nivel == 0) {
            return 1;
        } else {
            return contarNodosNivel(arbol.hijoIzq(), nivel - 1) + contarNodosNivel(arbol.hijoDer(), nivel - 1);
        }
    }

//Ejercicio 5 está bien(Definitivo)
    public static <E> EnlazadoArbolBinario<E> copia(EnlazadoArbolBinario<E> arbol) { //Supongo que está bien
        if (arbol.esVacio()) {
            return new EnlazadoArbolBinario<>();
        } else if (arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio()) {
            return new EnlazadoArbolBinario<>();
        } else {
            return new EnlazadoArbolBinario(arbol.raiz(), copia(arbol.hijoIzq()), copia(arbol.hijoDer()));
        }
    }

    //Ejercicio 6, está bien(Definitivo)
    public static <E> int altura(EnlazadoArbolBinario<E> arbol) {

        if (arbol.esVacio() || esHoja(arbol)) {
            return 0;
        } else {
            return 1 + altura(arbol.hijoIzq()) + altura(arbol.hijoDer());
        }
    }

    //Ejercicio 7, está bien(Definitivo)
    public static <E> boolean mismaForma(ArbolBinario<E> a, ArbolBinario<E> b) {
        if (a.esVacio() && b.esVacio()) {
            return true;
        } else if (a.esVacio() || b.esVacio()) {
            return false;
        } else {
            return mismaForma(a.hijoIzq(), b.hijoIzq()) && mismaForma(a.hijoDer(), b.hijoDer());
        }
    }

    //Ejercicio 8, está bien(Definitivo)
    public static <E extends Comparable<E>> boolean arbolSeleccion(EnlazadoArbolBinario<E> arbol) {
        if (arbol.esVacio()) {
            return true;
        } else if (esHoja(arbol)) {
            return true;
        } else if (arbol.hijoIzq().esVacio() && !arbol.hijoDer().esVacio()) {
            return arbol.raiz().equals(arbol.hijoDer().raiz()) && arbolSeleccion(arbol.hijoDer());
        } else if (!arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio()) {
            return arbol.raiz().equals(arbol.hijoIzq().raiz()) && arbolSeleccion(arbol.hijoIzq());
        } else {
            E menor;

            if (arbol.hijoIzq().raiz().compareTo(arbol.hijoDer().raiz()) < 0) {
                menor = arbol.hijoIzq().raiz();
            } else {
                menor = arbol.hijoDer().raiz();
            }

            return arbol.raiz().equals(menor) && arbolSeleccion(arbol.hijoIzq()) && arbolSeleccion(arbol.hijoDer());
        }
    }

    //Ejercicio 9, está bien(Definitivo)
    public static <E> boolean esCamino(ArbolBinario<E> arbol, String camino) {
        if (camino.length() == 0) {
            return true;
        } else if (arbol.esVacio()) {
            return false;
        } else if (arbol.raiz().equals(camino.charAt(0))) {
            return esCamino(arbol.hijoIzq(), camino.substring(1)) || esCamino(arbol.hijoDer(), camino.substring(1));
        } else {
            return false;
        }
    }

    //Ejercicio 10, está bien(Definitivo)
    public static <E> EnlazadoArbolBinario<E> copiaHastaNivel(EnlazadoArbolBinario<E> arbol, int nivel) {
        if (arbol.esVacio()) {
            return new EnlazadoArbolBinario<>();
        } else if (nivel == 0) {
            return new EnlazadoArbolBinario<>(arbol.raiz(), new EnlazadoArbolBinario<>(), new EnlazadoArbolBinario<>());
        } else {
            return new EnlazadoArbolBinario<>(arbol.raiz(), copiaHastaNivel(arbol.hijoIzq(), nivel - 1), copiaHastaNivel(arbol.hijoDer(), nivel - 1));
        }
    }

    //Ejercicio 11, esta bien(Definitivo)
    public static <E> void visualizarPalabras(ArbolBinario<E> a) {
        String palabra = "";
        visualizarPalabras(a, palabra);
    }

    private static <E> void visualizarPalabras(ArbolBinario<E> a, String palabra) {
        if (!a.esVacio()) {
            if (a.hijoIzq().esVacio() && a.hijoDer().esVacio()) {
                System.out.println(palabra + a.raiz());
            } else {
                visualizarPalabras(a.hijoIzq(), palabra + a.raiz());
                visualizarPalabras(a.hijoDer(), palabra + a.raiz());
            }
        }
    }

    //Ejercicio 12, está bien(Definitivo)
    public static <E> E padre(ArbolBinario<E> arbol, E elemento) {
        if (arbol.esVacio()) {
            return null;
        } else if (arbol.raiz().equals(elemento)) {
            return null;
        } else if ((!arbol.hijoIzq().esVacio() && arbol.hijoIzq().raiz().equals(elemento))
                || (!arbol.hijoDer().esVacio() && arbol.hijoDer().raiz().equals(elemento))) {
            return arbol.raiz();
        } else {
            E aux = padre(arbol.hijoIzq(), elemento);
            if (aux == null) {
                return padre(arbol.hijoDer(), elemento);
            } else {
                return aux;
            }
        }
    }

    //Ejercicio 13, está bien(Definitivo)
    public static <E> boolean nivelK(ArbolBinario<E> arbol, E elem, int k) {
        if (arbol.esVacio()) {
            return false;
        } else if (arbol.raiz().equals(elem) && k == 0) {
            return true;
        } else if (k == 0) {
            return false;
        } else {
            return nivelK(arbol.hijoIzq(), elem, k - 1) || nivelK(arbol.hijoDer(), elem, k - 1);
        }
    }

    //Métodos complementarios
    public static <E> int numNodos(EnlazadoArbolBinario<E> a) throws ArbolVacioException {
        if (a.esVacio()) {
            return 0;
        } else {
            return (1 + numNodos(a.hijoIzq()) + numNodos(a.hijoDer()));
        }
    }

    public static <E> boolean esHoja(EnlazadoArbolBinario<E> arbol) {
        return arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio();
    }
}
