package mapas;

import java.util.Iterator;
import lista.*;

/**
 *
 * @author Usuario
 * @param <K>
 * @param <V>
 */
public class HashMap<K extends Object, V extends Object> implements Map<K,V>{

    
    private final int CAPACIDAD_DEFECTO = 10;
    private Lista<Par<K,V>> [] lista;
    private int numElem;
    
    //metodo division
    private int funcionHash(K clave){
        try{
            return Math.abs(clave.hashCode())%CAPACIDAD_DEFECTO;
        }catch(NullPointerException exc){
            System.err.println("La clave es null.");
        }
        return 0;
    }
    
    public HashMap(){
        //creas un Array de listas con capcidad defecto
        lista = new Lista[CAPACIDAD_DEFECTO];
        
        //creas una lista enlazada en cada hueco del array
        for(int i = 0; i < CAPACIDAD_DEFECTO; i++){
            lista[i] = new ListaEnlazada<>();
        }
        //inicializas el tamaño
        numElem = 0;
    }
    
    @Override
    public boolean esVacio() {
        return  numElem == 0;
    }

    @Override
    public int size() {
        return numElem;
    }

    @Override
    public void insertar(K clave, V valor){
        //variables de control y auxiliar de funcion hash
        int aux = funcionHash(clave);
        boolean variableControl = false;
        
        //si la lista de pares no esta vacia
        if(!lista[aux].esVacio()){
            //por cada par en la posicion del array de listas
            for (Par<K,V> a : lista[aux]){
                //si la clave coincide actualiza el valor
                if(a.getClave().equals(clave)){
                    a.setValor(valor);
                    variableControl = true;
                }
            }
            /*si no se actualiza la variable de control añade el par en la  
            lista de pares al final en la posicion del array*/
            if (!variableControl){
                lista[aux].insertarFinal(new Par<>(clave,valor));
                numElem++;
            }
        //si la lista de pares está vacia inserta el par    
        }else{
            lista[aux].insertarPrincipio(new Par<>(clave, valor));
            numElem++;
        }
        
        
            
    }

    @Override
    public V buscar(K clave) throws NullPointerException {
        //variables de control y auxiliar de funcion hash
        int aux = funcionHash(clave);
        
        //si la posicion del array no esta vacia
        try{
            if(!lista[aux].esVacio()){
                //por cada par en la lista de la posicion del array
                for (Par<K,V> a : lista[aux]){
                    //si existe un par con la clave retorna el valor
                    try{    
                        if (a.getClave().equals(clave)){
                            return a.getValor();
                        }
                    }catch(NullPointerException exc){
                        System.err.println("No está la clave que se quiere buscar.");
                    }
                }
            }
        }catch(NullPointerException exc){
            System.err.println("La posición del array está vacia.");
        }
        return null;
        
    }

    @Override
    public V eliminar(K clave) throws NullPointerException {
        //variables de control y auxiliar de funcion hash
        int aux = funcionHash(clave);
        
        //si la posicion del array no esta vacia
        try{
            if(!lista[aux].esVacio()){
                //por cada par en la lista de la posicion del array
                for (Par<K,V> a : lista[aux]){
                    //si existe un par con la clave retorna el valor y eliminar
                    try{    
                        if (a.getClave().equals(clave)){
                            V i = a.getValor();
                            lista[aux].suprimir(a);
                            numElem--;
                            return i;
                        }
                        
                    }catch(NullPointerException exc){
                        System.err.println("No está la clave que se quiere eliminar.");
                    }
                }
            }
        }catch(NullPointerException exc){
            System.err.println("La posición del array está vacia.");
        }
        return null;
        
    }

    @Override
    public boolean contieneClave(K clave) {
        //variables de control y auxiliare funcion hash
        int aux = funcionHash(clave);
        
        //si está vacio retorna falso
        if(lista[aux].esVacio()){
            return false;
        }else{
            //por cada par de valores en la lista dentro de la posicion del array
            for(Par a : lista[aux]){
                //si la clave está retorna true, si no false
                if(a.getClave().equals(clave)){
                    return true;
                }
            }
            return false;
        }  
    }

    @Override
    public boolean contieneValor(V valor) {
        //por cada lista en el array
        for (Lista<Par<K,V>> arrayLista : lista){
            //por cada Par en las listas dentro del array
            for (Par<K,V> a : arrayLista){
                //si existe el valor retorna true
                if(a.getValor().equals(valor)){
                    return true;
                }
            } 
        }
        return false;
    }

    @Override
    public Iterator<K> keySet() {
        //creas una lista vacia
        Lista<K> aux = new ListaEnlazada();
        //por cada lista en el array
        for (Lista<Par<K,V>> a : lista){
            //por cada par de listas en las listas del array
            for (Par<K,V> aPar : a){
                //inserta en la lista aux las claves
                aux.insertarFinal(aPar.getClave());
            }
        }
        //convierte la lista en un iterador y lo retorna
        Iterator<K> toRet = aux.iteradorLista();
        return toRet;
    }

    @Override
    public Iterator<V> valueSet() {
        //creas una lista vacia
        Lista<V> aux = new ListaEnlazada();
        //por cada lista en el array
        for (Lista<Par<K,V>> a : lista){
            //por cada par de listas en las listas del array
            for (Par<K,V> aPar : a){
                //inserta en la lista aux los valores
                aux.insertarFinal(aPar.getValor());
            }
        }
        //convierte la lista en un iterador y lo retorna
        Iterator<V> toRet = aux.iteradorLista();
        return toRet;
    }

    @Override
    public void clear() {
        //creas un Array de listas con capcidad defecto
        lista = new Lista[CAPACIDAD_DEFECTO];
        
        //creas una lista enlazada en cada hueco del array
        for(int i = 0; i < CAPACIDAD_DEFECTO; i++){
            lista[i] = new ListaEnlazada<>();
        }
        //inicializas el tamaño
        numElem = 0; 
    }
}