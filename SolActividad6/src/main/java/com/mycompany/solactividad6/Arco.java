/*
 * Clase Arco que representa un arco en un grafo, conectando dos vértices (origen y destino)
 * y con una etiqueta asociada que describe la relación entre ellos.
 */
package com.mycompany.solactividad6;

public class Arco<E, T> {
    // Vértice de origen del arco
    private Vertice<E> origen;
    // Vértice de destino del arco
    private Vertice<E> destino;
    // Etiqueta del arco, de tipo genérico T, que representa información adicional sobre el arco
    private T etiqueta;

    // Constructor que inicializa el arco con un vértice de origen, un vértice de destino y una etiqueta
    public Arco(Vertice<E> origen, Vertice<E> destino, T etiqueta) {
        this.origen = origen;
        this.destino = destino;
        this.etiqueta = etiqueta;
    }

    // Método para obtener el vértice de origen del arco
    public Vertice<E> getOrigen() {
        return origen;
    }

    // Método para obtener el vértice de destino del arco
    public Vertice<E> getDestino() {
        return destino;
    }

    // Método para obtener la etiqueta del arco
    public T getEtiqueta() {
        return etiqueta;
    }
}
