package es.iespuertodelacruz.concesionario.modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.iespuertodelacruz.concesionario.api.*;
import es.iespuertodelacruz.concesionario.exception.BbddException;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
/**
 * 
 * Clase BDbd, va a contener los datos para la base de datos
 */
public class Bbdd2  {
    Fichero fichero;
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
     */
    public Bbdd2(String driver, String url, String usuario, String password) {
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }
    /**
     * Constructor por defecto, para crear la conexion a la basede datos
     * @param driver driver para cargar la bd
     * @param url url con el puerto incluido de la bd
     * @param usuario usuario de la bd
     * @param password contraseña de la bd
     * @throws BbddException
     * @throws PersistenciaException
     */
    public Bbdd2(String nombreTabla, String clave, String driver, String url, String usuario, String password) throws PersistenciaException {
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

        String[] convertir = nombreTabla.split(",");
        List<String> nombreTablas = Arrays.asList(convertir);

        try {
            connection = getConnection();
            databaseMetaData = connection.getMetaData();
            resultSet = databaseMetaData.getTables(null, null, null, new String[] {"TABLE"});
            while (resultSet.next()) {
                listaTablas.add(resultSet.getString("TABLE_NAME"));
            }
            for (String tabla : nombreTablas) {
                if (!listaTablas.contains(tabla)) {
                    String sqlCrearTabla = fichero.leer(tabla + "_crear.sql");
                    actualizar(sqlCrearTabla);
                    String sqlInsertarDatos = fichero.leer(tabla + "_insertar.sql");
                    actualizar(sqlInsertarDatos);
                }
            }
        } catch (Exception e) {
            throw new PersistenciaException("Se ha producido un error en la inicializacion de la BBDD", e);
        } finally {
            closeConnection(connection, null, resultSet);
        }
    }

  

