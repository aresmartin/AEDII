/*
 *Observaciones:

    1. Patron repetitivo 1: Me doy cuenta de que en los métodos donde se usan estra-
    tegias voraces, la lista solución se crea dentro del método como una lista vacia,
    mientras que en los métodos que usan vuelta atrás dichas lista se pasan como
    parametro

    2. En la mayoria de las estrategias voraces se usa un método que busca el mayor o menor
    de un determinado conjunto (depende de lo que pidan). Sería bueno aprenderse los esquemas
    de estos métodos porque pueden ser utiles a la hora de optimizar código en los examenes.

    3. Las estrategias de vuelta atras (al menos la de estos ejercicios) usan mucha
    recursividad, sería bueno considerarla también. La recursividad se usa a la hora de revisar
    los demás elementos del conjunto de candidatos.

    4. Patron repetitivo 2: Las estrategías ya sean voraces o vuelta atrás siempre se van a 
    atacar de la misma forma, siguiendo los determinados esquemas claro. La cosa es, sudo de 
    comentar algunos ejercicios porque son muy parecidos entre ellos. Lo que hay que tener en 
    cuenta es que para la mayoria de los esquemas voraces se usa un método aparte y para las 
    estrategias de vuelta atrás se usa mucho la recursividad

    5. Patron repetitivo 3: Si nos damos cuenta, en los métodos que usan vuelta atrás siempre
    se usa una variable de tipo boolean 'objetivo'; también por lo general los métodos que
    usan esta estrategia son de retorno tipo boolean
 */
package actividad8;

import lista.*;
import java.util.Iterator;
import grafo.*;
import java.util.HashSet;
import java.util.Set;
import mapa.*;

/**
 *
 * @author Samuel Velasquez
 */
public class Prueba {

    public static void main(String[] args) {

        Map<Integer, Integer> mapaCantidades = new HashMap<>();

        mapaCantidades.insertar(100, 5);
        mapaCantidades.insertar(50, 5);
        mapaCantidades.insertar(20, 5);
        mapaCantidades.insertar(10, 5);
        mapaCantidades.insertar(5, 5);
        mapaCantidades.insertar(1, 5);

        Map<Integer, Integer> solucion = darCambio(289, mapaCantidades);

        Iterator<Integer> itr = solucion.getClaves();

        while (itr.hasNext()) {
            Integer aux = itr.next();
            System.out.println(aux + " | " + solucion.get(aux));
        }
//        char[][] laberinto = {{' ', ' ', 'X', ' '},
//        {' ', 'X', ' ', ' '}, {' ', ' ', ' ', ' '}, {' ', ' ', 'X', ' '}};
//
//        boolean bandera = ensayar(laberinto, 1, 1);
//
//        System.out.println(bandera);
    }

    /*
    Ejercicio 1 con estrategía voraz, ya esta comentado y listo
     */
    public static Map<Integer, Integer> darCambio(int importeDevolver, Map<Integer, Integer> mapaCantidades) {
        //Creamos el mapa donde meteremos los candidatos que sean parte de la solución
        Map<Integer, Integer> solucion = new HashMap<>();

        int importeDevuelto = 0;//Variable de control en la que vamos llevando la suma de lo que vamos devolviendo
        boolean devolverMas = true;

        //Mientras que el importe devuelto sea menor que el importe a devolver y pueda devolverMas
        while (importeDevuelto < importeDevolver && devolverMas) {

            //Seleccionamos el billete mayor
            Integer billeteSeleccionado = mayor(importeDevolver - importeDevuelto, mapaCantidades);

            //Si el billete seleccionado es distinto de cero
            if (billeteSeleccionado != 0) {

                //Determino la cantidad que necesito de el billete mayor
                int cantBil = (importeDevolver - importeDevuelto) / billeteSeleccionado;

                //Guardo en una variable la cantidad total que hay en el mapa del billete mayor
                int tot = mapaCantidades.get(billeteSeleccionado);

                //Si la cantidad de billetes que necesito es más grande que los billetes que tengo, los uso todos
                if (cantBil > tot) {
                    cantBil = tot;
                }

                //Meto en el mapa el billete seleccionado y la cantidad de dichos billetes
                solucion.insertar(billeteSeleccionado, cantBil);

                //Actualizo el importe devuelto
                importeDevuelto += billeteSeleccionado * cantBil;

                //Si me quedo sin billetes (del que estoy usando) en el mapa de cantidades, 
                //elimino ese billete, indicando que ya no me quedan para usar
                if (tot - cantBil == 0) {
                    mapaCantidades.eliminar(billeteSeleccionado);
                } else {//En caso contrio, actualizo la cantidad de billetes (el que estoy usando) que me quedan
                    mapaCantidades.insertar(billeteSeleccionado, tot - cantBil);
                }

            } else {//Llega a este else cuando ya no puedo devolver más billetes
                devolverMas = false;
            }
        }

        //En caso de salir del while, comprobamos
        //Si no se pueden devolver, retorno el mapa vacio
        if (devolverMas == false) {
            return new HashMap<>();
        } else {//En caso de que si se pueda devolver algo, retorno el mapa de soluciones
            return solucion;
        }
    }

