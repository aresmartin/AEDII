/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import arbolBinario.ArbolBinario;
import arbolBinario.EnlazadoArbolBinario;
import static java.lang.Math.E;

/**
 *
 * @author Yo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    public static <E> boolean completo(ArbolBinario<E> arbol) {
        if (arbol.esVacio()) {
            return true;
        } else if (arbol.hijoDer().esVacio() && arbol.hijoDer().esVacio()) {
            return true;
        } else if ((!arbol.hijoDer().esVacio() && arbol.hijoDer().esVacio()) || (arbol.hijoDer().esVacio() && !arbol.hijoDer().esVacio())) {
            return false;
        }
        return completo(arbol.hijoDer()) && completo(arbol.hijoIzq());

    }

    public static <E> boolean identicos(ArbolBinario<E> arbol1, ArbolBinario<E> arbol2) {
        if (arbol1.esVacio() && arbol2.esVacio()) {
            return true;
        }
        if (!arbol1.esVacio() && !arbol2.esVacio()) {
            return arbol1.raiz().equals(arbol2.raiz()) && identicos(arbol1.hijoIzq(),
                    arbol2.hijoIzq()) && identicos(arbol1.hijoDer(),
                    arbol2.hijoDer());
        } else {
            return false;
        }
    }

    public static <E> int numNodosNivel(ArbolBinario<E> a, int nivel) {
        if (nivel < 0) {
            return 0;
        }
        if (a.esVacio()) {
            return 0;
        }
        if (nivel == 0) {
            return 1;
        }

        return numNodosNivel(a.hijoIzq(), nivel - 1)
                + numNodosNivel(a.hijoDer(), nivel - 1);

    }

    public static <E> ArbolBinario<E> crearArbolsinHojas(ArbolBinario<E> a) {
        if (a.esVacio() || a.hijoDer().esVacio() && a.hijoIzq().esVacio()) {
            return new EnlazadoArbolBinario<>();
        } else {
            return new EnlazadoArbolBinario<>(a.raiz(), crearArbolsinHojas(a.hijoDer()),
                    crearArbolsinHojas(a.hijoIzq()));
        }

    }

    public static <E> int alturaArbol(ArbolBinario<E> a) {
        if (a.esVacio()) {
            return -1;
        }
        int izquierda = alturaArbol(a.hijoIzq());
        int derecha = alturaArbol(a.hijoDer());
        if (izquierda > derecha) {
            return izquierda + 1;
        } else {
            return derecha + 1;
        }

    }

    public static <E> boolean mismaForma(ArbolBinario<E> a, ArbolBinario<E> b) {
        if (a.esVacio() && b.esVacio()) {
            return true;
        }
        if (!a.esVacio() && !b.esVacio()) {
            return mismaForma(a.hijoDer(), b.hijoDer()) && mismaForma(a.hijoIzq(),
                    b.hijoIzq());
        } else {
            return false;
        }
    }
    public static <E extends Comparable<E>> boolean arbolSeleccion(ArbolBinario<E> a){
        if(a.esVacio())return true;
        if(a.hijoIzq().esVacio()&&a.hijoDer().esVacio())return true;
        if(a.hijoIzq().esVacio()){
            return a.raiz().equals(a.hijoDer().raiz())&& arbolSeleccion(a.hijoDer());
        }
        if(a.hijoDer().esVacio()){
            return a.raiz().equals(a.hijoIzq().raiz())&& arbolSeleccion(a.hijoIzq());
        }
        E raizhi=a.hijoIzq().raiz();
        E raizhd=a.hijoDer().raiz();
        E menor= (raizhi.compareTo(raizhd)>0)?raizhd:raizhi;
        return a.raiz().equals(menor) && arbolSeleccion(a.hijoIzq())&&arbolSeleccion(a.hijoDer());
        
    }
    public static <E> boolean esCamino(ArbolBinario<E> arbol, String camino){
       if(camino.length()==0)return true;
       if(arbol.esVacio())return false;
       return arbol.raiz().equals(camino.charAt(0))&&
               esCamino(arbol.hijoIzq(),camino.substring(1))&&
               esCamino(arbol.hijoDer(),camino.substring(1));
        
        
    }
}
