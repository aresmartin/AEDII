/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Iterator;

/**
 *
 * @author Yo
 */
public interface Grafo<E, T> {

    public Iterator<Vertice<E>> adyacentes(Vertice<E> v);
//Produce: devuelve un iterador sobre los vértices adyacentes al vértice v que se pasa
//como parámetro.

    public boolean estaArco(Arco<E, T> a);
//Produce: devuelve cierto si el arco a que se pasa como parámetro pertenece al
//conjunto de arcos del grafo
}
