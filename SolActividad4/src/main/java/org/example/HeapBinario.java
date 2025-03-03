package org.example;

public class HeapBinario<E extends Comparable<E>> implements Heap<E>{
        private static final int CAPACIDAD = 50;
        private E [] array; // el array del montículo
        private int numElem; // número de elementos del montículo

        public HeapBinario(){
            // En java SI se puede llamar a un constructor desde un constructor
            this.CAPACIDAD;
        }

        public HeapBinario(int capacidad){
            if(capacidad < 0){
                throw new IllegalArgumentException("HeapBinario: la capacidad debe ser mayor que 0");
            }
            //array = new E[capacidad + 1]; no porque genericos tiene limitación de no poder hacer arrays
            //              ya que para crear x elementos (capacidad) de un obejeto
            //              debe de saber cuanto ocupa ese objeto (int long string) para poder crear x elementos de ese objeto
            //array = (E[]) new Object[capacidad]; // se resuelve asi -> buscar creación de array genéricos
            array = (E[]) new Comparable[capacidad]; // array de objetos comparables (espacio para almacenar elems)
            numElem = 0;
        }

        public boolean esVacio(){
            return numElem == 0;
        }

        public E recuperarMax() throws HeapVacioExcepcion{
            if(esVacio()){
                throw new HeapVacioExcepcion("recuperarMax: Heap Vacío");
            }
            return array[1];

        }

    @Override
    public E suprimirMax() throws HeapVacioExcepcion {
        if(esVacio()){
            throw new HeapVacioExcepcion("suprimirMax: Heap Vacío");
        }
        E e = array[1]; // el primer elemento del heap
        array[1] = array[numElem]; // poner en la primera posición el último elemento
        array[numElem] = null;
        numElem--;
        //Mejor quitar las dos anteriores líneas y poner: array[numElem--] = null
        hundir(1);
        return e;
    }

    private void hundir(int hueco) throws HeapVacioException{
            int hijo = hueco * 2;
            E temporal = array[hueco];
            boolean fin = false;
            while (hijo <= numElem && !fin){ // si no quedan hijos y no encontré la solución
                // (hijo < numElem) ->se que hijo + 1 existe  ya que es menor que numElem
                if(hijo < numElem && array[hijo +1].compareTo(array[hijo])>0){
                    hijo ++;
                }

                if(array[hijo].compareTo(temp)> 0){
                    array[hueco] = array[hijo];
                    hueco = hijo;
                    hijo = hueco * 2;
                }else
                 fin = true;

            }

            array[hueco] = temporal;

    }
}

    /*private void hundir(int hueco) throws HeapVacioException{
            if(esVacio()){
                throw new HeapVacioException("hundir: arbol vacio");
            }
            // Comentar este código y comparar con la solución para luego mejorarlo
            E mayor = array[hueco];
            E hi = array[hueco*2];
            E hd = array[(hueco*2)+1];
            if(mayor.compareTo(hi) < 0){
                mayor = hi;
            }else if(mayor.compareTo(hd) < 0){
                mayor = hd;
            }

    }*/

    @Override
    public void insertar(E e) throws NullPointerException {

    }

    @Override
    public void anular()

    }


}

