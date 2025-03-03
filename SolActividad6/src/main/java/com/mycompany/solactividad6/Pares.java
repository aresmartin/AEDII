package com.mycompany.solactividad6;

public class Pares<K,V> implements Par<K,V> {
    
    private K clave;
    private V valor;
    
    public Pares(K clave, V valor){
        
        this.clave = clave;
        this.valor = valor;
        
    }

    
    public K getKey() {
        
        return clave;
    }

    
    public V getValue() {
        
        return valor;
    }

    
    public void setValue(V valorNuevo) {
        
        this.valor = valorNuevo;
    }
}

