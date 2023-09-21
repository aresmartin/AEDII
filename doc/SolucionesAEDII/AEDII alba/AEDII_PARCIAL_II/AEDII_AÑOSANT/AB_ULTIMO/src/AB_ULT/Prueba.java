/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AB_ULT;

import cola.Cola;
import cola.EnlazadaCola;

/**
 *
 * @author Yo
 */
public class Prueba {
    public static void main(String[] args) {
        
        EnlazadoArbolBinario arbol = new EnlazadoArbolBinario("m", new EnlazadoArbolBinario(), new EnlazadoArbolBinario());
        EnlazadoArbolBinario arbol1 = new EnlazadoArbolBinario(44, new EnlazadoArbolBinario(), new EnlazadoArbolBinario());

        arbol.setHijoIzq(new EnlazadoArbolBinario("l", new EnlazadoArbolBinario(), new EnlazadoArbolBinario()));
        arbol.setHijoDer(new EnlazadoArbolBinario("o", new EnlazadoArbolBinario(), new EnlazadoArbolBinario()));

        //System.out.println(esCamino(arbol, "mlo"));
        
        
    }
    
    public static <E> void Anchura(EnlazadoArbolBinario<E> a){
        Cola<EnlazadoArbolBinario> c=new EnlazadaCola<>();
        c.insertar(a);
        do{
            a=c.suprimir();
            if(!a.esVacio()){
                System.out.println(a.raiz());
                c.insertar((EnlazadoArbolBinario) a.hijoIzq());
                c.insertar((EnlazadoArbolBinario) a.hijoDer());
            }
        }while(!c.esVacio());
        
        
    }
    public static <E> int numNodos(EnlazadoArbolBinario<E> a){
        if(a.esVacio())return 0;
        return 1 + numNodos((EnlazadoArbolBinario<E>) a.hijoIzq())+numNodos((EnlazadoArbolBinario<E>) a.hijoDer());
    }
    public static <E> int numHojas(EnlazadoArbolBinario<E>a){
        if(a.esVacio())return 0;
        else if(a.hijoDer().esVacio()&&a.hijoIzq().esVacio())return 1;
        return numHojas((EnlazadoArbolBinario<E>) a.hijoDer())+numHojas((EnlazadoArbolBinario<E>) a.hijoIzq());
    }
    
    public static<E> boolean degenerado(EnlazadoArbolBinario<E> a){
        if(a.esVacio())return true;
        else if(a.hijoIzq().esVacio()&&a.hijoDer().esVacio())return true;
        else if(!a.hijoIzq().esVacio()&&!a.hijoDer().esVacio())return false;
        return degenerado((EnlazadoArbolBinario<E>) a.hijoIzq()) && degenerado((EnlazadoArbolBinario<E>) a.hijoDer());
        
    }
    public static <E> EnlazadoArbolBinario<E> copia(EnlazadoArbolBinario<E>a){
        if(a.esVacio())return new EnlazadoArbolBinario();
        return new EnlazadoArbolBinario(a.raiz(),copia((EnlazadoArbolBinario<E>) a.hijoIzq()),copia((EnlazadoArbolBinario<E>) a.hijoDer()));
    }
    
    public static <E> boolean completo(EnlazadoArbolBinario<E> a){
        if(a.esVacio())return true;
        else if(a.hijoIzq().esVacio()&&a.hijoDer().esVacio())return true;
        else if(!a.hijoIzq().esVacio()&& a.hijoDer().esVacio()||
                !a.hijoIzq().esVacio()&& a.hijoDer().esVacio())return false;
        return completo((EnlazadoArbolBinario<E>) a.hijoIzq())&&completo((EnlazadoArbolBinario<E>) a.hijoDer());
    }
}
