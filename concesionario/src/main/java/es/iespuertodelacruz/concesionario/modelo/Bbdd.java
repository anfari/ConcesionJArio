package es.iespuertodelacruz.concesionario.modelo;
import java.sql.*;
import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.*;
import es.iespuertodelacruz.concesionario.exception.BbddException;
/**
 * /**
 * Clase BDbd, va a contener los datos para la base de datos
 */
public class Bbdd {
    
    private String driver;
    private String url;
    private String usuario;
    private String password;

    /**
     * Constructor por defecto, para crear la conexion a la basede datos
     * @param driver driver para cargar la bd
     * @param url url con el puerto incluido de la bd
     * @param usuario usuario de la bd
     * @param password contraseña de la bd
     */
    public Bbdd(String driver, String url, String usuario, String password) {
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    //TODO: Modificar Direccion cuando sepamos PK

    /**
     * Funcion encargada de realizar la conexion con la BBDD
     * @return la conexion
     * @throws BbddException error controlado
     */
    private Connection getConnection() throws BbddException {
        Connection connection = null;

        try {
            Class.forName(driver);
            if (usuario == null ||password == null) {
                connection = DriverManager.getConnection(url);
            } else {
                connection = DriverManager.getConnection(url, usuario, password);
            }
        } catch (Exception exception) {
            throw new BbddException("No se ha podido establecer la conexion con la BBDD", exception);
        }
        
        return connection;
    }

    









    
    //CRUD de Cliente
    
    /**
     * Metodo encargado de realizar la insercion de un cliente
     * @param cliente cliente a insertar
     * @throws BbddException error controlado
     */
    public void insertarCliente(Cliente cliente) throws BbddException {
        String sql ="INSERT INTO Cliente (codigoCliente, nombre, apellidos, dni, " + 
        "fechaNacimiento, telefono, direccion) VALUES ('" + cliente.getCodigoCliente() + 
        "', '" + cliente.getNombre() + "', '" + cliente.getApellidos() + "', '" + 
        cliente.getDni() + "', '" + cliente.getFechaNacimiento() + "', '" + 
        cliente.getTelefono() + "', '" + cliente.getDireccion() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la eliminacion de un cliente
     * @param cliente cliente a eliminar
     * @throws BbddException error controlado
     */
    public void eliminarCliente(Cliente cliente) throws BbddException {
        String sql = "DELETE from Cliente where codigoCliente = '" + cliente.getCodigoCliente() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la modificacion de un cliente
     * @param cliente cliente a modificar
     * @throws BbddException error controlado
     */
    public void modificarCliente(Cliente cliente) throws BbddException {
        String sql = "UPDATE Cliente SET nombre = '" + cliente.getNombre() +
        "', apellidos = '" + cliente.getApellidos() + "', dni = '" + cliente.getDni() +
        "', fechaNacimiento = '" + cliente.getFechaNacimiento() + "', telefono = '" + 
        cliente.getTelefono() + "', direccion = '" + cliente.getDireccion() +
        "' WHERE codigoCliente = '" + cliente.getCodigoCliente() + "'";
        actualizar(sql);
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Cliente
     * @param sql a ejecutar
     * @return lista de resultado
     * @throws BbddException error controlado
     */
    public ArrayList<Cliente> obtenerListadoClientes(String sql) throws BbddException {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int codigoCliente = resultSet.getInt("codigoCliente");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String dni = resultSet.getString("dni");
                String fechaNacimiento = resultSet.getString("fechaNacimiento");
                String telefono = resultSet.getString("telefono");
                Direccion direccion = null; //TODO: Modificar cuando se tenga PK
                cliente = new Cliente(codigoCliente, nombre, apellidos, dni, fechaNacimiento, telefono, direccion);
                listaClientes.add(cliente);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        
        return listaClientes;
    }

    /**
     * Funcion busca todos los clientes guardados
     * @return lista de todos los clientes
     * @throws BbddException error controlado
     */
    public ArrayList<Cliente> obtenerListadoClientes() throws BbddException {
        String sql = "SELECT * FROM Cliente";
        return obtenerListadoClientes(sql);
    }

    /**
     * Funcion que busca un cliente especifico
     * @param codigoCliente codigo del cliente a buscar
     * @return Cliente encotrado
     * @throws BbddException error controlado
     */
    public Cliente obtenerCliente(int codigoCliente) throws BbddException {
        Cliente cliente = null;
        ArrayList<Cliente> listaClientes = null;
        String sql = "SELECT * FROM Cliente where codigoCliente =";
        sql = sql + "'" + codigoCliente + "'";
        listaClientes = obtenerListadoClientes(sql);
        if (!listaClientes.isEmpty()) {
            cliente = listaClientes.get(0);
        }

        return cliente;
    }





    //CRUD de Vendedor

    /**
     * Metodo encargado de realizar la insercion de un vendedor
     * @param vendedor vendedor a insertar
     * @throws BbddException error controlado
     */
    public void insertarVendedor(Vendedor vendedor) throws BbddException {
        String sql ="INSERT INTO Vendedor (codigoVendedor, nombre, apellidos, dni, " + 
        "fechaNacimiento, telefono, direccion) VALUES ('" + vendedor.getCodigoVendedor() + 
        "', '" + vendedor.getNombre() + "', '" + vendedor.getApellidos() + "', '" + 
        vendedor.getDni() + "', '" + vendedor.getFechaNacimiento() + "', '" + 
        vendedor.getTelefono() + "', '" + vendedor.getDireccion() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la eliminacion de un vendedor
     * @param vendedor vendedor a eliminar
     * @throws BbddException error controlado
     */
    public void eliminarVendedor(Vendedor vendedor) throws BbddException {
        String sql = "DELETE from Vendedor where codigoVendedor = '" + vendedor.getCodigoVendedor() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la modificacion de un vendedor
     * @param vendedor vendedor a modificar
     * @throws BbddException error controlado
     */
    public void modificarVendedor(Vendedor vendedor) throws BbddException {
        String sql = "UPDATE Vendedor SET nombre = '" + vendedor.getNombre() +
        "', apellidos = '" + vendedor.getApellidos() + "', dni = '" + vendedor.getDni() +
        "', fechaNacimiento = '" + vendedor.getFechaNacimiento() + "', telefono = '" + 
        vendedor.getTelefono() + "', direccion = '" + vendedor.getDireccion() +
        "' WHERE codigoVendedor = '" + vendedor.getCodigoVendedor() + "'";
        actualizar(sql);
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Vendedor
     * @param sql a ejecutar
     * @return lista de resultado
     * @throws BbddException error controlado
     */
    public ArrayList<Vendedor> obtenerListadoVendedores(String sql) throws BbddException {
        ArrayList<Vendedor> listaVendedores = new ArrayList<>();
        Vendedor vendedor = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int codigoVendedor = resultSet.getInt("codigoVendedor");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String dni = resultSet.getString("dni");
                String fechaNacimiento = resultSet.getString("fechaNacimiento");
                String telefono = resultSet.getString("telefono");
                Direccion direccion = null; //TODO: Modificar cuando se tenga PK
                vendedor = new Vendedor(codigoVendedor, nombre, apellidos, dni, fechaNacimiento, telefono, direccion);
                listaVendedores.add(vendedor);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        
        return listaVendedores;
    }

    /**
     * Funcion busca todos los vendedores guardados
     * @return lista de todos los vendedores
     * @throws BbddException error controlado
     */
    public ArrayList<Vendedor> obtenerListadoVendedores() throws BbddException {
        String sql = "SELECT * FROM Vendedor";
        return obtenerListadoVendedores(sql);
    }

    /**
     * Funcion que busca un vendedor especifico
     * @param codigoVendedor codigo del vendedor a buscar
     * @return Vendedor encotrado
     * @throws BbddException error controlado
     */
    public Vendedor obtenerVendedor(int codigoVendedor) throws BbddException {
        Vendedor vendedor = null;
        ArrayList<Vendedor> listaVendedores = null;
        String sql = "SELECT * FROM Vendedor where codigoVendedor =";
        sql = sql + "'" + codigoVendedor + "'";
        listaVendedores = obtenerListadoVendedores(sql);
        if (!listaVendedores.isEmpty()) {
            vendedor = listaVendedores.get(0);
        }

        return vendedor;
    }





    //CRUD de Coche

    /**
     * Metodo encargado de realizar la insercion de un coche
     * @param coche coche a insertar
     * @throws BbddException error controlado
     */
    public void insertarCoche(Coche coche) throws BbddException {
        String sql ="INSERT INTO Coche (bastidor, matricula, marca, modelo, color, precio, " + 
        "extrasInstalados, motor, potencia, cilindrada) VALUES ('" + coche.getBastidor() + 
        "', '" + coche.getMatricula() + "', '" + coche.getMarca() + "', '" + coche.getModelo() + 
        "', '" + coche.getColor() + "', '" + coche.getPrecio() + "', '" + coche.getExtrasInstalados() + 
        "', '" + coche.getMotor() + "', '" + coche.getPotencia() + "', '" + coche.getCilindrada() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la eliminacion de un coche
     * @param coche coche a eliminar
     * @throws BbddException error controlado
     */
    public void eliminarCoche(Coche coche) throws BbddException {
        String sql = "DELETE from Coche where bastidor = '" + coche.getBastidor() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la modificacion de un coche
     * @param coche coche a modificar
     * @throws BbddException error controlado
     */
    public void modificarCoche(Coche coche) throws BbddException {
        String sql = "UPDATE Coche SET matricula = '" + coche.getMatricula() +
        "', marca = '" + coche.getMarca() + "', modelo = '" + coche.getModelo() +
        "', color = '" + coche.getColor() + "', precio = '" + coche.getPrecio() + 
        "', extrasInstalados = '" + coche.getExtrasInstalados() +
        "', motor = '" + coche.getMotor() + "', potencia = '" + coche.getPotencia() + 
        "', cilindrada = '" + coche.getCilindrada() + 
        "' WHERE codigoCliente = '" + coche.getBastidor() + "'";
        actualizar(sql);
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Coche
     * @param sql a ejecutar
     * @return lista de resultado
     * @throws BbddException error controlado
     */
    public ArrayList<Coche> obtenerListadoCoches(String sql) throws BbddException {
        ArrayList<Coche> listaCoches = new ArrayList<>();
        Coche coche = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String bastidor = resultSet.getString("bastidor");
                String matricula = resultSet.getString("matricula");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                String color = resultSet.getString("color");
                double precio = resultSet.getDouble("precio");
                String extrasInstalados = resultSet.getString("extrasInstalados");
                String motor = resultSet.getString("motor");
                int potencia = resultSet.getInt("potencia");
                String cilindrada = resultSet.getString("cilindrada");
                coche = new Coche(bastidor, matricula, marca, modelo, color, precio, extrasInstalados, motor, potencia, cilindrada);
                listaCoches.add(coche);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        
        return listaCoches;
    }

    /**
     * Funcion busca todos los coches guardados
     * @return lista de todos los coches
     * @throws BbddException error controlado
     */
    public ArrayList<Coche> obtenerListadoCoches() throws BbddException {
        String sql = "SELECT * FROM Coche";
        return obtenerListadoCoches(sql);
    }

    /**
     * Funcion que busca un coche especifico
     * @param bastidor numero de bastidor del coche a buscar
     * @return Coche encotrado
     * @throws BbddException error controlado
     */
    public Coche obtenerCoche(String bastidor) throws BbddException {
        Coche coche = null;
        ArrayList<Coche> listaCoches = null;
        String sql = "SELECT * FROM Coche where bastidor =";
        sql = sql + "'" + bastidor + "'";
        listaCoches = obtenerListadoCoches(sql);
        if (!listaCoches.isEmpty()) {
            coche = listaCoches.get(0);
        }

        return coche;
    }





    //CRUD de Direccion

    /**
     * Metodo encargado de realizar la insercion de una direccion
     * @param direccion direccion a insertar
     * @throws BbddException error controlado
     */
    public void insertarDireccion(Direccion direccion) throws BbddException {
        String sql ="INSERT INTO Direccion (calle, numero, codigoPostal, provincia, poblacion) " + 
        "VALUES ('" + direccion.getCalle() + "', '" + direccion.getNumero() + 
        "', '" + direccion.getCodigoPostal() + "', '" + direccion.getProvincia() + 
        "', '" + direccion.getPoblacion() + "'";
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la eliminacion de una direccion
     * @param direccion direccion a eliminar
     * @throws BbddException error controlado
     */
    public void eliminarDireccion(Direccion direccion) throws BbddException {
        String sql = "DELETE from Direccion where unknown = '" + direccion.getCodigoPostal() + "'";  //TODO: cambiar cuando sepamos PK de direccion
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la modificacion de una direccion
     * @param direccion direccion a modificar
     * @throws BbddException error controlado
     */
    public void modificarDireccion(Direccion direccion) throws BbddException {
        String sql = "UPDATE Direccion SET calle = '" + direccion.getCalle() +
        "', numero = '" + direccion.getNumero() + "', codigoPostal = '" + direccion.getCodigoPostal() +
        "', provincia = '" + direccion.getProvincia() + "', poblacion = '" + direccion.getPoblacion() + 
        "' WHERE codigoCliente = '" + direccion.getCodigoPostal() + "'";
        actualizar(sql);
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Direccion
     * @param sql a ejecutar
     * @return lista de resultado
     * @throws BbddException error controlado
     */
    public ArrayList<Direccion> obtenerListadoDirecciones(String sql) throws BbddException {
        ArrayList<Direccion> listaDirecciones = new ArrayList<>();
        Direccion direccion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String calle = resultSet.getString("calle");
                int numero = resultSet.getInt("numero");
                String codigoPostal = resultSet.getString("codigoPostal");
                String provincia = resultSet.getString("provincia");
                String poblacion = resultSet.getString("poblacion");
                direccion = new Direccion(calle, numero, codigoPostal, provincia, poblacion);
                listaDirecciones.add(direccion);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        
        return listaDirecciones;
    }

    /**
     * Funcion busca todas las direcciones guardadas
     * @return lista de todas las direcciones
     * @throws BbddException error controlado
     */
    public ArrayList<Direccion> obtenerListadoDirecciones() throws BbddException {
        String sql = "SELECT * FROM Direccion";
        return obtenerListadoDirecciones(sql);
    }

    /**
     * Funcion que busca una direccion especifica
     * @param unknown numero de bastidor del coche a buscar
     * @return Direccion encotrada
     * @throws BbddException error controlado
     */
    public Direccion obtenerDireccion(String unknown) throws BbddException {
        Direccion direccion = null;
        ArrayList<Direccion> listaDirecciones = null;
        String sql = "SELECT * FROM Direccion where bastidor =";
        sql = sql + "'" + unknown + "'";
        listaDirecciones = obtenerListadoDirecciones(sql);
        if (!listaDirecciones.isEmpty()) {
            direccion = listaDirecciones.get(0);
        }

        return direccion;
    }








    /**
     * Metodo encargado de realizar la actualizacion de la BBDD
     * @param sql a ejecutar
     * @throws BbddException error controlado
     */
    private void actualizar(String sql) throws BbddException {
        Statement statement;
        Connection connection;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        }
    }

      /**
     * Metodo privado encargado de cerrar la conexion con la base de datos
     * @param conexion de la BD
     * @param statement de la BD
     * @param resultado de la BD
     * @throws BDbdException error controlado
     */
    private void closeConnection (Connection connection, Statement statement, ResultSet resultSet) throws BbddException {
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
            throw new BbddException("Se ha producido un error cerando la conexion", exception);
        }
    }

}
