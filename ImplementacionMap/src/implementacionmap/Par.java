/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionmap;

/**
 *
 * @author marti
 */
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
