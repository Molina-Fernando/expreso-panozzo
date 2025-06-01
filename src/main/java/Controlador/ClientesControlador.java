
package Controlador;

import BaseDatos.ClienteDB;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago
 */
public class ClientesControlador {

    public ArrayList<Object[]> getTablaClientes() {
            return new ClienteDB().getClientes();
    }

    public DefaultTableModel buscarClientesPorNombre(String nombre) {
    String[] columnas = {"DNI", "Nombre", "Domicilio", "Localidad", "Teléfono"};
    DefaultTableModel modelo = new DefaultTableModel(null, columnas);
    ClienteDB cdb = new ClienteDB();
    for (Object[] fila : cdb.buscarClientesPorNombre(nombre)) {
        modelo.addRow(fila);
    }
    return modelo;
}

    public boolean eliminarClientePorDni(String dni) {
        return new ClienteDB().eliminarPorDni(dni); // true si se elimina, false si no se encuentra o falla
    }
    
    public static boolean actualizarCliente(String dni, String nombre, String domicilio, String localidad, String telefono) {
        return new ClienteDB().modificarClientePorDni(dni, nombre, domicilio, localidad, telefono);
    }
    
    public ArrayList<String> traerLocalidades() {
        return new ClienteDB().obtenerLocalidades();
    }
    
    public static boolean crearCliente(String dni, String nombre, String domicilio, String localidad, String telefono){
        return new ClienteDB().agregarCliente(dni, nombre, domicilio, localidad, telefono);
    }
}
