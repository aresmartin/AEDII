
package hashmap;


public class Vertice<E> {
    
    private E etiqueta;
    
    public Vertice(E elemento){
        
        this.etiqueta = elemento;
    }

    public E getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(E etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    public boolean equals(Object o){
        
        if(o instanceof Vertice){
            
            Vertice<E> v = (Vertice)o;
                  
            if(this.getEtiqueta() != v.getEtiqueta()) return false;
                
          return true;
          
        }
        
        else{
            return false;
        }
    }
}
