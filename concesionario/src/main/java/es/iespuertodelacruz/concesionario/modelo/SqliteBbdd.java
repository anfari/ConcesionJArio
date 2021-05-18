package es.iespuertodelacruz.concesionario.modelo;

/**
 * Clase SqliteBbdd
 */
public class SqliteBbdd extends Bbdd {
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:concesionjario.db";

    /**
     * Constructor con todos los parametros de la clase SqliteBbdd
     * @param driver driver necesario
     * @param url url de la BBDD
     * @param usuario usuario de la BBDD
     * @param password contrasenia del usuario
     */
    public SqliteBbdd(String driver, String url, String usuario, String password) {
        super(driver, url, usuario, password);
    }

    /**
     * Constructor solo con usuario y contrasenia
     * @param usuario usuario de la BBDD
     * @param password contrasenia del usuario
     */
    public SqliteBbdd(String usuario, String password) {
        super(DRIVER, URL, usuario, password);
    }
    
}
