package es.iespuertodelacruz.concesionario.api;
/**
 * Clase coche que entiende de vehiculo
 */
public class Coche extends Vehiculo{

    
    /**
     * Constructor de coche con parametros
     * @param matricula matricula de vehiculo
     * @param marca marca del vehiculo
     * @param modelo modelo del vehiculo
     * @param color color del vehiculo
     * @param precio preciodel vehiculo
     * @param extrasInstalados extras instalados del vehiculo
     * @param estado estado del vehiculo
     */
    public Coche(String matricula, String marca, String modelo, String color, double precio, String extrasInstalados,
            boolean estado) {
        super(matricula, marca, modelo, color, precio, extrasInstalados, estado);
        
    }
    
}
