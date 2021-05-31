package es.iespuertodelacruz.concesionario.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.api.Vehiculo;
import es.iespuertodelacruz.concesionario.controlador.VehiculoController;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.exception.VehiculoException;

public class VehiculoControllerTest {
    VehiculoController vehiculoController;
    Vehiculo vehiculo;

    @BeforeEach 
    public void setUp(){
        if (vehiculoController == null){
            try {
                vehiculoController = new VehiculoController(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo", e);
            }
        }
        vehiculo = crearVehiculo();
        try {
            vehiculoController.insertar(vehiculo);
        } catch (PersistenciaException | VehiculoException e) {
            fail("Error al insertar el vehiculo", e);
        }
    }

    @AfterEach 
    public void tearDown(){
        try {
            vehiculoController.eliminar(vehiculo);
        } catch (PersistenciaException | VehiculoException e) {
            fail("Error al eliminar el vehiculo", e);
        }
    }


    @Test
    public void constructorTest() {
        try {
            vehiculoController = new VehiculoController();
            vehiculoController = new VehiculoController(true);
        } catch (PersistenciaException e) {
            fail("Error al inicialziar el modelo");
        }
    }

    @Test
    public void validarVehiculoNuloTest() {
        Vehiculo vehiculoNulo = null;

        try {
            vehiculoController.validarVehiculo(vehiculoNulo);
        } catch (VehiculoException e) {
            assertTrue(e.getMessage().contains("Se esta intentando validar un objeto vacio"));
        }
    }
    @Test
    public void validarEnterosTest(){
        Vehiculo vehiculo= new Vehiculo("", "", "", "", "", 0, "", "", 0, "", "", "");
        try {
            vehiculoController.validarVehiculo(vehiculo);
        } catch (VehiculoException e) {
            assertTrue(e.getMessage().contains("del vehiculo"));
        }
    }
    @Test
    public void validarStringTest(){
        Vehiculo vehiculo= new Vehiculo(null, null, null, null, null, 0, null, null, 0, null, null, null);
        try {
            vehiculoController.validarVehiculo(vehiculo);
        } catch (VehiculoException e) {
            assertTrue(e.getMessage().contains("del vehiculo"));
        }
    }

    @Test
    public void validarBastidorErrorTest(){
        Vehiculo vehiculo = new Vehiculo("123456789", null, null, null, null, 0, null, null, 0, null, null, null);
        try {
            vehiculoController.validarVehiculo(vehiculo);
        } catch (VehiculoException e) {
            assertTrue(e.getMessage().contains("invalido"));
        }
    }
    
    @Test
    public void insertarErrorTest() {
        try {
            vehiculoController.insertar(vehiculo);
        } catch (PersistenciaException | VehiculoException e) {
            assertTrue(e.getMessage().contains("El vehiculo indicado ya existe"));
        }
    }

    @Test
    public void eliminarErrorTest() {
        Vehiculo vehiculoBorrar = new Vehiculo("VVVCZZ6KZ1R149942", null, "Fiat", "panda", "rojo", 15000, "", "Gasolina", 95, "1400cc", "Coche", "disponible");
        try {
            vehiculoController.eliminar(vehiculoBorrar);
        } catch (PersistenciaException | VehiculoException e) {
            assertTrue(e.getMessage().contains("El vehiculo indicado no existe"));
        }
    }

    @Test
    public void eliminarBastidorTest() {
        try {
            vehiculoController.eliminar("VVVZZZ6KZ1R149942");
        } catch (PersistenciaException | VehiculoException e) {
            fail("Error al eliminar el vehiculo", e);
        }
        try {
            vehiculoController.insertar(vehiculo);
        } catch (PersistenciaException | VehiculoException e) {
            fail("Error al insertar el vehiculo", e);
        }
    }

    @Test
    public void modificarTest() {
        vehiculo.setColor("Amarillo");
        try {
            vehiculoController.modificar(vehiculo);
        } catch (PersistenciaException | VehiculoException e) {
            fail("Error al actualizar el vehiculo", e);
        }
    }

    @Test
    public void modificarErrorTest() {
        Vehiculo vehiculoModificar = new Vehiculo("ZZZCZZ6KZ1R149942", null, "Fiat", "panda", "rojo", 15000, "", "Gasolina", 95, "1400cc", "Coche", "disponible");
        try {
            vehiculoController.modificar(vehiculoModificar);
        } catch (PersistenciaException | VehiculoException e) {
            assertTrue(e.getMessage().contains("El vehiculo indicado no existe"));
        }
    }

    @Test
    public void listadoVehiculosTest() {
        try {
            assertEquals(40, vehiculoController.listadoVehiculos().size(), "El tamanio no es el esperado");
        } catch (PersistenciaException e) {
            fail("Error al listar los vehiculos", e);
        }
    }
    
    

    /**
     * Funcion encargado de crear un vehiculo para test
     * @return vehiculo creado
     */
    private Vehiculo crearVehiculo() {
        return new Vehiculo("VVVZZZ6KZ1R149942", null, "Ford", "Fiesta", "Azul", 19000, null, "Gasolina", 120, "1600cc", "Coche", "Disponible");
    }
    
}
