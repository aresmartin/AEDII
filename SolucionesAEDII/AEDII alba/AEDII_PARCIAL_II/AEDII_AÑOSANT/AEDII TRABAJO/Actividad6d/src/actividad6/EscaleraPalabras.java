package actividad6;

import grafo.Arco;
import grafo.Grafo;
import grafo.ListaAdyacencia;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Samuel Lema González
 */
public class EscaleraPalabras {

    private static Grafo<String, Integer> g;
    
    public static void main(String[] args) {
        
        // Este código es simplemente para debugear
        
//        String [] arrayPalabras = {"FOOL", "FOUL", "FOIL", "POOL", "COOL"};
//        List<String> palabras = Arrays.asList(arrayPalabras);
//        
//        construirGrafo(palabras);
    }
    
    public static Grafo<String, Integer> construirGrafo(List<String> palabras){
        
        g = new ListaAdyacencia<>();
        
        // Recojo los keys y valores parecidos de la lista de 
        // palabras y las guardo en un HashMap
        
        HashMap<String, ArrayList<String>> hmPalabras = new HashMap<>();
        
        palabras.forEach((palabra) -> {
            
            ArrayList<String> listaParecidos = new ArrayList<>();
            
            for(int i = 0; i < palabra.length(); i++){
                
                String palabraKey = palabra.replace(palabra.charAt(i), '_');
                    
                palabras.forEach((palabraParecida) -> {
                        
                    boolean matches = Pattern.matches(palabraKey.replace('_', '.'), palabraParecida);
                        
                    if (matches) {
                            
                        listaParecidos.add(palabraParecida);
                    }
                });
            }
            
            hmPalabras.put(palabra, listaParecidos);
        });
        
        // Itero el hasmap para construir el grafo a partir de las key - value
        
        Iterator<String> it = hmPalabras.keySet();
        
        while (it.hasNext()) {
            
            String key = it.next();
            
            hmPalabras.get(key).forEach((palabrasAsociadas) -> {
                
                g.insertarArco(new Arco<>(new Vertice<>(key), new Vertice<>(palabrasAsociadas), 0));
            });
        }
        
        return g;
    }
}
