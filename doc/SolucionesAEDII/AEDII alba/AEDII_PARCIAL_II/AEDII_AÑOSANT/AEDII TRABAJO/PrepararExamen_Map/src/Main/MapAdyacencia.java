/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Yo
 */
public class MapAdyacencia<E, T> implements Grafo<E, T> {

    private List<VerticeConMap<E, T>> listVertices;

    public MapAdyacencia() {
        listVertices = new ArrayList<>();
    }

    @Override
    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
        List<Vertice<E>> lista = new ArrayList<>();

        int i = 0;
        while(!listVertices.get(i).equals(v)&& i<listVertices.size() ){
            i++;
        }
        
        if(listVertices.get(i).equals(v)){
            //preguntar pk castear aqui
           lista= (List<Vertice<E>>) listVertices.get(i).getAdy();
  
        }   
        return lista.iterator();
    }

    @Override
    public boolean estaArco(Arco<E, T> a) {
        boolean toret=false;
        int i=0;
         while(i<listVertices.size()&&toret==false){
             
             if(listVertices.get(i).getAdy().get(listVertices.get(i).getVertice()).equals(a.getEtiqueta())&&
                     listVertices.get(i).getVertice().equals(a.getOrigen())&&
                     listVertices.get(i).getAdy().esta(a.getDestino())){
                 toret=true;
             }
             i++;
         
    }
         return toret;

}
}
