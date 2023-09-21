/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo_ladyacencia;

/**
 *
 * @author Yo
 */
public class VerticeAdyacente<E,T> {
    private Vertice<E> verticeDestino;
    private T etiquetaArco;

    public VerticeAdyacente(Vertice<E> verticeDestino, T etiquetaArco) {
        this.verticeDestino = verticeDestino;
        this.etiquetaArco = etiquetaArco;
    }

    public Vertice<E> getVerticeDestino() {
        return verticeDestino;
    }

   /* public void setVerticeDestino(Vertice<E> verticeDestino) {
        this.verticeDestino = verticeDestino;
    }*/

    public T getEtiquetaArco() {
        return etiquetaArco;
    }

   /* public void setEtiquetaArco(T etiquetaArco) {
        this.etiquetaArco = etiquetaArco;
    }*/
    
}
