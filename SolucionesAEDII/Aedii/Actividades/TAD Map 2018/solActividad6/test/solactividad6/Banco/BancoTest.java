/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad6.Banco;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BancoTest {
    Banco b = new Banco();
    
    
    
    @Before
    public void setUp() {
        b.crearCuenta(1212121212, "Titular 1");
        b.crearCuenta(1353536523, "Titular 2");
                
        b.depositar(1212121212,new java.sql.Date(System.currentTimeMillis()), "Ingreso a cuenta", 2000);
        b.depositar(1353536523,new java.sql.Date(System.currentTimeMillis()), "Ingreso a cuenta", 3000);
        b.transferencia(1212121212, 1353536523, new java.sql.Date(System.currentTimeMillis()), 1000);
        b.retirar(1212121212, new java.sql.Date(System.currentTimeMillis()), "Retirada de dinero", 500);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crearCuenta method, of class Banco.
     */
    @Test
    public void testCrearCuenta() {
        System.out.println("crearCuenta");
        int codigo = 1345362334;
        String titular = "Titular 3";
        
        b.crearCuenta(codigo, titular);
        String expResult="1212121212---500.0\n1353536523---4000.0\n1345362334---0.0\n";
        assertEquals(expResult,b.toString());
    }

    /**
     * Test of obtenerBalance method, of class Banco.
     */
    @Test
    public void testObtenerBalance_int() {
        System.out.println("obtenerBalance");
        int codigo = 1212121212;
       
        float expResult = 500.0F;
        float result = b.obtenerBalance(codigo);
        assertEquals(expResult, result, 500.0);
        
    }

    /**
     * Test of depositar method, of class Banco.
     */
    @Test
    public void testDepositar() {
        System.out.println("depositar");
        int codigo = 1212121212;
        Date fecha = new java.sql.Date(System.currentTimeMillis());
        String concepto = "Ingreso de 100 euros";
        float cantidad = 100.0F;
        
        boolean expResult = true;
        boolean result = b.depositar(codigo, fecha, concepto, cantidad);
        assertEquals(expResult, result);
        Float saldo=b.obtenerBalance(codigo);
        Float expCantidad=new Float(600.0);
        assertEquals(saldo,expCantidad);
    }

    /**
     * Test of retirar method, of class Banco.
     */
    @Test
    public void testRetirar() {
        System.out.println("retirar");
        int codigo = 1212121212;
        Date fecha = new java.sql.Date(System.currentTimeMillis());
        String concepto = "Retirar 100 euros";
        float cantidad = 100.0F;
        b.retirar(codigo, fecha, concepto, cantidad);
        
        Float saldo=b.obtenerBalance(codigo);
        Float expCantidad=new Float(400.0);
        assertEquals(saldo,expCantidad);
    }

    /**
     * Test of transferencia method, of class Banco.
     */
    @Test
    public void testTransferencia() {
        System.out.println("transferencia");
        int codigo1 = 1212121212;
        int codigo2 = 1353536523;
        
        Date fecha = new java.sql.Date(System.currentTimeMillis());
        
        float cantidad = 100.0F;
        boolean result = b.transferencia(codigo1, codigo2, fecha, cantidad);
        
        Float saldo1=b.obtenerBalance(codigo1);
        Float saldo2=b.obtenerBalance(codigo2);
        Float expCantidad1=new Float(400.0);
        Float expCantidad2=new Float(4100.0);
        
        assertEquals(result,true);
        assertEquals(saldo1, expCantidad1);
        assertEquals(saldo2, expCantidad2);
        
    }

    /**
     * Test of obtenerBalance method, of class Banco.
     */
   /* @Test
    public void testObtenerBalance_int_Date() {
        System.out.println("obtenerBalance");
        java.sql.Date fechaAnterior = new java.sql.Date(System.currentTimeMillis());
        
        int codigo = 1212121212;
       
        Float expResult = 2000.0F;
        float result = b.obtenerBalance(codigo, fechaAnterior);
        assertEquals(expResult, result, 2000.0);
        
    }*/

    /**
     * Test of toString method, of class Banco.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
                
        String expResult="1212121212---500.0\n1353536523---4000.0\n";
        assertEquals(expResult,b.toString());
    }
    
}

