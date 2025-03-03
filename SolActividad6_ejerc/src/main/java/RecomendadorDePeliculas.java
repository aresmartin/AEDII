import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecomendadorDePeliculas {
    
    // Método estático para obtener recomendaciones
    public static List<String> getRecomendaciones(Map<String, List<String>> sistema, String pelicula) {
        // HashMap para mantener una registro de cuantas personas han visto la peli.
        HashMap<String, Integer> visualizaciones = new HashMap<>();
        
        // Recorre las claves
        Iterator<String> iterUsuarios = sistema.keySet(); 
        while(iterUsuarios.hasNext()){
            String user = iterUsuarios.next();
            List<String> pelisUsuario = sistema.get(user);
            if(pelisUsuario.contains(pelicula)){
                for(String peli : pelisUsuario){
                    if(peli != pelicula){
                        if(visualizaciones.esta(peli)){
                            visualizaciones.put(peli, visualizaciones.get(peli)+1);
                            
                        }else{
                            visualizaciones.put(peli, 1);
                        }
                    }
                }
                
            }
        }
        
        int maximo = 0;
        Iterator<String> iterPelis = visualizaciones.keySet();
        while(iterPelis.hasNext()){
            String peliculaRecomendada = iterPelis.next();
            maximo = Math.max(maximo, visualizaciones.get(peliculaRecomendada));
        }
        
        List<String> resultado = new ArrayList<>();
        while(iterPelis.hasNext()){
            String peliculaRecomendada = iterPelis.next();
            if(visualizaciones.get(peliculaRecomendada) == maximo){
                resultado.add(peliculaRecomendada);
                
            }
        }      
        return resultado;            
    }   
}
    
   
    

