package usografo;


import grafo2.Arco;
import grafo2.Grafo;
import grafo2.MapAdyacencia;

import grafo2.Vertice;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Juan Yuri Díaz Sánchez
 */
public class UsoGrafoTest {
    
    private static Grafo<String, Integer> g; 
    private static final Grafo<String, Integer> gVacio = new MapAdyacencia<>();

    private static final Vertice<String> v1 = new Vertice<>("Coruña");
    private static final Vertice<String> v2 = new Vertice<>("Lugo");
    private static final Vertice<String> v3 = new Vertice<>("Ourense");
    private static final Vertice<String> v4 = new Vertice<>("Pontevedra");
    
    
    

    private static void rellenarGrafoG(){
        g = new MapAdyacencia<>();
        g.insertarArco(new Arco<>(v2, v1, 10));
        g.insertarArco(new Arco<>(v1, v3, 20));
        g.insertarArco(new Arco<>(v2, v4, 115));
        g.insertarArco(new Arco<>(v3, v4, 100));
        g.insertarArco(new Arco<>(v2, v3, 100));
        g.insertarArco(new Arco<>(v4, v2, 120));
        g.insertarArco(new Arco<>(v4, v3, 120));
    }
   
    @Before
    public void setUp() throws Exception {
            rellenarGrafoG();
    }
    
   
    /**
     * Test of predecesores method, of class UsoGrafo.
     */
    @Test
    public void testPredecesores() {
        System.out.println("predecesores");
        Iterator<Vertice<String>> itPred = UsoGrafo.predecesores(g, v4);
        List<String> result = new ArrayList<>();
        while (itPred.hasNext()) {
            result.add(itPred.next().getEtiqueta());
        }
        List<String> expResult = new ArrayList<>();
        expResult.add("Lugo");
        expResult.add("Ourense");
        assertArrayEquals(expResult.toArray(), result.toArray());
    }

    /**
     * Test of sumidero method, of class solActividad7.
     */
    @Test
    public void testSumideroVacio() {
        System.out.println("sumidero");
        boolean result = UsoGrafo.sumidero(gVacio, v3);
        assertFalse(result);
    }
    @Test
    public void testNoSumidero() {
        System.out.println("sumidero");
        boolean result = UsoGrafo.sumidero(g, v3);
        assertFalse(result);
    }
    @Test
    public void testSumidero() {
        System.out.println("sumidero");
        g.eliminarArco(new Arco<>(v3,v4, 100));
        boolean result = UsoGrafo.sumidero(g,v3);
        assertTrue(result);
    }

    /**
     * Test of regular method, of class solActividad7.
     */
    @Test
    public void testVacioRegular() {
        System.out.println("regular");
        boolean expResult = true;
        boolean result = UsoGrafo.regular(gVacio);
        assertEquals(expResult, result);
    }
    @Test
    public void testNORegular() {
        System.out.println("regular");
        boolean expResult = false;
        boolean result = UsoGrafo.regular(g);
        assertEquals(expResult, result);
    }
    @Test
    public void testSiRegular() {
        System.out.println("regular");
        g.eliminarArco(new Arco<>(v2,v4, 115));
	g.insertarArco(new Arco<>(v1, v4, 200));
	g.insertarArco(new Arco<>(v3, v1, 120));
        boolean expResult = true;
        boolean result = UsoGrafo.regular(g);
        assertEquals(expResult, result);
    }
//
    /**
     * Test of hayCaminoEntreDos method, of class solActividad7.
     */
    @Test
    public void testHayCaminoEntreDos() {
        System.out.println("hayCaminoEntreDos");
        boolean expResult = false;
        boolean result = UsoGrafo.esCamino(gVacio, v1, v2);
        assertEquals(expResult, result);   
    }
//
//    /**
//     * Test of esArborescencia method, of class solActividad7.
//     */
//    @Test
//    public void testEsArborescencia() {
//        System.out.println("esArborescencia");
//        Vertice<String> expResult = v2;
//        Vertice<String> result = UsoGrafo.esArborescencia(g);
//        assertEquals(expResult, result);   
//    }
    
//    @Test
//    public void testEsCompleto(){
//        System.out.println("esCompleto");
//        boolean expResult = false;
//        boolean result = UsoGrafo.esCompleto(g);
//        assertEquals(expResult,result);
//    }
    
//    @Test
//    public void testNoEsArborescencia() {
//        g.eliminarArco(new Arco<>(v4, v2, 120));
//	g.eliminarArco(new Arco<>(v4, v3, 120));
//        g.eliminarArco(new Arco<>(v2, v3, 100));
//        g.eliminarArco(new Arco<>(v2, v1, 10));
//        System.out.println("noEsArborescencia");
//        Vertice<String> expResult = null;
//        Vertice<String> result = UsoGrafo.esArborescencia(g);
//        assertEquals(expResult, result);   
//    }
//
//    /**
//     * Test of hayCaminoEntreDos method, of class solActividad7.
//     */
//    @Test
//    public void testEsCicloFalse() {
//        System.out.println("esCiclo");
//        List<Vertice<String>> camino = new ArrayList<>();
//        camino.add(v1);
//        camino.add(v2);
//        boolean expResult = false;
//        boolean result = UsoGrafo.esCiclo(gVacio, camino);
//        assertEquals(expResult, result);   
//    }
//    
//    @Test
//    public void testEsCicloTrue() {
//        System.out.println("esCiclo true");
//        List<Vertice<String>> camino = new ArrayList<>();
//        camino.add(v2);
//        camino.add(v3);
//        camino.add(v4);
//        camino.add(v2);
//        boolean expResult = true;
//        boolean result = UsoGrafo.esCiclo(g, camino);
//        assertEquals(expResult, result);   
//    }
//    @Test
//    public void testEsCicloTrue2() {
//        System.out.println("esCiclo true");
//        List<Vertice<String>> camino = new ArrayList<>();
//        camino.add(v4);
//        camino.add(v3);
//        camino.add(v4);
//        boolean expResult = true;
//        boolean result = UsoGrafo.esCiclo(g, camino);
//        assertEquals(expResult, result);   
//    }
//    @Test
//    public void testEsCicloTrue3() {
//        System.out.println("esCiclo true");
//        List<Vertice<String>> camino = new ArrayList<>();
//        camino.add(v2);
//        camino.add(v1);
//        camino.add(v3);
//        camino.add(v4);
//        camino.add(v2);
//        boolean expResult = true;
//        boolean result = UsoGrafo.esCiclo(g, camino);
//        assertEquals(expResult, result);   
//    }
//    @Test
//    public void testEsCicloFalse2() {
//        System.out.println("esCiclo false");
//        List<Vertice<String>> camino = new ArrayList<>();
//        camino.add(v1);
//        camino.add(v3);
//        camino.add(v4);
//        camino.add(v3);
//        camino.add(v4);
//        camino.add(v2);
//        camino.add(v1);
//        
//        boolean expResult = false;
//        boolean result = UsoGrafo.esCiclo(g, camino);
//        assertEquals(expResult, result);   
//    }
    
}