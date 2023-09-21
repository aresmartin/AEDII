
package hashmap;

import java.util.*;

/**
 *
 * @author jdher
 */
public class MapPolinomio implements Polinomio{

    private final Map<Integer,Double> polinomio;
    
    public MapPolinomio(){
        
        polinomio = new HashMap<>();
    }
    
    public int grado() {
    
    if(polinomio == null) return 0;
        
    int mayor = 0;
    
    Iterator<Integer> it = polinomio.keySet();
    
    while(it.hasNext()){
        
        Integer num = it.next();
        
        if(num > mayor){
            
            mayor = num;
        }
     }
    
    return mayor;
    }

    public double coeficiente(int n) {
        
       if(polinomio.get(n) != null) return polinomio.get(n);
       else return 0;
       
    }

    public void añadirTermino(int exponente, double coeficiente) throws IllegalArgumentException {
        
        if(exponente < 0 || coeficiente == 0) throw new IllegalArgumentException();
        
        polinomio.put(exponente, coeficiente);
        
    }

    public void eliminarTermino(int exponente) {
        
        polinomio.remove(exponente);
        
    }

    public Polinomio suma(Polinomio p) {
        
        Polinomio toret = new MapPolinomio();
        
        int mayorGrado = 0;
        
        if(grado() >= p.grado()){
            
            mayorGrado = grado();
        }
        else{
            mayorGrado = p.grado();
        }
        
        for(int i = 0; i < mayorGrado; i++){
            
            if(polinomio.get(i) + p.coeficiente(i) != 0){
                
                toret.añadirTermino(i, polinomio.get(i) + p.coeficiente(i));
            }
        }
        
        return toret;
    }

    public Polinomio derivada() {
        
        Polinomio toret = new MapPolinomio();
        
        Iterator<Integer> it = polinomio.keySet();
        
        while(it.hasNext()){
            
            Integer exponente = it.next();
            Double coeficiente = polinomio.get(exponente);
            
            toret.añadirTermino(exponente - 1, coeficiente * exponente);
        }
        
        return toret;
    }
   
}
