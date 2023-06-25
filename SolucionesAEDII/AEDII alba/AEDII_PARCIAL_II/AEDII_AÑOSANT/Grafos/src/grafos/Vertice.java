/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author Samuel Velásquez
 */
public class Vertice<E> {
    private E etiqueta;
    
    public Vertice(E etiqueta){
        this.etiqueta = etiqueta;
    }
    
    public E getEtiqueta(){
        return etiqueta;
    }
    
    public void setEtiqueta(E etiqueta){
        this.etiqueta = etiqueta;
    }
}
