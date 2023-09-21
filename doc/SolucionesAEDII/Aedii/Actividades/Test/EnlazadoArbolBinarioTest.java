/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolucionActividad3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.StringWriter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rosalia
 */
public class EnlazadoArbolBinarioTest {
    
   private static EnlazadoArbolBinario<Character> aF;
   private static EnlazadoArbolBinario<Character> aG;
   private static EnlazadoArbolBinario<Character> aH;
   private static EnlazadoArbolBinario<Character> aI;
   private static EnlazadoArbolBinario<Character> aK;
   private static EnlazadoArbolBinario<Character> aJ;
   private static EnlazadoArbolBinario<Character> aD;
   private static EnlazadoArbolBinario<Character> aC;
   private static EnlazadoArbolBinario<Character> aE;
   private static EnlazadoArbolBinario<Character> aB;
   private static EnlazadoArbolBinario<Character> aA;
   
   
   private static boolean identicos (ArbolBinario<Character> a, ArbolBinario<Character> b){
        if (!a.esVacio() && !b.esVacio())
            return a.raiz().equals(b.raiz()) && identicos(a.hijoIzq(), b.hijoIzq()) && identicos(a.hijoDer(), b.hijoDer());
        else return a.esVacio() && b.esVacio();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
            aF = new EnlazadoArbolBinario<>('F',new EnlazadoArbolBinario<>(),new EnlazadoArbolBinario<>());
            aG = new EnlazadoArbolBinario<>('G',new EnlazadoArbolBinario<>(),new EnlazadoArbolBinario<>());
            aH = new EnlazadoArbolBinario<>('H',new EnlazadoArbolBinario<>(),new EnlazadoArbolBinario<>());
            aI = new EnlazadoArbolBinario<>('I',new EnlazadoArbolBinario<>(),new EnlazadoArbolBinario<>());
            aK = new EnlazadoArbolBinario<>('K',new EnlazadoArbolBinario<>(),new EnlazadoArbolBinario<>());
            aJ = new EnlazadoArbolBinario<>('J',aK,new EnlazadoArbolBinario<>());
            aD = new EnlazadoArbolBinario<>('D',aH,aI);
            aC = new EnlazadoArbolBinario<>('C',new EnlazadoArbolBinario<>(),aG);
            aE = new EnlazadoArbolBinario<>('D',aJ,new EnlazadoArbolBinario<>());
            aB = new EnlazadoArbolBinario<>('B',aD,aE);
            aA = new EnlazadoArbolBinario<>('A',aB,new EnlazadoArbolBinario<>());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of esVacio method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testEsVacioFasle() {
        System.out.println("esVacio");
        boolean expResult = false;
        boolean result = aA.esVacio();
        assertEquals(expResult, result);
        
    }
@Test
    public void testEsVacioTrue() {
        System.out.println("esVacio");
        EnlazadoArbolBinario<Character> instance= new EnlazadoArbolBinario<>();
        boolean expResult = true;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of raiz method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testRaiz() {
        System.out.println("raiz");
        Character expResult = 'A';
        Character result = aA.raiz();
        assertEquals(expResult, result);
        
    }
    
    @Test(expected=ArbolVacioExcepcion.class)
    public void testRaizArbolVacio() {
        System.out.println("raiz arbol vacio");
        EnlazadoArbolBinario<Integer> instance = new EnlazadoArbolBinario<>();
        Integer result = instance.raiz();
    }

    /**
     * Test of esta method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testEstaTrue() {
        System.out.println("esta");
        Character elemento = 'J';
        boolean expResult = true;
        boolean result = aA.esta(elemento);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEstaFalse() {
        System.out.println("esta");
        Character elemento = 'O';
        boolean expResult = false;
        boolean result = aA.esta(elemento);
        assertEquals(expResult, result);
    }

    /**
     * Test of hijoIzq method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testHijoIzq() {
        System.out.println("hijoIzq");
        boolean expect = true;
        ArbolBinario<Character> result = aA.hijoIzq();
        boolean resultExpect = identicos(aB,result);
        assertEquals(expect,resultExpect);        
        }

    @Test(expected=ArbolVacioExcepcion.class)
    public void testHijoIzqArbolVacio() {
        System.out.println("Hijo izquierdo arbol vacio");
        EnlazadoArbolBinario<Character> instance = new EnlazadoArbolBinario<>();
        ArbolBinario<Character> result = instance.hijoIzq();
    }
    /**
     * Test of hijoDer method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testHijoDer() {
        System.out.println("hijoDer");
        boolean expect = true;
        ArbolBinario<Character> result = aB.hijoDer();
        boolean resultExpect = identicos(aE,result);
        assertEquals(expect,resultExpect);        
    }
    
    @Test(expected=ArbolVacioExcepcion.class)
    public void testHijoDerArbolVacio() {
        System.out.println("Hijo Derecho arbol vacio");
        EnlazadoArbolBinario<Character> instance = new EnlazadoArbolBinario<>();
        ArbolBinario<Character> result = instance.hijoDer();
    }

    /**
     * Test of setRaiz method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testSetRaiz() {
        System.out.println("setRaiz");
        Character elemRaiz = 'a';
        aA.setRaiz(elemRaiz);
        assertEquals(elemRaiz,aA.raiz());
    }
    
    @Test(expected=ArbolVacioExcepcion.class)
    public void testSetRaizArbolVacio() {
        System.out.println("setRaiz arbol vacio");
        EnlazadoArbolBinario<Character> instance = new EnlazadoArbolBinario<>();
        Character elemRaiz = 'a';
        instance.setRaiz(elemRaiz);
    }

    /**
     * Test of setHijoIzq method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testSetHijoIzq() {
        System.out.println("setHijoIzq");
        EnlazadoArbolBinario<Character> aF2 = new EnlazadoArbolBinario<>('F',new EnlazadoArbolBinario<>(),new EnlazadoArbolBinario<>());
        EnlazadoArbolBinario<Character> aG2 = new EnlazadoArbolBinario<>('G',new EnlazadoArbolBinario<>(),new EnlazadoArbolBinario<>());
        EnlazadoArbolBinario<Character> aC2 = new EnlazadoArbolBinario<>('C',aF2,aG2);
        
        aC.setHijoIzq(aF);
        boolean resultExpect = identicos(aC2,aC);
        assertEquals(true,resultExpect);
    }

    @Test(expected=ArbolVacioExcepcion.class)
    public void testSetHijoIzqArbolVacio() {
        System.out.println("setHijoIzq arbol vacio");
        EnlazadoArbolBinario<Character> instance = new EnlazadoArbolBinario<>();
        instance.setHijoIzq(aF);
    }
    
    @Test(expected=NullPointerException.class)
    public void testSetHijoIzqNull() {
        System.out.println("setHijoIzq null");
        EnlazadoArbolBinario<Character> instance = null;
        aC.setHijoIzq(instance);
    }
    
    /**
     * Test of setHijoDer method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testSetHijoDer() {
        System.out.println("setHijoDer");
        EnlazadoArbolBinario<Character> aG2 = new EnlazadoArbolBinario<>('G',new EnlazadoArbolBinario<>(),new EnlazadoArbolBinario<>());
        EnlazadoArbolBinario<Character> aH2 = new EnlazadoArbolBinario<>('H',new EnlazadoArbolBinario<>(),new EnlazadoArbolBinario<>());
        EnlazadoArbolBinario<Character> aI2 = new EnlazadoArbolBinario<>('I',new EnlazadoArbolBinario<>(),new EnlazadoArbolBinario<>());
        EnlazadoArbolBinario<Character> aK2 = new EnlazadoArbolBinario<>('K',new EnlazadoArbolBinario<>(),new EnlazadoArbolBinario<>());
        EnlazadoArbolBinario<Character> aJ2 = new EnlazadoArbolBinario<>('J',aK2,new EnlazadoArbolBinario<>());
        EnlazadoArbolBinario<Character> aD2 = new EnlazadoArbolBinario<>('D',aH2,aI2);
        EnlazadoArbolBinario<Character> aC2 = new EnlazadoArbolBinario<>('C',new EnlazadoArbolBinario<>(),aG2);
        EnlazadoArbolBinario<Character> aE2 = new EnlazadoArbolBinario<>('D',aJ2,new EnlazadoArbolBinario<>());
        EnlazadoArbolBinario<Character> aB2 = new EnlazadoArbolBinario<>('B',aD2,aE2);
        EnlazadoArbolBinario<Character> aA2 = new EnlazadoArbolBinario<>('A',aB2,aC2);
        
        aA.setHijoDer(aC);
        boolean resultExpect = identicos(aA2,aA);
        assertEquals(true,resultExpect);
        
        
    }

    @Test(expected=ArbolVacioExcepcion.class)
    public void testSetHijoDerArbolVacio() {
        System.out.println("setHijoDer arbol vacio");
        EnlazadoArbolBinario<Character> instance = new EnlazadoArbolBinario<>();
        instance.setHijoDer(aF);
    }
    
    @Test(expected=NullPointerException.class)
    public void testSetHijoDerNull() {
        System.out.println("setHijoDer null");
        EnlazadoArbolBinario<Character> instance = null;
        aC.setHijoDer(instance);
    }
    
    /**
     * Test of suprimir method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testSuprimir() {
        System.out.println("suprimir");
        EnlazadoArbolBinario<Character> instance = new EnlazadoArbolBinario<>();
        aA.suprimir();
        boolean resultExpect = identicos(instance,aA);
        assertEquals(true,resultExpect);
    }
    
}
