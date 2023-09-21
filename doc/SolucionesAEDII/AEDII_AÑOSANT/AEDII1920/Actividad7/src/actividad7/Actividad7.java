/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad7;

import grafo.*;
import lista.*;
import java.util.Iterator;
import mapa.*;

/**
 *
 * @author Samuel Velasquez
 */
public class Actividad7 {

    public static void main(String[] args) {

        Grafo<String, Integer> grafo = new ListaAdyacencia<>();
        Vertice<String> vertice1 = new Vertice<>("v1");
        Vertice<String> vertice2 = new Vertice<>("v2");
        Vertice<String> vertice3 = new Vertice<>("v3");
        Vertice<String> vertice4 = new Vertice<>("v4");
        //Vertice<String> vertice5 = new Vertice<>("v5");
        //Vertice<String> vertice6 = new Vertice<>("v6");

        Arco<String, Integer> arco1 = new Arco<>(vertice1, vertice2, 30);
        //Arco<String, Integer> arco2 = new Arco<>(vertice1, vertice3, 30);
        Arco<String, Integer> arco3 = new Arco<>(vertice1, vertice4, 30);
        Arco<String, Integer> arco4 = new Arco<>(vertice2, vertice4, 30);
        //Arco<String, Integer> arco5 = new Arco<>(vertice3, vertice1, 30);
        //Arco<String, Integer> arco6 = new Arco<>(vertice3, vertice2, 30);
        Arco<String, Integer> arco7 = new Arco<>(vertice4, vertice3, 30);
        //Arco<String, Integer> arco8 = new Arco<>(vertice4, vertice2, 30);

        grafo.insertarVertice(vertice1);
        grafo.insertarVertice(vertice2);
        grafo.insertarVertice(vertice3);
        grafo.insertarVertice(vertice4);
        //grafo.insertarVertice(vertice5);

        grafo.insertarArco(arco1);
        //grafo.insertarArco(arco2);
        grafo.insertarArco(arco3);
        grafo.insertarArco(arco4);
        //grafo.insertarArco(arco5);
        //grafo.insertarArco(arco6);
        grafo.insertarArco(arco7);
        //grafo.insertarArco(arco8);

        boolean ciclo = hayCiclo(grafo, vertice2);
        
        if(ciclo){
            System.out.println("Hay ciclo");
        }else{
            System.out.println("No hay ciclo");
        }
    }

    //Ejercicio 1, Esta Correcto :)
    public static <E, T> Iterator<Vertice<E>> predecesores(Grafo<E, T> grafo, Vertice<E> vertice) {
        //Lista donde guardaré los predecesores y luego lanzaré un iterador sobre ella
        Lista<Vertice<E>> lista = new ListaEnlazada<>();

        //Iterador para recorrer los vertices del grafo
        Iterator<Vertice<E>> itr = grafo.vertices();

        while (itr.hasNext()) {
            Vertice<E> aux = itr.next();//Guardo en una variable llamada (vertice) origen el itr.next() 
            Iterator<Vertice<E>> itr2 = grafo.adyacentes(aux); //Lanzo un iterador a los adyacentes de origen
            while (itr2.hasNext()) {
                /*Si uno de los adyacentes de origen es el vertice que le pasamos, 
                insertamos en la lista dicho origen que vendría siendo el predecesor*/
                if (itr2.next().equals(vertice)) {
                    lista.insertarFinal(aux);
                }
            }
        }
        return lista.iterator(); //retornamos un iterador sobre la lista de predecesores 
    }

    //Ejercicio 2, Esta Correcto :)
    public static <E, T> boolean esSumidero(Grafo<E, T> grafo, Vertice<E> vertice) {
        if (numPredecesores(grafo, vertice) == (numVertices(grafo) - 1) && numVerticesAdyacentes(grafo, vertice) == 0) {
            return true;
        }
        return false;
    }

