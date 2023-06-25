/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo_mapadyacencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Yo
 */
public class Grafo_MapAdyacencia<E, T> implements Grafo<E, T> {

    private List<VerticeConMap<E, T>> listVertices;

    public Grafo_MapAdyacencia() {
        listVertices = new ArrayList<>();
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
        boolean toret = false;
        int i = 0;
        while (i < listVertices.size() && toret == false) {

            if (listVertices.get(i).getOrigen().equals(a.getOrigen())
                    && listVertices.get(i).getMapAdy().esta(a.getDestino())
                    && listVertices.get(i).getMapAdy().get(listVertices.get(i).getOrigen()).equals(a.getEtiqueta())) {
                toret = true;
            }

            i++;

        }
        return toret;
    }

    @Override
    public Iterator<Vertice<E>> vertices() {
        List<Vertice<E>> vertices = new ArrayList<>();
        for (VerticeConMap<E, T> v : listVertices) {
            vertices.add(v.getOrigen());
        }
        return vertices.iterator();
    }

    @Override
    public Iterator<Arco<E, T>> arcos() {
        List<Arco<E, T>> arc = new ArrayList<>();
        int i = 0;
        while (i < listVertices.size()) {
            Vertice<E> origen = listVertices.get(i).getOrigen();
            Vertice<E> destino = null;
            T etiqueta = null;

            Iterator<Vertice<E>> it = listVertices.get(i).getMapAdy().keySet();
            while (it.hasNext()) {
                Vertice<E> dest = it.next();
                if (listVertices.get(i).getMapAdy().esta(dest)) {
                    destino=dest;
                    etiqueta=listVertices.get(i).getMapAdy().get(destino);
                }
            }
          arc.add(new Arco(origen,destino,etiqueta));
            
        }
        return arc.iterator();
    }

    @Override
    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {

        Iterator<Vertice<E>> adyacentes = null;
        int i=0;
        while(!listVertices.get(i).getOrigen().equals(v)&&i<listVertices.size()){
            i++;
        }
        if(listVertices.get(i).getOrigen().equals(v)){
            
             adyacentes = listVertices.get(i).getMapAdy().keySet(); 
        }
        return adyacentes;


    }

    @Override
    public void insertarVertice(Vertice<E> v) {
        listVertices.add(new VerticeConMap(v,null));

    }

    @Override
    public void insertarArco(Arco<E, T> a) {
        int i=0;
         while(!listVertices.get(i).getOrigen().equals(a.getOrigen())&&i<listVertices.size()){
             i++;
         }
         if(listVertices.get(i).getOrigen().equals(a.getOrigen())){
             listVertices.get(i).getMapAdy().put(a.getDestino(), a.getEtiqueta());
         }
         //pensar si tiene que ir un else

    }

    @Override
    public void eliminarVertice(Vertice<E> v) {
        int i=0;
        while(!listVertices.get(i).getOrigen().equals(v)&&i<listVertices.size()){
            i++;
        }
        if(listVertices.get(i).getOrigen().equals(v)){
            for(int j=0;j<listVertices.size();j++){
               Iterator<Vertice<E>>lista= listVertices.get(j).getMapAdy().keySet();
               while(lista.hasNext()){
                   Vertice<E> w = lista.next();
                   if(w.equals(v)){
                       listVertices.get(j).getMapAdy().clear();
                   }
               }
            }

            listVertices.remove(i);
        }
    }

    @Override
    public void eliminarArco(Arco<E, T> a) {

        for(int i=0;i<listVertices.size();i++){
            if(listVertices.get(i).getOrigen().equals(a.getOrigen())&&
                   listVertices.get(i).getMapAdy().esta(a.getDestino())&&
                    listVertices.get(i).getMapAdy().get(a.getDestino()).equals(a.getEtiqueta())
                    )
                
                listVertices.get(i).getMapAdy().clear();
        }


    }

}
