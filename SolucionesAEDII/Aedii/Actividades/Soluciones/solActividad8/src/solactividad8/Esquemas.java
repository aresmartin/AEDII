/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad8;

/**
 *
 * @author Rosalia
 */
import grafo.*;
import mapa.*;
import lista.*;

import java.util.Iterator;

/**
 *
 * @author Rosalia
 */
public class Esquemas {

// Ejercicio 1: Dar el cambio voraz
    public static Map<Integer, Integer> darCambio(int importeDevolver, Map<Integer, Integer> cantidades) {

        Map<Integer, Integer> solucion = new HashMap<>();

        int importeDevuelto = 0;
        boolean devolverMas = true;

        // Mientras no se haya cumplido el objetivo con los objetos disponibles
        while (importeDevuelto < importeDevolver && devolverMas) {
            // buscar un billete que “quepa”
            Integer billeteSel = mayor(importeDevolver - importeDevuelto, cantidades);
            if (billeteSel != 0) {

                int cantBil = (importeDevolver - importeDevuelto) / billeteSel; // ¿Cuántos billetes utilizo?

                int tot = cantidades.get(billeteSel); //¿cuántos billetes tengo realmente?
                if (cantBil > tot) {
                    cantBil = tot;
                }

                solucion.insertar(billeteSel, cantBil);
                importeDevuelto += billeteSel * cantBil;

                if (tot - cantBil == 0) {
                    cantidades.eliminar(billeteSel);
                } else {
                    cantidades.insertar(billeteSel, tot - cantBil);
                }

            } else {
                devolverMas = false; //No se puede devolver
            }
        }

        if (devolverMas == false) {
            return new HashMap<>();
        } else {
            return solucion;
        }
    }

    private static Integer mayor(int importeQueda, Map<Integer, Integer> cant) {
        Integer billMax = 0;
        Iterator<Integer> it_bill = cant.getClaves();

        while (it_bill.hasNext()) {
            Integer bill = it_bill.next();

            if (bill > billMax && bill <= importeQueda) {
                billMax = bill;
            }
        }

        return billMax;

    }

// Ejercicio 2: Dar el cambio vuelta atrás
    public static boolean darCambio(int importeDevolver, Map<Integer, Integer> cantidades, Map<Integer, Integer> solucion) {

        boolean objetivo = false;
        Iterator<Integer> it_bill = cantidades.getClaves();

        // Mientras no se hayan mirado todas las posibilidades o alcanzado el objetivo
        while (it_bill.hasNext() && !objetivo) {
            int moneda = it_bill.next();

            if (cantidades.get(moneda) > 0 && importeDevolver >= moneda) {
                cantidades.insertar(moneda, cantidades.get(moneda) - 1);
                if (moneda == importeDevolver) {
                    solucion.insertar(moneda, solucion.get(moneda) + 1);
                    objetivo = true;
                } else {
                    objetivo = darCambio(importeDevolver - moneda, cantidades, solucion);
                    if (objetivo) {
                        solucion.insertar(moneda, solucion.get(moneda) + 1);
                    } else {
                        cantidades.insertar(moneda, cantidades.get(moneda) + 1); //vuelta atrás, deshacer el último paso
                    }

                }
            }
        }
        return objetivo;
    }

// Ejercicio 3:: Grabar CD voraz
    public static Lista<String> llenarCDVoraz(int capacidadMaxima, Map<String, Integer> espacioProgramas) {

        Lista<String> CD = new ListaEnlazada<String>();
        int espacioOcupado = 0;
        boolean llenarMas = true;

        int k = 0;
        // Mientras no se haya cumplido el objetivo con los objetos disponibles
        while (espacioOcupado < capacidadMaxima && llenarMas) {
            // buscar un programa que “quepa”
            String prog = mayor(capacidadMaxima - espacioOcupado, espacioProgramas, CD);
            if (prog != null) {
                k = espacioProgramas.get(prog);
                espacioProgramas.eliminar(prog);
                CD.insertarPrincipio(prog);
                espacioOcupado += k;
            } else {
                llenarMas = false; //No se puede llenar más, devolvemos el CD
            }
        }

        return CD;
    }

