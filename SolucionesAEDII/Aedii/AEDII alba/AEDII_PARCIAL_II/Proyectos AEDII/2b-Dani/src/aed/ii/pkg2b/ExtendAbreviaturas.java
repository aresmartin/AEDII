/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aed.ii.pkg2b;

import java.io.InputStream;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import map.*;


/**
 *
 * @author 
 */
public class ExtendAbreviaturas {
    
    /**
     * htAbbreviations. Mapa constante que contiene para cada idioma, su diccionario de abreviaturas correspondiente.
     * el cual es otro Mapa que contiene para cada abreviatura su extensión
     * El Mapa se crea a partir de ficheros JSON, uno para cada idioma
    */
    private static final Map<String, Map<String,String>> htAbbreviations = new HashMap<>();

    
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
            Map<String, String> dict = new HashMap<>();
            jsonObject.keySet().forEach((abbrev) -> {
                dict.insertar(abbrev, jsonObject.getString(abbrev));
            });
            htAbbreviations.insertar(lang, dict);
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
            
            Map<String,String> mapaExtnd = htAbbreviations.recuperar(idioma);
            String[] splitted = textoExtender.split(" ");
            
            for (String palabra : splitted) {
                
               // buscamos la clave
               if(mapaExtnd.recuperar(palabra) != null){
                   palabra = mapaExtnd.recuperar(palabra);
               }
               toret.append(palabra).append(" ");
               
            }
            
            
        }
        
        return toret.toString();
    }
  
    
}


//Necesario en la función concatenar el texto con las palabras extendidas
//Necesario evaluar palabras individuales (
//El bucle tiene que revisar cada palabra (después de cada espacio o al final del string)
//Si es abreviatura se extiende, si no lo es se añade al texto para devolver
//El return ha de ser el texto