    //TODO: Modificar Direccion cuando sepamos PK

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
    //CRUD de Persona
    /**
     * Metodo encargado de realizar la insercion de una persona
     * @param persona persona a insertar
     * @throws BbddException error controlado
     
    
    public void insertarPersona(Persona persona) throws BbddException {
        String sql ="INSERT INTO Persona (dni,nombre, apellidos" + 
        "fechaNacimiento, telefono, direccion) VALUES ('" + persona.getDni() + 
        "', '" + persona.getNombre() + "', '" + persona.getApellidos() +
         "', '" + persona.getFechaNacimiento() + "', '" + 
        persona.getTelefono() + "', '" + persona.getDireccion() + "'";
        actualizar(sql);
    }
    
    /**
     * Metodo encargado de realizar la eliminacion de una persona
     * @param persona persona a eliminar
     * @throws BbddException error controlado
     
    public void eliminarPersona(Persona persona) throws BbddException {
        String sql = "DELETE from Persona where dni = '" + persona.getDni() + "'";
        actualizar(sql);
    }
    
    /**
     * Metodo encargado de realizar la modificacion de una Persona
     * @param persona persona a modificar
     * @throws BbddException error controlado
    
    public void modificarPersona(Persona persona) throws BbddException {
        String sql = "UPDATE Persona SET nombre = '" + persona.getNombre() +
        "', apellidos = '" + persona.getApellidos() +
        "', fechaNacimiento = '" + persona.getFechaNacimiento() + "', telefono = '" + 
        persona.getTelefono() + "', direccion = '" + persona.getDireccion() +
        "' WHERE dni = '" + persona.getDni()  + "'";
        actualizar(sql);
    }
*/
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
                Persona persona= new Persona();
                persona.setApellidos(resultSet.getString("apellidos"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setDni(resultSet.getString("dni"));
                persona.setTelefono(resultSet.getString("telefono"));
                persona.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                persona.setDireccion(obtenerDireccion(resultSet.getString("dni")));
                //String apellidos = resultSet.getString("apellidos");
                //String dni = resultSet.getString("dni");
                //String fechaNacimiento = resultSet.getString("fechaNacimiento");
                //String telefono = resultSet.getString("telefono");
                //Direccion direccion = obtenerDireccion("dni"); //TODO: Modificar cuando se tenga PK
               // persona = new Persona(nombre, apellidos, dni, fechaNacimiento, telefono, direccion);
                listaPersonas.add(persona);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
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
        String sql = "SELECT * FROM"+nombreTabla+"where"+clave+"=";
        sql = sql + "'" + dni + "'";
        listaPersonas = obtenerListadoPersonas(sql);
        if (!listaPersonas.isEmpty()) {
            persona = listaPersonas.get(0);
        }
        return persona;
    }

    
    //CRUD de Cliente
    
    /**
     * Metodo encargado de realizar la insercion de un cliente
     * @param cliente cliente a insertar
     * @throws BbddException error controlado
     
    public void insertarCliente(Cliente cliente) throws BbddException {
        String sql ="INSERT INTO Cliente (dni,nombre, apellidos" + 
        "fechaNacimiento, telefono, direccion) VALUES ('" + cliente.getDni() + 
        "', '" + cliente.getNombre() + "', '" + cliente.getApellidos() +
         "', '" + cliente.getFechaNacimiento() + "', '" + 
        cliente.getTelefono() + "', '" + cliente.getDireccion() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la eliminacion de un cliente
     * @param cliente cliente a eliminar
     * @throws BbddException error controlado
     
    public void eliminarCliente(Cliente cliente) throws BbddException {
        String sql = "DELETE from Cliente where dni = '" + cliente.getDni() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la modificacion de un cliente
     * @param cliente cliente a modificar
     * @throws BbddException error controlado
     
    public void modificarCliente(Cliente cliente) throws BbddException {
        String sql = "UPDATE Cliente SET nombre = '" + cliente.getNombre() +
        "', apellidos = '" + cliente.getApellidos() +
        "', fechaNacimiento = '" + cliente.getFechaNacimiento() + "', telefono = '" + 
        cliente.getTelefono() + "', direccion = '" + cliente.getDireccion() +
        "' WHERE dni = '" + cliente.getDni()  + "'";
        actualizar(sql);
    }
    */
    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Cliente
     * @param sql a ejecutar
     * @return lista de resultado
     * @throws BbddException error controlado
     */
    public ArrayList<Object> obtenerListadoClientes(String sql) throws PersistenciaException {
        ArrayList<Object> listaClientes = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigoCliente(resultSet.getString("codigoCliente"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(obtenerDireccion(resultSet.getString("dni")));
                //String codigoCliente = resultSet.getString("codigoCliente");
                //String nombre = resultSet.getString("nombre");
                //String apellidos = resultSet.getString("apellidos");
                //String dni = resultSet.getString("dni");
                //String fechaNacimiento = resultSet.getString("fechaNacimiento");
                //String telefono = resultSet.getString("telefono");
                //Direccion direccion = obtenerDireccion("codigoCliente");//TODO: Modificar cuando se tenga PK
                //cliente = new Cliente(codigoCliente, nombre, apellidos, dni, fechaNacimiento, telefono, direccion);
                listaClientes.add(cliente);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
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
    public ArrayList<Object> obtenerListadoClientes() throws PersistenciaException {
        String sql = "SELECT * FROM Cliente";
        return obtenerListadoClientes(sql);
    }

    /**
     * Funcion que busca un cliente especifico
     * @param dni dni del cliente
     * @return Cliente encotrado
     * @throws BbddException error controlado
     */
    public Object obtenerCliente(String dni) throws PersistenciaException {
        Object cliente = null;
        ArrayList<Object> listaClientes = null;
        String sql = "SELECT * FROM Cliente where dni =";
        sql = sql + "'" + dni + "'";
        listaClientes = obtenerListadoClientes(sql);
        if (!listaClientes.isEmpty()) {
            cliente = listaClientes.get(0);
        }

        return cliente;
    }



    //CRUD de Empleado

    /**
     * Metodo encargado de realizar la insercion de un empleado
     * @param empleado empleado a insertar
     * @throws PersistenciaException error controlado
     
    public void insertarVendedor(Empleado empleado) throws PersistenciaException {
        String sql ="INSERT INTO Empleado (dni, nombre, apellidos " + 
        "fechaNacimiento, telefono, direccion,codigoEmpleado"+
        "+,rango,contrasenia) VALUES ('" + empleado.getDni()+ 
        "', '" + empleado.getNombre() + "', '" + empleado.getApellidos() + "', '"
         + empleado.getFechaNacimiento() + "', '" + 
        empleado.getTelefono() + "', '" + empleado.getDireccion() + 
         "', '" + empleado.getCodigoEmpleado() + "', '" + empleado.getRango() +
         "', '" + empleado.getContrasenia() +"'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la eliminacion de un empleado
     * @param empleado empleado a eliminar
     * @throws PersistenciaException error controlado
     
    public void eliminarEmpleado(Empleado empleado) throws PersistenciaException {
        String sql = "DELETE from Empleado where codigoEmpleado = '" + 
        empleado.getCodigoEmpleado() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la modificacion de un empleado
     * @param empleado empleado a modificar
     * @throws PersistenciaException error controlado
     
    public void modificarEmpleado(Empleado empleado) throws PersistenciaException {
        String sql = "UPDATE Empleado SET nombre = '" + empleado.getNombre() +
        "', apellidos = '" + empleado.getApellidos() +
        "', fechaNacimiento = '" + empleado.getFechaNacimiento() + "', telefono = '" + 
        empleado.getTelefono() + "', direccion = '" + empleado.getDireccion() +
        "', dni = '" + empleado.getDni()+"', rango = '" + empleado.getRango()+
        "', contrasenia = '" + empleado.getContrasenia()+
        "' WHERE codigoEmpleado = '" + empleado.getCodigoEmpleado() + "'";
        actualizar(sql);
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
                empleado.setCodigoEmpleado(resultSet.getString("codigoEmpleado"));
                empleado.setRango(resultSet.getString("rango"));
                empleado.setContrasenia(resultSet.getString("contraseña"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setApellidos(resultSet.getString("apellidos"));
                empleado.setDni(resultSet.getString("dni"));
                empleado.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                empleado.setCodigoEmpleado(resultSet.getString("telefono"));
                empleado.setDireccion(obtenerDireccion("dni"));
                //Direccion direccion = obtenerDireccion("codigoEmpleado"); //TODO: Modificar cuando se tenga PK
                //empleado = new Empleado(codigoEmpleado, nombre, apellidos, dni, fechaNacimiento, telefono, direccion, rango, contrasenia);
                listaEmpleados.add(empleado);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
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





    //CRUD de vehiculo

    /**
     * Metodo encargado de realizar la insercion de un vehiculo
     * @param vehiculo vehiculo a insertar
     * @throws PersistenciaException error controlado
     
    public void insertarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        String sql ="INSERT INTO Vehiculo (bastidor, matricula, marca, modelo, color, precio, " + 
        "extrasInstalados, motor, potencia, cilindrada,tipo) VALUES ('" + vehiculo.getBastidor() + 
        "', '" + vehiculo.getMatricula() + "', '" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + 
        "', '" + vehiculo.getColor() + "', '" + vehiculo.getPrecio() + "', '" + vehiculo.getExtrasInstalados() + 
        "', '" + vehiculo.getMotor() + "', '" + vehiculo.getPotencia() + "', '" + vehiculo.getCilindrada()+ 
        "', '" + vehiculo.getTipo() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la eliminacion de un vehiculo
     * @param vehiculo vehiculo a eliminar
     * @throws PersistenciaException error controlado
     
    public void eliminarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        String sql = "DELETE from Vehiculo where bastidor = '" + vehiculo.getBastidor() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la modificacion de un vehiculo
     * @param vehiculo vehiculo a modificar
     * @throws PersistenciaException error controlado
     
    public void modificarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        String sql = "UPDATE Vehiculo SET matricula = '" + vehiculo.getMatricula() +
        "', marca = '" + vehiculo.getMarca() + "', modelo = '" + vehiculo.getModelo() +
        "', color = '" + vehiculo.getColor() + "', precio = '" + vehiculo.getPrecio() + 
        "', extrasInstalados = '" + vehiculo.getExtrasInstalados() +
        "', motor = '" + vehiculo.getMotor() + "', potencia = '" + vehiculo.getPotencia() + 
        "', cilindrada = '" + vehiculo.getCilindrada() + 
        "' WHERE bastidor = '" + vehiculo.getBastidor() + "'";
        actualizar(sql);
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
                //vehiculo = new Vehiculo(bastidor, matricula, marca, modelo, color,
                //precio, extrasInstalados, motor, potencia, cilindrada,tipo);
                listavehiculos.add(vehiculo);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
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





    //CRUD de Direccion

    /**
     * Metodo encargado de realizar la insercion de una direccion
     * @param direccion direccion a insertar
     * @throws PersistenciaException
     
    public void insertarDireccion(Direccion direccion) throws PersistenciaException  {
        String sql ="INSERT INTO Direccion (identificador, calle, numero, codigoPostal"
        +", provincia, ciudad,pais) " + 
        "VALUES ('"+ direccion.getIdentificador() + "', '"  + direccion.getCalle() + "', '" + direccion.getNumero() + 
        "', '" + direccion.getCodigoPostal() + "', '" + direccion.getProvincia() + 
        "', '" + direccion.getCiudad() + "', '" + direccion.getPais() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la eliminacion de una direccion
     * @param direccion direccion a eliminar
     * @throws PersistenciaException
     
    public void eliminarDireccion(Direccion direccion) throws PersistenciaException  {
        String sql = "DELETE from Direccion where identificador = '" + direccion.getIdentificador() + "'"; 
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la modificacion de una direccion
     * @param direccion direccion a modificar
     * @throws PersistenciaException
     
    public void modificarDireccion(Direccion direccion) throws PersistenciaException {
        String sql = "UPDATE Direccion SET calle = '" + direccion.getCalle() +
        "', numero = '" + direccion.getNumero() + "', codigoPostal = '" + direccion.getCodigoPostal() +
        "', provincia = '" + direccion.getProvincia() + "', pais = '" + direccion.getPais() + 
        "', ciudad = '" + direccion.getCiudad() + 
        "' WHERE identificador = '" + direccion.getIdentificador() + "'";
        actualizar(sql);
    }
    */
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
                //String identificador=resultSet.getString("identificador");
                //String calle = resultSet.getString("calle");
                //int numero = resultSet.getInt("numero");
                //String codigoPostal = resultSet.getString("codigoPostal");
                //String provincia = resultSet.getString("provincia");
                //String ciudad = resultSet.getString("ciudad");
                //String pais = resultSet.getString("pais");
                //direccion = new Direccion(identificador, calle, numero, codigoPostal,
                //provincia, ciudad, pais);
                listaDirecciones.add(direccion);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
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
     * @param identificador dni de la persona
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
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
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
