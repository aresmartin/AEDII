/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad6.Banco;

import java.util.Date;
import lista.Lista;
import lista.ListaEnlazada;


public class Cuenta {
    private final int codigo;
    private final String titular;
    private final Lista<Movimiento> listMovimientos;
    private float saldo;

    public Cuenta(int codigo, String titular) {
        this.codigo = codigo;
        this.titular = titular;
        this.listMovimientos = new ListaEnlazada<>();
        this.saldo=0;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitular() {
        return titular;
    }

    public Lista<Movimiento> getListMovimientos() {
        return listMovimientos;
    }

    public float getSaldo() {
        return saldo;
    }
       
    /**
     * Realiza un deposito de la cantidad indicada
     * @param fecha Fecha en la que se realiza la operacion
     * @param concepto Descripción del motivo de ingreso
     * @param cantidad La cantidad a depositar
     */
    public void depositar(Date fecha, String concepto, float cantidad){
      listMovimientos.insertarFinal(new Movimiento(fecha,concepto,cantidad));
      saldo+=cantidad;
    }
    
    /**
     * Retira la cantidad indicada
     * @param fecha Fecha en la que se realiza la operacion
     * @param concepto Descripción del motivo de retiro
     * @param cantidad La cantidad a retirar
     */
    public void retirar(Date fecha, String concepto, float cantidad){
    listMovimientos.insertarFinal(new Movimiento(fecha,concepto,(-1 *cantidad)));
    saldo-=cantidad;
    }
    
    @Override
    public String toString(){
        return codigo+"---"+saldo;
    }
    
}

