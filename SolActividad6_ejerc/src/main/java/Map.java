
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public interface Map<K,V> {
    
    public int size();
    /*
        Produce: devuelve el número de claves del mapa, es decir, número de posiciones del array
    */
    
    public boolean isEmpty();
    /*
        Produce: si está vacío devuelve true, sino devuelve false
    */
    
    public V get(K clave);
    /*
        Produce: si la clase existe devuelve el valor asociado, sino devuelve null
    */
    
    public void put(K clave, V valor) throws NullPointerException;
    /*
        Produce: si la clave no existe, inserta una pareja nueva <K, V> si el valor es null devuelve NullPointerException, 
                 sino modifica el valor asociado a la clave.
        Modifica: this
    */
    
    public V remove(K clave);
    /*
        Produce: si la clave existe, se elimina el par y devuelve el valor, sino devuelve null
        Modifica: this
    */
    
    public void clear();
    /*
        Produce: borra todas las claves y valores del mapa
    */
    
    public boolean esta(K clave);
    /*
        Produce: si se encuentra la clave devuelve true, sino devuelve false
    */

    public Iterator<K> keySet();
    /*
        Produce: devuelve una colección de todas las claves
    */
    
    public Iterator<V> values();
    /*
        Produce: devuelve una colección de todas los valores
    */
}
