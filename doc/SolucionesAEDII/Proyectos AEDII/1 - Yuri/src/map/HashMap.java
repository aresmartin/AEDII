package map;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Yuri Díaz Sánchez
 */
public class HashMap<K,V> implements Map<K,V> {
    private List<Pares<K,V>>[] vector;
    private int numElem;
    
    public HashMap(){
        this.vector = new ArrayList[50];
        this.numElem = 0;
        for (int i = 0; i < vector.length; i++) {
            vector[i] = new ArrayList();
        }
    }
    
    public HashMap(int capacidad){
        if(capacidad > 0){
            this.vector = new ArrayList[capacidad];
            this.numElem = 0;
            for (int i = 0; i < vector.length; i++) {
            vector[i] = new ArrayList();
        }
        }else{
            throw new IllegalArgumentException("ERROR: capacidad negativa");
        }
    }
    
    private int hashCode(K clave){ 
            int cod = (clave.hashCode() % (vector.length));
            
            if(cod < 0) // Si es una clave negativa, la convertimos a positiva
                return cod*-1;
            
            return cod;
    }

    /**
     * Determina si un mapa está vacío
     * @return devuelve cierto si el mapa está vacío, falso de lo contrario
     */
    @Override
    public boolean esVacio() {
        return (numElem == 0);
    }

    /**
     * Determina el número de elementos del mapa
     * @return el numero de elementos como entero
     */
    @Override
    public int tamaño() {
        return numElem;
    }
    
    /**
     * Recupera el valor asociado a una clave pasada como argumento
     * @param clave la clave cuyo valor queremos obtener
     * @return devuelve el valor asociado a la clave si está en el mapa y null si no está
     */
    @Override
    public V recuperar(K clave) {
        int indicePar = hashCode(clave);
            
            // Búsqueda lineal
            int i = 0;
            while(i<vector[indicePar].size() && !vector[indicePar].get(i).getClave().equals(clave)){
                i++;
            }

            if( i != vector[indicePar].size()){ // Si hemos encontrado la clave
                return vector[indicePar].get(i).getValor();
                // Retornamos el valor asociado a la clave
                
            }else{ // Si no la encontramos, devolvemos null
                return null;
            }
        
    }

    /**
     * Inserta un Par
     * @param clave La clave que queremos insertar
     * @param valor El valor asociado a la clave que queremos insertar
     */
    @Override
    public void insertar(K clave, V valor) {
        int indiceNuevoPar = hashCode(clave);
        
            int i = 0;
            while(i<vector[indiceNuevoPar].size() && !vector[indiceNuevoPar].get(i).getClave().equals(clave)){
                i++;
            }
            
            if(i != vector[indiceNuevoPar].size()){ // Si coincide, actualizamos el valor
                
                vector[indiceNuevoPar].get(i).setValor(valor);
                
            }else{ // Si no coincide, insertamos el Par
                
                vector[indiceNuevoPar].add(new Pares(clave,valor));
                numElem++;
                
            }
            
        
    }
    
    /**
     * Elimina un par
     * @param clave La clave que queremos eliminar
     * @return el valor de la clave que intentamos eliminar, null si no está la clave en el mapa
     */
    @Override
    public V eliminar(K clave) {
        int indiceElimPar = hashCode(clave);
        
        int i = 0;
        while(i<vector[indiceElimPar].size() && !vector[indiceElimPar].get(i).getClave().equals(clave)){
            i++;
        }

        if(i != vector[indiceElimPar].size()){ // Si encontramos la clave, la eliminamos
            V antiguo = vector[indiceElimPar].get(i).getValor();
            vector[indiceElimPar].remove(i);
            numElem--;
            return antiguo; // Retornamos el valor asociado a la clave
        }
        return null;

    }

    /**
     * Limpia el vector de listas de pares
     */
    @Override
    public void limpiar() {
        vector = new ArrayList[50];
    }

    /**
     * 
     * @return devuelve una lista con las claves existentes en el mapa
     */
    @Override
    public List<K> claves() {
        List<K> claves = new ArrayList(); 
        
        for (List<Pares<K, V>> list : vector) {
            // Recorremos las listas
            
                for (Pares<K, V> pares : list) {
                    // Par 1, Par 2, ... , Par n
                    claves.add(pares.getClave());
                }
            
        }
        
        return claves;
    }

    /**
     * 
     * @return devuelve una lista con los valores existentes en el mapa
     */
    @Override
    public List<V> valores() {
        List<V> valores = new ArrayList();
        
        for (List<Pares<K, V>> list : vector) {
            // Recorremos las listas del vector
            
                for (Pares<K, V> pares : list) {
                    // Par 1, Par 2, ... , Par n
                    valores.add(pares.getValor());
                }
            
        }
        return valores;
    }

    /**
     * 
     * @return devuelve una lista con todos los pares existentes en el mapa
     */
    @Override
    public List<Par<K,V>> pares() {
        List<Par<K,V>> pares = new ArrayList();
        for (List<Pares<K, V>> vectorB : vector) {
            // Lista 1 Lista 2 ... Lista n
            
                for (Pares<K, V> pares1 : vectorB) {
                    // Par 1, Par 2, ... , Par n
                    pares.add(pares1);
                }
            
        }
        return pares;
    }

    /**
     * Busca en el mapa si existe una clave pasada como argumento
     * @param clave la clave que queremos encontrar
     * @return devuelve cierto si la clave está en el mapa, falso de lo contrario
     */
    @Override
    public boolean contieneClave(K clave) {
        int indicePar = hashCode(clave);
        
        int i = 0;
        while(i<vector[indicePar].size() && !vector[indicePar].get(i).getClave().equals(clave)){
            i++;
        }
       
        return (i != vector[indicePar].size());
    }

    /**
     * Busca en el mapa si existe un valor pasado como argumento
     * @param valor el valor que queremos buscar
     * @return devuelve cierto si el valor está en el mapa, falso de lo contrario
     */
    @Override
    public boolean contieneValor(V valor) {
        for (List<Pares<K, V>> list : vector) {
            
            for (Pares<K, V> pares : list) {
                if(pares.getValor().equals(valor)){
                    return true;
                }
            }
            
        }
        return false;
    }
    
    @Override
    public String toString(){
        StringBuilder toret = new StringBuilder();
        
        for (List<Pares<K, V>> list : vector) {
            for (Pares<K, V> par : list) {
                toret.append("--> ");
                toret.append(par.getClave()).append(" ");
                
                toret.append(par.getValor()).append(" ");
                toret.append("\n");
            }
        }
        
        return toret.toString();
    }
    
}
