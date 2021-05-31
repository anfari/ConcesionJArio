package es.iespuertodelacruz.concesionario.api;
/**
 * Clase vehiculo contiene las caracteristicas de un vehiculo
 */
public class Vehiculo {
    String bastidor;
    String matricula;
    String marca;
    String modelo;
    String color;
    double precio;
    String extrasInstalados;
    String motor;
    int potencia;
    String cilindrada;
    String tipo;
    String estado;

    /**
     * Constructor por defecto
     */
    public Vehiculo() {
    }

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
     * @param tipo tipo de vehiculo
     * @param estado estado de disponibilidad del vehiculo
     */
    public Vehiculo(String bastidor, String matricula, String marca, 
    String modelo, String color, double precio, String extrasInstalados, 
    String motor, int potencia, String cilindrada, String tipo, String estado) {
        this.bastidor = bastidor;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.extrasInstalados = extrasInstalados;
        this.motor = motor;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.tipo=tipo;
        this.estado=estado;
    }
     /**
     * Getter de la clase Vehiculo
     * @return estado del vehiculo
     */
    public String getEstado() {
        return this.estado;
    }
    /**
     * Setter de la clase Vehiculo
     * @param estado del vehiculo
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    /**
     * Getter de la clase Vehiculo
     * @return numero de bastidor del vehiculo
     */
    public String getBastidor() {
        return this.bastidor;
    }

    /**
     * Setter de la clase Vehiculo
     * @param bastidor numero de bastidor del vehiculo
     */
    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    /**
     * Getter de la clase Vehiculo
     * @return matricula del vehiculo
     */
    public String getMatricula() {
        return this.matricula;
    }

    /**
     * Setter de la clase Vehiculo
     * @param matricula matricula del vehiculo
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter de la clase Vehiculo
     * @return marca del vehiculo
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * Setter de la clase Vehiculo
     * @param marca marca del vehiculo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Getter de la clase Vehiculo
     * @return modelo del vehiculo
     */
    public String getModelo() {
        return this.modelo;
    }

    /**
     * Setter de la clase Vehiculo
     * @param modelo modelo del vehiculo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter de la clase Vehiculo
     * @return color del vehiculo
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Setter de la clase Vehiculo
     * @param color color del vehiculo
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter de la clase Vehiculo
     * @return precio del vehiculo
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Setter de la clase Vehiculo
     * @param precio precio del vehiculo
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Getter de la clase Vehiculo
     * @return extras del vehiculo
     */
    public String getExtrasInstalados() {
        return this.extrasInstalados;
    }

    /**
     * Setter de la clase Vehiculo
     * @param extrasInstalados extras del vehiculo
     */
    public void setExtrasInstalados(String extrasInstalados) {
        this.extrasInstalados = extrasInstalados;
    }

    /**
     * Getter de la clase Vehiculo
     * @return motor del vehiculo
     */
    public String getMotor() {
        return this.motor;
    }

    /**
     * Setter de la clase Vehiculo
     * @param motor motor del vehiculo
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }

    /**
     * Getter de la clase Vehiculo
     * @return potencia del vehiculo
     */
    public int getPotencia() {
        return this.potencia;
    }

    /**
     * Setter de la clase Vehiculo
     * @param potencia potencia del vehiculo
     */
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    /**
     * Getter de la clase Vehiculo
     * @return cilindrada del vehiculo
     */
    public String getCilindrada() {
        return this.cilindrada;
    }

    /**
     * Setter de la clase Vehiculo
     * @param cilindrada cilindrada del vehiculo
     */
    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * Getter de la clase Vehiculo
     * @return tipo de vehiculo
     */
    public String getTipo() {
        return this.tipo;
    }
    
     /**
     * Setter de la clase Vehiculo
     * @param tipo tipo de vehiculo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Funcion toString de la Clase Vehiculo
     */
    @Override
    public String toString() {
        return getBastidor() + ", " + getMatricula() + ", " + getMarca() + ", " + getModelo() + ", " + getColor() + ", " +
            getPrecio() + "€, Extras:'" + getExtrasInstalados() + ", " + getMotor() + ", " + getPotencia() + " CV, " +
            getCilindrada() + ", " + getTipo() + " " + getEstado();
    }

}
