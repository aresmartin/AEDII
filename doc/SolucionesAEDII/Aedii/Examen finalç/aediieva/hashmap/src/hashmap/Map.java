
package hashmap;

import java.util.Iterator;


public interface Map<K,V> {
    
     public int size();
    /*Produce: devuelve el número de pares del mapa, es decir, nos da el tamaño*/
    
    public boolean isEmpty();
    /*Produce: si está vacío devuelve true, si no devuelve false*/
    
    public V get(K clave);
    /*Produce: si la clave existe devuelve el valor asociado, si no, devuelve null*/
    
    
    public void put(K clave, V valor);
    /*Produce: si la clave no existe, inserta una pareja nueva <K,V>,
    si no, modifica el valor asociado a la clave
    Modifica: this
    */
    
    public V remove(K clave);
    /*Produce: si la clave existe, se elimina y devuelve el valor, si no, devuelve null
    Modifica: this
    */
    
    public void clear();
    /*Produce: borra todas las claves y valores del mapa
    */
    public boolean esta(K clave);
    /*Produce: si se encuentra la clave devuelve true, si no, devuelve false*/
    
    
    public Iterator<K> keySet();
    /*Produce: devuelve una colección de todas las claves*/
    
    public Iterator<V> values();
    /*Produce: devuelve una colección de todas los valores*/
    
   
}
