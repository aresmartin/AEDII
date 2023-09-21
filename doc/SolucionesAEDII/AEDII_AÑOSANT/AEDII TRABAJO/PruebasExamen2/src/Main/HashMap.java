/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Yo
 */
public class HashMap<K,V> implements Map<K,V> {
    private List<Par<K,V>> vector[];
    private int numeroPares;
    private final int CAPACIDAD=50;
    
    public HashMap(){
        numeroPares=0;
        vector=new List[CAPACIDAD];
        for(int i=0;i<CAPACIDAD;i++){
            vector[i]=new ArrayList<>();
        }
    }
    
    public HashMap(int cap)throws IllegalArgumentException{
        if(cap<0){
            throw new IllegalArgumentException("ERROR");
        }
        numeroPares=0;
        vector=new List[cap];
        for(int i=0;i<cap;i++){
            vector[i]=new ArrayList<>();
        }
    }
    
    private int funcionHash(K clave){
        return Math.abs(clave.hashCode())% vector.length;
    }

    
    @Override
    public int size() {
        return numeroPares;
    }

    @Override
    public boolean isEmpty() {
        return numeroPares==0;
    }

    @Override
    public V get(K clave) {
        int toret=funcionHash(clave);
        for(Par<K,V> p: vector[toret]){
            if(p.getKey().equals(clave)){
                return p.getValue();
            }
        }
        return null;
    }

    @Override
    public void put(K clave, V valor) {
        int toret=funcionHash(clave);
        V valor1=get(clave);
        if(valor1==null){
            vector[toret].add(new Pares(clave,valor));
            numeroPares++;
        }else{
            for(Par<K,V>p: vector[toret]){
                if(p.getKey().equals(clave)){
                    p.setValue(valor);
                }
            }
        }
    }

    @Override
    public boolean esta(K clave) {
        int toret=funcionHash(clave);
        for(Par<K,V> p : vector[toret]){
            if(p.getKey().equals(clave)){
                return true;
            }
        }
        return false;
    }

    @Override
    public V remove(K clave) {
        int toret = funcionHash(clave);
        V valor1=get(clave);
        if(valor1!=null){
            for(Par<K,V> p:vector[toret]){
                if(p.getKey().equals(clave)){
                    vector[toret].remove(p);
                    numeroPares--;
                }
            }
            return valor1;
        }
        return null;
    }

    @Override
    public void clear() {
        for(int i=0;i<vector.length;i++){
            for(Par<K,V> p : vector[i]){
                vector[i].remove(p.getKey());
            }
        }
    }

    @Override
    public Iterator<K> keySet() {
        List<K> claves=new ArrayList<>();
        for(int i=0;i<vector.length;i++){
            for(Par<K,V> p : vector[i]){
                claves.add(p.getKey());
            }
        }
        return claves.iterator();
    }

    @Override
    public Iterator<V> Values() {
        List<V> valores=new ArrayList<>();
        for(int i=0;i<vector.length;i++){
            for(Par<K,V> p : vector[i]){
                valores.add(p.getValue());
            }
        }
        return valores.iterator();
    }

    @Override
    public Iterator<Par<K, V>> getPares() {
        List<Par<K,V>> pares=new ArrayList<>();
        for(int i=0;i<vector.length;i++){
            for(Par<K,V> p : vector[i]){
                pares.add(p);
            }
        }
        return pares.iterator();
    }
    
}
