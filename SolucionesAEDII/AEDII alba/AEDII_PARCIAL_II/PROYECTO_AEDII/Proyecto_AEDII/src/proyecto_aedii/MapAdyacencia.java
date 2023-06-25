/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aedii;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author LuisFerCou
 * @param <E>
 * @param <T>
 */
public class MapAdyacencia<E, T> implements Grafo<E, T> {

    private List<VerticeConMap<E, T>> listVertices;

    public MapAdyacencia() {
        listVertices = new ArrayList<>();
    }

    @Override
    public boolean estaArco(Arco<E, T> a) {
      boolean toret = false;
      
      int i = 0;
      
      while(i<listVertices.size() && toret == false){
          if(listVertices.get(i).getVertice().equals(a.getOrigen()) &&
                  listVertices.get(i).getAdy().equals(a.getDestino()) &&
                  listVertices.get(i).getAdy().get(a.getDestino()).equals(a.getEtiqueta())){
              toret = true;
          }
          
          i++;
      }
        return toret;
    }

    @Override
    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
        
        int i = 0;
        
        //Busco el vértice que me pasan como parámetro
        while (i < listVertices.size() && !listVertices.get(i).getVertice().equals(v)) {
            i++;
        }

        //Guardo en una lista las claves de los adyacentes
        if (listVertices.get(i).getVertice().equals(v)) {
            return listVertices.get(i).getAdy().keySet();
        } else {
            return new ArrayList<Vertice<E>>().iterator();
        }
    }

    @Override
    public boolean esVacio() {
        return listVertices.size() == 0;
    }

    @Override
    public boolean estaVertice(Vertice<E> v) {
        boolean toret = false;
        
        int i = 0;
        while(i< listVertices.size() && toret == false){
            if(listVertices.get(i).getVertice().equals(v) ||
                    listVertices.get(i).getAdy().equals(v)){
                toret = true;
            }
            i++;
        }
        return toret;
    }

    @Override
    public Iterator<Vertice<E>> vertices() {
        List<Vertice<E>> vertices = new ArrayList<>();
        
        for(int i=0; i<listVertices.size(); i++){
            vertices.add(listVertices.get(i).getVertice());
        }
        
        return vertices.iterator();
    }

    @Override
    public Iterator<Arco<E, T>> arcos() {
        List<Arco<E,T>> arcos = new ArrayList<>();
        
        for(int i= 0; i< listVertices.size(); i++){
            for(VerticeConMap<E,T> vm : listVertices){
                arcos.add((Arco<E, T>) vm.getAdy().values());
            }
        }
        
        return arcos.iterator();
    }

    @Override
    public void insertarVertice(Vertice<E> v) {
    }

    @Override
    public void insertarArco(Arco<E, T> a) {
    }

    @Override
    public void eliminarVertice(Vertice<E> v) {
        int i=0;
        boolean toret = false;
        
        
        //Buscamos el vertice:
        while(i<listVertices.size() && !listVertices.get(i).getVertice().equals(v)){
            i++;
        }
        
        //Eliminamos el vertice:
        if(listVertices.get(i).getVertice().equals(v) ||
                listVertices.get(i).getAdy().esta(v)){
            listVertices.remove(v);
        }
    }

    
      public void eliminarArco(Arco<E,T> arco) {
        
        for(VerticeConMap<E,T> vm : listVertices){
            
            if(vm.getVertice().equals(arco.getOrigen())) vm.getAdy().remove(arco.getDestino());
        }     
        }

}
