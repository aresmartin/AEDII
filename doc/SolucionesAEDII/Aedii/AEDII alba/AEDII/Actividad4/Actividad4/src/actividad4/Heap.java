/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Alba
 */
public class Heap<E extends Comparable<E>>{
    
    private List<E> vector;
       
    public Heap(){
    
        vector = new ArrayList<>();
        vector.add(null);
       
    }
    
    public boolean esVacio(){
    
        return vector.size() < 2;
        
    }
    
    public E recuperarMax() throws HeapVacioExcepcion{
        if(esVacio()){
            throw new HeapVacioExcepcion();
        }
        
        return vector.get(1);
    }
    
    public E suprimirMax() throws HeapVacioExcepcion{
    
     if(esVacio()){
         throw new HeapVacioExcepcion();
     }
     
     E max = vector.get(1);
     E ultimo = vector.remove(vector.size()-1);
     
     if(!esVacio()){
         vector.set(1, ultimo);
         hundir(1);
     }
     
     return max;
    }
    
    
    public void insertar(E e) throws IllegalArgumentException{
    
       if(e == null){
           throw new IllegalArgumentException();
       }
       
       int hueco = vector.size();
       int padre = hueco/2;
       vector.add(e);
       
       while(hueco > 1 && vector.get(padre).compareTo(e) <0){
           vector.set(hueco, vector.get(padre));
           hueco = padre;
           padre=hueco/2;
       }
       
       vector.set(hueco, e);
    }
    
    public void anular(){
    
        vector.clear();
        vector.add(0,null);
    }
    
    private void hundir(int padre){
        
        int hi = padre * 2;
        int hd = (padre * 2) + 1;
        
        while(hi < vector.size()){

        int hijoMayor;
        
        if(hd < vector.size() && vector.get(hi).compareTo(vector.get(hd)) < 0)
        hijoMayor = hd;
        else hijoMayor = hi;
        
        if(vector.get(hijoMayor).compareTo(vector.get(padre)) > 0){
        
        E aux = vector.get(padre);
        vector.set(padre, vector.get(hijoMayor));
        vector.set(hijoMayor, aux);
  
        } else break;   
        
        padre = hijoMayor;
        hi = padre * 2;
        hd = (padre * 2) + 1;
        
    }
    }
    
    public void introducir(E elemento){
        vector.add(elemento);
    }
    
    public void arreglarHeap() throws HeapVacioExcepcion{
        
        if(esVacio()) throw new HeapVacioExcepcion();
        
        for(int nodo = vector.size() - 1; nodo > vector.size()/2; nodo--){
            
            hundir(nodo);
            
        }
    }
}