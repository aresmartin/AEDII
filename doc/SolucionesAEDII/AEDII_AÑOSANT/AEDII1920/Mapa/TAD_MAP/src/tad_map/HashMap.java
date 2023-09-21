/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad_map;

import java.util.Iterator;
import java.util.Vector;
import lista.Lista;
import lista.ListaEnlazada;

/**
 *
 * @author degap
 * @param <K>
 * @param <V>
 */
public class HashMap<K ,V> implements Map<K,V>{
    
    public static int CAPACIDAD = 10;
    private Lista<Par<K, V>>[] arrayDeListas;
    private int numElem;
    
    
    public HashMap(){
        
        arrayDeListas = new ListaEnlazada[CAPACIDAD];
        for(int i = 0; i < CAPACIDAD; i++){
            arrayDeListas[i] = new ListaEnlazada<>();
        }
        numElem = 0;        
    }
    
    /**
     *Devuelve el numero de pares <K,V> que están guardados en las listas 
     *del array.
     * @return 
    */    
    @Override
    public int tamanho(){
        return numElem;
    }
    
    /**
     * Devuelve true si el mapa está vacio.
     * @return 
     */
    
    @Override
    public boolean esVacio(){
        if(numElem == 0){
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @param clave
     * @return 
     */
    private int funcionHash(K clave){
        
        /**
         * La variable hasCode sirve para guardar el valor que resulta de 
         * convertir a entero el valor de la clave utilizando la funcion
         * hasCode().
         */        
        int hashCode;
        
        hashCode = clave.hashCode();
        
        /**
         * En la variable dirHash se guardara el valor que resulte del calculo
         * de la funcionHAsh(). Este valor indica la posicion que ocupa en el
         * arrayDeListas la lista en la que se va a guardar el Par<K,V>.
         */
        int dirHash;
        
        /**
         * Dado que el valor de la variable hashCode puede ser negativo y el
         * valor de dirHash no, a la funcion hash hay que aplicarle el metodo
         * Math.abs() para garantizar que dirHash es positiva. 
         */        
        dirHash = Math.abs(hashCode)%CAPACIDAD;
        
        return dirHash;  
    }
    /**
     * Este metodo sirve para insertar un nuevo Par<K,V> en el mapa. Primero
     * lo recorre, si encuentra una clave igual, sustituye el valor por el nuevo
     * sino, inserta el nuevo par al final de la lista correspondiente.
     * @param clave
     * @param valor 
     */
    
    @Override
    public void insertar(K clave, V valor){        
        /**
         * Pasandole al metodo privado la clave del par que queremos insertar,
         * calculamos la posicion del arrayDeListas en la que se encuentra la
         * lista en la que tenemos que insertar el nuevo par.
         */        
        int dirHash = funcionHash(clave);        
        /**
         * Creamos un iterador para recorer la lista de esa posicion. 
         */        
        Lista<Par<K, V>> it_list = arrayDeListas[dirHash];
        Iterator<Par<K,V>> it = it_list.iterator();
        Par<K, V> par = null;
        /**
         * Declaramos una variable booleana que nos permita salir del bucle.
         */
        boolean iguales = false;
        /**
         * Recorremos la lista buscando si ya existe un par con esa misma clave.
         */
        while(!iguales && it.hasNext()){
            
            par = it.next();
        
            /**
            * Si encuentra un par con esa clave, sustituye el valor existente
            * por el nuevo.
            */
            if(par.getClave().equals(clave)){
                par.setValor(valor);
                iguales = true;                
            }
        }
        /**
         * Sino, inserta al final de la lista un nuevo objeto de tipo par
         * con la clave y el valor que pasamos como parametros.
         */
        if(!iguales){
            arrayDeListas[dirHash].insertarFinal(new Par(clave, valor));
            numElem++;
        }        
    }
    /** Recupera el valor asociado a la clave 
     * @param clave, la clave del valor
     * @return si la clave está en el mapa, devuelve el valor asociado a esta. Si no, devuelve null.
     */
    @Override
    public V recuperar(K clave){
        
        /**
         * Pasandole al metodo privado la clave del par que queremos insertar,
         * calculamos la posicion del arrayDeListas en la que se encuentra la
         * lista en la que tenemos que insertar el nuevo par.
         */ 
        int dirHash = funcionHash(clave);
         /**
         * Creamos un iterador para recorer la lista de esa posicion. 
         */        
        Iterator<Par<K,V>> it = arrayDeListas[dirHash].iterator();
        /**
         * Recorremos la lista buscando si existe un par con esa clave.
         */        
        while(it.hasNext()){
            Par<K,V> par = it.next();
            /**
             * Si existe la clave...
             */            
            if(par.getClave().equals(clave)){
                /**
                 * devuelve el valor asociado a la clave.
                 */
                return par.getValor();
            }
        }
        /**
         * Si no existe devuelve null.
         */
        return null;        
    }
    /**
     * Busca en el mapa la clave que pasamos como parametro.
     * @param clave, la clave a buscar
     * @return true si la clave está en el mapa, false si no devuelve false
     */
    @Override
    public boolean estaClave(K clave){
        /**
         * Pasandole al metodo privado funcionHash() la clave del par que 
         * queremos comprobar si se encuentra en el mapa, calculamos la 
         * posicion del arrayDeListas en la que se supone que se encuentra
         * la lista en la que tenemosque buscar si esta el par que contiene
         * la clave.
         */ 
        int dirHash = funcionHash(clave);
         /**
         * Creamos un iterador para recorer la lista de esa posicion. 
         */        
        Iterator<Par<K,V>> it = arrayDeListas[dirHash].iterator();
        /**
         * Recorremos la lista buscando si existe un par con esa clave.
         */        
        while(it.hasNext()){
            Par<K,V> par = it.next();
            /**
             * Si existe la clave...
             */            
            if(par.getClave().equals(clave)){
                /**
                 * devuelve el valor asociado a la clave.
                 */
                return true;
            }               
        }
         /**
         * Si no existe devuelve false.
         */
        return false;
    }
    /**
     * Busca en el mapa el valor que pasamos como parametro.
     * @param valor, el valor a buscar
     * @return true si hay claves asociadas al valor, false si no esta.
     */
    @Override
    public boolean estaValor(V valor){
        /**
         * Declaramos una variable i que servira de contador para recorrer el
         * array de listas y la inicializamos 0 que es la primera poscicion 
         * del array.
         */
        int i = 0;
        /**
         * Declaramos un iterador para recorrer cada una de las listas que se
         * encuentran en cada posicion del array de listas.
         */        
        Iterator<Par<K,V>> it;
        /**
         * Como para buscar comprobar si existe en valor tenemos que mirar en
         * los pares almacenados en las listas, tenemos que declarar una
         * variable par inicializandola null para que no de error.
         */        
        Par<K,V> par = null;
        /**
         * Recorremos todas las listas del array, mientras que no encontremos
         * el valor que pasamos como parámetro y tengamos listas para recorrer.
         */       
        while(i<arrayDeListas.length){
            /**
             * situamos el iterador en la primera lista.
             */
            it = arrayDeListas[i].iterator();
            /**
             * Mientras la lista tenga pares.
             */
            while(it.hasNext()){
                par = it.next();
                /**
                 * Si encontramos en esa lista un par que contenga el valor,
                 * retornamos true.
                 */
                if(par.getValor().equals(valor)){
                    return true;
                }
            }
            /**
             * Si llegamos al final de la lista de la posicion iy no hemos
             * encontrado el valor, incrementamos el valor del contador de
             * posiciones del array y nos situamos en la siguiente lista.
             */
            i++;            
        }
        /**
         * Si nos salimos del primer while significa que ya habremos recorrido
         * todas las listas sin encontrar el valor por lo que retornaremos
         * false.
         */
        return false;        
    }
    /**
     * Elimina el par K clave V valor asociado a la clave dada, si la clave
     * está en el mapa
     * @param clave, la clave del valor
     * @return si la clave está en el mapa, devuelve el valor asociado a esta.
     * Sino, devuelve null.
     */
    @Override
    public V eliminar(K clave){
        /**
         * Pasandole al metodo privado funcionHash() la clave del par que 
         * queremos buscar en el mapa, calculamos la posicion del arrayDeListas
         * en la que se supone que se encuentra la lista en la que tenemos que
         * buscar si esta el par que contiene la clave.
         */
        int dirHash = funcionHash(clave);
         /**
         * Creamos un iterador para recorer la lista de esa posicion. 
         */ 
        Iterator<Par<K,V>> it = arrayDeListas[dirHash].iterator();
        /**
         * Recorremos la lista buscando si existe un par con esa clave.
         */ 
        while(it.hasNext()){
            Par<K,V> par = it.next();
            if(par.getClave().equals(clave)){
                return par.getValor();
            }           
        }
        return null;       
    }
    /**
     * @return un iterador sobre las claves.
     */
    @Override
    public Iterator<K> iteradorClaves(){
        /**
         * Declaramos un vector en el que guardar las claves que recuperamos
         * con el iterador.
         */
        Vector<K> arrayDeClaves = new Vector<>();
        /**
         * Con el bucle for recorremos todas las listas que se almacenan en
         * cada una de las posiciones del arrayDeListas.
         */
        for(int i = 0; i < arrayDeListas.length; i++){
            /**
             * Definimos un iterador para recorrer cada una de las listas del
             * array de Listas.
             */
            Iterator<Par<K,V>> it = arrayDeListas[i].iterator();
            /**
             * Mientras que haya pares en la lista que estamos recorriendo...
             */
            while(it.hasNext()){
                Par<K,V> par = it.next();
                /**
                 * Recuperamos la clave de cada par y la guardamos en 
                 * el arrayDeClaves.
                 */
                arrayDeClaves.add(par.getClave());
            }
        }
        /**
         * Retorna el iterador sobre el arrayDeClaves.
         */
        return arrayDeClaves.iterator();
    }
    
    /**
     * @return un iterador sobre los valores.
     */
    @Override
    public Iterator<V> iteradorValores(){
        /**
         * Declaramos un vector en el que guardar las claves que recuperamos
         * con el iterador.
         */
        Vector<V> arrayDeValores = new Vector<>();
        /**
         * Con el bucle for recorremos todas las listas que se almacenan en
         * cada una de las posiciones del arrayDeListas.
         */
        for(int i = 0; i < arrayDeListas.length; i++){
            /**
             * Definimos un iterador para recorrer cada una de las listas del
             * arrayDeListas.
             */
            Iterator<Par<K,V>> it = arrayDeListas[i].iterator();
            /**
             * Mientras que haya pares en la lista que estamos recorriendo...
             */
            while(it.hasNext()){
                Par<K,V> par = it.next();
                 /**
                 * Recuperamos el valor de cada par y la guardamos en 
                 * el arrayDeValores.
                 */
                arrayDeValores.add(par.getValor());
            }            
        }
        /**
         * Retorna el iterador sobre el arrayDeValores.
         */
        return arrayDeValores.iterator();
    }
    
    /**
     * Quita todos los pares del mapa
     */
    @Override
    public void vaciar(){
        /**
         * Con el bucle for recoremos todas las posiciones del arrayDeListas.
         */
        for(int i = 0; i < arrayDeListas.length; i++){
            /**
             * En cada una de las posiciones sustituimos cada una de las listas
             * existentes por una lista vacia.
             */
            arrayDeListas[i] = new ListaEnlazada<>();
        }        
    }  
}
