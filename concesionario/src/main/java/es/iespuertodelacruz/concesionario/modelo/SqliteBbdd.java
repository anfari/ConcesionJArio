package es.iespuertodelacruz.concesionario.modelo;

/**
 * Clase SqliteBbdd
 */
public class SqliteBbdd extends Bbdd {
    /**
     * Constructor con todos los parametros de la clase SqliteBbdd
     * @param driver driver necesario
     * @param url url de la BBDD
     * @param usuario usuario de la BBDD
     * @param password contraseña del usuario
     */
    public SqliteBbdd(String driver, String url, String usuario, String password) {
        super(driver, url, usuario, password);
    }
    
}
