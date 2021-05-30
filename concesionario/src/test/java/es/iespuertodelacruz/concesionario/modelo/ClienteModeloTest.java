package es.iespuertodelacruz.concesionario.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.api.*;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

public class ClienteModeloTest {
    ClienteModelo clienteModelo;
    PersonaModelo personaModelo;
    DireccionModelo direccionModelo;
    Cliente cliente;
    Persona persona;
    Direccion direccion;
     
    @BeforeEach 
    public void setUp(){
        if (clienteModelo == null){
            try {
                clienteModelo = new ClienteModelo(true);
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
        cliente = crearCliente();
        try {
            clienteModelo.insertar(cliente);
        } catch (PersistenciaException e) {
            fail("Error al insertar el cliente", e);
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
            clienteModelo.eliminar(cliente);
        } catch (PersistenciaException e) {
            fail("Error al eliminar el cliente", e);
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
            clienteModelo = new ClienteModelo();
            clienteModelo = new ClienteModelo(true);
        } catch (PersistenciaException e) {
            fail("Error al inicialziar el modelo");
        }
    }

    @Test
    public void modificarTest() {
        cliente.setNombre("Benito Perez");
        try {
            clienteModelo.modificar(cliente);
        } catch (PersistenciaException e) {
            fail("Error al actualizar el cliente", e);
        }
    }
    
    @Test
    public void buscarTest() {
        Cliente clienteEncontrado = null;
        try {
            clienteEncontrado = clienteModelo.buscar("11111111A");
        } catch (PersistenciaException e) {
            fail("Error al buscar el cliente", e);
        }
        assertNotNull(clienteEncontrado, "El objeto no deberia ser nulo");
    }

    @Test
    public void buscarEmptyTest() {
        Cliente clienteEncontrado = null;
        try {
            clienteEncontrado = clienteModelo.buscar("00000000Z");
        } catch (PersistenciaException e) {
            fail("Error al buscar el cliente", e);
        }
        assertNull(clienteEncontrado, "El objeto deberia ser nulo");
    }
   
    
    @Test
    public void listadoClientesTest() {
        try {
            assertEquals(11, clienteModelo.listadoClientes().size(), "El tamanio no es el esperado");
        } catch (PersistenciaException e) {
            fail("Error al listar los clientes", e);
        }

    }

    @Test
    public void convertirErrorTest() {
        try {
            clienteModelo.convertir("error");
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
     * Funcion encargado de crear un cliente para test
     * @return cliente creado
     */
    private Cliente crearCliente() {
        return new Cliente(null, "Juan", "Perez", "55555555H", "15/05/1992", "123456789", crearDireccion());
    }

    /**
     * Funcion encargado de crear una direccion para test
     * @return direccion creada
     */
    private Direccion crearDireccion() {
        return new Direccion("55555555H", "Camino Dia", 3, "38400", "Santa Cruz de Tenerife", "Puerto de la Cruz", "Espana");
    }

}