package solactividad4;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class HeapTest {
     Heap<Integer> heapVacio = new Heap<>(Integer.class, Integer.MAX_VALUE); 
     Heap<Integer> heapPrueba = new Heap<>(Integer.class, Integer.MAX_VALUE); 
     	  
      
    @Before
    public void setUp() throws Exception {
        heapPrueba.insertar(14);
        heapPrueba.insertar(6);
        heapPrueba.insertar(5);
        heapPrueba.insertar(8);
        heapPrueba.insertar(1);
        heapPrueba.insertar(3);
        heapPrueba.insertar(12);
        heapPrueba.insertar(9);
        heapPrueba.insertar(7);
        heapPrueba.insertar(13);
        heapPrueba.insertar(2);
    }
    
    @Test
    public void testEsVacioTrue() {
        System.out.println("esVacioTrue");
        boolean expResult = true;
        boolean result = heapVacio.esVacio();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEsVacioFalse() {
        System.out.println("esVacioFalse");
        boolean expResult = false;
        boolean result = heapPrueba.esVacio();
        assertEquals(expResult, result);
    }

    /**
     * Test of recuperarMax method, of class Heap.
     */
    @Test(expected=HeapVacioExcepcion.class)
    public void testRecuperarMaxVacio() {
        System.out.println("recuperarMaxVacio");
        Integer result = heapVacio.recuperarMax();
    }
    @Test
    public void testRecuperarMax() {
        System.out.println("recuperarMax");
        Integer result = heapPrueba.recuperarMax();
        Integer expResult = 14;
        assertEquals(expResult, result);
    }
    /**
     * Test of suprimirMax method, of class Heap.
     */
    @Test (expected=HeapVacioExcepcion.class)
    public void testSuprimirMaxVacio() {
        System.out.println("suprimirMaxVacio");
        Integer result = heapVacio.recuperarMax();
    }
    @Test 
    public void testSuprimirMax() {
        Integer expResult = 12;
        Integer result = heapPrueba.suprimirMax();
        result = heapPrueba.suprimirMax();
        result = heapPrueba.suprimirMax();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertar method, of class Heap.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Integer e = 15;
        heapPrueba.insertar(e);
        Integer result = heapPrueba.recuperarMax();
        assertEquals(e, result);    
    }
    
    
}
