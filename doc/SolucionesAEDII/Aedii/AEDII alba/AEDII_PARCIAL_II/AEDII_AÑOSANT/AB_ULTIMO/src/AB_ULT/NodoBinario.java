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
public class NodoBinario<E> {
    private E elemento;
    private NodoBinario<E> izq;
    private NodoBinario<E> der;

    public NodoBinario(E elemento, NodoBinario<E> izq, NodoBinario<E> der) {
        this.elemento = elemento;
        this.izq = izq;
        this.der = der;
    }



    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public NodoBinario<E> getIzq() {
        return izq;
    }

    public void setIzq(NodoBinario<E> izq) {
        this.izq = izq;
    }

    public NodoBinario<E> getDer() {
        return der;
    }

    public void setDer(NodoBinario<E> der) {
        this.der = der;
    }
    
    
}
