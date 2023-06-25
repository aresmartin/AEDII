/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map.Entry;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 *
 * @author Kevin
 */
public class Actividad6b {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        HashMap<String, HashMap<String, String>> diccionarios = new HashMap<>();
        HashMap<String, String> es = new HashMap<>();
        HashMap<String, String> en = new HashMap<>();
        HashMap<String, String> fr = new HashMap<>();
        String[] idioma = new String[]{"es", "en", "fr"};

        for (String lg : idioma) {

            try {
                InputStream fis = new FileInputStream("src\\actividad6\\abbrev." + lg + ".json");
                JsonReader reader = Json.createReader(fis);
                JsonObject abrev = reader.readObject();
                reader.close();

                switch (lg) {
                    case "es":
                        for (Entry<String, JsonValue> entry : abrev.entrySet()) {
                            es.insertar(entry.getKey(), entry.getValues().toString().replace("\"", ""));
                        }
                        diccionarios.insertar("es", es);
                        break;
                    case "en":
                        for (Entry<String, JsonValue> entry : abrev.entrySet()) {
                            en.put(entry.getKey(), entry.getValues().toString().replace("\"", ""));
                        }
                        diccionarios.insertar("en", en);
                        break;
                    case "fr":
                        for (Entry<String, JsonValue> entry : abrev.entrySet()) {
                            fr.put(entry.getKey(), entry.getValues().toString().replace("\"", ""));
                        }
                        diccionarios.insertar("fr", fr);
                        break;
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
            }
        }
        
        //PRUEBAS
        String textoOriginal = "Hola D. Pepito, Hola D. José ";
        String textoEsperado = "Hola don Pepito, Hola don José ";
        String sinAbrev = extensionAbreviaturas(textoOriginal, "es", diccionarios);
        if (sinAbrev.equals(textoEsperado)) {
            System.out.println("Texto Original: " + textoOriginal);
            System.out.println("Texto sin abreviaturas " + sinAbrev);
        }

        textoOriginal = "This is Gd. ";
        textoEsperado = "This is good ";
        sinAbrev = extensionAbreviaturas(textoOriginal, "en", diccionarios);
        if (sinAbrev.equals(textoEsperado)) {
            System.out.println("Texto Original: " + textoOriginal);
            System.out.println("Texto sin abreviaturas " + sinAbrev);
        }

        textoOriginal = "Bonjour Dr Pepito, bonjour Dr José ";
        textoEsperado = "Bonjour docteur Pepito, bonjour docteur José ";
        sinAbrev = extensionAbreviaturas(textoOriginal, "fr", diccionarios);
        if (sinAbrev.equals(textoEsperado)) {
            System.out.println("Texto Original: " + textoOriginal);
            System.out.println("Texto sin abreviaturas " + sinAbrev);
        }

    }

    public static String extensionAbreviaturas(String textoExtender, String idioma, HashMap<String, HashMap<String, String>> dic) {
        Map<String, String> abrev = dic.get(idioma);
        String textoFinal = textoExtender;
        for (String palabra : textoExtender.split(" ")) {
            if (abrev.esta(palabra)) {
                textoFinal = textoFinal.replace(palabra, abrev.get(palabra));
            }
        }

        return textoFinal;
    }
}
