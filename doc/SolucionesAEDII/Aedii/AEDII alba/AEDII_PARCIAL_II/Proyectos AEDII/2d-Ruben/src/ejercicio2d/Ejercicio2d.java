/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2d;

import grafo.Arco;
import grafo.Grafo;
import grafo.ListaAdyacencia;

import grafo.Vertice;
import java.util.LinkedList;
import java.util.List;
import map.HashMap;
import map.Par;

/**
 *
 * @author Rubén Gómez Martínez
 */
public class Ejercicio2d {
    
    public static Grafo<String, Integer> construirGrafo(List<String> palabras) {
        
        Grafo<String, Integer> grafoDiccionario = new ListaAdyacencia<>();
        
        HashMap<String, List<String>> diccionario = new HashMap<>();
        List<String> listaClaves = new LinkedList<>();
        
        
        String clave;
        for (String palabra : palabras) {
            
            for (int i = 0; i < palabra.length(); i++) {
                    // Creamos 4 claves para cada palabra( si long = 4 ) con el guion bajo
                    clave = palabra.substring(0, i) + "_" + palabra.substring(i + 1);

                if (!listaClaves.contains(clave)) {
                    listaClaves.add(clave); 
                }
                
                // Introducimos las claves en la lista de claves si no están ya
            }
        }
        
        
        
        for (String key : listaClaves) { // Recorremos la lista de claves
            List<String> listaValores = new LinkedList<>();
            
            for (int i = 0; i < palabras.size(); i++) { // Recorremos la lista de palabras pasadas como parámetro
                int cont = 0;
                
                //Comparamos cada clave con cada palabra
                for(int j=0; j< palabras.get(i).length();j++){// Iteramos cuatro veces, y cada vez comparamos si la clave y la palabra se diferencian en una letra.
                    if (key.charAt(j) == palabras.get(i).charAt(j)) {//comprobamos si coinciden en todas las letras -1.
                        cont++; // Cuenta si hay tres letras iguales
                    }
                }
                if (cont == key.length() - 1 && !listaValores.contains(palabras.get(i))) {
                    listaValores.add(palabras.get(i));//Añadimos valor a la lista de valores
                }
            
            }
            //Asociamos cada clave a la lista de valores que generamos antes, obteniendo el diccionario
            diccionario.insertar(key, listaValores);
            
        }
        
        // Insertamos las palabras en los vértices
        for (String palabra : palabras) {
            grafoDiccionario.insertarVertice(new Vertice(palabra));
        }
        
        for(Par<String, List<String>> par : diccionario.pares()) {
            List<String> valores = par.getValor();
            
            // Comparamos p con las otras palabras
            for(String p : valores) {
                for(String q : valores) {
                    if(!p.equals(q)){ // Si no son iguales, las insertamos como un arco en el grafo
                        Arco<String,Integer> nuevoArco = new Arco(new Vertice(p),new Vertice(q),0);
                        grafoDiccionario.insertarArco(nuevoArco);
                    }
                }
            }
        }
        
        return grafoDiccionario;//Devolvemos grafo ya creado.
        
        
//        for (String origen : palabras) {
//            List<List<String>> valores = diccionario.valores(); // Lista de lista de palabras
//            
//            
//            for (int i = 0; i < valores.size(); i++) { // La i representa cada lista de listas de palabras
//                
//                if (valores.get(i).contains(origen)) { // Si la lista contiene a la palabra que queremos como vértice
//                    for (int j = 0; j < valores.get(i).size(); j++) { // Recorremos la lista de Strings
//                        if (!valores.get(i).get(j).equals(origen)) { // Comprobamos las otras palabras de la lista (en relación con la del vertice)
//                            String destino = valores.get(i).get(j); // Las otras las guardamos como destino
//                            Arco<String, Integer> arcoNuevo = new Arco<>(new Vertice<>(origen), new Vertice<>(destino), 0);
//                            grafoDiccionario.insertarArco(arcoNuevo); // Insertamos un arco con el vértice origen y el destino
//                        }
//                    }
//                }
//                
//            }
//        }      

        
    }
}
