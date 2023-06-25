package abreviaturas;


import java.io.InputStream;
import java.util.StringTokenizer;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.util.Map;
import java.util.HashMap;


public class ExtendAbreviaturas {
    
    /**
     * htAbbreviations. Mapa constante que contiene para cada idioma, su diccionario de abreviaturas correspondiente.
     * el cual es otro Mapa que contiene para cada abreviatura su extensiÃ³n
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
                dict.put(abbrev, jsonObject.getString(abbrev));
            });
            htAbbreviations.put(lang, dict);   
        }
    }
    
  /**
     * traduccionAbreviaturas. Este mÃ©todo devuelve un nuevo texto con las abreviaturas extendidas
     * segÃºn su idioma correspondiente.
     * @param textoExtender 
     * @param idioma (limitado a EspaÃ±ol (ES), InglÃ©s (EN), FrancÃ©s (FR))
     * @return Texto traducido
     */ 
    
    public static String extensionAbreviaturas (String textoExtender, String idioma) {

        String nuevoTexto="";
        int corte=0;
        Map<String,String> sustitucion=htAbbreviations.get(idioma.toUpperCase());
        for (int i=0 ;i<= textoExtender.length();i++){
            if (i==textoExtender.length() || textoExtender.charAt(i)==' '){
                String palabra=textoExtender.substring(corte,i);
                if(sustitucion.get(palabra)==null){
                    nuevoTexto = nuevoTexto.concat(palabra);
                    nuevoTexto = nuevoTexto.concat(" ");
                }
                else{
                    nuevoTexto = nuevoTexto.concat(sustitucion.get(palabra));
                    nuevoTexto = nuevoTexto.concat(" ");
                }
                corte=i+1;
            }
        }
        
        return nuevoTexto;
    }
              
       
  
    
}
