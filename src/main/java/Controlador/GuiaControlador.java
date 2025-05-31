package Controlador;

import BaseDatos.GuiaDB;
import java.util.ArrayList;

public class GuiaControlador {

//    GuiaDB guiaDB = new GuiaDB();
    public ArrayList buscarDNI(String dni) {
        return new GuiaDB().buscarDNI(dni);
    }

    public ArrayList<String> traerLocalidades() {
        return new GuiaDB().obtenerLocalidades();
    }
        public boolean registrarCliente(String dni, String nombre, String domicilio, String telefono, String localidad){
            return new GuiaDB().registrarCliente(dni, nombre, domicilio, telefono, localidad);
        }
    
    public ArrayList<String> traerTipo() {
        return new GuiaDB().obtenerTipo();
    }
}
