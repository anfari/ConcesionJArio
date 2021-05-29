package es.iespuertodelacruz.concesionario.ModeloTest;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.api.Direccion;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.modelo.ClienteModelo;

public class ClienteModeloTest {
    ClienteModelo clienteModelo;
    Cliente cliente;
     @BeforeEach 
    public void setUp(){
        if(clienteModelo==null){
            try {
                clienteModelo=new ClienteModelo(true);
            } catch (PersistenciaException e) {
                fail("Error al inicializar el modelo");
            }
        }
        cliente=generarCliente();
        
        try {
            clienteModelo.insertar(cliente);
        } catch (PersistenciaException e) {
            fail("Error al insertar un cliente");
        }

    }
     @AfterEach 
    public void tearDown(){}
    @Test
    public void constructorTest() {
        try {
            clienteModelo= new ClienteModelo();
            clienteModelo = new ClienteModelo(true);
        } catch (PersistenciaException e) {
            fail("Error al inicializar el modelo");
        }
    }
      /**
     * Funcion privada encargada de genrar cliente
     */
    private Cliente generarCliente(){
        Cliente cliente= new Cliente(null, "Pacho", "Burrulo", "22222222A", "02/09/1990", "986365252",generarDireccion());
        return cliente;
    }
    
       /**
     * Funcion privada encargada de generar direcciones de personas
     */
    private Direccion generarDireccion(){
        Direccion direccion= new Direccion("22222222A", "VillaBajo", 2, "38435", "Almeria", "Almeria", "España");
        return direccion;
    }
   
    
}
