package com.mycompany.repetiractividad4;

//import java.lang.reflect.Array;

public class HeapBinario<E extends Comparable<E>> implements Heap<E> {
    private static final int CAPACIDAD = 50;
    private E[] array; // el array del montículo
    private int numElem; // numero de elementos del montículo
    
    /* ANOTACIONES:
        - Hijo izquierdo: posición 2i
        - Hijo derecho: posición 2i+1
        - Padre: posición i/2
        - Recordar actualizar numElem
    */
    
    HeapBinario(int capacidad){
        
        if(capacidad < 0){
            throw new IllegalArgumentException("HeapBinario: la capacidad debe ser mayor que 0");
        }
        array = (E[]) new Comparable[capacidad];
        numElem = 0;
        
    }
    
     HeapBinario(){
        this(CAPACIDAD); //Invoca al segundo constructor con la capacidad por defecto   
    }

    @Override
    public boolean esVacio() {
        return numElem == 0; 
    }

    @Override
    public E recuperarMax() throws HeapVacioExcepcion {
        if(esVacio()){
            throw new HeapVacioExcepcion("recuperarMax(): Heap vacio.");
        }
        return array[1];
    }

    @Override
    public E suprimirMax() throws HeapVacioExcepcion {
        if(esVacio()){
            throw new HeapVacioExcepcion("recuperarMax(): Heap vacio.");
        }
        E e = array[1]; // primer elemento del heap (no hace falta crear un array)
        
        array[1] = array[numElem];
        array[numElem] = null; // se libera la última posición ya que ahí no hay nada
        numElem = numElem - 1;
        
        hundir(1); // ordenamos el Heap desde la primera posición
        
        
        return e;
        
    }
    
    private void hundir(int hueco){
        E temporal = array[hueco];
        int hijo = hueco * 2;
        boolean fin = false;
        
        while(hijo <= numElem && !fin){
            if(hijo < numElem && array[hijo + 1].compareTo(array[hijo]) > 0){
                hijo ++;
            }
            
            if(array[hijo].compareTo(temporal) > 0){
                array[hueco] = array[hijo];
                hueco = hijo;
                hijo = hueco * 2;
            }else{
                fin = true;
            }
            
            array[hueco] = temporal;
        }
        
        
    }

    @Override
    public void insertar(E e) throws NullPointerException {
        if(e == null){
            throw new NullPointerException();
        }
        int tamano = array.length -1;
       if(numElem == tamano){
           throw new IllegalStateException("insertar(): el array esta lleno.");
           
       }
        
       array[++numElem] = e;   
       flotar(numElem);
    }

    @Override
    public void anular() {
        // array = null; -> así elimino la estructura del array
        
        // Vaciar el array sin eliminar la estructura
        for(int i = 0; i <= numElem; i++){
            array[i] = null;
        }
        numElem = 0;
    }
    
    private void flotar(int indice){
        E temporal = array[indice];
        
        // Mientras que el índice no sea la raíz (indice 1) y el valor del padre sea menor que el actual
        while (indice > 1 && temporal.compareTo(array[indice/2]) > 0){
            // Subir el valor del padre a la posición del hijo
            array[indice] = array[indice / 2];
            
            // Mover el índice hacia el padre
            indice = indice / 2;
        }
        array[indice] = temporal;
        }
    
    public void introducir(E e) throws NullPointerException {
        if(e == null){
            throw new NullPointerException();
        }
        int tamano = array.length -1;
       if(numElem == tamano){
           throw new IllegalStateException("insertar(): el array esta lleno.");
           
       }
        
       array[++numElem] = e;    
    }
    
    public void arreglarHeap() {
        // Comenzar desde el último nodo que no es una hoja y llamar a hundir()
        for (int i = numElem / 2; i >= 1; i--) {
            try {
                hundir(i);
            } catch (HeapVacioExcepcion e) {
                System.err.println("Error al arreglar el heap: " + e.getMessage());
            }
        }
    }
    
    public void heapSort(E[] elementos) {
        // Paso 1: Introducir cada elemento en el montículo sin mantener la propiedad del heap
        for (E e : elementos) {
            introducir(e);
        }

        // Paso 2: Arreglar el heap para restablecer la propiedad
        arreglarHeap();

        // Paso 3: Suprimir los elementos en orden descendente y almacenarlos en el array original
        for (int i = elementos.length - 1; i >= 0; i--) {
            try {
                 elementos[i] = suprimirMax(); // Suprime el elemento máximo y lo almacena
            } catch (HeapVacioExcepcion e) {
            System.err.println("Error durante el HeapSort: " + e.getMessage());
            }
        }
    }
    
}
