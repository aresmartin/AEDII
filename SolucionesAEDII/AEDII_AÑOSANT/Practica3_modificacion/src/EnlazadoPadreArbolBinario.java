/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import arbolBinario.ArbolVacioExcepcion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yo
 */
public class EnlazadoPadreArbolBinario<E> implements ArbolBinario<E> {

    private NodoBinario<E> nodoRaiz;

    public EnlazadoPadreArbolBinario() {
        this.nodoRaiz = null;
        //new EnlazadoArbolBinarrio<E>(null,null,null);
    }

    public EnlazadoPadreArbolBinario(E elemRaiz, ArbolBinario<E> hi, ArbolBinario<E> hd) throws NullPointerException {

        if (hi == null || hd == null) {
            throw new NullPointerException();
        }
        NodoBinario izq = ((EnlazadoPadreArbolBinario) hi).nodoRaiz;
        //otra manera NodoBinario der=((EnlazadoArbolBinario)hd).nodoRaiz;
        EnlazadoPadreArbolBinario d = (EnlazadoPadreArbolBinario) hd;
        NodoBinario der = d.nodoRaiz;
        //EnlazadoPadreArbolBinario p = (EnlazadoPadreArbolBinario) padre;
        //NodoBinario pad = d.nodoRaiz;
        nodoRaiz = new NodoBinario<>(elemRaiz, izq, der,null);

        /* esto esta mal 
        this.nodoRaiz.setElemento(elemRaiz);
        this.nodoRaiz.getIzq().setElemento(hi.raiz());
        this.nodoRaiz.getDer().setElemento(hd.raiz());
         */
    }

    //constructor privado que convierta el Nodo en enlazadoArboll
    //para usar en el hijoIzq/hijoDer
    private EnlazadoPadreArbolBinario(NodoBinario<E> nodo) {
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
            throw new ArbolVacioExcepcion("[ERROR] raiz: Arbol vacio");
        }
        return nodoRaiz.getElemento();
    }

    @Override
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("[ERROR] hijoIzq: Arbol vacio");
        }
        return new EnlazadoPadreArbolBinario<>(nodoRaiz.getIzq());

    }

    @Override
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
        if (this.esVacio()) {
            throw new ArbolVacioExcepcion("[ERROR] hijoDer: Arbol vacio");
        }
        return new EnlazadoPadreArbolBinario<>(nodoRaiz.getDer());

    }
   /* public ArbolBinario<E> Padre() throws ArbolVacioExcepcion {
        if (this.esVacio()) {
            throw new ArbolVacioExcepcion("[ERROR] hijoDer: Arbol vacio");
        }
        return new EnlazadoPadreArbolBinario<>(nodoRaiz.getPadre());

    }*/
    //tiene que ser recursivo

    @Override
    public boolean esta(E elemento) {
        if (esVacio()) {
            return false;
        }
        if (nodoRaiz.getElemento() == elemento) {
            return true;
        }
        return hijoDer().esta(elemento) || hijoIzq().esta(elemento);
    }

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("[ERROR] raiz: Arbol vacio");
        }
        nodoRaiz.setElemento(elemRaiz);
    }

    @Override
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException {
        if (hi == null) {

            throw new NullPointerException("[ERROR] hi: valor nulo");

        }
        if (esVacio()) {
            throw new ArbolVacioExcepcion("[ERROR] hijoIzq: Arbol vacio");
        }
        EnlazadoPadreArbolBinario izq = new EnlazadoPadreArbolBinario(hi.raiz(),hi.hijoIzq(),hi.hijoDer());
        nodoRaiz.setIzq(izq.nodoRaiz);
    }

    @Override
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException {
        if (hd== null) {
            throw new NullPointerException("[ERROR] hd: valor nulo");
        }
        if (esVacio()) {
            throw new ArbolVacioExcepcion("[ERROR] hijoDer: Arbol vacio");
        }

        EnlazadoPadreArbolBinario der = new EnlazadoPadreArbolBinario(hd.raiz(),hd.hijoIzq(),hd.hijoDer());
        nodoRaiz.setDer(der.nodoRaiz);

    }

    @Override
    public void suprimir() {
        nodoRaiz=null;
    }

}
