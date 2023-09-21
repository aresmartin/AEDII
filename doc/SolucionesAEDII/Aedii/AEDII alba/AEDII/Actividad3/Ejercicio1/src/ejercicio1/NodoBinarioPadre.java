/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author Alba
 */
public class NodoBinarioPadre <E> {
    private E elemento;
    private NodoBinarioPadre <E> izq;
    private NodoBinarioPadre <E> der;
    private NodoBinarioPadre <E> padre;

    public NodoBinarioPadre() {
        elemento = null;
        izq = null;
        der = null;
        padre = null;
    }
    
    public NodoBinarioPadre(E raiz, NodoBinarioPadre<E> izq, NodoBinarioPadre<E> der, NodoBinarioPadre<E> padre){
        elemento = raiz;
        this.der = der;
        this.izq = izq;
        this.padre = padre;
    }

    public E getElemento() {
        return elemento;
    }

    public NodoBinarioPadre<E> getIzq() {
        return izq;
    }

    public NodoBinarioPadre<E> getDer() {
        return der;
    }

    public NodoBinarioPadre<E> getPadre() {
        return padre;
    }

    public void setPadre(NodoBinarioPadre<E> padre) {
        this.padre = padre;
    }
    

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public void setIzq(NodoBinarioPadre<E> izq) {
        this.izq = izq;
    }

    public void setDer(NodoBinarioPadre<E> der) {
        this.der = der;
    }
    
}
