/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import java.util.Iterator;
import hashmap.Map;
import hashmap.Par;

/**
 *
 * @author Víctor Rodríguez
 */
public class PolinomioImp implements Polinomio {
    
    private HashMap<Integer, Double> mapa;
    
    public PolinomioImp(){
        this.mapa = new HashMap();
    }
    
    public PolinomioImp(HashMap<Integer, Double> mapa){
        this.mapa = mapa;
    }
    
    
    @Override
    public int grado() {
        if(mapa.esVacio()) //si el mapa está vacío el grado es 0.
            return 0;
        
        int maximo= 0;
        for (int exponente : mapa.claves()) { //se recorre el map, el exponente asociado a cada clave.
            if( exponente > maximo ){
                maximo = exponente; //se queda con el exponente mayor. Es decir, con el grado del polinomio.
            }
        }
        
        return maximo;
    }

    @Override
    public double coeficiente(int grado) {
        Double coeficiente = 0.0;
        
        if( mapa.contieneClave(grado) ){
            coeficiente = mapa.recuperar(grado); 
        }
        
        return coeficiente;
    }

    @Override
    public void añadirTermino(int exponente, double coeficiente) throws IllegalArgumentException {
        
        if(exponente < 0 || coeficiente == 0)
            throw new IllegalArgumentException("añadirTermino: IllegalArgumentException");
        
        
        if(mapa.contieneClave(exponente)){ 
            double nuevoCoeficiente = coeficiente + mapa.recuperar(exponente);
            
            if(nuevoCoeficiente == 0.0){
                mapa.eliminar(exponente);
            }else{
                mapa.insertar(exponente, nuevoCoeficiente);
            }
        }else{
            mapa.insertar(exponente, coeficiente);
        }
        
        
    }

    @Override
    public void eliminarTermino(int exponente) {
        mapa.eliminar(exponente);
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
        if(mapa.esVacio()){
            return new PolinomioImp();
        }
        
        PolinomioImp p = new PolinomioImp();
        
        int grado = p.grado();
        
        for(int i = grado;i>=0;i--){
            if(grado == 0){
                return p;
            }else{
                int nuevoGrado = grado-1;
                double nuevoCoeficiente = grado*p.coeficiente(grado);
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
