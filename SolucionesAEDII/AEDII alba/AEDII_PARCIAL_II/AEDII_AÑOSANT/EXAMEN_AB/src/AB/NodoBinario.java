/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AB;

/**
 *
 * @author Yo
 */
public class NodoBinario<E> {
    private E elemento;
    private NodoBinario<E> izq;
    private NodoBinario<E> der;
    private NodoBinario<E> padre;
   // private NodoBinario<E> hermano;

    public NodoBinario(E elemento, NodoBinario<E> izq, NodoBinario<E> der,NodoBinario<E> pad/*NodoBinario<E> her*/) {
        this.elemento = elemento;
        this.izq = izq;
        this.der = der;
        this.padre = pad;
       // this.hermano=her;
    }

   /* public NodoBinario<E> getHermano() {
        return hermano;
    }

    public void setHermano(NodoBinario<E> hermano) {
        this.hermano = hermano;
    }*/
    

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

    public NodoBinario<E> getPadre() {
        return padre;
    }

    public void setPadre(NodoBinario<E> padre) {
        this.padre = padre;
    }
    
    
    
}
