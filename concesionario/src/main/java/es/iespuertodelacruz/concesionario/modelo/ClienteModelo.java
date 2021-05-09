package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.exception.BbddException;

/**
 * Clase CienteModelo 
 */
public class ClienteModelo {
    Bbdd persistencia;

    /**
     * Constructor de la Clase ClienteModelo
     */
    public ClienteModelo() {
        persistencia = new Bbdd("org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
    }


    /**
     * Metodo que inserta un cliente
     * @param cliente cliente a insertar
     * @throws BbddException error controlado
     */
    public void insertar(Cliente cliente) throws BbddException{
        persistencia.insertarCliente(cliente);
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
     * @param codigoCliente codigo del cliente a buscar
     * @throws BbddException error controlado
     */
    public Cliente buscar(int codigoCliente) throws BbddException{
        return persistencia.obtenerCliente(codigoCliente);
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
