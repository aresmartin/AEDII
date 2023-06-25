package grafo2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import map.Par;



/**
 *
 * @author Juan Yuri Díaz Sánchez
 */
public class MapAdyacencia<E,T> implements Grafo<E,T> {
    private List<VerticeConMap<E,T>> listVertices;
    
    public MapAdyacencia(){
        this.listVertices = new LinkedList();
    }

    @Override
    public boolean esVacio() {
        return (listVertices.isEmpty());
    }

    @Override
    public boolean estaVertice(Vertice<E> v) {
        int i = 0;
        
        while(i<listVertices.size() && !listVertices.get(i).getVertice().equals(v))
            i++;
        
        return ( i != listVertices.size());
    }

    /**
     * 
     * @param arco el arco del cual queremos comprobar su existencia
     * @return cierto si el arco está en el mapa
     */
    @Override
    public boolean estaArco(Arco<E, T> arco) {
        
        for (VerticeConMap<E, T> listVertice : listVertices) {
            
            if(listVertice.getVertice().equals(arco.getOrigen())){
                for (Par<Vertice<E>, T> par : listVertice.getSucesores().pares()) {
                    
                    if( par.getClave().equals( arco.getDestino() ) && par.getValor().equals( arco.getEtiqueta() ) ){
                        return true;
                    }
                }

            }
        }
        return false;
    
    }

    @Override
    public List<Vertice<E>> vertices() {
        List<Vertice<E>> listaVertices = new LinkedList();
        
        for (VerticeConMap<E, T> vertice : listVertices) {
            listaVertices.add(vertice.getVertice());
        }
        
        return listaVertices;
    }
    
   
    @Override
    public List<Arco<E, T>> arcos() {
        List<Arco<E,T>> listaArcos = new LinkedList();
        
        for (VerticeConMap<E, T> nodo : listVertices) {
            // Para cada nodo.getVertice(), generamos sus adyacentes.
          
//                if(!nodo.getSucesores().esVacio()){
                    for (Par<Vertice<E>, T> par :  nodo.getSucesores().pares() ) {
                        listaArcos.add(new Arco(nodo.getVertice(),par.getClave(),par.getValor()));
                    }
                
        }
        
        return listaArcos;
    }
    
    
    

    @Override
    public List<Vertice<E>> adyacentes(Vertice<E> v) {
        List<Vertice<E>> sucesores = new LinkedList();
        
        // Búsqueda lineal
        int i = 0;
        while(i<listVertices.size() && !listVertices.get(i).getVertice().equals(v)){
            i++;
        }
        
            
        if(i != listVertices.size()){ 
                
            for (Vertice<E> verticeDestino : listVertices.get(i).getSucesores().claves()) {
                sucesores.add(verticeDestino);
            }
        }
            
        return sucesores;
    }
    
    
    @Override
    public void insertarVertice(Vertice<E> v) {
        if(!estaVertice(v))
            listVertices.add(new VerticeConMap(v));
    }
    
    
    

    @Override
    public void insertarArco(Arco<E, T> arco) {
        
        if(!estaVertice(arco.getOrigen())){
           insertarVertice(arco.getOrigen());
        }
       
        if(!estaVertice(arco.getDestino())){
           insertarVertice(arco.getDestino());
        }
        
        int i = 0;
        while(i<listVertices.size() && !listVertices.get(i).getVertice().equals(arco.getOrigen()))
            i++;
        
        if(i != listVertices.size()){
            // Ya sabíamos que estaba, pero no sabíamos dónde
            // Al insertar sobreescribimos la clave
            listVertices.get(i).getSucesores().insertar(arco.getDestino(), arco.getEtiqueta());
        } 
    
    }
    
    
    @Override
    public void eliminarVertice(Vertice<E> v) {
                
            if(estaVertice(v)){
                listVertices.remove(v);
                // Ahora procedemos a eliminarlo dentro de los mapas de otros vértices
                for (VerticeConMap<E, T> nodo : listVertices) {
                    for (Par<Vertice<E>, T> par : nodo.getSucesores().pares()) {
                        if(par.getClave().equals(v)){
                            nodo.getSucesores().eliminar(par.getClave());
                        }
                    }
                }
                // Lo eliminamos de la lista de vértices
                
                
                
            }
            
        
    }

    
    @Override
    public void eliminarArco(Arco<E, T> arco) {
        
            // Si está el vertice de origen, eliminamos el vértice de destino asociado
            
            int i = 0;
            while(i<listVertices.size() && !listVertices.get(i).getVertice().equals(arco.getOrigen())){
                i++;
            }
            
            if(i != listVertices.size()){
                listVertices.get(i).getSucesores().eliminar(arco.getDestino());
            }
        
        
    }
    
    
    @Override
    public String toString(){
        StringBuilder toret = new StringBuilder();
        
        for (VerticeConMap<E, T> vertice : listVertices) {
            toret.append(vertice.getVertice()).append("\n");
            toret.append(vertice.getSucesores());
            toret.append("\n\n");
        }
        
        return toret.toString();
    }
}
