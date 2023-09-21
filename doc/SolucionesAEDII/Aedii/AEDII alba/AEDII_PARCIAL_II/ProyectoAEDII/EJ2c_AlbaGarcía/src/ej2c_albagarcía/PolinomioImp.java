/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import hashmap.HashMap;
import java.util.Iterator;
import hashmap.Map;
import hashmap.Par;

/**
 *
 * @author Alba García
 */
public class PolinomioImp implements Polinomio {
    
    private HashMap<Integer, Double> mapa;
    
    public PolinomioImp(){
        int tam = 0;
        this.mapa = new HashMap(tam);
    }
    
    
    
    @Override
    public int grado() {
        if (mapa.isEmpty()) //si el mapa está vacío el grado es 0.
        {
            return 0;
        }

        int maximo = 0;
        Iterator<Integer> iterador = mapa.keySet();
        while (iterador.hasNext()) {
            Integer exponente = iterador.next();
            if (exponente > maximo) {
                maximo = exponente;
            }
        }

        return maximo;
    }

    @Override
    public double coeficiente(int grado) {
        Double coeficiente = 0.0;
        
        if( mapa.esta(grado)){
            coeficiente = mapa.get(grado); 
        }
        
        return coeficiente;
    }

    @Override
    public void añadirTermino(int exponente, double coeficiente) throws IllegalArgumentException {
        
        if(exponente < 0 || coeficiente == 0)
            throw new IllegalArgumentException("añadirTermino: IllegalArgumentException");
        
        
        if(mapa.esta(exponente)){ 
            double nuevoCoeficiente = coeficiente + mapa.get(exponente);
            
            if(nuevoCoeficiente == 0.0){
                mapa.remove(exponente);
            }else{
                mapa.put(exponente, nuevoCoeficiente);
            }
        }else{
            mapa.put(exponente, coeficiente);
        }
        
        
    }

    @Override
    public void eliminarTermino(int exponente) {
        mapa.remove(exponente);
    }

    @Override
    
    public Polinomio suma(Polinomio p) {
        
        Polinomio polinomioResultado = new PolinomioImp();
        
        int gradoMayor;
        
        if(this.grado() > p.grado()){
            gradoMayor = this.grado();
        } else 
            gradoMayor = p.grado();

        for(int i = gradoMayor; i >= 0 ; i--){
            double total = (this.coeficiente(i) + p.coeficiente(i)); // Sumamos los coeficientes
            
            if(total != 0) 
                polinomioResultado.añadirTermino(i, total);
        }
        return polinomioResultado;
    }
    
    @Override
    public Polinomio derivada() {
        if(mapa.isEmpty()){
            return new PolinomioImp();
        }
        
        PolinomioImp p = new PolinomioImp();
        
        int grado = p.grado();
        
        for(int i = grado;i>=1;i--){
            if(grado == 0){
                return p;
            }else{
                int nuevoGrado = i-1;
                double nuevoCoeficiente = i * p.coeficiente(i);
                p.añadirTermino(nuevoGrado, nuevoCoeficiente);
            }
        }
        return p;
    }
    
    @Override
    public String toString(){
        StringBuilder toret = new StringBuilder();
        
        for (Par<Integer, Double> par : mapa.pares()) {
            
            toret.append(par.getValue()).append("x^");
            toret.append(par.getValue()).append("  ");
            
        }
        toret.append("\n");
        
        
        return toret.toString();
    }
}

