/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author Samuel Velásquez
 */
import java.util.Iterator;

public interface Grafo<E,T> {

    public boolean esVacio();
    
    public boolean estaVertice(Vertice<E> v);
    // Produce: cierto si el vértice v está en this, falso en caso contrario

    public boolean estaArco(Arco<E, T> a);
    // Produce: cierto si el arco a está en this, falso en caso contrario

    public Iterator<Vertice<E>> vertices();
    // Produce: devuelve un iterador sobre los vértices del grafo

    public Iterator<Arco<E, T>> arcos();
    // Produce: devuelve un iterador sobre los arcos del grafo

    public Iterator<Vertice<E>> adyacentes(Vertice<E> v);
    // Produce: devuelve un iterador sobre los vértices del grafo adyacentes al vértice v

    public void insertarVertice(Vertice<E> v);
    // Modifica: this
    // Produce: inserta el vértice v en this

    public void insertarArco(Arco<E, T> a);
    // Modifica: this
    // Produce: inserta el arco a en this

    public void eliminarVertice(Vertice<E> v);
    // Modifica: this
    // Produce: elimina el vértice v de this y todos los arcos que salen y llegan a v

    public void eliminarArco(Arco<E, T> a);
    // Modifica: this
    // Produce: elimina el arco a de this
}
