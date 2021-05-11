package es.iespuertodelacruz.concesionario.api;
/**
 * Clase direccion que contiene la direccion de una persona
 */
public class Direccion {
    String identificador;
    String calle;
    int numero;
    String codigoPostal;
    String provincia;
    String poblacion;

    /**
     * Constructor de direccion con parametros
     * @param identificador identificador de la direccion
     * @param calle nombre de la calle 
     * @param numero numeo de la casa
     * @param codigoPostal codigo postal 
     * @param provincia provincia de residencia
     * @param poblacion poblacion de residencia
     */
    public Direccion(String identificador, String calle, int numero, String codigoPostal, 
    String provincia, String poblacion) {
        this.identificador = identificador;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.poblacion = poblacion;
    }

   
    /**
     * Getter de la clase Direccion
     * @return identificador de la direccion
     */
    public String getIdentificador() {
        return this.identificador;
    }

    /**
     * Setter de la clase Direccion
     * @param identificador identificador de la direccion
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * Getter de la clase Direccion
     * @return nombre de la calle
     */
    public String getCalle() {
        return this.calle;
    }

    /**
     * Setter de la clase Direccion
     * @param calle nombre de la calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Getter de la clase Direccion
     * @return numero de la casa
     */
    public int getNumero() {
        return this.numero;
    }

     /**
     * Setter de la clase Direccion
     * @param numero numero de la casa
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Getter de la clase Direccion
     * @return codigo postal de la calle
     */
    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    /**
     * Setter de la clase Direccion
     * @param codigoPostal codigo postal de la calle
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Getter de la clase Direccion
     * @return provincia del cliente
     */
    public String getProvincia() {
        return this.provincia;
    }

    /**
     * setter de la clase Direccion
     * @param provincia del cliente
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * getter de la clase Direccion
     * @return  poblacion 
     */
    public String getPoblacion() {
        return this.poblacion;
    }

    /**
     * setter de la clase Direccion
     * @param poblacion nombre
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }


    
}
