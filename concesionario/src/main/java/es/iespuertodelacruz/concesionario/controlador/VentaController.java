package es.iespuertodelacruz.concesionario.controlador;


import es.iespuertodelacruz.concesionario.api.Venta;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.exception.VentaException;
import es.iespuertodelacruz.concesionario.modelo.VentaModelo;

/**
 * Clase VentaController
 */
public class VentaController {
    VentaModelo ventaModelo;

    /**
     * Constructor de la clase ClienteController
     * @throws PersistenciaException
     */
    public VentaController() throws PersistenciaException {
        ventaModelo = new VentaModelo();
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
        if (venta.getBastidor() == null || venta.getBastidor().isEmpty()) {
            mensaje += "El bastidor de venta es nulo o vacio\n";
        }
        if (venta.getCodigoCliente() == null || venta.getCodigoCliente().isEmpty()) {
            mensaje += "El codigo de cliente de la venta es nulo o vacio\n";
        }
        if (venta.getIdentificador() == null || venta.getIdentificador().isEmpty()) {
            mensaje += "El identificador de venta es nulo o vacio\n";
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
     * @throws PersistenciaException
     * 
     */
    public void insertar(Venta venta) throws VentaException, PersistenciaException {
        validarVenta(venta);
        if (existe(venta)) {
            throw new VentaException("La venta indicado ya existe");
        }
        ventaModelo.insertar(venta);
    }

    /**
     * Metodo encargado de elimianr
     * @param venta cliente a eliminar
     * @throws VentaException error controlado
     * @throws PersistenciaException
     */
    public void eliminar(Venta venta) throws VentaException, PersistenciaException {
        validarVenta(venta);
        if (!existe(venta)) {
            throw new VentaException("La venta indicado no existe");
        }
        ventaModelo.eliminar(venta);
    }

    /**
     * Metodo encargado de eliminar utilizando el codigo de la venta
     * @param identificador identificador de la venta
     * @throws VentaException error controlado
     * @throws PersistenciaException
     */
    public void eliminar(String identificador) throws VentaException, PersistenciaException {
        Venta venta;
        venta = buscar(identificador);
        eliminar(venta);
    }

    /**
     * Metodo encargado de modificar
     * @param venta venta a modificar
     * @throws VentaException error controlado
     * @throws PersistenciaException
     */
    public void modificar(Venta venta) throws VentaException, PersistenciaException {
        Venta ventaAlmacenado;
        validarVenta(venta);
        ventaAlmacenado = buscar(venta.getIdentificador());
        if (ventaAlmacenado == null) {
            throw new VentaException("El venta indicado no existe");
        }
        ventaModelo.actualizar(venta);
    }

    /**
     * Metodo encargado de buscar por identificaor de venta
     * @param identificador 
     * @return venta encontrado
     * @throws PersistenciaException
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
     * @throws PersistenciaException
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

}
