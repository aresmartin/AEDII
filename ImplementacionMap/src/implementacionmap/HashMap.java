package implementacionmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashMap<K,V> implements Map<K,V> {
    
    private int numeroElementos;
    private int capacidad;
    private List<Pares<K,V>>[] datos;
    
    public HashMap(int capacidad) throws IllegalArgumentException {
        if(capacidad == 0){
            throw new IllegalArgumentException();
        }
        
        this.capacidad = capacidad;
        this.numeroElementos = 0;
        datos = new List[capacidad];
        
        for(int i = 0; i < datos.length; i++){
            datos[i] = new ArrayList<>();
        }
        
    }
    
    private int funcionHash(K clave) {
        return Math.abs(clave.hashCode()) % this.capacidad;
    }
    
    public HashMap() {
        this(50);
    }
    
    @Override
    public int tamano() {
        return numeroElementos;
    }

    @Override
    public V get(K clave) {
      int indice = funcionHash(clave);
      for(Pares<K,V> p : datos[indice]){
          if(p.getKey() == clave){
              return p.getValue();
          }
      }
      return null;
    }

    @Override
    public void insertar(K clave, V valor) throws NullPointerException {
        if(clave == null){
            throw new NullPointerException();
        }
        int indice = funcionHash(clave);
        V v = this.get(clave);
        
        if(v != null){
            for(Pares<K,V> p : datos[indice]){
                if(p.getKey() == clave){
                    p.setValue(valor);
                }
            }
        }else{
            datos[indice].add(new Pares(clave, valor));
            numeroElementos ++;        
        }            
    }    

    @Override
    public V eliminar(K clave) {
        int indice = funcionHash(clave);
        V estaValue = get(clave);
        if(estaValue != null){
            for(Pares<K,V> p : datos[indice]){
            if(p.getKey() == clave){
                datos[indice].remove(p);
                 numeroElementos --;
                return estaValue;
               
            }
        }
        }     
        return null;
    }

    @Override
    public Iterator<K> getClaves() {
        List<K> claves = new ArrayList<>();
        
        for(int i = 0; i < datos.length; i++){
            for(Pares<K,V> p : datos[i]){
                claves.add(p.getKey());        
            }
        }
        return claves.iterator();
    }

    @Override
    public Iterator<V> getValores() {
       List<V> claves = new ArrayList<>();
        
        for(int i = 0; i < datos.length; i++){
            for(Pares<K,V> p : datos[i]){
                claves.add(p.getValue());        
            }
        }
        return claves.iterator();
    }
    
}
