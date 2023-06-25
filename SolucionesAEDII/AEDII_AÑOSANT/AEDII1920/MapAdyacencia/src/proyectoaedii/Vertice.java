package proyectoaedii;

/**
 *
 * @author marco
 */
public class Vertice<E> {

    private E etiqueta;

    public Vertice(E etiqueta) {
        this.etiqueta = etiqueta;
    }

    public E getEtiqueta() {
        return etiqueta;
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        Vertice<E> v = (Vertice<E>) o;
        return etiqueta.equals(v.getEtiqueta());
    }

    public String toString() {
        return " " + etiqueta;
    }
}

