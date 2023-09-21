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
public class SolActividad1 {

    //ejercicio 1
	public static int factorial(int n)
	{
		if (n == 0) return 1;
                else return n * factorial (n-1);
	}
	
	//ejercicio 2
	public static int cuadrado (int n)
	{
		if (n == 0) return 0;
		else return cuadrado(n-1) + 2 * n - 1; 	
	}
	
	//ejercicio 3
	public static int sumarDigitos (int n){
            if (n < 10) return n;
            else return (n%10) + sumarDigitos(n/10);
        }
        
        public static void visualizarDigitos (int n){
            if (n < 10) System.out.print(n);
            else {
                 visualizarDigitos(n/10);
                 System.out.print(n%10);
            }
        }
	//ejercicio 4
	public static int euclides (int n1, int n2)
	{
		if (n1 == n2) return n1;
		else if (n1 > n2) return euclides(n1-n2, n2);
		else return euclides (n1, n2-n1);
	}
	
	//ejercicio 5
	public static boolean palindromo(String cadena)
	{
		if (cadena.length() == 0 || cadena.length() == 1)
			return true;
		else if ( cadena.charAt(0)!=cadena.charAt(cadena.length()-1) )
			return false;
		else return palindromo(cadena.substring(1, cadena.length()-1));
	}
	//ejercicio 6
        public static int sumarValoresArray(int[] vector){
            return sumarValoresArray(vector, vector.length-1);
        }
        private static int sumarValoresArray(int[] vector, int fin)
	{
		if (fin == 0) return vector[fin];
                else return vector[fin] + sumarValoresArray(vector, fin - 1);
	}
	//ejercicio 7
        public static void invertirArray(int[] vector){
            invertirArray(vector, vector.length-1);
        } 
	private static void invertirArray(int[] vector, int fin)
	{
		if (fin!= 0){
			int aux = vector[0];
			for (int i= 1; i<=fin; i++){
				vector[i-1] = vector[i];
			}
			vector[fin] = aux;
			invertirArray(vector, fin-1);
			}
	}
	//otra forma
        public static void invertirArray2(int[] vector){
            invertirArray2(vector, 0, vector.length-1);
        }
	public static void invertirArray2(int[] vector, int inicio, int fin){
		if (inicio < fin){
			int aux = vector[inicio];
			vector[inicio] = vector[fin];
			vector[fin] = aux;
			invertirArray2(vector, inicio + 1, fin - 1);
			}
	}
        //otra forma
        public static int[] invertirArray3(int[] vector){
            return invertirArray3(vector, 0);
        }
        private static int[] invertirArray3(int[] vector, int inicio){
            int[] toret;
            if (inicio <= vector.length-1){
                toret = invertirArray3(vector, inicio+1);
                toret[vector.length-1-inicio] = vector[inicio];  
            }
            else toret = new int[vector.length];
            return toret;
        }
        
        //ejercicio 8
        public static int menorArray(int[] vector){
            return menorArray(vector, vector.length-1, Integer.MAX_VALUE);
        }
        public static int menorArray(int[] vector, int indice, int menor){
            if (indice == 0){
                if (vector[indice] < menor)
                    return vector[indice];
                else
                    return menor;
            }
            else{
                if (vector[indice] < menor)
                    return menorArray(vector, indice - 1, vector[indice]);
                else
                    return menorArray(vector, indice - 1, menor);
            }
        }
        //otra forma
        public static int menorArray2(int[] vector){
            return menorArray2(vector, 0, Integer.MAX_VALUE);
        }
        public static int menorArray2(int[] vector, int indice, int menor){
            if (indice == -1){
                    return menor;
            }
            else{
                if (vector[indice] < menor)
                    return menorArray2(vector, indice - 1, vector[indice]);
                else
                    return menorArray2(vector, indice - 1, menor);
            }
        }
        //otra forma
        public static int menorArray3(int[] vector){
            return menorArray3(vector, 0);
        }
        private static int menorArray3(int[] vector, int inicio){
            int menor;
            if (inicio == vector.length - 1){
                menor = vector[inicio];
            }
            else{
                menor = menorArray3(vector, inicio + 1);
                if (vector[inicio] < menor)
                    return vector[inicio];
                else
                    return menor;
            }
            return menor;
        }
        //otra forma
        public static int menorArray4(int[] vector){
            return menorArray(vector, 0, vector.length);
        }
        private static int menorArray4(int [] array, int inicio, int fin){
            if (inicio == fin-1)
                return array[inicio];
            else if (array[inicio] < array[fin-1])
                return menorArray4(array, inicio, fin-1);
            else
                return menorArray4(array, inicio+1, fin);
        }
        
        //ejercicio 9
        public static int busquedaBinaria (double [] array, int inicio, int fin, double elemento){
	    int medio;
            if (inicio>fin) return -1;
            else {
                medio = (fin+inicio)/2;
                if (array[medio]<elemento)
                    return busquedaBinaria(array, medio+1, fin, elemento);
                else if (array[medio]>elemento)
                        return busquedaBinaria(array, inicio, medio-1, elemento);
                     else return medio;
            }
        }
        //ejercicio 10
        public static <E> Stack<E> copiar (Stack<E> pila){
            Stack<E> toret;
            if (pila.empty()){
                return new Stack<>();
            }
            else {
                E elemento = pila.pop();
                toret = copiar(pila);
                toret.push(elemento);
                pila.push(elemento);
                return toret;
                
            }
            
        } 
        
        
	
    
}
