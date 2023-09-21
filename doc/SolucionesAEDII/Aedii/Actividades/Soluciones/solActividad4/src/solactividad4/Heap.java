
package solactividad4;

import java.lang.reflect.Array;

public class Heap <E extends Comparable<E>> {
    private static final int CAPACIDAD = 25;
    private E [] vector;	// el vector del montículo
    private int numElem;	// número de elementos del montículo.
   

    public Heap (Class clase, E superior){
       	numElem=0;
	//vector = (E[]) new Object[CAPACIDAD+1]; //esta solución no pasa el test. imposible convertir un Object en genérico
        vector = (E[]) Array.newInstance(clase, CAPACIDAD+1);
	vector[0]= superior;
    }
  
    public boolean esVacio() {
        return numElem == 0;
    }

    public E recuperarMax() throws HeapVacioExcepcion {
        if (esVacio())
            throw new HeapVacioExcepcion("recuperarMax: Heap vacío");
        return vector[1];    
    }

    public E suprimirMax() throws HeapVacioExcepcion {
        if (esVacio())
            throw new HeapVacioExcepcion("suprimirMax: Heap vacío");
        E e = vector [1];
        vector[1]= vector[numElem];
        vector[numElem--]=null;
        hundir(1);
        return e;
    }
 
    public void insertar(E e) throws IllegalArgumentException {      
        if (numElem==vector.length-1)
            duplicarVector();   
        int hueco =++numElem;
        while (vector[hueco/2].compareTo(e)<0){
            vector[hueco]=vector[hueco/2];
            hueco/=2;
        }
        vector[hueco] = e;
    }    
    
    public void anular() {
        for (int i=1; i<= numElem;i++)
            vector[i] = null;
        numElem = 0;
    }
    
    private void hundir(int hueco){
        int hijo = hueco*2;
        E temp = vector[hueco];
        boolean fin = false;
        while (hijo <= numElem && !fin){
            if (hijo < numElem && 
               vector[hijo+1].compareTo(vector[hijo])>0)
               hijo++;
            if (vector[hijo].compareTo(temp)>0){
                vector[hueco] = vector[hijo];
                hueco = hijo;
                hijo = hueco*2;
            }
            else fin = true;
        }
        vector[hueco]=temp;
    }
    
    private void duplicarVector(){
        E[] nuevoVector = (E[]) Array.newInstance(vector[0].getClass(), vector.length*2);
        System.arraycopy(vector, 0, nuevoVector, 0, vector.length);
        vector = nuevoVector;
    }
    
}
