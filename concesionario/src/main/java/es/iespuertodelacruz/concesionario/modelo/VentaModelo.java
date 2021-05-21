package es.iespuertodelacruz.concesionario.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Venta;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase VentaModelo
 */
public class VentaModelo {
    SqliteBbdd persistencia;

    private static final String TABLA  = "Venta";
    private static final String CLAVE  = "identificador";

    /**
     * Constructor de la Clase ClienteModelo
     * @throws PersistenciaException
     */
    public VentaModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);

    }

    /**
     * Metodo que inserta una venta
     * @param venta venta a insertar
     * @throws PersistenciaException
     */
    public void insertar(Venta venta) throws PersistenciaException {
        String sql ="INSERT INTO Venta (identificador, codigoEmpleado, codigoCliente, bastidor)" + 
        "VALUES ('" + venta.getIdentificador() + "', '" + venta.getCodigoEmpleado() + 
        "', '" + venta.getCodigoCliente() + "', '" + venta.getBastidor() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una venta
     * @param venta venta a modificar
     * @throws PersistenciaException
     */
    public void actualizar(Venta venta) throws PersistenciaException {
        String sql = "UPDATE Venta SET codigoEmpleado = '" + venta.getCodigoEmpleado() +
        "', codigoCliente = '" + venta.getCodigoCliente() + "', bastidor = '" + venta.getIdentificador() + 
        "' WHERE identificador = '" + venta.getIdentificador()  + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que busca una venta
     * @param bastidor codigo de bastidor del vehiculo
     * @throws PersistenciaException
     */
    public Venta buscar(String bastidor) throws PersistenciaException {
        return (Venta)persistencia.obtenerCliente(bastidor);
    }
    
    /**
     * Metodo que elimina una venta
     * @param venta venta a eliminar
     * @throws PersistenciaException
     */
    public void eliminar(Venta venta) throws PersistenciaException {
        String sql = "DELETE from Venta where identificador = '" + 
        venta.getIdentificador() + "'";
        persistencia.actualizar(sql);
    }

    public void agruparVentas() throws PersistenciaException {
        String sql="SELECT COUNT(bastidor), Marca, Modelo FROM Vehiculo WHERE estado = 'Vendido' GROUP BY Modelo;";
        persistencia.actualizar(sql);
    }
}
