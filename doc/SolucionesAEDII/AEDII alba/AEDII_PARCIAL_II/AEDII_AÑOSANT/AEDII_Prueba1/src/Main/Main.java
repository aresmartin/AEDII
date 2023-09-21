/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import pila.EnlazadaPila;

/**
 *
 * @author Yo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num=4;
        int[]v={1,2,3,4,3}; 
        EnlazadaPila<Integer> p = new EnlazadaPila<Integer>();
        p.push(3);
        p.push(7);
        p.push(8);
        p.push(1);
        //ejercicio1
        System.out.println(Recursividad.factorial(num));
        //ejercicio2
        System.out.println(Recursividad.cuadrado(num));
        //ejercicio3
        System.out.println(Recursividad.sumar(133356));
        //ejercicio4
        System.out.println(Recursividad.divisor(5,25));
        //ejercicio5
        System.out.println(Recursividad.invertir("Miguel"));
        //ejercicio6
        System.out.println(Recursividad.sumar(v));
        //ejercicio 7 esta mal
        Recursividad.invertir(v);
        System.out.println("[");
        for(int i=0;i<v.length;i++){
            System.out.println(v[i]);
        }
        System.out.println("]");
        //ejercicio 8
        System.out.println(Recursividad.devolver(v));
        //ejercicio 9
        System.out.println(Recursividad.binariaRec(v, num));
        System.out.println("------------");
        //ejercicio 10 esta mal
        Recursividad.copiaRec(p);
        


    }
    
}
