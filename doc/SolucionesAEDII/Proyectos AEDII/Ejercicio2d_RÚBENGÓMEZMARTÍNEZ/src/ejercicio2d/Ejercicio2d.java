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

/**
 *
 * @author Rubén Gómez Martínez
 */
public class Ejercicio2d {
    
    public static Grafo<String, Integer> construirGrafo(List<String> palabras) {
        
        Grafo<String, Integer> grafoDiccionario = new ListaAdyacencia<>(); //Creamos grafo vacío.
        HashMap<String, List<String>> diccionario = new HashMap<>();//Primero necesitamos un diccionario(CLAVES: _OOL,P_OL,PO_L,POO_;)
        List<String> listaClaves = new LinkedList<>();//Lista que contendrá las posibles claves del Mapa.
        String clave;
        
        for (String palabra : palabras) { //Por cada palabra de la lista inicial...
            //grafoDiccionario.insertarVertice(new Vertice(palabra)); //Creamos vertice con cada palabra.
            for (int i = 0; i < palabra.length(); i++) {//Recorremos la longitud de cada palabra ...

                    clave = palabra.substring(0, i) + "_" + palabra.substring(i + 1);//y creamos su clave(añadiendo el guión en cada posición).

                if (!listaClaves.contains(clave)) {//Si la lista no contiene ya esa clave...
                    listaClaves.add(clave); //Introducimos cada clave en la lista de Claves.
                }
            }
        }
        
        //Generamos el hashMap
        
        for (String key : listaClaves) {//Recorremos nuestra lista de claves.
            List<String> listaValores = new LinkedList<>();//Creamos listaValores que contendrá los valores de cada clave.
            for (int i = 0; i < palabras.size(); i++) {//Recorriendo la lista de palabras...
                int cont = 0;//Creamos variable que nos permitirá saber si es un valor válido(sólo una letra de diferencia).
                for(int j=0; j< palabras.get(i).length();j++){//y recorriendo la longitud de cada palabra...
                    if (key.charAt(j) == palabras.get(i).charAt(j)) {//comprobamos si coinciden en todas las letras -1.
                        cont++;
                    }
                }
                if (cont == key.length() - 1 && !listaValores.contains(palabras.get(i))) {//Cuando el contador sea una unidad menos que la longitud de la clave y esa palabra no este contenida en la lista.
                    listaValores.add(palabras.get(i));//Añadimos el valor correcto a la lista de valores.
                }
            
            }
            diccionario.insertar(key, listaValores);//E insertamos el par(clave, valores) en el diccionario.
            
        }
        
        for (String origen : palabras) {//Recorremos la lista de palabras...
            List<List<String>> valores = diccionario.valores();//Cogemos todos los valores(cada una de las listaValores de cada clave) del diccionario y los guardamos en la variable.
            for (int i = 0; i < valores.size(); i++) {
                if (valores.get(i).contains(origen)) {//Miramos si las palabras están contenidas en la misma lista(condición de que haya un arco entre ellas).
                    for (int j = 0; j < valores.get(i).size(); j++) {//Recorremos cada una de la listas.
                        if (!valores.get(i).get(j).equals(origen)) {//Si la palabra en la que estamos ahora es = origen, no creamos arco.
                            String destino = valores.get(i).get(j); //Sino si lo creamos...
                            Arco<String, Integer> arcoNuevo = new Arco<>(new Vertice<>(origen), new Vertice<>(destino), 0);
                            grafoDiccionario.insertarArco(arcoNuevo);//Y lo insertamos.
                        }
                    }
                }
                
            }
        }        
        return grafoDiccionario;//Devolvemos grafo ya creado.
    }
}
