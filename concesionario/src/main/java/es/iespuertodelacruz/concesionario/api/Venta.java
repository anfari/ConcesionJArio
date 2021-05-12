package es.iespuertodelacruz.concesionario.api;

/**
 * Clase Venta
 */
public class Venta {
    String dniEmpleado;
    String dniCliente;
    String bastidor;


    /**
     * Constructor de la clase Venta
     * @param dniEmpleado dni del empleado que realiza la venta
     * @param dniCliente dni del cliente que realiza la compra
     * @param bastidor numero de bastidor del vehiculo vendido
     */
    public Venta(String dniEmpleado, String dniCliente, String bastidor) {
        this.dniEmpleado = dniEmpleado;
        this.dniCliente = dniCliente;
        this.bastidor = bastidor;
    }


    /**
     * Getter de la clase Venta
     * @return dni del empleado
     */
    public String getDniEmpleado() {
        return this.dniEmpleado;
    }

    /**
     * Setter de la clase Venta
     * @param dniEmpleado dni del empleado
     */
    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    /**
     * Getter de la clase Venta
     * @return dni del cliente
     */
    public String getDniCliente() {
        return this.dniCliente;
    }

    /**
     * Setter de la clase Venta
     * @param dniCliente dni del cliente
     */
    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
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
