package es.iespuertodelacruz.concesionario.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.api.Vehiculo;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

public class VehiculoModeloTest {
    VehiculoModelo vehiculoModelo;
    Vehiculo vehiculo;

    @BeforeEach 
    public void setUp(){
        if (vehiculoModelo == null){
            try {
                vehiculoModelo = new VehiculoModelo(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo", e);
            }
        }
        vehiculo = crearVehiculo();
        try {
            vehiculoModelo.insertar(vehiculo);
        } catch (PersistenciaException e) {
            fail("Error al insertar el vehiculo", e);
        }
    }

    @AfterEach 
    public void tearDown(){
        try {
            vehiculoModelo.eliminar(vehiculo);
        } catch (PersistenciaException e) {
            fail("Error al eliminar el vehiculo", e);
        }
    }


    @Test
    public void constructorTest() {
        try {
            vehiculoModelo = new VehiculoModelo();
            vehiculoModelo = new VehiculoModelo(true);
        } catch (PersistenciaException e) {
            fail("Error al inicialziar el modelo");
        }
    }

    @Test
    public void modificarTest() {
        vehiculo.setColor("Blanco");
        try {
            vehiculoModelo.modificar(vehiculo);
        } catch (PersistenciaException e) {
            fail("Error al actualizar el vehiculo", e);
        }
    }
    
    @Test
    public void buscarTest() {
        Vehiculo vehiculoEncontrado = null;
        try {
            vehiculoEncontrado = vehiculoModelo.buscar("VVVZZZ6KZ1R149942");
        } catch (PersistenciaException e) {
            fail("Error al buscar el vehiculo", e);
        }
        assertNotNull(vehiculoEncontrado, "El objeto no deberia ser nulo");
    }

    @Test
    public void buscarEmptyTest() {
        Vehiculo vehiculoEncontrado = null;
        try {
            vehiculoEncontrado = vehiculoModelo.buscar("00000000Z");
        } catch (PersistenciaException e) {
            fail("Error al buscar el vehiculo", e);
        }
        assertNull(vehiculoEncontrado, "El objeto deberia ser nulo");
    }
   
    
    @Test
    public void listadoVehiculosTest() {
        try {
            assertEquals(40, vehiculoModelo.listadoVehiculos().size(), "El tamanio no es el esperado");
        } catch (PersistenciaException e) {
            fail("Error al listar los vehiculos", e);
        }

    }

    @Test
    public void convertirErrorTest() {
        try {
            vehiculoModelo.convertir("error");
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error"), "La consulta no deberia ser posible");
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
