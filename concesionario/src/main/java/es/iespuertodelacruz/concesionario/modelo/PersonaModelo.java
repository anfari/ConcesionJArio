package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.BbddException;

/**
 * Clase PersonaModelo
 */
public class PersonaModelo {
    Bbdd persistencia;

    /**
     * Constructor de la Clase PersonaModelo
     */
    public PersonaModelo() {
        persistencia = new Bbdd("org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
    }


    /**
     * Metodo que inserta una persona
     * @param persona persona a insertar
     * @throws BbddException error controlado
     */
    public void insertar(Persona persona) throws BbddException{
        persistencia.insertarPersona(persona);
    }

     /**
     * Metodo que modifica una persona
     * @param persona persona a modificar
     * @throws BbddException error controlado
     */
    public void modificar(Persona persona) throws BbddException{
        persistencia.modificarPersona(persona);
    }

     /**
     * Metodo que busca una persona
     * @param dni dni de la persona
     * @throws BbddException error controlado
     */
    public Persona buscar(String dni) throws BbddException{
        return persistencia.obtenerPersona(dni);
    }

     /**
     * Metodo que elimina una persona
     * @param persona persona a eliminar
     * @throws BbddException error controlado
     */
    public void eliminar(Persona persona) throws BbddException{
        persistencia.eliminarPersona(persona);
    }  
}
