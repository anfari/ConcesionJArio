package es.iespuertodelacruz.concesionario.controlador;

import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.BbddException;
import es.iespuertodelacruz.concesionario.exception.PersonaException;
import es.iespuertodelacruz.concesionario.modelo.PersonaModelo;

/**
 * Clase PersonaController
 */
public class PersonaController {
    PersonaModelo personaModelo;

    /**
     * Constructor de la clase PersonaController
     */
    public PersonaController() {
        personaModelo = new PersonaModelo();
    }
    

    /**
     * Metodo encargado de realizar la validacion del objeto Persona
     * @param persona persona a validar
     * @throws PersonaException error controlado
     */
    public void validarCliente(Persona persona) throws PersonaException {
        String mensaje = "";

        if (persona == null) {
            mensaje = "Se esta intentando validar un objeto vacio";
            throw new PersonaException(mensaje);
        }
        if (persona.getNombre() == null || persona.getNombre().isEmpty()) {
            mensaje += "El nombre de la persona es nulo o vacio\n";
        }
        if (persona.getApellidos() == null || persona.getApellidos().isEmpty()) {
            mensaje += "Los apellidos de la persona son nulos o vacios\n";
        }
        if (persona.getDni() == null || persona.getDni().isEmpty()) {
            mensaje += "El dni de la persona es nulo o vacio\n";
        }
        if (persona.getFechaNacimiento() == null || persona.getFechaNacimiento().isEmpty()) {
            mensaje += "La fecha de nacimiento de la persona es nula o vacia\n";
        }
        if (persona.getTelefono() == null || persona.getTelefono().isEmpty()) {
            mensaje += "El telefono de la persona es nulo o vacio";
        }
        //TODO: validar direccion?
        if (!mensaje.isEmpty()) {
            throw new PersonaException(mensaje);
        }
    }


    /**
     * Metodo encargado de insertar
     * @param persona persona a insertar
     * @throws BbddException error controlado
     * @throws PersonaException error controlado
     */
    public void insertar(Persona persona) throws BbddException, PersonaException {
        validarCliente(persona);
        if (existe(persona)) {
            throw new PersonaException("El cliente indicado ya existe");
        }
        personaModelo.insertar(persona);
    }

    /**
     * Metodo encargado de elimianr
     * @param persona persona a eliminar
     * @throws BbddException error controlado
     * @throws PersonaException error controlado
     */
    public void eliminar(Persona persona) throws BbddException, PersonaException {
        validarCliente(persona);
        if (!existe(persona)) {
            throw new PersonaException("El cliente indicado no existe");
        }
        personaModelo.eliminar(persona);
    }

    /**
     * Metodo encargado de eliminar
     * @param dni dni de la persona
     * @throws BbddException error controlado
     * @throws PersonaException error controlado
     */
    public void eliminar(String dni) throws BbddException, PersonaException {
        Persona persona;
        persona = buscar(dni);
        eliminar(persona);
    }

    /**
     * Metodo encargado de modificar
     * @param persona persona a modificar
     * @throws ClienteException error controlado
     * @throws BbddException error controlado
     * @throws PersonaException error controlado
     */
    public void modificar(Persona persona) throws BbddException, PersonaException {
        Persona personaAlmacenada;
        validarCliente(persona);
        personaAlmacenada = buscar(persona.getDni());
        if (personaAlmacenada == null) {
            throw new PersonaException("El cliente indicado no existe");
        }
        personaModelo.modificar(persona);
    }

    /**
     * Metodo encargado de buscar
     * @param dni dni de la persona
     * @return persona encontrada
     * @throws BbddException error controlado
     */
    public Persona buscar(String dni) throws BbddException {
        Persona persona = null;
        persona = personaModelo.buscar(dni);
        return persona;
    }

    /**
     * Funcion encargada de verificar si existe o no una persona
     * @param persona persona a encontrar
     * @return true/false si existe o no
     * @throws BbddException error controlado
     */
    public boolean existe(Persona persona) throws BbddException {
        boolean encontrado = false;
        Persona personaeEncontrada;

        personaeEncontrada = buscar(persona.getDni());
        if (personaeEncontrada != null) {
            encontrado = true;
        }

        return encontrado;
    }

}
