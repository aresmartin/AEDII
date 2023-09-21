/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad1;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author 
 */
public class SolActividad1Test {

        
    /**
     * Test of factorial method, of class SolActividad1.
     */
    @Test
    public void testFactorial0() {
        System.out.println("factorial de 0");
        int n = 0;
        int expResult = 1;
        int result = SolActividad1.factorial(n);
        assertEquals(expResult, result);
    }
    public void testFactorial4() {
        System.out.println("factorial de 4");
        int n = 4;
        int expResult = 24;
        int result = SolActividad1.factorial(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of cuadrado method, of class SolActividad1.
     */
    @Test
    public void testCuadrado0() {
        System.out.println("cuadrado de 0");
        int n = 0;
        int expResult = 0;
        int result = SolActividad1.cuadrado(n);
        assertEquals(expResult, result);
    }
    public void testCuadrado4() {
        System.out.println("cuadrado de 4");
        int n = 4;
        int expResult = 16;
        int result = SolActividad1.cuadrado(n);
        assertEquals(expResult, result);
    }
    /**
     * Test of visualizar method, of class SolActividad1.
     */
    @Test
    public void testsumarDigitos() {
        System.out.println("sumar los dígitos del 1369");
        int n = 1369;
        int expResult = 19;
        int result = SolActividad1.sumarDigitos(n);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testVisualizarDigitos() {    
        System.out.println("visualizar los dígitos del 1369");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream((output));
        System.setOut(ps); // Esto hace que System.out escriba en "output" en lugar de escribir por consola
        SolActividad1.visualizarDigitos(1369);
        String written = output.toString(); // Este toString recupera lo  escrito en "output"
        assertEquals("1369", written);
    }
    
    /**
     * Test of euclides method, of class SolActividad1.
     */
    
    @Test
    public void testEuclides() {
        System.out.println("máximo común divisor 36 y 60");
        int n1 = 36;
        int n2 = 60;
        int expResult = 12;
        int result = SolActividad1.euclides(n1, n2);
        assertEquals(expResult, result);
   }

    /**
     * Test of palindromo method, of class SolActividad1.
     */
    @Test
    public void testPalindromoTrue() {
        System.out.println("palindromo cierto");
        String cadena = "dabalearrozalazorraelabad";
        boolean expResult = true;
        boolean result = SolActividad1.palindromo(cadena);
        assertEquals(expResult, result);
    }
    @Test
    public void testPalindromoTrue2() {
        System.out.println("palindromo cierto 2");
        String cadena = "dabalearrozaazorraelabad";
        boolean expResult = true;
        boolean result = SolActividad1.palindromo(cadena);
        assertEquals(expResult, result);
    }
    @Test
    public void testPalindromoFalse() {
        System.out.println("palindromo falso");
        String cadena = "dabalearrozabzorraelabad";
        boolean expResult = false;
        boolean result = SolActividad1.palindromo(cadena);
        assertEquals(expResult, result);
    }
    @Test
    public void sumarValoresArrayTest() {
        System.out.println("sumarArray");
        int[] vector = {1,2,3,4,5};
        int expResult = 15;
        int result = SolActividad1.sumarValoresArray(vector);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of invertirArray method, of class SolActividad1.
     */
    @Test
    public void testInvertirArray() {
        System.out.println("invertirArray ");
        int[] vector = {1,2,3,4,5,6,7,8,9};
        int[] resultado = {9,8,7,6,5,4,3,2,1};
        SolActividad1.invertirArray(vector);
        assertArrayEquals(vector, resultado);
    }
    @Test
    public void testInvertirArray2() {
        System.out.println("invertirArray ");
        int[] vector = {1,2,3,4,5,6,7,8,9};
        int[] expResul = {9,8,7,6,5,4,3,2,1};
        SolActividad1.invertirArray2(vector);
        assertArrayEquals(expResul, vector);
    }
    @Test
    public void testInvertirArray3() {
        System.out.println("invertirArray ");
        int[] vector = {5,6,7,8,9};
        int[] expResul = {9,8,7,6,5};
        int[] result = SolActividad1.invertirArray3(vector);
        assertArrayEquals(expResul, result);
    }
    
    /**
     * Test of menorArray method, of class SolActividad1.
     */
    
    @Test
    public void menorArrayTest() {
        System.out.println("menorArray");
        int[] vector = {10,20,30,40,5};
        int expResult = 5;
        int result = SolActividad1.menorArray(vector);
        assertEquals(expResult, result);
    }
    
    @Test
    public void menorArrayTest2() {
        System.out.println("menorArray");
        int[] vector = {1,20,30,40,5};
        int expResult = 1;
        int result = SolActividad1.menorArray2(vector);
        assertEquals(expResult, result);
    }
    @Test
    public void menorArrayTest3() {
        System.out.println("menorArray");
        int[] vector = {1,20,30,40,5};
        int expResult = 1;
        int result = SolActividad1.menorArray3(vector);
        assertEquals(expResult, result);
    }
     @Test
    public void menorArrayTest4() {
        System.out.println("menorArray");
        int[] vector = {1,20,30,40,5};
        int expResult = 1;
        int result = SolActividad1.menorArray4(vector);
        assertEquals(expResult, result);
    }

    /**
     * Test of busquedaBinaria method, of class SolActividad1.
     */
    @Test
    public void testBusquedaBinariaFalse() {
        System.out.println("busquedaBinaria");
        double [] array = {10.5,20.3,3.2,4.0,5.1};
        int inicio = 0;
        int fin = array.length -1;
        double elemento = 0.0;
        int expResult = -1;
        int result = SolActividad1.busquedaBinaria(array, inicio, fin, elemento);
        assertEquals(expResult, result);
    }
    @Test
    public void testBusquedaBinariaTruee() {
        System.out.println("busquedaBinaria");
        double [] array = {10.5,20.3,3.2,4.0,5.1};
        int inicio = 0;
        int fin = array.length -1;
        double elemento = 3.2;
        int expResult = 2;
        int result = SolActividad1.busquedaBinaria(array, inicio, fin, elemento);
        assertEquals(expResult, result);
    }

     /**
     * Test of copiar method, of class SolActividad1.
     */
    @Test
    public void testCopiar() {
        System.out.println("copiar");
        Stack<Integer> expResult = new Stack<>();
        expResult.push(1);
        expResult.push(2);
        Stack result = SolActividad1.copiar(expResult);
        assertEquals(expResult, result);
        
    }
}
