/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author Yo
 */
public class NodoBinario<E> {

    private E elemento;
    private NodoBinario<E> izq;
    private NodoBinario<E> der;

    public NodoBinario(E e, NodoBinario<E> hi, NodoBinario<E> hd) {
        this.elemento = e;
        this.izq = hi;
        this.der = hd;
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

    public void setElemento(E e) {
        this.elemento = e;
    }

    public void setDer(NodoBinario<E> hd) {
        this.der = hd;
    }

    public void setIzq(NodoBinario<E> hi) {
        this.izq = hi;
    }

}
