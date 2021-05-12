package es.iespuertodelacruz.concesionario.controlador;

import es.iespuertodelacruz.concesionario.api.Empleado;
import es.iespuertodelacruz.concesionario.exception.EmpleadoException;
import es.iespuertodelacruz.concesionario.modelo.EmpleadoModelo;

/**
 * Clase EmpleadoController
 */
public class EmpleadoController {
    EmpleadoModelo empleadoModelo;

    /**
     * Constructor de la clase EmpleadoModelo
     */
    public EmpleadoController() {
        empleadoModelo = new EmpleadoModelo();
    }

    /**
     * Metodo encargado de realizar la validacion del objeto Empleado
     * @param empleado empleado a validar
     * @throws EmpleadoException error controlado
     */
    public void validarCliente(Empleado empleado) throws EmpleadoException {
        String mensaje = "";

        if (empleado == null) {
            mensaje = "Se esta intentando validar un objeto vacio";
            throw new EmpleadoException(mensaje);
        }
        if (empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
            mensaje += "El nombre del cliente es nulo o vacio\n";
        }
        if (empleado.getApellidos() == null || empleado.getApellidos().isEmpty()) {
            mensaje += "Los apellidos del cliente son nulos o vacios\n";
        }
        if (empleado.getDni() == null || empleado.getDni().isEmpty()) {
            mensaje += "El dni del cliente es nulo o vacio\n";
        }
        if (empleado.getFechaNacimiento() == null || empleado.getFechaNacimiento().isEmpty()) {
            mensaje += "La fecha de nacimiento del cliente es nula o vacia\n";
        }
        if (empleado.getTelefono() == null || empleado.getTelefono().isEmpty()) {
            mensaje += "El telefono del cliente es nulo o vacio";
        }
        //TODO: validar direccion?
        if (!mensaje.isEmpty()) {
            throw new EmpleadoException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar
     * @param empleado empleado a insertar
     * @throws ClienteException error controlado
     * @throws BbddException error controlado
     */
    public void insertar(Empleado empleado) throws BbddException {
        validarCliente(empleado);
        if (existe(empleado)) {
            throw new EmpleadoException("El cliente indicado ya existe");
        }
        empleadoModelo.insertar(empleado);
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
