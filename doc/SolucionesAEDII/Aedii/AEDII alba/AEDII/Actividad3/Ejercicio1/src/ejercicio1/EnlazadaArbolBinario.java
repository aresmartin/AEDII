/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alba
 */
public class EnlazadaArbolBinario<E> implements ArbolBinario{
   public NodoBinario<E> nodoRaiz;
   
   
   public EnlazadaArbolBinario(){
       nodoRaiz = null;
   }
   
   public EnlazadaArbolBinario(NodoBinario<E> nodo){
       nodoRaiz = nodo;
   }
   
   public EnlazadaArbolBinario(E elemento, EnlazadaArbolBinario<E> hi, 
           EnlazadaArbolBinario<E> hd ){
       nodoRaiz = new NodoBinario(elemento, hi.nodoRaiz, hd.nodoRaiz);
       
   }
   
   public boolean esVacio(){
       if(nodoRaiz == null){
           return true;
       }else{
           return false;
       }
   }
   
   public E raiz() throws ArbolVacioExcepcion{
       if(esVacio()){
           throw new ArbolVacioExcepcion();
       }else{
           return nodoRaiz.getElemento();
       }
   }
   
   public ArbolBinario hijoIzq() throws ArbolVacioExcepcion{
       if(esVacio()){
           throw new ArbolVacioExcepcion();
       }else{
           return new EnlazadaArbolBinario(nodoRaiz.getIzq());
       }
   }
   
   public ArbolBinario hijoDer() throws ArbolVacioExcepcion{
       if(esVacio()){
           throw new ArbolVacioExcepcion();
       }else{
           return new EnlazadaArbolBinario(nodoRaiz.getDer());
       }
   }
   
   public boolean esta(Object elemento){
       if(esVacio()){
           return false;
       }else{
           if(nodoRaiz.getElemento().equals(elemento)){
               return true;
           }else{
               try {
                   return hijoIzq().esta(elemento) || hijoDer().esta(elemento);
               } catch (ArbolVacioExcepcion ex) {
                   Logger.getLogger(EnlazadaArbolBinario.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
       return false;
   }

    public void setRaiz(Object elemRaiz) throws ArbolVacioExcepcion {
        nodoRaiz.setElemento((E) elemRaiz);
    }

    public void setHijoIzq(ArbolBinario hi) throws ArbolVacioExcepcion, NullPointerException {
        if(hi == null){
            throw new NullPointerException();
        }
        if(esVacio()){
            throw new ArbolVacioExcepcion();
        }
        
        nodoRaiz.setIzq((NodoBinario<E>) hi);
        
    }


    public void setHijoDer(ArbolBinario hd) throws ArbolVacioExcepcion, NullPointerException {
        if(hd == null){
            throw new NullPointerException();
        }
        if(esVacio()){
            throw new ArbolVacioExcepcion();
        }
        
        nodoRaiz.setDer((NodoBinario<E>) hd);
        
    }

    
    public void suprimir() {
        nodoRaiz = null;
    }
}
