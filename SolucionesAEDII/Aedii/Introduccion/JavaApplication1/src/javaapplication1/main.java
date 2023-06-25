/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Usuario
 */
public class main {
    
    public static void main(String[] args){
        
       PilaDinamica <Integer> pila = new PilaDinamica<>();
        
       pila.push(5);
       pila.push(10);
       pila.push(15);
       pila.push(20);
       
        System.out.println("El tamaño de la pila es de: " + pila.size());
        System.out.println("El primer elemento de la pila es: " + pila.top());
        
       int numero = pila.pop();
       
        System.out.println("He sacado el numero: " + numero);
       
        
        
    }
}
