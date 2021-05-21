package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase CienteModelo 
 */
public class ClienteModelo {
    SqliteBbdd persistencia;

    private static final String TABLA  = "Cliente";
    private static final String CLAVE  = "codigoCliente";

    /**
     * Constructor de la Clase ClienteModelo
     * @throws PersistenciaException
     */
    public ClienteModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);

    }

    /**
     * Metodo que inserta un cliente
     * @param cliente cliente a insertar
     * @throws PersistenciaException
     */
    public void insertar(Cliente cliente) throws PersistenciaException {
        String sql ="INSERT INTO Cliente (codigoCliente, dni) VALUES ('" + 
        cliente.getCodigoCliente() + "', '" + cliente.getDni() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica un cliente
     * @param cliente cliente a modificar
     * @throws PersistenciaException
     */
    public void actualizar(Cliente cliente) throws PersistenciaException {
        String sql = "UPDATE Cliente SET dni = '" + cliente.getDni() +
        "' WHERE codigoCliente = '" + cliente.getCodigoCliente()  + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que busca un cliente
     * @param dni dni del cliente
     * @throws PersistenciaException
     */
    public Cliente buscar(String dni) throws PersistenciaException {
        return (Cliente)persistencia.obtenerCliente(dni);
    }

    /**
     * Metodo que elimina un cliente
     * @param cliente cliente a eliminar
     * @throws PersistenciaException
     */
    public void eliminar(Cliente cliente) throws PersistenciaException {
        String sql = "DELETE from Cliente where codigoCliente = '" + 
        cliente.getCodigoCliente() + "'";
        persistencia.actualizar(sql);
    }  
}
