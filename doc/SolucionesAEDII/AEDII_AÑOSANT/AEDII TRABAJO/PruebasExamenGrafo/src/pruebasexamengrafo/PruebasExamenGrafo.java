/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasexamengrafo;

import cola.Cola;
import cola.EnlazadaCola;
import grafo.Arco;
import grafo.Grafo;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import lista.Lista;
import lista.ListaEnlazada;

/**
 *
 * @author Yo
 */
public class PruebasExamenGrafo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    /*  public static <E,T>Iterator<Vertice<E>>predecesores(Grafo<E,T> g, Vertice<E> v){
        Vector<Vertice<E>> predec=new Vector<>();
        Iterator<Vertice<E>> itv = g.vertices();
        while(itv.hasNext()){
            Vertice<E> w = itv.next();
            Iterator<Vertice<E>> it2 = g.adyacentes(w);
            while(it2.hasNext()){
                if(it2.next().equals(v)){
                    predec.add(w);
                }
            }
        }
        return predec.iterator();
    }
    
    
    public <E,T> boolean regular(Grafo<E,T> g){
        int numAdy = 0;
        Iterator<Vertice<E>> itv = g.vertices();
        while(itv.hasNext()){
            Vertice<E> w = itv.next();
            Iterator<Vertice<E>> it2 = g.adyacentes(w);
            while(it2.hasNext()){
                it2.next();
                numAdy++;
            }
        }
    }*/
    public static <E, T> Iterator<Vertice<E>> predecesores(Grafo<E, T> g, Vertice<E> v) {
        List<Vertice<E>> pred = new ArrayList<>();
        Iterator<Vertice<E>> it = g.vertices();
        while (it.hasNext()) {
            Vertice<E> w = it.next();
            Iterator<Vertice<E>> it2 = g.adyacentes(w);
            while (it2.hasNext()) {
                Vertice<E> ww = it2.next();
                if (ww.equals(v)) {
                    pred.add(w);
                }
            }

        }
        return pred.iterator();
    }

    public static <E, T> boolean Sumidero(Grafo<E, T> g, Vertice<E> v) {

        int n = 0;
        int gradoEntrada = 0;
        int gradoSalida = 0;
        Iterator<Vertice<E>> it = g.vertices();
        while (it.hasNext()) {
            it.next();
            n++;
        }
        Iterator<Vertice<E>> it2 = predecesores(g, v);
        while (it2.hasNext()) {
            it2.next();
            gradoEntrada++;
        }
        Iterator<Vertice<E>> it3 = g.adyacentes(v);
        while (it3.hasNext()) {
            it3.next();
            gradoSalida++;
        }
        return (gradoEntrada == n - 1 && gradoSalida == 0);

    }

    public static <E, T> boolean regular(Grafo<E, T> g) {
        if (g.esVacio()) {
            return true;
        } else {
            Iterator<Vertice<E>> it = g.vertices();
            Vertice<E> aux = it.next();
            Iterator<Vertice<E>> it2 = g.adyacentes(aux);
            int numAdy = 0;
            while (it2.hasNext()) {
                it2.next();
                numAdy++;
            }
            int numAdy2 = 0;
            while (it.hasNext()) {
                Vertice<E> w = it.next();
                Iterator<Vertice<E>> itady = g.adyacentes(w);
                while (itady.hasNext()) {
                    itady.next();
                    numAdy2++;
                }
                if (numAdy != numAdy2) {
                    return false;
                }
            }
            return true;

        }

    }

    public static <E, T> boolean esRegular(Grafo<E, T> g) {
        if (g.esVacio()) {
            return true;
        }
        Iterator<Vertice<E>> it1 = g.vertices();
        Vertice<E> aux = it1.next();
        int ady1 = 0;
        Iterator<Vertice<E>> it2 = g.adyacentes(aux);
        while (it2.hasNext()) {
            it2.next();
            ady1++;

        }
        int numAdy2 = 0;
        while (it1.hasNext()) {
            Vertice<E> v1 = it1.next();
            Iterator<Vertice<E>> it3 = g.adyacentes(v1);
            while (it3.hasNext()) {
                it3.next();
                numAdy2++;
            }
            if (ady1 != numAdy2) {
                return false;
            }
        }
        return true;
    }

    public static <E, T> boolean esCamino(Grafo<E, T> g, Vertice<E> v1, Vertice<E> v2, Lista<Vertice<E>> visitados) {

        visitados.insertarFinal(v1);

        boolean encontrado = false;

        if (v2.equals(v1)) {
            encontrado = true;
        } else {
            Iterator<Vertice<E>> ady = g.adyacentes(v1);
            while (ady.hasNext() && !encontrado) {
                Vertice<E> aux = ady.next();
                if (visitados.contiene(aux)) {
                    encontrado = esCamino(g, aux, v2, visitados);
                }
            }

        }
        return encontrado;

    }

    public static <E, T> boolean esCiclo(Grafo<E, T> g, List<Vertice<E>> camino) {
        Iterator<Arco<E, T>> itArco = g.arcos();
        int i = 0;
        boolean esCiclo = false;
        if (camino.get(0).equals(camino.get(camino.size()))) {
            while (i < camino.size()) {
                Arco<E, T> arco = new Arco(camino.get(i), camino.get(i + 1), camino.get(i).getEtiqueta());
                if (g.estaArco(arco)) {
                    esCiclo = true;
                }
                i++;
            }
            return esCiclo;
        }

        return false;
    }

    public static <E, T> List<Vertice<E>> aislado(Grafo<E, T> g) {
        List<Vertice<E>> listaAislados = new ArrayList<>();
        Iterator<Vertice<E>> it = g.vertices();

        while (it.hasNext()) {
            Vertice<E> aux = it.next();
            Iterator<Vertice<E>> it2 = g.adyacentes(aux);
            int nAdy = 0;
            while (it2.hasNext()) {
                it.next();
                nAdy++;
            }
            int nSuc = 0;
            Iterator<Vertice<E>> it3 = g.vertices();
            while (it3.hasNext()) {
                Vertice<E> aux2 = it3.next();
                Iterator<Vertice<E>> it4 = g.adyacentes(aux2);
                while (it4.hasNext()) {
                    Vertice<E> iguales = it4.next();
                    if (iguales.equals(aux)) {
                        nSuc++;
                    }
                }

            }
            if (nAdy == 0 && nSuc == 0) {
                listaAislados.add(aux);
            }

        }

        return listaAislados;

    }

    public static <E, T> void profundidad(Grafo<E, T> g, Vertice<E> v) {
        Vector<Vertice<E>> v1 = new Vector<>();
        profundidad(g, v, v1);

    }

    private static <E, T> void profundidad(Grafo<E, T> g, Vertice<E> v, Vector<Vertice<E>> visitados) {

        System.out.println(v);
        visitados.add(v);
        Iterator<Vertice<E>> ady = g.adyacentes(v);
        while (ady.hasNext()) {
            Vertice<E> w = ady.next();
            if (!visitados.contains(w)) {
                profundidad(g, w, visitados);
            }
        }

    }

    public static <E, T> void anchura(Grafo<E, T> g, Vertice<E> v) {
        List<Vertice<E>> visitados = new ArrayList<>();
        Cola<Vertice<E>> porExplorar = new EnlazadaCola();
        porExplorar.insertar(v);
        visitados.add(v);
        do {
            v = porExplorar.suprimir();
            System.out.println(v);
            Iterator<Vertice<E>> ady = g.adyacentes(v);
            while (ady.hasNext()) {
                Vertice<E> w = ady.next();
                if (!visitados.contains(w)) {
                    porExplorar.insertar(w);
                    visitados.add(w);
                }

            }

        } while (!porExplorar.esVacio());

    }
}
