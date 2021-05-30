package es.iespuertodelacruz.concesionario.api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


public class VentaApiTest {
    Venta venta;
    Cliente cliente;
    Empleado empleado;
    Vehiculo vehiculo;

    @BeforeEach 
    public void setUp(){
        if(venta==null){
            venta= generarventa();
        }
    }

    @Test
    public void ConstructorTest() {
        assertNotNull(venta);
    }

    @Test
    public void ListaventaTest() {
        assertTrue(venta.toString().length()>0);
    }

    @Test
    public void gettetSetterVentaTest() {
        venta= crearventa();
        assertTrue(venta.toString().contains(venta.getCodigoCliente()));
    }
  
    
    /**
     * Funcion privada encargada de genrar ventas
     */
    private Venta generarventa(){
        Venta venta= new Venta(null, "22222222R", "11111111E", "111121312AA");
        return venta;
    }

    /**
     * Funcion privada encargada de generar Set de ventas
     * @return
     */
    private Venta crearventa(){ 
        venta= new Venta();
    
        venta.setBastidor("333EER");
        venta.setCodigoCliente("5555J");
        venta.setCodigoEmpleado("88888O");
        venta.setIdentificador(null);
    
        return venta;
    }
}
