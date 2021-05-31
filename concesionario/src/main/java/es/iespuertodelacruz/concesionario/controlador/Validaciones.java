package es.iespuertodelacruz.concesionario.controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase Validaciones
 */
public class Validaciones {
    private String patronDni = "^[0-9]{8}[A-Z-a-z]";
    private String patronCodigoPostal = "[0-9]{5}$";
    private String patronBastidor = "^[A-Z-a-z-0-9]{17}";

    Pattern pattern;
    Matcher matcher;

    
    /**
     * Funcion que evalua si un dni es valido
     * @param valor a evaluar
     * @return true/false en funcion si es correcto o no
     */
    public boolean validarDni(String valor) {
        boolean resultado = false;

        this.pattern = Pattern.compile(patronDni);
        this.matcher = pattern.matcher(valor);
        resultado = matcher.find();

        return resultado;
    }

    /**
     * Funcion que evalua si un Codigo Postal es valido
     * @param valor a evaluar
     * @return true/false en funcion de si es correcto o no
     */
    public boolean validarCodigoPostal(String valor) {
        boolean resultado = false;
        this.pattern = Pattern.compile(patronCodigoPostal);
        this.matcher = pattern.matcher(valor);
        resultado = matcher.find();
        return resultado;
    }

    /**
     * Funcion que evalua si un numero de bastidor es valido
     * @param valor a evaluar
     * @return true/false en funcion de si es correcto o no
     */
    public boolean validarBastidor(String valor) {
        boolean resultado = false;
        this.pattern = Pattern.compile(patronBastidor);
        this.matcher = pattern.matcher(valor);
        resultado = matcher.find();
        return resultado;
    }
    
}
