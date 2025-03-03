/*
 * Clase MapaAdyacencia que implementa la interfaz Grafo utilizando un mapa de adyacencia
 * con un mapa de vértices y sus respectivos arcos.
 */
package com.mycompany.solactividad6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Clase genérica MapaAdyacencia para representar grafos con vértices y arcos.
 */
public class MapaAdyacencia<E, T> implements Grafo<E, T> {
    
    // Mapa que almacena cada vértice y su mapa de vértices adyacentes con sus respectivas etiquetas de arco.
    private Map<Vertice<E>, Map<Vertice<E>, T>> mapaVertices;

    // Constructor que inicializa el mapa de vértices
    public MapaAdyacencia() {
        mapaVertices = new HashMap<>();
    }

    // Método que verifica si el grafo está vacío
    @Override
    public boolean esVacio() {
        return mapaVertices.isEmpty();
    }

    // Método que verifica si un vértice está en el grafo
    @Override
    public boolean estaVertice(Vertice<E> v) {
        return mapaVertices.esta(v);
    }

    // Método que verifica si un arco entre dos vértices específicos existe en el grafo
    @Override
    public boolean estaArco(Arco<E, T> a) {
        Vertice<E> origen = a.getOrigen();
        Vertice<E> destino = a.getDestino();
        // Verifica si el vértice origen existe y si el destino está entre sus adyacentes
        return mapaVertices.esta(origen) && mapaVertices.get(origen).esta(destino);
    }

    // Método que devuelve un iterador para recorrer los vértices del grafo
    @Override
    public Iterator<Vertice<E>> vertices() {
        return mapaVertices.keySet();
    }

    // Método que devuelve un iterador para recorrer los arcos del grafo
    @Override
    public Iterator<Arco<E, T>> arcos() {
        List<Arco<E, T>> listaArcos = new ArrayList<>();
        Iterator<Vertice<E>> iterVertices = mapaVertices.keySet();
        
        // Convierte el iterador de vértices a una lista temporal para iterar con for-each
        List<Vertice<E>> vertices = new ArrayList<>();
        while (iterVertices.hasNext()) {
            vertices.add(iterVertices.next());
        }

        // Recorre cada vértice origen
        for (Vertice<E> origen : vertices) {
            Map<Vertice<E>, T> adyacentes = mapaVertices.get(origen);
            
            // Convierte el iterador de adyacentes a una lista temporal para iterar con for-each
            List<Vertice<E>> destinos = new ArrayList<>();
            Iterator<Vertice<E>> iterDestinos = adyacentes.keySet();
            while (iterDestinos.hasNext()) {
                destinos.add(iterDestinos.next());
            }

            // Recorre cada vértice destino para crear el arco correspondiente y agregarlo a la lista de arcos
            for (Vertice<E> destino : destinos) {
                listaArcos.add(new Arco<>(origen, destino, adyacentes.get(destino)));
            }
        }
        // Retorna un iterador para la lista de arcos
        return listaArcos.iterator();
    }

    // Método que devuelve un iterador para los vértices adyacentes de un vértice específico
    @Override
    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
        if (mapaVertices.esta(v)) {
            return mapaVertices.get(v).keySet();
        }
        return Collections.emptyIterator(); // Retorna un iterador vacío si el vértice no tiene adyacentes
    }

    // Método para insertar un vértice en el grafo
    @Override
    public void insertarVertice(Vertice<E> v) {
        if (!mapaVertices.esta(v)) {
            mapaVertices.put(v, new HashMap<>()); // Crea un nuevo mapa de adyacentes para el vértice
        }
    }

    // Método para insertar un arco entre dos vértices en el grafo
    @Override
    public void insertarArco(Arco<E, T> a) {
        Vertice<E> origen = a.getOrigen();
        Vertice<E> destino = a.getDestino();
        T etiqueta = a.getEtiqueta();

        // Verifica si el vértice origen existe, si no, lo agrega
        if (!mapaVertices.esta(origen)) {
            mapaVertices.put(origen, new HashMap<>());
        }
        // Agrega el vértice destino y la etiqueta del arco al mapa de adyacentes del origen
        mapaVertices.get(origen).put(destino, etiqueta);
    }

    // Método para eliminar un vértice del grafo junto con todos los arcos asociados a él
    @Override
    public void eliminarVertice(Vertice<E> v) {
        mapaVertices.remove(v); // Elimina el vértice y sus adyacentes del mapa

        // Recorre los vértices para eliminar referencias a este vértice en sus adyacentes
        for (Iterator<Vertice<E>> iter = mapaVertices.keySet(); iter.hasNext();) {
            Vertice<E> origen = iter.next();
            mapaVertices.get(origen).remove(v);
        }
    }

    // Método para eliminar un arco específico entre dos vértices
    @Override
    public void eliminarArco(Arco<E, T> a) {
        Vertice<E> origen = a.getOrigen();
        Vertice<E> destino = a.getDestino();

        // Verifica si el vértice origen existe y elimina el arco hacia el destino
        if (mapaVertices.esta(origen)) {
            mapaVertices.get(origen).remove(destino);
        }
    }
}
