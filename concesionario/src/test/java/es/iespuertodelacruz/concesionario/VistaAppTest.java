package es.iespuertodelacruz.concesionario;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.*;

import es.iespuertodelacruz.concesionario.exception.BastidorException;
import es.iespuertodelacruz.concesionario.exception.ClienteException;
import es.iespuertodelacruz.concesionario.exception.DireccionException;
import es.iespuertodelacruz.concesionario.exception.DniException;
import es.iespuertodelacruz.concesionario.exception.EmpleadoException;
import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.exception.PersonaException;
import es.iespuertodelacruz.concesionario.exception.VehiculoException;
import es.iespuertodelacruz.concesionario.exception.VentaException;
import es.iespuertodelacruz.concesionario.vista.VistaApp;

public class VistaAppTest {
   private ByteArrayInputStream testIn;
   String[] args = null;
   VistaApp vistaApp;

   
   @BeforeEach 
   public void setUp() throws PersistenciaException{
      if(vistaApp == null){
         try {
               vistaApp = new VistaApp(true);
         } catch (PersistenciaException e) {
               fail("Error en la inicializacion de la vista");
         }
      }
   }

   @Test
   public void constructorTest() {
      try {
         vistaApp = new VistaApp();
         vistaApp = new VistaApp(true);
      } catch (PersistenciaException e) {
         fail("Error al inicializar la vista");
      }
   }
   
   @Test
   public void principalSalirTest(){
      args = null;
      testIn = new ByteArrayInputStream("3 ".getBytes());
      System.setIn(testIn);

      try {
         VistaApp.menuPrincipal();
      } catch (ClienteException | PersistenciaException | DniException | EmpleadoException
            | VehiculoException | BastidorException | DireccionException | VentaException | PersonaException e) {
         fail("Error ejecutando el menu");
      }
   } 

   @Test
   public void opcion4Test(){
      args = null;
      testIn = new ByteArrayInputStream("3 ".getBytes());
      System.setIn(testIn);

      try {
         VistaApp.menuPrincipal();
      } catch (ClienteException | PersistenciaException | DniException | EmpleadoException
            | VehiculoException | BastidorException | DireccionException | VentaException | PersonaException e) {
         fail("Error ejecutando el menu");
      }
   } 

   @Test
   public void principalSolo1a3Test(){
      args = null;
      testIn = new ByteArrayInputStream("4\r3 ".getBytes());
      System.setIn(testIn);

      try {
         VistaApp.main(args);
      } catch (ClienteException | PersistenciaException | DniException | EmpleadoException
            | VehiculoException | BastidorException | DireccionException | VentaException | PersonaException e) {
         fail("Error ejecutando el menu");
      }
   } 

   @Test
   public void principalErrorTest(){
      args = null;
      testIn = new ByteArrayInputStream("a\r3 ".getBytes());
      System.setIn(testIn);

      try {
         VistaApp.main(args);
      } catch (ClienteException | PersistenciaException | DniException | EmpleadoException
            | VehiculoException | BastidorException | DireccionException | VentaException | PersonaException e) {
         fail("Error ejecutando el menu");
      }
   } 
/*
   @Test
   public void empleadoSalirTest(){
      args = null;
      testIn = new ByteArrayInputStream("3 ".getBytes());
      System.setIn(testIn);

      try {
         VistaApp.menuEmpleado();
      } catch (BbddException | ClienteException | PersistenciaException | DniException | VehiculoException
      | DireccionException | VentaException | PersonaException e) {
         fail("Error ejecutando el menu");
      }
   } 


   @Test
   public void gerenteSalirTest(){
      args = null;
      testIn = new ByteArrayInputStream("5 ".getBytes());
      System.setIn(testIn);


      try {
         VistaApp.menuGerente();
      } catch (BbddException | ClienteException | PersistenciaException | DniException | EmpleadoException
            | VehiculoException | BastidorException | DireccionException | VentaException | PersonaException e) {
         fail("Error ejecutando el menu");
      }
   } 



   @Test
   public void ventasSalirTest(){
      testIn = new ByteArrayInputStream("4 ".getBytes());
      System.setIn(testIn);

      try {
         VistaApp.menuVentas();
      } catch (BbddException | PersistenciaException | VehiculoException | VentaException e) {
         fail("Error ejecutando el menu");
      }
   } 



   @Test
   public void clientesSalirTest(){
      testIn = new ByteArrayInputStream("6 ".getBytes());
      System.setIn(testIn);

      try {
         VistaApp.menuClientes();
      } catch (ClienteException | PersistenciaException | DniException | DireccionException | PersonaException e) {
         fail("Error ejecutando el menu");
      }
   } 



   @Test
   public void empleadosSalirTest(){
      testIn = new ByteArrayInputStream("6 ".getBytes());
      System.setIn(testIn);

      try {
         VistaApp.menuEmpleados();
      } catch (EmpleadoException | PersistenciaException | DniException | DireccionException | PersonaException e) {
         fail("Error ejecutando el menu");
      }
   } 


   @Test
   public void vehiculosSalirTest(){
      testIn = new ByteArrayInputStream("5 ".getBytes());
      System.setIn(testIn);

      try {
         VistaApp.menuVehiculos();
      } catch (VehiculoException | PersistenciaException | DniException | BastidorException e) {
         fail("Error ejecutando el menu");
      }
   } 



   /*
   @Test
   public void restaTest(){
      String[] args = null;
      testIn = new ByteArrayInputStream("2 3".getBytes());
      System.setIn(testIn);
      try {
         vista.main(args);
      } catch (Exception e) {
         fail("Se ha producido un error realizando la operacion suma:"+e.getMessage());
      }
      
   } 
   

   @Test
   public void errorEleccionMenuTest(){
      
      String[] args = null;
      testIn = new ByteArrayInputStream("4 a".getBytes());
      System.setIn(testIn);
      try {
         vista.main(args);
      } catch (Exception exception) {
         if (exception instanceof NoSuchElementException) {
            assertTrue(true);
         } else {
            fail("Se ha producido un error realizando la operacion suma:"+exception.getMessage());
         }
         
      }
      
   }*/


   @Test
   public void validarDniTest() {
      String dni = "11111111A";
      try {
         VistaApp.validarDni(dni);
      } catch (DniException e) {
         fail("Error al validar el dni");
      }
   }

   @Test
   public void validarDniErrorTest() {
      String dni = "";
      try {
         VistaApp.validarDni(dni);
      } catch (DniException e) {
         assertTrue(e.getMessage().contains("Debe introducir un DNI"));
      }
   }

   @Test
   public void validarBastidorTest() {
      String bastidor = "VVVZZZ6KZ1R149942";
      
      try {
         VistaApp.validarBastidor(bastidor);
      } catch (BastidorException e) {
         fail("Error al validar el bastidor");
      }
      
   }

   @Test
   public void validarBastidorErrorTest() {
      String bastidor = "";
      try {
         VistaApp.validarBastidor(bastidor);
      } catch (BastidorException e) {
         assertTrue(e.getMessage().contains("Debe introducir"));
      }
   }


}