    //Este método es útil (Funciona como grado de entrada)
    public static <E, T> int numPredecesores(Grafo<E, T> grafo, Vertice<E> vertice) {
        //Contador para ir viendo los predecesores
        int cont = 0;

        //Iterador para recorrer los vertices del grafo
        Iterator<Vertice<E>> itr = grafo.vertices();

        while (itr.hasNext()) {
            Vertice<E> aux = itr.next();//Guardo en una variable llamada (vertice) origen el itr.next() 
            Iterator<Vertice<E>> itr2 = grafo.adyacentes(aux); //Lanzo un iterador a los adyacentes de origen
            while (itr2.hasNext()) {
                /*Si uno de los adyacentes de origen es el vertice que le pasamos, 
                aumentamos el numero de predecesores*/
                if (itr2.next().equals(vertice)) {
                    cont++;
                }
            }
        }
        return cont; //retornamos el contador con los predecesores de dicho vertice
    }

    //Otro método útil, cuenta el numero de vertices del grafo
    public static <E, T> int numVertices(Grafo<E, T> grafo) {
        //Contador para saber el numero de vertices 
        int cont = 0;

        //Iterador para recorrer los vertices del grafo
        Iterator<Vertice<E>> itr = grafo.vertices();

        while (itr.hasNext()) {
            itr.next(); //RECORDAR: Hay que movernos
            cont++;
        }
        return cont; //retornamos el contador que me dice el numero de vertices de un grafo 
    }

    //Método útil tambien (Funciona como grado de salida)
    public static <E, T> int numVerticesAdyacentes(Grafo<E, T> grafo, Vertice<E> vertice) {
        //Contador para saber el numero de vertices 
        int cont = 0;

        //Iterador para recorrer los vertices adyacentes a uno dado
        Iterator<Vertice<E>> itr = grafo.adyacentes(vertice);

        while (itr.hasNext()) {
            itr.next(); //RECORDAR: Hay que movernos
            cont++;
        }
        return cont; //retornamos un contador que me dice el numero de adyacentes a un vertice 
    }

    //Ejercicio 3, mirar con cuidado
    public static <E, T> boolean esRegular(Grafo<E, T> grafo) {
        if (grafo.esVacio()) {
            return true;
        } else {
            //Lanzamos un iterador sobre los vertices del grafo
            Iterator<Vertice<E>> itr = grafo.vertices();

            //Cogemos el primero de los vertices apuntados por el iterador
            Vertice<E> vertAux = itr.next();

            //Lanzamos un iterador sobre los adyacentes a ese vertice
            Iterator<Vertice<E>> itAdy = grafo.adyacentes(vertAux);

            //Establecemos un contador para contar los adyacentes al primer vertice que tomamos como referencia
            int numAdy = 0;

            //Contaje de adyacentes
            while (itAdy.hasNext()) {
                itAdy.next();//RECORDAR: hay que moverse
                numAdy++;
            }

            //Establecemos un contador para contar los adyacentes al segundo vertice que tomamos como referencia
            int numAdy2 = 0;

            while (itr.hasNext()) {
                itr.next();//Nos movemos y cogemos el siguiente vertice apuntado por el iterador

                //Lanzamos un iterador sobre los adyacentes a ese vertice
                Iterator<Vertice<E>> itAdy2 = grafo.adyacentes(vertAux);

                //Contamos
                while (itAdy2.hasNext()) {
                    itAdy2.next();
                    numAdy2++;
                }

                //Basta con que dos sean distintos, para que sea 'false'. Por eso solo cogemos dos
                if (numAdy != numAdy2) {
                    return false;
                }

            }
        }
        return true;
    }

    //Ejercicio 4
    public static <E, T> boolean dirigido(Grafo<E, T> grafo, Vertice<E> origen, Vertice<E> destino) {
        //Creamos una lista vacia donde se meteran los vertices ya visitados
        Lista<Vertice<E>> visitados = new ListaEnlazada<>();

        //Llamamos al método recursivo de abajo
        return esCamino(grafo, origen, destino, visitados);
    }

