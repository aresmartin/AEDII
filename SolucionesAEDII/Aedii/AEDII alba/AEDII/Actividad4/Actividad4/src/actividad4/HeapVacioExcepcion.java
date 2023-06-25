/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4;

/**
 *
 * @author Alba
 */
public class HeapVacioExcepcion extends Exception {

    /**
     * Creates a new instance of <code>HeapVacioExcepcion</code> without detail
     * message.
     */
    public HeapVacioExcepcion() {
    }

    /**
     * Constructs an instance of <code>HeapVacioExcepcion</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public HeapVacioExcepcion(String msg) {
        super(msg);
    }
}
