package es.iespuertodelacruz.concesionario.vista;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertodelacruz.concesionario.api.*;
import es.iespuertodelacruz.concesionario.controlador.*;
import es.iespuertodelacruz.concesionario.exception.*;
import es.iespuertodelacruz.concesionario.modelo.Bbdd;
/**
 * Clase principal que contiene el menu de opciones de la app
 */
public class VistaApp {
    static Scanner teclado = new Scanner(System.in);
    static Bbdd bd;
    static ClienteController clienteController;
    static EmpleadoController empleadoController;
    static VehiculoController vehiculoController;
    static PersonaController personaController;
    static DireccionController direccionController;
    static VentaController ventaController;
    

    /**
     * Constructor de VistaApp
     * @throws PersistenciaException error controlado
     */
    public VistaApp() throws PersistenciaException {
        clienteController = new ClienteController();
        empleadoController = new EmpleadoController();
        vehiculoController = new VehiculoController();
        personaController = new PersonaController();
        direccionController = new DireccionController();
        ventaController= new VentaController();
    }

    /**
     * constructor para test de la clase VistaApp
     * @param test parametro que recibe de los test
     * @throws PersistenciaException error controlado
     */
    public VistaApp(boolean test) throws PersistenciaException {
        clienteController = new ClienteController(true);
        empleadoController = new EmpleadoController(true);
        vehiculoController = new VehiculoController(true);
        personaController = new PersonaController(true);
        direccionController = new DireccionController(true);
        ventaController= new VentaController(true);
    }


    /**
     * Metodo main de la clase VistaApp
     * @param args argumentos
     * @throws ClienteException error controlado
     * @throws PersistenciaException error controlado
     * @throws DniException error controlado
     * @throws EmpleadoException error controlado
     * @throws VehiculoException error controlado
     * @throws BastidorException error controlado
     * @throws DireccionException error controlado
     * @throws VentaException error controlado
     * @throws PersonaException error controlado
     */
    public static void main(String[] args) throws ClienteException, PersistenciaException, DniException, EmpleadoException, VehiculoException, BastidorException, DireccionException, VentaException, PersonaException {

        new VistaApp();
        menuPrincipal();

    }
    /**
     * Metodo estatico privado que contiene el menu principal 
     * @throws DniException error controlado
     * @throws PersistenciaException error controlado
     * @throws ClienteException error controlado
     * @throws BastidorException error controlado
     * @throws VehiculoException error controlado
     * @throws EmpleadoException error controlado
     * @throws DireccionException error controlado
     * @throws VentaException error controlado
     * @throws PersonaException error controlado
     */
    public static void menuPrincipal() throws ClienteException, PersistenciaException, DniException, EmpleadoException, VehiculoException, BastidorException, DireccionException, VentaException, PersonaException {
        teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("\n1. Acceso Gerente");
            System.out.println("2. Acceso Empleado");
            System.out.println("3. Salir\n");

            try {
                System.out.print("Introduzca una de las opciones: ");
                opcion = teclado.nextInt();
                teclado.nextLine();
                System.out.println("");

                switch (opcion) {
                    case 1:
                        pedirCredenciales(1);
                        menuGerente();
                        break;
                    case 2:
                        pedirCredenciales(2);
                        menuEmpleado();
                        break;
                    case 3:
                        salir = true;
                        System.out.println("Usted a salido correctamente del programa");
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe insertar una opcion correcta");
                teclado.next();
            }
        }
    }

    /**
     * Metodo estatico privado que contiene el menu de empleado
     * @throws DniException error controlado
     * @throws PersistenciaException error controlado
     * @throws ClienteException error controlado
     * @throws VehiculoException error controlado
     * @throws DireccionException error controlado
     * @throws VentaException error controlado
     * @throws PersonaException error controlado
     */
    public static void menuEmpleado() throws ClienteException, PersistenciaException, DniException, VehiculoException, DireccionException, VentaException, PersonaException {
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("\n1. Realizar ventas");
            System.out.println("2. Gestionar clientes");
            System.out.println("3. Salir\n");

            try {
                System.out.print("Introduzca una de las opciones: ");
                opcion = teclado.nextInt();
                teclado.nextLine();
                System.out.println("");

                switch (opcion) {
                    case 1:
                        menuVentas();
                        break;
                    case 2:
                        menuClientes();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe insertar una opcion correcta");
                teclado.next();
            }
        }
    }

