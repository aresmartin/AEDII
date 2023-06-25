/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Yo
 */
public interface Par<K,V> {
    
    public K getKey();
    //devuelve la clave
    public V getValue();
    //devuelve el valor asociado a una clave
    public void setValue(V valor);
    //modifica el valor y lo cambia por uno nuevo
}
