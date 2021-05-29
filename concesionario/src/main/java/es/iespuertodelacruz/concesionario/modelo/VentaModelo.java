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
     * @throws PersistenciaException error controlado
     */
    public VentaModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);

    }

    /**
     * Constructor para test de la Clase VentaModelo
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public VentaModelo(boolean test) throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, "org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);

    }

    /**
     * Metodo que inserta una venta
     * @param venta venta a insertar
     * @throws PersistenciaException error controlado
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
     * @throws PersistenciaException error controlado
     */
    public void actualizar(Venta venta) throws PersistenciaException {
        String sql = "UPDATE Venta SET codigoEmpleado = '" + venta.getCodigoEmpleado() +
        "', codigoCliente = '" + venta.getCodigoCliente() + "', bastidor = '" + venta.getIdentificador() + 
        "' WHERE identificador = '" + venta.getIdentificador()  + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que busca una venta
     * @param identificador identificador de la venta
     * @throws PersistenciaException error controlado
     */
    public Venta buscar(String identificador) throws PersistenciaException {
        return (Venta)persistencia.obtenerVenta(identificador);
    }
    
    /**
     * Metodo que elimina una venta
     * @param venta venta a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(Venta venta) throws PersistenciaException {
        String sql = "DELETE from Venta where identificador = '" + 
        venta.getIdentificador() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que retorna un listado agrupado de las ventas realizadas
     * @return listado de ventas agrupado por modelo
     * @throws PersistenciaException error controlado
     */
    public ArrayList<String> agruparVentas() throws PersistenciaException {
        String sql="SELECT COUNT(bastidor), Marca, Modelo FROM Vehiculo WHERE estado = 'Vendido' GROUP BY Modelo;";
        return persistencia.agruparVentas(sql);
    }
}
