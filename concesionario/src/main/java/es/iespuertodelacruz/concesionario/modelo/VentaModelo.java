package es.iespuertodelacruz.concesionario.modelo;

import java.sql.ResultSet;
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
        "VALUES (" + venta.getIdentificador() + ", '" + venta.getCodigoEmpleado() + 
        "', '" + venta.getCodigoCliente() + "', '" + venta.getBastidor() + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una venta
     * @param venta venta a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificar(Venta venta) throws PersistenciaException {
        String sql = "UPDATE Venta SET codigoEmpleado = '" + venta.getCodigoEmpleado() +
        "', codigoCliente = '" + venta.getCodigoCliente() + "', bastidor = '" + venta.getIdentificador() + 
        "' WHERE identificador = '" + venta.getIdentificador()  + "'";
        persistencia.actualizar(sql);
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
     * Metodo que elimina una venta por identificador
     * @param identificador identificador de la venta a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(String identificador) throws PersistenciaException {
        String sql = "DELETE from Venta where identificador = '" + 
        identificador + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que busca una venta especifica
     * @param identificador identificador de la venta
     * @return Venta encontrado
     * @throws PersistenciaException error controlado
     */
    public Venta buscar(String identificador) throws PersistenciaException  {
        Venta venta = null;
        ArrayList<Venta> listaVentas = null;
        String sql = "SELECT * FROM Venta where identificador = ";
        sql = sql + "'" + identificador + "'";
        listaVentas = convertir(sql);
        if (!listaVentas.isEmpty()) {
            venta = listaVentas.get(0);
        }

        return venta;
    }

    /**
     * Funcion busca todas las ventas guardados
     * @return lista de todas las ventas
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Venta> listadoVentas() throws PersistenciaException  {
        String sql = "SELECT * FROM Venta";
        return convertir(sql);
    }

    /**
     * Funcion que retorna un listado agrupado de las ventas realizadas
     * @return listado de ventas agrupado por modelo
     * @throws PersistenciaException error controlado
     */
    public ArrayList<String> agruparVentas() throws PersistenciaException  {
        String sql = "SELECT COUNT(bastidor), Marca, Modelo FROM Vehiculo WHERE estado = 'Vendido' GROUP BY Modelo ORDER BY COUNT(bastidor) DESC;";
        ArrayList<String> ventasAgrupadas = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            resultSet = persistencia.buscarElementos(sql);

            while (resultSet.next()) {
                String cantidad = resultSet.getString("COUNT(bastidor)");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                String resultado = marca + " " + modelo + ": " + cantidad;
                ventasAgrupadas.add(resultado);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return ventasAgrupadas;
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Venta
     * @param sql a ejecutar
     * @return lista de resultados
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Venta> convertir(String sql) throws PersistenciaException {
        ArrayList<Venta> listaVentas = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            resultSet = persistencia.buscarElementos(sql);

            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setBastidor("bastidor");
                venta.setCodigoCliente("codigoCliente");
                venta.setCodigoEmpleado("codigoEmpleado");
                venta.setIdentificador("identificador");
                listaVentas.add(venta);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return listaVentas;
    }

}
