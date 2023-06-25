package proyectoaedii;
/**
 *
 * @author degap
 * @param <K>
 * @param <V>
 */
public class Par<K, V>{
    
    private K clave;
    private V valor;
    
    public Par(K clave, V valor){
        this.clave = clave;
        this.valor = valor;
    }
    public K getClave(){
        return clave;
    }
    public V getValor(){
        return valor;
    }
    public void setClave(K clave){
        this.clave = clave;
    }
    public void setValor(V valor){
        this.valor = valor;
    }
    
}

