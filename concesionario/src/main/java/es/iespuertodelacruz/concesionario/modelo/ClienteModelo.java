package es.iespuertodelacruz.concesionario.modelo;

import java.util.ArrayList;

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
     * @throws PersistenciaException error controlado
     */
    public ClienteModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);

    }

    /**
     * Constructor para test de la Clase ClienteModelo
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public ClienteModelo(boolean test) throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, "org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);

    }
    

    /**
     * Metodo que inserta un cliente
     * @param cliente cliente a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertar(Cliente cliente) throws PersistenciaException {
        String sql ="INSERT INTO Cliente (codigoCliente, dni) VALUES ('" + 
        cliente.getCodigoCliente() + "', '" + cliente.getDni() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica un cliente
     * @param cliente cliente a modificar
     * @throws PersistenciaException error controlado
     */
    public void actualizar(Cliente cliente) throws PersistenciaException {
        String sql = "UPDATE Cliente SET dni = '" + cliente.getDni() +
        "' WHERE codigoCliente = '" + cliente.getCodigoCliente()  + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que busca un cliente
     * @param dni dni del cliente
     * @throws PersistenciaException error controlado
     */
    public Cliente buscar(String dni) throws PersistenciaException {
        return (Cliente)persistencia.obtenerCliente(dni);
    }

    /**
     * Metodo que elimina un cliente
     * @param cliente cliente a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(Cliente cliente) throws PersistenciaException {
        String sql = "DELETE from Cliente where codigoCliente = '" + 
        cliente.getCodigoCliente() + "'";
        persistencia.actualizar(sql);
    }  

    /**
     * Funcion que retorna una lista con todos los clientes
     * @return listado con todos los clientes
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Cliente> listadoClientes() throws PersistenciaException {
        return persistencia.obtenerListadoClientes();
    }
}