    /*
    Método necesario: Lo que hace es seleccionar el billete más grande del mapa de billetes para usarlo primero
     */
    private static Integer mayor(int importeQueda, Map<Integer, Integer> mapaCantidades) {
        //Creamos una variable donde guardaremos el billete más grande
        Integer billeteMayor = 0;

        //Lanzamos un iterador sobre las claves del mapa(los billetes)
        Iterator<Integer> itrbilletes = mapaCantidades.getClaves();

        //Recorremos
        while (itrbilletes.hasNext()) {
            //Guardamos en un aux el billete apuntado por el iterador
            Integer billete = itrbilletes.next();

            /*Si el billete apuntado por el iterador es mayor que el 
            billeteMayor (siempre lo va a ser porque billeteMayor = 0), y dicho 
            billete es menor o igual que el importe que quiero devolver, lo 
            asigno como nuevo mayor*/
            if (billete > billeteMayor && billete <= importeQueda) {
                billeteMayor = billete;
            }
        }

        return billeteMayor;//Devuelvo el billete mayor

    }

    /*
    Ejercicio 2 con estrategia de vuelta atrás, ya esta comentado y listo
     */
    public static boolean darCambio(int importeDevolver, Map<Integer, Integer> mapaCantidades, Map<Integer, Integer> mapaSolucion) {
        boolean objetivo = false;

        //Lanzamos un iterador sobre las claves del mapa (los billetes)
        Iterator<Integer> itrbilletes = mapaCantidades.getClaves();

        // Mientras haya billetes y no se haya alcanzado el objetivo
        while (itrbilletes.hasNext() && !objetivo) {

            //Guardo en un aux el elemento apuntado por el iterador
            int moneda = itrbilletes.next();

            //Si tengo billetes y  el importe a devolver es mayor o igual que los billetes
            if (mapaCantidades.get(moneda) > 0 && importeDevolver >= moneda) {

                //Actualizo la cantidad de billetes que me quedan en el mapa de cantidades
                mapaCantidades.insertar(moneda, mapaCantidades.get(moneda) - 1);

                //Si la moneda es igual al importe a devolver
                if (moneda == importeDevolver) {

                    //Agrego al mapa de soluciones la moneda en cuestion
                    mapaSolucion.insertar(moneda, mapaSolucion.get(moneda) + 1);

                    //Pongo que ya he alcanzado el objetivo
                    objetivo = true;

                } else {//En caso contrario

                    //Llamo a la recursividad
                    objetivo = darCambio(importeDevolver - moneda, mapaCantidades, mapaSolucion);

                    //Después de salir de la recursividad sigue esta linea
                    //Si llegamos al objetivo
                    if (objetivo) {
                        //Agregamos al mapa de soluciones la moneda en cuestion
                        mapaSolucion.insertar(moneda, mapaSolucion.get(moneda) + 1);
                    } else {//En caso contrario

                        /*No hemos alcanzado el objetivo, volvemos atras.
                        Añadimos nuevamente el billete que habiamos usado al mapa de cantidades
                        y volvemos arriba*/
                        mapaCantidades.insertar(moneda, mapaCantidades.get(moneda) + 1);
                    }

                }
            }
        }
        return objetivo;
    }

