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
    
    public boolean emitirGuia(
            String costoSeguro, 
            String costoFlete, 
            String recargo, 
            String valor_declarado, 
            String contrareembolso, 
            String remitente_dni, 
            String destinatario_dni, 
            String remitente_localidad, 
            String destinatario_localidad){
        
        return new GuiaDB().emitirGuia(costoSeguro, costoFlete, recargo, valor_declarado, contrareembolso, remitente_dni, destinatario_dni, remitente_localidad, destinatario_localidad);
    }
}
