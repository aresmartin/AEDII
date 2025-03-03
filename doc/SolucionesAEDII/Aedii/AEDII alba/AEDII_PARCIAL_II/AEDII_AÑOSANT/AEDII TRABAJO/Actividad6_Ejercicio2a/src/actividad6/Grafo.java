import java.util.Iterator;

public interface Grafo <E,T>{
    
     public Iterator <Vertice<E>> adyacentes (Vertice<E> v);
     public boolean estaArco(Arco<E,T> a); 
}
