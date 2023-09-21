/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solActividad9;

import grafo.*;
import mapa.*;
import lista.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Rosalia
 */
public class EsquemasTest {
private static Grafo<Integer, Integer> g1; 
	
private static Vertice<Integer> uno = new Vertice<Integer>(1);
private static Vertice<Integer> dos = new Vertice<Integer>(2);
private static Vertice<Integer> tres = new Vertice<Integer>(3);
private static Vertice<Integer> cuatro = new Vertice<Integer>(4);
private static Vertice<Integer> cinco = new Vertice<Integer>(5);
private static Vertice<Integer> seis = new Vertice<Integer>(6); 


private static Map<String,Integer> cantidades;
private static Map<String,Integer> volumenes;
private static Map<String,Integer> pesos;
private static Map<Integer,Integer> can;
private static Map<String,Integer> programas;

private static int[] selecRapi = {4,2, 8, 12,6,9,23,43,78,14};
private static char[][] lab = {{' ',' ',' ','X'},
                               {' ',' ','X',' '},
                               {' ',' ',' ',' '},
                               {' ','X',' ',' '}};

private static int [] valores = {8,3,5,9};
	
private static void rellenarMapas(){
cantidades = new HashMap<>();	
cantidades.insertar("Coche",5);
cantidades.insertar("Muñeca",4);

volumenes = new HashMap<>();
volumenes.insertar("Coche",10);
volumenes.insertar("Muñeca",20);

pesos = new HashMap<>();
pesos.insertar("Coche",20);
pesos.insertar("Muñeca",30);

can = new HashMap<>();
can.insertar(200,10);
can.insertar(500,10);

programas=new HashMap<>();
programas.insertar("p1",10);
programas.insertar("p2",3);
programas.insertar("p3",5);
programas.insertar("p4",3);
programas.insertar("p5",3);

}


private static void rellenarGrafoG(){
    g1 = new ListaAdyacencia<>();
    g1.insertarArco(new Arco<>(uno,dos,3));
    g1.insertarArco(new Arco<>(uno,seis,5));
    g1.insertarArco(new Arco<>(dos,tres,7));
    g1.insertarArco(new Arco<>(dos,seis,10));
    g1.insertarArco(new Arco<>(seis,tres,8));
    g1.insertarArco(new Arco<>(seis,cuatro,2));
    g1.insertarArco(new Arco<>(tres,cuatro,5));
    g1.insertarArco(new Arco<>(tres,cinco,1));
    g1.insertarArco(new Arco<>(cuatro,cinco,6)); 
    // Añado los arcos en el otro sentido, hace falta para el problema del viajante
    g1.insertarArco(new Arco<>(dos,uno,3));
    g1.insertarArco(new Arco<>(seis,uno,5));
    g1.insertarArco(new Arco<>(tres,dos,7));
    g1.insertarArco(new Arco<>(seis,dos,10));
    g1.insertarArco(new Arco<>(tres,seis,8));
    g1.insertarArco(new Arco<>(cuatro,seis,2));
    g1.insertarArco(new Arco<>(cuatro,tres,5));
    g1.insertarArco(new Arco<>(cinco,tres,1));
    g1.insertarArco(new Arco<>(cinco,cuatro,6));
}

private <E,T> boolean grafosIguales(Grafo<E,T> g1, Grafo<E,T> g2){ 
    Iterator<Arco<E,T>> arc = g1.arcos();
		
    while (arc.hasNext()) {
	Iterator<Arco<E,T>> arcExpected = g2.arcos();
	boolean continuar = true;
	Arco<E,T> a1 = arc.next();
        Vertice<E> w1 = a1.getDestino();
        Vertice<E> v1 = a1.getOrigen();
			
	while (arcExpected.hasNext() && continuar){
	    Arco<E,T> a2 = arcExpected.next();
	    Vertice<E> w2 = a1.getDestino();
	    Vertice<E> v2 = a1.getOrigen(); 
			    
	    if (a1.getEtiqueta().equals(a2.getEtiqueta()) && w1.equals(w2) && v1.equals(v2)) 
	    	continuar = false;
            }
			
	if (continuar) 
            return false;
    }
		
    // Se comprueba en el otro sentido para garantizar que tienen exactamente los mismos arcos y no más
    arc = g2.arcos();
		
    while (arc.hasNext()) {
	Iterator<Arco<E,T>> arcActual = g1.arcos();
	boolean continuar = true;
	Arco<E,T> a1 = arc.next();
        Vertice<E> w1 = a1.getDestino();
        Vertice<E> v1 = a1.getOrigen();
			
	while (arcActual.hasNext() && continuar){
	    Arco<E,T> a2 = arcActual.next();
	    Vertice<E> w2 = a1.getDestino();
	    Vertice<E> v2 = a1.getOrigen(); 
			    
	    if (a1.getEtiqueta().equals(a2.getEtiqueta()) && w1.equals(w2) && v1.equals(v2)) 
	    	continuar = false;
        }
			
	if (continuar) 
            return false;
    }
		
		
return true;
    
}

private static <E,F> boolean mapasIguales(Map<E,F> m1, Map<E, F> m2){
if (m1.tamaño() == m2.tamaño()){
    Iterator<E> itr = m1.getClaves();
    while(itr.hasNext()){
        E clave = itr.next();
        if (m1.get(clave)==null || !m1.get(clave).equals(m2.get(clave)))
            return false;
        }
        return true;
}
return false;
}

private static <E> boolean listasIguales(Lista<E> m1, Lista<E> m2){
if (m1.tamaño() == m2.tamaño()){
    Iterator<E> itr = m1.iteradorLista();
    while(itr.hasNext()){
        E clave = itr.next();
        if (!m2.contiene(clave))
            return false;
        }
        return true;
}
return false;
}

