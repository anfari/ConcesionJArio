package es.iespuertodelacruz.concesionario.controlador;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.*;
import es.iespuertodelacruz.concesionario.modelo.PersonaModelo;

/**
 * Clase PersonaController
 */
public class PersonaController extends Validaciones {
    PersonaModelo personaModelo;
    DireccionController direccionController;

    /**
     * Constructor de la clase PersonaController
     * @throws PersistenciaException error controlado
     */
    public PersonaController() throws PersistenciaException {
        personaModelo = new PersonaModelo();
        direccionController = new DireccionController();
    }

    /**
     * Constructor para test de la clase PersonaController
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public PersonaController(boolean test) throws PersistenciaException {
        personaModelo = new PersonaModelo(true);
        direccionController = new DireccionController(true);
    }
    

    /**
     * Metodo encargado de realizar la validacion del objeto Persona
     * @param persona persona a validar
     * @throws PersonaException error controlado
     */
    public void validarPersona(Persona persona) throws PersonaException {
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
        if (persona.getDni() == null || persona.getDni().isEmpty() || !validarDni(persona.getDni())) {
            mensaje += "El dni de la persona es nulo, vacio o invalido\n";
        }
        if (persona.getFechaNacimiento() == null || persona.getFechaNacimiento().isEmpty()) {
            mensaje += "La fecha de nacimiento de la persona es nula o vacia\n";
        }
        if (persona.getTelefono() == null || persona.getTelefono().isEmpty()) {
            mensaje += "El telefono de la persona es nulo o vacio";
        }
        if (!mensaje.isEmpty()) {
            throw new PersonaException(mensaje);
        }
    }


    /**
     * Metodo encargado de insertar
     * @param persona persona a insertar
     * @throws PersonaException error controlado
     * @throws PersistenciaException error controlado
     * @throws DireccionException error controlado
     */
    public void insertar(Persona persona) throws PersonaException, PersistenciaException, DireccionException {
        validarPersona(persona);
        if (existe(persona)) {
            throw new PersonaException("La persona indicada ya existe");
        }
        Direccion direccion = persona.getDireccion();
        direccionController.insertar(direccion);
        personaModelo.insertar(persona);
    }

    /**
     * Metodo encargado de eliminar
     * @param persona persona a eliminar
     * @throws PersonaException error controlado
     * @throws PersistenciaException error controlado
     * @throws DireccionException error controlado
     */
    public void eliminar(Persona persona) throws PersonaException, PersistenciaException, DireccionException {        
        validarPersona(persona);
        if (!existe(persona)) {
            throw new PersonaException("La persona indicada no existe");
        }
        Direccion direccion = persona.getDireccion();
        direccionController.eliminar(direccion);
        personaModelo.eliminar(persona);
    }

    /**
     * Metodo encargado de eliminar
     * @param dni dni de la persona
     * @throws PersonaException error controlado
     * @throws PersistenciaException error controlado
     * @throws DireccionException error controlado
     */
    public void eliminar(String dni) throws PersonaException, PersistenciaException, DireccionException {
        Persona persona;
        persona = buscar(dni);
        eliminar(persona);
    }

    /**
     * Metodo encargado de modificar
     * @param persona persona a modificar
     * @throws PersonaException error controlado
     * @throws PersistenciaException error controlado
     * @throws DireccionException error controlado
     */
    public void modificar(Persona persona) throws PersonaException, PersistenciaException, DireccionException {
        Persona personaAlmacenada;
        validarPersona(persona);
        personaAlmacenada = buscar(persona.getDni());
        if (personaAlmacenada == null) {
            throw new PersonaException("La persona indicada no existe");
        }
        Direccion direccion = persona.getDireccion();
        direccionController.modificar(direccion);
        personaModelo.modificar(persona);
    }

    /**
     * Metodo encargado de buscar
     * @param dni dni de la persona
     * @return persona encontrada
     * @throws PersistenciaException error controlado
     */
    public Persona buscar(String dni) throws PersistenciaException  {
        Persona persona = null;
        persona = personaModelo.buscar(dni);
        return persona;
    }

    /**
     * Funcion encargada de verificar si existe o no una persona
     * @param persona persona a encontrar
     * @return true/false si existe o no
     * @throws PersistenciaException error controlado
     */
    public boolean existe(Persona persona) throws PersistenciaException  {
        boolean encontrado = false;
        Persona personaeEncontrada;

        personaeEncontrada = buscar(persona.getDni());
        if (personaeEncontrada != null) {
            encontrado = true;
        }

        return encontrado;
    }

}
