/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionmap;

import java.util.Iterator;

/**
 *
 * @author marti
 */
public interface Map<K,V> {
    
    public int tamano();
    /*
        Produce: devuelve el número de claves del mapa, es decir, número de posiciones del array
    */
    
    public V get(K clave);
    /*
        Produce: si la clase existe devuelve el valor asociado, sino devuelve null
    */
    
    public void insertar(K clave, V valor) throws NullPointerException;
    /*
        Produce: si la clave no existe, inserta una pareja nueva <K, V> si el valor es null devuelve NullPointerException, 
                 sino modifica el valor asociado a la clave.
        Modifica: this
    */
    
    public V eliminar(K clave);
    /*
        Produce: si la clave existe, se elimina el par y devuelve el valor, sino devuelve null
        Modifica: this
    */


    public Iterator<K> getClaves();
    /*
        Produce: devuelve una colección de todas las claves
    */
    
    public Iterator<V> getValores();
    /*
        Produce: devuelve una colección de todas los valores
    */
}
