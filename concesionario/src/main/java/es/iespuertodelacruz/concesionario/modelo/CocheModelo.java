package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Coche;
import es.iespuertodelacruz.concesionario.exception.BbddException;

/**
 * Clase VehiculoModelo 
 */
public class CocheModelo {
    Bbdd persistencia;

    /**
     * Constructor de la clase CocheModelo
     */
    public CocheModelo() {
        persistencia = new Bbdd("org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
    }


    /**
     * Metodo que inserta en una lista
     * @param vehiculo inserta el vehiculo
     * @throws BbddException error controlado
     */
    public void insertar(Coche coche) throws BbddException{
        persistencia.insertarCoche(coche);
    }
     /**
     * Metodo que modifica en una lista
     * @param coche coche a modificar
     * @throws BbddException error controlado
     */
    public void modificar(Coche coche) throws BbddException{
        persistencia.modificarCoche(coche);
    }
     /**
     * Metodo que busca un vehiculo en la lista
     * @param vehiculo a buscar
     * @throws BbddException error controlado
     */
    public void buscar(Coche coche) throws BbddException{
        persistencia.obtenerCoche(coche.getBastidor());
    }
     /**
     * Metodo que elimina un vehiculo de la lista
     * @param vehiculo vehiculo a eliminar
     * @throws BbddException error controlado
     */
    public void eliminar(Coche coche) throws BbddException{
        persistencia.eliminarCoche(coche);
    }
}
