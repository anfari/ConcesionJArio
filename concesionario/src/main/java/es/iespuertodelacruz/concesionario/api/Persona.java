package es.iespuertodelacruz.concesionario.api;
/**
 * Clase Persona  que contiene las carateristicas de una persona
 */
public class Persona {
    String nombre;
    String apellidos;
    String dni;
    String fechaNacimiento;
    String telefono;
    Direccion direccion;

    /**
     * Constructor de persona con parametros 
     * @param nombre nombre del cliente
     * @param apellidos apellidos del cliente
     * @param dni dni del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param telefono teledono del cliente
     * @param direccion objeto direccion
     */
    public Persona(String nombre, String apellidos, String dni, 
    String fechaNacimiento, String telefono, Direccion direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }

}
