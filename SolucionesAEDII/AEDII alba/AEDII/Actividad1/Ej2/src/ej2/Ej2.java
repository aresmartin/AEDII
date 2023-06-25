/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2;

/**
 *
 * @author Alba
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(potencia(3));
    }
    
    public static int potencia (int num){
        if(num == 0){
            return 0;
        }else{
            return potencia(num-1) + 2* num -1;
        }
    }
}
