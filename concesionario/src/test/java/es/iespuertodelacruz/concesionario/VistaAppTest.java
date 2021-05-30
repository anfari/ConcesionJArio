package es.iespuertodelacruz.concesionario;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
/**
 * 
 */

import es.iespuertodelacruz.concesionario.controlador.ClienteController;
import es.iespuertodelacruz.concesionario.controlador.DireccionController;
import es.iespuertodelacruz.concesionario.controlador.EmpleadoController;
import es.iespuertodelacruz.concesionario.controlador.PersonaController;
import es.iespuertodelacruz.concesionario.controlador.VehiculoController;
import es.iespuertodelacruz.concesionario.controlador.VentaController;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.vista.VistaApp;
public class VistaAppTest {
    VistaApp vista;
    ClienteController clienteController;
    EmpleadoController empleadoController;
    VehiculoController vehiculoController;
    PersonaController personaController;
    DireccionController direccionController;
    VentaController ventaController;
     @BeforeEach 
    public void setUp() throws PersistenciaException{
        if(vista==null){
            try {
                vista=new VistaApp();
            } catch (PersistenciaException e) {
                fail("Error en la inicializacion de la vista");
            }
        clienteController = new ClienteController();
        empleadoController = new EmpleadoController();
        vehiculoController = new VehiculoController();
        personaController = new PersonaController();
        direccionController = new DireccionController();
        ventaController= new VentaController();
        }
    }
     @AfterEach 
    public void tearDown(){}
    
    public void pruebaTest(){
        assertTrue(true);
    }
}
