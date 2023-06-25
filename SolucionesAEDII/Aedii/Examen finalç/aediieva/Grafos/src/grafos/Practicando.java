
package grafos;

import java.util.*;
import grafo.*;
import java.util.Iterator;

public class Practicando {
    
    public static <E,T> Iterator<Vertice<E>> predecesores(Grafo <E,T> g, Vertice<E> v){
        
        List<Vertice<E>> toret = new ArrayList<>();
        
        Iterator<Arco<E,T>> it = g.arcos();
        
        while(it.hasNext()){
            
            Arco<E,T> arco = it.next();
            
            if(arco.getDestino().equals(v)) toret.add(arco.getOrigen());
        }
        
        return toret.iterator();
    }
    
    public static <E,T> boolean esSumidero(Grafo <E,T> g, Vertice<E> v){
        
        Iterator<Vertice<E>> it = g.adyacentes(v);
        
        if(it.hasNext()) return false;
        
        int contador1 = 0;
        int contador2 = 0;
        
        Iterator<Vertice<E>> it2 = g.vertices();
        
        while(it2.hasNext()){
            
            Vertice<E> vertice = it2.next();
            contador1++;
            Iterator<Vertice<E>> adyacentes = g.adyacentes(vertice);
            
            while(adyacentes.hasNext()){
                
                if(it.next().equals(v))
                contador2++;
            }
        }
        
        
        
        return (contador1 - 1) == contador2;
    }
    
    public static <E,T> boolean esSumideroConPredecesores(Grafo <E,T> g, Vertice<E> v){
        
        Iterator<Vertice<E>> adyacentes = g.adyacentes(v);
        
        if(adyacentes.hasNext()) return false;
        
        Iterator<Vertice<E>> predecesores = predecesores(g,v);
        
        int contador1 = 0;
        
        while(predecesores.hasNext()){
            
            predecesores.next();
            contador1++;
        }
        
        Iterator<Vertice<E>> vertices = g.vertices();
        
        int contador2 = 0;
        
        while(vertices.hasNext()){
            
            vertices.next();
            contador2++;
        }
        
        return (contador2 - 1) == contador1;
    }
    
    public static <E,T> boolean regular(Grafo <E,T> g){
        
        Iterator<Vertice<E>> vertices = g.vertices();
        
        Vertice<E> vertice = vertices.next();
        
        Iterator<Vertice<E>> adyacentes = g.adyacentes(vertice);
        int contador1 = 0;
        
        while(adyacentes.hasNext()){
            
            adyacentes.next();
            contador1++;
        }
        
        while(vertices.hasNext()){
            
            vertice = vertices.next();
            adyacentes = g.adyacentes(vertice);
            int contador2 = 0;
            
            while(adyacentes.hasNext()){
                
                adyacentes.next();
                contador2++;
            }
            
            if(contador1 != contador2) return false; 
        }
        
        return true;
    }
}
