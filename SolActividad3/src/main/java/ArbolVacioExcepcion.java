public class ArbolVacioExcepcion extends RuntimeException {

    public ArbolVacioExcepcion() {super();} //Constructor sin parametros

    public ArbolVacioExcepcion(String mensaje) {
        super(mensaje);
    }

}
