/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel Velásquez
 */
public class ClasePrueba {
    /* 1. Introducir() cada elemento en un montículo binario,
       2. Llamar a arreglarHeap() y 
       3. Llamar a suprimir() tantas veces como elementos haya en el montículo. 
       Los elementos saldrán del montículo en orden.*/
    private static void heapSort(int[] elementos){
        Heap<Integer> heap = new Heap(Integer.MAX_VALUE);
        
        for (int i = 0; i < elementos.length; i++) {
            heap.introducir(elementos[i]);
        }
        heap.arreglarHeap();
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = heap.suprimir();
        }
        
    }

    public static void main(String[] args) {
        int[] datos = new int[]{33,44,55,28,57,19,8,10,99,2};

        
        System.out.println("\nArray desordenado: ");
        for (int i = 0; i < datos.length; i++) {
            System.out.print(datos[i] + " ");
        }
        
        heapSort(datos);
        
        System.out.println("\nArray ordenado: ");
        for (int i = 0; i < datos.length; i++) {
            System.out.print(datos[i] + " ");
        }
        
        System.out.println("\n");
    }
}
