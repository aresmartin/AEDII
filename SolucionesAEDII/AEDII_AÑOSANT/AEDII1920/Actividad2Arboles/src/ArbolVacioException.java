

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author svsemeria_ESEI
 */
public class ArbolVacioException extends RuntimeException { //Heredamos de RuntimeException para que no haya que capturar necesariamente las excepciones

    public ArbolVacioException() {
        super("El Arbol Binario está vacio");
    }
}
