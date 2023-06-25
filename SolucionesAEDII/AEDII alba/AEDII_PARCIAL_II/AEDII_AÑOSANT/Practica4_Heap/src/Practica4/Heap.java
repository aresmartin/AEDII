/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yo
 * @param <E>
 */
public class Heap<E extends Comparable<E>> {

    // private static final int CAPACIDAD = valor;
    private List<E> vector;
    //private int numElem;

    public Heap() {
        vector = new ArrayList<>();
        vector.add(null);
    }

    public boolean esVacio() {
        return vector.isEmpty();
    }

    public E recuperarMax() throws HeapVacioException {
        if (vector.isEmpty()) {
            throw new HeapVacioException("Error");
        }
        return vector.get(1);
    }

    public E suprimirMax() throws HeapVacioException {
        //ultimo en hacer porque es lioso
        //colocar el ultimo numero del vector en el del max y ordenar
        E toret=vector.get(1);
        vector.set(1,vector.remove(vector.size()-1));
        hundir(1);
        
        
        
        return toret;
    }
    //sirve para ordenar el Heap
    private void hundir(int pos){
        //mientras el vector de mi posicion sea menor que el alguno de sus hijos y no llegasemos al final del vector
        //ojo a esto que hay que revisarlo me falta que sea tambien cuando llega al final del vector
        while(vector.get(pos).compareTo(vector.get(pos*2))==0||vector.get(pos).compareTo(vector.get(pos*2+1))==0){
        //hijo izq mayor hijo der
        if(vector.get(pos*2).compareTo(vector.get(pos*2+1))==1){
                E elem = vector.remove(pos*2);
                vector.add(pos*2, vector.get(pos));
                vector.add(pos, elem);
                pos = pos * 2;
        }
        //hijo derecho mayor hijo izquierdo
        if(vector.get(pos*2).compareTo(vector.get(pos*2+1))==0){
                E elem = vector.remove(pos*2+1);
                vector.add(pos*2+1, vector.get(pos));
                vector.add(pos, elem);
                pos = pos * 2+1;
        }  
    }
        
    }

    public void insertar(E e) throws IllegalArgumentException {
        //insertar y comparar para colocarlo correctamente
        //mete al final y ordena
        //Puedes comprobar si el elemento que insertas es el primero en un if 
        //y luego si hay mas usar un while? Si. 

        vector.add(e);
        int pos = vector.size()-1;
        if (pos / 2 == 0) {
            System.out.println("Es padre");
        } else {
            while (vector.get(pos / 2).compareTo(vector.get(pos)) == 1) {
                E elem = vector.remove(pos / 2);
                vector.add(pos / 2, vector.get(pos));
                vector.add(pos, elem);
                pos = pos / 2;
            }

        }

    }

    public void anular() {
       // vector = null;
        for(int i=1;i<vector.size();i++){
            vector.remove(i);
        }
    }
    
    
    public void introducir(E e){
        if(vector.isEmpty()){
            vector.add(e);
        }
        else{
            vector.add(e);
        }
    }
    public void arreglarHeap(){
        
        for (int i=0;i<vector.size();i++){
            hundir(i);
        }
    }
    //no se seguro
    public static void hepSort(int h){
        
    }


}
