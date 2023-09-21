/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad3;


public class ArbolVacioExcepcion extends RuntimeException
{
    public ArbolVacioExcepcion()
    {
        super();
    }
    
    public ArbolVacioExcepcion(String mensaje)
    {
        super(mensaje);
    }
}  
