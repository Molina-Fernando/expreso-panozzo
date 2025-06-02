/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author defer
 */
public class GuiaDB {

    public ArrayList<String> resultadosConsulta = new ArrayList();

    public ArrayList buscarDNI(String dni) {
        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String query = "SELECT * FROM clientes WHERE DNI = ?";

            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dni);
            ResultSet rs = psq.executeQuery();

            if (rs.next()) {

//                // Obtener la cantidad de columnas
//                ResultSetMetaData metaData = rs.getMetaData();
//                int columnas = metaData.getColumnCount();
//
//                // Recorrer dinámicamente las columnas y agregarlas a la lista
//                for (int i = 1; i <= columnas; i++) {
//                    resultadosConsulta.add(rs.getString(i));
//                }
                resultadosConsulta.add(rs.getString(1));
                resultadosConsulta.add(rs.getString(2));
                resultadosConsulta.add(rs.getString(3));
                resultadosConsulta.add(rs.getString(4));
                resultadosConsulta.add(rs.getString(5));

                //System.out.println(resultadosConsulta);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "---");
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException excSql) {
                System.err.println("ERROR SQL" + excSql);
            }
        }
        return resultadosConsulta;
    }

    public static ArrayList<String> obtenerLocalidades() {
        ArrayList<String> localidades = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT nombre FROM localidades";
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                localidades.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener localidades: " + e);
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return localidades;
    }

    public boolean registrarCliente(String dni, String nombre, String domicilio, String telefono, String localidad) {

        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String insertCliente = "INSERT INTO clientes(dni, nombre, domicilio, localidad, telefono) VALUES(?,?,?,?,?);";

            PreparedStatement psi = conex.prepareStatement(insertCliente);

            psi.setString(1, dni);
            psi.setString(2, nombre);
            psi.setString(3, domicilio);
            psi.setString(4, localidad);
            psi.setString(5, telefono);

            psi.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("EXCEP SQL" + e);
            JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException excSql) {
                System.err.println("ERROR SQL" + excSql);
            }
        }
        return false;
    }
    public static ArrayList<String> obtenerTipo() {
        ArrayList<String> nombreTipo = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT nombre FROM tipo_envio";
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nombreTipo.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener localidades: " + e);
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nombreTipo;
    }

    public boolean emitirGuia(String fecha,
            String costoSeguro,
            String costoFlete,
            String recargo,
            String valor_declarado,
            String contrareembolso,
            String remitente_dni,
            String destinatario_dni,
            String remitente_localidad,
            String destinatario_localidad) {

        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String insertGuia = "INSERT INTO guias"
                    + "(fecha, seguro, flete, recargo, valor_declarado, contrareembolso, remitente_dni, destinatario_dni, remitente_localidad, destinatario_localidad) "
                    + "VALUES(?,?,?,?,?, ?, ?, ?, ?, ?);";

            PreparedStatement psi = conex.prepareStatement(insertGuia);
            
            psi.setString(1,fecha);
            psi.setFloat(2, Float.parseFloat(costoSeguro));
            psi.setFloat(3, Float.parseFloat(costoFlete));
            psi.setFloat(4, Float.parseFloat(recargo));
            psi.setFloat(5, Float.parseFloat(valor_declarado));
            psi.setFloat(6, Float.parseFloat(contrareembolso));
            psi.setString(7, remitente_dni);
            psi.setString(8, destinatario_dni);
            psi.setString(9, remitente_localidad);
            psi.setString(10, destinatario_localidad);

            psi.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("EXCEP SQL" + e);
            JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException excSql) {
                System.err.println("ERROR SQL" + excSql);
            }
        }

        return false;
    }

}

//                 for(String  item : resultadosConsulta) {
//                     resultadosConsulta.add(rs.getString(1));
//                 }
