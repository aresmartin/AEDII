package proyectoaedii;

/**
 *
 * @author marco
 */
public class Arco<E,T>
{
    private Vertice<E> origen;
    private Vertice<E> destino;
    private T etiqueta;

    public Arco(Vertice<E> vo, Vertice<E> vd, T etiq)
    {
        origen = vo;
        destino = vd;
        etiqueta = etiq;
    }

    
    public Vertice<E> getOrigen()
    {
        return origen;
    }
    public Vertice<E> getDestino()
    {
        return destino;
    }
    public T getEtiqueta()
    {
        return etiqueta;
    }
    public void setOrigen(Vertice<E> vo)
    {
        origen = vo;
    }
    public void setDestino (Vertice<E> vd)
    {
        destino = vd;
    }
    public void setEtiqueta(T etiq)
    {
        etiqueta = etiq;
    }
    public String toString(){
        return ""+origen+"-"+destino+": "+etiqueta;
    }

}
