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
    String ciudad;
    String pais;

    /**
     * Constructor por defecto
     */
    public Direccion() {
    }
    
    /**
     * Constructor de direccion con parametros
     * @param identificador identificador de la direccion
     * @param calle nombre de la calle 
     * @param numero numeo de la casa
     * @param codigoPostal codigo postal 
     * @param provincia provincia de residencia
     * @param ciudad ciudad de residencia
     * @param pais pais de residencia
     */
    public Direccion(String identificador, String calle, int numero, String codigoPostal, 
    String provincia, String ciudad, String pais) {
        this.identificador = identificador;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.pais = pais;
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
     * Setter de la clase Direccion
     * @param provincia provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Getter de la clase Direccion
     * @return cuidad
     */
    public String getCiudad() {
        return this.ciudad;
    }

    /**
     * Setter de la clase Direccion
     * @param ciudad ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Getter de la clase Direccion
     * @return pais
     */
    public String getPais() {
        return this.pais;
    }

    /**
     * Setter de la clase Direccion
     * @param pais pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }


    /**
     * Funcion toString de la clase Direccion
     */
    @Override
    public String toString() {
        return getCalle() + " " + getNumero() + ", " + getCiudad() + 
        ", " + getProvincia() + ", " + getPais() + ", " + getCodigoPostal()+ getIdentificador();
    }

    
}
