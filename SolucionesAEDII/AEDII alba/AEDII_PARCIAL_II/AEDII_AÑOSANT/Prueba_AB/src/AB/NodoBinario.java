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
    private E raiz;
    private NodoBinario<E> hi;
    private NodoBinario<E> hd;
    
    public NodoBinario(E elem,NodoBinario<E> hi,NodoBinario<E> hd){
        raiz=elem;
        this.hi=hi;
        this.hd=hd;
    }
    public E getElemento(){
        return raiz;
    }
    public NodoBinario<E> getIzquierda(){
        return hi;
    }
    public NodoBinario<E> getDerecha(){
        return hd;
    }
    public void setElemento(E el){
        raiz=el;
    }
    public void setIzquierdo(NodoBinario<E> izq){
        hi=izq;
    }
    public void setDerecho(NodoBinario<E> der){
        hd=der;
    }
}
