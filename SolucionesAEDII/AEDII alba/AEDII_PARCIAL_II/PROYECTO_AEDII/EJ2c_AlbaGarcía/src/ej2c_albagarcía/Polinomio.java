/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

/**
 *
 * @author Alba García
 */
public interface Polinomio {
    // Produce: Inicializa this al polinomio cero

    public int grado();

// Produce: Devuelve el grado del polinomio, es decir, el mayor exponente de un  
// término con coeficiente distinto de cero. Devuelve 0 si es el polinomio cero.
    
    public double coeficiente(int n);
// Produce: Devuelve el coeficiente del término de grado n. Si el término no existe,  
// devuelve 0.

    public void añadirTermino(int exponente, double coeficiente) throws IllegalArgumentException;
// Modifica: this 
// Produce: si el exponente es negativo o el coeficiente es 0 lanza la excepción  

// IllegalArgumentException; en otro caso, añade el termino (coeficiente x exponente) a  
// this
    
    public void eliminarTermino(int exponente);
// Modifica: this 
// Produce: elimina el término con exponente que se pasa como parámetro

    public Polinomio suma(Polinomio p);
// Produce: un nuevo polinomio que es la suma de los polinomios p y this 

    public Polinomio derivada();
// Produce: Dado el polinomio this de la forma anxn + an-1xn-1 + ...+ a1x1 + a0x0         
// devuelve su derivada:  (n*an) xn-1  +  (n-1 * an-1) xn-2 + ...+ a1

    
    public Polinomio resta(Polinomio p);


}

