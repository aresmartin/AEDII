/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad1;

import java.util.Stack;

/**
 *
 * @author LenovoPavon
 */
public class Main {
    public static void main (String[] args){
		
		//ejercicio 1
		System.out.println("Factorial: " + SolActividad1.factorial(4));
		
		//ejercicio 2
		System.out.println("cuadrado de 4: " + SolActividad1.cuadrado(4));
		
		//ejercicio 3
		//sumar(1369);
		System.out.println("La suma es: " + SolActividad1.sumarDigitos(1369));
		//visualizar digitos
                SolActividad1.visualizarDigitos(1369);
                System.out.println();
		//ejercicio 4
		System.out.println("El maximo común divisor es: " + SolActividad1.euclides(36, 60));
		
		//ejercicio 5
		System.out.println("Palindromo: " + SolActividad1.palindromo("dabalearrozalazorraelabad"));
		
                //ejercicio 6
                int [] vector1 = {1,2,3,4,5};
                System.out.println("Suma vector: " + SolActividad1.sumarValoresArray(vector1));
                
		//ejercicio 7
		int [] vector = {1,2,3,4,5,6,7,8,9};
		SolActividad1.invertirArray(vector);
		System.out.print("Vector invertido: ");
		for(int i=0; i < vector.length; i++){
			System.out.print(vector[i]);
		}
		System.out.println();
		SolActividad1.invertirArray2(vector);
		System.out.print("Vector invertido: ");
		for(int i=0; i < vector.length; i++){
			System.out.print(vector[i]);
		}
                System.out.println();
                
		//ejercicio 8
                int [] vector2 = {1,20,3,40,5};
                System.out.println("Elemento menor: " + SolActividad1.menorArray(vector2));
                
                //ejercicio 9
                double [] vector3 = {10.5,20.6,3.0,4.4,5.6};
                System.out.println("la posición del elemento 3.0 es: " + SolActividad1.busquedaBinaria(vector3,0,vector3.length-1, 3.0));
                
                //ejercicio 10
                Stack<Integer> original = new Stack<>();
                original.push(1);
                original.push(2);
                Stack<Integer> copia = SolActividad1.copiar(original);
                System.out.println("Copia " + original.equals(copia));
                
                
	}
}
