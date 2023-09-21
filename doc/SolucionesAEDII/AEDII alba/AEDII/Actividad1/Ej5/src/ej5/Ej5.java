/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej5;

/**
 *
 * @author Alba
 */
public class Ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static String invertir (String str){
        if(str.isEmpty()){
            return str;
        }else{
            return invertir(str.substring(1) + str.charAt(0));
        }
    }
}
