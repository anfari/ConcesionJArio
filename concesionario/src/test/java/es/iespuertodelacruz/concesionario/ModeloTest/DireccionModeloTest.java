package es.iespuertodelacruz.concesionario.ModeloTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.modelo.DireccionModelo;

public class DireccionModeloTest {
    DireccionModelo direccionModelo;
    Direccion direccion;
     @BeforeEach 
    public void setUp(){
        if(direccionModelo==null){
            try {
                direccionModelo=new DireccionModelo(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo");
            }
        }
        direccion=generarDireccion();
        
        try {
            direccionModelo.insertar(direccion);
        } catch (PersistenciaException e) {
            fail("Error al insertar una direccion");
        }

    }
     @AfterEach 
    public void tearDown(){
        try {
            direccionModelo.eliminar(direccion);
        } catch (PersistenciaException e) {
            fail("Error al eliminar");
        }
    }
    @Test
    public void constructorTest() {
        try {
            direccionModelo= new DireccionModelo();
            direccionModelo = new DireccionModelo(true);
        } catch (PersistenciaException e) {
            fail("Error al inicializar el modelo");
        }
    }
    
    @Test
    public void modificarTest() {
        direccion.setCalle("Benito Perez");
        try {
            direccionModelo.modificar(direccion);
        } catch (PersistenciaException e) {
            fail("Error al actualizar la cliente", e);
        }
    }

    @Test
    public void buscarTest() {

        
        try {
            assertTrue(direccionModelo.listadoDirecciones().size()>0);
        } catch (PersistenciaException e) {
            fail("Error");
        }
       
    }

       /**
     * Funcion privada encargada de generar direcciones de personas
     */
    private Direccion generarDireccion(){
        Direccion direccion= new Direccion("22222222A", "VillaBajo", 2, "38435", "Almeria", "Almeria", "España");
        return direccion;
    }
   
    



}
