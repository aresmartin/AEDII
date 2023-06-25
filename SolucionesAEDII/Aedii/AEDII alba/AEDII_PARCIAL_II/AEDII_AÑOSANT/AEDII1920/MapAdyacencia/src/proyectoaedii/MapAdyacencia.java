package proyectoaedii;

import java.util.Iterator;
import lista.Lista;
import lista.ListaEnlazada;
//import java.util.Map;

/**
 *
 * @author Marcos Villar Avion
 */
public class MapAdyacencia<E, T> implements Grafo<E, T> {

    private Lista<VerticeConMap<E, T>> listVertices;
    private int numVertices;

    public MapAdyacencia() {
        this.numVertices = 0;
        this.listVertices = new ListaEnlazada<>();
    }

    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
        //algo para guardar el iterador
        Map<Vertice<E>, T> map = new HashMap();
        for (VerticeConMap<E, T> verticeMap : this.listVertices) {
            if (verticeMap.getVertice().equals(v)) {
                map = verticeMap.getAdy();
            }
        }
        return map.iteradorClaves();
    }

    public boolean estaArco(Arco<E, T> a) {
        Map<Vertice<E>, T> map = new HashMap();
        for (VerticeConMap<E, T> verticeMap : this.listVertices) { //Recorre todos la estructura de datos listVertices
            if (verticeMap.getVertice().equals(a.getOrigen())) { //Si algun vertice es igual al vertice origen del arco que le pasamos como parametro
                map = verticeMap.getAdy();
                Iterator<Vertice<E>> iterador = map.iteradorClaves();
                while (iterador.hasNext()) { //Mientras haya una siguiente
                    Vertice<E> siguiente = iterador.next();
                    if (siguiente.equals(a.getDestino())) {
                        //Si el vertice del mapa de adyacencia(VerticeDestino) es igual al verticeDestino del arco
                        if (map.recuperar(siguiente).equals(a.getEtiqueta())) {
                            //Y si la etiqueda del mapa de adyacencia(EtiquetaArco) es igual a la etiqueta del arco que le pasamos como parametro
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    @Override
    public boolean esVacio() {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estaVertice(Vertice<E> v) {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Vertice<E>> vertices() {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Arco<E, T>> arcos() {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarVertice(Vertice<E> v) {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarArco(Arco<E, T> a) {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarVertice(Vertice<E> v) {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarArco(Arco<E, T> a) {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

}
