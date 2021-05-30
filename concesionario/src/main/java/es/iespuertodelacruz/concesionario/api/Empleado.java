package es.iespuertodelacruz.concesionario.api;

/**
 * Clase empleado contiene los datos de un empleado
 */
public class Empleado extends Persona{
    String codigoEmpleado;
    String rango;
    String contrasenia;
    
    /**
     * Constructor por defecto
     */
    public Empleado() {
    }

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
     * @param contrasenia contrasenia del empleado
     */
    public Empleado(String codigoEmpleado, String nombre, String apellidos, 
    String dni, String fechaNacimiento, String telefono, Direccion direccion, 
    String rango, String contrasenia) {
        super(nombre, apellidos, dni, fechaNacimiento, telefono, direccion);
        this.codigoEmpleado = codigoEmpleado;
        this.rango = rango;
        this.contrasenia = contrasenia;
    }


    /**
     * Getter de la clase Empleado
     * @return codigoEmpleado codigo del empleado
     */
    public String getCodigoEmpleado() {
        return this.codigoEmpleado;
    }

    /**
     * Setter de la clase Empleado
     * @param codigoEmpleado codigo del empleado
     */
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    /**
     * Getter de la clase Empleado
     * @return rango de el empleado
     */
    public String getRango() {
        return this.rango;
    }

    /**
     * Setter de la clase Empleado
     * @param rango del empleado
     */
    public void setRango(String rango) {
        this.rango = rango;
    }

    /**
     * Getter de la clase Empleado
     * @return contrasenia de el empleado 
     */
    public String getContrasenia() {
        return this.contrasenia;
    }

    /**
     * Setter de la clase Empleado
     * @param contrasenia del empleado
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Funcion toString de la clase Empleado
     */
    @Override
    public String toString() {
        return getCodigoEmpleado() + ", " + getRango() + ", " + super.toString();
    }

}