    //Ejercicio 3, ya esta comentado y listo
    //Me devuelve una lista en este caso es más cómodo
    //Observación y pregunta: ¿Descarta aquellos que no se pueden insertar? SI
    public static Lista<String> llenarCDVoraz(int capacidadMaxima, Map<String, Integer> espacioProgramas) {
        //Declaramos la lista solución donde meteremos los programas
        Lista<String> CD = new ListaEnlazada<String>();

        //Declaramos una variable de control que nos ayudará a no sobrepasarnos de la capacidadMax
        int espacioOcupado = 0;

        //Declaramos una variable que se interpretara como: ¿Se puede llenar más?
        boolean llenarMas = true;

        //Varible que usaremos para guardar la capacidad del programa que hemos elegido
        int k = 0;

        // Mientras no se haya cumplido el objetivo con los objetos disponibles
        while (espacioOcupado < capacidadMaxima && llenarMas) {
            //Buscar el programa que sea mayor y que “quepa” en la lista
            String prog = mayor(capacidadMaxima - espacioOcupado, espacioProgramas, CD);

            //Si dicho programa existe, es decir, si hemos escogido un programa porque el mapa no estaba vacio
            if (prog != null) {
                //Guardamos la capacidad del programa elegido
                k = espacioProgramas.get(prog);

                //Eliminamos el programa del mapa, porque ya lo hemos usado
                espacioProgramas.eliminar(prog);

                //Insertamos el programa en la lista de soluciones
                CD.insertarPrincipio(prog);

                //Actualizamos el espacio ocupado, que será el espacio ocupado de antes más
                //el ocupado por el programa que acabamos de insertar
                espacioOcupado += k;

            } else {//En caso contrario
                llenarMas = false; //No se puede llenar más, devolvemos el CD vacio
            }
        }

        return CD;
    }

    /*Este método sirve para determinar cual es el programa que mayor espacio ocupa*/
    private static String mayor(int parcial, Map<String, Integer> programas, Lista<String> solucion) {
        //Variable donde guardaremos el nombre del programa más grande
        String maxProg = null;

        //Variable donde guardaremos el espacio del programa más grande
        int maxEsp = 0;

        //Lanzamos un iterador sobre los programas del mapa de programas
        Iterator<String> itrprogramas = programas.getClaves();

        //Mientras el mapa tenga programas
        while (itrprogramas.hasNext()) {
            //Guardo en una variable el programa apuntado por el iterador
            String prog = itrprogramas.next();

            //Guardo en una variable el espacio que ocupa el programa apuntado por el iterador
            int espacio = programas.get(prog);

            //Si la lista de soluciones no lo contiene, el espacio ocupado por el programa mas grande que maxEsp
            //y además el espacio es menor o igual al parcial(que vendría siendo el espacio que te queda)
            if (!solucion.contiene(prog) && espacio > maxEsp && espacio <= parcial) {

                //Hacemos las asignaciones
                maxEsp = espacio;
                maxProg = prog;
            }
        }

        return maxProg;//Devolvemos el nombre del programa que mayor espacio ocupa
    }