    @Before
    public void setUp() throws Exception{
        rellenarGrafoG();
        rellenarMapas();
    }

       

    /**
     * Test of darCambio method, of class Esquemas.
     */
    @Test
    public void testDarCambio_int_Map() {
        System.out.println("darCambio Voraz");
        Map<Integer, Integer> mapaActual = Esquemas.darCambio(1200, can);
        Map<Integer,Integer> mapaEsperado = new HashMap<>();
        mapaEsperado.insertar(200,1);
        mapaEsperado.insertar(500,2);
        
        boolean result = mapasIguales(mapaActual,mapaEsperado);
        
        assertTrue(result);
    }

    /**
     * Test of darCambio method, of class Esquemas.
     */
    @Test
    public void testDarCambio_3args() {
        System.out.println("darCambio Vuelta atras");
        Map<Integer, Integer> mapaActual = new HashMap<>();
        mapaActual.insertar(200, 0);
        mapaActual.insertar(500,0);

        Esquemas.darCambio(2100, can, mapaActual);

        Map<Integer,Integer> mapaEsperado = new HashMap<>();
        mapaEsperado.insertar(200,3);
        mapaEsperado.insertar(500,3);
        
        boolean result = mapasIguales(mapaActual,mapaEsperado);
        
        assertTrue(result);
    }

    /**
     * Test of llenarMochila method, of class Esquemas.
     */
    @Test
    public void testLlenarMochila_3args() {
        System.out.println("llenarMochila");
        Map<String,Integer> mapaActual = Esquemas.llenarMochila(55, cantidades, volumenes);
        
        Map<String,Integer> mapaEsperado = new HashMap<>();
        mapaEsperado.insertar("Coche",1);
        mapaEsperado.insertar("Muñeca",2);
        
        boolean result = mapasIguales(mapaActual,mapaEsperado);
        
        assertTrue(result);
    }

    /**
     * Test of llenarMochila method, of class Esquemas.
     */
    @Test
    public void testLlenarMochila_5args() {
        System.out.println("llenarMochila 2");
        Map<String, Integer> mapaActual = Esquemas.llenarMochila(55, 50, cantidades, volumenes, pesos);
        
        Map<String,Integer> mapaEsperado = new HashMap<>();
        mapaEsperado.insertar("Coche",1);
        mapaEsperado.insertar("Muñeca",1);
        
        boolean result = mapasIguales(mapaActual,mapaEsperado);
        
        assertTrue(result);
    }

    /**
     * Test of viajante method, of class Esquemas.
     */
    @Test
    public void testViajante() {
    System.out.println("viajante");
    Grafo<Integer, Integer> grafoActual = Esquemas.viajante(g1, uno);
    Grafo<Integer, Integer> grafoEsperado = new ListaAdyacencia<>();

    Vertice<Integer> v1 = new Vertice<Integer>(1);
    Vertice<Integer> v2 = new Vertice<Integer>(2);
    Vertice<Integer> v3 = new Vertice<Integer>(3);
    Vertice<Integer> v4 = new Vertice<Integer>(4);
    Vertice<Integer> v5 = new Vertice<Integer>(5);
    Vertice<Integer> v6 = new Vertice<Integer>(6);

    grafoEsperado.insertarArco(new Arco<>(v1, v2, 3));
    grafoEsperado.insertarArco(new Arco<>(v2, v3, 7));
    grafoEsperado.insertarArco(new Arco<>(v3, v5, 1));
    grafoEsperado.insertarArco(new Arco<>(v5, v4, 6));
    grafoEsperado.insertarArco(new Arco<>(v4, v6, 2));
    
    boolean result = grafosIguales(grafoActual,grafoEsperado);
    assertTrue(result);
    }

