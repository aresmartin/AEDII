/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad6;

/**
 *
 * @author jdher
 */
public class Arco <E,T> {
    
    private Vertice<E> origen, destino;
    private T etiqueta;

    public Arco(Vertice<E> origen, Vertice<E> destino, T etiqueta){
    
    this.origen=origen;
    this.destino=destino;
    this.etiqueta=etiqueta;
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
