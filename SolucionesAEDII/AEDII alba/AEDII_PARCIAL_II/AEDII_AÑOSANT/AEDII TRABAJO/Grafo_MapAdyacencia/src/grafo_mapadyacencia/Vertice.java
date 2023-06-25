/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo_mapadyacencia;

/**
 *
 * @author Yo
 */
public class Vertice<E> {
    private E etiqueta;
    
    public Vertice(E etiq){
        this.etiqueta=etiq;
    }

    public E getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(E etiqueta) {
        this.etiqueta = etiqueta;
    }
       
}
