package es.iespuertodelacruz.concesionario.modelo;
import java.sql.*;
import java.util.ArrayList;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
/**
 * 
 * Clase BDbd, va a contener los datos para la base de datos
 */
public class Bbdd  {

    private static final String SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA = "Se ha producido un error realizando la consulta";
    private static final String TABLE = "TABLE";
    private static final String TABLE_NAME= "TABLE_NAME";
    private static final String NOMBRE_TABLAS = "persona,cliente,empleado,direccion,vehiculo,venta";

    protected String nombreTabla;
    protected String clave;
    protected String driver;
    protected String url;
    protected String usuario;
    protected String password;


    /**
     * Constructor por defecto, para crear la conexion a la basede datos
     * @param nombreTabla nombre de la tabla a inicializar
     * @param clave PK de la tabla a inicializar
     * @param driver driver para cargar la bd
     * @param url url con el puerto incluido de la bd
     * @param usuario usuario de la bd
     * @param password contraseña de la bd
     * @throws PersistenciaException error controlado
     */
    public Bbdd(String nombreTabla, String clave, String driver, String url, String usuario, String password) throws PersistenciaException {
        this.nombreTabla= nombreTabla;
        this.clave=clave;
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        init();
    }


    /**
     * Metodo encargado de inicializar las tablas de la BBDD
     * @throws PersistenciaException error controlado
     */
    private void init() throws PersistenciaException {
        DatabaseMetaData databaseMetaData;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<String> listaTablas = new ArrayList<>();

        try {
            connection = getConnection();
            databaseMetaData = connection.getMetaData();
            resultSet = databaseMetaData.getTables(null, null, null, new String[] {TABLE});
            while (resultSet.next()) {
                listaTablas.add(resultSet.getString(TABLE_NAME));
            }
                if (!listaTablas.contains(nombreTabla)) {
                    String sqlCrearTabla = new Fichero().leer("src/resources/sqlite/" + nombreTabla.toLowerCase() + "_crear.sql");
                    actualizar(sqlCrearTabla);
                    String sqlInsertarDatos = new Fichero().leer("src/resources/sqlite/" + nombreTabla.toLowerCase() + "_insertar.sql");
                    actualizar(sqlInsertarDatos);
                }
        } catch (Exception e) {
            throw new PersistenciaException("Se ha producido un error en la inicializacion de la BBDD", e);
        } finally {
            closeConnection(connection, null, resultSet);
        }
    }

    /**
     * Funcion encargada de realizar la conexion con la BBDD
     * @return la conexion
     * @throws PersistenciaException error controlado
     */
    private Connection getConnection() throws PersistenciaException {
        Connection connection = null;

        try {
            Class.forName(driver);
            if (usuario == null ||password == null) {
                connection = DriverManager.getConnection(url);
            } else {
                connection = DriverManager.getConnection(url, usuario, password);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("No se ha podido establecer la conexion con la BBDD", exception);
        }
        
        return connection;
    }

    /**
    * Funcion que realiza una consulta sobre una sentencia sql
    * @param sql de la consulta
    * @return lista resultados
    * @throws PersistenciaException error controlado
    */
    protected ResultSet buscarElementos(String sql) throws PersistenciaException {
      
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
           connection = getConnection();
           statement = connection.prepareStatement(sql);
           resultSet = statement.executeQuery();
        } catch (SQLException exception) {
           throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
        } finally {
        }
        return resultSet;
    }

    /**
     * Metodo encargado de realizar la actualizacion de la BBDD
     * @param sql a ejecutar
     * @throws PersistenciaException error controlado
     */
    public void actualizar(String sql) throws PersistenciaException {
        Statement statement;
        Connection connection;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception exception) {
            throw new PersistenciaException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA, exception);
        }
    }

      /**
     * Metodo privado encargado de cerrar la conexion con la base de datos
     * @param connection de la BBDD
     * @param statement de la BBDD
     * @param resultSet de la BBDD
     * @throws PersistenciaException error controlado
     */
    public void closeConnection (Connection connection, Statement statement, ResultSet resultSet) throws PersistenciaException  {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error cerando la conexion", exception);
        }
    } 

}
