package es.iespuertodelacruz.concesionario.api;
/**
 * Clase direccion que contiene la direccion de una persona
 */
public class Direccion {
    String calle;
    int numero;
    String codigoPostal;
    String provincia;
    String poblacion;

    /**
     * Constructor de direccion con parametros
     * @param calle nombre de la calle 
     * @param numero numeo de la casa
     * @param codigoPostal codigo postal 
     * @param provincia provincia de residencia
     * @param poblacion poblacion de residencia
     */
    public Direccion(String calle, int numero, String codigoPostal, 
    String provincia, String poblacion) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.poblacion = poblacion;
    }

    
}
