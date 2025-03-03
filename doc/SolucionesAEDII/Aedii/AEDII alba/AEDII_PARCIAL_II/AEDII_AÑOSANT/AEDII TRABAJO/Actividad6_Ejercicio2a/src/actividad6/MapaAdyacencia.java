import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jdher
 */
public class MapaAdyacencia<E,T> implements Grafo<E,T>{
    
    private List<VerticesConMap<E,T>> listVertices;
    
     public MapaAdyacencia(){
    
        listVertices=new ArrayList<>();
        
    }
    
    public Iterator<Vertice<E>> adyacentes(Vertice<E> v){
        
         List <Vertice<E>> lista= new ArrayList<>();
        
         int i=0;
        
        while(!listVertices.get(i).getVertice().equals(v)&& i<listVertices.size()){
            
             i++;
        
        }
        
           if(listVertices.get(i).getVertice().equals(v)){
            
                lista=(List<Vertice<E>>) listVertices.get(i).getAdy().keySet();
            
            }
        Iterator <Vertice<E>> iterador_toret = lista.iterator();
        
        return iterador_toret;
    }
        
   
    
            
    public boolean estaArco(Arco<E,T> arc){
        
        boolean toret=false;
        int i=0;
        
        while(i<listVertices.size()&&toret==false)
        {
            
            if(listVertices.get(i).getAdy().contieneValor(arc.getEtiqueta())&&
                    listVertices.get(i).getAdy().esta(arc.getDestino())&&
                    listVertices.get(i).getVertice().equals(arc.getOrigen())){
                
                toret=true;
            
                } 
                i++;
        
        }
        return toret;



    }
}
