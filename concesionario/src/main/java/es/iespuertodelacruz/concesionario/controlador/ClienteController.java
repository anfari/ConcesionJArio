package es.iespuertodelacruz.concesionario.controlador;

import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.ClienteException;
import es.iespuertodelacruz.concesionario.exception.DireccionException;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.exception.PersonaException;
import es.iespuertodelacruz.concesionario.modelo.ClienteModelo;

/**
 * Clase ClienteController
 */
public class ClienteController extends Validaciones {
    ClienteModelo clienteModelo;
    PersonaController personaController;

    /**
     * Constructor de la clase ClienteController
     * @throws PersistenciaException error controlado
     */
    public ClienteController() throws PersistenciaException {
        clienteModelo = new ClienteModelo();
        personaController = new PersonaController();
    }

    /**
     * Constructor para test de la clase ClienteController
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public ClienteController(boolean test) throws PersistenciaException {
        clienteModelo = new ClienteModelo(true);
        personaController = new PersonaController(true);
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
        if (cliente.getDni() == null || cliente.getDni().isEmpty() || !validarDni(cliente.getDni())) {
            mensaje += "El dni del cliente es nulo, vacio o invalido\n";
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
     * @throws PersistenciaException error controlado
     * @throws PersonaException error controlado
     * @throws DireccionException error controlado
     * 
     */
    public void insertar(Cliente cliente) throws ClienteException, PersistenciaException, PersonaException, DireccionException {
        validarCliente(cliente);
        if (existe(cliente)) {
            throw new ClienteException("El cliente indicado ya existe");
        }
        Persona persona = generarPersona(cliente);
        personaController.insertar(persona);
        clienteModelo.insertar(cliente);
    }

    /**
     * Metodo encargado de elimianr
     * @param cliente cliente a eliminar
     * @throws ClienteException error controlado
     * @throws PersistenciaException error controlado
     * @throws PersonaException error controlado
     * @throws DireccionException error controlado
     */
    public void eliminar(Cliente cliente) throws ClienteException, PersistenciaException, PersonaException, DireccionException {
        validarCliente(cliente);
        if (!existe(cliente)) {
            throw new ClienteException("El cliente indicado no existe");
        }
        Persona persona = generarPersona(cliente);
        personaController.eliminar(persona);
        clienteModelo.eliminar(cliente);
    }

    /**
     * Metodo encargado de eliminar utilizando el dni
     * @param dni dni del cliente
     * @throws ClienteException error controlado
     * @throws PersistenciaException error controlado
     * @throws PersonaException error controlado
     * @throws DireccionException error controlado
     */
    public void eliminar(String dni) throws ClienteException, PersistenciaException, PersonaException, DireccionException {
        Cliente cliente;
        cliente = buscar(dni);
        eliminar(cliente);
    }

    /**
     * Metodo encargado de modificar
     * @param cliente cliente a modificar
     * @throws ClienteException error controlado
     * @throws PersistenciaException error controlado
     * @throws PersonaException error controlado
     * @throws DireccionException error controlado
     */
    public void modificar(Cliente cliente) throws ClienteException, PersistenciaException, PersonaException, DireccionException {
        Cliente clienteAlmacenado;
        validarCliente(cliente);
        clienteAlmacenado = buscar(cliente.getDni());
        if (clienteAlmacenado == null) {
            throw new ClienteException("El cliente indicado no existe");
        }
        Persona persona = generarPersona(cliente);
        personaController.modificar(persona);
        clienteModelo.modificar(cliente);
    }

    /**
     * Funcion encargada de buscar por dni
     * @param dni dni del cliente
     * @return cliente encontrado
     * @throws PersistenciaException error controlado
     * @throws ClienteException error controlado
     */
    public Cliente buscar(String dni) throws PersistenciaException, ClienteException  {
        Cliente cliente = null;
        cliente = clienteModelo.buscar(dni);
        return cliente;
    }

    /**
     * Funcion que retorna una lista con todos los clientes
     * @return listado con todos los clientes
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Cliente> listadoClientes() throws PersistenciaException {
        return clienteModelo.listadoClientes();
    }

    /**
     * Funcion encargada de verificar si existe o no un cliente
     * @param cliente cliente a encontrar
     * @return true/false si existe o no
     * @throws PersistenciaException error controlado
     * @throws ClienteException error controlado
     */
    public boolean existe(Cliente cliente) throws PersistenciaException, ClienteException  {
        boolean encontrado = false;
        Cliente clienteEncontrado;

        clienteEncontrado = buscar(cliente.getDni());
        if (clienteEncontrado != null) {
            encontrado = true;
        }

        return encontrado;
    }


    /**
     * Funcion encargada de generar una Persona a partir de los datos del cliente
     * @param cliente cliente del que generar la persona
     * @return Persona creada
     */
    public Persona generarPersona(Cliente cliente) {
        return new Persona(cliente.getNombre(), cliente.getApellidos(), cliente.getDni(), 
        cliente.getFechaNacimiento(), cliente.getTelefono(), cliente.getDireccion());
    }

}
