/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

/**
 *
 * @author Juan Yuri Díaz Sánchez
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PolinomioImp instance = new PolinomioImp();
        instance.añadirTermino(2, 6);
        instance.añadirTermino(1, -7);
        instance.añadirTermino(0, 5);
        instance.añadirTermino(1, 7);
        
        PolinomioImp instance2 = new PolinomioImp();

        
        System.out.println(instance);
        System.out.println(instance2);
        
        PolinomioImp d = (PolinomioImp) instance.suma(instance2);
        
        System.out.println(d);
       
    }
    
}
