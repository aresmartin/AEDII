/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HEAP;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yo
 */
public class Heap<E extends Comparable<E>> {

    private List<E> vector;

    public Heap() {
        vector = new ArrayList<>();
        vector.add(null);
    }

    public boolean esVacio() {
        return vector.isEmpty();
    }

    public E recuperarMax() throws HeapVacioException {
        if (esVacio()) {
            throw new HeapVacioException("");
        }
        return vector.get(1);
    }

    public E suprimirMax() throws HeapVacioException {
        if (esVacio()) {
            throw new HeapVacioException("");
        }
        E toret = vector.get(1);
        vector.set(1, vector.remove(vector.size() - 1));
        hundir(1);
        return toret;
    }

    private void hundir(int pos) {
        while (vector.get(pos).compareTo(vector.get(pos * 2)) > 0
                || vector.get(pos).compareTo(vector.get(pos * 2 + 1)) > 0) {
            //si hijo izq mayor
            if (vector.get(pos * 2).compareTo(vector.get(pos * 2 + 1)) > 0) {
                E elem = vector.remove(pos * 2);
                vector.add(pos * 2, vector.get(pos));
                vector.add(pos, elem);
                pos = pos * 2;

            }
            if (vector.get(pos * 2).compareTo(vector.get(pos * 2 + 1)) < 0) {
                E elem = vector.remove(pos * 2 + 1);
                vector.add(pos * 2 + 1, vector.get(pos));
                vector.add(pos, elem);
                pos = pos * 2 + 1;

            }

        }

    }

    public void insertar(E e) throws IllegalArgumentException {

        vector.add(e);
        int pos = vector.size() - 1;
        if (pos / 2 == 0) {
            System.out.println("es padre");
        } else {
            while (vector.get(pos).compareTo(vector.get(pos / 2)) > 0 || pos / 2 != 0) {
                E elem = vector.remove(pos);
                vector.set(pos, vector.get(pos / 2));
                vector.set(pos / 2, elem);
                pos = pos / 2;

            }
        }

    }

    public void anular() {
        for (int i = 1; i < vector.size(); i++) {
            vector.remove(i);
        }
    }

    public void introducir(E e) {
        vector.add(e);
    }

    public void arreglarHeap() {
        for (int i = 1; i < (vector.size() - 1) / 2; i++) {
            hundir(i);
        }
    }

    public void HeapSort() {

        Heap uno = null;
        for (int i = 0; i < vector.size() - 1; i++) {

            uno.introducir(vector.get(i));

        }
        uno.arreglarHeap();
        for(int i=1;i<vector.size()-1;i++){
            uno.suprimirMax();
            i++;
        }

    }
}
