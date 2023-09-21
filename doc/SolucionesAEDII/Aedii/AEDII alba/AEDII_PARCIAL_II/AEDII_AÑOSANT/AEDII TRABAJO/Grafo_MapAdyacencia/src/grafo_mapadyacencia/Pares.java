/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo_mapadyacencia;

/**
 *
 * @author Yo
 */
public class Pares<K,V> implements Par<K,V> {

    private K clave;
    private V valor;
    
    public Pares(K clav, V val){
        clave=clav;
        valor=val;
        
    }
    @Override
    public K getKey() {
        return clave;
    }

    @Override
    public V getValue() {
        return valor;
    }

    @Override
    public void setValue(V valor) {
        this.valor=valor;
    }
    
}
