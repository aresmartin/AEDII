/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad6_ejercicioe;

public class Vertice<E> {
    // Atributo que almacena la etiqueta del vértice
    private E etiqueta;

    // Constructor que inicializa el vértice con una etiqueta específica
    public Vertice(E etiqueta) {
        this.etiqueta = etiqueta;
    }

    // Método para obtener la etiqueta del vértice
    public E getEtiqueta() {
        return etiqueta;
    }

    // Método que compara si dos vértices son iguales, basado en sus etiquetas
    @Override
    public boolean equals(Object o) {
        // Verifica si el objeto comparado es el mismo
        if (this == o) return true;
        // Verifica si el objeto es una instancia de Vertice
        if (!(o instanceof Vertice)) return false;
        // Realiza una conversión de tipo para comparar etiquetas
        Vertice<?> vertice = (Vertice<?>) o;
        // Compara las etiquetas de los dos vértices
        return etiqueta.equals(vertice.etiqueta);
    }

    // Método para obtener el código hash del vértice, basado en su etiqueta
    @Override
    public int hashCode() {
        return etiqueta.hashCode();
    }
}