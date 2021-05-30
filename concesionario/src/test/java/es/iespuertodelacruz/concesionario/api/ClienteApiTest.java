package es.iespuertodelacruz.concesionario.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

public class ClienteApiTest {
    Cliente cliente;
    Direccion direccion;

    @BeforeEach 
    public void setUp(){
        if(cliente==null){
            cliente=generarCliente();
        }
        if(direccion==null){
            direccion=generarDireccion();
        }
    }

    @Test
    public void ListaClienteTest() {
        assertTrue(cliente.toString().length()>0);
    }

    @Test
    public void ConstructorTest() {
        assertNotNull(cliente);
    }
   
    @Test
    public void gettetSetterDirecionTest() {
        direccion= crearDirecionSet();
        assertTrue(direccion.toString().contains("Mauritania"));
    }

    @Test
    public void ConstructorDirecionTest() {
        assertNotNull(direccion);
    }
   
    @Test
    public void gettetSetterTest() {
        cliente= crearCliente();
        assertTrue(cliente.toString().contains("Pan y vino"));
    }



    /**
     * Funcion privada encargada de genrar cliente
     */
    private Cliente generarCliente(){
        Cliente cliente= new Cliente(null, "Pacho", "Burrulo", "22222222A", "02/09/1990", "986365252",generarDireccion());
        return cliente;
    }  

    /**
     * Funcion privada encargada de generar Set de cliente
     * @return
     */
    private Cliente crearCliente(){ 
    cliente= new Cliente();
    
        cliente.setNombre("Marcelino");
        cliente.setApellidos("Pan y vino");
        cliente.setDni("34212345R");
        cliente.setFechaNacimiento("02/01/2007");
        cliente.setTelefono("9821576958");;
        cliente.setDireccion(crearDirecionSet());
        cliente.setCodigoCliente("QW1");
    
    return cliente;
    }

    
     /**
     * Funcion privada encargada de generar direcciones de personas
     */
    private Direccion generarDireccion(){
        Direccion direccion= new Direccion("22222222A", "VillaBajo", 2, "38435", "Almeria", "Almeria", "España");
        return direccion;
    }

    /**
     * Funcion privada encargada de generar Set de cliente
     * @return
     */
    private Direccion crearDirecionSet(){
        direccion= new Direccion();
        
        direccion.setCalle("Hawai");
        direccion.setCiudad("Mauritania");
        direccion.setCodigoPostal("34546");
        direccion.setPais("Japón");
        direccion.setProvincia("STA cruz de Tenerife");
        direccion.setIdentificador("34212345R");
        direccion.setNumero(2);
        
        return direccion;
    }
            
        
        
    
    
}
