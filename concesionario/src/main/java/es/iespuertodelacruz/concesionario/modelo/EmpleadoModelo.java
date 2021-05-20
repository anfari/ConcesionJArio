package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Empleado;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
/**
 * Clase EmpleadoModelo que gestiona los datos de empleados
 */
public class EmpleadoModelo {
    SqliteBbdd persistencia;


    private static final String TABLA  = "CUENTA";
    private static final String CLAVE  = "CODIGO";

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
        String sql ="INSERT INTO Empleado (dni, nombre, apellidos " + 
        "fechaNacimiento, telefono, direccion,codigoEmpleado"+
        "+,rango,contrasenia) VALUES ('" + empleado.getDni()+ 
        "', '" + empleado.getNombre() + "', '" + empleado.getApellidos() + "', '"
         + empleado.getFechaNacimiento() + "', '" + 
        empleado.getTelefono() + "', '" + empleado.getDireccion() + 
         "', '" + empleado.getCodigoEmpleado() + "', '" + empleado.getRango() +
         "', '" + empleado.getContrasenia() +"'";
        persistencia.actualizar(sql);
    }

     /**
     * Metodo que modifica un empleado
     * @param empleado empleado a modificar
     * @throws PersistenciaException
     */
    public void actualizar(Empleado empleado) throws PersistenciaException {
        String sql = "UPDATE Empleado SET nombre = '" + empleado.getNombre() +
        "', apellidos = '" + empleado.getApellidos() +
        "', fechaNacimiento = '" + empleado.getFechaNacimiento() + "', telefono = '" + 
        empleado.getTelefono() + "', direccion = '" + empleado.getDireccion() +
        "', dni = '" + empleado.getDni()+"', rango = '" + empleado.getRango()+
        "', contrasenia = '" + empleado.getContrasenia()+
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