    //Ejercicio 4 con estrategia de vuelta atras, ya esta comentado y listo
    public static boolean llenarCDVueltaAtras(int capacidadMaxima, Map<String, Integer> espacioProgramas, Lista<String> CD) {
        //Declaramos una variable de objetivo, se leera: ¿Se ha llegado al objetivo?
        boolean objetivo = false;

        //Lanzamos un iterador sobre las claves (programas) del mapa de programas
        Iterator<String> itr = espacioProgramas.getClaves();

        //Mientras haya programas en el mapa y no se haya alcanzado el objetivo
        while (itr.hasNext() && !objetivo) {

            //Guardamos en una variable el programa apuntado por el iterador
            String actual = itr.next();

            //Guardamos en una variable la capacidad del programa apuntado por el iterador
            int capacProgram = espacioProgramas.get(actual);

            //Si la capacidad del programa es mayor a 0 y esta capacidad no supera la
            //capacidadMaxima
            if (capacProgram > 0 && capacidadMaxima >= capacProgram) {

                //Eliminamos del mapa el programa apuntado por el iterador
                espacioProgramas.eliminar(actual);

                //Si la capacidad del programa actual es igual a la capacidadMaxima
                if (capacProgram == capacidadMaxima) {
                    //Lo insertamos en la lista solución
                    CD.insertarFinal(actual);

                    //Y decimos que hemos alcanzado el objetivo
                    objetivo = true;

                } else {//En caso contrario

                    //Llamamos a la recursividad, con la capacidadMaxima ahora reducida y
                    //con el mapa de programas actualizado (recordar que eliminamos uno)
                    objetivo = llenarCDVueltaAtras(capacidadMaxima - capacProgram, espacioProgramas, CD);

                    //Si al salir de la recursividad se ha alcanzado el objetivo
                    if (objetivo) {
                        //Insertamos en la lista solución el programa correspondiente
                        CD.insertarFinal(actual);
                    } else {//En caso contrario

                        //Volvemos atras restaurando el programa que habiamos borrado del mapa
                        espacioProgramas.insertar(actual, capacProgram);
                    }
                }
            }
        }
        return objetivo;
    }

    //Ejercicio 5 con estrategia voraz, ya esta listo y comentado
    public static <E> Grafo<E, Integer> viajante(Grafo<E, Integer> grafo, Vertice<E> vertice) {
        //Guardamos en una variable el vertice en el que vamos
        Vertice<E> nodoActual = vertice;

        //Creamos la lista de vertices que nos faltan por visitar, así sabremos después
        //por los que hemos pasado ya
        Lista<Vertice<E>> porVisitar = new ListaEnlazada<>();

        //Creamos el grafo solución que regresaremos 
        Grafo<E, Integer> solucion = new ListaAdyacencia<>();

        //Lanzamos un iterador sobre los vertices del grafo
        Iterator<Vertice<E>> itrVer = grafo.vertices();

        //Con este bucle metemos en la lista porVisitar TODOS los vertices del grafo
        while (itrVer.hasNext()) {
            Vertice<E> vert = itrVer.next();
            porVisitar.insertarPrincipio(vert);
        }

        //Borramos de la lista el vertice en el que vamos (ya ha sido visitado)
        porVisitar.suprimir(nodoActual);

        //Declaramos una variable que se leerá: ¿Podemos continuar?
        boolean continuar = true;

        //Mientras porVisitar no sea vacia y se pueda continuar
        while (!porVisitar.esVacio() && continuar) {
            //Guardamos en una variable el arco minimo (el camino más corto)            
            Arco<E, Integer> u = minimo(grafo.arcos(), nodoActual, porVisitar);

            //Si el arco minimo no es vacio
            if (u != null) {
                //Borro de la lista porVisitar el vertice destino del arco
                //minimo(porque se que ese ya lo voy a visitar)
                porVisitar.suprimir(u.getDestino());

                //Inserto el arco minimo en el grafo solución
                solucion.insertarArco(u);

                //Actualizo el nodo actual con el vertice destino del arco minimo
                nodoActual = u.getDestino();

            } else {//En caso contrario

                //No se puede continuar (ya no hay más arcos)
                continuar = false;
            }
        }
        return solucion; //Retorno el grafo solución
    }

