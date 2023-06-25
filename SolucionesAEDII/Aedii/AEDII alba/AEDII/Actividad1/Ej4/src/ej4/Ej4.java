/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4;

/**
 *
 * @author Alba
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public static int mcd(int a, int b){
        if(b == 0){
            return 0;
        }else{
            return mcd(b, a%b);
        }
    }
}
