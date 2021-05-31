package es.iespuertodelacruz.concesionario.modelo;

import java.io.File;
import java.util.Scanner;

import es.iespuertodelacruz.concesionario.exception.PersistenciaException;

/**
 * Clase Fichero
 */
public class Fichero {
   private static final String RETORNO_CARRO = "\n";

   /**
    * Funcion encargada de leer un ficher
    * @param nombre nombre del fichero a leer
    * @return informacion obtenida del fichero
    * @throws PersistenciaException Error controlado en la lectura del fichero
    */
   public String leer(String nombre) throws PersistenciaException {
      StringBuilder informacion = null;
      File fichero = null;
      Scanner scanner = null;

      try {
         fichero = new File(nombre);
         if (!validarFichero(fichero)) {
            throw new PersistenciaException("El fichero a leer no existe");
         }
         informacion = new StringBuilder();
         scanner = new Scanner(fichero);

         while (scanner.hasNextLine()) {
            String linea = scanner.nextLine(); // Guardamos la linea en un String
            informacion.append(linea + RETORNO_CARRO);
         }
      }catch (Exception e) {
            throw new PersistenciaException("Se ha producido un error en la lectura del fichero", e);
      } finally {
         if (scanner != null) {
            scanner.close();
         }
      }
      return informacion.toString();
   }    

   /**
   * Funcion que verifica si el fichero existo
   * @param fichero fichero a validar
   * @return true/false si existe o no
   */
   public boolean validarFichero(File fichero) {
      return fichero.exists();
   }
}
