package es.iespuertodelacruz.concesionario.controlador;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.exception.DireccionException;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.modelo.DireccionModelo;

/**
 * Clase DireccionController
 */
public class DireccionController extends Validaciones {
    DireccionModelo direccionModelo;

    /**
     * Constructor de la clase DireccionController
     * @throws PersistenciaException error controlado
     */
    public DireccionController() throws PersistenciaException {
        direccionModelo = new DireccionModelo();
    }

    /**
     * Constructor para test de la clase DireccionController
     * @param test parametro que recibe de la llamada en los test
     * @throws PersistenciaException error controlado
     */
    public DireccionController(boolean test) throws PersistenciaException {
        direccionModelo = new DireccionModelo(true);
    }


    /**
     * Metodo encargado de realizar la validacion del objeto Direccion
     * @param direccion direccion a validar
     * @throws DireccionException error controlado
     */
    public void validarDireccion(Direccion direccion) throws DireccionException {
        String mensaje = "";

        if (direccion == null) {
            mensaje = "Se esta intentando validar un objeto vacio";
            throw new DireccionException(mensaje);
        }
        if (direccion.getNumero() <= 0) {
            mensaje = "El numero de direccion de domicilio es 0 o menor\n";
        }
        if (direccion.getCalle() == null || direccion.getCalle().isEmpty()) {
            mensaje += "La calle de direccion es nula o vacia\n";
        }
        if (direccion.getCodigoPostal() == null || direccion.getCodigoPostal().isEmpty() || !validarCodigoPostal(direccion.getCodigoPostal())) {
            mensaje += "El codigo postal de direccion es nulo, vacio o invalido\n";
        }
        if (direccion.getCiudad() == null || direccion.getCiudad().isEmpty()) {
            mensaje += "La ciudad de direccion es nula o vacia\n";
        }
        if (direccion.getProvincia() == null || direccion.getProvincia().isEmpty()) {
            mensaje += "La provincia de direccion es nula o vacia";
        }
        if (!mensaje.isEmpty()) {
            throw new DireccionException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar
     * @param direccion direccion a insertar
     * @throws DireccionException error controlado
     * @throws PersistenciaException error controlado
     */
    public void insertar(Direccion direccion) throws DireccionException, PersistenciaException {
        validarDireccion(direccion);
        if (existe(direccion)) {
            throw new DireccionException("La direccion indicada ya existe");
        }
        direccionModelo.insertar(direccion);
    }

    /**
     * Metodo encargado de eliminar
     * @param direccion direccion a eliminar
     * @throws DireccionException error controlado
     * @throws PersistenciaException error controlado
     */
    public void eliminar(Direccion direccion) throws DireccionException, PersistenciaException {
        validarDireccion(direccion);
        if (!existe(direccion)) {
            throw new DireccionException("La direccion indicada no existe");
        }
        direccionModelo.eliminar(direccion);
    }

    /**
     * Metodo encargado de eliminar utilizando el identificador de la direccion
     * @param identificador identificadorde la direccion
     * @throws DireccionException error controlado
     * @throws PersistenciaException error controlado
     */
    public void eliminar(String identificador) throws  DireccionException, PersistenciaException {
        Direccion direccion;
        direccion = buscar(identificador);
        eliminar(direccion);
    }

    /**
     * Metodo encargado de modificar
     * @param direccion direccion a modificar
     * @throws DireccionException error controlado
     * @throws PersistenciaException error controlado
     */
    public void modificar(Direccion direccion) throws DireccionException, PersistenciaException {
        Direccion direccionAlmacenada;
        validarDireccion(direccion);
        direccionAlmacenada = buscar(direccion.getIdentificador());
        if (direccionAlmacenada == null) {
            throw new DireccionException("La direccion indicada no existe");
        }
        direccionModelo.modificar(direccion);
    }

    /**
     * Metodo encargado de buscar por identificador de la direccion
     * @param identificador identificadorde la direccion
     * @return Direccion encontrada
     * @throws PersistenciaException error controlado
     */
    public Direccion buscar(String identificador) throws PersistenciaException  {
        Direccion direccion = null;
        direccion = direccionModelo.buscar(identificador);
        return direccion;
    }

    /**
     * Funcion encargada de verificar si existe o no una direccion
     * @param direccion direccion a encontrar
     * @return true/false si existe o no
     * @throws PersistenciaException error controlado
     */
    public boolean existe(Direccion direccion) throws PersistenciaException {
        boolean encontrado = false;
        Direccion direccionEncontrada;

        direccionEncontrada = buscar(direccion.getIdentificador());
        if (direccionEncontrada != null) {
            encontrado = true;
        }

        return encontrado;
    }
}
