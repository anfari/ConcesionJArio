package es.iespuertodelacruz.concesionario.api;

/**
 * Clase vendedor contiene los datos de un vendedor
 */
public class Vendedor extends Persona{
    
    /**
     * Constructor de vendedor con parametros
     * @param codigoVendedor codigo del vendedor
     * @param nombre nombre del cliente
     * @param apellidos apellidos del cliente
     * @param dni dni del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param telefono teledono del cliente
     * @param direccion objeto direccion del vendedor
     */
    public Vendedor(String nombre, String apellidos, 
    String dni, String fechaNacimiento, String telefono,
            Direccion direccion) {
        super(nombre, apellidos, dni, fechaNacimiento, telefono, direccion);
    }
}
