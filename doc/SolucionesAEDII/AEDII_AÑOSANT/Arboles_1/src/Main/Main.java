/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import arbolBinario.ArbolBinario;
import arbolBinario.EnlazadoArbolBinario;
import cola.Cola;
import cola.EnlazadaCola;

/**
 *
 * @author Yo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    //EJERCICIO 1
    public static <E> boolean completo(ArbolBinario<E> a) {
        if (a.esVacio()) {
            return true;
        }
        if (a.hijoIzq().esVacio() && a.hijoDer().esVacio()) {
            return true;
        }
        if ((a.hijoIzq().esVacio() && !a.hijoDer().esVacio())
                || (!a.hijoIzq().esVacio() && a.hijoDer().esVacio())) {
            return true;
        }
        return completo(a.hijoIzq()) && completo(a.hijoDer());
    }

    //EJERCICIO 2
    public static <E> boolean identicos(ArbolBinario<E> a, ArbolBinario<E> b) {
        if (!a.esVacio() && !b.esVacio()) {
            return a.raiz().equals(b.raiz()) && identicos(a.hijoDer(), b.hijoDer())
                    && identicos(a.hijoIzq(), b.hijoIzq());
        }
        if (a.esVacio() && b.esVacio()) {
            return true;
        } else {
            return false;
        }

    }

    //EJERCICIO 3
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
    //EJERCICIO 4

    public static <E> ArbolBinario<E> copiaSinHojas(ArbolBinario<E> a) {
        if (a.esVacio() || (a.hijoDer().esVacio() && a.hijoIzq().esVacio())) {
            return new EnlazadoArbolBinario<>();
        } else {
            return new EnlazadoArbolBinario<>(a.raiz(),
                    copiaSinHojas(a.hijoIzq()), copiaSinHojas(a.hijoDer()));
        }

    }

//EJERCICIO 5
/*ESTÁ MAL CREO
public static <E> int altura(ArbolBinario<E> a) {
        Cola<ArbolBinario<E>> c = new EnlazadaCola<>();
        int contador=0;
        c.insertar(a);
        do {
            a = c.suprimir();
            if (!a.esVacio()) {
                System.out.print(a.raiz() + " ");
                c.insertar(a.hijoIzq());
                c.insertar(a.hijoDer());
                contador++;
            }
        } while (!c.esVacio());
        return contador;
    }*/
    public static <E> int altura(ArbolBinario<E> a) {
        if (a.esVacio())return -1;
        int izquierda = altura(a.hijoIzq());
        int derecha = altura(a.hijoDer());
        if (izquierda > derecha)return izquierda + 1;
        else return derecha + 1;
        
        // return (izquierda>derecha)? iquierda+1 : derecha+1;
    }

    //EJERCICIO 6 (igual ejercicio 2)
    public static <E> boolean mismaForma(ArbolBinario<E> a, ArbolBinario<E> b) {
        if(a.esVacio()&& b.esVacio())return true;
         if (!a.esVacio() && !b.esVacio()) {
            return mismaForma(a.hijoDer(), b.hijoDer())
                    && mismaForma(a.hijoIzq(), b.hijoIzq());
        }
         else return false;
        
    }
    
    //EJERCICIO 7
    public static <E extends Comparable<E>> boolean arbolSeleccion (ArbolBinario<E> a){
        if(a.esVacio()) return true;
        if(a.hijoIzq().esVacio() && a.hijoDer().esVacio())return true;
        if(a.hijoIzq().esVacio()) 
            return a.raiz().equals(a.hijoDer().raiz()) && arbolSeleccion(a.hijoDer());
        if(a.hijoDer().esVacio()) 
            return a.raiz().equals(a.hijoIzq().raiz()) && arbolSeleccion(a.hijoIzq());
        E raizHi = a.hijoIzq().raiz();
        E raizHd = a.hijoDer().raiz();
        E menor = (raizHi.compareTo(raizHd)>0)? raizHd : raizHi;
        return a.raiz().equals(menor) && arbolSeleccion(a.hijoIzq())&& arbolSeleccion(a.hijoDer());
        
        
    }
    
    //EJERCICIO 8
    public static  boolean esCamino(ArbolBinario<Character> a, String camino){
        if(camino.length()==0) return true;
        if(a.esVacio())return false;
        return a.raiz().equals(camino.charAt(0)) && 
                (esCamino(a.hijoIzq(),camino.substring(1))|| 
                esCamino(a.hijoDer(),camino.substring(1)));
    }
 
    
    /*EJERCICIO 9 hecho por mi no se si esta bien
    public static <E> ArbolBinario<E> copiaHastaNivel(ArbolBinario<E> a, int nivel){
        if(a.esVacio())return new EnlazadoArbolBinario<E>();
        if(nivel==0) return a;
        if(!a.esVacio()&&(a.hijoDer().esVacio()&&a.hijoIzq().esVacio()))
            return new EnlazadoArbolBinario<E>(a.raiz(),null,null);
        if(!a.esVacio()&&!a.hijoDer().esVacio()&& a.hijoIzq().esVacio())
            return new EnlazadoArbolBinario<E>(a.raiz(),a.hijoDer(),null);
        if(!a.esVacio()&&a.hijoDer().esVacio()&& !a.hijoIzq().esVacio())
            return new EnlazadoArbolBinario<E>(a.raiz(),null,a.hijoIzq());
        
        return copiaHastaNivel(a,nivel-1);
    }*/
        public static <E> ArbolBinario<E> copiaHastaNivel(ArbolBinario<E> arbol, int nivel) {
        if (arbol.esVacio()) {
            return new EnlazadoArbolBinario<>();
        } else if (nivel == 0) {
            return new EnlazadoArbolBinario<>(arbol.raiz(), new EnlazadoArbolBinario<>(), new EnlazadoArbolBinario<>());
        } else {
            return new EnlazadoArbolBinario<>(arbol.raiz(), copiaHastaNivel(arbol.hijoIzq(), nivel - 1), copiaHastaNivel(arbol.hijoDer(), nivel - 1));
        }
    }

    //EJERCICIO 10 hecho por mi no se si esta bien
    public static  void visualizarPalabras(ArbolBinario<String> a) {
        String palabra = "";
        visualizarPalabras (a, palabra);
}
    private static  void visualizarPalabras(ArbolBinario<String> a, String palabra){
        if(a.esVacio()) palabra="";
        if(!a.esVacio() && !a.hijoDer().esVacio() && a.hijoIzq().esVacio())
        palabra+=a.hijoDer().raiz();
        if(!a.esVacio() && a.hijoDer().esVacio() && !a.hijoIzq().esVacio())
        palabra+=a.hijoIzq().raiz();
        else{
        visualizarPalabras(a.hijoDer(),palabra);
        visualizarPalabras(a.hijoIzq(),palabra);
        }
        
        
    }
     //ej 11 avacio, no tiene raiz no tiene,comprobar si elem es hd o hi de raiz
    //ej 12 por hacer
    //ej voluntario 
}
    
   

