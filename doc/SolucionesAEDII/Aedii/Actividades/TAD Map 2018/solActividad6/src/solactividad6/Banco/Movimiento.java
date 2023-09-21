/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad6.Banco;

import java.util.Date;


public class Movimiento {
    private static int idMov=0;
    private final Date fechaValor;
    private final String concepto;
    private final float cantidad;
    
    public Movimiento(Date fecha, String con, float cant){
        idMov++;
        fechaValor = fecha;
        concepto = con;
        cantidad = cant;
    }

    public float getCantidad() {
        return cantidad;
    }

    public Date getFechaValor() {
        return fechaValor;
    }

    
    public String getConcepto() {
        return concepto;
    }

  
    
}
