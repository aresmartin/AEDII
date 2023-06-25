
package solactividad6.Dijkstra;

import grafo.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mapa.*;


public class Dijkstra {
    
    public static <E> Map<Vertice<E>,Integer> dijkstra(Grafo<E,Integer> g, Vertice<E> v)
{
	     final Integer INFINITO = Integer.MAX_VALUE;
	     Map<Vertice<E>,Integer> distancia = new HashMap<>();
	     Set<Vertice<E>> porVisitar = new HashSet<>(); 
	     
	     Iterator<Vertice<E>> it_v = g.vertices();
	     
	     while (it_v.hasNext())
	     {
	         Vertice<E> vert = it_v.next();
	         distancia.insertar(vert,INFINITO);
	         porVisitar.add(vert);
	     }
             
             distancia.insertar(v,0);
	        
	     while (!porVisitar.isEmpty())
	     {
	           Vertice<E> vMinimo = minimo(distancia,porVisitar.iterator());
	           porVisitar.remove(vMinimo);
	           Integer dis_vMinimo;
                   dis_vMinimo = distancia.get(vMinimo);
	           
	           if (!dis_vMinimo.equals(INFINITO))
	           {
	            Iterator<Arco<E,Integer>> arc = g.arcos();
	            Integer pesoArcoElegido = 0;
	            while (arc.hasNext()) 
	            {
	                Arco<E,Integer> a1 = arc.next();
                        Vertice<E> wDestino = a1.getDestino();
	                if (a1.getOrigen().equals(vMinimo) && porVisitar.contains(wDestino)){
	                   pesoArcoElegido = a1.getEtiqueta();   
	                
	                   Integer dw = distancia.get(wDestino);
	                   if ( dis_vMinimo+pesoArcoElegido < dw){
	                           distancia.insertar(wDestino,dis_vMinimo+pesoArcoElegido);
	                    }  
	               }
	            }
                  }
             }
	     return distancia;   
	    }
    
    private static <E> Vertice<E> minimo (Map<Vertice<E>,Integer> d, Iterator<Vertice<E>> iPorVisitar)
	    {
	        Vertice<E> v, minV = iPorVisitar.next();
	        Integer c, minD = d.get(minV);
	        
	        while (iPorVisitar.hasNext())
	        {
	            v = iPorVisitar.next();
	            c = d.get(v);
	            if (c < minD)
	            {
	                minV = v;
	                minD = c;
	            }
	        }
	        
	        return minV;
	        
	        
	    }
    
}
