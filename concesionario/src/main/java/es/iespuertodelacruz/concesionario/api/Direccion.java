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
    //Aqui van los getter y setter
    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPoblacion() {
        return this.poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }


    
}
