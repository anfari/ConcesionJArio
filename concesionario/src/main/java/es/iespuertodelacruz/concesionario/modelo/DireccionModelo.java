package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.exception.BbddException;

/**
 * Clase DireccionModelo contiene los datos de direccion de un cliente
 */
public class DireccionModelo {
    Bbdd persistencia;

    /**
     * Constructor de la Clase DireccionModelo
     */
    public DireccionModelo() {
        persistencia = new Bbdd("org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
    }


    /**
     * Metodo que inserta una direccion
     * @param direccion direccion a insertar
     * @throws BbddException error controlado
     */
    public void insertar(Direccion direccion) throws BbddException{
        persistencia.insertarDireccion(direccion);
    }

     /**
     * Metodo que modifica una direccion
     * @param direccion direccion a modificar
     * @throws BbddException error controlado
     */
    public void modificar(Direccion direccion) throws BbddException{
        persistencia.modificarDireccion(direccion);
    }

     /**
     * Metodo que busca una direccion
     * @param direccion direccion a buscar
     * @throws BbddException error controlado
     */
    public void buscar(Direccion direccion) throws BbddException{
        persistencia.obtenerDireccion(direccion.getCodigoPostal());
    }

     /**
     * Metodo que elimina una direccion
     * @param direccion direccion a eliminar
     * @throws BbddException error controlado
     */
    public void eliminar(Direccion direccion) throws BbddException{
        persistencia.eliminarDireccion(direccion);
    }
 
}
