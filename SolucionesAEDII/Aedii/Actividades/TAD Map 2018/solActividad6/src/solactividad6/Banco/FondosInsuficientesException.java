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
public class FondosInsuficientesException extends RuntimeException {
    
    public FondosInsuficientesException(){
        super();
    }
    
    public FondosInsuficientesException(String mensaje){
        super(mensaje);
    }
    
}
