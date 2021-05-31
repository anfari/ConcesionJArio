package es.iespuertodelacruz.concesionario.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Vehiculo;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase VehiculoModelo 
 */
public class VehiculoModelo {
    SqliteBbdd persistencia;

    private static final String TABLA  = "Vehiculo";
    private static final String CLAVE  = "bastidor";

    /**
     * Constructor de la clase CocheModelo
     * @throws PersistenciaException error controlado
     */
    public VehiculoModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);
    }

    /**
     * Constructor para test de la Clase VehiculoModelo
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public VehiculoModelo(boolean test) throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, "org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);

    }


    /**
     * Metodo que inserta en una lista
     * @param vehiculo inserta el vehiculo
     * @throws PersistenciaException error controlado
     */
    public void insertar(Vehiculo vehiculo) throws PersistenciaException {
        String sql ="INSERT INTO Vehiculo (bastidor, matricula, marca, modelo, color, precio, " + 
        "extrasInstalados, motor, potencia, cilindrada, tipo, estado) VALUES ('" + vehiculo.getBastidor() + 
        "', '" + vehiculo.getMatricula() + "', '" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + 
        "', '" + vehiculo.getColor() + "', '" + vehiculo.getPrecio() + "', '" + vehiculo.getExtrasInstalados() + 
        "', '" + vehiculo.getMotor() + "', '" + vehiculo.getPotencia() + "', '" + vehiculo.getCilindrada() + 
        "', '" + vehiculo.getTipo() + "', '" + vehiculo.getEstado() + "')";
        persistencia.actualizar(sql);
    }
     /**
     * Metodo que modifica en una lista
     * @param vehiculo vehiculo a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificar(Vehiculo vehiculo) throws PersistenciaException {
        String sql = "UPDATE Vehiculo SET matricula = '" + vehiculo.getMatricula() +
        "', marca = '" + vehiculo.getMarca() + "', modelo = '" + vehiculo.getModelo() +
        "', color = '" + vehiculo.getColor() + "', precio = '" + vehiculo.getPrecio() + 
        "', extrasInstalados = '" + vehiculo.getExtrasInstalados() +
        "', motor = '" + vehiculo.getMotor() + "', potencia = '" + vehiculo.getPotencia() + 
        "', cilindrada = '" + vehiculo.getCilindrada() + "', tipo = '" + vehiculo.getTipo() + 
        "', estado = '" + vehiculo.getEstado() + "' WHERE bastidor = '" + vehiculo.getBastidor() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina un vehiculo de la lista
     * @param vehiculo vehiculo a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(Vehiculo vehiculo) throws PersistenciaException {
        String sql = "DELETE from Vehiculo where bastidor = '" + vehiculo.getBastidor() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que busca un vehiculo especifico
     * @param bastidor numero de bastidor del vehiculo
     * @return Vehiculo encontrado
     * @throws PersistenciaException error controlado
     */
    public Vehiculo buscar(String bastidor) throws PersistenciaException  {
        Vehiculo vehiculo = null;
        ArrayList<Vehiculo> listaVehiculos = null;
        String sql = "SELECT * FROM Vehiculo where bastidor = ";
        sql = sql + "'" + bastidor + "'";
        listaVehiculos = convertir(sql);
        if (!listaVehiculos.isEmpty()) {
            vehiculo = listaVehiculos.get(0);
        }

        return vehiculo;
    }

    /**
     * Funcion busca todos los vehiculos guardados
     * @return lista de todos los vehiculos
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Vehiculo> listadoVehiculos() throws PersistenciaException  {
        String sql = "SELECT * FROM Vehiculo";
        return convertir(sql);
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Vehiculo
     * @param sql a ejecutar
     * @return lista de resultados
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Vehiculo> convertir(String sql) throws PersistenciaException {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            resultSet = persistencia.buscarElementos(sql);

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
                listaVehiculos.add(vehiculo);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return listaVehiculos;
    }


}
