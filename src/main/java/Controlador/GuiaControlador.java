package Controlador;

import BaseDatos.GuiaDB;
import java.util.ArrayList;

public class GuiaControlador {
    
    GuiaDB guiaDB;
    
    
    public ArrayList buscarDNI(String dni){        
           return  guiaDB.buscarDNI(dni);
    }
}

