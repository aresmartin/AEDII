package usografo;


import grafo2.Arco;
import grafo2.Grafo;
import grafo2.MapAdyacencia;
import grafo2.Vertice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Juan Yuri Díaz Sánchez
 */
public class UsoGrafo {
    public static void main(String[] args) {
        
        Vertice<String> v1 = new Vertice<>("Coruña");
        Vertice<String> v2 = new Vertice<>("Lugo");
        Vertice<String> v3 = new Vertice<>("Ourense");
        Vertice<String> v4 = new Vertice<>("Pontevedra");
        
        Grafo<String,Integer> g = new MapAdyacencia<>();
        g.insertarArco(new Arco<>(v2, v1, 10));
        g.insertarArco(new Arco<>(v1, v3, 20));
        g.insertarArco(new Arco<>(v2, v4, 115));
        g.insertarArco(new Arco<>(v3, v4, 100));
        
        g.insertarArco(new Arco<>(v2, v3, 100));
        g.insertarArco(new Arco<>(v4, v2, 120));
        g.insertarArco(new Arco<>(v4, v3, 120));
        
//        Iterator<Vertice<String>> itPred = UsoGrafo.predecesores(g, v4);
//        List<String> result = new ArrayList<>();
//        while (itPred.hasNext()) {
//            result.add(itPred.next().getEtiqueta());
//        }
//        
//        List<String> expResult = new ArrayList<>();
//        expResult.add("Lugo");
//        expResult.add("Ourense");
//        
//        System.out.println(expResult);
//        System.out.println(result);
    boolean encontrado;
        encontrado = esCamino(g,v1,v2);
        System.out.println(encontrado);
        
    }
    
    public static <E,T> Iterator<Vertice<E>> predecesores(Grafo<E,T> grafo,Vertice<E> v){
        List<Vertice<E>> predecesores = new LinkedList<>();
        Iterator<Vertice<E>> listaGrafo = grafo.vertices();
        
        while(listaGrafo.hasNext()){
            Vertice<E> verticeGrafo = listaGrafo.next();
            
            Iterator<Vertice<E>> listaAdyc = grafo.adyacentes(verticeGrafo);
            while(listaAdyc.hasNext()){
                Vertice<E> verticeAdyacente = listaAdyc.next();
                
                if(verticeAdyacente.equals(v))
                    predecesores.add(verticeGrafo);
                
            }
        }
        
        return predecesores.iterator();
    }
    
    
    
    public static <E,T> boolean sumidero(Grafo<E,T> grafo,Vertice<E> vertice){
        Iterator<Vertice<E>> itVert = grafo.vertices();
        int numVertices = contarNumElem(itVert);
        
        itVert = grafo.adyacentes(vertice);
        int numSucesores = contarNumElem(itVert);
        
        int numPredecesores = contarNumElem(predecesores(grafo,vertice));
         
        if(numSucesores == 0){
           
            return (numPredecesores == (numVertices - 1));
            
        }else{
            return false;
        }
        
    }
    
    private static <E> int  contarNumElem(Iterator<E> it){
        int cont = 0;
        while(it.hasNext()){
            it.next();
            cont++;
        }
        
        return cont;
    }
    
    public static <E,T> boolean regular(Grafo<E,T> grafo){
        
        if(grafo.esVacio())
            return true;
        
        Iterator<Vertice<E>> itVert = grafo.vertices();
        int cont = contarNumElem(grafo.adyacentes(itVert.next()));
        
        while(itVert.hasNext()){
            
            int contSucesores = contarNumElem( grafo.adyacentes(itVert.next()) );
            if(cont != contSucesores){
                return false;
            }
            
        }
        return true;
    }
    
    public static <E,T> boolean esCamino(Grafo<E,T> grafo,Vertice<E> vo, Vertice<E> vd){
        if(grafo.esVacio()){
            return false; // No se si devolver true o false
        }
        
        List<Vertice<E>> visitados = new LinkedList<>();
        
        return(esCamino(grafo,vo,vd,visitados));
    
    }
    
    private static <E,T> boolean esCamino(Grafo<E,T> grafo,Vertice<E> vo, Vertice<E> vd,List<Vertice<E>> visitados){
            boolean encontrado=false;
            visitados.add(vo);
            
            if (vo.equals(vd)){
                return true;
            }else{
                Iterator<Vertice<E>> adys = grafo.adyacentes(vo);
                while (adys.hasNext()&& !encontrado){
                    Vertice<E> w = adys.next();
                    if (!visitados.contains(w))
                      encontrado = esCamino(grafo, w, vd, visitados);
                }
               return encontrado;
            }
    }
    
    public static <E,T> List<E> aislado(Grafo<E,T> grafo,Vertice<E> v){
        List<E> lista = new LinkedList();
        
        if(!predecesores(grafo,v).hasNext() && contarNumElem(grafo.adyacentes(v)) == 0){
            return lista;
        }
//        Iterator<Vertice<E>> itAdy = grafo.adyacentes(v);
        // Ni idea de como seguir
        return lista;
    }
 
    
}
