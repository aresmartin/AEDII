package grafo2;

import map.HashMap;

/**
 *
 * @author Juan Yuri Díaz Sánchez
 */
public class VerticeConMap<E,T> {
    private Vertice<E> origen;
    private HashMap<Vertice<E>,T> mapaSucesores;
    // K: vertice destino
    // V: etiqueta del Arco
    
    public VerticeConMap(Vertice<E> vo){
        this.origen = vo;
        this.mapaSucesores = new HashMap();
    }
    
    public Vertice<E> getVertice(){
        return this.origen;
    }
    
    public HashMap<Vertice<E>,T> getSucesores(){
        return this.mapaSucesores;
    }
    

    
    
}
