package es.iespuertodelacruz.concesionario.modelo;

import es.iespuertodelacruz.concesionario.api.Cliente;

/**
 * Clase CienteModelo 
 */
public class ClienteModelo {
    Bbdd persistencia;

    public ClienteModelo() {
        persistencia = new Bbdd("org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
    }
    /**
     * Metodo que inserta un cliente
     * @param cliente cliente a insertar
     */
    public void insertar(Cliente cliente){
        
    }
     /**
     * Metodo que modifica un cliente
     * @param cliente cliente a modificar
     */
    public void modificar(Cliente cliente){

    }
     /**
     * Metodo que busca un cliente
     * @param cliente cliente a buscar
     */
    public void buscar(Cliente cliente){

    }
     /**
     * Metodo que elimina un cliente
     * @param cliente cliente a eliminar
     */
    public void eliminar(Cliente cliente){

    }
    /**
     * Metodo que verifica si existe o no un cliente
     * @param cliente cliente a verificar 
     * @return true o false
     */
    public boolean existe(Cliente cliente){
        return true;
    }   
}
