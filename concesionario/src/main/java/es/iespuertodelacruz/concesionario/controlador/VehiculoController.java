package es.iespuertodelacruz.concesionario.controlador;

import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Vehiculo;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.exception.VehiculoException;
import es.iespuertodelacruz.concesionario.modelo.VehiculoModelo;

/**
 * Clase VehiculoController
 */
public class VehiculoController {
    VehiculoModelo vehiculoModelo;

    /**
     * Constructor de la clase VehiculoController
     * @throws PersistenciaException error controlado
     */
    public VehiculoController() throws PersistenciaException {
        vehiculoModelo = new VehiculoModelo();
    }

    /**
     * Metodo encargado de realizar la validacion del objeto Vehiculo
     * @param vehiculo vehiculo a validar
     * @throws VehiculoException error controlado
     */
    public void validarVehiculo(Vehiculo vehiculo) throws VehiculoException {
        String mensaje = "";

        if (vehiculo == null) {
            mensaje = "Se esta intentando validar un objeto vacio";
            throw new VehiculoException(mensaje);
        }
        if (vehiculo.getBastidor() == null || vehiculo.getBastidor().isEmpty()) {
            mensaje += "El codigo de bastidor es nulo o vacio\n";
        }
        if (vehiculo.getMarca() == null || vehiculo.getMarca().isEmpty()) {
            mensaje += "La marca es nula o vacia\n";
        }
        if (vehiculo.getModelo() == null || vehiculo.getModelo().isEmpty()) {
            mensaje += "El modelo es nulo o vacio\n";
        }
        if (vehiculo.getColor() == null || vehiculo.getColor().isEmpty()) {
            mensaje += "El color es nulo o vacio\n";
        }
        if (vehiculo.getPrecio() <= 0) {
            mensaje = "El precio es 0 o menor\n";
        }
        if (vehiculo.getMotor() == null || vehiculo.getMotor().isEmpty()) {
            mensaje += "El motor es nulo o vacio\n";
        }
        if (vehiculo.getPotencia() <= 0) {
            mensaje = "La potencia es nula o vacia\n";
        }
        if (vehiculo.getCilindrada() == null || vehiculo.getCilindrada().isEmpty()) {
            mensaje += "La cilindrada es nula o vacia\n";
        }
        if (vehiculo.getTipo() == null || vehiculo.getTipo().isEmpty()) {
            mensaje += "El tipo es nulo o vacio\n";
        }
        if (vehiculo.getEstado() == null || vehiculo.getEstado().isEmpty()) {
            mensaje += "El estado es nulo o vacio\n";
        }
        if (!mensaje.isEmpty()) {
            throw new VehiculoException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar
     * @param vehiculo vehiculo a insertar
     * @throws VehiculoException error controlado
     * @throws PersistenciaException error controlado
     * 
     */
    public void insertar(Vehiculo vehiculo) throws VehiculoException, PersistenciaException {
        validarVehiculo(vehiculo);
        if (existe(vehiculo)) {
            throw new VehiculoException("El vehiculo indicado ya existe");
        }
        vehiculoModelo.insertar(vehiculo);
    }

    /**
     * Metodo encargado de elimianr
     * @param vehiculo vehiculo a eliminar
     * @throws VehiculoException error controlado
     * @throws PersistenciaException error controlado
     */
    public void eliminar(Vehiculo vehiculo) throws VehiculoException, PersistenciaException {
        validarVehiculo(vehiculo);
        if (!existe(vehiculo)) {
            throw new VehiculoException("El vehiculo indicado no existe");
        }
        vehiculoModelo.eliminar(vehiculo);
    }

    /**
     * Metodo encargado de eliminar 
     * @param bastidor numero de bastidor del vehiculo
     * @throws VehiculoException error controlado
     * @throws PersistenciaException error controlado
     */
    public void eliminar(String bastidor) throws VehiculoException, PersistenciaException {
        Vehiculo vehiculo;
        vehiculo = buscar(bastidor);
        eliminar(vehiculo);
    }

    /**
     * Metodo encargado de modificar
     * @param vehiculo vehiculo a modificar
     * @throws VehiculoException error controlado
     * @throws PersistenciaException
     */
    public void modificar(Vehiculo vehiculo) throws VehiculoException, PersistenciaException {
        Vehiculo vehiculoAlmacenado;
        validarVehiculo(vehiculo);
        vehiculoAlmacenado = buscar(vehiculo.getBastidor());
        if (vehiculoAlmacenado == null) {
            throw new VehiculoException("El vehiculo indicado no existe");
        }
        vehiculoModelo.actualizar(vehiculo);
    }

    /**
     * Metodo encargado de buscar por numero de bastidor
     * @param bastidor numero de bastidor del vehiculo
     * @return vehiculo encontrado
     * @throws PersistenciaException error controlado
     */
    public Vehiculo buscar(String bastidor) throws PersistenciaException  {
        Vehiculo vehiculo = null;
        vehiculo = vehiculoModelo.buscar(bastidor);
        return vehiculo;
    }

    /**
     * Funcion encargada de verificar si existe o no un vehiculo
     * @param vehiculo vehiculo a encontrar
     * @return true/false si existe o no
     * @throws PersistenciaException error controlado
     */
    public boolean existe(Vehiculo vehiculo) throws PersistenciaException  {
        boolean encontrado = false;
        Vehiculo vehiculoEncontrado;

        vehiculoEncontrado = buscar(vehiculo.getBastidor());
        if (vehiculoEncontrado != null) {
            encontrado = true;
        }

        return encontrado;
    }

    /**
     * Funcion que retorna una lista con todos los vehiculos
     * @return listado con todos los vehiculos
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Object> listadoVehiculos() throws PersistenciaException {
        return vehiculoModelo.listadoVehiculos();
    }
}
