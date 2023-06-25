
package grafos;

import grafo.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Actividad7 {
    
    public static <E,T> Iterator<Vertice<E>> predecesores(Grafo <E,T> g, Vertice<E> v){
        
        List<Vertice<E>> toret = new ArrayList<>(); 
        Iterator<Arco<E,T>> itA = g.arcos();
        
        while(itA.hasNext()){
            
           Arco<E,T> a = itA.next();
            
           if(a.getDestino().equals(v)){
               toret.add(a.getOrigen());
           } 
            
        }
        
        return toret.iterator();
    }
    
    public static <E,T> boolean esSumidero(Grafo <E,T> g, Vertice<E> v){

    Iterator<Vertice<E>> itV = g.adyacentes(v);
    
    if(itV.hasNext()) return false;
    
    itV = predecesores(g,v);
    
    int cont = 0;
    
    while(itV.hasNext()){
        itV.next();
        cont++;
    }
    
    itV = g.vertices();
    int num = 0;
    
    while(itV.hasNext()){
        
        itV.next();
        num++;
    }
    
    return num-1==cont; 
    
}

    public static <E,T> boolean regular(Grafo <E,T> g){
        
        if(g.esVacio()) return true;
        
        Iterator<Vertice<E>> itV = g.vertices();
        Vertice<E> v = itV.next();
        Iterator<Vertice<E>> itAdy = g.adyacentes(v);
        
        int num = 0;
        while(itAdy.hasNext()){
            
            itAdy.next();
            num++;
        }
        
        while(itV.hasNext()){
            
            v = itV.next();
            itAdy = g.adyacentes(v);
            int cont = 0;
            
            while(itAdy.hasNext()){
                itAdy.next();
                cont++;
            }
            
            if(cont != num) return false;
        }
        
        return true;
    }
    
    public static <E,T> boolean hayCamino(Grafo<E,T> g, Vertice<E> origen, Vertice<E> destino){
        
        List<Vertice<E>> visitados = new ArrayList<>();
        return hayCamino(g, origen, destino, visitados);
    }

    
    public static <E,T> boolean hayCamino(Grafo<E,T> g, Vertice<E> origen, Vertice<E> destino, List<Vertice<E>> visitados){
        
        if(origen.equals(destino)) return true;
        
        boolean encontrado = false;
        visitados.add(origen);
        Iterator<Vertice<E>> itV = g.adyacentes(origen);
        
        while(itV.hasNext() && !encontrado){
            
            Vertice<E> w = itV.next();
            if(!visitados.contains(w)){
                
                encontrado = hayCamino(g,w,destino,visitados);
            }
        }
        
        return encontrado;
    }
    
    public static <E,T> boolean manos (Grafo<E,T> grafo){
        
        Iterator<Vertice<E>> it = grafo.vertices();
        Iterator<Arco<E,T>> it2 = grafo.arcos();
                
        int grado = 0;
        int numArcos = 0;
        
        while(it.hasNext()){
           
            Vertice<E> vertice = it.next();
            grado += numAdy(vertice, grafo);
            grado += numPred(vertice, grafo);
            
        }
        
       while(it2.hasNext()){
           
           it.next();
           numArcos++;
       }      
       
       return 2*numArcos == grado;
    }
    
    private static <E,T> int numAdy(Vertice<E> v, Grafo<E,T> grafo){
        
        Iterator<Vertice<E>> it = grafo.adyacentes(v);
        
        int toret = 0;
        
        while(it.hasNext()){
            
            it.next();
            toret++;
            
        }
        
        return toret;
    }
    
     private static <E,T> int numPred(Vertice<E> v, Grafo<E,T> grafo){
         
        int toret = 0; 
        Iterator<Arco<E,T>> it = grafo.arcos();
        
        while(it.hasNext()){
            
            Arco<E,T> arco = it.next();
            
            if(arco.getDestino().equals(v)) toret++;
        }
        
        return toret;
}
     

}