package proyectoaedii;

//import java.util.HashMap;

//import java.util.Map;

public class VerticeConMap<E,T>  {
    private Vertice<E> origen;
    private Map<Vertice<E>, T> mapAdy;

    VerticeConMap(Vertice<E> v)
    {
        origen=v;
        mapAdy = new HashMap<>();
    }
    Vertice<E> getVertice(){
        return origen;
    }
    Map<Vertice<E>, T> getAdy(){
           return mapAdy;
    }   
}
