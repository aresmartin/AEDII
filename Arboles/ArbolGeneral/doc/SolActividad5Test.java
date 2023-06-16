
package solactividad5;

import solactividad5.SolActividad5;
import arbolGeneral.ArbolGeneral;
import arbolGeneral.EnlazadoArbolGeneral;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
 */
public class SolActividad5Test {
    
    ArbolGeneral<Integer> arbol1 =new EnlazadoArbolGeneral<>(4, new EnlazadoArbolGeneral<>(2));
    ArbolGeneral<Integer> arbol2 =new EnlazadoArbolGeneral<>(3, new EnlazadoArbolGeneral<>(1));
    ArbolGeneral<Integer> arbol3 =new EnlazadoArbolGeneral<>(6, arbol1, arbol2, new EnlazadoArbolGeneral<>(5));
    ArbolGeneral<Integer> arbol4 =new EnlazadoArbolGeneral<>(7, arbol3);
    
    ArbolGeneral<Integer> arbolDos =new EnlazadoArbolGeneral<>(1, new EnlazadoArbolGeneral<>(2), new EnlazadoArbolGeneral<>(1));
    ArbolGeneral<Integer> arbolTres =new EnlazadoArbolGeneral<>(1, arbolDos, new EnlazadoArbolGeneral<>(3), new EnlazadoArbolGeneral<>(5));
    ArbolGeneral<Integer> arbol =new EnlazadoArbolGeneral<>(4,new EnlazadoArbolGeneral<>(3), new EnlazadoArbolGeneral<>(3), new EnlazadoArbolGeneral<>(5), new EnlazadoArbolGeneral<>(6));
    ArbolGeneral<Integer> arbolCuatro =new EnlazadoArbolGeneral<>(4, arbol, new EnlazadoArbolGeneral<>(3), new EnlazadoArbolGeneral<>(5), new EnlazadoArbolGeneral<>(6));
    
    ArbolGeneral<Integer> no23 = new EnlazadoArbolGeneral<>(1, new EnlazadoArbolGeneral<>(2, new EnlazadoArbolGeneral<>(3), new EnlazadoArbolGeneral<>(4)));
    
    /**
     * Test of sumaNodos method, of class SolActividad5.
     */
    @Test
    public void testSumaNodosTrue() {
        System.out.println("suma nodos bien");
        int expResult = 0;
        int result = SolActividad5.sumaNodos(arbol4);
        assertNotEquals(expResult, result);
    }
    @Test
    public void testSumaNodosFalse() {
        System.out.println("suma nodos mal");
        int expResult = 28;
        int result = SolActividad5.sumaNodos(arbol4);
        assertEquals(expResult, result);
    }

    /**
     * Test of igualEstructura method, of class SolActividad5.
     */
    @Test
    public void testIgualEstructuraTrue() {
        System.out.println("igual Estructura");
        boolean result = SolActividad5.igualEstructura(arbol1, arbol2);
        assertTrue(result);
    }
    @Test
    public void testIgualEstructuraFalse() {
        System.out.println("distinta Estructura");
        boolean result = SolActividad5.igualEstructura(arbol1, arbol4);
        assertFalse(result);
    }

    /**
     * Test of arbolDosTres method, of class SolActividad5.
     */
    @Test
    public void testArbolDosTresTrue() {
        System.out.println("arbolDosTres si");
        boolean result = SolActividad5.arbolDosTres(arbolTres);
        assertTrue(result);
    }
    @Test
    public void testArbolDosTresFalse() {
        System.out.println("arbolDosTres no");
        boolean result = SolActividad5.arbolDosTres(arbol4);
        assertFalse(result);
    }
    @Test
    public void testArbolDosTresFalse2() {
        System.out.println("arbolDosTres no");
        boolean result = SolActividad5.arbolDosTres(no23);
        assertFalse(result);
    }

