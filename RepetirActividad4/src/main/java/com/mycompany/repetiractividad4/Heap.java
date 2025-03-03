package com.mycompany.repetiractividad4;

public interface Heap<E> {
    public boolean esVacio();
    public E recuperarMax() throws HeapVacioExcepcion;
    public E suprimirMax() throws HeapVacioExcepcion;
    public void insertar(E e) throws NullPointerException;
    public void anular();
}
