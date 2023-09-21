
package hashmap;

/**
 *
 * @author jdher
 */
public interface Polinomio {
 
   public int grado ();
   public double coeficiente (int n) ;
   public void añadirTermino(int exponente, double coeficiente) throws IllegalArgumentException;
   public void eliminarTermino(int exponente);
   public Polinomio suma (Polinomio p);
   public Polinomio derivada();
      
}

