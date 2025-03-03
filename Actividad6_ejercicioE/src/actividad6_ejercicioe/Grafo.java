/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad6_ejercicioe;

import java.util.Iterator;

public interface Grafo<E, T> {
    boolean esVacio();
    boolean estaVertice(Vertice<E> v);
    boolean estaArco(Arco<E, T> a);
    Iterator<Vertice<E>> vertices();
    Iterator<Arco<E, T>> arcos();
    Iterator<Vertice<E>> adyacentes(Vertice<E> v);
    void insertarVertice(Vertice<E> v);
    void insertarArco(Arco<E, T> a);
    void eliminarVertice(Vertice<E> v);
    void eliminarArco(Arco<E, T> a);
}
