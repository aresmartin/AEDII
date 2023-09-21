/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo_larcos;

/**
 *
 * @author Yo
 */
public class Arco<E,T> {
    private Vertice<E> origen, destino;
    private T etiqueta;
    
    public Arco(Vertice<E> o,Vertice<E> d,T e){
        this.origen=o;
        this.destino=d;
        this.etiqueta=e;
        
    }

    public Vertice<E> getOrigen() {
        return origen;
    }

    public void setOrigen(Vertice<E> origen) {
        this.origen = origen;
    }

    public Vertice<E> getDestino() {
        return destino;
    }

    public void setDestino(Vertice<E> destino) {
        this.destino = destino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    
}
