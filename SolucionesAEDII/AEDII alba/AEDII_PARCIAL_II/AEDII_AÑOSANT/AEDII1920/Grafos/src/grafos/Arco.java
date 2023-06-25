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
public class Arco<E, T> {

    private Vertice<E> origen;
    private Vertice<E> destino;
    private T etiqueta;

    public Arco(Vertice<E> origen, Vertice<E> destino, T etiqueta) {
        this.origen = origen;
        this.destino = destino;
        this.etiqueta = etiqueta;
    }

    public Vertice<E> getOrigen() {
        return origen;
    }

    public Vertice<E> getDestino() {
        return destino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    public void setOrigen(Vertice<E> origen) {
        this.origen = origen;
    }

    public void setDestino(Vertice<E> destino) {
        this.destino = destino;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }
}
