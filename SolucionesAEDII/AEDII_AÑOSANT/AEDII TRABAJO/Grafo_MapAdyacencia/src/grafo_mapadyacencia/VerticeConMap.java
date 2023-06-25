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
class VerticeConMap<E,T> {
    private Vertice<E> origen;
    private Map<Vertice<E>,T> mapAdy;

    public VerticeConMap(Vertice<E> origen, Map<Vertice<E>, T> mapAdy) {
        this.origen = origen;
        this.mapAdy = mapAdy;
    }

    public Vertice<E> getOrigen() {
        return origen;
    }

    public Map<Vertice<E>, T> getMapAdy() {
        return mapAdy;
    }
    
    
    
}
