/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo_larcos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Yo
 */
public class ListaDeArcos<E, T> implements Grafo<E, T> {

    private List<Vertice<E>> listVertices;
    private List<Arco<E, T>> listArcos;

    public ListaDeArcos() {
        listVertices = new ArrayList<>();
        listArcos = new ArrayList<>();
    }

    @Override
    public boolean esVacio() {
        if (listVertices.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean estaVertice(Vertice<E> v) {
        Iterator<Vertice<E>> it = this.vertices();
        while (it.hasNext()) {
            Vertice<E> w = it.next();
            if (w.equals(v)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean estaArco(Arco<E, T> a) {
        Iterator<Arco<E, T>> it = this.arcos();
        while (it.hasNext()) {
            Arco<E, T> arc = it.next();
            if (arc.equals(a)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Vertice<E>> vertices() {
        List<Vertice<E>> vertices = new ArrayList<>();
        for (Vertice<E> v : listVertices) {
            vertices.add(v);
        }
        return vertices.iterator();
    }

    @Override
    public Iterator<Arco<E, T>> arcos() {
        List<Arco<E, T>> arcos = new ArrayList<>();
        for (Arco<E, T> arc : listArcos) {
            arcos.add(arc);
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
        List<Vertice<E>> adyacentes = new ArrayList<>();
        for (Arco<E, T> a : listArcos) {
            if (a.getOrigen().equals(v)) {
                adyacentes.add(a.getDestino());
            }
        }
        return adyacentes.iterator();
    }

    @Override
    public void insertarVertice(Vertice<E> v) {
        listVertices.add(v);
    }

    @Override
    public void insertarArco(Arco<E, T> a) {
        listArcos.add(a);
    }

    @Override
    public void eliminarVertice(Vertice<E> v) {
        for (Vertice<E> ver : listVertices) {
            if (ver.equals(v)) {
                for (Arco<E, T> a : listArcos) {
                    if (a.getOrigen().equals(v)) {
                        listArcos.remove(a);
                    }
                    if(a.getDestino().equals(v)){
                        listArcos.remove(a);
                    }
                }
                listVertices.remove(ver);
            }
        }

    }

    @Override
    public void eliminarArco(Arco<E, T> a) {
        for (Arco<E, T> arc : listArcos) {
            if (arc.equals(a)) {
                listArcos.remove(arc);
            }
        }

    }

}
