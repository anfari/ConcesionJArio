package es.iespuertodelacruz.concesionario.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.controlador.PersonaController;
import es.iespuertodelacruz.concesionario.exception.DireccionException;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.exception.PersonaException;

public class PersonaControllerTest {
    PersonaController personaController;
    Persona persona;
    Direccion direccion;

    @BeforeEach 
    public void setUp(){
        if (personaController == null){
            try {
                personaController = new PersonaController(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo", e);
            }
        }
        persona = crearPersona();
        try {
            personaController.insertar(persona);
        } catch (PersistenciaException | PersonaException | DireccionException e) {
            fail("Error al insertar la persona", e);
        }
    }

    @AfterEach 
    public void tearDown(){
        try {
            personaController.eliminar(persona);
        } catch (PersistenciaException | PersonaException | DireccionException e) {
            fail("Error al eliminar la persona", e);
        }
    }


    @Test
    public void constructorTest() {
        try {
            personaController = new PersonaController();
            personaController = new PersonaController(true);
        } catch (PersistenciaException e) {
            fail("Error al inicialziar el modelo");
        }
    }

    @Test
    public void validarPersonaNulaTest() {
        Persona personaNula = null;

        try {
            personaController.validarPersona(personaNula);
        } catch (PersonaException e) {
            assertTrue(e.getMessage().contains("Se esta intentando validar un objeto vacio"));
        }

    }

    @Test
    public void validarPersonaVaciaTest() {
        Persona personaVacia = new Persona("", "", "", "", "", direccion);

        try {
            personaController.validarPersona(personaVacia);
        } catch (PersonaException e) {
            assertTrue(e.getMessage().contains("El telefono"));
        }
    }


    @Test
    public void validarPersonaNulaaTest() {
        Persona personaVacia = new Persona(null, null, null, null, null, direccion);

        try {
            personaController.validarPersona(personaVacia);
        } catch (PersonaException e) {
            assertTrue(e.getMessage().contains("de la persona"));
        }
    }

    @Test
    public void validarDniErrorTest() {
        Persona personaVacia = new Persona(null, null, "1234567", null, null, direccion);

        try {
            personaController.validarPersona(personaVacia);
        } catch (PersonaException e) {
            assertTrue(e.getMessage().contains("invalido"));
        }
    }

    @Test
    public void insertarErrorTest() {
        try {
            personaController.insertar(persona);
        } catch (PersistenciaException | PersonaException | DireccionException e) {
            assertTrue(e.getMessage().contains("La persona indicada ya existe"));
        }
    }

    @Test
    public void eliminarErrorTest() {
        Persona personaBorrar = new Persona("Ana", "Soria", "77777777F", "15/05/2020", "123456789", direccion);
        try {
            personaController.eliminar(personaBorrar);
        } catch (PersistenciaException | PersonaException | DireccionException e) {
            assertTrue(e.getMessage().contains("La persona indicada no existe"));
        }
    }

    @Test
    public void eliminarDniTest() {
        try {
            personaController.eliminar("55555555H");
        } catch (PersistenciaException | PersonaException | DireccionException e) {
            fail("Error al eliminar la persona", e);
        }
        try {
            personaController.insertar(persona);
        } catch (PersistenciaException | PersonaException | DireccionException e) {
            fail("Error al insertar la persona", e);
        }
    }

    @Test
    public void modificarTest() {
        persona.setNombre("Benito");
        try {
            personaController.modificar(persona);
        } catch (PersistenciaException | PersonaException | DireccionException e) {
            fail("Error al actualizar la persona", e);
        }
    }

    @Test
    public void modificarErrorTest() {
        Persona personaModificar = new Persona("Jose", "Ramos", "77777777B", "15/08/2020", "123456789", direccion);
        try {
            personaController.modificar(personaModificar);
        } catch (PersistenciaException | PersonaException | DireccionException e) {
            assertTrue(e.getMessage().contains("La persona indicada no existe"));
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
