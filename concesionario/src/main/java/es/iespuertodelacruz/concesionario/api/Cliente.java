package es.iespuertodelacruz.concesionario.api;

import java.util.HashSet;
import java.util.Set;

/**
 * Contiene las caracteristicas extendidas de persona
 */
public class Cliente extends Persona{
    Set <Vehiculo> historial;
    int codigoCliente;

    /**
     * Contructor de cliente con parametros
     * @param codigoCliente codigo del cliente
     * @param nombre nombre del cliente
     * @param apellidos apellidos del cliente
     * @param dni dni del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param telefono teledono del cliente
     * @param direccion direccion del cliente
     */
    public Cliente(int codigoCliente,String nombre, String apellidos, 
    String dni, String fechaNacimiento, String telefono, Direccion direccion) {
        super(nombre, apellidos, dni, fechaNacimiento, telefono, direccion);
        historial = new  HashSet<>();
        this.codigoCliente=codigoCliente;
    }

    
    
}
