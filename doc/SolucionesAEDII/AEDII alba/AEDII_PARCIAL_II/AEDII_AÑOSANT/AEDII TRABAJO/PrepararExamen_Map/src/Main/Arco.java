/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Yo
 */
public class Arco<E, T> {

    private Vertice<E> origen;
    private Vertice<E> destino;
    private T etiqueta;

    public Arco(Vertice<E> o, Vertice<E> d, T c){
        origen=o;
        destino=d;
        etiqueta=c;
    }
    public Vertice<E> getOrigen(){
        return origen;
    }

    public Vertice<E> getDestino(){
        return destino;
    }

    public T getEtiqueta(){
        return etiqueta;
    }
}
