package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.BbddException;

/**
 * Clase PersonaModelo
 */
public class PersonaModelo {
    Bbdd persistencia;

    /**
     * Constructor de la Clase PersonaModelo
     */
    public PersonaModelo() {
        persistencia = new Bbdd("org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
    }


    /**
     * Metodo que inserta una persona
     * @param persona persona a insertar
     * @throws BbddException error controlado
     */
    public void insertar(Persona persona) throws BbddException{
        persistencia.insertarCliente(persona);
    }

     /**
     * Metodo que modifica un cliente
     * @param cliente cliente a modificar
     * @throws BbddException error controlado
     */
    public void modificar(Cliente cliente) throws BbddException{
        persistencia.modificarCliente(cliente);
    }

     /**
     * Metodo que busca un cliente
     * @param dni dni del cliente
     * @throws BbddException error controlado
     */
    public Cliente buscar(String dni) throws BbddException{
        return persistencia.obtenerCliente(dni);
    }

     /**
     * Metodo que elimina un cliente
     * @param cliente cliente a eliminar
     * @throws BbddException error controlado
     */
    public void eliminar(Cliente cliente) throws BbddException{
        persistencia.eliminarCliente(cliente);
    }  
}