    //Método recursivo necesario
    private static <E, T> boolean esCamino(Grafo<E, T> grafo, Vertice<E> origen, Vertice<E> destino, Lista<Vertice<E>> visitados) {
        //Insertamos en la lista de visitados el vertice en el que estamos porque ya lo hemos visitado
        visitados.insertarFinal(origen);

        //Creamos una bandera
        boolean encontrado = false;

        //Si al vertice al que quiero llegar es igual al vertice donde estoy retorno 'true'
        if (destino.equals(origen)) {
            encontrado = true;
        } else { //En caso contrario

            //Lanzo un iterador sobre los vertices adyacentes al origen(vertice donde me encuentro ahora)
            Iterator<Vertice<E>> ady = grafo.adyacentes(origen);

            //Recorro mientras haya adyacentes y no haya sido "encontrado"
            while (ady.hasNext() && !encontrado) {

                //Guardo en un auxiliar el valor del adyacente apuntado por el iterador
                Vertice<E> aux = ady.next();

                //Si visitados no contiene dicho vertice, llamo a la recursividad en la variable "encontrado"
                if (!visitados.contiene(aux)) {
                    encontrado = esCamino(grafo, aux, destino, visitados);
                }
            }
        }
        return encontrado;
    }

    //Ejercicio 5
    public static <E, T> Vertice<E> esArborescencia(Grafo<E, T> grafo) {
        //Lanza un iterador sobre los vertices del grafo
        Iterator<Vertice<E>> vertices = grafo.vertices();

        //Recorremos 
        while (vertices.hasNext()) {
            Lista<Vertice<E>> visitados = new ListaEnlazada<>();
            Vertice<E> v = vertices.next();
            profundidad2(grafo, v, visitados);
            if (tamano(visitados.iterator()) == tamano(grafo.vertices())) {
                return v;
            }
        }
        return null;
    }

    //Método necesario, cuenta cuantos vertices recorre un iterador
    public static <E, T> int tamano(Iterator<Vertice<E>> itr) {
        int cont = 0;

        while (itr.hasNext()) {
            itr.next(); //RECORDAR: Hay que moverse con itr.next()
            cont++;
        }

        return cont;
    }

    //Método necesario
    public static <E, T> void profundidad(Grafo<E, T> grafo, Vertice<E> vertice) {
        //Creamos una lista vacia donde se meteran los vertices ya visitados
        Lista<Vertice<E>> visitados = new ListaEnlazada<Vertice<E>>();

        //Llamamos al metodo de abajo
        profundidad2(grafo, vertice, visitados);
    }

    //Método necesario (esta en las diapos)
    private static <E, T> void profundidad2(Grafo<E, T> grafo, Vertice<E> vertice, Lista<Vertice<E>> visitados) {
        //Metemos en la lista de visitados el vertice pasado como parámetro
        visitados.insertarFinal(vertice);

        //Lanzamos un iterador sobre los adyacentes del vertice que pasamos como parametro
        Iterator<Vertice<E>> adys = grafo.adyacentes(vertice);

        //Recorremos mientras haya adyacentes
        while (adys.hasNext()) {

            //Metemos en un auxiliar el valor que hay en el adyacente apuntado
            Vertice<E> aux = adys.next();

            //Mientras ese vertice adyacente auxiliar no lo hayamos visitado(O no este en la lista de visitados)
            if (!visitados.contiene(aux)) {
                profundidad2(grafo, aux, visitados); //Llamamos al método recursivo para así inicializarlo y meterlo en visitados mínimo
            }
        }
    }

