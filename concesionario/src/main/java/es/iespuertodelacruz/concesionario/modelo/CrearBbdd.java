package es.iespuertodelacruz.concesionario.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.exception.BbddException;

public class CrearBbdd {
    
    private String driver;
    private String url;
    private String usuario;
    private String password;



    public CrearBbdd(String driver, String url, String usuario, String password) {
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }


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

    
    


/** 
    //CRUD
    public void insertar(Fruta fruta) {
        
    }

    public void eliminar(Fruta fruta) {

    }

    public void modificar(Fruta fruta) {

    }*/

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Fruta
     * @param sql 
     * @return lista de resultado
     * @throws BbddException error controlado
     */
    public ArrayList<Cliente> obtenerListado(String sql) throws BbddException {
        ArrayList<Cliente> listaFrutas = new ArrayList<>();
        Cliente cliente = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            //resultSet = 
            statement.executeQuery(sql);
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        
        return listaFrutas;
    }

    public ArrayList<Cliente> crearCliente() throws BbddException {
        String sql = "CREATE TABLE IF NOT EXISTS Clientes (" +
            "codigoCliente INTEGER NOT NULL PRIMARY KEY, " +
            "nombre TEXT NOT NULL, " +
            "apellidos TEXT NOT NULL, " +
            "dni TEXT NOT NULL UNIQUE, "+ 
            "fechaNacimiento TEXT NOT NULL, " +
            "telefono TEXT NOT NULL, " +
            "direccion TEXT NOT NULL);";
        return obtenerListado(sql);
    }

    public Cliente obtenerFruta(String identificador) throws BbddException {
        Cliente cliente = null;
        ArrayList<Cliente> listaClientes = null;
        String sql = "SELECT * FROM Cliente where identificador =";
        sql = sql + "'" + identificador + "'";
        listaClientes = obtenerListado(sql);
        if (!listaClientes.isEmpty()) {
            cliente = listaClientes.get(0);
        }

        return cliente;
    }





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
