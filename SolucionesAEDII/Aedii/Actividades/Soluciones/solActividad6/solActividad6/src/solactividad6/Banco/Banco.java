package solactividad6.Banco;




import java.util.Date;
import java.util.Iterator;
import mapa.HashMap;
import mapa.Map;

/**
 * Simula las operaciones basicas que se pueden realizar en un banco
 *
 */
public class Banco {
 
    /**
     * Las cuentas se almacenan en un mapa cuya clave es el codigo de la cuenta
     */
    private final Map<Integer, Cuenta> cuentas;


    /**
     * Constructor. Inicializa el mapa donde se almacenarán las cuentas
     */
    public Banco() {
        cuentas = new HashMap();
    }

    /**
     * Crea una nueva cuenta y la almacena en el mapa que contiene las cuentas
     * del banco
     * @param codigo El codigo de la nueva cuenta
     * @param titular Titular de la nueva cuenta
     */
    public void crearCuenta(int codigo, String titular) {
        Cuenta cuenta = new Cuenta(codigo, titular);
        cuentas.insertar(codigo, cuenta);
    }

    /**
     * Obtiene el balance de una cuenta a fecha actual
     * @param codigo El codigo de la cuenta en la que se desea consultar el
     *        balance
     * @return El balance de la cuenta
     * @throws CuentaNoEncontradaException Se lanza esta excepcion si no se
     *         ha podido encontrar la cuenta
     */
    public float obtenerBalance(int codigo)
            throws CuentaNoEncontradaException {
        Cuenta cuenta = cuentas.get(codigo);
        if (cuenta != null) {
            return cuenta.getSaldo();
        } else {
            throw new CuentaNoEncontradaException("No existe la cuenta: " + codigo);
        }
    }


    /**
     * Realiza un deposito de la cantidad indicada en la cuenta especificada
     * @param codigo Codigo de la cuenta en la que se realiza la operacion
     * @param fecha Fecha en la que se realiza la operacion
     * @param concepto Descripción del motivo de ingreso
     * @param cantidad La cantidad a depositar
     * @return un booleano que indica si se ha podido realizar la operacion o no
     *         (por ejemplo, si la cantidad es negativa)
     * @throws CuentaNoEncontradaException Se lanza esta excepcion si la cuenta
     *         no se ha encontrado en el banco
     */
    public boolean depositar(int codigo, Date fecha, String concepto, float cantidad)
            throws CuentaNoEncontradaException{
    
        Cuenta cuenta = cuentas.get(codigo);
    
        if (cantidad <=0) {
            System.out.println("Cantidad negativa");
            return false;
        }
        else if (cuenta==null) throw new CuentaNoEncontradaException("No existe, la cuenta: " + codigo);

        cuenta.depositar(fecha, concepto, cantidad);
        return true;
    }

    /**
     * Retira la cantidad indicada de la cuenta especificada
     * @param codigo Codigo de la cuenta en la que se realiza la operacion
     * @param fecha Fecha en la que se realiza la operacion
     * @param concepto Descripción del motivo de retiro
     * @param cantidad La cantidad a retirar
     * @throws FondosInsuficientesException Se lanza si la cuenta no dispone
     *         de fondos suficientes
     * @throws CuentaNoEncontradaException Se lanza esta excepcion si la cuenta
     *         no se ha encontrado en el banco
     */
    public void retirar(int codigo, Date fecha, String concepto, float cantidad)
            throws FondosInsuficientesException, CuentaNoEncontradaException{
    
        Cuenta cuenta = cuentas.get(codigo);
        
        if (cuenta==null) throw new CuentaNoEncontradaException("No existe, la cuenta: " + codigo);
        if (cantidad > cuenta.getSaldo())
            throw new FondosInsuficientesException("Saldo insuficiente, cuenta: "+codigo);

        cuenta.retirar(fecha, concepto, cantidad);
    }
            
    /**
     * Realiza una transferencia entre dos cuentas bancarias
     * @param codigo1 Codigo de la cuenta en la que se retira la cantidad
     * @param codigo2 Codigo de la cuenta en la que se ingresa la cantidad
     * @param fecha Fecha en la que se realiza la operacion
     * @param cantidad La cantidad a transferir
     * @return un booleano que indica si se ha podido realizar la operacion o no
     *         (por ejemplo, si la cantidad es negativa)
     * @throws FondosInsuficientesException Se lanza si la cuenta 1 no dispone
     *         de fondos suficientes
     * @throws CuentaNoEncontradaException Se lanza esta excepcion si no se ha
     *         encontrado alguna de las cuentas
     */
    public boolean transferencia(int codigo1, int codigo2, Date fecha, float cantidad)
            throws CuentaNoEncontradaException, FondosInsuficientesException{
        
        Cuenta cuenta1 = cuentas.get(codigo1);
        Cuenta cuenta2 = cuentas.get(codigo2);
        
        if (cuenta1== null || cuenta2 == null) throw new CuentaNoEncontradaException("No existe una de las dos cuentas");
        
        if (cuenta1.getSaldo() < cantidad) throw new FondosInsuficientesException("Saldo insuficiente, cuenta: "+codigo1);
        
        if (cantidad <= 0){
            System.out.println("Cantidad negativa");
            return false;
        }
        else {
            cuenta1.retirar(fecha, ("Transferencia a la cuenta "+codigo2), cantidad);
            cuenta2.depositar(fecha, ("Transferencia de la cuenta "+codigo1), cantidad);
            return true;
        }

    }
            
    /**
     * Obtiene el balance de una cuenta a en la fecha indicada. Se obtienen
     * los movimientos de la cuenta entre la fecha especificada y la fecha actual
     * y se "deshacen" las operaciones.
     * @param codigo El codigo de la cuenta en la que se desea consultar el
     *        balance
     * @param fecha Fecha en la que se consulta el balance
     * @return El balance de la cuenta
     * @throws CuentaNoEncontradaException Se lanza esta excepcion si no se
     *         ha podido encontrar la cuenta
     */
    /*@SuppressWarnings("empty-statement")
    public float obtenerBalance(int codigo, Date fecha)
            throws CuentaNoEncontradaException{
        
        Cuenta cuenta = cuentas.get(codigo);
        
        if (cuenta==null) throw new CuentaNoEncontradaException("No existe, la cuenta: " + codigo);
        
        Lista<Movimiento> movimientos=cuenta.getListMovimientos();
        Iterator<Movimiento> iter = movimientos.iterator();
        while (iter.hasNext() && iter.next().getFechaValor().compareTo(fecha)<0); //Salto movimientos anteriores a fecha
        
        float saldoAFecha=cuenta.getSaldo();
        while (iter.hasNext()){ // Deshago los movimientos hasta el final
            saldoAFecha-=iter.next().getCantidad();
        }
        return saldoAFecha;
        
    }*/
            
    @Override
    public String toString() {

        String cuentaS = "";
        Iterator<Cuenta> iter = cuentas.getValores();
        
        while (iter.hasNext()) {
            cuentaS += iter.next().toString() + "\n";
        }

        return cuentaS;
    }
}



