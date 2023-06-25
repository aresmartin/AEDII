/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3;

/**
 *
 * @author Alba
 */
public class Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public static int sumanumeros (int num){
        if(num < 10){
            return num;
        }else{
           return num%10 + sumanumeros(num/10);
        }
    }
}
