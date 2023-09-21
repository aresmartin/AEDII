/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3;

/**
 *
 * @author Yo
 */
public class EnlazadoArbolBinario<E> implements ArbolBinario<E> {

    private NodoBinario<E> nodo;

    public EnlazadoArbolBinario() {
        nodo = null;
    }

    public EnlazadoArbolBinario(E elemento, ArbolBinario<E> hi, ArbolBinario<E> hd) throws NullPointerException {
        if (hi == null || hd == null) {
            throw new NullPointerException();
        }
        NodoBinario izq = ((EnlazadoArbolBinario) hi).nodo;
        NodoBinario der = ((EnlazadoArbolBinario) hd).nodo;
        nodo = new NodoBinario<E>(elemento, izq, der);
    }

    private EnlazadoArbolBinario(NodoBinario<E> nod) {
        nodo = nod;
    }

    @Override
    public boolean esVacio() {
        return nodo == null;
    }

    @Override
    public E raiz() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("error");
        }
        return nodo.getElemento();
    }

    @Override
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("");
        }
        return new EnlazadoArbolBinario(nodo.getIzq());

    }

    @Override
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("");
        }
        return new EnlazadoArbolBinario(nodo.getDer());
    }

    @Override
    public boolean esta(E elemento) {
        if (esVacio()) {
            return false;
        }
        if (nodo.getElemento() == elemento) {
            return true;
        }
        return hijoDer().esta(elemento) || hijoIzq().esta(elemento);
    }

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("[ERROR] raiz: Arbol vacio");
        }
        nodo.setElemento(elemRaiz);
    }

    @Override
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException {
        if (hi == null) {
            throw new NullPointerException("");
        }
        if (esVacio()) {
            throw new ArbolVacioExcepcion("");
        }
        EnlazadoArbolBinario izq = new EnlazadoArbolBinario(hi.raiz(), hi.hijoIzq(), hi.hijoDer());
        nodo.setIzq(izq.nodo);
    }

    @Override
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException {
        if (hd == null) {
            throw new NullPointerException("");
        }
        if (esVacio()) {
            throw new ArbolVacioExcepcion("");
        }

        EnlazadoArbolBinario der = new EnlazadoArbolBinario(hd.raiz(), hd.hijoIzq(), hd.hijoDer());
        nodo.setDer(der.nodo);
    }

    @Override
    public void suprimir() {
        nodo = null;
    }

}
