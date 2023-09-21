package map;

/**
 *
 * @author Juan Yuri Díaz Sánchez
 */
public class Pares<K,V> implements Par<K,V>{
    private K clave;
    private V valor;
    
    public Pares(K clave,V valor){
        this.clave = clave;
        this.valor = valor;
    }
    
    @Override
    public V getValor() {
        return valor;
    }

    @Override
    public K getClave() {
        return clave;
    }

    @Override
    public V setValor(V valor) {
        V antiguo = this.valor;
        this.valor = valor;
        return antiguo;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Pares){
            Pares p = (Pares)o;
            
            if(this.getValor() != p.getValor())
                return false;
            
            if(this.getClave() != p.getClave())
                return false;
            
            return true;
            
        }else{
            return false;
        }
    }
    
}
