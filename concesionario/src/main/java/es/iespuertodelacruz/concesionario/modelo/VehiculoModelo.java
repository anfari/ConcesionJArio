package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Vehiculo;
import es.iespuertodelacruz.concesionario.exception.BbddException;

/**
 * Clase VehiculoModelo 
 */
public class VehiculoModelo {
    Bbdd persistencia;

    /**
     * Constructor de la clase CocheModelo
     */
    public VehiculoModelo() {
        persistencia = new Bbdd("org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
    }


    /**
     * Metodo que inserta en una lista
     * @param vehiculo inserta el vehiculo
     * @throws BbddException error controlado
     */
    public void insertar(Vehiculo vehiculo) throws BbddException{
        persistencia.insertarVehiculo(vehiculo);
    }
     /**
     * Metodo que modifica en una lista
     * @param vehiculo vehiculo a modificar
     * @throws BbddException error controlado
     */
    public void modificar(Vehiculo vehiculo) throws BbddException{
        persistencia.modificarVehiculo(vehiculo);
    }
     /**
     * Metodo que busca un vehiculo en la lista
     * @param vehiculo a buscar
     * @throws BbddException error controlado
     */
    public void buscar(Vehiculo vehiculo) throws BbddException{
        persistencia.obtenerVehiculo(vehiculo.getBastidor());
    }
     /**
     * Metodo que elimina un vehiculo de la lista
     * @param vehiculo vehiculo a eliminar
     * @throws BbddException error controlado
     */
    public void eliminar(Vehiculo vehiculo) throws BbddException{
        persistencia.eliminarVehiculo(vehiculo);
    }
}