    /**
     * Test of esSeleccion method, of class SolActividad5.
     */
    @Test
    public void testEsSeleccionTrue() {
        System.out.println("esSeleccion si");
        boolean result = SolActividad5.esSeleccion(arbolTres);
        assertTrue(result);
    }
    @Test
    public void testEsSeleccionFalse() {
        System.out.println("esSeleccion no");
        boolean result = SolActividad5.esSeleccion(arbol4);
        assertFalse(result);
    }
    @Test
    public void testEsSeleccionFalse2() {
        System.out.println("esSeleccion no");
        boolean result = SolActividad5.esSeleccion(no23);
        assertFalse(result);
    }

    /**
     * Test of nivel method, of class SolActividad5.
     */
    @Test
    public void testNivelCero() {
        System.out.println("nivel cero");
        int expResult = 0;
        int result = SolActividad5.nivel(arbol4, 7);
        assertEquals(expResult, result);
    }
    @Test
    public void testNivelUno() {
        System.out.println("nivel uno");
        int expResult = 2;
        int result = SolActividad5.nivel(arbol4, 3);
        assertEquals(expResult, result);
    }
    @Test
    public void testNivelN() {
        System.out.println("nivel N");
        int expResult = 3;
        int result = SolActividad5.nivel(arbol4, 1);
        assertEquals(expResult, result);
    }

    /**
     * Test of grado method, of class SolActividad5.
     */
    @Test
    public void testGradoUno() {
        System.out.println("grado");
        int expResult = 1;
        int result = SolActividad5.grado(arbol1);
        assertEquals(expResult, result);
    }
    @Test
    public void testGradoTres() {
        System.out.println("grado");
        int expResult = 3;
        int result = SolActividad5.grado(arbol4);
        assertEquals(expResult, result);
    }

    /**
     * Test of altura method, of class SolActividad5.
     */
    @Test
    public void testAlturaDos() {
        System.out.println("altura");
        int expResult = 2;
        int result = SolActividad5.altura(arbolTres);
        assertEquals(expResult, result);
    }
    @Test
    public void testAlturaTres() {
        System.out.println("altura");
        int expResult = 3;
        int result = SolActividad5.altura(arbol4);
        assertEquals(expResult, result);
    }
    

    /**
     * Test of anchura method, of class SolActividad5.
     */
    @Test
    public void testAnchuraTrue() {
        System.out.println("anchura si");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps); // Esto hace que System.out escriba en "output" en lugar de escribir por consola
        SolActividad5.anchura(arbol4);
        String written = output.toString(); // Este toString recupera lo escrito en "output"
        assertEquals("7 6 4 3 5 2 1 ", written);
    }
    @Test
    public void testAnchuraFalse() {
        System.out.println("anchura no");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps); // Esto hace que System.out escriba en "output" en lugar de escribir por consola
        SolActividad5.anchura(arbol4);
        String written = output.toString(); // Este toString recupera lo escrito en "output"
        assertNotEquals("7 6 4 3 2 1", written);
    }

    /**
     * Test of numNodosPares method, of class SolActividad5.
     */
    @Test
    public void testNumNodosParesTres() {
        System.out.println("numNodosPares");
        int expResult = 3;
        int result = SolActividad5.numNodosPares(arbol4);
        assertEquals(expResult, result);
    }
    @Test
    public void testNumNodosParesUno() {
        System.out.println("numNodosPares");
        int expResult = 1;
        int result = SolActividad5.numNodosPares(arbolTres);
        assertEquals(expResult, result);
    }

    /**
     * Test of hojas method, of class SolActividad5.
     */
    @Test
    public void testHojasUna() {
        System.out.println("hojas una");
        List<Integer> result = new LinkedList<>();
        List<Integer> expResult = Arrays.asList(2);
        SolActividad5.hojas(arbol1, result);
        assertEquals(expResult, result);
    }
    public void testHojasCuatro() {
        System.out.println("hojas cuatro");
        List<Integer> result = new LinkedList<>();
        List<Integer> expResult = Arrays.asList(2,1,3,5);
        SolActividad5.hojas(arbol1, result);
        assertEquals(expResult, result);
    }
    
}
