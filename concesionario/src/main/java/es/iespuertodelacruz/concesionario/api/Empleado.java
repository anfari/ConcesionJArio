package es.iespuertodelacruz.concesionario.api;

/**
 * Clase vendedor contiene los datos de un vendedor
 */
public class Empleado extends Persona{
    String codigoEmpleado;
    String rango;
    String contraseña;
    
    /**
     * Constructor de vendedor con parametros
     * @param nombre nombre del cliente
     * @param apellidos apellidos del cliente
     * @param dni dni del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param telefono teledono del cliente
     * @param direccion objeto direccion del vendedor
     * @param codigoEmpleado identidicador de empleado
     * @param rango cargo que ocupa el empleado
     * @param contraseña contraseña del empleado
     */
    public Empleado(String nombre, String apellidos, 
    String dni, String fechaNacimiento, String telefono,
    Direccion direccion, 
    String codigoEmpleado, String rango, String contraseña) {
        super(nombre, apellidos, dni, fechaNacimiento, telefono, direccion);
        this.codigoEmpleado = codigoEmpleado;
        this.rango = rango;
        this.contraseña = contraseña;
    }

    public String getCodigoEmpleado() {
        return this.codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getRango() {
        return this.rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
