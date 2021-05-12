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
     * @return
     */
    public String getDniEmpleado() {
        return this.dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public String getDniCliente() {
        return this.dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getBastidor() {
        return this.bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }


}
