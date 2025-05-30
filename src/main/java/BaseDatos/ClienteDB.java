/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class ClienteDB {
    
    public ArrayList<Object[]> getClientes() {
        ArrayList<Object[]> listaClientes = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT * FROM clientes ORDER BY nombre";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[5];
                ob[0] = rs.getString("dni");
                ob[1] = rs.getString("nombre");
                ob[2] = rs.getString("domicilio");
                ob[3] = rs.getString("localidad");
                ob[4] = rs.getString("telefono");
                listaClientes.add(ob);
            }
        } catch (SQLException e) {
            System.out.println("EXCEP SQL" + e);
            JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
            //JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage());
            //e.printStackTrace();
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException excSql) {
                System.err.println("ERROR SQL" + excSql);
                //JOptionPane.showMessageDialog(null, "Error SQL: " + excSql.getMessage());
            }
        }
        return listaClientes;
    }
    
    public ArrayList<Object[]> buscarClientesPorNombre(String nombreBuscado) {
    ArrayList<Object[]> listaClientes = new ArrayList<>();
    Connection conex = null;
    try {
        conex = Conexion.conectar();
        String query = "SELECT * FROM clientes WHERE nombre LIKE ? ORDER BY nombre";
        PreparedStatement psq = conex.prepareStatement(query);
        psq.setString(1, "%" + nombreBuscado + "%"); // búsqueda parcial
        ResultSet rs = psq.executeQuery();
        while (rs.next()) {
            Object ob[] = new Object[5];
            ob[0] = rs.getString("dni");
            ob[1] = rs.getString("nombre");
            ob[2] = rs.getString("domicilio");
            ob[3] = rs.getString("localidad");
            ob[4] = rs.getString("telefono");
            listaClientes.add(ob);
        }
    } catch (SQLException e) {
        System.out.println("EXCEP SQL" + e);
        JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
        e.printStackTrace();
    } finally {
        try {
            if (conex != null) {
                conex.close();
            }
        } catch (SQLException excSql) {
            System.err.println("ERROR SQL" + excSql);
        }
    }
    return listaClientes;
}

}
