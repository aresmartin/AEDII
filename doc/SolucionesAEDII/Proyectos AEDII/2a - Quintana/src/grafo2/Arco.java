package grafo2;

/**
 *
 * @author Juan Yuri Díaz Sánchez
 */
public class Arco<E,T>{
    private Vertice<E> origen;
    private Vertice<E> destino;
    private T etiqueta;
    
    public Arco(Vertice<E> origen, Vertice<E> destino, T etiqueta){
        this.origen = origen;
        this.destino = destino;
        this.etiqueta = etiqueta;
    }

    
    public Vertice<E> getOrigen() {
        return origen;
    }

    
    public Vertice<E> getDestino() {
        return destino;
    }

    
    public T getEtiqueta() {
        return etiqueta;
    }

    
    public void setOrigen(Vertice<E> vo) {
        this.origen = vo;
    }

    
    public void setDestino(Vertice<E> vd) {
        this.destino = vd;
    }

    
    public void setEtiqueta(T etiq) {
        this.etiqueta = etiq;
    }
    
}
