package map;

/**
 *
 * @author Juan Yuri Díaz Sánchez
 */
public interface Par<K,V> {
    public V getValor(); // Devuelve el valor del par
    
    public K getClave(); // Devuelve la clave del par
    
    public V setValor(V valor); // Devuelve el antiguo valor y lo sobreescribe con el que pasamos como parámetro
}
