package es.iespuertodelacruz.concesionario.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.api.Empleado;
import es.iespuertodelacruz.concesionario.api.Persona;
import es.iespuertodelacruz.concesionario.controlador.DireccionController;
import es.iespuertodelacruz.concesionario.controlador.EmpleadoController;
import es.iespuertodelacruz.concesionario.controlador.PersonaController;
import es.iespuertodelacruz.concesionario.exception.DireccionException;
import es.iespuertodelacruz.concesionario.exception.EmpleadoException;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.exception.PersonaException;

public class EmpleadoControllerTest {
    EmpleadoController empleadoController;
    PersonaController personaController;
    DireccionController direccionController;
    Empleado empleado;
    Persona persona;
    Direccion direccion;

    @BeforeEach 
    public void setUp(){
        if (empleadoController == null){
            try {
                empleadoController = new EmpleadoController(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo", e);
            }
        }
        empleado = crearEmpleado();
        try {
            empleadoController.insertar(empleado);
        } catch (PersistenciaException | EmpleadoException | PersonaException | DireccionException e) {
            fail("Error al insertar el empleado", e);
        }
    }

    @AfterEach 
    public void tearDown(){
        try {
            empleadoController.eliminar(empleado);
        } catch (PersistenciaException | EmpleadoException | PersonaException | DireccionException e) {
            fail("Error al eliminar el empleado", e);
        }
    }


    @Test
    public void constructorTest() {
        try {
            empleadoController = new EmpleadoController();
            empleadoController = new EmpleadoController(true);
        } catch (PersistenciaException e) {
            fail("Error al inicialziar el modelo");
        }
    }

    @Test
    public void validarEmpleadoNuloTest() {
        Empleado empleadoNulo = null;

        try {
            empleadoController.validarEmpleado(empleadoNulo);
        } catch (EmpleadoException e) {
            assertTrue(e.getMessage().contains("Se esta intentando validar un objeto vacio"));
        }

    }

    @Test
    public void validarEmpleadoVacioTest() {
        Empleado empleadoVacio = new Empleado("", "", "", "", "", "", direccion, "", "");

        try {
            empleadoController.validarEmpleado(empleadoVacio);
        } catch (EmpleadoException e) {
            assertTrue(e.getMessage().contains("El telefono"));
        }
    }

    @Test
    public void validarEmpleadoNullTest() {
        Empleado empleadoVacio = new Empleado(null, null, null, null, null, null, direccion, null, null);

        try {
            empleadoController.validarEmpleado(empleadoVacio);
        } catch (EmpleadoException e) {
            assertTrue(e.getMessage().contains("del empleado"));
        }

    }

    @Test
    public void validarDniErrorTest() {
        Empleado empleadoVacio = new Empleado(null, null, null, "1234567", null, null, direccion, null, null);

        try {
            empleadoController.validarEmpleado(empleadoVacio);
        } catch (EmpleadoException e) {
            assertTrue(e.getMessage().contains("invalido"));
        }
    }

    @Test
    public void insertarErrorTest() {
        try {
            empleadoController.insertar(empleado);
        } catch (PersistenciaException | EmpleadoException | PersonaException | DireccionException e) {
            assertTrue(e.getMessage().contains("El empleado indicado ya existe"));
        }
    }

    @Test
    public void eliminarErrorTest() {
        Empleado empleadoBorrar = new Empleado(null, "Sara", "Rosas", "88888888J", "15/05/2020", "123456789", direccion, "Empleado", "1234");
        try {
            empleadoController.eliminar(empleadoBorrar);
        } catch (PersistenciaException | EmpleadoException | PersonaException | DireccionException e) {
            assertTrue(e.getMessage().contains("El empleado indicado no existe"));
        }
    }

    @Test
    public void eliminarDniTest() {
        try {
            empleadoController.eliminar("55555555H");
        } catch (PersistenciaException | EmpleadoException | PersonaException | DireccionException e) {
            fail("Error al eliminar el empleado", e);
        }
        try {
            empleadoController.insertar(empleado);
        } catch (PersistenciaException | EmpleadoException | PersonaException | DireccionException e) {
            fail("Error al insertar el empleado", e);
        }
    }

    @Test
    public void modificarTest() {
        empleado.setNombre("Benito");
        try {
            empleadoController.modificar(empleado);
        } catch (PersistenciaException | EmpleadoException | PersonaException | DireccionException e) {
            fail("Error al actualizar el empleado", e);
        }
    }

    @Test
    public void modificarErrorTest() {
        Empleado empleadoModificar = new Empleado(null, "Jose", "Ramos", "77777777B", "15/08/2020", "123456789", direccion, "Empleado", "1234");
        try {
            empleadoController.modificar(empleadoModificar);
        } catch (PersistenciaException | EmpleadoException | PersonaException | DireccionException e) {
            assertTrue(e.getMessage().contains("El empleado indicado no existe"));
        }
    }

    @Test
    public void listadoEmpleadosTest() {
        try {
            assertEquals(11, empleadoController.listadoEmpleados().size(), "El tamanio no es el esperado");
        } catch (PersistenciaException e) {
            fail("Error al listar los empleados", e);
        }
    }

    @Test
    public void comprobarCredencialesGerenteTest() {
        try {
            empleadoController.comprobarCredenciales(1, "11111111B", "gerente");
        } catch (PersistenciaException | EmpleadoException e) {
            fail("Error validando las credenciales");
        }
    }

    @Test
    public void comprobarCredencialesEmpleadoTest() {
        try {
            empleadoController.comprobarCredenciales(2, "11111112B", "empleado01?");
        } catch (PersistenciaException | EmpleadoException e) {
            fail("Error validando las credenciales");
        }
    }

    @Test
    public void comprobarCredencialesGerenteErrorTest() {
        try {
            empleadoController.comprobarCredenciales(1, "11111112B", "empleado01?");
        } catch (PersistenciaException | EmpleadoException e) {
            assertTrue(e.getMessage().contains("Tu rango no es suficiente"));
        }
    }

    @Test
    public void comprobarCredencialesEmpleadoErrorTest() {
        try {
            empleadoController.comprobarCredenciales(2, "55555555H", "1234?");
        } catch (PersistenciaException | EmpleadoException e) {
            assertTrue(e.getMessage().contains("Tu rango no es suficiente"));
        }
    }

    @Test
    public void comprobarCredencialesContraseniaErrorTest() {
        try {
            empleadoController.comprobarCredenciales(1, "11111111B", "gerent");
        } catch (PersistenciaException | EmpleadoException e) {
            assertTrue(e.getMessage().contains("La contrasenia es incorrecta"));
        }
    }

    @Test
    public void comprobarCredencialesNuloTest() {
        try {
            empleadoController.comprobarCredenciales(1, "21111111B", "gerent");
        } catch (PersistenciaException | EmpleadoException e) {
            assertTrue(e.getMessage().contains("No existe un empleado"));
        }
    }

    @Test
    public void comprobarCredencialesSwitchErrorTest() {
        try {
            empleadoController.comprobarCredenciales(3, "11111111B", "gerente");
        } catch (PersistenciaException | EmpleadoException e) {
            fail("Error al validar las credenciales");
        }
    }



    /**
     * Funcion encargado de crear un empleado para test
     * @return empleado creado
     */
    private Empleado crearEmpleado() {
        return new Empleado(null, "Juan", "Perez", "55555555H", "15/05/1992", "123456789", crearDireccion(), "becario", "1234");
    }

    /**
     * Funcion encargado de crear una direccion para test
     * @return direccion creada
     */
    private Direccion crearDireccion() {
        return new Direccion("55555555H", "Camino Dia", 3, "38400", "Santa Cruz de Tenerife", "Puerto de la Cruz", "Espana");
    }
    
}