    private static String mayor(int parcial, Map<String, Integer> progr, Lista<String> sol) {
        String maxProg = null;
        int maxEsp = 0;

        Iterator<String> it_prog = progr.getClaves();

        while (it_prog.hasNext()) {
            String prog = it_prog.next();
            int esp = progr.get(prog);

            if (!sol.contiene(prog) && esp > maxEsp && esp <= parcial) {
                maxEsp = esp;
                maxProg = prog;
            }
        }

        return maxProg;
    }

// Ejercicio 4:: Grabar CD Vuelta Atrás
    public static boolean llenarCDVueltaAtras(int capacidadCD, Map<String, Integer> programas, Lista<String> CD) {

        boolean objetivo = false;
        Iterator<String> itProgramas = programas.getClaves();

        // Mientras no se hayan mirado todas las posibilidades o alcanzado el objetivo
        while (itProgramas.hasNext() && !objetivo) {
            String program = itProgramas.next();
            int capacProgram = programas.get(program);

            if (capacProgram > 0 && capacidadCD >= capacProgram) {
                programas.eliminar(program);

                if (capacProgram == capacidadCD) {
                    CD.insertarPrincipio(program);
                    objetivo = true;
                } else {
                    objetivo = llenarCDVueltaAtras(capacidadCD - capacProgram, programas, CD);
                    if (objetivo) {
                        CD.insertarPrincipio(program);
                    } else {
                        programas.insertar(program, capacProgram); //vuelta atrás, deshacer el último paso
                    }

                }
            }
        }
        return objetivo;
    }

//Ejercicio 5: Colorear
    public static <E> Map<Vertice<E>, String> colorearMapa(Grafo<E, Integer> g, String[] colores) {
        Map<Vertice<E>, String> mapaColores = new HashMap<>();

        Iterator<Vertice<E>> it_v = g.vertices();

        while (it_v.hasNext()) {
            Vertice<E> vert = it_v.next();
            mapaColores.insertar(vert, new String());
        }

        it_v = g.vertices();

        while (it_v.hasNext()) {
            Vertice<E> vActual = it_v.next();
            String colorAdecuado = seleccionarColor(mapaColores, colores, vActual, g);
            mapaColores.insertar(vActual, colorAdecuado);
        }
        return mapaColores;
    }

    private static <E> String seleccionarColor(Map<Vertice<E>, String> d, String[] c, Vertice<E> v, Grafo<E, Integer> g) {
        int i = 0;
        String color = c[i];
        boolean fin = false;

        while (i < c.length && !fin) {
            fin = true;
            color = c[i];
            Iterator<Vertice<E>> it_ady = g.adyacentes(v);
            while (it_ady.hasNext() && fin) {
                Vertice<E> vAct = it_ady.next();
                if (d.get(vAct).equals(color)) {
                    i++;
                    fin = false;
                }
            }
        }
        return color;
    }

//Ejercicio 6: Llenar Mochila
    public static Map<String, Integer> llenarMochila(int volumenMaximo, Map<String, Integer> cantidades, Map<String, Integer> volumenes) {

        Map<String, Integer> S = new HashMap<>();
        int volumenOcupado = 0;
        boolean llenarMas = true;

        int cantObj = 0;
        // Mientras no se haya cumplido el objetivo con los objetos disponibles
        while (volumenOcupado < volumenMaximo && llenarMas) {
            // buscar un objeto que “quepa”
            String obj = mayor(volumenMaximo - volumenOcupado, cantidades, volumenes);
            if (obj != null) {
                int vol = volumenes.get(obj);
                cantObj = (volumenMaximo - volumenOcupado) / vol; // ¿Cuántos objetos?
                int tot = cantidades.get(obj);
                if (cantObj > tot) {
                    cantObj = tot;
                }

                S.insertar(obj, cantObj);
                if (tot - cantObj == 0) {
                    cantidades.eliminar(obj);
                } else {
                    cantidades.insertar(obj, tot - cantObj);
                }

                volumenOcupado += vol * cantObj;
            } else {
                llenarMas = false; //No se puede llenar más, devolvemos la mochila
            }
        }

        return S;
    }

