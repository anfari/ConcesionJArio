package es.iespuertodelacruz.concesionario.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase DireccionModelo contiene los datos de direccion de un cliente
 */

public class DireccionModelo {
    SqliteBbdd persistencia;

    private static final String TABLA  = "Direccion";
    private static final String CLAVE  = "identificador";

    /**
     * Constructor de la Clase DireccionModelo
     * @throws PersistenciaException error controlado
     */
    public DireccionModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);
    }

    /**
     * Constructor para test de la Clase DireccionModelo
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public DireccionModelo(boolean test) throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, "org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);

    }


    /**
     * Metodo que inserta una direccion
     * @param direccion direccion a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertar(Direccion direccion) throws PersistenciaException {
        String sql ="INSERT INTO Direccion (identificador, calle, numero, codigoPostal" +
        ", provincia, ciudad, pais) " + 
        "VALUES ('"+ direccion.getIdentificador() + "', '"  + direccion.getCalle() + "', '" + direccion.getNumero() + 
        "', " + direccion.getCodigoPostal() + ", '" + direccion.getProvincia() + 
        "', '" + direccion.getCiudad() + "', '" + direccion.getPais() + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una direccion
     * @param direccion direccion a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificar(Direccion direccion) throws PersistenciaException {
        String sql = "UPDATE Direccion SET calle = '" + direccion.getCalle() +
        "', numero = '" + direccion.getNumero() + "', codigoPostal = '" + direccion.getCodigoPostal() +
        "', provincia = '" + direccion.getProvincia() + "', pais = '" + direccion.getPais() + 
        "', ciudad = '" + direccion.getCiudad() + 
        "' WHERE identificador = '" + direccion.getIdentificador() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina una direccion
     * @param direccion direccion a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(Direccion direccion) throws PersistenciaException {
        String sql = "DELETE from Direccion where identificador = '" + direccion.getIdentificador() + "'"; 
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que busca una direccion especifica
     * @param identificador identificador de la direccion
     * @return Direccion encontrada
     * @throws PersistenciaException error controlado
     */
    public Direccion buscar(String identificador) throws PersistenciaException  {
        Direccion direccion = null;
        ArrayList<Direccion> listaDirecciones = null;
        String sql = "SELECT * FROM Direccion where identificador = ";
        sql = sql + "'" + identificador + "'";
        listaDirecciones = convertir(sql);
        if (!listaDirecciones.isEmpty()) {
            direccion = listaDirecciones.get(0);
        }

        return direccion;
    }

    /**
     * Funcion busca todas las direcciones guardadas
     * @return lista de todas las direcciones
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Direccion> listadoDirecciones() throws PersistenciaException  {
        String sql = "SELECT * FROM Direccion";
        return convertir(sql);
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Direccion
     * @param sql a ejecutar
     * @return lista de resultados
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Direccion> convertir(String sql) throws PersistenciaException {
        ArrayList<Direccion> listaDirecciones = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            resultSet = persistencia.buscarElementos(sql);

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
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return listaDirecciones;
    }





}
