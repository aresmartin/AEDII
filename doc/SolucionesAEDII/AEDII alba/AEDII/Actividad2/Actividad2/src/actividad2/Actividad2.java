/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad2;

import arbolBinario.ArbolBinario;
import arbolBinario.EnlazadoArbolBinario;

/**
 *
 * @author Alba
 */
public class Actividad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    //EJERCICIO 1
    public static <E> boolean completo (ArbolBinario<E> a){
        if (a.esVacio()) {
            return true;
        }else{
            if ((a.hijoIzq().esVacio() && !a.hijoDer().esVacio())
                || (!a.hijoIzq().esVacio() && a.hijoDer().esVacio())) {
            return false;
        }else return completo(a.hijoIzq()) && completo(a.hijoDer());
        }
    }
            
    
    //EJERCICIO 2
    public static <E> boolean identicos(ArbolBinario<E> a, ArbolBinario<E> b) {
        if(a.esVacio() && b.esVacio()){
            return true;
        }else if(a.esVacio() || b.esVacio() ){
            return false;
        }else if (a.raiz().equals(b.raiz())){
            return identicos(a.hijoDer(), b.hijoDer()) && identicos(a.hijoIzq(), b.hijoDer());
        }else return false;

    }
   

    //EJERCICIO 3
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
    public static <E> int altura(ArbolBinario<E> a) {
        if (a.esVacio() || a.hijoIzq().esVacio() && a.hijoDer().esVacio())return -1;
        int izquierda = altura(a.hijoIzq());
        int derecha = altura(a.hijoDer());
        if (izquierda > derecha)return izquierda + 1;
        else return derecha + 1;
        
    }

    
           
}
