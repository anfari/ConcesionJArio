package es.iespuertodelacruz.concesionario.exception;

/**
 * Clase DniException
 */
public class DniException extends Exception {
   private static final long serialVersionUID = 1L;

   /**
    * Constructor con el mensaje personalizado
    * @param mensaje personalizado
    */
    public DniException (String mensaje) {
      super(mensaje);
   }

   /**
    * Constructor con el mensaje y la exception que se produce
    * @param mensaje de la excepcion
    * @param exception que produce el error
    */
   public DniException (String mensaje, Exception exception) {
      super(mensaje, exception);
   }
}
