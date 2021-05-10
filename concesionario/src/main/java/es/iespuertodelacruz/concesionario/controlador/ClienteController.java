package es.iespuertodelacruz.concesionario.controlador;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.exception.BbddException;
import es.iespuertodelacruz.concesionario.exception.ClienteException;
import es.iespuertodelacruz.concesionario.modelo.ClienteModelo;

/**
 * Clase ClienteController
 */
public class ClienteController {
    ClienteModelo clienteModelo;

    /**
     * Constructor de la clase ClienteController
     */
    public ClienteController() {
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
        //TODO: validar direccion?
        if (!mensaje.isEmpty()) {
            throw new ClienteException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar
     * @param cliente cliente a insertar
     * @throws ClienteException error controlado
     * @throws BbddException error controlado
     */
    public void insertar(Cliente cliente) throws ClienteException, BbddException {
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
     * @throws BbddException error controlado
     */
    public void eliminar(Cliente cliente) throws ClienteException, BbddException {
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
     * @throws BbddException error controlado
     */
    public void eliminar(String dni) throws ClienteException, BbddException {
        Cliente cliente;
        cliente = buscar(dni);
        eliminar(cliente);
    }

    /**
     * Metodo encargado de modificar
     * @param cliente cliente a modificar
     * @throws ClienteException error controlado
     * @throws BbddException error controlado
     */
    public void modificar(Cliente cliente) throws ClienteException, BbddException {
        Cliente clienteAlmacenado;
        validarCliente(cliente);
        clienteAlmacenado = buscar(cliente.getDni());
        if (clienteAlmacenado == null) {
            throw new ClienteException("El cliente indicado no existe");
        }
        clienteModelo.modificar(cliente);
    }

    /**
     * Metodo encargado de buscar por codigo de cliente
     * @param dni dni del cliente
     * @return cliente encontrado
     * @throws BbddException error controlado
     */
    public Cliente buscar(String dni) throws BbddException {
        Cliente cliente = null;
        cliente = clienteModelo.buscar(dni);
        return cliente;
    }

    /**
     * Funcion encargada de verificar si existe o no un cliente
     * @param cliente cliente a encontrar
     * @return true/false si existe o no
     * @throws BbddException error controlado
     */
    public boolean existe(Cliente cliente) throws BbddException {
        boolean encontrado = false;
        Cliente clienteEncontrado;

        clienteEncontrado = buscar(cliente.getDni());
        if (clienteEncontrado != null) {
            encontrado = true;
        }

        return encontrado;
    }

}
