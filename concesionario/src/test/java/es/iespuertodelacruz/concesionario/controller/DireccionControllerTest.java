package es.iespuertodelacruz.concesionario.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.controlador.DireccionController;
import es.iespuertodelacruz.concesionario.exception.DireccionException;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

public class DireccionControllerTest {
    DireccionController direccionController;
    Direccion direccion;

    @BeforeEach 
    public void setUp() {
        if(direccionController == null){
            try {
                direccionController = new DireccionController(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo");
            }
        }
        direccion = crearDireccion();
        try {
            direccionController.insertar(direccion);
        } catch (PersistenciaException | DireccionException e) {
            fail("Error al insertar la direccion");
        }

    }

    @AfterEach 
    public void tearDown(){
        try {
            direccionController.eliminar(direccion);
        } catch (PersistenciaException | DireccionException e) {
            fail("Error al eliminar la direccion");
        }
    }


    @Test
    public void constructorTest() {
        try {
            direccionController = new DireccionController();
            direccionController = new DireccionController(true);
        } catch (PersistenciaException e) {
            fail("Error al inicialziar el modelo");
        }
    }

    @Test
    public void validarDireccionNulaTest() {
        Direccion direccionNula = null;

        try {
            direccionController.validarDireccion(direccionNula);
        } catch (DireccionException e) {
            assertTrue(e.getMessage().contains("Se esta intentando validar un objeto vacio"));
        }
    }

    @Test
    public void validarDireccionVaciaTest() {
        Direccion direccionVacia = new Direccion("", "", 0, "", "", "", "");

        try {
            direccionController.validarDireccion(direccionVacia);
        } catch (DireccionException e) {
            assertTrue(e.getMessage().contains("direccion"));
        }

    }

    @Test
    public void validarDireccionNulaaTest() {
        Direccion direccionVacia = new Direccion(null, null, 0, null, null, null, null);

        try {
            direccionController.validarDireccion(direccionVacia);
        } catch (DireccionException e) {
            assertTrue(e.getMessage().contains("de direccion"));
        }

    }

    @Test
    public void validarCodigoPostalErrorTest() {
        Direccion direccionVacia = new Direccion(null, null, 0, "12", null, null, null);

        try {
            direccionController.validarDireccion(direccionVacia);
        } catch (DireccionException e) {
            assertTrue(e.getMessage().contains("invalido"));
        }

    }

    @Test
    public void insertarErrorTest() {
        try {
            direccionController.insertar(direccion);
        } catch (PersistenciaException | DireccionException e) {
            assertTrue(e.getMessage().contains("La direccion indicada ya existe"));
        }
    }

    @Test
    public void eliminarErrorTest() {
        Direccion direccionBorrar = new Direccion("25511854H", "calle", 2, "38300", "Madrid", "Madrid", "espana");
        try {
            direccionController.eliminar(direccionBorrar);
        } catch (PersistenciaException | DireccionException e) {
            assertTrue(e.getMessage().contains("La direccion indicada no existe"));
        }
    }

    @Test
    public void eliminarIdentificadorTest() {
        try {
            direccionController.eliminar("22222222A");
        } catch (PersistenciaException | DireccionException e) {
            fail("Error al eliminar la persona", e);
        }
        try {
            direccionController.insertar(direccion);
        } catch (PersistenciaException | DireccionException e) {
            fail("Error al insertar la persona", e);
        }
    }

    @Test
    public void modificarTest() {
        direccion.setCalle("Camino del sol");
        try {
            direccionController.modificar(direccion);
        } catch (PersistenciaException | DireccionException e) {
            fail("Error al actualizar la direccion", e);
        }
    }

    @Test
    public void modificarErrorTest() {
        Direccion direccionModificar = new Direccion("98989898H", "calle", 2, "38300", "Madrid", "Madrid", "espana");
        try {
            direccionController.modificar(direccionModificar);
        } catch (PersistenciaException | DireccionException e) {
            assertTrue(e.getMessage().contains("La direccion indicada no existe"));
        }
    }


    
    /**
     * Funcion encargado de crear una direccion para test
     * @return direccion creada
     */
    private Direccion crearDireccion(){
        return new Direccion("22222222A", "VillaBajo", 2, "38435", "Almeria", "Almeria", "España");
    }

}
