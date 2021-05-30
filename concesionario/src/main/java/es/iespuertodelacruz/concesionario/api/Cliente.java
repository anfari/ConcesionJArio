package es.iespuertodelacruz.concesionario.api;

/**
 * Contiene las caracteristicas extendidas de persona
 */
public class Cliente extends Persona{
    String codigoCliente;

    /**
     * Constructor por defecto
     */
    public Cliente() {
    }

    /**
     * Contructor de cliente con parametros
     * @param nombre nombre del cliente
     * @param apellidos apellidos del cliente
     * @param dni dni del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param telefono teledono del cliente
     * @param direccion direccion del cliente
     * @param codigoCliente codigo del cliente
     */
    public Cliente(String codigoCliente,String nombre, String apellidos, 
    String dni, String fechaNacimiento, String telefono, Direccion direccion) {
        super(nombre, apellidos, dni, fechaNacimiento, telefono, direccion);
        this.codigoCliente= codigoCliente;
    }


    /**
     * Getter de la clase Cliente
     * @return codigo del cliente
     */
    public String getCodigoCliente() {
        return this.codigoCliente;
    }

    /**
     * Setter de la clase Cliente
     * @param codigoCliente codigo del cliente
     */
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    
    /**
     * Funcion toString de la clase Cliente
     */
    @Override
    public String toString() {
        return getCodigoCliente() + ", " + super.toString();
    }
    
}
