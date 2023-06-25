/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad1_Recursividad;

/**
 *
 * @author svsemeria_ESEI
 */
public class Actividad1_Recursividad {

    public static void main(String[] args) {
//        String palabra = "manolo";
//
//        System.out.print(invertir(palabra));
//        
//        System.out.println("\n");
//        String toret = "";
//        
//        int inicio = palabra.length() - 1;
//        int fin = palabra.length();
//        
//        toret += palabra.substring(inicio, fin);
//        
//        inicio--;
//        fin--;
//        
//        toret += palabra.substring(inicio, fin);
//        
//        inicio--;
//        fin--;
//        
//        toret += palabra.substring(inicio, fin);
//        
//        inicio--;
//        fin--;
//        
//        toret += palabra.substring(inicio, fin);
//        
//        inicio--;
//        fin--;
//        
//        toret += palabra.substring(inicio, fin);
//        
//        inicio--;
//        fin--;
//        
//        toret += palabra.substring(inicio, fin);
//        
//        inicio--;
//        fin--;
//        
//        System.out.println(toret);

        int[] numeros1 = new int[]{10, 20, 25, 30, 40, 50};
        int[] numeros2 = new int[]{2, 4, 3, 5, 8, 10};
        final int indice = 0;

        System.out.println(busquedaBinariaRecursiva(numeros1, 25));

    }

    //Ejercicio 1
    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    //Ejercicio 2
    private static int cuadrado(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return cuadrado(n - 1) + (2 * n) - 1;
        }
    }

    //Ejercicio 3
    private static int sumaDigitos(int n) {
        if (n == 0) {
            return 0;
        } else {
            return sumaDigitos(n / 10) + (n % 10);
        }
    }

    //Ejercicio 4
    private static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            //int resto = a % b;
            return mcd(b, (a % b));
        }
    }

    //Ejercicio 5
    private static String invertir(String palabra) { //No va
        return "";
    }

    //Ejercicio 6
    //Los putos arrays necesitan o bien un indice(0) como paramétro o bien un inicio y fin
    private static int sumaArray1(int[] numeros, int indice) {
        int suma = 0;

        if (indice < numeros.length) {
            suma += numeros[indice++] + sumaArray1(numeros, indice);

            return suma;
        }
        return suma;
    }

    //Ejercicio 7
    //Los putos arrays necesitan o bien un indice(0) como paramétro o bien un inicio y fin
    private static void invertirNumeros(int[] numeros, int inicio, int fin) { //No va

    }

    //Ejercicio 8
    //Los putos arrays necesitan o bien un indice(0) como paramétro o bien un inicio y fin
    private static int menorElem(int[] numeros, int indice) {
        int menor = 9999;

        if (indice < numeros.length) {
            if (numeros[indice] < menor) {
                menor = numeros[indice];
            }

            menorElem(numeros, indice + 1);

            return menor;
        }
        return menor;
    }

    //Ejercicio 9
    private static int busquedaBinariaRecursiva(int[] numeros, int elem) {

        /*int inicio = 0;
        int fin = numeros.length - 1;
        int medio;

        while (inicio <= fin) {
            medio = (inicio + fin) / 2;

            if (numeros[medio] < elem) {
                inicio = medio + 1;
            } else {
                if (numeros[medio] > elem) {
                    fin = medio - 1;
                } else {
                    while (numeros[medio] != elem && medio != inicio) {
                        medio--;
                    }
                    return medio;
                }
            }

        }

        return inicio;*/
        return 0;
    }

    //Ejercicio 10
}
