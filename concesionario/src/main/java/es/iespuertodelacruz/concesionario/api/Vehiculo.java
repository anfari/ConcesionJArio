package es.iespuertodelacruz.concesionario.api;
/**
 * Clase vehiculo contiene las caracteristicas de un vehiculo
 */
public class Vehiculo {
    String matricula;
    String marca;
    String modelo;
    String color;
    double precio;
    String extrasInstalados;
    boolean estado;
    String numeroBastidor;

    /**
     * Contructor de vehiculo con parametros 
     * @param matricula matricula de vehiculo
     * @param marca marca del vehiculo
     * @param modelo modelo del vehiculo
     * @param color color del vehiculo
     * @param precio preciodel vehiculo
     * @param extrasInstalados extras instalados del vehiculo
     * @param estado estado del vehiculo
     * @param numeroBastidor numero de bastidor del vehiculo
     */
    public Vehiculo(String matricula, String marca, String modelo, 
    String color, double precio, String extrasInstalados, boolean estado,
    String numeroBastidor) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.extrasInstalados = extrasInstalados;
        this.estado = estado;
        this.numeroBastidor=numeroBastidor;
    }

}
