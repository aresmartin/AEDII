/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author Alba
 */
public class NodoBinario {
    private E elemento;
    private NodoBinario<E> izq;
    private NodoBinario<E> der;

    public NodoBinario() {
        elemento = null;
        izq = null;
        der = null;
    }
    
    public NodoBinario(E raiz, NodoBinario<E> izq, NodoBinario<E> der){
        elemento = raiz;
        this.der = der;
        this.izq = izq;
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

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public void setIzq(NodoBinario<E> izq) {
        this.izq = izq;
    }

    public void setDer(NodoBinario<E> der) {
        this.der = der;
    }

    
}
