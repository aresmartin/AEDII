/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;

import grafo.*;
import java.util.ArrayList;
import mapa.*;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Ana
 */
public class Practica7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }

    
    //Ejercicio_1
//    public static <E,T>Iterator<Vertice<E>> predecesores(Grafo<E,T> g, Vertice<E> v){
//        List<Vertice<E>> pred = new ArrayList<>();
//        Iterator<Vertice<E>> it = g.vertices();
//        while(it.hasNext()){
//            Vertice<E> w = it.next();
//            Iterator<Vertice<E>> it2 = g.adyacentes(w);
//            while(it2.hasNext()){
//                if(it2.next().equals(v)){
//                    pred.add(w);
//                }
//            }
//        }
//        return pred.iterator();
//    }

    //Ejercicio_2
    public static <E, T> boolean esSumidero(Grafo<E, T> g, Vertice<E> v) {
        Iterator<Vertice<E>> vertices = g.vertices();
        int numVertices = 0;
        int numPredecesores = 0;
        int numSucesores = 0;

        if (g.esVacio()) {
            return false;
        }

        while (vertices.hasNext()) {
            vertices.next();
            numVertices++;
        }

        //Miramos los predecesores y sucesores del grafo
        Iterator<Arco<E, T>> arcos = g.arcos();

        while (arcos.hasNext()) {
            Arco<E, T> arcoA = arcos.next();

            if (arcoA.getDestino().equals(v)) {
                numPredecesores++;
            }

            if (arcoA.getOrigen().equals(v)) {
                numSucesores++;
            }
        }

        return numPredecesores == numVertices - 1 && numSucesores == 0;

    }

    //Ejercicio_3
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

    //Ejercicio_4
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
                    encontrado = esCamino(g, adyacente , v2, visitados);
                }

            }
        }

        return encontrado;

    }

    static Iterator<Vertice<String>> predecesores(Grafo<String, Integer> g, Vertice<String> v4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
    
  

}
