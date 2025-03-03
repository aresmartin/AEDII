/*
 * Clase HashMap que implementa la interfaz Map, utilizando un array de listas enlazadas para manejar colisiones
 * y almacenar pares de clave-valor.
 */
package com.mycompany.solactividad6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashMap<K, V> implements Map<K, V> {

    // Array de listas de pares clave-valor, utilizado para almacenar elementos en cada índice del hash
    private List<Par<K, V>> array[];
    // Número de pares clave-valor en el mapa
    private int numeroPares;
    // Capacidad del array
    private int capacidad;

    // Constructor que inicializa el mapa con una capacidad específica
    public HashMap(int capacidad) throws IllegalArgumentException {
        if (capacidad < 1) {
            throw new IllegalArgumentException("ERROR: Argumento invalido");
        }

        this.capacidad = capacidad;
        numeroPares = 0;
        array = new List[capacidad];
        // Inicializa cada índice del array con una lista vacía para manejar colisiones
        for (int i = 0; i < capacidad; i++) {
            array[i] = new ArrayList<>();
        }
    }

    // Constructor sin argumentos que inicializa el mapa con una capacidad por defecto de 50
    public HashMap(){
        this(50);
    }

    /* 
     * Función hash que convierte una clave en un índice dentro del array.
     * Math.abs calcula el valor absoluto del hash para evitar índices negativos.
     * hashCode convierte la clave en un entero.
     */
    private int funcionHash(K clave) {
        return Math.abs(clave.hashCode()) % array.length;
    }

    // Método que devuelve el número de pares clave-valor en el mapa
    public int size() {
        return numeroPares;
    }

    // Método que verifica si el mapa está vacío
    public boolean isEmpty() {
        return numeroPares == 0;
    }

    // Método que obtiene el valor asociado a una clave
    public V get(K clave) {
        int hash = funcionHash(clave);

        // Recorre la lista en el índice hash para buscar la clave
        for (Par<K, V> p : array[hash]) {
            if (p.getKey().equals(clave)) {
                return p.getValue();
            }
        }
        // Retorna null si la clave no se encuentra
        return null;
    }

    // Método que inserta o actualiza un par clave-valor en el mapa
    public void put(K clave, V valor) throws NullPointerException {
        if (clave == null || valor == null) {
            throw new NullPointerException("La clave o el valor es nulo");
        }

        int hash = funcionHash(clave);
        V estaValue = get(clave);

        // Si la clave no existe, crea un nuevo par y lo agrega a la lista en el índice hash
        if (estaValue == null) {
            array[hash].add(new Pares(clave, valor));
            numeroPares++;
        } else {
            // Si la clave ya existe, actualiza el valor del par
            for (Par<K, V> p : array[hash]) {
                if (p.getKey().equals(clave)) {
                    p.setValue(valor);
                }
            }
        }
    }

    // Método que elimina un par clave-valor del mapa y devuelve el valor eliminado
    public V remove(K clave) throws NullPointerException {
        if (clave == null) {
            throw new NullPointerException("La clave es nula");
        }

        int hash = funcionHash(clave);
        V estaValue = get(clave);

        // Si la clave existe, elimina el par de la lista en el índice hash
        if (estaValue != null) {
            for (Par<K, V> p : array[hash]) {
                if (p.getKey().equals(clave)) {
                    array[hash].remove(p);
                    numeroPares--;
                    return estaValue;
                }
            }
        }
        // Retorna null si la clave no se encuentra
        return null;
    }

    // Método que elimina todos los pares clave-valor del mapa
    public void clear() {
        // Recorre el array y elimina cada par en cada lista
        for (int i = 0; i < array.length; i++) {
            for (Par<K, V> p : array[i]) {
                remove(p.getKey());
            }
        }
    }

    // Método que verifica si una clave existe en el mapa
    public boolean esta(K clave) {
        int hash = funcionHash(clave);

        // Recorre la lista en el índice hash para verificar si la clave existe
        for (Par<K, V> p : array[hash]) {
            if (p.getKey().equals(clave)) {
                return true;
            }
        }
        return false;
    }

    // Método que devuelve un iterador de todas las claves en el mapa
    public Iterator<K> keySet() {
        List<K> toret = new ArrayList<>();

        // Recorre el array y agrega cada clave a la lista de claves
        for (int i = 0; i < array.length; i++) {
            for (Par<K, V> p : array[i]) {
                toret.add(p.getKey());
            }
        }
        return toret.iterator();
    }

    // Método que devuelve un iterador de todos los valores en el mapa
    public Iterator<V> values() {
        List<V> toret = new ArrayList<>();

        // Recorre el array y agrega cada valor a la lista de valores
        for (int i = 0; i < array.length; i++) {
            for (Par<K, V> p : array[i]) {
                toret.add(p.getValue());
            }
        }
        return toret.iterator();
    }

    // Método placeholder que no está implementado
    public Iterable<Par<Integer, Double>> pares() {
        throw new UnsupportedOperationException("Not supported yet."); // Método no implementado
    }
}
