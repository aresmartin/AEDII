/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Yo
 */
public class NodoBinario<E> {

    private E elemento;
    private NodoBinario<E> izq;
    private NodoBinario<E> der;
    private NodoBinario<E> padre;

    public NodoBinario(E e, NodoBinario<E> hi, NodoBinario<E> hd,NodoBinario<E> padre) {
        this.elemento = e;
        this.izq = hi;
        this.der = hd;
        this.padre = padre;
    }

    public E getElemento() {
        return elemento;
    }

    public NodoBinario<E> getIzq() {
        return izq;
    }

    public NodoBinario<E> getDer() {
        return der;
    }
    public NodoBinario<E> getPadre() {
        return padre;
    }

    public void setElemento(E e) {
        this.elemento = e;
    }

    public void setDer(NodoBinario<E> hd) {
        this.der = hd;
    }

    public void setIzq(NodoBinario<E> hi) {
        this.izq = hi;
    }
    public void setPadre(NodoBinario<E> padre) {
        this.padre = padre;
    }

}
