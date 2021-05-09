package es.iespuertodelacruz.concesionario;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase principal encargada de lanzar el menu de opciones de la app
 */
import es.iespuertodelacruz.concesionario.api.Vehiculo;
import es.iespuertodelacruz.concesionario.exception.BbddException;
import es.iespuertodelacruz.concesionario.modelo.CrearBbdd;

public class main {
    public static void main(String[] args) throws BbddException {
        CrearBbdd bbdd;
        bbdd = new CrearBbdd("org.sqlite.JDBC", "jdbc:sqlite:test.db", "", "");

        System.out.println(bbdd.crearCliente());
    }
    /**
     * Metodo estatico privado que contiene el menu
     */
    private static void menu(){
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Vehiculo vehiculo;
        while (!salir) {
 
            System.out.println("1. Insertar vehiculo nuevo");
            System.out.println("2. Modificar vehiculo");
            System.out.println("3. Elimininar vehiculo");
            System.out.println("4. Listado de vehiculos");
            System.out.println("5. Salir");
            vehiculo = null;
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = teclado.nextInt();
 
                switch (opcion) {
                    case 1:
                        
                        System.out.println("Coche"+ "insertado");
                        break;
                    case 2:
                        operacion = realizarOperacion('-', teclado);
                        resultado = operacionController.resta(operacion);
                        System.out.println("Resultado obtenido:"+resultado);
                        break;
                    case 3:
                        operacion = realizarOperacion('*', teclado);
                        resultado = operacionController.multiplicacion(operacion);
                        System.out.println("Resultado obtenido:"+resultado);
                        break;
                    case 4:
                        operacion = realizarOperacion('/', teclado);
                        resultado = operacionController.division(operacion);
                        System.out.println("Resultado obtenido:"+resultado);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar una opcion correcta");
                teclado.next();
            }
        }
 
    }

}
