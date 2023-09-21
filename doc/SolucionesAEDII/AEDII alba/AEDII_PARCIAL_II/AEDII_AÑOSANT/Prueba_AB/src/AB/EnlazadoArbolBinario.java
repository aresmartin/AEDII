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
public class EnlazadoArbolBinario<E> implements ArbolBinario<E> {

    private NodoBinario<E> nodoRaiz;
    
    public EnlazadoArbolBinario(){
        nodoRaiz=null;
    }
    public EnlazadoArbolBinario(E elemento,ArbolBinario<E> hi,ArbolBinario<E> hd) throws NullPointerException{
        if(hi==null || hd==null){
            throw new NullPointerException("");
        }
        NodoBinario izq = ((EnlazadoArbolBinario)hi).nodoRaiz;
        NodoBinario der = ((EnlazadoArbolBinario)hd).nodoRaiz;
        nodoRaiz= new NodoBinario<>(elemento,izq,der); 
       
    }
    private EnlazadoArbolBinario(NodoBinario<E> nodo){
        nodoRaiz=nodo;
    }
    
    @Override
    public boolean esVacio() {
        return nodoRaiz==null;
    }

    @Override
    public E raiz() throws ArbolVacioException {
        if(this.esVacio()){
            throw new ArbolVacioException("");
        }
        return nodoRaiz.getElemento();


    }

    @Override
    public EnlazadoArbolBinario<E> hijoIzq() throws ArbolVacioException {
        if(this.esVacio()){
            throw new ArbolVacioException("");
        }
        return new EnlazadoArbolBinario(nodoRaiz.getIzquierda());
    }

    @Override
    public EnlazadoArbolBinario<E> hijoDer() throws ArbolVacioException {
        if(esVacio()){
          throw new ArbolVacioException("");
        }
        return new EnlazadoArbolBinario(nodoRaiz.getDerecha());
    }

    @Override
    public boolean esta(E elemento) {
        if(esVacio()){
            return false;
        }
        else if(nodoRaiz.getElemento().equals(elemento)){
            return true;
        }
        return this.hijoDer().esta(elemento) || this.hijoIzq().esta(elemento);
        
    }

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioException {
        if(esVacio()){
            throw new ArbolVacioException("");
        }
        nodoRaiz.setElemento(elemRaiz);
    }

    @Override
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioException, NullPointerException {
        if(hi==null){
            throw new NullPointerException("");
        }
        else if(esVacio()){
            throw new ArbolVacioException("");
        }
        EnlazadoArbolBinario izq= new EnlazadoArbolBinario(hi.raiz(),hi.hijoIzq(),hi.hijoDer());
        nodoRaiz.setIzquierdo(izq.nodoRaiz);

    }

    @Override
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioException, NullPointerException {
         if(hd==null){
            throw new NullPointerException("");
        }
        else if(esVacio()){
            throw new ArbolVacioException("");
        }
         EnlazadoArbolBinario der = new EnlazadoArbolBinario(hd.raiz(),hd.hijoIzq(),hd.hijoDer());
         nodoRaiz.setDerecho(der.nodoRaiz);

    }

    @Override
    public void suprimir() {
        nodoRaiz=null;
    }
    
}
