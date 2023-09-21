/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad6;

import java.util.Iterator;

/**
 *
 * @author Yo
 */
public class MapPolinomio implements Polinomio {

    private Map<Integer, Double> p;

    public MapPolinomio() {
        p=new HashMap(1);

    }

   /*@Override
    public int grado() {
        if (p.isEmpty()) {
            return 0;
        } else {
            int gradomayor = -1;
            Iterator<Integer> it = p.keySet();
            while (it.hasNext()) {
                if (gradomayor < it.next()) {
                    gradomayor = it.next();
                } else {
                    it.next();
                }
            }

            return gradomayor;
        }

    }*/

   @Override
    public int grado() {
        if (p.isEmpty()) {
            return 0;
        } else {
            int gradomayor = -11111;
            Iterator<Integer> it = p.keySet();
            while (it.hasNext()) {
                int grado= it.next();    
                if(gradomayor<grado){
                    gradomayor=grado;
                } 
                    
            }

            return gradomayor;
        }

    }

    @Override
    public double coeficiente(int n) {
        if (p.esta(n)) {
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
        MapPolinomio p2 = new MapPolinomio();
        int gradomayor = this.grado();
        if (gradomayor < t.grado()) {
            gradomayor = t.grado();
        }
        for (int i = 0; i < gradomayor; i++) {
            p2.añadirTermino(i, t.coeficiente(i) + this.coeficiente(i));

        }
        return p2;
    }

    @Override
    public Polinomio derivada() {
        MapPolinomio p2 = new MapPolinomio();
        for (int i =0; i < grado(); i++) {
            p2.añadirTermino(i - 1, i * p.get(i));
        }

        return p2;
    }

}
