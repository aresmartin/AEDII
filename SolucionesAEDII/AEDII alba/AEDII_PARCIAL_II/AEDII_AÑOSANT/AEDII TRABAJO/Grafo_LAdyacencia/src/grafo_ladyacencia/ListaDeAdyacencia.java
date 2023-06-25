/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo_ladyacencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Yo
 */
public class ListaDeAdyacencia<E, T> implements Grafo<E, T> {

    private List<VerticeConLista<E, T>> listVertices;
    private int numVertices;

    public ListaDeAdyacencia() {
        listVertices = new ArrayList<>();
        numVertices = 0;
    }

    @Override
    public boolean esVacio() {
        if (numVertices == 0) {
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
        Iterator<Arco<E, T>> arc = this.arcos();
        while (arc.hasNext()) {
            Arco<E, T> aco = arc.next();
            if (aco.equals(a)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Vertice<E>> vertices() {
        List<Vertice<E>> vertices = new ArrayList<>();
        for (VerticeConLista<E, T> v : listVertices) {
            vertices.add(v.getVertice());
        }
        return vertices.iterator();
    }

    @Override
    public Iterator<Arco<E, T>> arcos() {
        List<Arco<E, T>> arcos = new ArrayList<>();
        for (VerticeConLista<E, T> v1 : listVertices) {
            Arco<E, T> arco = null;
            List<VerticeAdyacente<E, T>> v2 = v1.getLista();
            for (VerticeAdyacente<E, T> q : v2) {
                arco.setOrigen(v1.getVertice());
                arco.setDestino(q.getVerticeDestino());
                arco.setEtiqueta(q.getEtiquetaArco());
            }
            arcos.add(arco);
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
        List<Vertice<E>> adyacentes = new ArrayList<>();
        for (VerticeConLista<E, T> ver1 : listVertices) {
            if (ver1.getVertice().equals(v)) {
                List<VerticeAdyacente<E, T>> I = ver1.getLista();
                for (VerticeAdyacente<E, T> q : I) {
                    adyacentes.add(q.getVerticeDestino());
                }
            }
        }
        return adyacentes.iterator();
    }

    @Override
    public void insertarVertice(Vertice<E> v) {
        listVertices.add(new VerticeConLista(v, null));
    }

    @Override
    public void insertarArco(Arco<E, T> a) {
        List<VerticeAdyacente<E, T>> listaAdyacencia = new ArrayList<>();
        listaAdyacencia.add(new VerticeAdyacente(a.getDestino(), a.getEtiqueta()));
        boolean esta = false;
        for (VerticeConLista<E, T> v1 : listVertices) {
            if (v1.getVertice().equals(a.getOrigen())) {
                esta = true;
            }
            if (esta) {
                v1.getLista().add(new VerticeAdyacente(a.getDestino(), a.getEtiqueta()));
            }
        }
        if (!esta) {
            listVertices.add(new VerticeConLista(a.getOrigen(),listaAdyacencia));
        }

    }

    @Override
    public void eliminarVertice(Vertice<E> v) {
        for (VerticeConLista<E, T> q : listVertices) {
            if (q.getVertice().equals(v)) {
                listVertices.remove(q);
                numVertices--;
            }
        }
        for (VerticeConLista<E, T> q : listVertices) {
            VerticeConLista<E,T> w = q;
            for(VerticeAdyacente<E,T> r: w.getLista()){
                if(r.getVerticeDestino()==v){
                    w.getLista().remove(r);
                }
            }
            
            
        }
        
    }

    @Override
    public void eliminarArco(Arco<E, T> a) {
         for (VerticeConLista<E, T> q : listVertices) {
            VerticeConLista<E,T> w = q;
            for(VerticeAdyacente<E,T> r: w.getLista()){
                if(r.getVerticeDestino().equals(a.getDestino())&&
                        r.getEtiquetaArco().equals(a.getEtiqueta())&&
                        w.equals(a.getOrigen())){
                    w.getLista().remove(r);
                }
            }
            
            
        }
    }

}
