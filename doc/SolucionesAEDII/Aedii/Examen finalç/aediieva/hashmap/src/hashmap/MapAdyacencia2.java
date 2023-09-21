
package hashmap;

import java.util.*;

public class MapAdyacencia2<E,T> implements Grafo<E,T> {

    List<VerticeConMap<E,T>> listVertices;
    
    public MapAdyacencia2(){
        
        listVertices = new ArrayList<>();
    }
    
    public boolean esVacio() {
        
        return listVertices.isEmpty();
    }

    public boolean estaVertice(Vertice<E> v) {
        
        for(VerticeConMap<E,T> vm : listVertices){
            
            if(vm.getVertice().equals(v)) return true;
        }
        
        return false;
    }

    public boolean estaArco(Arco<E, T> arco) {
        
        for(VerticeConMap<E,T> vm : listVertices){
            
            if(vm.getVertice().equals(arco.getOrigen())){
                
                if(vm.getAdy().get(arco.getDestino()) != null){
                    
                    if(vm.getAdy().get(arco.getDestino()).equals(arco.getEtiqueta())) 
                        return true;
                }
            }
        }
        
        return false;
    }

    public Iterator<Vertice<E>> vertices() {
        
        List<Vertice<E>> toret = new ArrayList<>();
        
        for(VerticeConMap<E,T> vm : listVertices){
            
            toret.add(vm.getVertice());
        }
        
        return toret.iterator();
    }

    public Iterator<Arco<E, T>> arcos() {
        
        List<Arco<E,T>> toret = new ArrayList<>();
        
        for(VerticeConMap<E,T> vm : listVertices){
            
            Iterator<Vertice<E>> it = vm.getAdy().keySet();
            
            while(it.hasNext()){
                
                Vertice<E> verticeDest = it.next();
                toret.add(new Arco(vm.getVertice(), verticeDest, vm.getAdy().get(verticeDest)));
                
            }
       }        
        return toret.iterator();
    }

    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
        
        List<Vertice<E>> toret = new ArrayList<>();
        
        for(VerticeConMap<E,T> vm : listVertices){
            
            if(vm.getVertice().equals(v)){
                
                Iterator<Vertice<E>> it = vm.getAdy().keySet();
                
                while(it.hasNext()){
                    
                    toret.add(it.next());
                }
            }
        }
        
        return toret.iterator();
    }

    public void insertarVertice(Vertice<E> v) {
        
        if(!estaVertice(v)) listVertices.add(new VerticeConMap(v));
    }

    public void insertarArco(Arco<E, T> arco) {
        
        if(!estaVertice(arco.getOrigen())) insertarVertice(arco.getOrigen());
        if(!estaVertice(arco.getDestino())) insertarVertice(arco.getDestino());
        
        for(VerticeConMap<E,T> vm : listVertices){
            
            if(vm.getVertice().equals(arco.getOrigen())){
                
                vm.getAdy().put(arco.getDestino(), arco.getEtiqueta());
            }
        }
    }

    public void eliminarVertice(Vertice<E> v) {
        
        if(estaVertice(v)){
            
            for(VerticeConMap<E,T> vm : listVertices){
                
                if(vm.getVertice().equals(v)){
                    
                    listVertices.remove(vm);
                }
                else{
                    vm.getAdy().remove(v);                  
                }
            }
        }
    }

    public void eliminarArco(Arco<E, T> arco) {
        
        for(VerticeConMap<E,T> vm : listVertices){
            
            if(vm.getVertice().equals(arco.getOrigen())){
                
                vm.getAdy().remove(arco.getDestino());
            }
            
        }
    }
    
    
}