    /**
     * Metodo estatico privado que contiene el menu de gerente
     * @throws DniException error controlado
     * @throws PersistenciaException error controlado
     * @throws ClienteException error controlado
     * @throws EmpleadoException error controlado
     * @throws BastidorException error controlado
     * @throws VehiculoException error controlado
     * @throws DireccionException error controlado
     * @throws VentaException error controlado
     * @throws PersonaException error controlado
     */
    public static void menuGerente() throws ClienteException, PersistenciaException, DniException, EmpleadoException, VehiculoException, BastidorException, DireccionException, VentaException, PersonaException {
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("\n1. Realizar ventas");
            System.out.println("2. Gestionar clientes");
            System.out.println("3. Gestionar empleados");
            System.out.println("4. Gestionar vehiculos");
            System.out.println("5. Salir\n");

            try {
                System.out.print("Introduzca una de las opciones: ");
                opcion = teclado.nextInt();
                teclado.nextLine();
                System.out.println("");

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
     * @throws PersistenciaException error controlado
     * @throws VehiculoException error controlado
     * @throws VentaException error controlado
    */
    public static void menuVentas() throws PersistenciaException, VehiculoException, VentaException {
        boolean salir = false;
        int opcion;
        Vehiculo vehiculo;
        Venta venta;

        while (!salir) {
            System.out.println("\n1. Vender Vehiculo");
            System.out.println("2. Vehiculos vendidos");
            System.out.println("3. Listado de vehiculos");
            System.out.println("4. Salir\n");
            venta=null;
            vehiculo = null;
            try {
                System.out.print("Introduzca una de las opciones: ");
                opcion = teclado.nextInt();
                teclado.nextLine();
                System.out.println("");

                switch (opcion) {
                    case 1:
                        venta = pedirDatosVenta();
                        vehiculo = vehiculoController.buscar(venta.getBastidor());
                        vehiculo.setEstado("Vendido");
                        ventaController.insertar(venta);
                        vehiculoController.modificar(vehiculo);
                        System.out.println("Venta completada");
                        break;
                    case 2:
                        System.out.println("Lista vehiculos vendidos");
                        ArrayList<String> ventasAgrupadas = ventaController.agruparVentas();
                        for (String grupo : ventasAgrupadas) {
                            System.out.println(grupo);
                        }
                        break;
                    case 3:
                        System.out.println("Lista de vehiculos: ");
                        ArrayList<Vehiculo> vehiculos = vehiculoController.listadoVehiculos();
                        for (Vehiculo vehiculo2 : vehiculos) {
                            System.out.println(vehiculo2.toString());
                        }
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
     * @throws PersistenciaException error controlado
     * @throws ClienteException error controlado
     * @throws DniException error controlado
     * @throws DireccionException error controlado
     * @throws PersonaException error controlado
     */
    public static void menuClientes() throws ClienteException, PersistenciaException, DniException, DireccionException, PersonaException {
        boolean salir = false;
        int opcion;
        Cliente cliente;

        while (!salir) {
            System.out.println("\n1. Insertar nuevo cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Listado de clientes");
            System.out.println("5. Buscar cliente");
            System.out.println("6. Salir\n");
            cliente = null;
            String dni = null;

            try {
                System.out.print("Intrduzca una de las opciones: ");
                opcion = teclado.nextInt();
                teclado.nextLine();
                System.out.println("");

                switch (opcion) {
                    case 1:
                        cliente = generarDatosCliente(true);
                        clienteController.insertar(cliente);
                        System.out.println("\nCliente insertado");
                        break;
                    case 2:
                        System.out.println("Proceda a introducir los datos, el DNI debe mantenerse igual");
                        cliente = generarDatosCliente(false);
                        clienteController.modificar(cliente);
                        System.out.println("\nCliente modificado");
                        break;
                    case 3:
                        System.out.print("Introduzca el dni del cliente: ");
                        dni = teclado.nextLine();
                        validarDni(dni);
                        clienteController.eliminar(clienteController.buscar(dni));
                        System.out.println("\nCliente eliminado");
                        break;
                    case 4:
                        System.out.println("Lista de clientes: ");
                        ArrayList<Cliente> clientes = clienteController.listadoClientes();
                        for (Cliente cliente2 : clientes) {
                            System.out.println(cliente2.toString());
                        }
                        break;
                    case 5:
                        System.out.print("Introduzca el dni del cliente: ");
                        dni = teclado.next();
                        validarDni(dni);
                        cliente = clienteController.buscar(dni);
                        System.out.println(cliente.toString());
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
     * Metodo estatico que contiene el menu de gestion de empleados
     * @throws PersistenciaException error controlado
     * @throws EmpleadoException error controlado
     * @throws DniException error controlado
     * @throws DireccionException error controlado
     * @throws PersonaException error controlado
     */
    public static void menuEmpleados() throws EmpleadoException, PersistenciaException, DniException, DireccionException, PersonaException {
        boolean salir = false;
        int opcion;
        Empleado empleado;
        String dni=null;

        while (!salir) {
            System.out.println("\n1. Insertar empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Listado de empleados");
            System.out.println("5. Obtener datos empleado");
            System.out.println("6. Salir\n");
            empleado = null;

            try {

                System.out.print("Introduzca una de las opciones: ");
                opcion = teclado.nextInt();
                teclado.nextLine();
                System.out.println("");

                switch (opcion) {
                    case 1:
                        empleado = generarDatosEmpleado(true);
                        empleadoController.insertar(empleado);
                        System.out.println("\nEmpleado insertado");
                        break;
                    case 2:
                        System.out.println("Proceda a introducir los datos, el DNI debe mantenerse igual");
                        empleado = generarDatosEmpleado(false);
                        empleadoController.modificar(empleado);
                        System.out.println("\nCliente modificado");
                        break;
                    case 3:
                        System.out.print("Introduzca el dni del empleado: ");
                        dni = teclado.next();
                        validarDni(dni);
                        empleadoController.eliminar(empleadoController.buscar(dni));
                        System.out.println("\nEmpleado eliminado");
                        break;
                    case 4:
                        System.out.println("Lista de empleados: ");
                        ArrayList<Empleado> empleados = empleadoController.listadoEmpleados();
                        for (Empleado empleado2 : empleados) {
                            System.out.println(empleado2.toString());
                        }
                        break;
                    case 5:
                        System.out.print("Introduzca el dni del empleado: ");
                        dni = teclado.next();
                        validarDni(dni);
                        empleado = empleadoController.buscar(dni);
                        System.out.println(empleado.toString());
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
     * @throws PersistenciaException error controlado
     * @throws VehiculoException error controlado
     * @throws BastidorException error controlado
     * @throws DniException error controlado
     */
    public static void menuVehiculos() throws VehiculoException, PersistenciaException, DniException, BastidorException {
        boolean salir = false;
        int opcion;
        Vehiculo vehiculo;

        while (!salir) {
            System.out.println("\n1. Insertar vehiculo nuevo");
            System.out.println("2. Modificar vehiculo");
            System.out.println("3. Elimininar vehiculo");
            System.out.println("4. Listado de vehiculos");
            System.out.println("5. Salir\n");
            vehiculo = null;
            String bastidor=null;

            try {
                System.out.print("Introduzca una de las opciones: ");
                opcion = teclado.nextInt();
                teclado.nextLine();
                System.out.println("");
 
                switch (opcion) {
                    case 1:
                        vehiculo = generarDatosVehiculo();
                        vehiculoController.insertar(vehiculo);
                        System.out.println("\nVehiculo insertado");
                        break;
                    case 2:
                        System.out.println("Proceda a introducir los datos, el numero de bastidor debe mantenerse igual");
                        vehiculo = generarDatosVehiculo();
                        vehiculoController.modificar(vehiculo);
                        System.out.println("\nVehiculo modificado");
                        break;
                    case 3:
                        System.out.print("Introduzca el numero de bastidor del vehiculo: ");
                        bastidor = teclado.next();
                        validarBastidor(bastidor);
                        vehiculoController.eliminar(vehiculoController.buscar(bastidor));
                        System.out.println("\nVehiculo eliminado");
                        break;
                    case 4:
                        System.out.println("Lista de vehiculos: ");
                        ArrayList<Vehiculo> vehiculos = vehiculoController.listadoVehiculos();
                        for (Vehiculo vehiculo2 : vehiculos) {
                            System.out.println(vehiculo2.toString());
                        }
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
     * @throws VehiculoException error controlado
     */
    private static Vehiculo generarDatosVehiculo() throws VehiculoException{
        
        System.out.print("Introduzca el numero de bastidor: ");
        String bastidor = teclado.nextLine();

        System.out.print("Introduzca el valor de matricula: ");
        String matricula = teclado.nextLine();

        System.out.print("Introduzca la marca: ");
        String marca = teclado.nextLine();

        System.out.print("Introduzca el modelo: ");
        String modelo = teclado.nextLine();

        System.out.print("Introduzca el color: ");
        String color = teclado.nextLine();

        System.out.print("Introduzca la cilindrada: ");
        String cilindrada = teclado.nextLine();

        System.out.print("Introduzca el tipo de motor: ");
        String motor = teclado.nextLine();

        System.out.print("Introduzca la potencia: ");
        int potencia = Integer.parseInt(teclado.nextLine());

        System.out.print("Introduzca los extras instalados: ");
        String extras = teclado.nextLine();

        System.out.print("Introduzca el precio: ");
        double precio = teclado.nextDouble();

        System.out.print("Introduzca el tipo de vehiculo: ");
        String tipo = teclado.nextLine();

        System.out.print("Introduzca el estado del vehiculo: ");
        String estado = teclado.nextLine();

        Vehiculo vehiculo = new Vehiculo(bastidor, matricula, marca, modelo, color, precio, extras, motor, potencia, cilindrada, tipo, estado);
        vehiculoController.validarVehiculo(vehiculo);

        return vehiculo;
    }

    /**
     * Funcion privada encarga de generar clientes
     * @return un cliente
     * @throws ClienteException error controlado
     * @throws DireccionException error controlado
     */
    private static Cliente generarDatosCliente(boolean nuevo) throws ClienteException, DireccionException {
        String codigoCliente = null;

        if (!nuevo) {
            System.out.print("Introduzca el valor de el codigo de cliente: ");
            codigoCliente = teclado.nextLine();
        }

        System.out.print("Introduzca el valor de dni: ");
        String dni = teclado.nextLine();

        System.out.print("Introduzca el valor de nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Introduzca el valor de apellidos: ");
        String apellidos = teclado.nextLine();

        System.out.print("Introduzca el valor de fechaNacimiento: ");
        String fechaNacimiento = teclado.nextLine();

        System.out.print("Introduzca el valor de telefono: ");
        String telefono = teclado.nextLine();

        Cliente cliente = new Cliente(codigoCliente, nombre, apellidos, dni, fechaNacimiento, telefono, generarDatosDireccion(dni));
        clienteController.validarCliente(cliente);

        return cliente;
    }
    

    /**
     * Funcion privada encarga de generar empleados
     * @return un empleado
     * @throws EmpleadoException error controlado
     * @throws DireccionException error controlado
     */
    private static Empleado generarDatosEmpleado(boolean nuevo) throws EmpleadoException, DireccionException {
        String codigoEmpleado = null;

        if (!nuevo) {
            System.out.print("Introduzca el valor de el codigo del empleado ");
            codigoEmpleado = teclado.nextLine();
        }

        System.out.print("Introduzca el valor de dni: ");
        String dni = teclado.nextLine();

        System.out.print("Introduzca el valor de nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Introduzca el valor de apellidos: ");
        String apellidos = teclado.nextLine();

        System.out.print("Introduzca el valor de fechaNacimiento: ");
        String fechaNacimiento = teclado.nextLine();

        System.out.print("Introduzca el valor de telefono: ");
        String telefono = teclado.nextLine();

        System.out.print("Introduzca el rango del empleado: ");
        String rango = teclado.nextLine();

        System.out.print("Introduzca el valor de contraseña: ");
        String contrasenia = teclado.nextLine();

        Empleado empleado = new Empleado(codigoEmpleado, nombre, apellidos, dni, fechaNacimiento, telefono, generarDatosDireccion(dni), rango, contrasenia);
        empleadoController.validarEmpleado(empleado);

        return empleado;
    }

    /**
     * Funcion privada encarga de generar nuevas direcciones
     * @return una direccion
     * @throws DireccionException error controlado
     */
    private static Direccion generarDatosDireccion(String identificador) throws DireccionException{

        System.out.print("Introduzca el pais: ");
        String pais = teclado.nextLine();

        System.out.print("Introduzca la provincia: ");
        String provincia = teclado.nextLine();

        System.out.print("Introduzca la ciudad: ");
        String ciudad = teclado.nextLine();

        System.out.print("Introduzca la calle: ");
        String calle = teclado.nextLine();

        System.out.print("Introduzca el numero de la vivienda: ");
        int numero = Integer.parseInt(teclado.nextLine());

        System.out.print("Introduzca el codigo postal: ");
        String codigoPostal = teclado.nextLine();

        Direccion direccion = new Direccion(identificador, calle, numero, codigoPostal, provincia, ciudad, pais);
        direccionController.validarDireccion(direccion);

        return direccion;
    }

    /**
     * Metodo que pide los datos para generar una venta
     * @return venta creada
     * @throws VentaException error controlado
     */
    public static Venta pedirDatosVenta() throws VentaException {

        System.out.print("Introduzca el dni del empleado: ");
        String dniEmpleado = teclado.nextLine();

        System.out.print("Introduzca el dni del cliente: ");
        String dniCliente = teclado.nextLine();

        System.out.print("Introduzca el numero de bastidor del vehiculo: ");
        String bastidor = teclado.nextLine();

        Venta venta = new Venta(null, dniEmpleado, dniCliente, bastidor);
        ventaController.validarVenta(venta);

        return venta;

    }

    /**
     * Metodo que pide las credenciales de acceso
     * @param rango rango necesario para acceder al menu
     * @throws PersistenciaException error controlado
     * @throws EmpleadoException error controlado
     */
    public static void pedirCredenciales(int rango) throws PersistenciaException, EmpleadoException {

        System.out.print("Introduzca su dni: ");
        String dni = teclado.nextLine();

        System.out.print("Introduzca su contrsenia: ");
        String contrasenia = teclado.nextLine();

        empleadoController.comprobarCredenciales(rango, dni, contrasenia);
    }

    /**
     * Metodo privado que valida un dni
     * @param dni dni a validar 
     * @throws DniException error controlado
     */
    public static void validarDni(String dni) throws DniException {
        if (dni == null || dni.isEmpty()) {
            throw new DniException("Debe introducir un DNI");
        }
    }
    
    /**
     * Metodo privado que valida un bastidor 
     * @param bastidor a validar 
     * @throws BastidorException error controlado
     */
    public static void validarBastidor(String bastidor) throws BastidorException {
        if (bastidor == null || bastidor.isEmpty()) {
            throw new BastidorException("Debe introducir un numero de bastidor");
        }
    }





}
