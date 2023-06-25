/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo_ladyacencia;

import java.util.List;

/**
 *
 * @author Yo
 */
public class VerticeConLista<E,T> {
    private Vertice<E> verticeOrigen;
    private List<VerticeAdyacente<E,T>> listAdyacentes;

    public VerticeConLista(Vertice<E> verticeOrigen, List<VerticeAdyacente<E, T>> ady) {
        this.verticeOrigen = verticeOrigen;
        this.listAdyacentes = ady;
    }

    public Vertice<E> getVertice() {
        return verticeOrigen;
    }

    public List<VerticeAdyacente<E, T>> getLista() {
        return listAdyacentes;
    }
    
    
    
    
    
    
}
