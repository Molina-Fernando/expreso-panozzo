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
 * @author joaqu
 */
public class ConsultaGuiaDB {

    public ArrayList<Object[]> getDatos() {
        ArrayList<Object[]> listaDatosVista = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT g.idguias, g.fecha, g.remitente_localidad, g.destinatario_localidad, " +
                           "cr.nombre AS remitente, cd.nombre AS destinatario, g.seguro, g.flete, " +
                           "g.recargo, g.valor_declarado, g.contrareembolso " +
                           "FROM guias g " +
                           "JOIN clientes cr ON g.remitente_dni = cr.dni " +
                           "JOIN clientes cd ON g.destinatario_dni = cd.dni";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[11];
                ob[0] = rs.getString("idguias");
                ob[1] = rs.getString("fecha");
                ob[2] = rs.getString("remitente_localidad");
                ob[3] = rs.getString("destinatario_localidad");
                ob[4] = rs.getString("remitente");
                ob[5] = rs.getString("destinatario");
                ob[6] = rs.getString("seguro");
                ob[7] = rs.getString("flete");
                ob[8] = rs.getString("recargo");
                ob[9] = rs.getString("valor_declarado");
                ob[10] = rs.getString("contrareembolso");
                listaDatosVista.add(ob);
            }
        } catch (SQLException e) {
            System.out.println("EXCEP SQL: " + e);
            JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException excSql) {
                System.err.println("ERROR SQL: " + excSql);
            }
        }
        return listaDatosVista;
    }



    public ArrayList<Object[]> buscarGuia(String numeroGuia) { 
        ArrayList<Object[]> listaDatosVista = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT g.idguias, g.fecha, g.remitente_localidad, g.destinatario_localidad, " +
                           "cr.nombre AS remitente, cd.nombre AS destinatario, g.seguro, g.flete, " +
                           "g.recargo, g.valor_declarado, g.contrareembolso " +
                           "FROM guias g " +
                           "JOIN clientes cr ON g.remitente_dni = cr.dni " +
                           "JOIN clientes cd ON g.destinatario_dni = cd.dni " +
                           "WHERE g.idguias = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, numeroGuia);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object[] ob = new Object[11];
                ob[0] = rs.getString("idguias");
                ob[1] = rs.getString("fecha");
                ob[2] = rs.getString("remitente_localidad");
                ob[3] = rs.getString("destinatario_localidad");
                ob[4] = rs.getString("remitente");
                ob[5] = rs.getString("destinatario");
                ob[6] = rs.getString("seguro");
                ob[7] = rs.getString("flete");
                ob[8] = rs.getString("recargo");
                ob[9] = rs.getString("valor_declarado");
                ob[10] = rs.getString("contrareembolso");
                listaDatosVista.add(ob);
            }
        } catch (SQLException e) {
            System.out.println("EXCEP SQL: " + e);
            JOptionPane.showMessageDialog(null, "¡Error al buscar la guía! Contacte al administrador");
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException excSql) {
                System.err.println("ERROR SQL: " + excSql);
            }
        }
        return listaDatosVista;
    }

    public ArrayList<Object[]> getGuiasOrdenadasPor(String criterio) {
        ArrayList<Object[]> listaDatosVista = new ArrayList<>();
        Connection conex = null;

        // Mapeo del criterio a la columna SQL
        String columnaOrden = switch (criterio) {
            case "Nº Guía" -> "g.idguias";
            case "Fecha" -> "SUBSTR(g.fecha, 7, 4) DESC, SUBSTR(g.fecha, 4, 2) DESC, SUBSTR(g.fecha, 1, 2) DESC";
            case "Origen" -> "g.remitente_localidad";
            case "Destino" -> "g.destinatario_localidad";
            case "Remitente" -> "c1.nombre"; // tabla clientes, alias c1
            case "Destinatario" -> "c2.nombre"; // tabla clientes, alias c2
            default -> "g.idguias";
        };

        try {
            conex = Conexion.conectar();
            String query = """
                SELECT 
                    g.idguias, 
                    g.fecha, 
                    g.remitente_localidad, 
                    g.destinatario_localidad, 
                    c1.nombre AS remitente, 
                    c2.nombre AS destinatario, 
                    g.seguro, 
                    g.flete, 
                    g.recargo, 
                    g.valor_declarado, 
                    g.contrareembolso
                FROM 
                    guias g
                INNER JOIN 
                    clientes c1 ON g.remitente_dni = c1.dni
                INNER JOIN 
                    clientes c2 ON g.destinatario_dni = c2.dni
                ORDER BY """ +" "+ columnaOrden;

            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                Object[] ob = new Object[11];
                ob[0] = rs.getString("idguias");
                ob[1] = rs.getString("fecha");
                ob[2] = rs.getString("remitente_localidad");
                ob[3] = rs.getString("destinatario_localidad");
                ob[4] = rs.getString("remitente");
                ob[5] = rs.getString("destinatario");
                ob[6] = rs.getString("seguro");
                ob[7] = rs.getString("flete");
                ob[8] = rs.getString("recargo");
                ob[9] = rs.getString("valor_declarado");
                ob[10] = rs.getString("contrareembolso");
                listaDatosVista.add(ob);
            }
        } catch (SQLException e) {
            System.out.println("EXCEP SQL: " + e);
            JOptionPane.showMessageDialog(null, "¡Error al ordenar las guías! Contacte al administrador.");
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException excSql) {
                System.err.println("ERROR SQL (cerrando): " + excSql);
            }
        }

        return listaDatosVista;
    }

    
}
