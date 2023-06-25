/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7;

/**
 *
 * @author Alba
 */
public class Ej7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public static void invertirArray(int [] array){
        invertirArray(array, 0);
    }
    
    public static void invertirArray(int [] array, int pos){
        int posCola = array.length - 1 - pos;
        if(pos < posCola){
            invertirArray(array, pos -1);
            int temp = array[posCola];
            array[posCola] = array[pos];
            array[pos] = temp;
        }
    }
}

