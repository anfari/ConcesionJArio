package es.iespuertodelacruz.concesionario.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

public class VehiculoApiTest {
    Vehiculo vehiculo;

    @BeforeEach 
    public void setUp(){
        if(vehiculo==null){
            vehiculo=crearVehiculo();
        }
    }

    @AfterEach 
    public void tearDown(){}

    @Test
    public void ConstructorTest() {
        assertNotNull(vehiculo);
    }
   
    @Test
    public void gettetSetterTest() {
        vehiculo= crearVehiculoSet();
        assertTrue(vehiculo.toString().contains("negro"));
    }



    private Vehiculo crearVehiculo(){
        vehiculo=new Vehiculo("123213313", "1111EEE", "Fiat", "UNO", "GRIS", 22.000,
         "Luneta termica", "1800", 15, "14", "coche", "nuevo");
         return vehiculo;
    }


    private Vehiculo crearVehiculoSet(){
        vehiculo = new Vehiculo();
        vehiculo.setBastidor("12121213");
        vehiculo.setColor("negro");
        vehiculo.setEstado("nuevo");
        vehiculo.setMarca("Toyota");
        vehiculo.setMatricula("3431ASA");
        vehiculo.setModelo("Corrolla");
        vehiculo.setMotor("1400");
        vehiculo.setCilindrada("34");
        vehiculo.setPrecio(15000);
        vehiculo.setExtrasInstalados("Cristales tintados");
        vehiculo.setTipo("coche");
        vehiculo.setPotencia(43);

        return vehiculo;
    }

    
}
