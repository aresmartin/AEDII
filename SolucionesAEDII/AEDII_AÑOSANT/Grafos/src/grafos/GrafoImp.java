/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author PerezFamily
 */

import java.util.Iterator;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

public class GrafoImp<E,T> implements Grafo<E,T> {
    /*Un grafo es una estructura compuesta por Vertices o nodos y Arcos o Aristas*/
    private Vertice<E> nodo;
    private Arco<E,T> arista;    
    
    public GrafoImp(){
        nodo = null;
    }
    
    //Esta bien
    public boolean esVacio(){
        return nodo == null;
    }

    public boolean estaVertice(Vertice<E> v){
        return false;
    }

    public boolean estaArco(Arco<E, T> a){
        return false;
    }

    public Iterator<Vertice<E>> vertices(){
        return null;
    }

    public Iterator<Arco<E, T>> arcos(){
        return null;
    }

    public Iterator<Vertice<E>> adyacentes(Vertice<E> v){
        return null;
    }

    public void insertarVertice(Vertice<E> v){
        
    }

    public void insertarArco(Arco<E, T> a){
        
    }

    public void eliminarVertice(Vertice<E> v){
        
    }

    public void eliminarArco(Arco<E, T> a){
        
    }
}
