package javaapplication1;

public class PilaDinamica<T>{
    
    private Nodo<T> top;
    private int tamano;
    
    public PilaDinamica(){
        
        this.top = null;
        this.tamano = 0;
    }
    
    public int size(){
        
        return this.tamano;
    }
    
    public boolean isEmpty(){
        
        return top == null;
    }
    
    //Devuelve el contenido del primer elemento(no devuelve nada)
    public T top(){
        
        if(isEmpty()){
            
            return null;
        }else{
            
            return top.getElemento();
            
        }
        
    }
     
    //quitar el ultimo dato que se introdujo en la pila (lo saca y lo elimina)
    public T pop(){
        
        if(isEmpty()){
            
            return null;
        }else{
            
            T elemento = top.getElemento();
            Nodo<T> aux = top.getSiguiente();
            top = null;
            top = aux;
            this.tamano --;
                return elemento;
        }
    
       
    }
    
    //introducimos un dato en la pila
    public void push(T elemento){
        
        Nodo<T> nuevo = new Nodo<T>(elemento, top);
        
        top = nuevo;
        this.tamano ++;
        
    }
    
    @Override
    public String toString(){
        
        if(isEmpty()){
            return "La pila esta vacia";
        }else{
            
            String resultado = "";
            Nodo<T> toret = top;
            
            while(toret != null){
                
               resultado += toret.toString();
               toret = toret.getSiguiente(); 
            }
                   return resultado;
        }
        
    }
        
    
}
