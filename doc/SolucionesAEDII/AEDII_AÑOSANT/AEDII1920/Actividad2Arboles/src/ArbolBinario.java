

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author svsemeria_ESEI
 */
public interface ArbolBinario<E> {

    public boolean esVacio();

    /* Produce: Cierto si this está vacío. Falso en caso contrario. */
    public E raiz() throws ArbolVacioException;

    /* Produce: Si this está vacío lanza la excepción ArbolVacioExcepcion,
       sino devuelve el objeto almacenado en la raíz */
    public EnlazadoArbolBinario<E> hijoIzq() throws ArbolVacioException;

    /* Produce: Si this está vacío lanza la excepción ArbolVacioExcepcion,
       sino devuelve el subárbol izquierdo*/

    public EnlazadoArbolBinario<E> hijoDer() throws ArbolVacioException;

    /* Produce: Si this está vacío lanza la excepciónArbolVacioExcepcion,
       sino devuelve el subárbol derecho*/

    public boolean esta(E elemento);

    /* Produce: Cierto si elemento está en this, falso, en caso contrario*/

    public void setRaiz(E elemRaiz) throws ArbolVacioException;

    /* Modifica: this
       Produce: Si this está vacío lanza la excepción ArbolVacioExcepcion,
       sino asigna el objeto elemRaíz a la raíz del árbol this*/

    public void setHijoIzq(EnlazadoArbolBinario<E> hi) throws ArbolVacioException, NullPointerException;

    /* Modifica: this
       Produce: Si hi es null, lanza la excepción NullPointerException.
       En caso contrario, si this está vacío lanza la excepción ArbolVacioExcepcion,
       sino asigna el árbol hi como subárbol izquierdo de this*/

    public void setHijoDer(EnlazadoArbolBinario<E> hd) throws ArbolVacioException, NullPointerException;

    /* Modifica: this
       Produce: Si hd es null, lanza la excepción NullPointerException.
       En caso contrario, si this está vacío lanza la excepción ArbolVacioExcepcion,
       sino asigna el árbol hd como subárbol derecho de this*/

    public void suprimir();
    /* Modifica: this
       Produce: El árbol binario vacío*/
}
