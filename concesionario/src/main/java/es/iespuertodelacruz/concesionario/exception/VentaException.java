package es.iespuertodelacruz.concesionario.exception;
/**
 * Clase VentaException donde vamos a controlar las excepciones de ventas
 */
public class VentaException  extends Exception{
    private static final long serialVersionUID = 1L;

    /**
     * Constructor con el mensaje personalizado
     * @param mensaje personalizado
     */
     public VentaException (String mensaje) {
       super(mensaje);
    }
 
    /**
     * Constructor con el mensaje y la exception que se produce
     * @param mensaje de la excepcion
     * @param exception que produce el error
     */
    public VentaException (String mensaje, Exception exception) {
       super(mensaje, exception);
    }
}