    /*--------------Ejercicios no propuestos--------------*/
 /*¿Que es lo que hace?: Te devuelve un iterador sobre aquellos vertices a los que no se puede llegar por ningun camino.
    Para explicar esto mejor, digamos que tenemos un vertice (el cual pasamos como parametro) y que este no tiene ningun camino,
    ni siquiera a través de sus adyacentes, de llegar a un vertice cualquiera; pues ese vertice o vertices a los que no se puede llegar
    son vistos a través del iterador cuando se invoca al método
     */
    public static <E, T> Iterator<Vertice<E>> noAlcanzables(Grafo<E, T> grafo, Vertice<E> vertice) {
        //Creamos una lista vacia donde vamos a meter los vertices que hemos visitado
        Lista<Vertice<E>> visitados = new ListaEnlazada<>();

        //Lanzamos un iterador sobre los vertices del grafo
        Iterator<Vertice<E>> itVer = grafo.vertices();

        //Recorremos mientras haya vertices en el grafo
        while (itVer.hasNext()) {
            visitados.insertarFinal(itVer.next()); //Metemos TODOS los vertices del grafo en la lista
        }

        return noAlcanzables2(grafo, vertice, visitados);//Llamamos al método de abajo el cual nos va a devolver el iterador que necesitamos
    }

    private static <E, T> Iterator<Vertice<E>> noAlcanzables2(Grafo<E, T> grafo, Vertice<E> vertice, Lista<Vertice<E>> visitados) {
        //La lista de "visitados" tiene TODOS los vertices del grafo, de los cuales vamos a eliminar el que le pasamos como parametro
        visitados.suprimir(vertice);

        //Lanzamos un iterador sobre los adyacentes al vertice que pasamos como parametro
        Iterator<Vertice<E>> itAdy = grafo.adyacentes(vertice);

        //Recorremos, mientras haya adyacentes
        while (itAdy.hasNext()) {

            //Guardamos en un auxiliar el valor del adyacente donde nos encontramos
            Vertice<E> ady = itAdy.next();

            //Preguntamos, si la lista contiene al adyacente donde vamos
            if (visitados.contiene(ady)) {

                /*Si es así, llamamos al método recursivo. 
                Si no, nos seguimos moviendo con el iterador de los adyacentes y preguntamos*/
                return noAlcanzables2(grafo, ady, visitados);
            }
        }
        /*Retorna un iterador sobre la lista, la cual va a contener unicamente los vertices 
        que no son alcanzables por el que le pasamos como parametro*/
        return visitados.iterator();
    }

    //Determinar si hay un ciclo que tenga como origen el vértice v
    public static <E, T> boolean hayCiclo(Grafo<E, T> grafo, Vertice<E> vOrigen) {
        //Creamos una lista vacia donde vamos a meter los vertices que hemos visitado
        Lista<Vertice<E>> visitados = new ListaEnlazada<Vertice<E>>();

        //Llamamos al método recursivo de abajo
        return hayCiclo2(grafo, vOrigen, vOrigen, visitados);
    }

    private static <E, T> boolean hayCiclo2(Grafo<E, T> grafo, Vertice<E> vOrigen, Vertice<E> vertice, Lista<Vertice<E>> visitados) {
        //Declaramos una bandera
        boolean encontrado = false;

        //Insertamos al final de la lista el vertice que ya visitamos(en la primera vuelta, será el mismo que origen)
        visitados.insertarFinal(vertice);

        //Lanzamos un iterador sobre los adyacentes a ese vertice
        Iterator<Vertice<E>> adys = grafo.adyacentes(vertice);

        //Recorremos mientras haya adyacentes y no haya sido encontrado
        while (adys.hasNext() && !encontrado) {

            //Guardamos en un auxiliar el valor del adyacente en el que vamos
            Vertice<E> aux = adys.next();

            //Si el adyacente en el que vamos es igual a origen, devuelve true (hay ciclo) y salimos
            if (vOrigen.equals(aux)) {
                encontrado = true;
            } else if (!visitados.contiene(aux)) {
                //En caso de que no sean iguales, preguntamos si la lista de visitados lo tiene, si no lo tiene, llamamos al método recursivo.
                //Si la lista lo tiene, pasamos al siguiente adyacente y hacemos las mismas comprobaciones
                encontrado = hayCiclo2(grafo, vOrigen, aux, visitados);
            }
        }

        return encontrado;
    }

}
