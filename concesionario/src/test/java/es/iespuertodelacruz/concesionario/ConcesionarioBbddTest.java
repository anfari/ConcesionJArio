package es.iespuertodelacruz.concesionario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.modelo.Bbdd2;


public class ConcesionarioBbddTest {
    Bbdd2 bbdd2;
    Cliente cliente;
     @BeforeEach 
    public void setUp(){
    if(bbdd2==null){
        try {
            bbdd2= new Bbdd2("Cliente", "dni", "org.sqlite.JDBC", "jdbc:sqlite:concesionjario.db",null, null);
        } catch (PersistenciaException e) {
            fail("Error al inicializar la BD");
        }

    }
    }
    
    @AfterEach
    public void afterEach() {
        try {
            bbdd2.actualizar("DROP TABLE Cliente");
        } catch (PersistenciaException e) {
            fail("Error al eliminar la tabla");
        }
    }

    @Test
    public void initErrorTest() {
        try {
            bbdd2 = new Bbdd2("error", null,"org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error en la inicializacion"));
        }
    }

    @Test
    public void getConnectionErrorTest() {
        try {
            bbdd2 = new Bbdd2("Persona"," " ,"", "jdbc:sqlite:test.db", null, null);
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error en la inicializacion"));
        }
    }

    @Test
    public void actualizarErrorTest() {
        try {
            bbdd2.actualizar("error");
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error realizando la consulta"), "La consulta deberia dar error");
        }
    }

    @Test
    public void obtenerListadoPersonasTest() {
        try {
            assertEquals(1, bbdd2.obtenerListadoClientes().size(), "La lista deberia estar vacia");
        } catch (PersistenciaException e) {
            fail("Error al obtener la lista de personas", e);
        }
    }

    @Test
    public void obtenerListadoPersonasErrorTest() {
        try {
            bbdd2.obtenerListadoPersonas("error");
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error realizando la consulta"), "La consulta deberia dar error");
        }
    }

    @Test
    public void obtenerPersonaTest() {
        insertarCliente();
        try {
            assertNotNull(bbdd2.obtenerCliente("34212345R"), "Error al buscar una persona");
        } catch (PersistenciaException e) {
            fail("Error al obtener una persona", e);
        }
    }

    @Test
    public void obtenerPersonaNulaTest() {
        insertarCliente();
        try {
            assertNull(bbdd2.obtenerPersona("null"), "Error al buscar una persona");
        } catch (PersistenciaException e) {
            fail("Error al obtener una persona", e);
        }
    }


    /**
     * Metodo que inserta una persona en la bbdd2
     */
    private void insertarCliente() {
        try {
            bbdd2.actualizar("INSERT INTO Cliente (codigoCliente, dni) VALUES (null, '11111111A')");
        } catch (PersistenciaException e) {
            fail("Error al insertar la persona", e);
        }
    }
    
}
