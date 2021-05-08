package es.iespuertodelacruz.concesionario;

import es.iespuertodelacruz.concesionario.exception.BbddException;
import es.iespuertodelacruz.concesionario.modelo.CrearBbdd;

public class main {
    public static void main(String[] args) throws BbddException {
        CrearBbdd bbdd;
        bbdd = new CrearBbdd("org.sqlite.JDBC", "jdbc:sqlite:test.db", "", "");

        System.out.println(bbdd.crearCliente());

    }
}
