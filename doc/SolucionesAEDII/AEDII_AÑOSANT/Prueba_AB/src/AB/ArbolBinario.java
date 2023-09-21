/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AB;

/**
 *
 * @author Yo
 */
public interface ArbolBinario<E> {

    public boolean esVacio();

    public E raiz() throws ArbolVacioException;

    public ArbolBinario<E> hijoIzq() throws ArbolVacioException;

    public ArbolBinario<E> hijoDer() throws ArbolVacioException;

    public boolean esta(E elemento);

    public void setRaiz(E elemRaiz) throws ArbolVacioException;

    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioException, NullPointerException;

    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioException, NullPointerException;

    public void suprimir();

}
