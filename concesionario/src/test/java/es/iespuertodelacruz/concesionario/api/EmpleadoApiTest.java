package es.iespuertodelacruz.concesionario.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;


public class EmpleadoApiTest {
    Empleado empleado;
    Direccion direccion;

    @BeforeEach 
    public void setUp(){
        if(empleado==null){
            empleado=generarEmpleado();
        }
        if(direccion==null){
            direccion=generarDireccion();
        }
    }

    @Test
    public void ListaEmpleadoTest() {
        assertTrue(empleado.toString().length()>0);
    }

    @Test
    public void ConstructorTest() {
        assertNotNull(empleado);
    }
   
    @Test
    public void gettetSetterDirecionTest() {
        direccion= generarDireccion();
        assertTrue(direccion.toString().contains("VillaBajo"));
    }

    @Test
    public void ConstructorDirecionTest() {
        assertNotNull(direccion);
    }
   
    @Test
    public void gettetSetterTest() {
        empleado= crearEmpleado();
        assertTrue(empleado.toString().contains("Pan y vino"));
    }



    /**
     * Funcion privada encargada de genrar Empleado
     */
    private Empleado generarEmpleado(){
        Empleado empleado= new Empleado(null, "Pacho", "Burrulo", 
        "22222222A", "02/09/1990", "986365252",generarDireccion(),"Coordinador","EO");
        return empleado;
    }   

    
    /**
     * Funcion privada encargada de generar Set de Empleado
     * @return
     */
    private Empleado crearEmpleado(){ 
        empleado= new Empleado();
    
        empleado.setNombre("Marcelino");
        empleado.setApellidos("Pan y vino");
        empleado.setDni("34212345R");
        empleado.setFechaNacimiento("02/01/2007");
        empleado.setTelefono("9821576958");;
        empleado.setDireccion(crearDirecionSet());
        empleado.setCodigoEmpleado("QW1");
        empleado.setRango("Coordinador");
        empleado.setContrasenia("asdad");

    
    return empleado;
    }
    
     /**
     * Funcion privada encargada de generar direcciones de personas
     */
    private Direccion generarDireccion(){
        Direccion direccion= new Direccion("22222222A", "VillaBajo", 2, "38435", "Almeria", "Almeria", "España");
        return direccion;
    }

    /**
     * Funcion privada encargada de generar Set de Empleado
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