    /**
     * Test of prim method, of class Esquemas.
     */
    @Test
    public void testPrim() {
        System.out.println("prim");
        Grafo<Integer, Integer> grafoActual = Esquemas.prim(g1, seis);
        Grafo<Integer, Integer> grafoEsperado = new ListaAdyacencia<>();

        Vertice<Integer> v1 = new Vertice<Integer>(1);
        Vertice<Integer> v2 = new Vertice<Integer>(2);
        Vertice<Integer> v3 = new Vertice<Integer>(3);
        Vertice<Integer> v4 = new Vertice<Integer>(4);
        Vertice<Integer> v5 = new Vertice<Integer>(5);
        Vertice<Integer> v6 = new Vertice<Integer>(6);

        grafoEsperado.insertarArco(new Arco<>(v6, v4, 2));
        grafoEsperado.insertarArco(new Arco<>(v6, v1, 5));
        grafoEsperado.insertarArco(new Arco<>(v1, v2, 3));
        grafoEsperado.insertarArco(new Arco<>(v4, v3, 5));
        grafoEsperado.insertarArco(new Arco<>(v3, v5, 1));
        
        boolean result = grafosIguales(grafoActual,grafoEsperado);
        assertTrue(result);
    }

    /**
     * Test of colocarReinas method, of class Esquemas.
     */
    @Test
    public void testColocarReinas() {
        System.out.println("colocarReinas");
        int[] tablero = new int[8];
        Esquemas.colocarReinas(0, tablero);
        int [] solEsperada = {0,4,7,5,2,6,1,3};

        assertArrayEquals(tablero,solEsperada);
    }

    /**
     * Test of ensayar method, of class Esquemas.
     */
    @Test
    public void testEnsayar() {
        System.out.println("ensayar");
        Esquemas.ensayar(lab, 0, 0);
			
        char [][] solEsperada = {{'C',' ',' ','X'},
                                 {'C',' ','X',' '},
                                 {'C','C','C',' '},
                                 {'I','X','C','C'}};
        
        
        assertArrayEquals(lab,solEsperada);
    }

    /**
     * Test of subconjuntos method, of class Esquemas.
     */
    @Test
    public void testSubconjuntos() {
        System.out.println("subconjuntos");
        int[] solucion = new int[valores.length];
        int [] expResult = {0,1,0,1};
        Esquemas.subconjuntos(valores, solucion, 12, 0);
        assertArrayEquals(expResult, solucion);
    }

    /**
     * Test of SeleccionRapida method, of class Esquemas.
     */
    @Test
    public void testSeleccionRapida() {
        System.out.println("SeleccionRapida");
        int sol = Esquemas.SeleccionRapida(selecRapi, 5, 0, selecRapi.length-1);
																		
        assertEquals(sol,9); 
    }

    /**
     * Test of llenarCD_Voraz method, of class Esquemas.
     */
    @Test
    public void testLlenarCD_Voraz() {
        System.out.println("llenarCD_Voraz");
        int capacidadMaxima = 21;
        Lista<String> expResult = new ListaEnlazada<>();
        expResult.insertarPrincipio("p1");
        expResult.insertarPrincipio("p3");
        expResult.insertarPrincipio("p2");
        expResult.insertarPrincipio("p4");
        Lista<String> result = Esquemas.llenarCDVoraz(capacidadMaxima, programas);
        
        boolean toRet = listasIguales(expResult,result);
        assertTrue(toRet);
        
    }

    /**
     * Test of llenarCDVueltaAtras method, of class Esquemas.
     */
    @Test
    public void testLlenarCDVueltaAtras() {
        System.out.println("llenarCDVueltaAtras");
        int capacidadCD = 21;
        Lista<String> S = new ListaEnlazada<>();
        Lista<String> expResult = new ListaEnlazada<>();
        expResult.insertarPrincipio("p4");
        expResult.insertarPrincipio("p3");
        expResult.insertarPrincipio("p2");
        expResult.insertarPrincipio("p1");
        Esquemas.llenarCDVueltaAtras(capacidadCD, programas, S);
        
        boolean toRet = listasIguales(expResult,S);
        assertTrue(toRet);
        
    }
    
}
