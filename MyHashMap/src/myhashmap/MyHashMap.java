package myhashmap;

public class MyHashMap<K,V> {
    
    
    // <K,V> -> cual va a ser el tipo de mi clave y el tipo de mi valor
    private class Entry<K,V>{
        private K key;
        private V value;
        private Entry<K,V> next;
        
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        
        public K getKey(){
            return this.key;
        }
        
        public V getValue(){
            return this.value;
        }
        
        // Porque el valor si se puede modificar o añadir pero la llave no
        public void setValue(V value){
            this.value = value;
        }
        
        public String toString(){
            Entry<K,V> temp = this;
            StringBuilder sb = new StringBuilder();
            while(temp != null){
                sb.append(temp.key + " -> " + temp.value + ",");
                temp = temp.next;
            }
            return sb.toString();
        }
        
    }
    
    
    private final int SIZE = 5;
    
    private Entry<K,V> table[];
    
    public MyHashMap(){
        
        table = new Entry[SIZE];
        
    }
    
    public void put(K key, V value){
        // Un numero entre 0 y 5 dado el hashcode de la clave para colocarlo en el array
        int hash = key.hashCode() % SIZE; 
        Entry<K,V> e = table[hash]; // va a estar vacio porque es la primera vez de insertar
        
        if( e == null){
            table[hash] = new Entry<K,V>(key, value);
        }else{
            while(e.next != null){
                // Si la clave existe, sobreescribimos el valor
                if(e.getKey() == key){
                    e.setValue(value);
                    return;
                }
                
                e = e.next;
            }
            
            if(e.getKey() == key){
                    e.setValue(value);
                    return;
                }
            
            // La clave no existe -> necesitamos añadirla AL FINAL DE LA LISTA
            e.next = new Entry<K,V>(key, value);
        }              
    }
    
    public V get(K key){
            // Un numero entre 0 y 5 dado el hashcode de la clave para colocarlo en el array
            int hash = key.hashCode() % SIZE; 
            Entry<K,V> e = table[hash]; 
            
            if(e == null){
                return null; // no hay nada en el hashmap (la key no existe)
            }
            
            while(e != null){
                if(e.getKey()== key){
                    return e.getValue();
                }
                
                // miramos si hay otra posición en caso de no coincidir la clave
                //  con el primer elemento a buscar
                e = e.next; 
            }
            
            
            return null; // la llave no existe despues de recorrer todo
            
        }
    
    // Eliminar un par clave valor
    public Entry<K,V> remove(K key){
        // Un numero entre 0 y 5 dado el hashcode de la clave para colocarlo en el array
            int hash = key.hashCode() % SIZE; 
            Entry<K,V> e = table[hash];
            
            if( e == null){
                return null;
            }
            
            if(e.getKey() == key){
                 table[hash] = e.next;
                 e.next = null;
                 return e;
            }
            
            Entry<K,V> prev = e;
            e = e.next;
            
            while( e != null){
                if(e.getKey() == key){
                    prev.next = e.next;
                    e.next = null;
                    return e;
                }
                prev = e;
                e = e.next; 
            }
            
        return null;
    }
    
    public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < SIZE; i++) {
      if (table[i] != null) {
        sb.append(i + " " + table[i] + "\n");
      } else {
        sb.append(i + " " + "null" + "\n");
      }
    }
 
    return sb.toString();
  }
    
    
}
