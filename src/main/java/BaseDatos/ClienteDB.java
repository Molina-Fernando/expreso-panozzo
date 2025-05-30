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

    public boolean eliminarPorDni(String dni) {
        Connection conex = null;
        boolean eliminado = false;

        try {
            conex = Conexion.conectar();
            String query = "DELETE FROM clientes WHERE dni = ?";
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setString(1, dni);

            int filasAfectadas = ps.executeUpdate();
            eliminado = filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("EXCEP SQL" + e);
            JOptionPane.showMessageDialog(null, "¡Error al eliminar! Contacte al administrador");
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

        return eliminado;
    }
    
    public boolean modificarClientePorDni(String dni, String nombre, String domicilio, String localidad, int telefono) {
    Connection conex = null;
    boolean modificado = false;

    try {
        conex = Conexion.conectar();
        String query = "UPDATE clientes SET nombre = ?, domicilio = ?, localidad = ?, telefono = ? WHERE dni = ?";
        PreparedStatement ps = conex.prepareStatement(query);
        ps.setString(1, nombre);
        ps.setString(2, domicilio);
        ps.setString(3, localidad);
        ps.setInt(4, telefono);
        ps.setString(5, dni);

        int filasAfectadas = ps.executeUpdate();
        modificado = filasAfectadas > 0;

    } catch (SQLException e) {
        System.out.println("EXCEP SQL" + e);
        JOptionPane.showMessageDialog(null, "¡Error al modificar! Contacte al administrador");
        e.printStackTrace();
    } finally {
        try {
            if (conex != null) conex.close();
        } catch (SQLException excSql) {
            System.err.println("ERROR SQL" + excSql);
        }
    }

    return modificado;
    }
       
    public static ArrayList<String> obtenerLocalidades() {
        ArrayList<String> localidades = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT DISTINCT localidad FROM clientes ORDER BY localidad";
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                localidades.add(rs.getString("localidad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener localidades: " + e);
        } finally {
            try {
                if (conex != null) conex.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return localidades;
    }


}

