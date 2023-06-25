package hashmap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author LuisFerCou
 */
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
