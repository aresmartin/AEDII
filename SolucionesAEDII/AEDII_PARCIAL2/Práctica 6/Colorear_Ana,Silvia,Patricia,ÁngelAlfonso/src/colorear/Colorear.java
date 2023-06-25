/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorear;

import grafo.Grafo;
import grafo.Vertice;
import java.util.Iterator;
import mapa.*;

/**
 *
 * @author mlborras18_ESEI
 */
public class Colorear {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static <E> Map<Vertice<E>, String> colorearMapa(Grafo<E, Integer> g, String[] colores) {

        HashMap<Vertice<E>, String> mapa = new HashMap<>();
        Iterator<Vertice<E>> vertices = g.vertices();
        while (vertices.hasNext()) {

            mapa.insertar(vertices.next(), "");
        }

        vertices = g.vertices();
        while (vertices.hasNext()) {
            Vertice<E> v = vertices.next();
          

            String color = elegirColor(v, colores,g, mapa);
            
            mapa.insertar(v, color);
        }
        return mapa;
    }

    public static <E> String elegirColor(Vertice<E> v, String[] colores, Grafo <E, Integer> g, HashMap mapa) {

        boolean esta = true;
        int i = 0;
        while (esta) {
            esta = false;
            Iterator<Vertice<E>> iterador= g.adyacentes(v);
            while (iterador.hasNext()) {
                if (colores[i].equals(mapa.get(iterador.next()))) {
                    esta = true;
                    i++;
                    
                }
            }
        }
        return colores[i];
    }

}
