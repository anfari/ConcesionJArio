package es.iespuertodelacruz.concesionario.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Vehiculo;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase VehiculoModelo 
 */
public class VehiculoModelo {
    SqliteBbdd persistencia;

    private static final String TABLA  = "Vehiculo";
    private static final String CLAVE  = "bastidor";

    /**
     * Constructor de la clase CocheModelo
     * @throws PersistenciaException
     */
    public VehiculoModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);
    }


    /**
     * Metodo que inserta en una lista
     * @param vehiculo inserta el vehiculo
     * @throws PersistenciaException
     */
    public void insertar(Vehiculo vehiculo) throws PersistenciaException {
        String sql ="INSERT INTO Vehiculo (bastidor, matricula, marca, modelo, color, precio, " + 
        "extrasInstalados, motor, potencia, cilindrada, tipo, estado) VALUES ('" + vehiculo.getBastidor() + 
        "', '" + vehiculo.getMatricula() + "', '" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + 
        "', '" + vehiculo.getColor() + "', '" + vehiculo.getPrecio() + "', '" + vehiculo.getExtrasInstalados() + 
        "', '" + vehiculo.getMotor() + "', '" + vehiculo.getPotencia() + "', '" + vehiculo.getCilindrada() + 
        "', '" + vehiculo.getTipo() + "', '" + vehiculo.getEstado() + "'";
        persistencia.actualizar(sql);
    }
     /**
     * Metodo que modifica en una lista
     * @param vehiculo vehiculo a modificar
     * @throws PersistenciaException
     */
    public void actualizar(Vehiculo vehiculo) throws PersistenciaException {
        String sql = "UPDATE Vehiculo SET matricula = '" + vehiculo.getMatricula() +
        "', marca = '" + vehiculo.getMarca() + "', modelo = '" + vehiculo.getModelo() +
        "', color = '" + vehiculo.getColor() + "', precio = '" + vehiculo.getPrecio() + 
        "', extrasInstalados = '" + vehiculo.getExtrasInstalados() +
        "', motor = '" + vehiculo.getMotor() + "', potencia = '" + vehiculo.getPotencia() + 
        "', cilindrada = '" + vehiculo.getCilindrada() + "', tipo = '" + vehiculo.getTipo() + 
        "', estado = '" + vehiculo.getEstado() + "' WHERE bastidor = '" + vehiculo.getBastidor() + "'";
        persistencia.actualizar(sql);
    }
     /**
     * Metodo que busca un vehiculo en la lista
     * @param vehiculo a buscar
     * @throws PersistenciaException
     */
    public Vehiculo buscar(String bastidor) throws PersistenciaException {
        return (Vehiculo)persistencia.obtenerVehiculo(bastidor);
    }
     /**
     * Metodo que elimina un vehiculo de la lista
     * @param vehiculo vehiculo a eliminar
     * @throws PersistenciaException
     */
    public void eliminar(Vehiculo vehiculo) throws PersistenciaException {
        String sql = "DELETE from Vehiculo where bastidor = '" + vehiculo.getBastidor() + "'";
        persistencia.actualizar(sql);
    }

      /**
     * Funcion que retorna una lista con todos los veiculos
     * @return listado con todos los vehiculos
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Object> listadoVehiculos() throws PersistenciaException {
        return persistencia.obtenerListadovehiculos();
    }
}
