package es.iespuertodelacruz.concesionario.api;

/**
 * Clase Venta
 */
public class Venta {
    String codigoEmpleado;
    String codigoCliente;
    String bastidor;


    /**
     * Constructor de la clase Venta
     * @param codigoEmpleado codigo del empleado que realiza la venta
     * @param codigoCliente codigo del cliente que realiza la compra
     * @param bastidor numero de bastidor del vehiculo vendido
     */
    public Venta(String codigoEmpleado, String codigoCliente, String bastidor) {
        this.codigoEmpleado = codigoEmpleado;
        this.codigoCliente = codigoCliente;
        this.bastidor = bastidor;
    }


     /**
     * Getter de la clase Venta
     * @return dni del empleado
     */
    public String getCodigoEmpleado() {
        return this.codigoEmpleado;
    }

    /**
     * Setter de la clase Venta
     * @param dniEmpleado dni del empleado
     */
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
    
    /**
     * Getter de la clase Venta
     * @return dni del cliente
     */
    public String getCodigoCliente() {
        return this.codigoCliente;
    }
    
     /**
     * Setter de la clase Venta
     * @param dniCliente dni del cliente
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


}
