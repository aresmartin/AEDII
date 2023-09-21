
package hashmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashMap2<K,V> implements Map<K,V> {
    
    private List<Par<K,V>> array[];
    private final int CAPACIDAD = 50;
    private int numeroPares;
    

    public HashMap2(){
        
        array = new List[CAPACIDAD];
        for(int i = 0; i < array.length; i++){
            
            array[i] = new ArrayList<>();
        }
      
        numeroPares = 0;
    }
    
    private int funcionHash(K clave){
        
        return Math.abs(clave.hashCode()) % array.length;
    }
    
    public int size() {
        
        return numeroPares;
       
    }

    public boolean isEmpty() {
        
        return numeroPares == 0;
    }

    public V get(K clave) {
        
        if(clave == null) throw new NullPointerException();
       
        int hash = funcionHash(clave);
        
        for(Par<K,V> p : array[hash]){
            
            if(p.getKey().equals(clave)){
                
                return p.getValue();
            }
        }
        
        return null;
    }

    public void put(K clave, V valor) {
        
        if(clave == null || valor == null) throw new NullPointerException();
        
        int hash = funcionHash(clave);
        
        V estaValor = get(clave);
        
        if(estaValor == null){
            
            array[hash].add(new Pares(clave, valor));
            numeroPares++;
            
        }else{
            
            for(Par<K,V> p : array[hash]){
                
                if(p.getKey().equals(clave)){
                    
                    p.setValue(valor);
                }
            }
            
        }
    }

    public V remove(K clave) {
        
        if(clave == null) throw new NullPointerException();
        
        int hash = funcionHash(clave);
        
        V estaValue = get(clave);
        
        if(estaValue != null){
            
            for(Par<K,V> p : array[hash])
                
                if(p.getKey().equals(clave)){
                    
                    array[hash].remove(p);
                    numeroPares--;
                    return estaValue;
                    
                }
        }
        
        return null;
    }

    
    public void clear() {
        
        for(int i = 0; i < array.length; i++){
            
            for(Par<K,V> p : array[i]){
            
                remove(p.getKey());
                 
            }
        }
    }

    public boolean esta(K clave) {
        
        if (clave == null) throw new NullPointerException();
        
        int hash = funcionHash(clave);
        
        for(Par<K,V> p : array[hash]){
            
            if(p.getKey().equals(clave)) return true;
        }
        
        return false;
    }

    public Iterator<K> keySet() {
        
        List<K> toret = new ArrayList<>();
        
        for(int i = 0; i < array.length; i++){
        
            for(Par<K,V> p : array[i]){
            
                toret.add(p.getKey());                        
            }
        }
        
        return toret.iterator();
    }

    public Iterator<V> values() {
        
        List<V> toret = new ArrayList<>();
        
        for(int i = 0; i < array.length; i++){
            
            for(Par<K,V> p : array[i]){
                
                toret.add(p.getValue());
            }
        }
        
        return toret.iterator();
    }
    
}
