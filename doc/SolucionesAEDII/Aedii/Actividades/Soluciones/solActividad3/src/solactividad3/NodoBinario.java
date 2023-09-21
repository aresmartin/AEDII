/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad3;

public class NodoBinario<E>
{
    private E elemento;
    private NodoBinario<E> izq;
    private NodoBinario<E> der;
    
    // constructor
    public NodoBinario(E e, NodoBinario<E> hi, NodoBinario<E> hd)
    {
        elemento = e;
        izq = hi;
        der = hd;
    }
    
    // métodos
    public E getElemento()
    {
        return elemento;
    }
    
    public NodoBinario<E> getIzq()
    {
        return izq;
    }
    
    public NodoBinario<E> getDer()
    {
        return der;
    }
    
    public void setElemento(E e)
    {
        elemento = e;
    }
    
    public void setIzq(NodoBinario<E> hi)
    {
        izq = hi;
    }
    
    public void setDer(NodoBinario<E> hd)
    {
        der = hd;
    }
}    

