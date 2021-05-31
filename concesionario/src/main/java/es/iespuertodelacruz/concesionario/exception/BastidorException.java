package es.iespuertodelacruz.concesionario.exception;

/**
 * Clase BastidorException
 */
public class BastidorException extends Exception{
    private static final long serialVersionUID = 1L;

    /**
     * Constructor con el mensaje personalizado
     * @param mensaje personalizado
     */
     public BastidorException (String mensaje) {
       super(mensaje);
    }
 
    /**
     * Constructor con el mensaje y la exception que se produce
     * @param mensaje de la excepcion
     * @param exception que produce el error
     */
    public BastidorException (String mensaje, Exception exception) {
       super(mensaje, exception);
    }
}
