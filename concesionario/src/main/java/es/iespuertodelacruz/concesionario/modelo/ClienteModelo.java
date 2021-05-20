package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.exception.BbddException;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase CienteModelo 
 */
public class ClienteModelo {
    SqliteBbdd persistencia;

    private static final String TABLA  = "CUENTA";
    private static final String CLAVE  = "CODIGO";

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
        String sql ="INSERT INTO Cliente (dni,nombre, apellidos" + 
        "fechaNacimiento, telefono, direccion) VALUES ('" + cliente.getDni() + 
        "', '" + cliente.getNombre() + "', '" + cliente.getApellidos() +
         "', '" + cliente.getFechaNacimiento() + "', '" + 
        cliente.getTelefono() + "', '" + cliente.getDireccion() + "'";
        persistencia.actualizar(sql);
    }

     /**
     * Metodo que modifica un cliente
     * @param cliente cliente a modificar
     * @throws PersistenciaException
     */
    public void actualizar(Cliente cliente) throws PersistenciaException {
        String sql = "UPDATE Cliente SET nombre = '" + cliente.getNombre() +
        "', apellidos = '" + cliente.getApellidos() +
        "', fechaNacimiento = '" + cliente.getFechaNacimiento() + "', telefono = '" + 
        cliente.getTelefono() + "', direccion = '" + cliente.getDireccion() +
        "' WHERE dni = '" + cliente.getDni()  + "'";
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
        String sql = "DELETE from Cliente where dni = '" + cliente.getDni() + "'";
        persistencia.actualizar(sql);
    }  
}
