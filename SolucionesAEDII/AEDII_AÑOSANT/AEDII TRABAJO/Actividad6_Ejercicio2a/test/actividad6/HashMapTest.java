/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad6;


import static org.junit.Assert.*;
import org.junit.Test;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashMapTest {

@Rule
    public final ExpectedException exception = ExpectedException.none();
    
@Test//(expected = IllegalArgumentException.class)
public void testIllegalCapacity() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage(CoreMatchers.containsString("ERROR: capacidad negativa"));
    Map hashMap = new HashMap(-5);
}
    
@Test
public void testTamañoVacio() {
    Map instance = new HashMap(0);
    int expResult = 0;
    int result = instance.size();
    assertEquals(expResult, result);
}

@Test
public void testTamaño() {
    Map<String,String> instance = new HashMap<>(0);
    instance.put("c1", "v1");
    instance.put("c2", "v2");
    int expResult = 2;
    int result = instance.size();
    assertEquals(expResult, result);
}

@Test
public void testGetAndInsertar() {
    String clave = "clave1";
    String valor = "valor1";
    Map<String, String> instance = new HashMap<>(0);
    instance.put(clave, valor);
    instance.put("c2", "v2");
    String expResult = valor;
    String result = instance.get(clave);
    assertEquals(expResult, result);
}

@Test
public void testGetNonExistent() {
    Map<String, String> instance = new HashMap<>(0);
    instance.put("c2", "v2");
    String expResult = null;
    String result = instance.get("clave1");
    assertEquals(expResult, result);
}

public void testEliminar() {
    String clave = "c2";
    String valor = "v2";
    Map<String, String> instance = new HashMap<>(0);
    instance.put(clave, valor);
    String expResult = valor;
    String result = instance.remove(clave);
    assertEquals(expResult, result);
}

@Test
public void testEliminarNonExistent() {
    String clave = "c2";
    Map<String, String> instance = new HashMap<>(0);
    String expResult = null;
    String result = instance.remove(clave);
    assertEquals(expResult, result);
}

@Test
public void testGetValores() {
    Map<String, String> instance = new HashMap<>(0);
    String v1 = "v1";
    String v2 = "v2";
    String v3 = "v3";
    instance.put("c1", v1);
    instance.put("c2", v2);
    instance.put("c3", v3);
    List<String> expResult = new ArrayList<>();
    expResult.add(v1);
    expResult.add(v2);
    expResult.add(v3);
    Iterator<String> it = instance.values();
    List<String> result = new ArrayList<>();
    while (it.hasNext()) {
        result.add(it.next());
    }
    assertArrayEquals(expResult.toArray(new String[0]), result.toArray(new String[0]));
}

@Test
public void testGetClaves() {
    Map<String, String> instance = new HashMap<>(0);
    String c1 = "c1";
    String c2 = "c2";
    String c3 = "c3";
    instance.put(c1, "v1");
    instance.put(c2, "v2");
    instance.put(c3, "v3");
    List<String> expResult = new ArrayList<>();
    expResult.add(c3);
    expResult.add(c1);
    expResult.add(c2);
    Iterator<String> it = instance.keySet();
    List<String> result = new ArrayList<>();
    while (it.hasNext()) {
        result.add(it.next());
    }
    assertArrayEquals(expResult.toArray(new String[0]), result.toArray(new String[0]));
}    
}