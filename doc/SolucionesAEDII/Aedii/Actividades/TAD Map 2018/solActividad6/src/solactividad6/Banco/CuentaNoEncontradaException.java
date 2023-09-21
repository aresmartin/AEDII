/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad6.Banco;

/**
 *
 * @author Rosalia
 */
public class CuentaNoEncontradaException extends RuntimeException {
    
    public CuentaNoEncontradaException(){
        super();
    }
    
    public CuentaNoEncontradaException(String mensaje){
        super(mensaje);
    }
    
}
