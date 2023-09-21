package solactividad6.Map;

import java.util.Iterator;

public interface Map<K,V> {
    public int tamaño();
	public V get (K clave);
	public void insertar(K clave, V valor);
	public V eliminar(K clave);
	public Iterator<K> getClaves();
	public Iterator<V> getValores();
	
	interface Par<K,V>{
		K getClave();
		V getValor();
		void setValor(V nuevo);
	}
}
