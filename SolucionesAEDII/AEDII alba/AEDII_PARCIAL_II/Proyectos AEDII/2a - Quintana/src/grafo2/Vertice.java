/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo2;

/**
 *
 * @author Juan Yuri Díaz Sánchez
 */
public class Vertice<E> {
    private E etiqueta;
    
    public Vertice(E elem){
        this.etiqueta = elem;
    }


    public E getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(E elem) {
        this.etiqueta = elem;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Vertice){
            Vertice<E> v = (Vertice)o;
            
            
            if(this.getEtiqueta() != v.getEtiqueta())
                return false;
            
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        StringBuilder toret = new StringBuilder();
        
        toret.append(etiqueta);
        
        return toret.toString();
    }
    
    
}
