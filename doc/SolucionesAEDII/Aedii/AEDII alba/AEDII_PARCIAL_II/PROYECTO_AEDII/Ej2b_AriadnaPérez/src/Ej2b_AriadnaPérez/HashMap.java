package Ej2b_AriadnaPérez;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author LuisFerCou
 */
public class HashMap<K, V> implements Map<K, V> {

    private List<Par<K, V>> array[];
    private int numeroPares;
    private int capacidad;

    public HashMap(int capacidad) throws IllegalArgumentException {
        if (capacidad < 1) {
            throw new IllegalArgumentException("ERROR: Argumento invalido");
        }

        this.capacidad = capacidad;
        numeroPares = 0;
        array = new List[capacidad];
        for (int i = 0; i < capacidad; i++) {
            array[i] = new ArrayList<>();
        }
    }

    /*Transforma una clave en un índice del array.
    Math.abs-->calcula el valor absoluto
    hashCode-->convierte el objeto en un entero*/
    private int funcionHash(K clave) {

        return Math.abs(clave.hashCode()) % array.length;

    }

    public int size() {

        return numeroPares;
    }

    public boolean isEmpty() {

        return numeroPares == 0;
    }

    public V get(K clave) {

        int hash = funcionHash(clave);

        for (Par<K, V> p : array[hash]) {

            if (p.getKey().equals(clave)) {

                return p.getValue();
            }

        }

        return null;
    }

    public void put(K clave, V valor) throws NullPointerException {

        if (clave == null || valor == null) {
            throw new NullPointerException("La clave o el valor es nulo");
        }

        int hash = funcionHash(clave);

        V estaValue = get(clave);

        if (estaValue == null) {

            array[hash].add(new Pares(clave, valor));

        } else {

            for (Par<K, V> p : array[hash]) {

                if (p.getKey().equals(clave)) {

                    p.setValue(valor);
                }

            }

        }
    }

    public V remove(K clave) throws NullPointerException{
        
        if(clave == null){
            throw new NullPointerException("La clave es nula");
        }
        
        int hash = funcionHash(clave);

        V estaValue = get(clave);

        if (estaValue != null) {

            for (Par<K, V> p : array[hash]) {

                if (p.getKey().equals(clave)) {

                    array[hash].remove(p);
                    numeroPares--;
                    return estaValue;

                }

            }

        }

        return null;
    }

    public void clear() {

        for (int i = 0; i < array.length; i++) {

            for (Par<K, V> p : array[i]) {

                remove(p.getKey());
            }
        }
    }

    public boolean esta(K clave) {

        int hash = funcionHash(clave);

        for (Par<K, V> p : array[hash]) {

            if (p.getKey().equals(clave)) {
                return true;
            }
        }

        return false;
    }

    public Iterator<K> keySet() {

        List<K> toret = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {

            for (Par<K, V> p : array[i]) {

                toret.add(p.getKey());
            }
        }
        return toret.iterator();
    }

    public Iterator<V> values() {

        List<V> toret = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {

            for (Par<K, V> p : array[i]) {

                toret.add(p.getValue());
            }
        }

        return toret.iterator();
    }

}
