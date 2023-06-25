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
    
    private List<Par<K,V>> array[];
    private int numeroPares;
    private int capacidad;
    
    /*Constructor: se encarga de crear un array de listas*/
    public HashMap(int capacidad)throws IllegalArgumentException{
        if(capacidad < 0){
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
        for (int i = 0; i < capacidad; i++) {
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
    
    // tuve que crear este método para poder hacer el ejercicio 2.a
        public boolean contieneValor(V valor) {
        List<V> valores = (List<V>) values();
        int i =0;
        while(i< valores.size() && !valores.get(i).equals(valor)){
            i++;
        }
        if (valores.get(i).equals(valor)) return true;
        return false;
    }
}
