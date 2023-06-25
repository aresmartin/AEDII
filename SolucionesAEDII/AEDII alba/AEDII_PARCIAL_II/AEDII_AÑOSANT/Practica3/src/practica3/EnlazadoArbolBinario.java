/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import arbolBinario.ArbolVacioExcepcion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yo
 */
public class EnlazadoArbolBinario<E> implements ArbolBinario<E> {

    private NodoBinario<E> nodoRaiz;

    public EnlazadoArbolBinario() {
        this.nodoRaiz = null;
        //new EnlazadoArbolBinarrio<E>(null,null,null);
    }

    public EnlazadoArbolBinario(E elemRaiz, EnlazadoArbolBinario<E> hi, EnlazadoArbolBinario<E> hd) throws NullPointerException {

        if (hi == null || hd == null) {
            throw new NullPointerException();
        }
       /* NodoBinario izq = ((EnlazadoArbolBinario) hi).nodoRaiz;
        //otra manera NodoBinario der=((EnlazadoArbolBinario)hd).nodoRaiz;
        EnlazadoArbolBinario d = (EnlazadoArbolBinario) hd;
        NodoBinario der = d.nodoRaiz;
        nodoRaiz = new NodoBinario<>(elemRaiz, izq, der);

        /* esto esta mal 
        this.nodoRaiz.setElemento(elemRaiz);
        this.nodoRaiz.getIzq().setElemento(hi.raiz());
        this.nodoRaiz.getDer().setElemento(hd.raiz());
         */
       nodoRaiz = new NodoBinario<>(elemRaiz, hi.nodoRaiz, hd.nodoRaiz);
    }

    //constructor privado que convierta el Nodo en enlazadoArboll
    //para usar en el hijoIzq/hijoDer
    private EnlazadoArbolBinario(NodoBinario<E> nodo) {
        nodoRaiz = nodo;
    }

    @Override
    public boolean esVacio() {
        /* if (nodoRaiz == null) {
            return true;
        }
        return false;*/
        return nodoRaiz == null;
    }

    @Override
    public E raiz() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioException("[ERROR] raiz: Arbol vacio");
        }
        return nodoRaiz.getElemento();
    }

    @Override
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioException("[ERROR] hijoIzq: Arbol vacio");
        }
        return new EnlazadoArbolBinario<>(nodoRaiz.getIzq());

    }

    @Override
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
        if (this.esVacio()) {
            throw new ArbolVacioException("[ERROR] hijoDer: Arbol vacio");
        }
        return new EnlazadoArbolBinario<>(nodoRaiz.getDer());

    }
    //tiene que ser recursivo

    @Override
    public boolean esta(E elemento) {
        if(this.esVacio()){
            return false;
        }
        if (nodoRaiz.getElemento() == elemento) {
            return true;
        }
        return this.hijoDer().esta(elemento) || this.hijoIzq().esta(elemento);
        
        
        /*
        if (nodoRaiz.getDer().getElemento() == elemento) {
            return true;
        }
        if (nodoRaiz.getIzq().getElemento() == elemento) {
            return true;
        }
        return false;*/
    }

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioException("[ERROR] raiz: Arbol vacio");
        }
        nodoRaiz.setElemento(elemRaiz);
    }

    @Override
    public void setHijoIzq(EnlazadoArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException {
        if (hi == null) {

            throw new NullPointerException("[ERROR] hi: valor nulo");

        }
        if (esVacio()) {
            throw new ArbolVacioException("[ERROR] hijoIzq: Arbol vacio");
        }

        nodoRaiz.setIzq(hi.nodoRaiz);
    }

    @Override
    public void setHijoDer(EnlazadoArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException {
        if (hd== null) {
            throw new NullPointerException("[ERROR] hd: valor nulo");
        }
        if (esVacio()) {
            throw new ArbolVacioException("[ERROR] hijoDer: Arbol vacio");
        }

       
        nodoRaiz.setDer(hd.nodoRaiz);

    }

    public void suprimir() {
        nodoRaiz=null;
    }

}
