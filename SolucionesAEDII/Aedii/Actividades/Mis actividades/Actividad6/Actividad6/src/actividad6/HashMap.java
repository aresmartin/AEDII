/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author celticjordan
 */
public class HashMap<K, V> implements Map<K, V> {

    private int capacity;
    private int numElements;
    private List<Map.Par<K, V>>[] data;

    public HashMap(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad no puede ser negativa");
        } else {
            this.capacity = capacity;
            numElements = 0;
            data = new List[capacity];
            for (int i = 0; i < capacity; i++) {
                data[i] = new LinkedList<>();
            }
        }
    }

    public HashMap() {
        this(50);
    }

    private int funcionHash(K clave) {
        return Math.abs(clave.hashCode()) % capacity;
    }

    @Override
    public int tamaño() {
        return numElements;
    }

    @Override
    public V get(K clave) {
        int index = funcionHash(clave);
        for (Map.Par<K, V> p : data[index]) {
            if (p.getClave().equals(clave)) {
                return p.getValor();
            }
        }
        return null;
    }

    @Override
    public void insertar(K clave, V valor) {
        V v = get(clave);
        int index = funcionHash(clave);
        if (v != null) {
            for (Map.Par<K, V> p : data[index]) {
                if (p.getClave().equals(clave)) {
                    p.setValor(valor);
                }
            }
        } else {
            data[index].add(new HashPar<>(clave, valor));
            numElements++;
        }
    }

    @Override
    public V eliminar(K clave) {
        int index = funcionHash(clave);
        if (data[index].contains(new HashPar<>(clave, get(clave)))) {
            V valor = get(clave);
            data[index].remove(new HashPar<>(clave, valor));
            numElements--;
            return valor;
        } else {
            return null;
        }
    }

    @Override
    public Iterator<K> getClaves() {
        Vector<K> vector = new Vector<>();
        for (int index = 0; index < capacity; index++) {
            for (Map.Par<K, V> p : data[index]) {
                vector.add(p.getClave());
            }
        }
        return vector.iterator();
    }

    @Override
    public Iterator<V> getValores() {
        Vector<V> vector = new Vector<>();
        for (List<Map.Par<K, V>> lista : data) {
            for (Map.Par<K, V> p : lista) {
                vector.add(p.getValor());
            }
        }
        return vector.iterator();
    }

    static class HashPar<K, V> implements Map.Par<K, V> {

        K clave;
        V valor;

        HashPar(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        @Override
        public K getClave() {
            return clave;
        }

        @Override
        public V getValor() {
            return valor;
        }

        @Override
        public void setValor(V nuevo) {
            valor = nuevo;
        }

        @Override
        public boolean equals(Object o) {
            HashPar<K, V> hp = (HashPar<K, V>) o;
            return clave.equals(hp.clave) && valor.equals(hp.valor);
        }

    }

}
