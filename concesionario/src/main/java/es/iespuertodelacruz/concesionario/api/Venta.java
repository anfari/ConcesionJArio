package es.iespuertodelacruz.concesionario.api;

/**
 * Clase Venta
 */
public class Venta {
    String identificador;
    String codigoEmpleado;
    String codigoCliente;
    String bastidor;


    /**
     * Constructor vacio de la clase Venta
     */
    public Venta() {
    }

    /**
     * Constructor de la clase Venta
     * @param codigoEmpleado codigo del empleado que realiza la venta
     * @param codigoCliente codigo del cliente que realiza la compra
     * @param bastidor numero de bastidor del vehiculo vendido
     * @param identificador identificador de venta
     */
    public Venta(String identificador,String codigoEmpleado, String codigoCliente, String bastidor) {
        this.codigoEmpleado = codigoEmpleado;
        this.codigoCliente = codigoCliente;
        this.bastidor = bastidor;
        this.identificador=identificador;
    }


    /**
     * Getter de la clase Venta
     * @return identificador del empleado
     */
    public String getIdentificador() {
        return this.identificador;
    }
    /**
     * Setter de la clase Venta
     * @param identificador identificador del empleado
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

     /**
     * Getter de la clase Venta
     * @return codigo del empleado
     */
    public String getCodigoEmpleado() {
        return this.codigoEmpleado;
    }

    /**
     * Setter de la clase Venta
     * @param codigoEmpleado codigo del empleado
     */
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
    
    /**
     * Getter de la clase Venta
     * @return codigo del cliente
     */
    public String getCodigoCliente() {
        return this.codigoCliente;
    }
    
     /**
     * Setter de la clase Venta
     * @param codigoCliente codigo del cliente
     */
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * Getter de la clase Venta
     * @return numero de bastidor del vehiculo
     */
    public String getBastidor() {
        return this.bastidor;
    }

    /**
     * Setter de la clase Venta
     * @param bastidor numero de bastidor del vehiculo
     */
    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }


    /**
     * Funcion toString de la clase Venta
     */
    @Override
    public String toString() {
        return getIdentificador() + "," +getCodigoEmpleado() + "," +
            getCodigoCliente() + "," +getBastidor();
    }


}