    private static String mayor(int parcial, Map<String, Integer> c, Map<String, Integer> v) {
        String max = null;
        int maxV = 0;

        Iterator<String> obj = v.getClaves();

        while (obj.hasNext()) {
            String m = obj.next();
            int vol = v.get(m);
            int cant = c.get(m);

            if (cant > 0 && vol > maxV && vol <= parcial) {
                maxV = vol;
                max = m;
            }
        }

        return max;

    }

// Ejercicio 7: Llenar Mochila, restricción de Volumnen y Peso
    public static Map<String, Integer> llenarMochila(int volumenMaximo, int pesoMaximo, Map<String, Integer> cantidades, Map<String, Integer> volumenes, Map<String, Integer> pesos) {

        Map<String, Integer> solucion = new HashMap<>();

        int volumenOcupado = 0;
        int pesoOcupado = 0;
        boolean llenarMas = true;

        // Mientras no se haya cumplido el objetivo con los objetos disponibles
        while (volumenOcupado < volumenMaximo && llenarMas) {
            // buscar un objeto que “quepa”
            String obj = mayor(volumenMaximo - volumenOcupado, pesoMaximo - pesoOcupado, volumenes, cantidades, pesos);
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

    private static String mayor(int parcialVolumen, int parcialPeso, Map<String, Integer> v, Map<String, Integer> c, Map<String, Integer> p) {
        String max = null;
        int maxV = 0;

        Iterator<String> obj = v.getClaves();

        while (obj.hasNext()) {
            String m = obj.next();
            int vol = v.get(m);
            int pes = p.get(m);

            if (c.get(m) > 0 && vol > maxV && vol <= parcialVolumen && pes <= parcialPeso) {
                maxV = vol;
                max = m;
            }
        }

        return max;

    }

    // El Grafo debe estar bien construido, sino es posible que queden ciudades sin visitar
//////////////////////////////////////Ejercicio 8
    public static <E> Grafo<E, Integer> viajante(Grafo<E, Integer> g, Vertice<E> v) {
        Vertice<E> nodoActual = v;
        Lista<Vertice<E>> porVisitar = new ListaEnlazada<>();
        Grafo<E, Integer> solucion = new ListaAdyacencia<>();

        Iterator<Vertice<E>> it_v = g.vertices();

        while (it_v.hasNext()) {
            Vertice<E> vert = it_v.next();
            porVisitar.insertarPrincipio(vert);
        }

        porVisitar.suprimir(nodoActual);

        boolean continuar = true;

        while (!porVisitar.esVacio() && continuar) {
            Arco<E, Integer> u = minimo(g.arcos(), nodoActual, porVisitar);
            if (u != null) {
                porVisitar.suprimir(u.getDestino());
                solucion.insertarArco(u);
                nodoActual = u.getDestino();
            } else {
                continuar = false;
            }
        }
        return solucion;
    }

    private static <E> Arco<E, Integer> minimo(Iterator<Arco<E, Integer>> arc, Vertice<E> v, Lista<Vertice<E>> iPorVisitar) {
        int dist_v_min = 0;
        int min = Integer.MAX_VALUE;
        Arco<E, Integer> arco_min = null;
        while (arc.hasNext()) {
            Arco<E, Integer> a1 = arc.next();
            Vertice<E> w = a1.getDestino();
            if (a1.getOrigen().equals(v) && iPorVisitar.contiene(w)) {
                dist_v_min = a1.getEtiqueta();
                if (dist_v_min < min) {
                    arco_min = a1;
                    min = dist_v_min;
                }
            }
        }
        return arco_min;

    }

////////////////////////////////////// Ejercicio 9
    public static <E> Grafo<E, Integer> prim(Grafo<E, Integer> g, Vertice<E> v) {
        Lista<Vertice<E>> porVisitar = new ListaEnlazada<>();
        Lista<Vertice<E>> visitados = new ListaEnlazada<>();
        Grafo<E, Integer> solucion = new ListaAdyacencia<>();

        Iterator<Vertice<E>> it_v = g.vertices();

        while (it_v.hasNext()) {
            Vertice<E> vert = it_v.next();
            porVisitar.insertarPrincipio(vert);
        }

        porVisitar.suprimir(v);
        visitados.insertarPrincipio(v);

        while (!porVisitar.esVacio()) {
            Arco<E, Integer> u = minimo(g.arcos(), porVisitar, visitados);
            Vertice<E> w = u.getDestino();
            porVisitar.suprimir(w);
            visitados.insertarPrincipio(w);
            solucion.insertarArco(u);
        }
        return solucion;
    }

    private static <E> Arco<E, Integer> minimo(Iterator<Arco<E, Integer>> arc, Lista<Vertice<E>> iPorVisitar, Lista<Vertice<E>> iVisitados) {
        int dist_v_min = 0;
        int min = Integer.MAX_VALUE;
        Arco<E, Integer> arco_min = null;

        while (arc.hasNext()) {
            Arco<E, Integer> a1 = arc.next();
            Vertice<E> w = a1.getDestino();
            Vertice<E> v = a1.getOrigen();

            if (iPorVisitar.contiene(w) && iVisitados.contiene(v)) {
                dist_v_min = a1.getEtiqueta();
                if (dist_v_min < min) {
                    arco_min = a1;
                    min = dist_v_min;
                }

            }
        }

        return arco_min;

    }

    //Ejercicio 10: 8 reinas
    private static boolean buenSitio(int j, int[] tabl) {
        // ¿Es amenaza colocar la reina j en A[j], con las anteriores ?
        int i;
        for (i = 0; i < j; ++i) {
            if (tabl[i] == tabl[j]) {
                return false;
            }
            if (Math.abs(i - j) == Math.abs(tabl[i] - tabl[j])) {
                return false;
            }
        }
        return true;
    }

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

    //Ejercicio 11: Laberinto
    public static boolean ensayar(char[][] laberinto, int posicionX, int posicionY) {

        int n = laberinto.length; // Tamaño del laberinto n x n
        boolean toret;
// estamos dentro del laberinto ?
        if ((posicionX < 0) || (posicionX > n - 1) || (posicionY < 0) || (posicionY > n - 1)) {
            toret = false;
        } else {
// No se puede pasar por encima de los obstáculos
            if (laberinto[posicionX][posicionY] != ' ') {
                toret = false;
            } else {
                // Marca como parte del camino L[posicionX][posicionY] = camino; 
                //Quizás ya es la solución
                laberinto[posicionX][posicionY] = 'C';

                if ((posicionX == n - 1) && (posicionY == n - 1)) {
                    toret = true; //Se ha encontrado la solución
                } else {
                    // en principio, hay solución
                    toret = true;

                    //hay que desplazarse en vertical u horizontal por las otras casillas
                    if (!ensayar(laberinto, posicionX + 1, posicionY)) {
                        if (!ensayar(laberinto, posicionX, posicionY + 1)) {
                            if (!ensayar(laberinto, posicionX - 1, posicionY)) {
                                if (!ensayar(laberinto, posicionX, posicionY - 1)) {
                                    laberinto[posicionX][posicionY] = 'I';
                                    toret = false;
                                }
                            }
                        }
                    }
                }

            }
        }

        return toret;
    }

// Ejercicio 12: subconjunto   
    public static boolean subconjuntos(int[] valores, int[] solucion, int suma, int i) {
        boolean objetivo = false;
        while (i < valores.length && !objetivo) {
            int candidato = valores[i];
            if (candidato <= suma) {
                solucion[i] = 1;
                if (candidato == suma) {
                    solucion[i] = 1;
                    objetivo = true;
                } else {
                    objetivo = subconjuntos(valores, solucion, suma - candidato, i + 1);
                    if (!objetivo) {
                        solucion[i] = 0; //vuelta atrás
                    }
                }
            }
            i++;
        }
        return objetivo;
    }

// Ejercicio 13: k-esimo menor elemento
// Selecciona un elemento pivote, entre dos elementos diferentes devuelve el elemento mayor
    private static int buscaPivote(int i, int j, int[] array) {
        int primer = array[i];
        int k = i + 1;

        while (k <= j) {
            if (array[k] > primer) {
                return k;
            } else if (array[k] < primer) {
                return i;
            } else {
                k++;
            }
        }
        //Si llega al final del array y todos los elementos son iguales
        return -1;
    }

//Divide el array en menores que pivote, y mayores e igual a pivote
// Devuelve la posición del primer elemento de los mayores
    private static int particion(int i, int j, int pivote, int[] array) {
        int derecha = i;
        int izquierda = j - 1;
        while (derecha <= izquierda) {

            while (array[derecha] < pivote) {
                derecha++;
            }

            while (array[izquierda] >= pivote) {
                izquierda--;
            }

            if (derecha < izquierda) {
                intercambiar(derecha, izquierda, array);
            }
        }
        return derecha;
    }
// Intercambiar dos elementos en el array  

    private static void intercambiar(int i, int j, int[] array) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    public static int SeleccionRapida(int[] array, int k_menor, int i, int j) {
        int indicePivote = buscaPivote(i, j, array);
        if (indicePivote != -1) {
            int pivote = array[indicePivote];
            intercambiar(indicePivote, j, array); // pivote para la última posición
            int pos = particion(i, j, pivote, array);
            if (pos + 1 == k_menor) {
                return pivote; //encontrado el elemento k_menor
            } else if (pos >= k_menor) {
                return SeleccionRapida(array, k_menor, i, pos - 1);
            } else {
                return SeleccionRapida(array, k_menor, pos, j);
            }
        } else {
            return indicePivote;
        }
    }

}
