package es.iespuertodelacruz.concesionario.api;
/**
 * Clase Persona  que contiene las carateristicas de una persona
 */
public class Persona {
    String nombre;
    String apellidos;
    String dni;
    String fechaNacimiento;
    String telefono;
    Direccion direccion;


    /**
     * Constructor vacio de la clase Persona
     */
    public Persona() {
    }

    /**
     * Constructor de persona con parametros 
     * @param nombre nombre del cliente
     * @param apellidos apellidos del cliente
     * @param dni dni del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param telefono teledono del cliente
     * @param direccion objeto direccion
     */
    public Persona(String nombre, String apellidos, String dni, 
    String fechaNacimiento, String telefono, Direccion direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    
    /**
     * Getter de la clase Persona
     * @return nombre de la persona
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter de la clase Persona
     * @param nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la clase Persona
     * @return apellidos de la persona
     */
    public String getApellidos() {
        return this.apellidos;
    }
    
    /**
     * Setter de la clase Persona
     * @param apellidos de la persona
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Getter de la clase Persona
     * @return dni de la persona
     */
    public String getDni() {
        return this.dni;
    }
    
    /**
     * Setter de la clase Persona
     * @param dni de la persona
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Getter de la clase Persona
     * @return fecha de nacimiento de la persona
     */
    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    /**
     * Setter de la clase Persona
     * @param fechaNacimiento de la persona
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Getter de la clase Persona
     * @return telefono de la persona
     */
    public String getTelefono() {
        return this.telefono;
    }
    
    /**
     * Setter de la clase Persona
     * @param telefono de la persona
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Getter de la clase Persona
     * @return direccion de la persona
     */
    public Direccion getDireccion() {
        return this.direccion;
    }
    
    
    /**
     * Setter de la clase Persona
     * @param direccion de la persona
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


    /**
     * Funcion toString de la clase Persona
     */
    @Override
    public String toString() {
        return getNombre() + "," +getApellidos() + "," +getDni() + "," +
            getFechaNacimiento() + "," + getTelefono() + "," +getDireccion();
          
    }

}
