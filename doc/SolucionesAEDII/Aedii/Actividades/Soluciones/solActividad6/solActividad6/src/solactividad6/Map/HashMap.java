package solactividad6.Map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class HashMap<K,V> implements Map<K,V> {
    private int capacidad;
    private int numElems;
    private List<Map.Par<K,V>> [] datos;

    public HashMap(int capacidad) throws IllegalArgumentException{
        if (capacidad<=0)
        throw new IllegalArgumentException("ERROR: capacidad negativa");
        else {
             this.capacidad = capacidad;
             numElems = 0;
             datos = new List[capacidad];
             for (int i=0; i<capacidad; i++)
                     datos[i] = new LinkedList<>();
        }
    }
    public HashMap(){
        this(50);
    }

    private int funcionHash(K clave){
        return Math.abs(clave.hashCode()) % capacidad;
    }

    @Override
    public int tamaño(){
        return numElems;
    }

    @Override
    public V get (K clave){
        int indice = funcionHash(clave);
        for (Map.Par<K,V> p: datos[indice])
            if (p.getClave().equals(clave)) return p.getValor();
        return null;
    }

    @Override
    public void insertar(K clave, V valor){
        V v = get(clave);
        int indice= funcionHash(clave);
        if(v!=null){
            for (Map.Par<K,V> p: datos[indice])
                if (p.getClave().equals(clave))
                        p.setValor(valor);
        }
        else {
            datos[indice].add(new HashPar<>(clave,valor));
            numElems++;
        }
    }

    @Override
    public V eliminar (K clave) {
        int indice = funcionHash(clave);
        if (datos[indice].contains(new HashPar<>(clave,get(clave)))){
            V valor = get(clave);
            datos[indice].remove(new HashPar<>(clave,valor));
            numElems--;
            return valor;
        }
        else return null;
    }
    @Override
    public Iterator<K> getClaves(){
        Vector<K> vector = new Vector<>();
        for (int indice=0; indice<capacidad; indice++){
                for (Map.Par<K,V> p: datos[indice]){
                        vector.add(p.getClave());
                }
        }
        return vector.iterator();
    }

    @Override
    public Iterator<V> getValores(){
            Vector<V> vector = new Vector<>();
            //for (int indice=0; indice<capacidad; indice++){
            for(List<Map.Par<K,V>> lista : datos){
                    for (Map.Par<K,V> p: lista)
                            vector.add(p.getValor());
            }
            return vector.iterator();
    }

    static class HashPar<K,V> implements Map.Par<K, V>{
            K cla;
            V val;
            HashPar(K cla, V val){
                    this.cla = cla;
                    this.val =  val;
            }

            @Override
            public K getClave(){
                    return cla;
            }
            @Override
            public V getValor(){
                    return val;
            }
            @Override
            public void setValor(V nuevo){
                    val = nuevo;
            }
            @Override
            public boolean equals(Object o){
                    HashPar<K,V> hp= (HashPar<K,V>) o;
                    return cla.equals(hp.cla) && val.equals(hp.val);
            }


    }


}

