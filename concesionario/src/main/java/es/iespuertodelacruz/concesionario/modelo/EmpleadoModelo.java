package es.iespuertodelacruz.concesionario.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Empleado;
import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
/**
 * Clase EmpleadoModelo que gestiona los datos de empleados
 */
public class EmpleadoModelo {
    SqliteBbdd persistencia;
    PersonaModelo personaModelo;


    private static final String TABLA  = "Empleado";
    private static final String CLAVE  = "codigoEmpleado";

    /**
     * Constructor de la Clase EmpleadoModelo
     * @throws PersistenciaException error controlado
     */
    public EmpleadoModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);
        personaModelo = new PersonaModelo();
    }

    /**
     * Constructor para test de la Clase EmpleadoModelo
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public EmpleadoModelo(boolean test) throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, "org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
        personaModelo = new PersonaModelo(true);
    }


    /**
     * Metodo que inserta un empleado
     * @param empleado empleado a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertar(Empleado empleado) throws PersistenciaException {
        String sql ="INSERT INTO Empleado (codigoEmpleado, rango, contrasenia, dni)" + 
        "VALUES (" + empleado.getCodigoEmpleado()+ ", '" + empleado.getRango() + 
        "', '" + empleado.getContrasenia() + "', '" + empleado.getDni() + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica un empleado
     * @param empleado empleado a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificar(Empleado empleado) throws PersistenciaException {
        String sql = "UPDATE Empleado SET rango = '" + empleado.getRango() +
        "', contrasenia = '" + empleado.getContrasenia() +
        "', dni = '" + empleado.getDni() + 
        "' WHERE codigoEmpleado = '" + empleado.getCodigoEmpleado() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina un empleado
     * @param empleado empleado a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(Empleado empleado) throws PersistenciaException {
        String sql = "DELETE from Empleado where dni = '" + 
        empleado.getDni() + "'";
        persistencia.actualizar(sql);
    }
     
    /**
     * Funcion que busca un empleado especifico
     * @param dni dni del empleado
     * @return Empleado encontrado
     * @throws PersistenciaException error controlado
     */
    public Empleado buscar(String dni) throws PersistenciaException  {
        Empleado empleado = null;
        ArrayList<Empleado> listaEmpleados = null;
        String sql = "SELECT * FROM Empleado where dni = ";
        sql = sql + "'" + dni + "'";
        listaEmpleados = convertir(sql);
        if (!listaEmpleados.isEmpty()) {
            empleado = listaEmpleados.get(0);
        }

        return empleado;
    }

    /**
     * Funcion busca todos los empleados guardados
     * @return lista de todos los empleados
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Empleado> listadoEmpleados() throws PersistenciaException  {
        String sql = "SELECT * FROM Empleado";
        return convertir(sql);
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Empleado
     * @param sql a ejecutar
     * @return lista de resultados
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Empleado> convertir(String sql) throws PersistenciaException {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            resultSet = persistencia.buscarElementos(sql);

            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                String dni = resultSet.getString("dni");
                empleado.setCodigoEmpleado(resultSet.getString("codigoEmpleado"));
                empleado.setRango(resultSet.getString("rango"));
                empleado.setContrasenia(resultSet.getString("contrasenia"));
                empleado.setDni(dni);
                Persona persona = personaModelo.buscar(dni);
                empleado.setNombre(persona.getNombre());
                empleado.setApellidos(persona.getApellidos());
                empleado.setFechaNacimiento(persona.getFechaNacimiento());
                empleado.setTelefono(persona.getTelefono());
                empleado.setDireccion(persona.getDireccion());
                listaEmpleados.add(empleado);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return listaEmpleados;
    }

}
