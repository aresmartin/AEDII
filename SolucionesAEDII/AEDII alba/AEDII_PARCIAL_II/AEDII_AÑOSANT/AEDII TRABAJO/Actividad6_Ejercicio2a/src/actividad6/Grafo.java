/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad6;


import java.util.Iterator;
/**
 *
 * @author jdher
 */
public interface Grafo <E,T>{
    
     public Iterator <Vertice<E>> adyacentes (Vertice<E> v);
     public boolean estaArco(Arco<E,T> a); 
}
