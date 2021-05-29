package es.iespuertodelacruz.concesionario.modelo;
import java.sql.*;
import java.util.ArrayList;
import es.iespuertodelacruz.concesionario.api.*;
import es.iespuertodelacruz.concesionario.exception.BbddException;
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
     * @param driver driver para cargar la bd
     * @param url url con el puerto incluido de la bd
     * @param usuario usuario de la bd
     * @param password contraseña de la bd
     * @throws BbddException
     * @throws PersistenciaException
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


    private void init() throws PersistenciaException {
        DatabaseMetaData databaseMetaData;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<String> listaTablas = new ArrayList<>();
/*
        String[] convertir = nombreTabla.split(",");
        List<String> nombreTablas = new ArrayList<String>();
        nombreTablas = Arrays.asList(convertir);
*/
        try {
            connection = getConnection();
            databaseMetaData = connection.getMetaData();
            resultSet = databaseMetaData.getTables(null, null, null, new String[] {TABLE});
            while (resultSet.next()) {
                listaTablas.add(resultSet.getString(TABLE_NAME));
            }
            //for (String tabla : nombreTablas) {
                if (!listaTablas.contains(nombreTabla)) {
                    String sqlCrearTabla = new Fichero().leer("src/resources/sqlite/" + nombreTabla.toLowerCase() + "_crear.sql");
                    actualizar(sqlCrearTabla);
                    String sqlInsertarDatos = new Fichero().leer("src/resources/sqlite/" + nombreTabla.toLowerCase() + "_insertar.sql");
                    actualizar(sqlInsertarDatos);
                }
            //}
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
     * Funcion que realiza la consulta sobre la BBDD y la tabla Persona
     * @param sql a ejecutar
     * @return lista de personas
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Object> obtenerListadoPersonas(String sql) throws PersistenciaException {
        ArrayList<Object> listaPersonas = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Persona persona = new Persona();
                String dni = resultSet.getString("dni");
                persona.setApellidos(resultSet.getString("apellidos"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setDni(dni);
                persona.setTelefono(resultSet.getString("telefono"));
                persona.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                persona.setDireccion((Direccion)obtenerDireccion(dni));
                listaPersonas.add(persona);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listaPersonas;
    }

    /**
     * Funcion busca todos las personas guardados
     * @return lista de todas las personas
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Object> obtenerListadoPersonas() throws PersistenciaException {
        String sql = "SELECT * FROM Persona";
        return obtenerListadoPersonas(sql);
    }

    /**
     * Funcion que busca una persona especifica
     * @param dni dni de la persona
     * @return Persona encontrada
     * @throws PersistenciaException error controlado
     */
    public Object obtenerPersona(String dni) throws PersistenciaException {
        Object persona = null;
        ArrayList<Object> listaPersonas = null;
        String sql = "SELECT * FROM Persona where dni = ";
        sql = sql + "'" + dni + "'";
        listaPersonas = obtenerListadoPersonas(sql);
        if (!listaPersonas.isEmpty()) {
            persona = listaPersonas.get(0);
        }
        return persona;
    }

    

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Cliente
     * @param sql a ejecutar
     * @return lista de resultado
     * @throws BbddException error controlado
     */
    public ArrayList<Cliente> obtenerListadoClientes(String sql) throws PersistenciaException {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                String dni = resultSet.getString("dni");
                cliente.setCodigoCliente(resultSet.getString("codigoCliente"));
                cliente.setDni(dni);
                Persona persona = (Persona)obtenerPersona(dni);
                cliente.setNombre(persona.getNombre());
                cliente.setApellidos(persona.getApellidos());
                cliente.setFechaNacimiento(persona.getFechaNacimiento());
                cliente.setTelefono(persona.getTelefono());
                cliente.setDireccion(persona.getDireccion());
                listaClientes.add(cliente);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listaClientes;
    }

    /**
     * Funcion busca todos los clientes guardados
     * @return lista de todos los clientes
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Cliente> obtenerListadoClientes() throws PersistenciaException {
        String sql = "SELECT * FROM Cliente";
        return obtenerListadoClientes(sql);
    }

    /**
     * Funcion que busca un cliente especifico
     * @param dni dni del cliente
     * @return Cliente encotrado
     * @throws BbddException error controlado
     */
    public Cliente obtenerCliente(String dni) throws PersistenciaException {
        Cliente cliente = null;
        ArrayList<Cliente> listaClientes = null;
        String sql = "SELECT * FROM Cliente where dni =";
        sql = sql + "'" + dni + "'";
        listaClientes = obtenerListadoClientes(sql);
        if (!listaClientes.isEmpty()) {
            cliente = listaClientes.get(0);
        }

        return cliente;
    }




    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Empleado
     * @param sql a ejecutar
     * @return lista de resultado
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Object> obtenerListadoEmpleados(String sql) throws PersistenciaException {
        ArrayList<Object> listaEmpleados = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                String dni = resultSet.getString("dni");
                empleado.setCodigoEmpleado(resultSet.getString("codigoEmpleado"));
                empleado.setRango(resultSet.getString("rango"));
                empleado.setContrasenia(resultSet.getString("contraseña"));
                empleado.setDni(dni);
                Persona persona = (Persona)obtenerPersona(dni);
                empleado.setNombre(persona.getNombre());
                empleado.setApellidos(persona.getApellidos());
                empleado.setFechaNacimiento(persona.getFechaNacimiento());
                empleado.setTelefono(persona.getTelefono());
                empleado.setDireccion(persona.getDireccion());
                listaEmpleados.add(empleado);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        
        return listaEmpleados;
    }
    
    /**
     * Funcion busca todos los empleados guardados
     * @return lista de todos los empleados
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Object> obtenerListadoEmpleados() throws PersistenciaException {
        String sql = "SELECT * FROM Empleado";
        return obtenerListadoEmpleados(sql);
    }

    /**
     * Funcion que busca un empleado especifico
     * @param codigoEmpleado codigo del empleado a buscar
     * @return Empleado encotrado
     * @throws PersistenciaException error controlado
     */
    public Object obtenerEmpleados(String codigoEmpleado) throws PersistenciaException {
        Object empleado = null;
        ArrayList<Object> listaEmpleados = null;
        String sql = "SELECT * FROM Empleado where dni =";
        sql = sql + "'" + codigoEmpleado + "'";
        listaEmpleados = obtenerListadoEmpleados(sql);
        if (!listaEmpleados.isEmpty()) {
            empleado = listaEmpleados.get(0);
        }
        return empleado; 
    }





    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla vehiculo
     * @param sql a ejecutar
     * @return lista de resultado
     * @throws PersistenciaException
     */
    public ArrayList<Object> obtenerListadovehiculos(String sql) throws PersistenciaException {
        ArrayList<Object> listavehiculos = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setBastidor(resultSet.getString("bastidor"));
                vehiculo.setMatricula(resultSet.getString("matricula"));
                vehiculo.setMarca(resultSet.getString("marca"));
                vehiculo.setModelo(resultSet.getString("modelo"));
                vehiculo.setColor(resultSet.getString("color"));
                vehiculo.setPrecio(resultSet.getDouble("precio"));
                vehiculo.setExtrasInstalados(resultSet.getString("extrasInstalados"));
                vehiculo.setMotor(resultSet.getString("motor"));
                vehiculo.setPotencia(resultSet.getInt("potencia"));
                vehiculo.setCilindrada(resultSet.getString("cilindrada"));
                vehiculo.setTipo(resultSet.getString("tipo"));
                vehiculo.setEstado(resultSet.getString("estado"));
                listavehiculos.add(vehiculo);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listavehiculos;
    }


    /**
     * Funcion busca todos los vehiculos guardados
     * @return lista de todos los vehiculos
     * @throws PersistenciaException
     */
    public ArrayList<Object> obtenerListadovehiculos() throws PersistenciaException {
        String sql = "SELECT * FROM Vehiculo";
        return obtenerListadovehiculos(sql);
    }

    /**
     * Funcion que busca un vehiculo especifico
     * @param bastidor numero de bastidor del vehiculo a buscar
     * @return vehiculo encotrado
     * @throws PersistenciaException
     */
    public Object obtenerVehiculo(String bastidor) throws PersistenciaException  {
        Object vehiculo = null;
        ArrayList<Object> listavehiculos = null;
        String sql = "SELECT * FROM Vehiculo where bastidor =";
        sql = sql + "'" + bastidor + "'";
        listavehiculos = obtenerListadovehiculos(sql);
        if (!listavehiculos.isEmpty()) {
            vehiculo = listavehiculos.get(0);
        }

        return vehiculo;
    }





    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Direccion
     * @param sql a ejecutar
     * @return lista de resultado
     * @throws PersistenciaException
     */
    public ArrayList<Object> obtenerListadoDirecciones(String sql) throws PersistenciaException  {
        ArrayList<Object> listaDirecciones = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Direccion direccion = new Direccion();
                direccion.setIdentificador(resultSet.getString("identificador"));
                direccion.setCalle(resultSet.getString("calle"));
                direccion.setCiudad(resultSet.getString("ciudad"));
                direccion.setCodigoPostal(resultSet.getString("codigoPostal"));
                direccion.setNumero(resultSet.getInt("numero"));
                direccion.setPais(resultSet.getString("pais"));
                direccion.setProvincia(resultSet.getString("provincia"));
                listaDirecciones.add(direccion);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listaDirecciones;
    }

    /**
     * Funcion busca todas las direcciones guardadas
     * @return lista de todas las direcciones
     * @throws PersistenciaException
     */
    public ArrayList<Object> obtenerListadoDirecciones() throws PersistenciaException  {
        String sql = "SELECT * FROM Direccion";
        return obtenerListadoDirecciones(sql);
    }

    /**
     * Funcion que busca una direccion especifica
     * @param identificador identificador de la direccion
     * @return Direccion encontrada
     * @throws PersistenciaException
     */
    public Object obtenerDireccion(String identidicador) throws PersistenciaException  {
        Object direccion = null;
        ArrayList<Object> listaDirecciones = null;
        String sql = "SELECT * FROM Direccion where identificador =";
        sql = sql + "'" + identidicador + "'";
        listaDirecciones = obtenerListadoDirecciones(sql);
        if (!listaDirecciones.isEmpty()) {
            direccion = listaDirecciones.get(0);
        }

        return direccion;
    }





    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Venta
     * @param sql a ejecutar
     * @return lista de resultado
     * @throws PersistenciaException
     */
    public ArrayList<Object> obtenerListadoVentas(String sql) throws PersistenciaException  {
        ArrayList<Object> listaVentas = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setBastidor("bastidor");
                venta.setCodigoCliente("codigoCliente");
                venta.setCodigoEmpleado("codigoEmpleado");
                venta.setIdentificador("identificador");
                listaVentas.add(venta);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listaVentas;
    }

    public ArrayList<String> agruparVentas(String sql) throws PersistenciaException  {
        ArrayList<String> ventasAgrupadas = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String cantidad = resultSet.getString("COUNT(bastidor)");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                String resultado = marca + " " + modelo + ": " + cantidad;
                ventasAgrupadas.add(resultado);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return ventasAgrupadas;
    }
    /**
     * Funcion busca todas las ventas guardadas
     * @return lista de todas las ventas
     * @throws PersistenciaException
     */
    public ArrayList<Object> obtenerListadoVentas() throws PersistenciaException  {
        String sql = "SELECT * FROM Venta";
        return obtenerListadoDirecciones(sql);
    }

    /**
     * Funcion que busca una direccion especifica
     * @param identificador identificador de la venta
     * @return Venta encontrada
     * @throws PersistenciaException
     */
    public Object obtenerVenta(String identidicador) throws PersistenciaException  {
        Object venta = null;
        ArrayList<Object> listaVentas = null;
        String sql = "SELECT * FROM Venta where identificador =";
        sql = sql + "'" + identidicador + "'";
        listaVentas = obtenerListadoVentas(sql);
        if (!listaVentas.isEmpty()) {
            venta = listaVentas.get(0);
        }

        return venta;
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
     * @param conexion de la BD
     * @param statement de la BD
     * @param resultado de la BD
     * @throws PersistenciaException error controlado
     */
    private void closeConnection (Connection connection, Statement statement, ResultSet resultSet) throws PersistenciaException  {
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
