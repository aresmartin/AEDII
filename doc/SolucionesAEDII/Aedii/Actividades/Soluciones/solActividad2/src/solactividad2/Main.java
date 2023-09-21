/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad2;

import arbolBinario.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LenovoPavon
 */
public class Main {
     public static void main (String [] args)
    {
        Scanner entrada = new Scanner(System.in);
        // utilizaremos entrada para leer l�neas desde el teclado
        String preord, inord;
        ArbolBinario<Integer> inicial, copia;
        System.out.println ("Árboles binarios");
        System.out.print("Introduzca el recorrido en preorden:  ");
        preord = entrada.nextLine();
        System.out.print("Introduzca el recorrido en inorden:  ");
        inord = entrada.nextLine();
        //reconstruir el arbol
        inicial = Actividad2.reconstruir2(preord, inord);
        
       
        System.out.println("1. Numero de nodos?: " + Actividad2.numNodos(inicial));
        System.out.println();
       
        System.out.println("2. Numero de hojas?: " + Actividad2.numHojas(inicial));
        System.out.println();
        
        System.out.println("3. Degenerado?: " + (Actividad2.degenerado(inicial) ?"Si": "No"));
        System.out.println();
        
        System.out.println("4. Completo?: " + (Actividad2.completo(inicial) ?"Si": "No"));
        System.out.println();
               
        System.out.println("7. Copia");
        copia = Actividad2.copia(inicial);
        System.out.print("Recorrido en preorden:");
        Actividad2.preorden(copia);
        System.out.println();
        System.out.print("Recorrido en inorden:");
        Actividad2.inorden(copia);
        System.out.println();System.out.println();
        
        System.out.println("5. Misma forma?: " + (Actividad2.mismaForma(inicial,copia) ?"Si": "No"));
        System.out.println();
        
        System.out.println("6. Idénticos?: " + (Actividad2.identicos(inicial,copia) ?"Si": "No"));
        System.out.println();
        
       
        
        ArbolBinario<Integer> otroIgual;
        System.out.println ("Árboles binarios");
        System.out.print("Introduzca el recorrido en preorden:  ");
        preord = entrada.nextLine();
        System.out.print("Introduzca el recorrido en inorden:  ");
        inord = entrada.nextLine();
        otroIgual = Actividad2.reconstruir2(preord, inord);
        System.out.println("5. Misma forma?: " + (Actividad2.mismaForma(inicial,otroIgual) ?"Si": "No"));
        System.out.println();
        System.out.println("6. Idénticos?: " + (Actividad2.identicos(inicial,otroIgual) ?"Si": "No"));
        System.out.println();
        
        
        System.out.println("8. Está el valor 3: " + Actividad2.esta(inicial,3));
        System.out.println();
        
        System.out.println("9. Numero nodos nivel 3 es: " + Actividad2.contarNivel(inicial,3));
        System.out.println();
       
        List<Integer> l = Actividad2.nodosNivel(inicial,2);
        System.out.print("10. Lista de nodos nivel 2 es: " );
        l.forEach((i) -> {
            System.out.print(i + ", ");
         });
        System.out.println();
        
        System.out.println("11. copia hasta nivel 2");
        ArbolBinario<Integer> cpNivel = Actividad2.copiaHastaNivel(inicial,2);
        System.out.print("Recorrido en preorden:");
        Actividad2.preorden(cpNivel);
        System.out.println();
        System.out.print("Recorrido en inorden:");
        Actividad2.inorden(cpNivel);
        System.out.println();System.out.println();
        
        System.out.println("12. Altura del árbol: " + Actividad2.altura(inicial));
        System.out.println();
        
        System.out.println("13. Copia sin hojas ");
        ArbolBinario<Integer> sinHojas = Actividad2.eliminarHojas(inicial);
        System.out.print("Recorrido en preorden:");
        Actividad2.preorden(sinHojas);
        System.out.println();
        System.out.print("Recorrido en inorden:");
        Actividad2.inorden(sinHojas);
        System.out.println();System.out.println();
        
        
        System.out.println("14. Árbol selección? " + (Actividad2.arbolSeleccion(inicial)?"Si": "No"));
        System.out.println();
        
        ArbolBinario<String> otroArbol;
        System.out.println ("Árbol binario de caracteres");
        System.out.print("Introduzca el recorrido en preorden:  ");
        preord = entrada.nextLine();
        System.out.print("Introduzca el recorrido en inorden:  ");
        inord = entrada.nextLine();
        otroArbol = Actividad2.reconstruir(preord, inord);
        
        System.out.println("15. Existe camino? " + (Actividad2.esCamino(otroArbol, "mqt")? "Si": "No"));
        System.out.println();
        
        System.out.println("16. Visualizar palabras ");
        Actividad2.visualizarPalabras(otroArbol);
        System.out.println();
        
        
        System.out.println("17. Padre de 3?: "); Integer pad = Actividad2.padre(inicial, 3);
        if (pad == null) System.out.println("Elemento incorrecto/no existe");
        else System.out.println("El padre es: " + pad); 
        
       
    }
}
