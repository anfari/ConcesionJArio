package es.iespuertodelacruz.concesionario.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase CienteModelo 
 */
public class ClienteModelo {
    SqliteBbdd persistencia;
    PersonaModelo personaModelo;
    private static final String TABLA  = "Cliente";
    private static final String CLAVE  = "codigoCliente";

    /**
     * Constructor de la Clase ClienteModelo
     * @throws PersistenciaException error controlado
     */
    public ClienteModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);
        personaModelo = new PersonaModelo();

    }

    /**
     * Constructor para test de la Clase ClienteModelo
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public ClienteModelo(boolean test) throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, "org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
        personaModelo = new PersonaModelo(true);
    }
    

    /**
     * Metodo que inserta un cliente
     * @param cliente cliente a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertar(Cliente cliente) throws PersistenciaException {
        String sql ="INSERT INTO Cliente (codigoCliente, dni) VALUES (" + 
        cliente.getCodigoCliente() + ", '" + cliente.getDni() + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica un cliente
     * @param cliente cliente a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificar(Cliente cliente) throws PersistenciaException {
        String sql = "UPDATE Cliente SET dni = '" + cliente.getDni() +
        "' WHERE codigoCliente = '" + cliente.getCodigoCliente()  + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina un cliente
     * @param cliente cliente a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(Cliente cliente) throws PersistenciaException {
        String sql = "DELETE from Cliente where dni = '" + 
        cliente.getDni() + "'";
        persistencia.actualizar(sql);
    } 

    /**
     * Funcion que busca un cliente especifico
     * @param dni dni del cliente
     * @return Cliente encontrado
     * @throws PersistenciaException error controlado
     */
    public Cliente buscar(String dni) throws PersistenciaException  {
        Cliente cliente = null;
        ArrayList<Cliente> listaClientes = null;
        String sql = "SELECT * FROM Cliente where dni = ";
        sql = sql + "'" + dni + "'";
        listaClientes = convertir(sql);
        if (!listaClientes.isEmpty()) {
            cliente = listaClientes.get(0);
        }

        return cliente;
    }

    /**
     * Funcion busca todos los clientes guardados
     * @return lista de todos los clientes
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Cliente> listadoClientes() throws PersistenciaException  {
        String sql = "SELECT * FROM Cliente";
        return convertir(sql);
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Cliente
     * @param sql a ejecutar
     * @return lista de resultados
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Cliente> convertir(String sql) throws PersistenciaException {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            resultSet = persistencia.buscarElementos(sql);

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                String dni = resultSet.getString("dni");
                cliente.setCodigoCliente(resultSet.getString("codigoCliente"));
                cliente.setDni(dni);
                Persona persona = personaModelo.buscar(dni);
                cliente.setNombre(persona.getNombre());
                cliente.setApellidos(persona.getApellidos());
                cliente.setFechaNacimiento(persona.getFechaNacimiento());
                cliente.setTelefono(persona.getTelefono());
                cliente.setDireccion(persona.getDireccion());
                listaClientes.add(cliente);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return listaClientes;
    }


}
