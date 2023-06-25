
package hashmap;

import java.util.Iterator;
import java.util.List;


public interface Grafo<E,T> {
   
public boolean esVacio();

public boolean estaVertice(Vertice<E> v);

public boolean estaArco(Arco<E,T> a);

public Iterator<Vertice<E>> vertices();

public Iterator<Arco<E,T>> arcos();

public Iterator<Vertice<E>> adyacentes (Vertice<E> v);

public void insertarVertice (Vertice<E> v);

public void insertarArco (Arco<E,T> a);

public void eliminarVertice (Vertice<E> v);

public void eliminarArco (Arco<E,T> a);
    
}

