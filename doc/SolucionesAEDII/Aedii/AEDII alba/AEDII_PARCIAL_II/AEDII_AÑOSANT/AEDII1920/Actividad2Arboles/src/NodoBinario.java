

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author svsemeria_ESEI
 */
public class NodoBinario<E> {

    private E elem;//Elemento contenido en el nodo
    private NodoBinario<E> izq; //referencia al nodo izquierdo
    private NodoBinario<E> der; //referencia al nodo derecho

    public NodoBinario(E elemento, NodoBinario<E> izquierdo, NodoBinario<E> derecho) {
        elem = elemento;
        izq = izquierdo;
        der = derecho;
    }
    
    public NodoBinario(){
        elem = null;
        izq = null;
        der = null;
    }
    
    public NodoBinario(E elemento){
        elem = elemento;
    }

    public E getElem() {
        return elem;
    }

    public NodoBinario<E> getIzq() {
        return izq;
    }

    public NodoBinario<E> getDer() {
        return der;
    }

    public void setElem(E elemento) {
        elem = elemento;
    }

    public void setIzq(NodoBinario<E> izquierdo) {
        izq = izquierdo;
    }

    public void setDer(NodoBinario<E> derecho) {
        der = derecho;
    }

}