    /*Este método te dice cual es el arco que "menos mide" para que el viajante lo tome*/
    private static <E> Arco<E, Integer> minimo(Iterator<Arco<E, Integer>> arco, Vertice<E> vertice, Lista<Vertice<E>> porVisitar) {
        //Variable que indica la distancia minima hacia un vertice
        int dist_v_min = 0;

        //Declaramos una variable minimo (con el valor máximo posible) para que a la
        //hora de las comparaciones se hagan los cambios que queremos        
        int min = Integer.MAX_VALUE;

        //Declaramos un arco minimo el cual vamos a devolver luego de las operaciones
        Arco<E, Integer> arco_min = null;

        //Mientras el grafo tenga arcos (el iterador este lo pasamos como parametro)
        while (arco.hasNext()) {
            //Guardamos en una variable el arco apuntado por el iterador            
            Arco<E, Integer> a1 = arco.next();

            //Declaramos un vertice destino
            Vertice<E> w = a1.getDestino();

            //Si el origen del arco apuntado por el iterador es igual al vertice pasado
            //y el vertice destino esta en la lista por visitar
            if (a1.getOrigen().equals(vertice) && porVisitar.contiene(w)) {
                //Le asigno a distancia vertice minimo la etiqueta del arco
                dist_v_min = a1.getEtiqueta();

                //Si la distancia vertice minimo es menor que min (que lo va a ser)
                if (dist_v_min < min) {
                    //Hago el cambio

                    //Pongo el arco actual como el minimo
                    arco_min = a1;

                    //Y le asigno a min la distancia vertice minimo
                    min = dist_v_min;
                }
            }
        }
        return arco_min;

    }

    //Ejercicio 6 con estrategia voraz, ya esta listo y comentado
    public static <E> Grafo<E, Integer> prim(Grafo<E, Integer> grafo, Vertice<E> vertice) {
        //Creamos una lista donde meteremos los vertices por visitar
        Lista<Vertice<E>> porVisitar = new ListaEnlazada<>();

        //Creamos una lista donde meteremos los vertices ya visitados
        Lista<Vertice<E>> visitados = new ListaEnlazada<>();

        //Creamos el grafo solución que devolveremos
        Grafo<E, Integer> solucion = new ListaAdyacencia<>();

        //Lanzamos un iterador sobre los vertices del grafo
        Iterator<Vertice<E>> itrVertices = grafo.vertices();

        //Llenamos la lista porVisitar con TODOS los vertices del grafo
        while (itrVertices.hasNext()) {
            Vertice<E> vert = itrVertices.next();
            porVisitar.insertarPrincipio(vert);
        }

        //Borramos de la lista porVisitar el vertice en el que vamos
        porVisitar.suprimir(vertice);

        //Lo añadimos a la lista de visitados
        visitados.insertarPrincipio(vertice);

        //Mientras haya vertices por visitar
        while (!porVisitar.esVacio()) {
            //Buscamos el arco minimo
            Arco<E, Integer> u = minimo(grafo.arcos(), porVisitar, visitados);

            //Guardamos el vertice destino perteneciente al arco minimo
            Vertice<E> destino = u.getDestino();

            //Borramos de porVisitar el destino (por que ya lo vamos a visitar)
            porVisitar.suprimir(destino);

            //Lo insertamos en visitados
            visitados.insertarPrincipio(destino);

            //Insertamos el arco minimo en la solución
            solucion.insertarArco(u);
        }
        return solucion;
    }

    /*Este método te dice cual es el arco que "menos mide" 
    (Parecido al de arriba pero con un pequeño cambio en las variables)*/
    private static <E> Arco<E, Integer> minimo(Iterator<Arco<E, Integer>> arc, Lista<Vertice<E>> porVisitar, Lista<Vertice<E>> visitados) {
        int dist_v_min = 0;
        int min = Integer.MAX_VALUE;
        Arco<E, Integer> arco_min = null;

        while (arc.hasNext()) {
            Arco<E, Integer> a1 = arc.next();
            Vertice<E> destino = a1.getDestino();
            Vertice<E> origen = a1.getOrigen();

            if (porVisitar.contiene(destino) && visitados.contiene(origen)) {
                dist_v_min = a1.getEtiqueta();
                if (dist_v_min < min) {
                    arco_min = a1;
                    min = dist_v_min;
                }

            }
        }

        return arco_min;

    }

