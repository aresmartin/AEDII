/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package especificacionmap;

import java.util.Iterator;

/**
 *
 * @author celticjordan
 */
public interface Map<K, V> {

    public int tamaño();
        //Produce: Devuelve el tamaño del map
    public V get(K clave);
        //Produce: Devuelve el valor asociado a una clave
    public void insertar(K clave, V valor);
        //Modifica: this
        //Produce: Inserta un par de clave/valor en el map
    public V eliminar(K clave);
        //Modifica: this
        //Produce: Elimina un par asociado a una clave
    public Iterator<K> getClaves();
        //Produce: Devuelve claves mediante iterador
    public Iterator<V> getValores();
        //Produce: Devuelve valores mediante iterador
    interface Par<K, V> {

        K getClave();
            //Produce: Devuelve una clave K
        V getValor();
            //Produce: Devuelve un valor V
        void setValor(V nuevo);
            //Modifica: this
            //Produce: Añade un valor
    }
}
