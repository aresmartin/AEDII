/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class HashMap<K,V> implements Map<K,V> {
    
    private final int CAPACIDAD = 50;
    private List<Par<K,V>> array[];
    private int numeroPares;    
    
    /*Constructor: se encarga de crear un array de listas con una capacidad por defecto*/
    public HashMap(){
        numeroPares = 0;
        array = new List[CAPACIDAD];
        for (int i = 0; i < CAPACIDAD; i++) {
            array[i] = new ArrayList<>();
        }
    }
    
    /*Constructor: se encarga de crear un array de listas pasandole la capacidad*/
    public HashMap(int c)throws IllegalArgumentException{
        if(c < 0){
            throw new IllegalArgumentException("ERROR: capacidad negativa");
        }
        
        numeroPares = 0;
        array = new List[c];
        for (int i = 0; i < c; i++) {
            array[i] = new ArrayList<>();
        }
    }
    
    /*Transforma una clave en un índice del array.
    Math.abs-->calcula el valor absoluto
    hashCode-->convierte el objeto en un entero*/
    private int funcionHash(K clave){
        return Math.abs(clave.hashCode()) % array.length;
    }
    
    @Override
    public int size(){
        return numeroPares;
    }
    
    @Override
    public boolean isEmpty(){
        return numeroPares == 0;
    }
    
    @Override
    public V get(K clave){
        int toret = funcionHash(clave);
        for (Par<K,V> p:array[toret]) {
            if(p.getKey().equals(clave)){
                return p.getValue();
            }
        }
        return null;
    }
    
    @Override
    public void put(K clave, V valor){
        int toret = funcionHash(clave);
        V valor1 = get(clave);
        if (valor1 == null){
            array[toret].add(new Pares(clave,valor));
            numeroPares++;
        }
        else{
           for(Par<K,V> p:array[toret]){
               if(p.getKey().equals(clave)){
                   p.setValue(valor);
               }
           } 
        }
    }
    
    @Override
    public V remove(K clave){
        int toret = funcionHash(clave);
        V valor1 = get(clave);
        if(valor1 != null){
            for (Par<K,V> p:array[toret]) {
                if(p.getKey().equals(clave)){
                    array[toret].remove(p);
                    numeroPares--;
                    return valor1;
                }
            }
        }
        return null;
    }
    
    @Override
    public void clear(){
        for (int i = 0; i < array.length; i++) {
            for(Par<K,V> p:array[i]){
                remove(p.getKey());
            }
        }
    }
    
    @Override
    public boolean esta(K clave){
        int toret = funcionHash(clave);
        for (Par<K,V> p:array[toret]){
            if(p.getKey().equals(clave)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Iterator<K> keySet(){
        List<K> claves = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            for (Par<K,V> p:array[i]){
                claves.add(p.getKey());
            }
        }
        return claves.iterator();
    }
    
    @Override
    public Iterator<V> values(){
        List<V> valores = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            for (Par<K,V> p:array[i]){
                valores.add(p.getValue());
            }
        }
        return valores.iterator();
    
    }

    @Override
    public void insertar(String abbrev, String string) {
        this.put((K) abbrev, (V) string);
    }

    @Override
    public void insertar(String lang, Map<String, String> dict) {
        this.put((K) lang, (V) dict);
    }
}
