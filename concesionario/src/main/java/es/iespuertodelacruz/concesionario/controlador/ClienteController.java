package es.iespuertodelacruz.concesionario.controlador;

import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.exception.ClienteException;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.modelo.ClienteModelo;

/**
 * Clase ClienteController
 */
public class ClienteController {
    ClienteModelo clienteModelo;

    /**
     * Constructor de la clase ClienteController
     * @throws PersistenciaException
     */
    public ClienteController() throws PersistenciaException {
        clienteModelo = new ClienteModelo();
    }

    /**
     * Metodo encargado de realizar la validacion del objeto Cliente
     * @param cliente cliente a validar
     * @throws ClienteException error controlado
     */
    public void validarCliente(Cliente cliente) throws ClienteException {
        String mensaje = "";

        if (cliente == null) {
            mensaje = "Se esta intentando validar un objeto vacio";
            throw new ClienteException(mensaje);
        }
        if (cliente.getCodigoCliente() == null || cliente.getCodigoCliente().isEmpty()) {
            mensaje += "El codigo del cliente es nulo o vacio\n";
        }
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            mensaje += "El nombre del cliente es nulo o vacio\n";
        }
        if (cliente.getApellidos() == null || cliente.getApellidos().isEmpty()) {
            mensaje += "Los apellidos del cliente son nulos o vacios\n";
        }
        if (cliente.getDni() == null || cliente.getDni().isEmpty()) {
            mensaje += "El dni del cliente es nulo o vacio\n";
        }
        if (cliente.getFechaNacimiento() == null || cliente.getFechaNacimiento().isEmpty()) {
            mensaje += "La fecha de nacimiento del cliente es nula o vacia\n";
        }
        if (cliente.getTelefono() == null || cliente.getTelefono().isEmpty()) {
            mensaje += "El telefono del cliente es nulo o vacio";
        }
        if (!mensaje.isEmpty()) {
            throw new ClienteException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar
     * @param cliente cliente a insertar
     * @throws ClienteException error controlado
     * @throws PersistenciaException
     * 
     */
    public void insertar(Cliente cliente) throws ClienteException, PersistenciaException {
        validarCliente(cliente);
        if (existe(cliente)) {
            throw new ClienteException("El cliente indicado ya existe");
        }
        clienteModelo.insertar(cliente);
    }

    /**
     * Metodo encargado de elimianr
     * @param cliente cliente a eliminar
     * @throws ClienteException error controlado
     * @throws PersistenciaException
     */
    public void eliminar(Cliente cliente) throws ClienteException, PersistenciaException {
        validarCliente(cliente);
        if (!existe(cliente)) {
            throw new ClienteException("El cliente indicado no existe");
        }
        clienteModelo.eliminar(cliente);
    }

    /**
     * Metodo encargado de eliminar utilizando el codigo de cliente
     * @param dni dni del cliente
     * @throws ClienteException error controlado
     * @throws PersistenciaException
     */
    public void eliminar(String codigoCliente) throws ClienteException, PersistenciaException {
        Cliente cliente;
        cliente = buscar(codigoCliente);
        eliminar(cliente);
    }

    /**
     * Metodo encargado de modificar
     * @param cliente cliente a modificar
     * @throws ClienteException error controlado
     * @throws PersistenciaException
     */
    public void modificar(Cliente cliente) throws ClienteException, PersistenciaException {
        Cliente clienteAlmacenado;
        validarCliente(cliente);
        clienteAlmacenado = buscar(cliente.getDni());
        if (clienteAlmacenado == null) {
            throw new ClienteException("El cliente indicado no existe");
        }
        clienteModelo.actualizar(cliente);
    }

    /**
     * Metodo encargado de buscar por codigo de cliente
     * @param dni dni del cliente
     * @return cliente encontrado
     * @throws PersistenciaException error controlado
     * @throws ClienteException error controlado
     */
    public Cliente buscar(String dni) throws PersistenciaException, ClienteException  {
        Cliente cliente = null;
        cliente = clienteModelo.buscar(dni);
        if (cliente == null) {
            throw new ClienteException("El cliente no existe");
        }
        return cliente;
    }

    /**
     * Funcion que retorna una lista con todos los clientes
     * @return listado con todos los clientes
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Object> listadoClientes() throws PersistenciaException {
        return clienteModelo.listadoClientes();
    }

    /**
     * Funcion encargada de verificar si existe o no un cliente
     * @param cliente cliente a encontrar
     * @return true/false si existe o no
     * @throws PersistenciaException
     */
    public boolean existe(Cliente cliente) throws PersistenciaException  {
        boolean encontrado = false;
        Cliente clienteEncontrado;

        clienteEncontrado = buscar(cliente.getDni());
        if (clienteEncontrado != null) {
            encontrado = true;
        }

        return encontrado;
    }

}
