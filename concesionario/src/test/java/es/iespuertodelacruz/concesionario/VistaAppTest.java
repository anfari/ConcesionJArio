package es.iespuertodelacruz.concesionario;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

import es.iespuertodelacruz.concesionario.exception.PersistenciaException;
import es.iespuertodelacruz.concesionario.vista.VistaApp;

public class VistaAppTest {
/*
   private final InputStream systemIn = System.in;
   private final PrintStream systemOut = System.out;

   private ByteArrayInputStream testIn;
   private ByteArrayOutputStream testOut;

   String[] args = null;
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

   
      
   
   
   @Test
   public void sumaTest(){
      
   
      args = null;
      testIn = new ByteArrayInputStream("1 3".getBytes());
      System.setIn(testIn);
      try {
         vista.main(args);
      } catch (Exception e) {
         fail("Se ha producido un error realizando la operacion suma:"+e.getMessage());
      }
      
   } 

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
}
