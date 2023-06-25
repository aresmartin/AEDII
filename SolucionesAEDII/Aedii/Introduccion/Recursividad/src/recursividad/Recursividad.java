package recursividad;

public class Recursividad {
    
      public static void main(String[] args){
          
        
          
      }
      
      public static int sumaRecursiva (int numero){
        
        int res;
        
        if(numero == 1){
            
            return 1;
        }else{
            
            res = numero + sumaRecursiva(numero - 1);
        }
        return res;
    }
    
    public static int factorial(int numero){
        
        int res;
        
        if(numero == 1){
            
            return 1;
        }else{
            
            res = numero * factorial(numero-1);
        }
        
        return res;
    }
      
      public static void mostrarArrayRecursivo(int array[], int indice){
          
          if(indice != array.length){
              
              System.out.println(array[indice]);
              mostrarArrayRecursivo(array, indice+1);
              
          }
          
          
      }
}
