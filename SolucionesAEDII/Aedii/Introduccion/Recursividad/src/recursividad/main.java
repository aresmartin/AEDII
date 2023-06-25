package recursividad;

import static recursividad.Recursividad.factorial;
import static recursividad.Recursividad.mostrarArrayRecursivo;
import static recursividad.Recursividad.sumaRecursiva;

public class main {

    public static void main(String[] args) {
        
         //1.-Sumar los numeros enteros naturales hasta N (se lo damos nosotros) de forma recursiva
        
        int n = 9;
        int resultado = sumaRecursiva(n);
        System.out.println("La suma rescursiva es: " + resultado);
        
        //2.- Factorial de un numero
        
       int f = 6;
       int mult = factorial(f);
        System.out.println("El factorial es: " + mult );
        
         //3.- Recorrer un array de forma recursiva
                   
          int[] array = {1,2,3,4,5};
          mostrarArrayRecursivo(array, 0);
          
        //4.- Buscar un elemento de un array de forma recursiva
    }
    
    
    
}
