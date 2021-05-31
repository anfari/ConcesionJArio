package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase SqliteBbdd
 */
public class SqliteBbdd extends Bbdd {
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:concesionjario.db";

   /**
     * Constructor con todos los parametros de la clase SqliteBbdd
     * @param nombreTabla nombre de la tabla a inicializar
     * @param clave identificador de la tabla
     * @param driver driver necesario
     * @param url url de la BBDD
     * @param usuario usuario de la BBDD
     * @param password contrasenia del usuario
     * @throws PersistenciaException error controlado
     */
    public SqliteBbdd(String nombreTabla,String clave,String driver, String url, String usuario, String password) throws PersistenciaException {
        super(nombreTabla, clave, driver, url, usuario, password);
    }

    /**
     * Constructor solo con usuario y contrasenia
     * @param nombreTabla nombre de la tabla a inicializar
     * @param clave identificador de la tabla
     * @param usuario usuario de la BBDD
     * @param password contrasenia del usuario
     * @throws PersistenciaException error controlado
     */
    public SqliteBbdd(String nombreTabla,String clave,String usuario, String password) throws PersistenciaException {
        super(nombreTabla, clave, DRIVER, URL, usuario, password);
    }
    
}
