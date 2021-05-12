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
    static Scanner teclado = new Scanner(System.in);
    static Bbdd bd;

    public static void main(String[] args) throws BbddException {
        if(bd==null){
            bd=new Bbdd(null, null, null, null);
        }
        menuPrincipal();


    }


    /**
     * Metodo estatico privado que contiene el menu principal 
     * @throws BbddException error controlado
     */
    private static void menuPrincipal() throws BbddException {
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("1. Realizar ventas");
            System.out.println("2. Gestionar clientes");
            System.out.println("3. Gestionar empleados");
            System.out.println("4. Gestionar vehiculos");
            System.out.println("5. Salir\n");

            try {
                System.out.print("Introduzca una de las opciones: ");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        menuVentas();
                        break;
                    case 2:
                        menuClientes();
                        break;
                    case 3:
                        menuEmpleados();
                        break;
                    case 4:
                        menuVehiculos();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe insertar una opcion correcta");
                teclado.next();
            }
        }
    }
    
    /**
     * Metodo estatico privado que contiene el menu de ventas
     * @throws BbddException error controlado
    */
    private static void menuVentas() throws BbddException {
        boolean salir = false;
        int opcion;
        Vehiculo vehiculo;

        while (!salir) {
            System.out.println("1. Vender Vehiculo");
            System.out.println("2. Vehiculos vendidos");
            System.out.println("3. Listado de vehiculos");
            System.out.println("4. Salir\n");

            vehiculo=null;
            try {
                System.out.print("Introduzca una de las opciones: ");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        //TODO: Eliminar un coche del  modelo deseado de la BBDD
                        break;
                    case 2:
                        //TODO: Mostrar lista de vehiculos vendidos por orden de ventas
                        break;
                    case 3:
                        //TODO: Mostrar lista de vehiculos disponibles
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe insertar una opcion correcta");
                teclado.next();
            }
        }
    }


    /**
     * Metodo estatico privado que contiene el menu de gestion de clientes
     */
    private static void menuClientes() {
        boolean salir = false;
        int opcion;
        Cliente cliente;

        while (!salir) {
            System.out.println("1. Insertar nuevo cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Listado de clientes");
            System.out.println("5. Salir\n");
            cliente = null;

            try {
                System.out.print("Intrduzca una de las opciones: ");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        cliente = generarDatosCliente();
                        //TODO: Insertar el cliente desde controlador
                        System.out.println("\nCliente insertado");
                        break;
                    case 2:
                        System.out.println("Proceda a introducir los datos, el DNI debe mantenerse igual");
                        cliente = generarDatosCliente();
                        //TODO: Modificar el cliente desde controlador
                        System.out.println("\nCliente modificado");
                        break;
                    case 3:
                        System.out.print("Introduzca el dni del cliente: ");
                        //TODO: Eliminar el cliente desde controlador
                        System.out.println("\nCliente eliminado");
                        break;
                    case 4:
                        System.out.println("Lista de clientes: ");
                        //TODO: Mostrar lista de clientes
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe insertar una opcion correcta");
                teclado.next();
            }
        }
    }


    /**
     * Metodo estatico que contiene el menu de gestion de empleados
     */
    private static void menuEmpleados() {
        boolean salir = false;
        int opcion;
        Empleado empleado;

        while (!salir) {
            System.out.println("1. Insertar empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Listado de empleados");
            System.out.println("5. Obtener datos empleado");
            System.out.println("6. Salir\n");
            empleado = null;

            try {

                System.out.print("Introduzca una de las opciones: ");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        empleado = generarDatosEmpleado();
                        //TODO: Insertar el empleado desde controlador
                        System.out.println("\nEmpleado insertado");
                        break;
                    case 2:
                        System.out.println("Proceda a introducir los datos, el DNI debe mantenerse igual");
                        empleado = generarDatosEmpleado();
                        //TODO: Modificar el empleado desde controlador
                        System.out.println("\nCliente modificado");
                        break;
                    case 3:
                        System.out.print("Introduzca el dni del empleado: ");
                        //TODO: Eliminar el empleado desde controlador
                        System.out.println("\nEmpleado eliminado");                    
                        break;
                    case 4:
                        System.out.println("Lista de empleados: ");
                        //TODO: Mostrar lista de empleados
                        break;
                    case 5:
                        System.out.print("Introduzca el dni del empleado: ");
                        //TODO: Mostrar informacion del empleado desde controlador
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe insertar una opcion correcta");
                teclado.next();
            }
        }
    }    

    /**
     * Metodo estatico privado que contiene el menu
     * @throws BbddException error controlado
     */
    private static void menuVehiculos() throws BbddException{
        boolean salir = false;
        int opcion;
        Vehiculo vehiculo;

        while (!salir) {
            System.out.println("1. Insertar vehiculo nuevo");
            System.out.println("2. Modificar vehiculo");
            System.out.println("3. Elimininar vehiculo");
            System.out.println("4. Listado de vehiculos");
            System.out.println("5. Salir\n");
            vehiculo = null;

            try {
                System.out.print("Introduzca una de las opciones: ");
                opcion = teclado.nextInt();
 
                switch (opcion) {
                    case 1:
                        vehiculo = generarDatosVehiculo();
                        //TODO: Insertar el vehiculo desde controlador
                        System.out.println("\nVehiculo insertado");
                        break;
                    case 2:
                        System.out.println("Proceda a introducir los datos, el numero de bastidor debe mantenerse igual");
                        vehiculo = generarDatosVehiculo();
                        //TODO: Modificar el vehiculo desde controlador
                        System.out.println("\nVehiculo modificado");
                        break;
                    case 3:
                        System.out.print("Introduzca el numero de bastidor del vehiculo: ");
                        //TODO: Eliminar el vehiculo desde controlador
                        System.out.println("\nVehiculo eliminado");  
                        break;
                    case 4:
                        System.out.println("Lista de vehiculos: ");
                        //TODO: Mostrar lista de vehiculos
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe insertar una opcion correcta");
                teclado.next();
            }
        }
    }


    /**
     * Funcion privada encarga de generar vehiculos
     * @return devuelve un objeto de tipo vehiculo
     */
    private static Vehiculo generarDatosVehiculo(){
        
        System.out.print("Introduzca el numero de bastidor: ");
        String bastidor = teclado.next();

        System.out.print("Introduzca el valor de matricula: ");
        String matricula = teclado.next();

        System.out.print("Introduzca la marca: ");
        String marca = teclado.next();

        System.out.print("Introduzca el modelo: ");
        String modelo = teclado.next();

        System.out.print("Introduzca el color: ");
        String color = teclado.next();

        System.out.print("Introduzca la cilindrada: ");
        String cilindrada = teclado.next();

        System.out.print("Introduzca el tipo de motor: ");
        String motor = teclado.next();

        System.out.print("Introduzca la potencia: ");
        int potencia = teclado.nextInt();

        System.out.print("Introduzca los extras instalados: ");
        String extras = teclado.next();

        System.out.print("Introduzca el precio: ");
        double precio = teclado.nextDouble();

        System.out.print("Introduzca el tipo de vehiculo: ");
        String tipo = teclado.next();

        return new Vehiculo(bastidor, matricula, marca, modelo, color, precio, extras, motor, potencia, cilindrada, tipo);
    }

    /**
     * Funcion privada encarga de generar clientes
     * @return un cliente
     */
    private static Cliente generarDatosCliente() {

        System.out.print("Introduzca el valor de el codigo de cliente: ");
        String codigoCliente = teclado.next();

        System.out.print("Introduzca el valor de dni: ");
        String dni = teclado.next();

        System.out.print("Introduzca el valor de nombre: ");
        String nombre = teclado.next();

        System.out.print("Introduzca el valor de apellidos: ");
        String apellidos = teclado.next();

        System.out.print("Introduzca el valor de fechaNacimiento: ");
        String fechaNacimiento = teclado.next();

        System.out.print("Introduzca el valor de telefono: ");
        String telefono = teclado.next();

        return new Cliente(codigoCliente, nombre, apellidos, dni, fechaNacimiento, telefono, generarDatosDireccion(dni));
    }

    /**
     * Funcion privada encarga de generar empleados
     * @return un empleado
     */
    private static Empleado generarDatosEmpleado() {

        System.out.print("Introduzca el valor de el codigo del empleado ");
        String codigoEmpleado = teclado.next();

        System.out.print("Introduzca el valor de dni: ");
        String dni = teclado.next();

        System.out.print("Introduzca el valor de nombre: ");
        String nombre = teclado.next();

        System.out.print("Introduzca el valor de apellidos: ");
        String apellidos = teclado.next();

        System.out.print("Introduzca el valor de fechaNacimiento: ");
        String fechaNacimiento = teclado.next();

        System.out.print("Introduzca el valor de telefono: ");
        String telefono = teclado.next();

        System.out.print("Introduzca el rango del empleado: ");
        String rango = teclado.next();

        System.out.print("Introduzca el valor de contraseña: ");
        String contraseña = teclado.next();

        return new Empleado(nombre, apellidos, dni, fechaNacimiento, telefono, generarDatosDireccion(dni), codigoEmpleado, rango, contraseña);
    }

    /**
     * Funcion privada encarga de generar nuevas direcciones
     * @return una direccion
     */
    private static Direccion generarDatosDireccion(String identificador){

        System.out.print("Introduzca el pais: ");
        String pais = teclado.next();

        System.out.print("Introduzca la provincia: ");
        String provincia = teclado.next();

        System.out.print("Introduzca la ciudad: ");
        String ciudad = teclado.next();

        System.out.print("Introduzca el valor de calle: ");
        String calle = teclado.next();

        System.out.print("Introduzca el numero de la vivienda: ");
        int numero = teclado.nextInt();

        System.out.print("Introduzca el codigo postal: ");
        String codigoPostal = teclado.next();

        return new Direccion(identificador, calle, numero, codigoPostal, provincia, ciudad, pais);
    }





}
