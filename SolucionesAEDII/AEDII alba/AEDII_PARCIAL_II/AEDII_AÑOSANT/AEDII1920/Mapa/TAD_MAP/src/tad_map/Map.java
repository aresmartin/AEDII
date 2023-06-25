/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad_map;

import java.util.Iterator;

/**
 *
 * @author degap
 * @param <K>
 * @param <V>
 */
public interface Map<K,V> {
    
    
    
     /*Constructor, se crea un array con X posiciones que se pasan como parámetro, 
    cada posición señala a una lista en la que se guardarán los pares clave-valor.
    Inicialmente las posiciones del array se inicializan a null y con un bucle se 
    crea una ListaEnlazada en cada posición del array*/
   //public HashMap();
    
    
    
    public int tamanho();
    
    /**
     * @return true si el mapa es vacío, false en caso contrario. 
     */
    public boolean esVacio();
    
    /**
     * Asocia el valor y la clave dados dentro del mapa. Si la clave ya está en 
     * el mapa, se sobreescribe el valor
     * @param clave, la K clave
     * @param valor, el V valor
     */
    public void insertar(K clave, V valor);
    
    /** Recupera el valor asociado a la clave 
     * @param clave, la clave del valor
     * @return si la clave está en el mapa, devuelve el valor asociado a esta.
     * Si no, devuelve null.
     */
    public V recuperar(K clave);
    
    /**
     * Busca en el mapa la clave que pasamos como parametro.
     * @param clave, la clave a buscar
     * @return true si la clave está en el mapa, false si no
     */
    public boolean estaClave(K clave);
    
    /**
     * Busca en el mapa el valor que pasamos como parametro.
     * @param valor, el valor a buscar
     * @return true si hay claves asociadas al valor, false si no esta.
     */
    public boolean estaValor(V valor);
    
    /**
     * Elimina el par K clave V valor asociado a la clave dada, si la calve está en el mapa
     * @param clave, la clave del valor
     * @return si la clave está en el mapa, devuelve el valor asociado a esta. Si no, devuelve null.
     */
    public V eliminar(K clave);
    
    /**
     * @return un iterador sobre las claves
     */
    public Iterator<K> iteradorClaves();
    
    /**
     * @return un iterador sobre los valores
     */
    public Iterator<V> iteradorValores();
    
    /**
     * Quita todos los pares del mapa
     */
    public void vaciar();
    
}
    

