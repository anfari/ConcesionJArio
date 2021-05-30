package es.iespuertodelacruz.concesionario.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.api.Empleado;
import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

public class EmpleadoModeloTest {
    EmpleadoModelo empleadoModelo;
    PersonaModelo personaModelo;
    DireccionModelo direccionModelo;
    Empleado empleado;
    Persona persona;
    Direccion direccion;
     
    @BeforeEach 
    public void setUp(){
        if (empleadoModelo == null){
            try {
                empleadoModelo = new EmpleadoModelo(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo", e);
            }
        }
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
        empleado = crearEmpleado();
        try {
            empleadoModelo.insertar(empleado);
        } catch (PersistenciaException e) {
            fail("Error al insertar el empleado", e);
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
            empleadoModelo.eliminar(empleado);
        } catch (PersistenciaException e) {
            fail("Error al eliminar el empleado", e);
        }
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
    public void constructorTest() {
        try {
            empleadoModelo = new EmpleadoModelo();
            empleadoModelo = new EmpleadoModelo(true);
        } catch (PersistenciaException e) {
            fail("Error al inicialziar el modelo");
        }
    }

    @Test
    public void modificarTest() {
        empleado.setNombre("Benito Perez");
        try {
            empleadoModelo.modificar(empleado);
        } catch (PersistenciaException e) {
            fail("Error al actualizar el empleado", e);
        }
    }
    
    @Test
    public void buscarTest() {
        Empleado empleadoEncontrado = null;
        try {
            empleadoEncontrado = empleadoModelo.buscar("11111111B");
        } catch (PersistenciaException e) {
            fail("Error al buscar el empleado", e);
        }
        assertNotNull(empleadoEncontrado, "El objeto no deberia ser nulo");
    }

    @Test
    public void buscarEmptyTest() {
        Empleado empleadoEncontrado = null;
        try {
            empleadoEncontrado = empleadoModelo.buscar("00000000Z");
        } catch (PersistenciaException e) {
            fail("Error al buscar el empleado", e);
        }
        assertNull(empleadoEncontrado, "El objeto deberia ser nulo");
    }
   
    
    @Test
    public void listadoEmpleadosTest() {
        try {
            assertEquals(11, empleadoModelo.listadoEmpleados().size(), "El tamanio no es el esperado");
        } catch (PersistenciaException e) {
            fail("Error al listar los empleados", e);
        }

    }

    @Test
    public void convertirErrorTest() {
        try {
            empleadoModelo.convertir("error");
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
     * Funcion encargado de crear un empleado para test
     * @return empleado creado
     */
    private Empleado crearEmpleado() {
        return new Empleado(null, "Juan", "Perez", "55555555H", "15/05/1992", "123456789", crearDireccion(), "Gerente", "1234");
    }

    /**
     * Funcion encargado de crear una direccion para test
     * @return direccion creada
     */
    private Direccion crearDireccion() {
        return new Direccion("55555555H", "Camino Dia", 3, "38400", "Santa Cruz de Tenerife", "Puerto de la Cruz", "Espana");
    }

}
