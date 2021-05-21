package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Empleado;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
/**
 * Clase EmpleadoModelo que gestiona los datos de empleados
 */
public class EmpleadoModelo {
    SqliteBbdd persistencia;


    private static final String TABLA  = "Empleado";
    private static final String CLAVE  = "codigoEmpleado";

    /**
     * Constructor de la Clase EmpleadoModelo
     * @throws PersistenciaException
     */
    public EmpleadoModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);
    }


    /**
     * Metodo que inserta un empleado
     * @param empleado empleado a insertar
     * @throws PersistenciaException
     */
    public void insertar(Empleado empleado) throws PersistenciaException {
        String sql ="INSERT INTO Empleado (codigoEmpleado, rango, contrasenia, dni)" + 
        "VALUES ('" + empleado.getCodigoEmpleado()+ "', '" + empleado.getRango() + 
        "', '" + empleado.getContrasenia() + "', '" + empleado.getDni() + "'";
        persistencia.actualizar(sql);
    }

     /**
     * Metodo que modifica un empleado
     * @param empleado empleado a modificar
     * @throws PersistenciaException
     */
    public void actualizar(Empleado empleado) throws PersistenciaException {
        String sql = "UPDATE Empleado SET rango = '" + empleado.getRango() +
        "', contrasenia = '" + empleado.getContrasenia() +
        "', dni = '" + empleado.getDni() + 
        "' WHERE codigoEmpleado = '" + empleado.getCodigoEmpleado() + "'";
        persistencia.actualizar(sql);
    }

     /**
     * Metodo que busca un empleado
     * @param empleado empleado a buscar
     * @throws PersistenciaException
     */
    public Empleado buscar(String dni) throws PersistenciaException {
        return (Empleado)persistencia.obtenerEmpleados(dni);
    }

     /**
     * Metodo que elimina un empleado
     * @param empleado empleado a eliminar
     * @throws PersistenciaException
     */
    public void eliminar(Empleado empleado) throws PersistenciaException {
        String sql = "DELETE from Empleado where codigoEmpleado = '" + 
        empleado.getCodigoEmpleado() + "'";
        persistencia.actualizar(sql);
    }
}
