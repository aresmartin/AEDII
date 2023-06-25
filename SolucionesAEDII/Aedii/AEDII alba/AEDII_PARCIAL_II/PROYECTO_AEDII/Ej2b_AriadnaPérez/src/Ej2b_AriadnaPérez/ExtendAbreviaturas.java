/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej2b_AriadnaPérez;

import java.util.HashMap;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Ariadna Pérez
 */
public class ExtendAbreviaturas {
     /**
     * htAbbreviations. Mapa constante que contiene para cada idioma, su diccionario de abreviaturas correspondiente.
     * el cual es otro Mapa que contiene para cada abreviatura su extensión
     * El Mapa se crea a partir de ficheros JSON, uno para cada idioma
    */
    private static final HashMap<String, HashMap<String,String>> htAbbreviations = new HashMap<>();
    
    static { 
        for (String i : new String[]{"abbrev.es.json", 
                                     "abbrev.en.json",
                                     "abbrev.fr.json"
        }) {

            String lang = i.substring(7, 9).toUpperCase();
            InputStream is = ExtendAbreviaturas.class.getResourceAsStream(i);
            JsonReader rdr = Json.createReader(is);
            JsonObject jsonObject = rdr.readObject();
            rdr.close();
            HashMap<String, String> dict = new HashMap<>();
            jsonObject.keySet().forEach((abbrev) -> {
                dict.put(abbrev, jsonObject.getString(abbrev));
            });
            htAbbreviations.put(lang, dict);   
        }
    }
    
  /**
     * traduccionAbreviaturas. Este método devuelve un nuevo texto con las abreviaturas extendidas
     * según su idioma correspondiente.
     * @param textoExtender 
     * @param idioma (limitado a Español (ES), Inglés (EN), Francés (FR))
     * @return Texto traducido
     */ 
    
    public static String extensionAbreviaturas (String textoExtender, String idioma) {
        //    HashMap<Idioma,Mapa<Abbreviatura, Extendido>
        idioma = idioma.toUpperCase();
        StringBuilder toret = new StringBuilder();
        
        if (textoExtender.length() != 0 && ("ES".equals(idioma) || "FR".equals(idioma) || "EN".equals(idioma))){
            
            Map<String,String> mapaExtnd = (Map<String,String>) htAbbreviations.get(idioma);
            String[] splitted = textoExtender.split(" ");
            
            for (String palabra : splitted) {
                
               // buscamos la clave
               if(mapaExtnd.get(palabra) != null){
                   palabra = mapaExtnd.get(palabra);
               }
               toret.append(palabra).append(" ");
               
            }
            
            
        }
        
        return toret.toString();
    }
  
    
}
