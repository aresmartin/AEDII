/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad7;

import grafo.*;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author LenovoPavon
 */
public class SolActividad7 {
        //Ejercicio 1
        public static <E,T> Iterator<Vertice<E>> predecesores (Grafo<E,T> g, Vertice<E> v ){
            Vector<Vertice<E>> pred = new Vector<>();
            Iterator<Vertice<E>> itVer = g.vertices();
            while (itVer.hasNext()){
                Vertice<E> w = itVer.next();
                Iterator<Vertice<E>> itAdy = g.adyacentes(w);
                while (itAdy.hasNext())
                    if (itAdy.next().equals(v)) 
                        pred.add(w);
            }
            return pred.iterator();
        }

        //Ejercicio 2
        public static <E,T> boolean sumidero (Grafo<E,T> g, Vertice<E> v){
                Iterator<Vertice<E>> itVer = g.adyacentes(v);
                if (itVer.hasNext())
                   return false;
                //numero de vértices y grado de entrada
                int numVertices = 0, numPred = 0;
                itVer = g.vertices();
                while (itVer.hasNext()){
                    Vertice<E> w = itVer.next();
                    numVertices++;
                    Iterator<Vertice<E>> itAdy = g.adyacentes(w);
                    while (itAdy.hasNext())
                        if (itAdy.next().equals(v)) 
                            numPred++;
                }
                return numPred==numVertices-1;
        }

        //Ejercicio 3
        public static <E,T> boolean regular (Grafo<E,T> g){
            if (g.esVacio()) return true;
            Iterator<Vertice<E>> itVer = g.vertices();
            Vertice<E> v = itVer.next();
            Iterator<Vertice<E>> itAdy = g.adyacentes(v);
            int numAdy = 0;
            while (itAdy.hasNext()){
                numAdy++;
                itAdy.next();
            }
            while (itVer.hasNext()){
                v = itVer.next();
                itAdy = g.adyacentes(v);
                int contador = 0;
                while (itAdy.hasNext()){
                    contador++;
                    itAdy.next();
                }
                if (contador!=numAdy)
                    return false;
            }
            return true;
        }

        //Ejercicio 4
        public static <E,T> boolean hayCaminoEntreDos (Grafo<E,T> g, Vertice<E> v1, Vertice<E> v2){
            Vector<Vertice<E>> visitados = new Vector<>();
            return caminoEntreDos(g,v1,v2,visitados);
        } 

        private static <E,T> boolean caminoEntreDos (Grafo<E,T> g,Vertice<E> v1, Vertice<E> v2, Vector<Vertice<E>> visitados){
            boolean encontrado=false;
            visitados.add(v1);
            if (v1.equals(v2))
                return true;
            else {
                Iterator<Vertice<E>> adys = g.adyacentes(v1);
                while (adys.hasNext()&& !encontrado){
                    Vertice<E> w = adys.next();
                    if (!visitados.contains(w))
                      encontrado = caminoEntreDos(g, w, v2, visitados);
                }
               return encontrado;
            }
        }


        //Ejercicio 5
        
        private static <E,T> int size(Iterator<Vertice<E>> i){
            int cont = 0;
            while(i.hasNext()){
                    cont++;
                    i.next();
            }
            return cont;
	}
        
        //recorrido en profundidad
	public static <E,T> void profundidad (Grafo<E,T> g, Vertice<E> v) {
		Vector<Vertice<E>> visitados = new Vector<Vertice<E>>();
		profundidad(g, v, visitados);
	}
	private static <E,T> void profundidad(Grafo<E,T> g, Vertice<E> v, Vector<Vertice<E>> visitados)
	{   
		visitados.add(v);
		Iterator<Vertice<E>> adys = g.adyacentes(v);
		while (adys.hasNext()){
			Vertice<E> w = adys.next();
			if (!visitados.contains(w))
				profundidad(g, w, visitados);
		}
	} 
        
	public static <E,T> Vertice<E> esArborescencia (Grafo<E,T> g){
            Iterator<Vertice<E>> ver = g.vertices();
            while(ver.hasNext()){
                    Vector<Vertice<E>> visitados = new Vector<>();
                    Vertice<E> v = ver.next();
                    profundidad(g,v,visitados);
                    //comparar el conjunto de visitados con el conjunto de vértices del grafo
                    if (size(visitados.iterator())==size(g.vertices())) return v;
            }
            return null;
	} 
        
        
        //ejercicio no propuesto
       
        public static <E,T> Iterator<Vertice<E>> noAlcanzables (Grafo<E,T> g, Vertice<E> v){
            Vector<Vertice<E>> porVisitar = new Vector<>();
            Iterator<Vertice<E>> itVer = g.vertices();
            while (itVer.hasNext()){
                    porVisitar.add(itVer.next());
            }

            return noAlcanzables(g,v,porVisitar);
        }
        private static <E,T> Iterator<Vertice<E>> noAlcanzables (Grafo<E,T> g, Vertice<E> v, Vector<Vertice<E>> porVisitar){
            porVisitar.remove(v);
            Iterator<Vertice<E>> itAdy = g.adyacentes(v);
            while(itAdy.hasNext()){
                    Vertice<E> ady = itAdy.next();
                    if(porVisitar.contains(ady)) 
                        return noAlcanzables(g,ady,porVisitar); 
            }
            return porVisitar.iterator();
        }


        
        //determinar si hay un ciclo que tenga como origen el vértice v
        public static <E,T> boolean hayCiclo(Grafo<E,T> g, Vertice<E> v){
                Vector<Vertice<E>> visitados = new Vector<Vertice<E>>();
                return hayCiclo(g,v,v,visitados);
        }
        private static <E,T> boolean hayCiclo(Grafo<E,T> g, Vertice<E> vOrigen, Vertice<E> v, Vector<Vertice<E>> visitados){
                boolean encontrado = false;

                visitados.add(v);
                Iterator<Vertice<E>> adys = g.adyacentes(v);
                while (adys.hasNext()&& !encontrado){
                    Vertice<E> w = adys.next();
                    if (vOrigen.equals(w))
                            encontrado = true;
                    else if (!visitados.contains(w))
                                    encontrado = hayCiclo(g, vOrigen, w, visitados);
                }

                return encontrado;
        }
		
    
}
