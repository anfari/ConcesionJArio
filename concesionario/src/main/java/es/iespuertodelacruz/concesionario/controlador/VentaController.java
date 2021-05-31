package es.iespuertodelacruz.concesionario.controlador;


import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Venta;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.exception.VentaException;
import es.iespuertodelacruz.concesionario.modelo.VentaModelo;

/**
 * Clase VentaController
 */
public class VentaController extends Validaciones {
    VentaModelo ventaModelo;

    /**
     * Constructor de la clase ClienteController
     * @throws PersistenciaException error controlado
     */
    public VentaController() throws PersistenciaException {
        ventaModelo = new VentaModelo();
    }

    /**
     * Constructor para test de la clase VentaController
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public VentaController(boolean test) throws PersistenciaException {
        ventaModelo = new VentaModelo(true);
    }
    

    /**
     * Metodo encargado de realizar la validacion del objeto venta
     * @param venta venta a validar
     * @throws VentaException error controlado
     */
    public void validarVenta(Venta venta) throws VentaException {
        String mensaje = "";

        if (venta == null) {
            mensaje = "Se esta intentando validar un objeto vacio";
            throw new VentaException(mensaje);
        }
        if (venta.getBastidor() == null || venta.getBastidor().isEmpty() || !validarBastidor(venta.getBastidor())) {
            mensaje += "El bastidor de venta es nulo, vacio o invalido\n";
        }
        if (venta.getCodigoCliente() == null || venta.getCodigoCliente().isEmpty()) {
            mensaje += "El codigo de cliente de la venta es nulo o vacio\n";
        }
        if (venta.getCodigoEmpleado() == null || venta.getCodigoEmpleado().isEmpty()) {
            mensaje += "El codigo de empleado de venta es nulo o vacio\n";
        }
        if (!mensaje.isEmpty()) {
            throw new VentaException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar
     * @param venta venta a insertar
     * @throws VentaException error controlado
     * @throws PersistenciaException error controlado
     * 
     */
    public void insertar(Venta venta) throws VentaException, PersistenciaException {
        validarVenta(venta);
        if (existe(venta)) {
            throw new VentaException("La venta indicada ya existe");
        }
        ventaModelo.insertar(venta);
    }

    /**
     * Metodo encargado de elimianr
     * @param venta cliente a eliminar
     * @throws VentaException error controlado
     * @throws PersistenciaException error controlado
     */
    public void eliminar(Venta venta) throws VentaException, PersistenciaException {
        validarVenta(venta);
        if (!existe(venta)) {
            throw new VentaException("La venta indicada no existe");
        }
        ventaModelo.eliminar(venta);
    }

    /**
     * Metodo encargado de eliminar utilizando el codigo de la venta
     * @param identificador identificador de la venta
     * @throws VentaException error controlado
     * @throws PersistenciaException error controlado
     */
    public void eliminar(String identificador) throws VentaException, PersistenciaException {
        ventaModelo.eliminar(identificador);
    }

    /**
     * Metodo encargado de modificar
     * @param venta venta a modificar
     * @throws VentaException error controlado
     * @throws PersistenciaException error controlado
     */
    public void modificar(Venta venta) throws VentaException, PersistenciaException {
        Venta ventaAlmacenado;
        validarVenta(venta);
        ventaAlmacenado = buscar(venta.getIdentificador());
        if (ventaAlmacenado == null) {
            throw new VentaException("La venta indicada no existe");
        }
        ventaModelo.modificar(venta);
    }

    /**
     * Metodo encargado de buscar por identificaor de venta
     * @param identificador identificador de la venta
     * @return venta encontrado
     * @throws PersistenciaException error controlado
     */
    public Venta buscar(String identificador) throws PersistenciaException  {
        Venta venta = null;
        venta = ventaModelo.buscar(identificador);
        return venta;
    }

    /**
     * Funcion encargada de verificar si existe o no un venta
     * @param venta venta  a encontrar
     * @return true/false si existe o no
     * @throws PersistenciaException error controlado
     */
    public boolean existe(Venta venta) throws PersistenciaException  {
        boolean encontrado = false;
        Venta ventaEncontrado;

        ventaEncontrado = buscar(venta.getIdentificador());
        if (ventaEncontrado != null) {
            encontrado = true;
        }
        return encontrado;
    }

   /**
     * Funcion que retorna un listado agrupado de las ventas realizadas
     * @return listado de ventas agrupado por modelo
     * @throws PersistenciaException error controlado
     */
    public ArrayList<String> agruparVentas() throws PersistenciaException {
        return ventaModelo.agruparVentas();
    }

}
