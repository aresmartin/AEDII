package actividad6_ejercicioe;

//  import static actividad6_ejercicioe.Ejercicio2a.getAnagramas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Actividad6_ejercicioE {



    public static Grafo<String, String> construirGrafo(List<String> listaPalabras) {

        // Paso 1: Construir el diccionario
        Map<String, List<String>> diccionario = construirDiccionario(listaPalabras);

        // Paso 2: Crear el grafo
        Grafo<String, String> grafo = new ListaAdyacencia<>();

        // Paso 3: Insertar los vértices (las palabras del conjunto inicial)
        for (String palabra : listaPalabras) {
            Vertice<String> vertice = new Vertice<>(palabra);
            grafo.insertarVertice(vertice);
        }

        // Paso 4: Crear las aristas
        Iterator<String> claves = diccionario.getClaves();
        while (claves.hasNext()) {
            String clave = claves.next();
            List<String> palabras = diccionario.get(clave); //lista de palabras asociada a clave

            // Crear aristas entre todas las combinaciones de palabras de esta lista
            for (int i = 0; i < palabras.size(); i++) { //combinaciones primera y siguiente
                for (int j = i + 1; j < palabras.size(); j++) { // con todas las demas
                    String origen = palabras.get(i);
                    String destino = palabras.get(j);

                    // Crear una arista con la clave como etiqueta
                    Arco<String, String> arco = new Arco<>(new Vertice<>(origen), new Vertice<>(destino), clave);
                    grafo.insertarArco(arco);
                }
            }
        }

        return grafo;
    }

    private static Map<String,List<String>> construirDiccionario(List<String> listaPalabras) {

        Map<String,List<String>> diccionario = new HashMap<>();


        for (String palabra : listaPalabras){
            crearClaves(palabra,diccionario); //creamos todas las claves del mapa para cada palabra
        }

        Iterator<String> dItr = diccionario.getClaves();

        //recorremos todas las claves 1 a 1
        while(dItr.hasNext()){
            String key = dItr.next();
            //para cada clave de nuestro mapa miramos que palabras de la lista cumplen
            for (String palabra : listaPalabras) {
                char[] caracteres = palabra.toCharArray();
                //cada letra de la palabra de la lista tiene que coincidir con la clave
                diccionario.get(key).add(palabra); //añadimos la palabra
                if (caracteres.length == key.length()) {
                    for (int i = 0; i < caracteres.length; i++) {
                        if (!(key.charAt(i) == '_')){ //si la posicion i actual es distinto a nuestro comodin revisamos
                            if (key.charAt(i) != caracteres[i]){
                                diccionario.get(key).remove(palabra);
                            }
                        }
                    }
                }
            }
        }

        return diccionario;
    }

    private static void crearClaves(String palabra, Map<String,List<String>> d){
        List<String> clavesExploradas = new ArrayList<>();

        char[] caracteres = palabra.toCharArray();
        for (int i = 0; i < caracteres.length; i++){
            String key = palabra.substring(0, i) + "_" + palabra.substring(i + 1);
            if (!clavesExploradas.contains(key)){
                clavesExploradas.add(key);
                d.insertar(key,new ArrayList<>());
            }
        }
    }

     // Método main para probar
    public static void main(String[] args) {
        
         List<String> listaPalabras = List.of("pool", "cool", "fool", "foul", "foil");

        // Construir el grafo
        Grafo<String, String> grafo = construirGrafo(listaPalabras);

        // Mostrar los vértices del grafo
        System.out.println("Vértices del grafo:");
        Iterator<Vertice<String>> vertices = grafo.vertices();
        while (vertices.hasNext()) {
            System.out.println(vertices.next().getEtiqueta());
        }

        // Mostrar las aristas del grafo
        System.out.println("\nAristas del grafo:");
        Iterator<Arco<String, String>> arcos = grafo.arcos();
        while (arcos.hasNext()) {
            Arco<String, String> arco = arcos.next();
            System.out.println("Arco: " + arco.getOrigen().getEtiqueta() + " -> " + arco.getDestino().getEtiqueta() +
                    " (Etiqueta: " + arco.getEtiqueta() + ")");
        }
        
        /*List<String> palabras = Arrays.asList("rato", "arto", "tabo", "par", "taro", "bato", "tumadre", "madretu");
        List<List<String>> anagramas = getAnagramas(palabras);
        System.out.println(anagramas);*/
    }




}


