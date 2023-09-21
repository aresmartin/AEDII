package actividad6;

import static org.junit.Assert.*;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class MapPolinomioTest {
    
    public MapPolinomioTest() {
    }
    public static boolean iguales (Polinomio p, Polinomio q){
        if (p.grado() != q.grado())
            return false;
        else {
            for(int i = p.grado(); i >= 0 ; i--){
                if (p.coeficiente(i) != q.coeficiente(i))
                    return false;
            }
            return true;
        }
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    /**
     * Test of grado method, of class MapPolinomio.
     */
    @Test
    public void testGrado() {
        System.out.println("testGrado");
        MapPolinomio instance = new MapPolinomio();
        int expResult = 0;
        int result = instance.grado();
        assertEquals(expResult, result);
    }
    @Test
    public void testGrado2() {
        System.out.println("testGrado2");
        MapPolinomio instance = new MapPolinomio();
        instance.añadirTermino(2, 6);
        int expResult = 2;
        int result = instance.grado();
        assertEquals(expResult, result);
    }
    @Test
    public void testGrado3() {
        System.out.println("testGrado3");
        MapPolinomio instance = new MapPolinomio();
        instance.añadirTermino(2, 6);
        instance.añadirTermino(2, -6);
        int expResult = 0;
        int result = instance.grado();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of coeficiente method, of class MapPolinomio.
     */
    @Test
    public void testCoeficiente() {
        System.out.println("testCoeficiente");
        int n = 0;
        MapPolinomio instance = new MapPolinomio();
        double expResult = 0.0;
        double result = instance.coeficiente(n);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testCoeficiente2() {
        System.out.println("testCoeficiente2");
        int n = 1;
        MapPolinomio instance = new MapPolinomio();
        instance.añadirTermino(2, 6);
        instance.añadirTermino(1, -7);
        instance.añadirTermino(0, 5);
        double expResult = -7.0;
        double result = instance.coeficiente(n);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testCoeficiente3() {
        System.out.println("testCoeficiente3");
        int n = 3;
        MapPolinomio instance = new MapPolinomio();
        instance.añadirTermino(2, 6);
        instance.añadirTermino(1, -7);
        instance.añadirTermino(0, 5);
        double expResult = 0.0;
        double result = instance.coeficiente(n);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testCoeficiente4() {
        System.out.println("testCoeficiente4");
        int n = 1;
        MapPolinomio instance = new MapPolinomio();
        instance.añadirTermino(2, 6);
        instance.añadirTermino(1, -7);
        instance.añadirTermino(0, 5);
        instance.añadirTermino(1, 7);
        double expResult = 0.0;
        double result = instance.coeficiente(n);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of añadirTermino method, of class MapPolinomio.
     */
    @Test//(expected = IllegalArgumentException.class)
    public void testAñadirTermino() {
        System.out.println("añadirTermino exponente negativo");
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(CoreMatchers.containsString("añadirTermino: IllegalArgumentException"));
        int exponente = -2;
        double coeficiente = 3.0;
        MapPolinomio instance = new MapPolinomio();
        instance.añadirTermino(exponente, coeficiente);   
    }
    
    @Test//(expected = IllegalArgumentException.class)
    public void testAñadirTermino2() {
        System.out.println("añadirTermino coeficiente 0");
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(CoreMatchers.containsString("añadirTermino: IllegalArgumentException"));
        int exponente = 4;
        double coeficiente = 0.0;
        MapPolinomio instance = new MapPolinomio();
        instance.añadirTermino(exponente, coeficiente);
    }
      

    /**
     * Test of eliminarTermino method, of class MapPolinomio.
     */
    @Test
    public void testEliminarTermino() {
        System.out.println("testEliminarTermino");
        int exponente = 0;
        MapPolinomio instance = new MapPolinomio();
        instance.eliminarTermino(exponente);
    }
    @Test
    public void testEliminarTermino2() {
        System.out.println("testEliminarTermino2");
        int exponente = 0;
        MapPolinomio instance = new MapPolinomio();
        instance.añadirTermino(2, 6);
        instance.añadirTermino(1, -7);
        instance.añadirTermino(0, 5);
        instance.eliminarTermino(1);
        double expResult = 0.0;
        double result = instance.coeficiente(1);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of suma method, of class MapPolinomio.
     */
    @Test
    public void testSuma() {
        System.out.println("suma");
        Polinomio p = new MapPolinomio();
        p.añadirTermino(2, 6);
        p.añadirTermino(1, -7);
        p.añadirTermino(0, 5);
        MapPolinomio instance = new MapPolinomio();
        instance.añadirTermino(2, -6);
        instance.añadirTermino(1, 7);
        instance.añadirTermino(0, -5);
        Polinomio result = instance.suma(p);
        Polinomio expResult = new MapPolinomio();
        iguales(expResult, result);
    }
    @Test
    public void testSuma2() {
        System.out.println("testSuma2");
        Polinomio p = new MapPolinomio();
        p.añadirTermino(2, 6);
        p.añadirTermino(1, -7);
        p.añadirTermino(0, 5);
        MapPolinomio instance = new MapPolinomio();
        instance.añadirTermino(3, 5);
        instance.añadirTermino(1, 6);
        instance.añadirTermino(0, -3);
        Polinomio result = instance.suma(p);
        Polinomio expResult = new MapPolinomio();
        expResult.añadirTermino(3, 5);
        expResult.añadirTermino(2, 6);
        expResult.añadirTermino(1, -1);
        expResult.añadirTermino(0, 2);
        iguales(expResult, result);
    }
    /**
     * Test of derivada method, of class MapPolinomio.
     */
    @Test
    public void testDerivada() {
        System.out.println("derivada");
        MapPolinomio instance = new MapPolinomio();
        instance.añadirTermino(3, 5);
        instance.añadirTermino(1, 6);
        instance.añadirTermino(0, -3);
        Polinomio result = instance.derivada();
        Polinomio expResult = new MapPolinomio();
        expResult.añadirTermino(2, 15);
        expResult.añadirTermino(0, 6);
        iguales(expResult, result);   
    }
}
