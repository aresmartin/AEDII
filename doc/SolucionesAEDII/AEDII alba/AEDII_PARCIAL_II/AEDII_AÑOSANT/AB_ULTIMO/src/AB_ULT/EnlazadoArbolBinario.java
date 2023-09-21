/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AB_ULT;

/**
 *
 * @author Yo
 */
public class EnlazadoArbolBinario<E> implements ArbolBinario<E> {

    private NodoBinario<E> nodo;

    public EnlazadoArbolBinario() {
        nodo = null;
    }

    public EnlazadoArbolBinario(E elem, EnlazadoArbolBinario<E> hi, EnlazadoArbolBinario<E> hd) throws NullPointerException {
        if (hi == null || hd == null) {
            throw new NullPointerException("");
        }

        nodo = new NodoBinario(elem, hi.nodo, hd.nodo);

    }

    private EnlazadoArbolBinario(NodoBinario<E> nodob) {
        nodo = nodob;
    }

    @Override
    public boolean esVacio() {
        return nodo == null;
    }

    @Override
    public E raiz() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("");
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
        if (nodo.getElemento().equals(elemento)) {
            return true;
        }
        return hijoDer().esta(elemento) || hijoIzq().esta(elemento);
    }

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion("");
        }
        nodo.setElemento(elemRaiz);

    }

    @Override
    public void setHijoIzq(EnlazadoArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException {
        if (hi == null) {
            throw new NullPointerException("");
        }
        if (esVacio()) {
            throw new ArbolVacioExcepcion("");
        }
        nodo.setIzq(((EnlazadoArbolBinario<E>) hi).nodo);
    }

    @Override
    public void setHijoDer(EnlazadoArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException {
        if (hd == null) {
            throw new NullPointerException("");
        }
        if (esVacio()) {
            throw new ArbolVacioExcepcion("");
        }
        nodo.setDer(((EnlazadoArbolBinario<E>) hd).nodo);
    }

    @Override
    public void suprimir() {
        this.nodo = null;
    }

}
