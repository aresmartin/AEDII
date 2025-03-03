public class VerticesConMap<E,T> {
    
   private Vertice<E> origen; // vértice del grafo
    private HashMap <Vertice<E>, T> mapAdy; // mapa de adyacentes del vértice origen
 
    public VerticesConMap(Vertice<E> v){
        
        origen = v;
        mapAdy = new HashMap<>(1);
        
    }
 
   public Vertice<E> getVertice(){
    
        return origen;
    
    }
 
    
    public HashMap<Vertice<E>, T> getAdy(){
 
        return mapAdy;
 
    }
    
    
}
