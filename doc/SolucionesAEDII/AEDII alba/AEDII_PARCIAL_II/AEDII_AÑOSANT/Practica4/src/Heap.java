
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yo
 */
public class Heap<E extends Comparable<E>> {

   // private static final int CAPACIDAD = valor;
    private List<E> vector;
    //private int numElem;

    public Heap(){
        vector = new ArrayList<>();
        vector.add(null);
    }

    public boolean esVacio(){
        if(vector.isEmpty())
            return true;
        else return false;
    }

    public E recuperarMax() throws HeapVacioExcepcion{
        if(vector.isEmpty()){
            throw new HeapVacioExcepcion("Error");
        }
    }

    public E suprimirMax() throws HeapVacioExcepcion{
        //ultimo en hacer porque es lioso
    }

    public void insertar(E e) throws IllegalArgumentException{
        //insertar y comparar para colocarlo correctamente
        //mete al final y ordena
    }

    public void anular(){
        
    }

}
