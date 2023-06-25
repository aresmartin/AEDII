/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Iterator;

/**
 *
 * @author Yo
 */
public interface Map<K,V> {
    
    public int size();
    public boolean isEmpty();
    public V get(K clave);
    public void put(K clave,V valor);
    public boolean esta(K clave);
    public V remove (K clave);
    public void clear();
    public Iterator<K> keySet();
    public Iterator<V> Values();
    public Iterator<Par<K,V>> getPares();
    
    
}
