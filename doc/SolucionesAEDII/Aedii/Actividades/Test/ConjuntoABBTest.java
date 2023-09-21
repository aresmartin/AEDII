
package solactividad4;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ConjuntoABBTest {
    
    ConjuntoABB<Integer> instance;
    
    private static int[] conjunto2Array(Conjunto<Integer> c){
        int[] toret = new int[c.cardinal()];
        int i = 0;
        while (c.cardinal()!=0){
            int elemento = c.elige();
            c.elimina(elemento);
            toret[i++] = elemento;
	}
        return toret;
    }
    private static Conjunto<Integer> array2Conjunto(int[] array){
        Conjunto<Integer> conjunto = new ConjuntoABB();
        for(int i: array)
            conjunto.inserta(i);
        return conjunto;
    }
            
    @Before
    public void setUp()throws Exception{
        instance = new ConjuntoABB();
        int[] array = {1,2,3};
        for(int i: array)
            instance.inserta(i);
    }
    /**
     * Test of cardinal method, of class ConjuntoABB.
     */
    @Test
    public void testCardinal() {
        System.out.println("cardinal");
        int expResult = 3;
        int result = instance.cardinal();
        assertEquals(expResult, result);
    }

    /**
     * Test of pertenece method, of class ConjuntoABB.
     */
    @Test
    public void testPertenece() {
        System.out.println("pertenece");
        Integer x = 3;
        boolean expResult = true;
        boolean result = instance.pertenece(x);
        assertEquals(expResult, result);
    }
    @Test
    public void testPerteneceFalse() {
        System.out.println("no pertenece");
        Integer x = 4;
        boolean expResult = false;
        boolean result = instance.pertenece(x);
        assertEquals(expResult, result);
    }

    /**
     * Test of inserta method, of class ConjuntoABB.
     */
    @Test
    public void testInserta() {
        System.out.println("inserta");
        Integer x = 4;
        boolean expResult = true;
        boolean result = instance.inserta(x);
        assertEquals(expResult, result);
    }
    @Test
    public void testInsertaFalse() {
        System.out.println("no inserta");
        Integer x = 3;
        boolean expResult = false;
        boolean result = instance.inserta(x);
        assertEquals(expResult, result);
    }

    /**
     * Test of elimina method, of class ConjuntoABB.
     */
    @Test
    public void testElimina() {
        System.out.println("elimina");
        Integer x = 3;
        boolean expResult = true;
        boolean result = instance.elimina(x);
        assertEquals(expResult, result);
    }
    @Test
    public void testEliminaFalse() {
        System.out.println("elimina");
        Integer x = 4;
        boolean expResult = false;
        boolean result = instance.elimina(x);
        assertEquals(expResult, result);
    }

    /**
     * Test of elige method, of class ConjuntoABB.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testElige() {
        System.out.println("elige");
        instance = new ConjuntoABB<>();
        Integer result = instance.elige();
    }

    @Test
    public void testElige2() {
        System.out.println("elige");
        Integer expResult = 1;
        Integer result = instance.elige();
        assertEquals(expResult, result);
    }
        
    /**
     * Test of union method, of class ConjuntoABB.
     */
    @Test
    public void testUnion() {
        System.out.println("union");
        int[] elementos = {1,2,3,4};
        Conjunto instance2 = array2Conjunto(elementos);
         //hago la unión instance U instance2
        Conjunto result = instance.union(instance2);
        //creo el conjunto esperado
        int[] array = {1,2,3,4};
        Conjunto expResult = array2Conjunto(array);
        // los paso a array para compararlos
        Assert.assertArrayEquals(conjunto2Array(expResult), conjunto2Array(result));
    }

    /**
     * Test of interseccion method, of class ConjuntoABB.
     */
    @Test
    public void testInterseccion() {
        System.out.println("interseccion");
        int[] elementos = {1,2,3,4};
        Conjunto instance2 = array2Conjunto(elementos);
        //hago la intersección instance instance2
        Conjunto result = instance.interseccion(instance2);
        //creo el conjunto esperado
        int[] array = {1,2,3};
        Conjunto expResult = array2Conjunto(array);
        // los paso a array para compararlos
        Assert.assertArrayEquals(conjunto2Array(expResult), conjunto2Array(result));
    }

    /**
     * Test of diferencia method, of class ConjuntoABB.
     */
    @Test
    public void testDiferencia() {
        System.out.println("diferencia");
        int[] elementos = {1,2,3,4};
        Conjunto instance2 = array2Conjunto(elementos);
        //hago la intersección instance2 instance
        Conjunto result = instance2.diferencia(instance);
        //creo el conjunto esperado
        int[] array = {4};
        Conjunto expResult = array2Conjunto(array);
        // los paso a array para compararlos
        Assert.assertArrayEquals(conjunto2Array(expResult), conjunto2Array(result));
    }
    
}
