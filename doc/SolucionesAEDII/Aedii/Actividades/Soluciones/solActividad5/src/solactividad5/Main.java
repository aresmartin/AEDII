package solactividad5;

import arbolGeneral.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main (String [] args) 
     {    
        //Construccion de un árbol general, arbol4,  para probar los metodos:
        System.out.println ("Árboles generales");
        //construyo el árbol 1
        ArbolGeneral<Integer> arbol1 =new EnlazadoArbolGeneral<>(4, new EnlazadoArbolGeneral<>(2));
        ArbolGeneral<Integer> arbol2 =new EnlazadoArbolGeneral<>(3, new EnlazadoArbolGeneral<>(1));
        ArbolGeneral<Integer> arbol3 =new EnlazadoArbolGeneral<>(6, arbol1, arbol2, new EnlazadoArbolGeneral<>(5));
        ArbolGeneral<Integer> arbol4 =new EnlazadoArbolGeneral<>(7, arbol3);


        System.out.println("Recorrido en preorden del arbol4:");
        SolActividad5.preorden(arbol4);
        System.out.println();
        System.out.println("Recorrido en inorden del árbol4");
        SolActividad5.inorden(arbol4);
        System.out.println();

        //Ejercicio transparencias: contar numero de nodos
        System.out.println("1. El número de nodos es: "+ SolActividad5.contarNodos(arbol4));  
        
        //Ejercicio 1: suma los valores de los nodos
        System.out.println("1. La suma de los nodos es: "+ SolActividad5.sumaNodos(arbol4));   
        
        //Ejercicio 2: Miro si tienen la misma estructura
        System.out.println("2. IgualEstructura: "+ SolActividad5.igualEstructura(arbol1,arbol2));
        
         //Arbol nuevo       
        ArbolGeneral<Character> arbola =new EnlazadoArbolGeneral<>('a');
        ArbolGeneral<Character> arbolb =new EnlazadoArbolGeneral<>('b',arbola);
        ArbolGeneral<Character> arbolc =new EnlazadoArbolGeneral<>('c',arbolb);
        ArbolGeneral<Character> arbold =new EnlazadoArbolGeneral<>('d',arbolc);
        ArbolGeneral<Character> arbolv =new EnlazadoArbolGeneral<>('4', new EnlazadoArbolGeneral<>('2'));
        ArbolGeneral<Character> arbolw =new EnlazadoArbolGeneral<>('8', new EnlazadoArbolGeneral<>('1'));
        ArbolGeneral<Character> arbolx =new EnlazadoArbolGeneral<>('6', arbolv, arbolw, new EnlazadoArbolGeneral<>('5'));
        ArbolGeneral<Character> arbolz =new EnlazadoArbolGeneral<>('7', arbolx);

        //Ejercicio 3:
        System.out.println("3. ¿Es árbol 2-3 el arbol4: " + SolActividad5.arbolDosTres(arbol4));
        System.out.println("3. ¿Es árbol 2-3 el arbolz: " + SolActividad5.arbolDosTres(arbolz));
        System.out.println("3. ¿Es árbol 2-3 el arbold: " + SolActividad5.arbolDosTres(arbold));
        
        
         ArbolGeneral<Character> arboluno = new EnlazadoArbolGeneral<>('1',new EnlazadoArbolGeneral<>('1'),new EnlazadoArbolGeneral<>('3'), new EnlazadoArbolGeneral<>('4'));
        ArbolGeneral<Character> arboldos = new EnlazadoArbolGeneral<>('2', new EnlazadoArbolGeneral<>('2'), new EnlazadoArbolGeneral<>('7'));
        ArbolGeneral<Character> arbol5 = new EnlazadoArbolGeneral<>('1', arboluno, arboldos);

        //Ejercicio 4: esSelección
        System.out.println("4. Es arbol selección el arbol5: "+ SolActividad5.esSeleccion(arbol5));
        
        //Ejercicio 5: nivel de un elemento en un árbol
        System.out.println("5. El nivel del elemento 7 en el árbolz es: "+ SolActividad5.nivel(arbolz, '7'));
        System.out.println("5. El nivel del elemento 8 en el árbolz es: "+ SolActividad5.nivel(arbolz, '6'));
        System.out.println("5. El nivel del elemento 8 en el árbolz es: "+ SolActividad5.nivel(arbolz, '8'));
        System.out.println("5. El nivel del elemento 8 en el árbolz es: "+ SolActividad5.nivel(arbolz, '4'));
        System.out.println("5. El nivel del elemento 8 en el árbolz es: "+ SolActividad5.nivel(arbolz, '5'));
        System.out.println("5. El nivel del elemento 8 en el árbolz es: "+ SolActividad5.nivel(arbolz, '2'));
        System.out.println("5. El nivel del elemento 8 en el árbolz es: "+ SolActividad5.nivel(arbolz, '1'));
        System.out.println("5. El nivel del elemento 8 en el árbolz es: "+ SolActividad5.nivel(arbolz, '3'));
      
        
       //Ejercicio 6: Calculo el grado
        System.out.println("6. Grado del arbol4: "+ SolActividad5.grado(arbol4));
        
        
        //Ejercicio 7: calculo altura
        System.out.println("7. Altura del arbol4: "+ SolActividad5.grado(arbol4));
        
         //Ejercicio 8: anchura
        System.out.print("8. Anchura del arbol4: ");
        SolActividad5.anchura(arbol4);
        System.out.println("");
        
        
        //Ejercicio 9:
        System.out.println("9. ¿Es cuadArbol el arbol4: " + SolActividad5.cuadArbol(arbol4));
        System.out.println("9. ¿Es cuadArbol el arbolz: " + SolActividad5.cuadArbol(arbolz));
        System.out.println("9. ¿Es cuadArbol el arbold: " + SolActividad5.cuadArbol(arbold));
        
        
        //Ejercicio 10
        System.out.println("10. Numero nodos pares en arbol4: "+ SolActividad5.numNodosPares(arbol4));
        
        // Ejercicio 11: mete las hojas en una lista
        List<Integer> lista = new LinkedList<>();
        SolActividad5.hojas(arbol4, lista);
        System.out.println("11. Las hojas son: " );
        lista.forEach((i) -> {
            System.out.print(i + " ");
        });
        System.out.println();

        
        
        
        
        
        /*
       
        //Ejercicio 7: Miro si tienen la misma estructura
        System.out.println("7. IgualEstructura: "+ SolActividad5.igualEstructura(arbol1,arbol2));

        ArbolGeneral<Integer> arbolDoble = duplicar(arbol13);
        System.out.println("Recorrido en preorden del arbolDoble:");
        preorden(arbolDoble);
        System.out.println();
        System.out.println("Recorrido en inorden del árbolDoble");
        inorden(arbolDoble);
        System.out.println();
        
               
        ArbolGeneral<Integer> a1 =new EnlazadoArbolGeneral<>(1);
        ArbolGeneral<Integer> a2 =new EnlazadoArbolGeneral<>(2);
        ArbolGeneral<Integer> a3 =new EnlazadoArbolGeneral<>(3, a1, a2, new EnlazadoArbolGeneral<>(17));
        ArbolGeneral<Integer> a4 =new EnlazadoArbolGeneral<>(4);
        ArbolGeneral<Integer> a5 =new EnlazadoArbolGeneral<>(5);
        ArbolGeneral<Integer> a6 =new EnlazadoArbolGeneral<>(6, a5, a4);
        ArbolGeneral<Integer> a7 =new EnlazadoArbolGeneral<>(7, new EnlazadoArbolGeneral<>(14), new EnlazadoArbolGeneral<>(15));
        ArbolGeneral<Integer> a8 =new EnlazadoArbolGeneral<>(8);
        ArbolGeneral<Integer> a9 =new EnlazadoArbolGeneral<>(9);
        ArbolGeneral<Integer> a11 =new EnlazadoArbolGeneral<>(11);
        ArbolGeneral<Integer> a12 =new EnlazadoArbolGeneral<>(12);
        ArbolGeneral<Integer> a10 =new EnlazadoArbolGeneral<>(10, a9, a11, a12);
        ArbolGeneral<Integer> a13 =new EnlazadoArbolGeneral<>(13, a6, a7);
        
        //Ejercicio equilibrado
        System.out.println(". equilibrado: " + SolActividad5.equilibrado(a13));
        
        */
	      
     }  
}
