package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.exception.BbddException;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase DireccionModelo contiene los datos de direccion de un cliente
 */

public class DireccionModelo {
    SqliteBbdd persistencia;

    private static final String TABLA  = "CUENTA";
    private static final String CLAVE  = "CODIGO";

    /**
     * Constructor de la Clase DireccionModelo
     * @throws BbddException
     * @throws PersistenciaException
     */
    public DireccionModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);
    }

    /**
     * Metodo que inserta una direccion
     * @param direccion direccion a insertar
     * @throws PersistenciaException
     * @throws BbddException error controlado
     */
    public void insertar(Direccion direccion) throws PersistenciaException {
        String sql ="INSERT INTO Direccion (identificador, calle, numero, codigoPostal"
        +", provincia, ciudad,pais) " + 
        "VALUES ('"+ direccion.getIdentificador() + "', '"  + direccion.getCalle() + "', '" + direccion.getNumero() + 
        "', '" + direccion.getCodigoPostal() + "', '" + direccion.getProvincia() + 
        "', '" + direccion.getCiudad() + "', '" + direccion.getPais() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una direccion
     * @param direccion direccion a modificar
     * @throws PersistenciaException
     */
    public void actualizar(Direccion direccion) throws PersistenciaException {
        String sql = "UPDATE Direccion SET calle = '" + direccion.getCalle() +
        "', numero = '" + direccion.getNumero() + "', codigoPostal = '" + direccion.getCodigoPostal() +
        "', provincia = '" + direccion.getProvincia() + "', pais = '" + direccion.getPais() + 
        "', ciudad = '" + direccion.getCiudad() + 
        "' WHERE identificador = '" + direccion.getIdentificador() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que busca una direccion
     * @param identificador identificador de la direccion a buscar
     * @return direccion encontrada
     * @throws PersistenciaException
     */
    public Direccion buscar(String identificador) throws PersistenciaException {
        return (Direccion)persistencia.obtenerDireccion(identificador);
    }

    /**
     * Metodo que elimina una direccion
     * @param direccion direccion a eliminar
     * @throws PersistenciaException
     */
    public void eliminar(Direccion direccion) throws PersistenciaException {
        String sql = "DELETE from Direccion where identificador = '" + direccion.getIdentificador() + "'"; 
        persistencia.actualizar(sql);
    }
}
