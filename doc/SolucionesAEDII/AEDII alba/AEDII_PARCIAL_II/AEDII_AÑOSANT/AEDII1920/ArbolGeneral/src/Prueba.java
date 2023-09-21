/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author svsemeria_ESEI
 */
import arbolGeneral.ArbolGeneral;
import arbolGeneral.EnlazadoArbolGeneral;
import cola.*;
import lista.*;

public class Prueba {

    public static void main(String[] args) {
        ArbolGeneral<Integer> arbol
                = new EnlazadoArbolGeneral<>(53, new EnlazadoArbolGeneral(34, new EnlazadoArbolGeneral(34)), new EnlazadoArbolGeneral(6));

        Lista<Integer> lista = new ListaEnlazada<>();

        hojas(arbol, lista);

        while (!lista.esVacio()) {
            System.out.print(lista.recuperar() + " ");
            lista.suprimir(lista.recuperar());
        }

    }

    //Ejercicio 1, esta bien(Definitivo)
    private static int sumarContenidos(ArbolGeneral<Integer> arbol) { //Esta bien
        if (arbol.esVacio()) {
            return 0;
        } else {
            int suma = arbol.raiz();
            ArbolGeneral hijo = arbol.hijoMasIzq();
            while (!hijo.esVacio()) {
                suma += sumarContenidos(hijo);
                hijo = hijo.hermanoDer();
            }
            return suma;
        }
    }

    //Ejercicio 2, esta bien(Definitivo)
    private static <E> boolean mismaEstructura(ArbolGeneral<E> a, ArbolGeneral<E> b) { //Ya está
        if (a.esVacio() && b.esVacio()) { //Si ambos son vacios, tienen la misma estructura
            return true;
        }

        if (a.esVacio() || b.esVacio()) { //Si uno es vacio y el otro no, ya no tienen la misma estructura
            return false;
        }

        ArbolGeneral<E> hijoa = a.hijoMasIzq();
        ArbolGeneral<E> hijob = b.hijoMasIzq();
        while (!hijoa.esVacio() && !hijob.esVacio() && mismaEstructura(hijoa, hijob)) { //mientras los hijos no sean vacios y que tengan la misma estructura, me muevo
            hijoa = hijoa.hermanoDer();
            hijob = hijob.hermanoDer();
        }
        return hijoa.esVacio() && hijob.esVacio(); //llego aquí cuando ya he hecho las comprobaciones
    }

    //Ejercicio 3, esta bien(Definitivo)
    private static <E> boolean arbolDosTres(ArbolGeneral<E> arbol) { //Está listo
        ArbolGeneral<E> hijo = arbol.hijoMasIzq();
        int cont = 0;

        if (arbol.esVacio()) {
            return true;
        }
        if (hijo.esVacio()) {
            return true;
        }
        while (!hijo.esVacio() && arbolDosTres(hijo)) {
            cont++;
            hijo = hijo.hermanoDer();
        }
        return hijo.esVacio() && (cont == 2 || cont == 3); //Retornas true si es vacio y tiene 2 o 3 hijos
    }

    //Ejercicio 4, esta bien(Definitivo)
    private static <E extends Comparable<E>> boolean esSeleccion(ArbolGeneral<E> arbol) { //Está listo

        if (arbol.esVacio()) {
            return true;
        }

        ArbolGeneral<E> hijo = arbol.hijoMasIzq();

        if (hijo.esVacio()) {
            return true;
        }

        E menor = hijo.raiz(); //Me paro en el más a la izquierda porque no sé si tengo más hijos

        while (!hijo.esVacio() && esSeleccion(hijo)) {
            if (hijo.raiz().compareTo(menor) < 0) {
                menor = hijo.raiz();
            }
            hijo = hijo.hermanoDer();
        }

        return (hijo.esVacio() && arbol.raiz().equals(menor));
    }

    //Ejercicio 5, esta bien por fin coño e tu madre
    private static <E> int nivel(ArbolGeneral<E> arbol, E elemento) {

        if (arbol.esVacio()) {
            return -1;
        } else if (arbol.raiz().equals(elemento)) {
            return 0;
        } else {
            int cont = -1;
            ArbolGeneral<E> hijo = arbol.hijoMasIzq();

            while (!hijo.esVacio() && cont == -1) {
                cont = nivel(hijo, elemento);
                hijo = hijo.hermanoDer();
            }

            if (cont != -1) {
                return 1 + cont;
            } else {
                return -1;
            }
        }
    }

    //Ejercicio 6, esta bien(Definitivo)
    private static <E> int grado(ArbolGeneral<E> arbol) {
        ArbolGeneral<E> hijo = arbol.hijoMasIzq();
        int cont = 0;

        if (arbol.esVacio()) {
            return 0;
        } else if (hijo.esVacio()) {
            return 0;
        } else {
            while (!hijo.esVacio()) {
                cont++;
                hijo = hijo.hermanoDer();
            }
            return cont;
        }

    }

    //Ejercicio 7, esta bien(Definitivo)
    public static <E> int altura(ArbolGeneral<E> arbol) {
        if (arbol.esVacio()) {
            return 0;
        }
        if (arbol.hijoMasIzq().esVacio()) {
            return 0;
        }

        int maxGrado = 0;
        ArbolGeneral<E> hijo = arbol.hijoMasIzq();

        while (!hijo.esVacio()) {
            int cont = altura(hijo);

            if (cont > maxGrado) {
                maxGrado = cont;
            }

            hijo = hijo.hermanoDer();
        }
        return maxGrado + 1;
    }

    //Ejercicio 8, esta bien(Definitivo)
    public static <E> void anchura(ArbolGeneral<E> arbol) {
        Cola<ArbolGeneral<E>> c = new EnlazadaCola<>();
        c.insertar(arbol);
        do {
            arbol = c.suprimir();
            if (!arbol.esVacio()) {
                System.out.print(arbol.raiz() + " ");
                ArbolGeneral<E> hijo = arbol.hijoMasIzq();
                while (!hijo.esVacio()) {
                    c.insertar(hijo);
                    hijo = hijo.hermanoDer();
                }
            }
        } while (!c.esVacio());
    }

    //Ejercicio 9, está bien(Definitivo)
    public static int numPares(ArbolGeneral<Integer> arbol) {
        ArbolGeneral<Integer> hijo = arbol.hijoMasIzq();
        int cont = 0;

        if (arbol.esVacio()) {
            return 0;
        } else {
            //Verifica que la raiz sea par, si es así pone el contador a 1
            if (arbol.raiz() % 2 == 0) {
                cont = 1;
            }

            while (!hijo.esVacio()) {
                cont += numPares(hijo);
                hijo = hijo.hermanoDer();
            }
            return cont;
        }
    }

    //Ejercicio 10, esta bien(Definitivo)
    public static <E> void hojas(ArbolGeneral<E> arbol, Lista<E> lista) {
        if (!arbol.esVacio()) {
            if (arbol.hijoMasIzq().esVacio()) {
                lista.insertarFinal(arbol.raiz());
            } else {
                ArbolGeneral<E> hijo = arbol.hijoMasIzq();
                while (!hijo.esVacio()) {
                    hojas(hijo, lista);
                    hijo = hijo.hermanoDer();
                }
            }
        }
    }

}
