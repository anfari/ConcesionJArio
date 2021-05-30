package es.iespuertodelacruz.concesionario;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;
/**
 * 
 */


import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.vista.VistaApp;
public class VistaAppTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    VistaApp vista;
     @BeforeEach 
    public void setUp() throws PersistenciaException{
        if(vista==null){
            try {
                vista=new VistaApp();
            } catch (PersistenciaException e) {
                fail("Error en la inicializacion de la vista");
            }
    
        }

        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    
 
     @AfterEach 
    public void tearDown(){}


    @Test
    public void asse(){

    }
}
