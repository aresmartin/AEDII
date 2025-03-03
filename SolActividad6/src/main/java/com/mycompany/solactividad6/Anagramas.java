/*
 * Clase Anagramas que contiene el método getAnagramas para agrupar palabras que son anagramas.
 */
package com.mycompany.solactividad6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anagramas {

    // Método estático que toma una lista de palabras y devuelve una lista de listas de anagramas
    public static List<List<String>> getAnagramas(List<String> palabras) {
        // Crear un mapa para agrupar palabras por sus anagramas, con clave de tipo String (orden de letras) y valor de tipo List<String> (palabras anagramas)
        HashMap<String, List<String>> mapaAnagramas = new HashMap<>();

        // Recorrer cada palabra en la lista de palabras
        for (String palabra : palabras) {
            // Convertir la palabra en un arreglo de caracteres para ordenar sus letras
            char[] letras = palabra.toCharArray();
            // Ordenar el arreglo de letras alfabéticamente
            Arrays.sort(letras);
            // Convertir el arreglo ordenado en una cadena que servirá como clave
            String clave = new String(letras);

            // Obtener la lista de palabras agrupadas bajo la clave generada (si existe)
            List<String> grupoAnagramas = mapaAnagramas.get(clave);

            // Si no existe una lista para esta clave, crear una nueva lista
            if (grupoAnagramas == null) {
                grupoAnagramas = new ArrayList<>();
                // Insertar la nueva lista en el mapa con la clave ordenada
                mapaAnagramas.put(clave, grupoAnagramas);
            }

            // Añadir la palabra actual a la lista de su grupo de anagramas
            grupoAnagramas.add(palabra);
        }

        // Crear una lista final que contendrá todos los grupos de anagramas
        List<List<String>> resultado = new ArrayList<>();

        // Recorrer todos los valores en el mapa de anagramas y agregarlos a la lista de resultado
        for (Iterator<List<String>> it = mapaAnagramas.values(); it.hasNext();) {
            resultado.add(it.next());
        }

        // Devolver la lista final de grupos de anagramas
        return resultado;
    }
}
