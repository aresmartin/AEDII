/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapaAdyacencia;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author celticjordan
 */
public class MapaAdyacencia<E, T> implements Grafo<E, T> {

    private List<VerticeConMap<E, T>> listaVertices;
    private int numVertices;

    public MapaAdyacencia() {
        listaVertices = new LinkedList<>();
    }

    public boolean esVacio() {
        return numVertices == 0;
    }

    public boolean estaVertice(Vertice<E> v) {
        for (VerticeConMap<E, T> p : listaVertices) {
            if (p.getVertice().equals(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean estaArco(Arco<E, T> a) {
        for (VerticeConMap<E, T> v : listaVertices) {
            if (v.getVertice().equals(a.getOrigen())) {
                Map<Vertice<E>, T> mapAdy = v.getAdy();
                if (mapAdy.get(a.getDestino()) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<Vertice<E>> vertices() {
        Set<Vertice<E>> vertices = new HashSet<>();
        for (VerticeConMap<E, T> p : listaVertices) {
            vertices.add(p.getVertice());
        }
        return vertices.iterator();
    }

    @Override
    public Iterator<Arco<E, T>> arcos() {
        Set<Arco<E, T>> arcos = new HashSet<>();
        for (VerticeConMap<E, T> v : listaVertices) {
            Vertice<E> origen = v.getVertice();
            Map<Vertice<E>, T> map = v.getAdy();
            Iterator<Vertice<E>> it = map.keySet().iterator();
            while (it.hasNext()) {
                Vertice<E> destino = it.next();
                T etiqueta = map.get(destino);
                arcos.add(new Arco<>(origen, destino, etiqueta));
            }
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
        Set<Vertice<E>> ady = new HashSet<>();
        for (VerticeConMap<E, T> w : listaVertices) {
            if (w.getVertice().equals(v)) {
                Map<Vertice<E>, T> map = w.getAdy();
                ady = map.keySet();
            }
        }
        return ady.iterator();
    }

    @Override
    public void insertarVertice(Vertice<E> v) {
        if (!estaVertice(v)) {
            VerticeConMap<E, T> vl = new VerticeConMap<>(v);
            numVertices++;
            listaVertices.add(vl);
        }
    }

    @Override
    public void insertarArco(Arco<E, T> a) {
        if (!estaArco(a)) {
            if (!estaVertice(a.getOrigen())) {
                insertarVertice(a.getOrigen());
            }
            if (!estaVertice(a.getDestino())) {
                insertarVertice(a.getDestino());
            }
            for (VerticeConMap<E, T> v : listaVertices) {
                if (v.getVertice().equals(a.getOrigen())) {
                    Map<Vertice<E>, T> map = v.getAdy();
                    map.put(a.getDestino(), a.getEtiqueta());
                }
            }
        }
    }

    @Override
    public void eliminarVertice(Vertice<E> v) {
        Iterator<VerticeConMap<E, T>> itr = listaVertices.iterator();
        while (itr.hasNext()) {
            VerticeConMap<E, T> p = itr.next();
            if (p.getVertice().equals(v)) {
                itr.remove();
                numVertices--;
            } else {
                Map<Vertice<E>, T> map = p.getAdy();
                map.remove(v);
            }
        }
    }

    @Override
    public void eliminarArco(Arco<E, T> a) {
        for (VerticeConMap<E, T> p : listaVertices) {
            if (p.getVertice().equals(a.getOrigen())) {
                Map<Vertice<E>, T> map = p.getAdy();
                map.remove(a.getDestino());
            }
        }
    }
}
