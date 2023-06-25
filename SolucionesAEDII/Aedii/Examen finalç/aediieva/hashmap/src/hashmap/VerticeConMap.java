
package hashmap;


public class VerticeConMap<E,T> {
    
    private Vertice<E> vertice;
    private Map<Vertice<E>,T> mapAdy;
    
    public VerticeConMap(Vertice<E> vertice){
        
        this.vertice = vertice;
        this.mapAdy = new HashMap();
    }

    public Vertice<E> getVertice() {
        return vertice;
    }

    public Map<Vertice<E>,T> getAdy() {
        return mapAdy;
    }
    
    
    
}
