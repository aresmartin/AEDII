package actividad6_ejercicioe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ejercicio2a {
    
    public static List<List<String>> getAnagramas(List<String> palabras){
        Map<String, List<String>> mapaAnagramas = new HashMap<>();
        
        for(String palabra : palabras){
            char[] caracteres = palabra.toCharArray();
            Arrays.sort(caracteres);
            String clave = new String(caracteres);
            
            if(mapaAnagramas.get(clave) == null){
                mapaAnagramas.insertar(clave, new ArrayList<>());
            }
            
            mapaAnagramas.get(clave).add(palabra);
        }
        
         // Convertir los valores del mapa a una lista de listas
        List<List<String>> resultado = new ArrayList<>();
        Iterator<List<String>> iteradorValores = mapaAnagramas.getValores();
        while (iteradorValores.hasNext()) {
            resultado.add(iteradorValores.next());
        }

        return resultado;
   
    }
    
    
    
   
}
