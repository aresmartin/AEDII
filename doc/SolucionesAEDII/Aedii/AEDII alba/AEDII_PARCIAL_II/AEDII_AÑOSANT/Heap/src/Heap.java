
//import sun.font.EAttribute;

/*
Recordar: padre == i / 2
          hijoIzq == 2 * i
          hijoDer == (2 * i) + 1
 */
/**
 *
 * @author Samuel Velasquez
 */
public class Heap<E extends Comparable<E>> {

    private static final int CAPACIDAD = 10;
    private E[] vector;
    private int numElem;

    public Heap(E superior) { //Listo, estar pendiente
        vector = (E[]) new Comparable[CAPACIDAD + 1]; //tiene que ser de tipo Comparable el vector; CAPACIDAD + 1 porque la posición 0 está ocupada
        numElem = 0;
        vector[0] = superior; //Le paso como parametro un elemento que va a ser el superior en la pos 0

    }

    public boolean esVacio() { //Listo bb
        return numElem == 0;
    }

    public E recuperar() throws HeapVacioException { //Está bien

        if (esVacio()) {
            throw new HeapVacioException("El heap esta vacio");
        }
        return vector[1];

    }

    public E suprimir() throws HeapVacioException { //Listo pero buscar otra forma
        if (esVacio()) {
            throw new HeapVacioException("El heap está vacio");
        }
        E elem = vector[1]; //guardo el elemento de la raiz
        vector[1] = vector[numElem]; //Pongo el elemento de la ultima posición en la raiz
        vector[numElem--] = null; //Abro un hueco en la ultima posicion
        hundir(1); //Llamo a Hundir para que lo ordene
        return elem;
    }

    public void insertar(E e) throws IllegalArgumentException { //Esta bien
        
        if (numElem == vector.length - 1) {
            ampliar();
        }else{
	int hueco = ++numElem;
	while(vector[hueco/2].compareTo(e) < 0){ //Mientras el padre sea mayor que el elemento a insertar
		vector[hueco] = vector[hueco/2];
		hueco /= 2;
	}
	vector[hueco] = e;
          }
    }

    public void anular() { //Esta bien
        for (int i = 0; i < numElem; i++) { //Pongo todos los elementos de la array a null con un for
            vector[i] = null;
        }
        numElem = 0;
    }

    /*Otros métodos que te piden en la actividad 4*/
 /* Añade un objeto, pero no garantiza que se mantenga la propiedad de
       ordenación del heap.*/
    public void introducir(E elem) {
        if (numElem == vector.length - 1) {
            ampliar();
        }
        int pos = ++numElem;
        vector[pos] = elem;
    }

    /* Restablece el orden en el montículo. Debido a que es costoso, su
       uso está justificado si se realizan muchas operaciones introducir() entre dos accesos al
       elemento de mayor prioridad*/
    public void arreglarHeap() {
        for (int i = (numElem / 2); i > 0; i--) {
            hundir(i);
        }
    }

    public void hundir(int i) { //Buscar otra forma de hacerlo
        int hijo = i * 2;
        E temp = vector[i];
        boolean fin = false;

        while (hijo <= numElem && !fin) {
            if (hijo < numElem && vector[hijo + 1].compareTo(vector[hijo]) > 0) {
                hijo++;
            }
            if (vector[hijo].compareTo(temp) > 0) {
                vector[i] = vector[hijo];
                i = hijo;
                hijo = i * 2;
            } else {
                fin = true;
            }
        }
        vector[i] = temp;

    }

    //Método útil a mayores para ampliar el Heap en caso de que se necesite
    private void ampliar() {
        Comparable[] nuevo = new Comparable[vector.length * 2];

        for (int i = 0; i < numElem; i++) {
            nuevo[i] = vector[i];
        }
        nuevo = vector;

    }
}
