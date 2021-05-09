package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Vendedor;
import es.iespuertodelacruz.concesionario.exception.BbddException;
/**
 * Clase VendedorModelo que gestiona los datos de vendedoress
 */
public class VendedorModelo {
    Bbdd persistencia;

    /**
     * Constructor de la Clase VendedorModelo
     */
    public VendedorModelo() {
        persistencia = new Bbdd("org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
    }


    /**
     * Metodo que inserta un vendedor
     * @param vendedor vendedor a insertar
     * @throws BbddException error controlado
     */
    public void insertar(Vendedor vendedor) throws BbddException{
        persistencia.insertarVendedor(vendedor);
    }

     /**
     * Metodo que modifica un vendedor
     * @param vendedor vendedor a modificar
     * @throws BbddException error controlado
     */
    public void modificar(Vendedor vendedor) throws BbddException{
        persistencia.modificarVendedor(vendedor);
    }

     /**
     * Metodo que busca un vendedor
     * @param vendedor vendedor a buscar
     * @throws BbddException error controlado
     */
    public void buscar(Vendedor vendedor) throws BbddException{
        persistencia.obtenerVendedor(vendedor.getCodigoVendedor());
    }

     /**
     * Metodo que elimina un vendedor
     * @param vendedor vendedor a eliminar
     * @throws BbddException error controlado
     */
    public void eliminar(Vendedor vendedor) throws BbddException{
        persistencia.eliminarVendedor(vendedor);
    }
}
