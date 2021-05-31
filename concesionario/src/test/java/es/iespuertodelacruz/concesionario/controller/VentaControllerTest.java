package es.iespuertodelacruz.concesionario.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.api.Venta;
import es.iespuertodelacruz.concesionario.controlador.VentaController;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.exception.VentaException;

public class VentaControllerTest {
    VentaController ventaController;
    Venta venta;

    @BeforeEach 
    public void setUp(){
        if (ventaController == null){
            try {
                ventaController = new VentaController(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo", e);
            }
        }
        venta = crearVenta();
        try {
            ventaController.insertar(venta);
        } catch (PersistenciaException | VentaException e) {
            fail("Error al insertar la venta", e);
        }
    }

    @AfterEach 
    public void tearDown(){
        try {
            ventaController.eliminar(venta.getIdentificador());
        } catch (PersistenciaException | VentaException e) {
            fail("Error al eliminar la venta", e);
        }
        
    }


    @Test
    public void constructorTest() {
        try {
            ventaController = new VentaController();
            ventaController = new VentaController(true);
        } catch (PersistenciaException e) {
            fail("Error al inicialziar el modelo");
        }
    }

    @Test
    public void validarVentaNulaTest() {
        Venta ventaNula = null;

        try {
            ventaController.validarVenta(ventaNula);
        } catch (VentaException e) {
            assertTrue(e.getMessage().contains("Se esta intentando validar un objeto vacio"));
        }

    }

    @Test
    public void validarVentaVaciaTest() {
        Venta ventaVacia = new Venta("", "", "", "");

        try {
            ventaController.validarVenta(ventaVacia);
        } catch (VentaException e) {
            assertTrue(e.getMessage().contains("El bastidor"));
        }

    }

    @Test
    public void validarVentaNullTest() {
        Venta ventaVacia = new Venta(null, null, null, null);

        try {
            ventaController.validarVenta(ventaVacia);
        } catch (VentaException e) {
            assertTrue(e.getMessage().contains("venta"));
        }

    }

    @Test
    public void validarBastidorErrorTest() {
        Venta ventaVacia = new Venta(null, null, null, "1234");

        try {
            ventaController.validarVenta(ventaVacia);
        } catch (VentaException e) {
            assertTrue(e.getMessage().contains("invalido"));
        }

    }

    @Test
    public void insertarErrorTest() {
        try {
            ventaController.insertar(venta);
        } catch (PersistenciaException | VentaException e) {
            assertTrue(e.getMessage().contains("La venta indicada ya existe"));
        }
    }

    @Test
    public void eliminarErrorTest() {
        Venta ventaBorrar = new Venta("44444555G", "999999999999", "999999999999", "VVVZZZ6KZ1R149942");
        try {
            ventaController.eliminar(ventaBorrar);
        } catch (VentaException | PersistenciaException e) {
            assertTrue(e.getMessage().contains("La venta indicada no existe"));
        }
    }

    @Test
    public void eliminarIdentificadorTest() throws PersistenciaException {
        try {
            ventaController.eliminar(venta);
        } catch (PersistenciaException | VentaException e) {
            fail("Error al eliminar la venta", e);
        }
        
    }

    @Test
    public void modificarTest() {
        venta.setCodigoEmpleado("2");
        try {
            ventaController.modificar(venta);
        } catch (PersistenciaException | VentaException e) {
            fail("Error al actualizar la venta", e);
        }
    }

    @Test
    public void modificarErrorTest() {
        Venta ventaModificar = new Venta("555", "14", "14", "VSSZZZ6KZ1R149947");
        try {
            ventaController.modificar(ventaModificar);
        } catch (PersistenciaException | VentaException e) {
            assertTrue(e.getMessage().contains("La venta indicada no existe"));
        }
    }

    @Test
    public void agruparVentasTest() {
        ArrayList<String> ventasAgrupadas = new ArrayList<>();
        try {
            ventasAgrupadas = ventaController.agruparVentas();
        } catch (PersistenciaException e) {
            fail("Error agrupando las ventas");
        }
        assertFalse(ventasAgrupadas.isEmpty(), "La lista no deberia estar vacia");
    }

    




    /**
     * Funcion encargada de crear una venta para test
     * @return venta creada
     */
    private Venta crearVenta() {
        return new Venta("9999999999", "1", "1", "VSSZZZ6KZ1R149947");
    }

}
