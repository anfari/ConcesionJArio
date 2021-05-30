package es.iespuertodelacruz.concesionario.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.api.Venta;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

public class VentaModeloTest {
    VentaModelo ventaModelo;
    Venta venta;

    @BeforeEach 
    public void setUp(){
        if (ventaModelo == null){
            try {
                ventaModelo = new VentaModelo(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo", e);
            }
        }
        venta = crearVenta();
        try {
            ventaModelo.insertar(venta);
        } catch (PersistenciaException e) {
            fail("Error al insertar la venta", e);
        }
    }

    @AfterEach 
    public void tearDown(){
        try {
            ventaModelo.eliminar(venta);
        } catch (PersistenciaException e) {
            fail("Error al eliminar la venta", e);
        }
    }


    @Test
    public void constructorTest() {
        try {
            ventaModelo = new VentaModelo();
            ventaModelo = new VentaModelo(true);
        } catch (PersistenciaException e) {
            fail("Error al inicialziar el modelo");
        }
    }

    @Test
    public void modificarTest() {
        venta.setCodigoEmpleado("2");
        try {
            ventaModelo.modificar(venta);
        } catch (PersistenciaException e) {
            fail("Error al actualizar la venta", e);
        }
    }
    
    @Test
    public void buscarTest() {
        Venta ventaEncontrada = null;
        try {
            ventaEncontrada = ventaModelo.buscar("1");
        } catch (PersistenciaException e) {
            fail("Error al buscar la venta", e);
        }
        assertNotNull(ventaEncontrada, "El objeto no deberia ser nulo");
    }

    @Test
    public void buscarEmptyTest() {
        Venta ventaEncontrada = null;
        try {
            ventaEncontrada = ventaModelo.buscar("100");
        } catch (PersistenciaException e) {
            fail("Error al buscar la venta", e);
        }
        assertNull(ventaEncontrada, "El objeto deberia ser nulo");
    }
   
    
    @Test
    public void listadoVentasTest() {
        try {
            assertEquals(7, ventaModelo.listadoVentas().size(), "El tamanio no es el esperado");
        } catch (PersistenciaException e) {
            fail("Error al listar las ventas", e);
        }
    }

    @Test
    public void covnertirErrorTest() {
        try {
            ventaModelo.convertir("error");
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error"), "La consulta no deberia ser posible");
        }
    }

    @Test
    public void agruparVentasTest() {
        ArrayList<String> ventasAgrupadas = new ArrayList<>();
        try {
            ventasAgrupadas = ventaModelo.agruparVentas();
        } catch (PersistenciaException e) {
            fail("Error agrupando las ventas");
        }
        assertFalse(ventasAgrupadas.isEmpty(), "La lista no deberia estar vacia");
    }
    @Test
    public void agruparVentasFalseTest() throws PersistenciaException{
        
        try {
            ventaModelo.agruparVentas();
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("error realizando la consulta"));
        }
        //assertFalse(ventasAgrupadas.isEmpty(), "La lista no deberia estar vacia");
    }


    /**
     * Funcion encargada de crear una venta para test
     * @return venta creada
     */
    private Venta crearVenta() {
        return new Venta("9999999999999", "1", "1", "VSSZZZ6KZ1R149947");
    }
}
