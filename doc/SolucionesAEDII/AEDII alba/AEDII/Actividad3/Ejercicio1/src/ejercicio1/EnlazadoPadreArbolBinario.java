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
public class EnlazadoPadreArbolBinario <E> implements ArbolBinario<E> {
    private NodoBinarioPadre<E> nodoRaiz;
    
    public EnlazadoPadreArbolBinario(){
        nodoRaiz = null;
    }
    
    public EnlazadoPadreArbolBinario(NodoBinarioPadre<E> nodo){
        nodoRaiz = nodo;
    }
    
    public EnlazadoPadreArbolBinario(E elemento, EnlazadoPadreArbolBinario hi, 
            EnlazadoPadreArbolBinario hd){
        if(hi == null || hd == null){
            throw new NullPointerException();
        }
        
        nodoRaiz = new NodoBinarioPadre<E>(elemento, hi.nodoRaiz, hd.nodoRaiz, null);
        
           if(hi.nodoRaiz != null) hi.nodoRaiz.setPadre(nodoRaiz);
           if(hd.nodoRaiz != null ) hd.nodoRaiz.setPadre(nodoRaiz);
    }
    

    public boolean esVacio() {
        if(nodoRaiz == null){
            return true;
        }else{
            return false;
        }
    }
    

    public E raiz() throws ArbolVacioExcepcion {
        if(esVacio()){
            throw new ArbolVacioExcepcion();
        }
        
        return nodoRaiz.getElemento();
    }

    
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
        if(esVacio()){
            throw new ArbolVacioExcepcion();
        }
        
        return new EnlazadoPadreArbolBinario(nodoRaiz.getIzq());
    }

    
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
        if(esVacio()){
            throw new ArbolVacioExcepcion();
        }
        
        return new EnlazadoPadreArbolBinario(nodoRaiz.getDer());
    }

    public boolean esta(E elemento) {
        if(esVacio()){
            return false;
        }else{
            if(nodoRaiz.getElemento() == elemento){
                return true;
            }else{
                try {
                    if(!hijoIzq().esVacio() || !hijoDer().esVacio()){
                        return hijoDer().esta(elemento) || hijoIzq().esta(elemento);
                    }
                } catch (ArbolVacioExcepcion ex) {
                    Logger.getLogger(EnlazadoPadreArbolBinario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
        if(esVacio()){
            throw new ArbolVacioExcepcion();
        }
        nodoRaiz.setElemento(elemRaiz);
        
    }

    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException {
        if(hi == null){
            throw new NullPointerException();
        }
        if(esVacio()){
            throw new ArbolVacioExcepcion();
        }
        
        nodoRaiz.setPadre(null);
        nodoRaiz.setIzq(((EnlazadoPadreArbolBinario) hi).nodoRaiz);
        nodoRaiz.setPadre(nodoRaiz);
        
    }

    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException {
        if(hd == null){
            throw new NullPointerException();
        }
        
        if(esVacio()){
            throw new ArbolVacioExcepcion();
        }
        
        nodoRaiz.setPadre(null);
        nodoRaiz.setDer(((EnlazadoPadreArbolBinario)hd).nodoRaiz);
        nodoRaiz.setPadre(nodoRaiz);
        
    }

    @Override
    public void suprimir() {
        nodoRaiz = null;
    }
    
    public ArbolBinario<E> getPadre(ArbolBinario <E> hijo) throws ArbolVacioExcepcion{
        
        if(esVacio() || hijo.esVacio()){
            throw new ArbolVacioExcepcion("Arbol Vacio");
        }
        
        return new EnlazadoPadreArbolBinario<E> ((((EnlazadoPadreArbolBinario<E>) hijo).nodoRaiz.getPadre()));
    }
    
}

