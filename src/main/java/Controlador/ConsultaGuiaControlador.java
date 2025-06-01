
package Controlador;

import BaseDatos.ConsultaGuiaDB;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaqu
 */
public class ConsultaGuiaControlador {

    public ArrayList<Object[]> getDatosVista() {
        return new ConsultaGuiaDB().getDatos();
    }

    public DefaultTableModel buscarDatosAsociados(String numeroGuia) {
        String[] columnas = {"Nº Guía", "Fecha","DNI","Origen","Destino","Remitente","Destinatario","Seguro","Flete","Recargo","Valor Declarado","Contrareembolso"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        
        for (Object[] fila : new ConsultaGuiaDB().buscarGuia(numeroGuia)) {
            modelo.addRow(fila);
        }
        return modelo;
    }
    
}
