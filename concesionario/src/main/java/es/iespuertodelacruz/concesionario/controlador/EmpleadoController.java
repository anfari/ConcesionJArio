package es.iespuertodelacruz.concesionario.controlador;


import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Empleado;
import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.DireccionException;
import es.iespuertodelacruz.concesionario.exception.EmpleadoException;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.exception.PersonaException;
import es.iespuertodelacruz.concesionario.modelo.EmpleadoModelo;

/**
 * Clase EmpleadoController
 */
public class EmpleadoController {
    EmpleadoModelo empleadoModelo;
    PersonaController personaController;

    /**
     * Constructor de la clase EmpleadoModelo
     * @throws PersistenciaException
     */
    public EmpleadoController() throws PersistenciaException {
        empleadoModelo = new EmpleadoModelo();
        personaController = new PersonaController();
    }

    /**
     * Constructor para test de la clase EmpleadoController
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public EmpleadoController(boolean test) throws PersistenciaException {
        empleadoModelo = new EmpleadoModelo(true);
        personaController = new PersonaController(true);
    }

    /**
     * Metodo encargado de realizar la validacion del objeto Empleado
     * @param empleado empleado a validar
     * @throws EmpleadoException error controlado
     */
    public void validarEmpleado(Empleado empleado) throws EmpleadoException {
        String mensaje = "";

        if (empleado == null) {
            mensaje = "Se esta intentando validar un objeto vacio";
            throw new EmpleadoException(mensaje);
        }
        if (empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
            mensaje += "El nombre del empleado es nulo o vacio\n";
        }
        if (empleado.getApellidos() == null || empleado.getApellidos().isEmpty()) {
            mensaje += "Los apellidos del empleado son nulos o vacios\n";
        }
        if (empleado.getDni() == null || empleado.getDni().isEmpty()) {
            mensaje += "El dni del empleado es nulo o vacio\n";
        }
        if (empleado.getFechaNacimiento() == null || empleado.getFechaNacimiento().isEmpty()) {
            mensaje += "La fecha de nacimiento del empleado es nula o vacia\n";
        }
        if (empleado.getTelefono() == null || empleado.getTelefono().isEmpty()) {
            mensaje += "El telefono del empleado es nulo o vacio";
        }
        if (empleado.getRango() == null || empleado.getRango().isEmpty()) {
            mensaje += "El rango del empleado es nulo o vacio\n";
        }
        if (empleado.getContrasenia() == null || empleado.getContrasenia().isEmpty()) {
            mensaje += "La contraseña del empleado es nulo o vacio\n";
        }
        if (!mensaje.isEmpty()) {
            throw new EmpleadoException(mensaje);
        }
    }
    
    /**
     * Metodo encargado de insertar
     * @param empleado empleado a insertar
     * @throws EmpleadoException
     * @throws PersistenciaException
     * @throws DireccionException
     * @throws PersonaException
     */
    public void insertar(Empleado empleado) throws  EmpleadoException, PersistenciaException, PersonaException, DireccionException {
        validarEmpleado(empleado);
        if (existe(empleado)) {
            throw new EmpleadoException("El empleado indicado ya existe");
        }
        Persona persona = generarPersona(empleado);
        personaController.insertar(persona);
        empleadoModelo.insertar(empleado);
    }

    /**
     * Metodo encargado de elimianr
     * @param empleado empleado a eliminar
     * @throws EmpleadoException error controlado
     * @throws PersistenciaException
     * @throws DireccionException
     * @throws PersonaException
     */
    public void eliminar(Empleado empleado) throws EmpleadoException, PersistenciaException, PersonaException, DireccionException {
        validarEmpleado(empleado);
        if (!existe(empleado)) {
            throw new EmpleadoException("El empleado indicado no existe");
        }
        Persona persona = generarPersona(empleado);
        personaController.eliminar(persona);
        empleadoModelo.eliminar(empleado);
    }

    /**
     * Metodo encargado de eliminar utilizando el codigo de empleado
     * @param dni dni del empleado
     * @throws EmpleadoException error controlado
     * @throws PersistenciaException
     * @throws DireccionException
     * @throws PersonaException
     */
    public void eliminar(String dni) throws EmpleadoException, PersistenciaException, PersonaException, DireccionException {
        Empleado empleado;
        empleado = buscar(dni);
        eliminar(empleado);
    }

    /**
     * Metodo encargado de modificar
     * @param empleado empleado a modificar
     * @throws EmpleadoException error controlado
     * @throws PersistenciaException
     * @throws DireccionException
     * @throws PersonaException
     */
    public void modificar(Empleado empleado) throws EmpleadoException, PersistenciaException, PersonaException, DireccionException {
        Empleado empleadoAlmacenado;
        validarEmpleado(empleado);
        empleadoAlmacenado = buscar(empleado.getDni());
        if (empleadoAlmacenado == null) {
            throw new EmpleadoException("El empleado indicado no existe");
        }
        Persona persona = generarPersona(empleado);
        personaController.modificar(persona);
        empleadoModelo.modificar(empleado);
    }

    /**
     * Metodo encargado de buscar por codigo de empleado
     * @param dni dni del empleado
     * @return empleado encontrado
     * @throws PersistenciaException
     */
    public Empleado buscar(String dni) throws PersistenciaException  {
        Empleado empleado = null;
        empleado = empleadoModelo.buscar(dni);
        return empleado;
    }
    
     /**
     * Funcion que retorna una lista con todos los empleados
     * @return listado con todos los empleados
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Empleado> listadoEmpleados() throws PersistenciaException {
        return empleadoModelo.listadoEmpleados();
    }
    /**
     * Funcion encargada de verificar si existe o no un empleado
     * @param empleado empleado a encontrar
     * @return true/false si existe o no
     * @throws PersistenciaException
     */
    public boolean existe(Empleado empleado) throws PersistenciaException  {
        boolean encontrado = false;
        Empleado empleadoEncontrado;

        empleadoEncontrado = buscar(empleado.getDni());
        if (empleadoEncontrado != null) {
            encontrado = true;
        }

        return encontrado;
    }

    /**
     * Funcion encargada de generar una Persona a partir de los datos del empleado
     * @param empleado empleado del que generar la persona
     * @return Persona creada
     */
    private Persona generarPersona(Empleado empleado) {
        return new Persona(empleado.getNombre(), empleado.getApellidos(), empleado.getDni(), 
        empleado.getFechaNacimiento(), empleado.getTelefono(), empleado.getDireccion());
    }
    
}
