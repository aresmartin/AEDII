/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad6;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author AEDII
 */
public class ExtendAbreviaturasTest {
    
   
    @Before
    public void setUp() {
 
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of traduccionAbreviaturas method, of class ExtenderAbreviaturas.
     */
    @Test
    public void testTraduccionAbreviaturasIngles() {
        System.out.println("traduccionAbreviaturas inglés");
        String textoIngles = "This is Gd. ";
        String idioma = "en";
        String expResult = "This is good ";
        String result = ExtendAbreviaturas.extensionAbreviaturas(textoIngles, idioma);
        assertEquals(expResult, result);
    }

    /**
     * Test of traduccionAbreviaturas method, of class ExtenderAbreviaturas.
     */
    @Test
    public void testTraduccionAbreviaturasEspañol() {
        System.out.println("traduccionAbreviaturas español");
        String textoEspañol = "Hola D. Pepito, Hola D. José ";
        String idioma = "es";
        String expResult = "Hola don Pepito, Hola don José ";
        String result = ExtendAbreviaturas.extensionAbreviaturas(textoEspañol, idioma);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of traduccionAbreviaturas method, of class ExtenderAbreviaturas.
     */
    @Test
    public void testTraduccionAbreviaturasFrances() {
        System.out.println("traduccionAbreviaturas francés");
        String textoFrances = "Bonjour Dr Pepito, bonjour Dr José ";
        String idioma = "fr";
        String expResult = "Bonjour docteur Pepito, bonjour docteur José ";
        String result = ExtendAbreviaturas.extensionAbreviaturas(textoFrances, idioma);
        assertEquals(expResult, result);
    }
}
