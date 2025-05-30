
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

}
