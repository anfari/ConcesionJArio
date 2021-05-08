package es.iespuertodelacruz.concesionario.api;

/**
 * Clase vendedor contiene los datos de un vendedor
 */
public class Vendedor extends Persona{
    int codigoVendedor;
    
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
    public Vendedor(int codigoVendedor, String nombre, String apellidos, 
    String dni, String fechaNacimiento, String telefono,
            Direccion direccion) {
        super(nombre, apellidos, dni, fechaNacimiento, telefono, direccion);
        this.codigoVendedor=codigoVendedor;
    }
    
    
    /**
     * Getter de la clase Vendedor
     * @return codigo de vendedor del vendedor
     */
    public int getCodigoVendedor() {
        return this.codigoVendedor;
    }

    /**
     * Setter de la clase Vendedor
     * @param codigoVendedor codigo de vendedor del vendedor
     */
    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }


    
}
