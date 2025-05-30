package Controlador;

import BaseDatos.ClienteDB;
import BaseDatos.GuiaDB;
import java.util.ArrayList;

public class GuiaControlador {
    
//    GuiaDB guiaDB = new GuiaDB();
    
        public ArrayList buscarDNI(String dni){        
           return new GuiaDB().buscarDNI(dni);
    }
    
        public ArrayList<String> traerLocalidades() {
        return new GuiaDB().obtenerLocalidades();
    }
    
}
