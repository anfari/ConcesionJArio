package es.iespuertodelacruz.concesionario;

import es.iespuertodelacruz.concesionario.api.Cliente;
import es.iespuertodelacruz.concesionario.api.Direccion;
/**
 * Clase utilidades, donde contiene objetos con datos por defectos
 */
public class Utilidades {
      /**
     * Funcion privada encargada de generar personas
     * @return devuelve una persona
     */
    public Cliente generarCliente(String codigoCliente,String apellidos,String dni, String nombre, String fechaNacimineto,Direccion direccion, String telefono){
        Cliente cliente=null;
        if(codigoCliente!=null && nombre!=null && apellidos!=null && dni!=null && fechaNacimineto!=null && direccion!=null && telefono!=null){
            cliente= new Cliente(codigoCliente, nombre, apellidos, dni, fechaNacimineto, telefono, direccion);
        }else{
            cliente= new Cliente();
            cliente.setNombre("Marcelino");
            cliente.setApellidos("Pan y vino");
            cliente.setDni("34212345R");
            cliente.setFechaNacimiento("02/01/2007");
            cliente.setTelefono("9821576958");;
            cliente.setDireccion(generarDireccion(null, null, 0, null, null, null, null));
            cliente.setCodigoCliente("QW123");
        }
        return cliente;
    }
    /**
     * Funcion privada encargada de generar direcciones de personas
     */
    public Direccion generarDireccion(String identificador, String calle, int numero,
     String codigoPostal, String provincia, String ciudad, String pais){
        Direccion direccion= null;
        if(identificador!=null && calle!=null && numero<=0 && codigoPostal!=null &&
        provincia!=null && ciudad!=null && pais!=null){

        }else{
            direccion= new Direccion();
            direccion.setCalle("Hawai");
            direccion.setCiudad("Mauritania");
            direccion.setCodigoPostal("34546");
            direccion.setPais("Japón");
            direccion.setProvincia("STA cruz de Tenerife");
            direccion.setIdentificador("34212345R");
            direccion.setNumero(23);
        }
        return direccion;
    }
}