    //Ejercicio 7 con estrategía voraz, ya esta
    /*Basicamente lo que hace este método es, dado un Grafo y un vertice cualquiera,
    se devuelve un mapa que contiene los vertices como claves y como valor, la distancia
    del camino más corto desde el vertice pasado como parametro a los demás vertices del grafo*/
    public static <E> Map<Vertice<E>, Integer> dijkstra(Grafo<E, Integer> grafo, Vertice<E> vertice) {

        final Integer INFINITO = Integer.MAX_VALUE;
        Map<Vertice<E>, Integer> distancia = new HashMap<>();
        Set<Vertice<E>> porVisitar = new HashSet<>();

        Iterator<Vertice<E>> itrVertices = grafo.vertices();

        while (itrVertices.hasNext()) {
            Vertice<E> vert = itrVertices.next();
            distancia.insertar(vert, INFINITO);
            porVisitar.add(vert);
        }

        distancia.insertar(vertice, 0);

        while (!porVisitar.isEmpty()) {
            //Aquí se guarda el vertice que esta "más cerca"
            Vertice<E> vMinimo = minimo(distancia, porVisitar.iterator());
            porVisitar.remove(vMinimo);
            Integer dis_vMinimo;
            dis_vMinimo = distancia.get(vMinimo);

            if (!dis_vMinimo.equals(INFINITO)) {
                Iterator<Arco<E, Integer>> arc = grafo.arcos();
                Integer pesoArcoElegido = 0;
                while (arc.hasNext()) {
                    Arco<E, Integer> a1 = arc.next();
                    Vertice<E> wDestino = a1.getDestino();
                    if (a1.getOrigen().equals(vMinimo) && porVisitar.contains(wDestino)) {
                        pesoArcoElegido = a1.getEtiqueta();

                        Integer dw = distancia.get(wDestino);
                        if (dis_vMinimo + pesoArcoElegido < dw) {
                            distancia.insertar(wDestino, dis_vMinimo + pesoArcoElegido);
                        }
                    }
                }
            }
        }
        return distancia;
    }

    /*Este método determina el vertice que está "más cerca", lo toma y hace las operaciones 
    sobre el en el método principal*/
    private static <E> Vertice<E> minimo(Map<Vertice<E>, Integer> distancias, Iterator<Vertice<E>> iPorVisitar) {
        Vertice<E> v, minV = iPorVisitar.next();
        Integer c, minD = distancias.get(minV);

        while (iPorVisitar.hasNext()) {
            v = iPorVisitar.next();
            c = distancias.get(v);
            if (c < minD) {
                minV = v;
                minD = c;
            }
        }

        return minV;

    }

    //Ejercicio 8 con estrategia voraz, ya esta... No hago comentarios porque es bastante parecido a
    //los anteriores
    public static Map<String, Integer> llenarMochila(int volumenMaximo, Map<String, Integer> cantidades, Map<String, Integer> volumenes) {
        //Mapa que devuelve el nombre del objeto y el numero de ellos en la mochila
        Map<String, Integer> mochila = new HashMap<>();
        int volumenOcupado = 0;
        boolean llenarMax = true;

        int cantObj = 0;

        while (volumenOcupado < volumenMaximo && llenarMax) {

            String obj = mayor1(volumenMaximo - volumenOcupado, cantidades, volumenes);
            if (obj != null) {
                int vol = volumenes.get(obj);
                cantObj = (volumenMaximo - volumenOcupado) / vol;
                int total = cantidades.get(obj);//La cantidad total que tenemos de dicho objeto

                if (cantObj > total) {
                    cantObj = total;
                }

                mochila.insertar(obj, cantObj);
                cantidades.insertar(obj, total - cantObj);//Actualizamos las cantidades del objeto
                volumenOcupado = vol * cantObj;
            } else {
                llenarMax = false;
            }

        }

        return mochila;
    }

    /*Método que determina el elemento con mayor volumen*/
    private static String mayor1(int parcial, Map<String, Integer> cantidades, Map<String, Integer> volumenes) {
        String max = null;
        int maxV = 0;

        Iterator<String> obj = volumenes.getClaves();

        while (obj.hasNext()) {

            String aux = obj.next();
            int vol = volumenes.get(aux);
            int cant = cantidades.get(aux);

            if (cant > 0 && vol > maxV && vol <= parcial) {
                maxV = vol;
                max = aux;
            }
        }

        return max;
    }

