/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad7;

import grafo.Arco;
import grafo.Grafo;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Alba
 */
public class Actividad7 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    //Ejercicio 1:
    
    public static <E,T>Iterator<Vertice<E>> predecesores(Grafo<E,T> g, Vertice<E> v){
        List<Vertice<E>> pred = new ArrayList<>();
        
        Iterator<Vertice<E>> it = g.vertices();
        while(it.hasNext()){
            Vertice<E> w = it.next();
            Iterator<Vertice<E>> it2 = g.adyacentes(w);
            while(it2.hasNext()){
                if(it2.next().equals(v)){
                    pred.add(w);
                }
            }
        }
        return pred.iterator();
    }
    
    //Ejercicio 2: 
    
    public static <E, T> boolean esSumidero(Grafo<E, T> g, Vertice<E> v) {
        Iterator<Vertice<E>> it = g.vertices();
        int numVertices = 0;
        while (it.hasNext()) {
            it.next();
            numVertices++;
        }

        Iterator<Arco<E, T>> itArco = g.arcos();
        int numGradoEntrada = 0;
        int numGradoSalida = 0;
        while (itArco.hasNext()) {
            if (itArco.next().getDestino().equals(v)) {
                numGradoEntrada++;
            } else {
                if (itArco.next().getOrigen().equals(v)) {
                    numGradoSalida++;
                }
            }

        }

        if (numGradoEntrada == numVertices - 1 && numGradoSalida == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    //Ejercicio 3:
    
    public static <E, T> boolean esRegular(Grafo<E, T> g) {
        Iterator<Vertice<E>> vertices = g.vertices();
        int numAdyacentes = 0;
        int numAdyacentes1 = 0;

        if (g.esVacio()) {
            return true;

        } else {

            Iterator<Vertice<E>> adyacentes1 = g.adyacentes(vertices.next());

            while (adyacentes1.hasNext()) {
                adyacentes1.next();
                numAdyacentes1++;
            }

            while (vertices.hasNext()) {
                Vertice<E> vertice = vertices.next();
                Iterator<Vertice<E>> adyacentes = g.adyacentes(vertice);

                numAdyacentes = 0;

                while (adyacentes.hasNext()) {
                    adyacentes.next();
                    numAdyacentes++;
                }

                if (numAdyacentes1 != numAdyacentes) {
                    return false;
                }
            }

            return true;

        }

    }
    
    //Ejercicio 4:
    
    public static <E, T> boolean esCamino(Grafo<E, T> g, Vertice<E> v1, Vertice<E> v2) {
        Vector<Vertice<E>> visitados = new Vector<>();
        return esCamino(g, v1, v2, visitados);
    }

    private static <E, T> boolean esCamino(Grafo<E, T> g, Vertice<E> v1, Vertice<E> v2, Vector<Vertice<E>> visitados) {
        boolean encontrado = false;
        System.out.println(v1);
        visitados.add(v1);

        if (v1.equals(v2)) {
            return true;
        } else {
            Iterator<Vertice<E>> adyacentes = g.adyacentes(v1);
            while (adyacentes.hasNext() && !encontrado) {
                Vertice<E> adyacente = adyacentes.next();
                if (!visitados.contains(adyacente)) {
                    encontrado = esCamino(g, adyacente, v2, visitados);
                }

            }
        }

        return encontrado;

    }
    
     
    
    
    //EJERCICIO EXAMEN:
    
    public static <E,T> boolean lemaApretonManos(Grafo<E,T> g){
        Iterator<Vertice<E>> it = g.vertices();
        int grado =0;
        
        int numArcos = 0;
        Iterator<Arco<E,T>> it2 = g.arcos();
        while(it2.hasNext()){
            it2.next();
            numArcos ++;
        }
        while(it.hasNext()){
            Vertice<E> v = it.next();
            
            grado += numPredecesores(g, v);
            grado += numAdyacentes(g,v);
            
            if(grado == numArcos * 2){
                return true;    
            }
            
        }
       
        return false;
    }
    
        
    public static <E,T> int numPredecesores(Grafo <E,T> g, Vertice<E> v){
        int numPredecesores = 0;
        
        Iterator<Vertice<E>> it = g.vertices();
        
        while(it.hasNext()){
            Vertice<E> w = it.next();
            Iterator<Vertice<E>> it2 = g.adyacentes(w);
            while(it2.hasNext()){
                if(it2.next().equals(v)){
                    numPredecesores ++;
                }
            }
        }
        
        return numPredecesores;
    }
    
    public static <E,T> int numAdyacentes (Grafo <E,T> g, Vertice<E> v){
        int numAdyacentes = 0;
        
        Iterator<Vertice<E>> it = g.adyacentes(v);
        while(it.hasNext()){
            it.next();
            numAdyacentes++;
     
        }
        
        return numAdyacentes;
    }
    
    
    //Recorrido en profundidad:
    
    public static <E,T> void profundidad (Grafo<E,T> g, Vertice <E> v){
        Vector<Vertice<E>> visitados = new Vector<>();
        profundidad(g,v, visitados);
    }
    
    
    public static <E,T> void profundidad(Grafo<E,T> g, Vertice<E> v, Vector<Vertice<E>> visitados){
        System.out.println(v);
        visitados.add(v);
        
        Iterator<Vertice<E>> it = g.adyacentes(v);
        while(it.hasNext()){
            Vertice<E> w = it.next();
            if(!visitados.contains(w)){
                profundidad(g, w, visitados);
            }
        }
    }
}
