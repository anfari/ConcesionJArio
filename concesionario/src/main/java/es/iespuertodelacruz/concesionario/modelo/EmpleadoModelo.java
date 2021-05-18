package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Empleado;
import es.iespuertodelacruz.concesionario.exception.BbddException;
/**
 * Clase EmpleadoModelo que gestiona los datos de empleados
 */
public class EmpleadoModelo {
    Bbdd persistencia;

    /**
     * Constructor de la Clase EmpleadoModelo
     */
    public EmpleadoModelo() {
        persistencia = new Bbdd("org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
    }


    /**
     * Metodo que inserta un empleado
     * @param empleado empleado a insertar
     * @throws BbddException error controlado
     */
    public void insertar(Empleado empleado) throws BbddException{
        persistencia.insertarEmpleado(empleado);
    }

     /**
     * Metodo que modifica un empleado
     * @param empleado empleado a modificar
     * @throws BbddException error controlado
     */
    public void modificar(Empleado empleado) throws BbddException{
        persistencia.modificarEmpleado(empleado);
    }

     /**
     * Metodo que busca un empleado
     * @param empleado empleado a buscar
     * @throws BbddException error controlado
     */
    public Empleado buscar(String dni) throws BbddException{
        return persistencia.obtenerEmpleado(dni);
    }

     /**
     * Metodo que elimina un empleado
     * @param empleado empleado a eliminar
     * @throws BbddException error controlado
     */
    public void eliminar(Empleado empleado) throws BbddException{
        persistencia.eliminarEmpleado(empleado);
    }
}