    //Ejercicio 9 con estrategía voraz, ya esta.. Parecido a los anteriores, tiene algunas
    //lineas con otras operaciones pero se entiende bien
    public static Map<String, Integer> llenarMochila2(int volumenMaximo, int pesoMaximo, Map<String, Integer> cantidades, Map<String, Integer> volumenes, Map<String, Integer> pesos) {
        Map<String, Integer> solucion = new HashMap<>();

        int volumenOcupado = 0;
        int pesoOcupado = 0;
        boolean llenarMas = true;

        // Mientras no se haya cumplido el objetivo con los objetos disponibles
        while (volumenOcupado < volumenMaximo && llenarMas) {
            // buscar un objeto que “quepa”
            String obj = mayor2(volumenMaximo - volumenOcupado, pesoMaximo - pesoOcupado, volumenes, cantidades, pesos);
            if (obj != null) {
                int vol = volumenes.get(obj);
                int pes = pesos.get(obj);

                int cantObj = (volumenMaximo - volumenOcupado) / vol; // ¿Cuántos objetos según volumen?
                int s = (pesoMaximo - pesoOcupado) / pes; //¿Cuántos objetos según peso?

                if (cantObj > s) {
                    cantObj = s; //Me quedo con la cantidad más pequeña
                }
                int tot = cantidades.get(obj); //¿cuántos objetos tengo realmente?
                if (cantObj > tot) {
                    cantObj = tot;
                }

                solucion.insertar(obj, cantObj);

                if (tot - cantObj == 0) {
                    cantidades.eliminar(obj);
                } else {
                    cantidades.insertar(obj, tot - cantObj);
                }

                volumenOcupado += vol * cantObj;
                pesoOcupado += pes * cantObj;
            } else {
                llenarMas = false; //No se puede llenar más, devolvemos la mochila
            }
        }

        return solucion;
    }

    //Método que busca el elemento con el mayor volumen
    private static String mayor2(int parcialVolumen, int parcialPeso, Map<String, Integer> volumenes,
            Map<String, Integer> cantidades, Map<String, Integer> pesos) {
        String max = null;
        int maxV = 0;

        Iterator<String> obj = volumenes.getClaves();

        while (obj.hasNext()) {
            String aux = obj.next();
            int vol = volumenes.get(aux);
            int cant = cantidades.get(aux);
            int pes = pesos.get(aux);

            if (cant > 0 && vol > maxV && vol <= parcialVolumen && pes <= parcialPeso) {
                maxV = vol;
                max = aux;
            }
        }

        return max;

    }

    //Ejercicio 10 con estrategia de vuelta atras, ya esta
    //Observación: aquí se usa el método de buenSitio como un condicional y ver que tambien
    //más abajo está presente la recursividad de siempre
    public static boolean colocarReinas(int reina, int[] tablero) {
        boolean objetivo = false;
        int columna = 0;

        //Mientras no se hayan mirado todas las posibilidades o alcanzado el objetivo
        while (columna < 8 && !objetivo) {
            // Colocar la reina j en la columna
            tablero[reina] = columna;
            if (buenSitio(reina, tablero)) {
                // Si he colocado todas las reinas
                if (reina == 7) {
                    objetivo = true;
                } else {
                    // Hacer el siguiente paso recursivamente
                    // (colocar la siguiente reina)
                    if (colocarReinas(reina + 1, tablero)) {
                        objetivo = true;
                    } else {
                        tablero[reina] = -1; //vuelta atrás, no sería necesario porque es un array y se machacaría lo que está guardado
                    }
                }
            }
            columna++;
        }

        return objetivo;
    }

