package map;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Juan Yuri Díaz Sánchez
 * @param <K> la clave del par
 * @param <V> el valor asociado a esa clave
 */
public interface Map<K,V> {
    
    public boolean esVacio();
    public int tamaño();
    public V recuperar(K clave);
    public void insertar(K clave,V valor); 
    public V eliminar(K clave);
    public void limpiar();
    public List<K> claves();
    public List<V> valores();
    public List<Par<K,V>> pares();
    public boolean contieneClave(K clave);
    public boolean contieneValor(V valor);
    
}
