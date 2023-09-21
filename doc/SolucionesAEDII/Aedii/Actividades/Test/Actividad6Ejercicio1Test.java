
package solactividad6.ejercicio1;

import arbolGeneral.ArbolGeneral;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class NuevoArbolGeneral1Test {
    
    NuevoArbolGeneral1<Character> arbol;
    NuevoArbolGeneral1<Character> arbol1; 
    NuevoArbolGeneral1<Character> arbol2;
    NuevoArbolGeneral1<Character> arbol3;
    NuevoArbolGeneral1<Character> arbol4;

    @Before
    public void setUp() throws Exception {
        arbol = new NuevoArbolGeneral1<>('2');
        arbol1 = new NuevoArbolGeneral1<>('4', arbol);
        arbol2 = new NuevoArbolGeneral1<>('3', new NuevoArbolGeneral1<>('1'));
        arbol3 = new NuevoArbolGeneral1<>('6', arbol1, arbol2, new NuevoArbolGeneral1<>('5'));
        arbol4 = new NuevoArbolGeneral1<>('7', arbol3);
    }

    public static <E> boolean identicos(ArbolGeneral<E> a, ArbolGeneral<E> b){
        if (a.esVacio() && b.esVacio())
            return true;
        if (!a.esVacio() && !b.esVacio())
            if (!a.raiz().equals(b.raiz())) return false;
            else {
                ArbolGeneral<E> ha = a.hijoMasIzq();
                ArbolGeneral<E> hb = b.hijoMasIzq();
                while (!ha.esVacio() && !hb.esVacio())
                {
                    if (!identicos(ha,hb)) return false;
                    ha = ha.hermanoDer();
                    hb = hb.hermanoDer();
                }
                return ha.esVacio() && hb.esVacio();
            }
        return false;                    
    }

    public NuevoArbolGeneral1Test() {
    }

    
    /**
     * Test of esVacio method, of class NuevoArbolGeneral.
     */
    @Test
    public void testEsVacio() {
        System.out.println("esVacio");
        NuevoArbolGeneral1 instance = new NuevoArbolGeneral1();
        boolean expResult = true;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
    }
    @Test
    public void testEsVacioFalse() {
        System.out.println("esVacio");
        NuevoArbolGeneral1<Character> instance = arbol1;
        boolean expResult = false;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
    }

    /**
     * Test of raiz method, of class NuevoArbolGeneral.
     */
    @Test(expected=ArbolVacioExcepcion.class)
    public void testRaiz() {
        System.out.println("raiz");
        NuevoArbolGeneral1<Character> instance = new NuevoArbolGeneral1();
        Character result = instance.raiz();
        
    }
    @Test
    public void testRaiz2() {
        System.out.println("raiz");
        NuevoArbolGeneral1<Character> instance = arbol1;
        Character result = instance.raiz();
        Character expResult = '4';
        assertEquals(expResult, result);
    }
    @Test
    public void testRaiz3() {
        System.out.println("raiz");
        NuevoArbolGeneral1<Character> instance = arbol1;
        Character result = instance.raiz();
        Character expResult = '6';
        assertNotEquals(expResult, result);
    }

    /**
     * Test of esta method, of class NuevoArbolGeneral.
     */
    @Test
    public void testEstaVacio() {
        System.out.println("esta");
        NuevoArbolGeneral1<Character> instance = new NuevoArbolGeneral1<>();
        Character elemento = '6';
        boolean result = instance.esta(elemento);
        assertFalse(result);
    }
     @Test
    public void testEstaTrue() {
        System.out.println("esta");
        NuevoArbolGeneral1<Character> instance = arbol4;
        Character elemento = '1';
        boolean result = instance.esta(elemento);
        assertTrue(result);
    }
     @Test
    public void testEstaFalse() {
        System.out.println("esta");
        NuevoArbolGeneral1<Character> instance = arbol4;
        Character elemento = '8';
        boolean result = instance.esta(elemento);
        assertFalse(result);
    }

    /**
     * Test of hijoMasIzq method, of class NuevoArbolGeneral.
     */
    @Test (expected=ArbolVacioExcepcion.class)
    public void testHijoMasIzq() {
        System.out.println("hijoMasIzq");
        NuevoArbolGeneral1<Character> instance = new NuevoArbolGeneral1<>();
        instance.hijoMasIzq();
    }
    @Test
    public void testHijoMasIzqTrue() {
        System.out.println("hijoMasIzq");
        ArbolGeneral<Character> instance = arbol4;
        ArbolGeneral<Character> expResult = arbol3;
        ArbolGeneral<Character> result = instance.hijoMasIzq();
        assertTrue(identicos(expResult, result));
        
    }
    @Test
    public void testHijoMasIzqFalse() {
        System.out.println("hijoMasIzq");
        ArbolGeneral<Character> instance = arbol4;
        ArbolGeneral<Character> expResult = arbol2;
        ArbolGeneral<Character> result = instance.hijoMasIzq();
        assertFalse(identicos(expResult, result));
        
    }

    /**
     * Test of hermanoDer method, of class NuevoArbolGeneral.
     */
    @Test (expected=ArbolVacioExcepcion.class)
    public void testHermanoDer() {
        System.out.println("hijoMasDer");
        ArbolGeneral<Character> instance = new NuevoArbolGeneral1<>();;
        ArbolGeneral<Character> expResult = arbol2;
        ArbolGeneral<Character> result = instance.hermanoDer();
        assertTrue(identicos(expResult, result));
    }
    @Test
    public void testHermanoDerTrue() {
        System.out.println("hijoMasDer");
        ArbolGeneral<Character> instance = arbol1;
        ArbolGeneral<Character> expResult = arbol2;
        ArbolGeneral<Character> result = instance.hermanoDer();
        assertTrue(identicos(expResult, result));
    }
    @Test
    public void testHermanoDerFlse() {
        System.out.println("hijoMasDer");
        ArbolGeneral<Character> instance = arbol3;
        ArbolGeneral<Character> expResult = arbol2;
        ArbolGeneral<Character> result = instance.hermanoDer();
        assertFalse(identicos(expResult, result));
    }

    /**
     * Test of setRaiz method, of class NuevoArbolGeneral.
     */
    @Test (expected=ArbolVacioExcepcion.class)
    public void testSetRaiz() {
        System.out.println("setRaiz");
        Character elemRaiz = '2';
        ArbolGeneral<Character> instance = new NuevoArbolGeneral1();
        instance.setRaiz(elemRaiz);
   }
     @Test 
    public void testSetRaizTrue() {
        System.out.println("setRaiz");
        Character elemRaiz = '8';
        ArbolGeneral<Character> result = new NuevoArbolGeneral1<>('8', new NuevoArbolGeneral1<>('1')); 
        ArbolGeneral<Character> instance = arbol2;
        instance.setRaiz(elemRaiz);
        assertTrue(identicos(instance, result));
    }
     @Test 
    public void testSetRaizFalse() {
        System.out.println("setRaiz");
        Character elemRaiz = '8';
        ArbolGeneral<Character> result = new NuevoArbolGeneral1<>('2', new NuevoArbolGeneral1<>('1')); 
        ArbolGeneral<Character> instance = arbol2;
        instance.setRaiz(elemRaiz);
        assertFalse(identicos(instance, result));
    }

    /**
     * Test of setHijo method, of class NuevoArbolGeneral.
     */
    @Test(expected=ArbolVacioExcepcion.class)
    public void testSetHijo() {
        System.out.println("setHijo");
        ArbolGeneral instance = new NuevoArbolGeneral1();
        instance.setHijo(arbol);
    }
    @Test
    public void testSetHijoTrue() {
        System.out.println("setHijo");
        ArbolGeneral<Character> instance = arbol2;
        ArbolGeneral<Character> hijo = new NuevoArbolGeneral1<>('8');
        ArbolGeneral<Character> expResult =  new NuevoArbolGeneral1<>('3', new NuevoArbolGeneral1<>('1'), new NuevoArbolGeneral1<>('8'));
        instance.setHijo(hijo);
        assertTrue(identicos(instance, expResult));
    }
     @Test
    public void testSetHijoFalse() {
        System.out.println("setHijo");
        ArbolGeneral<Character> instance = arbol2;
        ArbolGeneral<Character> hijo = new NuevoArbolGeneral1<>('8');
        ArbolGeneral<Character> expResult =  new NuevoArbolGeneral1<>('3', new NuevoArbolGeneral1<>('8'), new NuevoArbolGeneral1<>('1'));
        instance.setHijo(hijo);
        assertFalse(identicos(instance, expResult));
    }

    /**
     * Test of suprimir method, of class NuevoArbolGeneral.
     */
    @Test
    public void testSuprimir() {
        System.out.println("suprimir");
        ArbolGeneral instance = new NuevoArbolGeneral1();
        instance.suprimir();
        assertTrue(identicos(instance, new NuevoArbolGeneral1()));
    }
     @Test
    public void testSuprimir2() {
        System.out.println("suprimir");
        ArbolGeneral instance = arbol4;
        instance.suprimir();
        assertTrue(identicos(instance, new NuevoArbolGeneral1()));
    }
    
}
