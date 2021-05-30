package es.iespuertodelacruz.concesionario.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;


public class BbddTest {
    Bbdd bbdd;
    Cliente cliente;

    @BeforeEach 
    public void setUp(){
        if(bbdd == null){
            try {
                bbdd = new Bbdd("Cliente", "dni", "org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
            } catch (PersistenciaException e) {
                fail("Error al inicializar la BBDD", e);
            }
        }
    }
    
    @AfterEach
    public void afterEach() {
        try {
            bbdd.actualizar("DROP TABLE Cliente");
        } catch (PersistenciaException e) {
            fail("Error al eliminar la tabla");
        }
    }

    @Test
    public void initErrorTest() {
        try {
            bbdd = new Bbdd("error", null, "org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error en la inicializacion"));
        }
    }

    @Test
    public void getConnectionErrorTest() {
        try {
            bbdd = new Bbdd("Persona", "" , "", "jdbc:sqlite:test.db", null, null);
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error en la inicializacion"));
        }
    }

    @Test
    public void getConnectionUsuarioErrorTest() {
        try {
            bbdd = new Bbdd("Persona", "dni", "org.sqlite.JDBC", "jdbc:sqlite:test.db", "asdf", "asdf");
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error en la inicializacion"));
        }
    }

    @Test
    public void actualizarErrorTest() {
        try {
            bbdd.actualizar("error");
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error realizando la consulta"), "La consulta deberia dar error");
        }
    }


    @Test
    public void getConnectionUsuarioError2Test() {
        try {
            bbdd = new Bbdd(null, null ,null, null, null, null);
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error en la inicializacion"));
        }
    }

    
}
