/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.solactividad6;

public class MapDeMap<E,T> {
    
   private Vertice<E> origen; // vértice del grafo
    private HashMap <Vertice<E>, T> mapAdy; // mapa de adyacentes del vértice origen
 
    public MapDeMap(Vertice<E> v){
        
        origen = v;
        mapAdy = new HashMap<>(1);
        
    }
 
   public Vertice<E> getVertice(){
    
        return origen;
    
    }
 
    
    public HashMap<Vertice<E>, T> getAdy(){
 
        return mapAdy;
 
    }
    
    
}
