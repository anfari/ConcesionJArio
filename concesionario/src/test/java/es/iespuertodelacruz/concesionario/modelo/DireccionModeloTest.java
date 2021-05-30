package es.iespuertodelacruz.concesionario.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

public class DireccionModeloTest {
    DireccionModelo direccionModelo;
    Direccion direccion;

    @BeforeEach 
    public void setUp() {
        if(direccionModelo == null){
            try {
                direccionModelo = new DireccionModelo(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo");
            }
        }
        direccion = crearDireccion();
        try {
            direccionModelo.insertar(direccion);
        } catch (PersistenciaException e) {
            fail("Error al insertar la direccion");
        }

    }

    @AfterEach 
    public void tearDown(){
        try {
            direccionModelo.eliminar(direccion);
        } catch (PersistenciaException e) {
            fail("Error al eliminar la direccion");
        }
    }

    
    @Test
    public void modificarTest() {
        direccion.setCalle("Benito Perez");
        try {
            direccionModelo.modificar(direccion);
        } catch (PersistenciaException e) {
            fail("Error al modificar la direccion", e);
        }
    }

    @Test
    public void listadoDireccionesTest() {
        try {
            assertEquals(21, direccionModelo.listadoDirecciones().size(), "El tamanio no es el esperado");
        } catch (PersistenciaException e) {
            fail("Error al listar las direcciones", e);
        }
    }

    @Test
    public void buscarEmptyTest() {
        Direccion direccionEncontrada = null;
        try {
            direccionEncontrada = direccionModelo.buscar("55555555X");
        } catch (PersistenciaException e) {
            fail("Error al buscar la direccion", e);
        }
        assertNull(direccionEncontrada, "El objeto deberia ser nulo");
    }

    @Test
    public void convertirErrorTest() {
        try {
            direccionModelo.convertir("error");
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error"), "La consulta no deberia ser posible");
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
