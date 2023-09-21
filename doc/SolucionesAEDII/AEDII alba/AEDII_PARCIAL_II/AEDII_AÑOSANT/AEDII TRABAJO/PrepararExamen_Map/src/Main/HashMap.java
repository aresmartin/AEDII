/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Yo
 */
public class HashMap<K, V> implements Map<K, V> {
    //preguntar pk capacidad constructor
    //preguntar pk arraylist
    private List<Par<K, V>> vector[];
    int numeroPares;
    int capacidad;

    //constructor
    public HashMap(int capacidad) throws IllegalArgumentException {
        if (capacidad < 0) {
            throw new IllegalArgumentException("ERROR");
        }
        this.capacidad = capacidad;
        numeroPares = 0;
        vector = new List[capacidad];
        for (int i = 0; i < capacidad; i++) {
            vector[i] = new ArrayList<>();
        }
    }

    private int funcionHash(K clave) {
        return Math.abs(clave.hashCode()) % vector.length;
    }

    @Override
    public int size() {
        return numeroPares;
    }

    @Override
    public boolean isEmpty() {
        return numeroPares == 0;
    }

    @Override
    public V get(K clave) {
        int recorrer = funcionHash(clave);
        for (Par<K, V> p : vector[recorrer]) {
            if (p.getKey().equals(clave)) {
                p.getValue();
            }
        }
        return null;
    }

    @Override
    public void put(K clave, V valor) {
        int recorrer = funcionHash(clave);
        if (get(clave) == null) {
            vector[recorrer].add(new Pares(clave, valor));
            numeroPares++;
        } else {

            for (Par<K, V> p : vector[recorrer]) {
                if (p.getKey().equals(clave)) {
                    p.setValue(valor);
                }
            }
        }
    }

    @Override
    public V remove(K clave) {
        int recorrer = funcionHash(clave);
        V valor1 = get(clave);
        if (valor1 != null) {
            for (Par<K, V> p : vector[recorrer]) {
                if (p.getKey().equals(clave)) {
                    vector[recorrer].remove(p);
                    numeroPares--;
                    return valor1;
                }
            }
        }
        return null;

    }

    @Override
    public void clear() {
        for (int i = 0; i < capacidad; i++) {
            for (Par<K, V> p : vector[i]) {
                remove(p.getKey());
            }
        }

    }

    @Override
    public boolean esta(K clave) {
        int recorrer = funcionHash(clave);
        for (Par<K, V> p : vector[recorrer]) {
            if (p.getKey().equals(clave)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<K> keySet() {
        List<K> claves = new ArrayList<>();
        for (int i = 0; i < vector.length; i++) {
            for (Par<K, V> p : vector[i]) {
                claves.add(p.getKey());
            }
        }
        return claves.iterator();
    }

    @Override
    public Iterator<V> values() {
        List<V> valores = new ArrayList<>();
        for (int i = 0; i < vector.length; i++) {
            for (Par<K, V> p : vector[i]) {
                valores.add(p.getValue());
            }
        }
        return valores.iterator();

    }

}
