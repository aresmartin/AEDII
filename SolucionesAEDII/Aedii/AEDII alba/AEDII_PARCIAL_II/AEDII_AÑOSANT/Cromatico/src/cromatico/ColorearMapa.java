/*
 *Comentarios y observaciones: Modificar los mapas y grafos
    
 */
package cromatico;

import grafo.*;
import mapa.*;
import java.util.Iterator;

/**
 *
 * @author svsemeria_ESEI
 */
public class ColorearMapa {

    public static void main(String[] args) {
       
        String[] colores = new String[]{"amarillo", "rojo", "azul", "verde"};

        Grafo<String, Integer> grafo = new ListaAdyacencia<>();

        Vertice<String> vertice1 = new Vertice<>("v1");
        Vertice<String> vertice2 = new Vertice<>("v2");
        Vertice<String> vertice3 = new Vertice<>("v3");
        Vertice<String> vertice4 = new Vertice<>("v4");
        Vertice<String> vertice5 = new Vertice<>("v5");
        Vertice<String> vertice6 = new Vertice<>("v6");
        Vertice<String> vertice7 = new Vertice<>("v7");
        Vertice<String> vertice8 = new Vertice<>("v8");

        Arco<String, Integer> arco1 = new Arco<>(vertice1, vertice2, 30);
        Arco<String, Integer> arco2 = new Arco<>(vertice1, vertice3, 30);
        Arco<String, Integer> arco3 = new Arco<>(vertice1, vertice5, 30);

        Arco<String, Integer> arco4 = new Arco<>(vertice2, vertice1, 30);
        Arco<String, Integer> arco5 = new Arco<>(vertice2, vertice6, 30);
        Arco<String, Integer> arco6 = new Arco<>(vertice2, vertice4, 30);

        Arco<String, Integer> arco7 = new Arco<>(vertice3, vertice1, 30);
        Arco<String, Integer> arco8 = new Arco<>(vertice3, vertice4, 30);
        Arco<String, Integer> arco9 = new Arco<>(vertice3, vertice8, 30);

        Arco<String, Integer> arco10 = new Arco<>(vertice4, vertice2, 30);
        Arco<String, Integer> arco11 = new Arco<>(vertice4, vertice7, 30);
        Arco<String, Integer> arco12 = new Arco<>(vertice4, vertice3, 30);

        Arco<String, Integer> arco13 = new Arco<>(vertice5, vertice1, 30);
        Arco<String, Integer> arco14 = new Arco<>(vertice5, vertice6, 30);
        Arco<String, Integer> arco15 = new Arco<>(vertice5, vertice8, 30);

        Arco<String, Integer> arco16 = new Arco<>(vertice6, vertice2, 30);
        Arco<String, Integer> arco17 = new Arco<>(vertice6, vertice5, 30);
        Arco<String, Integer> arco18 = new Arco<>(vertice6, vertice7, 30);

        Arco<String, Integer> arco19 = new Arco<>(vertice7, vertice6, 30);
        Arco<String, Integer> arco20 = new Arco<>(vertice7, vertice4, 30);
        Arco<String, Integer> arco21 = new Arco<>(vertice7, vertice8, 30);

        Arco<String, Integer> arco22 = new Arco<>(vertice8, vertice3, 30);
        Arco<String, Integer> arco23 = new Arco<>(vertice8, vertice5, 30);
        Arco<String, Integer> arco24 = new Arco<>(vertice8, vertice7, 30);

        grafo.insertarVertice(vertice1);
        grafo.insertarVertice(vertice2);
        grafo.insertarVertice(vertice3);
        grafo.insertarVertice(vertice4);
        grafo.insertarVertice(vertice5);
        grafo.insertarVertice(vertice6);
        grafo.insertarVertice(vertice7);
        grafo.insertarVertice(vertice8);

        grafo.insertarArco(arco1);
        grafo.insertarArco(arco2);
        grafo.insertarArco(arco3);
        grafo.insertarArco(arco4);
        grafo.insertarArco(arco5);
        grafo.insertarArco(arco6);
        grafo.insertarArco(arco7);
        grafo.insertarArco(arco8);
        grafo.insertarArco(arco9);
        grafo.insertarArco(arco10);
        grafo.insertarArco(arco11);
        grafo.insertarArco(arco12);
        grafo.insertarArco(arco13);
        grafo.insertarArco(arco14);
        grafo.insertarArco(arco15);
        grafo.insertarArco(arco16);
        grafo.insertarArco(arco17);
        grafo.insertarArco(arco18);
        grafo.insertarArco(arco19);
        grafo.insertarArco(arco20);
        grafo.insertarArco(arco21);
        grafo.insertarArco(arco22);
        grafo.insertarArco(arco23);
        grafo.insertarArco(arco24);
        
         Map<Vertice<String>, String> mapaColores = colorearMapa(grafo, colores);

        Iterator<Vertice<String>> itrMapa = mapaColores.getClaves();
        
        
        while(itrMapa.hasNext()){
            Vertice<String> aux = itrMapa.next();
            
            System.out.println(aux + " | " + mapaColores.get(aux));
        }

    }

    public static <E, T> Map<Vertice<E>, String> colorearMapa(Grafo<E, T> grafo, String[] colores) {
        //Este mapa debe ser el del ejercicio 1, cambiar luego
        Map<Vertice<E>, String> mapa = new HashMap<>();

        //Iterador para recorrer todos los vertices del grafo
        Iterator<Vertice<E>> itr = grafo.vertices();

        //Insertar en el mapa los vertices vacios
        while (itr.hasNext()) {
            mapa.insertar(itr.next(), "");
        }

        //Reiniciar el iterador
        itr = grafo.vertices();

        //Recorrer los vertices del mapa de nuevo y para cada vertice que este, actualizar el color
        while (itr.hasNext()) {
            Vertice<E> ver = itr.next();
            String color = colorCorrecto(ver, grafo, colores, mapa); //Método privado y complementario para elegir el color correcto
            mapa.insertar(ver, color);
        }

        return mapa;
    }

    //Comprobar el color que se va a poner
    private static <E, T> String colorCorrecto(Vertice<E> ver, Grafo<E, T> grafo, String[] colores, Map<Vertice<E>, String> mapa) {

        //Creo un iterador para recorrer los vertices del grafo
        Iterator<Vertice<E>> itr = grafo.adyacentes(ver);

        //Creo un auxiliar para recorrer el array de colores
        int aux = 0;

        String color = colores[aux]; //Guardo en una variable String el primer color

        //Recorro con el bucle 
        while (itr.hasNext()) {
            if (color.equals(mapa.get(itr.next()))) { //Si el color ya lo tengo, me muevo en el vector de colores a buscar uno que pueda usar
                aux++;
                color = colores[aux]; //Actualizo, paso al siguiente color en la lista
                itr = grafo.adyacentes(ver); //Pongo un iterador para los adyacentes y luego se haran las comparaciones con dichos vertices adyacentes
            }
        }
        return color;
    }
}
