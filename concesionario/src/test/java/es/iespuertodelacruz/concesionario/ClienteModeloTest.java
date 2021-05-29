package es.iespuertodelacruz.concesionario;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.modelo.ClienteModelo;

public class ClienteModeloTest {
    ClienteModelo clienteModelo;
     @BeforeEach 
    public void setUp(){
    if(clienteModelo==null){
        try {
            clienteModelo=new ClienteModelo();
        } catch (PersistenciaException e) {
            fail("Error al inicializar el modelo");
        }
    }
    }
     @AfterEach 
    public void tearDown(){}
    @Test
    public void crearTest() {
        
    }
   
    
}
