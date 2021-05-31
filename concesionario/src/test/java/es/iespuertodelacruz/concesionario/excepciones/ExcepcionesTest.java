package es.iespuertodelacruz.concesionario.excepciones;
/**
 * Clase donde vamos a testear todas las excepciones
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import es.iespuertodelacruz.concesionario.exception.*;

public class ExcepcionesTest {
     
    @Test
    public void DniExceptionTest() {
        try {
            throw new DniException("Error", new Exception());
        } catch (DniException e) {
            assertEquals("Error", e.getMessage(), "El error no es el esperado");
        }
    }

    @Test
    public void DniException2Test() {
        try {
            throw new DniException("Error");
        } catch (DniException e) {
            assertEquals("Error", e.getMessage(), "El error no es el esperado");
        }
    }

      
    @Test
    public void VentaExceptionTest() {
        try {
            throw new VentaException("Error", new Exception());
        } catch (VentaException e) {
            assertEquals("Error", e.getMessage(), "El error no es el esperado");
        }
    }

      
    @Test
    public void DireccionExceptionTest() {
        try {
            throw new DireccionException("Error", new Exception());
        } catch (DireccionException e) {
            assertEquals("Error", e.getMessage(), "El error no es el esperado");
        }
    }

      
    @Test
    public void PersonaExceptionTest() {
        try {
            throw new PersonaException("Error", new Exception());
        } catch (PersonaException e) {
            assertEquals("Error", e.getMessage(), "El error no es el esperado");
        }
    }

      
    @Test
    public void EmpleadoExceptionTest() {
        try {
            throw new EmpleadoException("Error", new Exception());
        } catch (EmpleadoException e) {
            assertEquals("Error", e.getMessage(), "El error no es el esperado");
        }
    }

      
    @Test
    public void VehiculoExceptionTest() {
        try {
            throw new VehiculoException("Error", new Exception());
        } catch (VehiculoException e) {
            assertEquals("Error", e.getMessage(), "El error no es el esperado");
        }
    }

      
    @Test
    public void ClienteExceptionTest() {
        try {
            throw new ClienteException("Error", new Exception());
        } catch (ClienteException e) {
            assertEquals("Error", e.getMessage(), "El error no es el esperado");
        }
    }

    @Test
    public void BastidorExceptionTest() {
        try {
            throw new BastidorException("Error", new Exception());
        } catch (BastidorException e) {
            assertEquals("Error", e.getMessage(), "El error no es el esperado");
        }
    }

    @Test
    public void BastidorException2Test() {
        try {
            throw new BastidorException("Error");
        } catch (BastidorException e) {
            assertEquals("Error", e.getMessage(), "El error no es el esperado");
        }
    }
    
}
