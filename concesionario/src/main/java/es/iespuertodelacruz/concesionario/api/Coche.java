package es.iespuertodelacruz.concesionario.api;
/**
 * Clase coche que entiende de vehiculo
 */
public class Coche extends Vehiculo{

    /**
     * Constructor con todos los parametros de la clase Vehiculo
     * @param bastidor numero de bastidor del vehiculo
     * @param matricula matricula del vehiculo
     * @param marca marca del vehiculo
     * @param modelo modelo del vehiculo
     * @param color color del vehiculo
     * @param precio precio en euros del vehiculo
     * @param extrasInstalados extras que tiene el vehiculo
     * @param motor tipo de motor del vehiculo
     * @param potencia potencia expresada en CV del vehiculo
     * @param cilindrada cilindrada expresada en CC del vehiculo
     */
    public Coche(String bastidor, String matricula, String marca, String modelo, String color, double precio,
            String extrasInstalados, String motor, int potencia, String cilindrada) {
        super(bastidor, matricula, marca, modelo, color, precio, extrasInstalados, motor, potencia, cilindrada);
    }   
    
    
}
