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
    //Aqui van los getter y setter
    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getExtrasInstalados() {
        return this.extrasInstalados;
    }

    public void setExtrasInstalados(String extrasInstalados) {
        this.extrasInstalados = extrasInstalados;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNumeroBastidor() {
        return this.numeroBastidor;
    }

    public void setNumeroBastidor(String numeroBastidor) {
        this.numeroBastidor = numeroBastidor;
    }
    

}
