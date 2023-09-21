/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Yo
 */
public class VerticeConMap<E, T> {

    private Vertice<E> origen; // vértice del grafo
    private Map<Vertice<E>, T> mapAdy; // mapa de adyacentes del vértice origen

    VerticeConMap(Vertice<E> v) {
        origen = v;
        mapAdy = new HashMap<>(1);
    }

    Vertice<E> getVertice() {
        return origen;
    }

    Map<Vertice<E>, T> getAdy() {
        return mapAdy;
    }

}
