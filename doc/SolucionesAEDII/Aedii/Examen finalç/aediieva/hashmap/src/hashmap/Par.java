
package hashmap;


public interface Par<K,V> {
 
    public K getKey();
    /*Produce: devuelve la clave*/
    
    public V getValue();
    /*Produce: devuelve el valor*/
    
    public void setValue(V valorNuevo);
    /*Produce: modifica el valor de un par
    Modifica: this
    */
}