    //Método privado necesario. Este método determinará si es buena opción colocar la reina en 
    //un determinado lugar
    private static boolean buenSitio(int r, int[] tabl) {
        /* ¿Es amenaza colocar la reina “r” en A[r], con las anteriores?*/
        int i;
        for (i = 0; i < r; ++i) {
            if (tabl[i] == tabl[r]) {
                return false;
            }
            if (Math.abs(i - r) == Math.abs(tabl[i] - tabl[r])) {
                return false;
            }
        }
        return true;
    }

    //Ejercicio 11 con estrategia de vuelta atras, ya esta
    public static boolean ensayar(char[][] laberinto, int posicionX, int posicionY) {
        int n = laberinto.length; // numero de filas
        boolean objetivo;
        //¿ Estamos dentro del laberinto ?
        if ((posicionX < 0) || (posicionX > n - 1) || (posicionY < 0) || (posicionY > n - 1)) {
            objetivo = false;
        } else {
            // No se puede pasar por encima de los obstáculos
            if (laberinto[posicionX][posicionY] != ' ') {
                objetivo = false;
            } else {
                // Marca como parte del camino L[posicionX][posicionY] = camino; 
                //Quizás ya es la solución
                laberinto[posicionX][posicionY] = 'C';

                if ((posicionX == n - 1) && (posicionY == n - 1)) {
                    objetivo = true; //Se ha encontrado la solución
                } else {
                    // en principio, hay solución
                    objetivo = true;

                    //hay que desplazarse en vertical u horizontal por las otras casillas
                    if (!ensayar(laberinto, posicionX + 1, posicionY)) {
                        if (!ensayar(laberinto, posicionX, posicionY + 1)) {
                            if (!ensayar(laberinto, posicionX - 1, posicionY)) {
                                if (!ensayar(laberinto, posicionX, posicionY - 1)) {
                                    laberinto[posicionX][posicionY] = 'I';
                                    objetivo = false;
                                }
                            }
                        }
                    }
                }

            }
        }

        return objetivo;
    }

    //Ejercicio 12 con estrategia de vuelta atras, ya esta
    public static boolean subconjunto(int[] vector, int[] solucion, int resultado, int indice) {
        boolean objetivo = false;

        while (indice < vector.length && !objetivo) {
            int candidato = vector[indice];
            if (candidato <= resultado) {
                solucion[indice] = 1;
                resultado -= candidato;
                if (resultado == 0) {
                    objetivo = true;
                } else {
                    objetivo = subconjunto(vector, solucion, resultado, indice + 1);
                    if (!objetivo) { //Deshago todo lo que he hecho
                        solucion[indice] = 0;
                        resultado += candidato;
                    }
                }
            }
            indice++;
        }

        return objetivo;
    }

    /*
    Ejercicio 13 con estrategia de divide y vencerás, ya esta
    
     */
    public static int SeleccionRapida(int[] array, int k_menor, int i, int j) {
        int indicePivote = buscaPivote(array, i, j);

        int pivote = array[indicePivote];
        intercambiar(array, indicePivote, j);

        int pos = particion(array, i, j, pivote);

        if (pos + 1 == k_menor) {
            return pivote;
        } else if (pos >= k_menor) {
            return SeleccionRapida(array, k_menor, i, pos - 1);
        } else {
            return SeleccionRapida(array, k_menor, pos, j);
        }
    }

    //Método necesario
    private static int buscaPivote(int[] array, int i, int j) {
        int primer = array[i];
        int k = i + 1;

        while (k <= j) {
            if (array[k] > primer) {
                return k;
            } else {
                if (array[k] < primer) {
                    return i;
                } else {
                    k++;
                }
            }

        }

        return -1;
    }

    //Método necesario
    private static void intercambiar(int[] array, int i, int j) {
        int aux = array[i];

        array[i] = array[j];
        array[j] = aux;
    }

    //Método necesario
    private static int particion(int[] array, int i, int j, int pivote) {
        int derecha = i;
        int izquierda = j - 1;

        while (derecha <= izquierda) {
            intercambiar(array, derecha, izquierda);

            while (array[derecha] < pivote) {
                ++derecha;
            }

            while (array[izquierda] >= pivote) {
                --izquierda;
            }
        }
        return derecha;
    }
}
