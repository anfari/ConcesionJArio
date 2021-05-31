package es.iespuertodelacruz.concesionario.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase PersonaModelo
 */
public class PersonaModelo {
    SqliteBbdd persistencia;
    DireccionModelo direccionModelo;
    private static final String TABLA  = "Persona";
    private static final String CLAVE  = "dni";

   
    /**
     * Constructor de la clase PersonaModelo
     * @throws PersistenciaException error controlado
     */
    public PersonaModelo() throws PersistenciaException  {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);
        direccionModelo = new DireccionModelo();
    }

    /**
     * Constructor para test de la Clase PersonaModelo
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public PersonaModelo(boolean test) throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, "org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
        direccionModelo = new DireccionModelo(true);
    }


    /**
     * Metodo que inserta una persona
     * @param persona persona a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertar(Persona persona) throws PersistenciaException {
        String sql ="INSERT INTO Persona (nombre, apellidos, dni, " + 
        "fechaNacimiento, telefono) VALUES ('" + persona.getNombre() + 
        "', '" + persona.getApellidos() + "', '" + persona.getDni() +
         "', '" + persona.getFechaNacimiento() + "', '" + 
        persona.getTelefono() + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una persona
     * @param persona persona a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificar(Persona persona) throws PersistenciaException {
        String sql = "UPDATE Persona SET nombre = '" + persona.getNombre() +
        "', apellidos = '" + persona.getApellidos() +
        "', fechaNacimiento = '" + persona.getFechaNacimiento() + 
        "', telefono = '" + persona.getTelefono() + 
        "' WHERE dni = '" + persona.getDni()  + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina una persona
     * @param persona persona a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(Persona persona) throws PersistenciaException {
        String sql = "DELETE from Persona where dni = '" + persona.getDni() + "'";
        persistencia.actualizar(sql);
    }  

    /**
     * Funcion que busca una persona especifica
     * @param dni dni de la persona
     * @return Persona encontrada
     * @throws PersistenciaException error controlado
     */
    public Persona buscar(String dni) throws PersistenciaException  {
        Persona persona = null;
        ArrayList<Persona> listaPersonas = null;
        String sql = "SELECT * FROM Persona where dni = ";
        sql = sql + "'" + dni + "'";
        listaPersonas = convertir(sql);
        if (!listaPersonas.isEmpty()) {
            persona = listaPersonas.get(0);
        }

        return persona;
    }

    /**
     * Funcion busca todas las personas guardados
     * @return lista de todas las personas
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Persona> listadoPersonas() throws PersistenciaException  {
        String sql = "SELECT * FROM Persona";
        return convertir(sql);
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Persona
     * @param sql a ejecutar
     * @return lista de resultados
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Persona> convertir(String sql) throws PersistenciaException {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            resultSet = persistencia.buscarElementos(sql);

            while (resultSet.next()) {
                Persona persona = new Persona();
                String dni = resultSet.getString("dni");
                persona.setApellidos(resultSet.getString("apellidos"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setDni(dni);
                persona.setTelefono(resultSet.getString("telefono"));
                persona.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                persona.setDireccion(direccionModelo.buscar(dni));
                listaPersonas.add(persona);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return listaPersonas;
    }

}
