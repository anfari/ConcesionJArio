package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase PersonaModelo
 */
public class PersonaModelo {
    SqliteBbdd persistencia;
    private static final String TABLA  = "Persona";
    private static final String CLAVE  = "dni";

   //ModeloCliente
   
   public PersonaModelo() throws PersistenciaException  {
      persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);
      
   }

   /**
     * Constructor para test de la Clase PersonaModelo
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public PersonaModelo(boolean test) throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, "org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);

    }


    /**
     * Metodo que inserta una persona
     * @param persona persona a insertar
     * @throws PersistenciaException
     */
    public void insertar(Persona persona) throws PersistenciaException {
        String sql ="INSERT INTO Persona (dni,nombre, apellidos" + 
        "fechaNacimiento, telefono) VALUES ('" + persona.getDni() + 
        "', '" + persona.getNombre() + "', '" + persona.getApellidos() +
         "', '" + persona.getFechaNacimiento() + "', '" + 
        persona.getTelefono() + "'";
        persistencia.actualizar(sql);
    }

     /**
     * Metodo que modifica una persona
     * @param persona persona a modificar
     * @throws PersistenciaException
     */
    public void actualizar(Persona persona) throws PersistenciaException {
        String sql = "UPDATE Persona SET nombre = '" + persona.getNombre() +
        "', apellidos = '" + persona.getApellidos() +
        "', fechaNacimiento = '" + persona.getFechaNacimiento() + 
        "', telefono = '" + persona.getTelefono() + 
        "' WHERE dni = '" + persona.getDni()  + "'";
        persistencia.actualizar(sql);
    }

     /**
     * Metodo que busca una persona
     * @param dni dni de la persona
     * @throws PersistenciaException
     */
    public Persona buscar(String dni) throws PersistenciaException {
        return (Persona)persistencia.obtenerPersona(dni);
    }

     /**
     * Metodo que elimina una persona
     * @param persona persona a eliminar
     * @throws PersistenciaException
     */
    public void eliminar(Persona persona) throws PersistenciaException {
        String sql = "DELETE from Persona where dni = '" + persona.getDni() + "'";
        persistencia.actualizar(sql);
    }  
}
