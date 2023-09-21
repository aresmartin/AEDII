/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad5;

import arbolGeneral.ArbolGeneral;

/**
 *
 * @author Alba
 */
public class Actividad5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    //Ejercicio1
    public static int suma (ArbolGeneral<Integer> a){
       if(a.esVacio()){
           return 0;
       }else{
           int cont = a.raiz();
           ArbolGeneral<Integer> hijo = a.hijoMasIzq();
           while(!hijo.esVacio()){
               cont += suma(hijo);
               hijo = hijo.hermanoDer();
           }
           return cont;
       }
    }
    
    //Ejercicio2 -> parecido al de idénticos de la presentación
    //quitariamos si la raiz de a es igual a la de b y el ej ya estaría hecho
    
    //Ejercicio3
    public static <E> boolean arbol23(ArbolGeneral<E> arbol) {
        //Un arbol vacio y que solo tiene un nodo es un arbol 2 3
        //Para mirar si un arbol es dos tres tendriamos que mirar si el num de subarboles
        //de la raiz sean dos o tres y que los hijos sean 2-3
        if (arbol.esVacio()) {
            return true;
        } else if (arbol.hijoMasIzq().esVacio()) {
            return true;
        } else {
            //numero de subarboles de la raiz
            int numSubArboles = 0; //para contar el num subarboles de la raiz
            ArbolGeneral<E> hijo = arbol.hijoMasIzq();
            while (!hijo.esVacio() && numSubArboles < 4) {
                numSubArboles++;
                hijo = hijo.hermanoDer();
            }
            if (numSubArboles == 2 || numSubArboles == 3) {
                //nos quedaria mirar que los hijos también sean así
                hijo = arbol.hijoMasIzq();
                while (!hijo.esVacio()) {
                    if (!arbol23(hijo)) {
                        hijo = hijo.hermanoDer();
                    }
                    return true;
                }
            } 
        
    }
        return false;
    
    }  
    
    //Ejercicio4
    public static <E extends Comparable<E>> boolean serSeleccion(ArbolGeneral<E> arbol) {
        //El padre siempre es el menor de los hijos
        if (arbol.esVacio()) {
            return true;
        } else if (arbol.hijoMasIzq().esVacio()) {
            return true;
        }
        ArbolGeneral<E> hijo = arbol.hijoMasIzq();
        ArbolGeneral<E> hijoMenor = hijo;
        while (!hijo.esVacio()) {
            hijo = hijo.hermanoDer();
            if (hijo.raiz().compareTo(hijoMenor.raiz()) < 0) {
                hijoMenor = hijo;
            }
            if (hijoMenor.raiz().equals(arbol.raiz())) {
                hijo = hijo.hijoMasIzq();
                while (!hijo.esVacio()) {
                    if (!serSeleccion(hijo)) {
                        return false;
                    }
                    hijo = hijo.hermanoDer();
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
