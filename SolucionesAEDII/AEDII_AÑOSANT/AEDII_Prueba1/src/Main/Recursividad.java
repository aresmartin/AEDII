/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import pila.EnlazadaPila;
import pila.Pila;

/**
 *
 * @author Yo
 */
public class Recursividad {

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else {

            return num * factorial(num - 1);
        }

    }

//ejercicio 2
    public static int cuadrado(int num) {
        if (num == 0) {
            return 0;
        } else {
            return cuadrado((num - 1)) + (2 * num - 1);
        }
    }

//ejercicio 3
    public static int sumar(int num) {
        if (num < 10) {
            return num;
        } else {
            return (num % 10) + sumar(num / 10);
        }
    }

//ejercicio 4
    public static int divisor(int num1, int num2) {
        if (num1 == num2) {
            return 1;
        } else {
            if (num1 > num2) {
                return 1 + divisor(num1 - num2, num2);
            } else {
                return 1 + divisor(num2 - num1, num1);
            }

        }
    }

//ejercicio 5
    public static String invertir(String palabra) {
        return invertir(palabra, palabra.length());

    }

    private static String invertir(String palabra, int index) {
        if (index == 0) {
            return "";
        } else {
            return palabra.charAt(index - 1) + invertir(palabra, index - 1);
        }
    }

//ejercicio 6
    public static int sumar(int[] v) {
        return sumar(v, v.length);

} 
private static int sumar(int[] v, int index) {
        if (index == 0) {
            return 0;
        } else {
            return v[index - 1] + sumar(v, index - 1);
        }
    }

/*ejercicio 6 segunda parte mal hecha
    public static int sumarEnteros(int[] vector) {
        if (vector[0] == vector[vector.length - 1]) {
            return vector[0];
        } else {
            return vector[vector.length - 1] + sumarEnteros(vector[vector.length - 1]);

        }
    }
*/

//ejercicio 7 está mal
    public static void invertir(int[] vect) {
        invertir(vect, vect.length);

    }

    private static void invertir(int[] v, int index) {
        int[] aux = null;
        if (index == 0){
           aux[index]=v[index];
            
        } 
        else {
            invertir(v, index - 1);
        }
    }

//ejercicio 8
    public static int devolver(int[] v) {
        return devolver(v, v.length);

    }

    private static int devolver(int[] v, int index) {
        if (index == 0) {
            return v[0];
        } else {
            return  devolver(v, index - 1);
        }
    }
    
    //ejercicio 9
    public static int binariaRec(int[] v, int elemento){
         return binariaRec(v,elemento,0,v.length-1); 
        
    }
    public static int binariaRec(int[] v, int elemento, int inicio,int fin){
        int medio;
        
        if(inicio>fin){
            return-1;
        }else{
            medio=(inicio+fin)/2;
            if(v[medio]<elemento){
                return binariaRec(v,elemento,medio+1,fin);
            }else if(v[medio]>elemento){
                return binariaRec(v,elemento,inicio,medio-1);
            }
            else return medio;
        }
        
        
        
    }
    //ejercicio 10 revisar
    public static<E> Pila<E> copiaRec(Pila<E> p){
        if(p.esVacio()){
            return new EnlazadaPila<E>();
        }
        else{
            E elem=p.pop();
            Pila<E> destino=copiaRec(p);
            p.push(elem);
            return destino;
        }
    }
}
