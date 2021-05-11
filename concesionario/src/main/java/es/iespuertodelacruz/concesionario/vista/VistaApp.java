package es.iespuertodelacruz.concesionario.vista;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertodelacruz.concesionario.api.*;
import es.iespuertodelacruz.concesionario.exception.BbddException;
import es.iespuertodelacruz.concesionario.modelo.Bbdd;
/**
 * Clase principal que contiene el menu de opciones de la app
 */
public class VistaApp {
    static Bbdd bd;
    public static void main(String[] args) throws BbddException {
        if(bd==null){
            bd=new Bbdd(null, null, null, null);
        }
        menuPrincipal();


    }
    /**
     * Metodo estatico privado que contiene el menu
     * @throws BbddException
     */
    private static void menuCoche() throws BbddException{
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Coche coche;
        while (!salir) {
 
            System.out.println("1. Insertar vehiculo nuevo");
            System.out.println("2. Modificar vehiculo");
            System.out.println("3. Elimininar vehiculo");
            System.out.println("4. Listado de vehiculos");
            System.out.println("5. Salir");
            coche = null;
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = teclado.nextInt();
 
                switch (opcion) {
                    case 1:
                        coche=generarDatosCoche(teclado);
                        bd.insertarCoche(coche);
                        System.out.println("Coche"+ "insertado");
                        break;
                    case 2:
                        System.out.println("Introduce el numero de bastidor");
                        String numBastidor=teclado.next();
                        coche=bd.obtenerCoche(numBastidor);
                        bd.modificarCoche(coche);
                        System.out.println("Coche"+ "modificado");
                        break;
                    case 3:
                        System.out.println("Introduce el numero de bastidor");
                        String numBastidor1=teclado.next();
                        coche=bd.obtenerCoche(numBastidor1);
                        bd.eliminarCoche(coche);
                        System.out.println("Coche"+ "eliminado");
                        break;
                    case 4:
                        ArrayList<Coche> lista=bd.obtenerListadoCoches();
                        String listado=lista.toString();
                        System.out.println("Lista de coches: "+listado);
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
    /**
     * Funcion privada encarga de generar nuevos coches
     * @param teclado variable a leer
     * @return devuelve un nuevo coche
     */
    private static Coche generarDatosCoche(Scanner teclado){
        
        System.out.println("Introduzca el valor de bastidor");
        String bastidor1 = teclado.next();

        System.out.println("Introduzca el valor de marca");
        String marca1 = teclado.next();

        System.out.println("Introduzca el valor de matricula");
        String matricula1 = teclado.next();

        System.out.println("Introduzca el valor de modelo");
        String modelo1 = teclado.next();

        System.out.println("Introduzca el valor de color");
        String color1 = teclado.next();

        System.out.println("Introduzca el valor de cilindrada");
        String cilindrada1 = teclado.next();

        System.out.println("Introduzca el valor de motor");
        String motor1 = teclado.next();

        System.out.println("Introduzca el valor de extras instalados");
        String extras1 = teclado.next();

        System.out.println("Introduzca el valor de la potencia");
        int potencia1 = teclado.nextInt();

        System.out.println("Introduzca el valor de precio");
        double precio1 = teclado.nextDouble();

        Coche coche= new Coche(bastidor1, matricula1, marca1, modelo1, color1, precio1, extras1, motor1, potencia1, cilindrada1);
        return coche;
    }



    /**
     * Metodo estatico privado que contiene el menu
     * @throws BbddException error controlado
     */
    private static void menuClientes() throws BbddException{
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Cliente clientes;
        while (!salir) {

        System.out.println("1. Insertar cliente nuevo");
        System.out.println("2. Modificar cliente");
        System.out.println("3. Elimininar cliente");
        System.out.println("4. Listado de clientes");
        System.out.println("5. Salir");
        clientes = null;
        try {

            System.out.println("Escribe una de las opciones");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    clientes=generarDatosClientes(teclado);
                    bd.insertarCliente(clientes);
                    System.out.println("Coche"+ "insertado");
                    break;
                case 2:
                    System.out.println("Introduce el dni del cliente");
                    String dni=teclado.next();
                    clientes=bd.obtenerCliente(dni);
                    break;
                case 3:
                    break;
                case 4:
                    ArrayList<Cliente> lista=bd.obtenerListadoClientes();
                    String listado=lista.toString();
                    System.out.println("Lista de clientes: "+listado);
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
    /**
     * Funcion privada encarga de generar nuevos clientes
     * @return devuelve un nuevo cliente
     */
    private static Cliente generarDatosClientes(Scanner teclado){

        System.out.println("Introduzca el valor de nombre");
        String nombre1 = teclado.next();

        System.out.println("Introduzca el valor de fechaNacimiento");
        String fechaNacimiento1 = teclado.next();

        System.out.println("Introduzca el valor de apellidos");
        String apellidos1 = teclado.next();

        System.out.println("Introduzca el valor de dni");
        String dni1 = teclado.next();

        System.out.println("Introduzca el valor de telefono");
        String telefono1 = teclado.next();

        Cliente cliente= new Cliente(nombre1, apellidos1, dni1, fechaNacimiento1, telefono1, generarDatosDireccion(teclado));
        return cliente;
    }
      /**
     * Funcion privada encarga de generar nuevas direcciones
     * @return devuelve una neuva direccion
     */
    private static Direccion generarDatosDireccion(Scanner teclado){

        System.out.println("Introduzca el valor del nuemro de la calle");
        int numero1 = teclado.nextInt();

        System.out.println("Introduzca el valor de calle");
        String calle1 = teclado.next();

        System.out.println("Introduzca el valor de codigoPostal");
        String codigoPostal1 = teclado.next();

        System.out.println("Introduzca el valor de provincia");
        String provincia1 = teclado.next();

        System.out.println("Introduzca el valor de poblacion");
        String poblacion1 = teclado.next();

        Direccion direccion=new Direccion(calle1, numero1, codigoPostal1, provincia1, poblacion1);
        return direccion;
    }

        /**
     * Metodo estatico privado que contiene el menu principal 
     * @throws BbddException error controlado
     */
    private static void menuPrincipal() throws BbddException{
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        while (!salir) {

        System.out.println("1. Realizar ventas");
        System.out.println("2. Usuarios");
        System.out.println("3. Empleado");
        System.out.println("4. Salir");
        try {

            System.out.println("Escribe una de las opciones");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    menuCoche();
                    break;
                case 2:
                   menuClientes();
                   
                    break;
                case 3:
                menuGerente();
                    break;
                case 4:
                    ArrayList<Cliente> lista=bd.obtenerListadoClientes();
                    String listado=lista.toString();
                    System.out.println("Lista de clientes: "+listado);
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

    private static void menuVentas() throws BbddException{
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Coche coche;
        while (!salir) {
        System.out.println("1. Vender coche");
        System.out.println("2. Coche vendidos");
        System.out.println("3. Listado de vehiculos");
        System.out.println("4. Salir");
        coche=null;
        try {

            System.out.println("Escribe una de las opciones");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    generarDatosCoche(teclado);
                    break;
                case 2:
                   generarDatosClientes(teclado);
                    break;
                case 3:
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
    /*
     * Metodo estatico privado que contiene el menu
     * @throws BbddException error controlado
     */
    private static void menuGerente() throws BbddException{
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Cliente clientes;
        while (!salir) {

        System.out.println("1. Insertar empleado");
        System.out.println("2. Modificar empleado");
        System.out.println("3. Elimininar empleados");
        System.out.println("4. Listado de empleados");
        System.out.println("5. Obtener datos empleado");
        System.out.println("6. Salir");
        clientes = null;
        try {

            System.out.println("Escribe una de las opciones");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    clientes=generarDatosClientes(teclado);
                    bd.insertarCliente(clientes);
                    System.out.println("Coche"+ "insertado");
                    break;
                case 2:
                    System.out.println("Introduce el dni del cliente");
                    String dni=teclado.next();
                    clientes=bd.obtenerCliente(dni);
                    break;
                case 3:
                    break;
                case 4:
                    ArrayList<Cliente> lista=bd.obtenerListadoClientes();
                    String listado=lista.toString();
                    System.out.println("Lista de clientes: "+listado);
                    break;
                case 5:
                    salir = true;
                    break;
                case 6:
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
