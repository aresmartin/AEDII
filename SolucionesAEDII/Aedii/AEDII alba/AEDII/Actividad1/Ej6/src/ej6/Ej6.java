/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej6;

/**
 *
 * @author Alba
 */
public class Ej6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    public static int sumaArray (int [] array){
        return sumaArray(array, 0, 0);
    }
    public static int sumaArray (int [] array, int res, int pos){
        if(array.length == pos){
            return res;
        }else{
            return sumaArray(array, pos +1, res + array[pos]);
    }
    }
}
