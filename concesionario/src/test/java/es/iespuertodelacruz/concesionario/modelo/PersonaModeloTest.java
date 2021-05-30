package es.iespuertodelacruz.concesionario.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

public class PersonaModeloTest {
    PersonaModelo personaModelo;
    DireccionModelo direccionModelo;
    Persona persona;
    Direccion direccion;

    @BeforeEach 
    public void setUp(){
        if (personaModelo == null){
            try {
                personaModelo = new PersonaModelo(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo", e);
            }
        }
        if (direccionModelo == null){
            try {
                direccionModelo = new DireccionModelo(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo", e);
            }
        }
        persona = crearPersona();
        try {
            personaModelo.insertar(persona);
        } catch (PersistenciaException e) {
            fail("Error al insertar la persona", e);
        }
        direccion = crearDireccion();
        try {
            direccionModelo.insertar(direccion);
        } catch (PersistenciaException e) {
            fail("Error al insertar la direccion", e);
        }
    }

    @AfterEach 
    public void tearDown(){
        try {
            personaModelo.eliminar(persona);
        } catch (PersistenciaException e) {
            fail("Error al eliminar la persona", e);
        }
        try {
            direccionModelo.eliminar(direccion);
        } catch (PersistenciaException e) {
            fail("Error al eliminar la direccion", e);
        }
    }


    @Test
    public void modificarTest() {
        persona.setNombre("Benito Perez");
        try {
            personaModelo.modificar(persona);
        } catch (PersistenciaException e) {
            fail("Error al actualizar la persona", e);
        }
    }

    @Test
    public void listadoPersonasTest() {
        try {
            assertEquals(21, personaModelo.listadoPersonas().size(), "El tamanio no es el esperado");
        } catch (PersistenciaException e) {
            fail("Error al listar las personas", e);
        }

    }

    @Test
    public void buscarEmptyTest() {
        Persona personaEncontrada = null;
        try {
            personaEncontrada = personaModelo.buscar("100");
        } catch (PersistenciaException e) {
            fail("Error al buscar la persona", e);
        }
        assertNull(personaEncontrada, "El objeto deberia ser nulo");
    }

    @Test
    public void convertirErrorTest() {
        try {
            personaModelo.convertir("error");
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error"), "La consulta no deberia ser posible");
        }
    }



    /**
     * Funcion encargado de crear una persona para test
     * @return persona creada
     */
    private Persona crearPersona() {
        return new Persona("Juan", "Perez", "55555555H", "15/05/1992", "123456789", crearDireccion());
    }

    /**
     * Funcion encargado de crear una direccion para test
     * @return direccion creada
     */
    private Direccion crearDireccion() {
        return new Direccion("55555555H", "Camino Dia", 3, "38400", "Santa Cruz de Tenerife", "Puerto de la Cruz", "Espana");
    }

}
