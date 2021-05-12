package es.iespuertodelacruz.concesionario.controlador;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.api.Empleado;
import es.iespuertodelacruz.concesionario.exception.BbddException;
import es.iespuertodelacruz.concesionario.exception.ClienteException;
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
        if (empleado.getCodigoEmpleado() == null || empleado.getCodigoEmpleado().isEmpty()) {
            mensaje += "El codigo del empleado es nulo o vacio\n";
        }
        if (empleado.getRango() == null || empleado.getRango().isEmpty()) {
            mensaje += "El rango del empleado es nulo o vacio\n";
        }
        if (empleado.getContrasenia() == null || empleado.getContrasenia().isEmpty()) {
            mensaje += "La contraseña del empleado es nulo o vacio\n";
        }
        //TODO: validar direccion?
        if (!mensaje.isEmpty()) {
            throw new EmpleadoException(mensaje);
        }
    }
    /**
     * Metodo encargado de insertar
     * @param empleado empleado a insertar
     * @throws BbddException error controlado
     * @throws EmpleadoException
     */
    public void insertar(Empleado empleado) throws BbddException, EmpleadoException {
        validarEmpleado(empleado);
        if (existe(empleado)) {
            throw new EmpleadoException("El empleado indicado ya existe");
        }
        empleadoModelo.insertar(empleado);
    }

    /**
     * Metodo encargado de elimianr
     * @param empleado empleado a eliminar
     * @throws EmpleadoException error controlado
     * @throws BbddException error controlado
     */
    public void eliminar(Empleado empleado) throws BbddException, EmpleadoException {
        validarEmpleado(empleado);
        if (!existe(empleado)) {
            throw new EmpleadoException("El empleado indicado no existe");
        }
        empleadoModelo.eliminar(empleado);
    }

    /**
     * Metodo encargado de eliminar utilizando el codigo de empleado
     * @param dni dni del empleado
     * @throws EmpleadoException error controlado
     * @throws BbddException error controlado
     */
    public void eliminar(String dni) throws EmpleadoException, BbddException {
        Empleado empleado;
        empleado = buscar(dni);
        eliminar(empleado);
    }

    /**
     * Metodo encargado de modificar
     * @param empleado empleado a modificar
     * @throws EmpleadoException error controlado
     * @throws BbddException error controlado
     */
    public void modificar(Empleado empleado) throws EmpleadoException, BbddException {
        Empleado empleadoAlmacenado;
        validarEmpleado(empleado);
        empleadoAlmacenado = buscar(empleado.getDni());
        if (empleadoAlmacenado == null) {
            throw new EmpleadoException("El empleado indicado no existe");
        }
        empleadoModelo.modificar(empleado);
    }

    /**
     * Metodo encargado de buscar por codigo de empleado
     * @param dni dni del empleado
     * @return empleado encontrado
     * @throws BbddException error controlado
     */
    public Empleado buscar(String dni) throws BbddException {
        Empleado empleado = null;
        empleado = empleadoModelo.buscar(dni);
        return empleado;
    }

    /**
     * Funcion encargada de verificar si existe o no un empleado
     * @param empleado empleado a encontrar
     * @return true/false si existe o no
     * @throws BbddException error controlado
     */
    public boolean existe(Empleado empleado) throws BbddException {
        boolean encontrado = false;
        Empleado empleadoEncontrado;

        empleadoEncontrado = buscar(empleado.getDni());
        if (empleadoEncontrado != null) {
            encontrado = true;
        }

        return encontrado;
    }
}
