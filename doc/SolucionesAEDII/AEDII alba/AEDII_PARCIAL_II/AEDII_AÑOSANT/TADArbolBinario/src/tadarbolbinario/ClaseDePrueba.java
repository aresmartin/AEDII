/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadarbolbinario;

/**
 *
 * @author svsemeria_ESEI
 */
public class ClaseDePrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EnlazadoArbolBinario uno = new EnlazadoArbolBinario(33, new EnlazadoArbolBinario(), new EnlazadoArbolBinario());
        EnlazadoArbolBinario dos = new EnlazadoArbolBinario(66, new EnlazadoArbolBinario(), new EnlazadoArbolBinario());
        EnlazadoArbolBinario tres = new EnlazadoArbolBinario(99, new EnlazadoArbolBinario(), new EnlazadoArbolBinario());
        
        

        try{
            uno.setHijoIzq(dos);
            uno.setHijoDer(tres);
            
            System.out.println(uno.esta(33));
            
            
        }catch(ArbolVacioException exc){
            System.err.println("El arbol está vacio");
        }catch(NullPointerException exc){
            System.err.println("Puntero al vacio");
        }
        
    }
    
}
