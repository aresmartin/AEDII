/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo2;

//import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Juan Yuri Díaz Sánchez
 */
public interface Grafo<E,T> {
    public boolean esVacio();
    public boolean estaVertice(Vertice<E> v);
    public boolean estaArco(Arco<E, T> arco);
    public List<Vertice<E>> vertices();
    public List<Arco<E, T>> arcos();
    public List<Vertice<E>> adyacentes(Vertice<E> v);
    public void insertarVertice(Vertice<E> v);
    public void insertarArco(Arco<E, T> arco);
    public void eliminarArco(Arco<E, T> a);
    public void eliminarVertice(Vertice<E> v);
}
