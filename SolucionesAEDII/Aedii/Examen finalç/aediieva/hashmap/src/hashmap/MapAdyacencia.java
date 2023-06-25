
package hashmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapAdyacencia<E,T> implements Grafo<E,T>{
    
    private List<VerticeConMap<E,T>> listVertices;
    
    public MapAdyacencia(){
    
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
    
    public boolean estaArco(Arco<E,T> arco) {

        for(VerticeConMap<E,T> vm : listVertices){
            
            if(vm.getVertice().equals(arco.getOrigen())){
                
                if(vm.getAdy().get(arco.getDestino()) != null){
                if(vm.getAdy().get(arco.getDestino()).equals(arco.getEtiqueta())) return true;
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

    
    public Iterator<Arco<E,T>> arcos() {
        
        List<Arco<E,T>> toret = new ArrayList<>();
        
        for(VerticeConMap<E,T> vm : listVertices){
            
            Iterator<Vertice<E>> it = vm.getAdy().keySet();
            
            while(it.hasNext()){
            
            Vertice<E> vertice = it.next();
            toret.add(new Arco<E,T>(vm.getVertice(), vertice, vm.getAdy().get(vertice)));
            
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
        
        if(!estaVertice(v)) listVertices.add(new VerticeConMap<E,T>(v));
        
    }
    

    public void insertarArco(Arco<E,T> arco) {
        
        if(!estaVertice(arco.getOrigen())) listVertices.add(new VerticeConMap<E,T>(arco.getOrigen()));
        if(!estaVertice(arco.getDestino())) listVertices.add(new VerticeConMap<E,T>(arco.getDestino()));
        
        for(VerticeConMap<E,T> vm : listVertices){
            
            if(vm.getVertice().equals(arco.getOrigen())){
                
                vm.getAdy().put(arco.getDestino(), arco.getEtiqueta());
            }
        }
  }
    

    public void eliminarVertice(Vertice<E> v) {
        
        if(estaVertice(v)){
            
            for(VerticeConMap<E,T> vm : listVertices){
                
                if(vm.getVertice().equals(v)) listVertices.remove(vm);
                
                else vm.getAdy().remove(v);
                
            }
        }
    }

    public void eliminarArco(Arco<E,T> arco) {
        
        for(VerticeConMap<E,T> vm : listVertices){
            
            if(vm.getVertice().equals(arco.getOrigen())) vm.getAdy().remove(arco.getDestino());
        }     
        }
    
}
        
   
    
 

    
