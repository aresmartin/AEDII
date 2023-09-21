/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Iterator;

/**
 *
 * @author Yo
 */
public class MapPolinomio implements Polinomio {
    private Map<Integer,Double> p;
    
    public MapPolinomio(){
        p=new HashMap<>();
    }
    @Override
    public int grado() {
        if(p.isEmpty())return 0;
        else{
         int gradoMayor=-1;
         Iterator<Integer> grados=p.keySet();
         while(grados.hasNext()){
             int aux=grados.next();
             if(gradoMayor<aux){
                 gradoMayor=aux;
             }
         }
         return gradoMayor;
        }
    }

    @Override
    public double coeficiente(int n) {
        if(p.esta(n)){
        return p.get(n);
        }else{
            return 0;
        }
    }

    @Override
    public void añadirTermino(int exponente, double coeficiente) throws IllegalArgumentException {
         if (exponente < 0 || coeficiente == 0) {
            throw new IllegalArgumentException("añadirTermino: IllegalArgumentException");
        }
         p.put(exponente, coeficiente);
    }

    @Override
    public void eliminarTermino(int exponente) {
        p.remove(exponente);
    }

    @Override
    public Polinomio suma(Polinomio t) {
        MapPolinomio p2=new MapPolinomio();
        int grado=this.grado();
        if(grado<t.grado()){
            grado=t.grado();
        }
        for(int i=0;i<grado;i++){
            p2.añadirTermino(i,this.coeficiente(i)+t.coeficiente(i));
        }
        return p2;
    }

    @Override
    public Polinomio derivada() {
        MapPolinomio p2= new MapPolinomio();
        for(int i=0;i<grado();i++){
            p2.añadirTermino(i-1,i*p.get(i) );
        }
        return p2;
    }
    
}
