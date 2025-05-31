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
import java.lang.Object;

/**
 *
 * @author Jeremías
 */
public class ConfiguracionDB {
        public void actualizarCostos(double costoTipo1, double costoTipo2, double costoTipo3) {

        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String updateCosto = "UPDATE tipo_envio SET costo = ? WHERE idtipo_envio = ?";

            PreparedStatement ps = conex.prepareStatement(updateCosto);

            ps.setDouble(1, costoTipo1);
            ps.setInt(2, 1);
            ps.executeUpdate();

            // Actualiza el tipo 2
            ps.setDouble(1, costoTipo2);
            ps.setInt(2, 2);
            ps.executeUpdate();

            // Actualiza el tipo 3
            ps.setDouble(1, costoTipo3);
            ps.setInt(2, 3);
            ps.executeUpdate();

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

    }
    
     public static ArrayList<Double> obtenerCostos() {
        ArrayList<Double> costos = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT costo FROM tipo_envio";
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                costos.add(rs.getDouble("costo"));
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
        return costos;
    }
     
     public static ArrayList<Object[]> obtenerLocalidades() {
        ArrayList<Object[]> localidades = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            
            String query = "SELECT nombre FROM localidades";
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[1];
                fila[0] = rs.getString("nombre");
                 localidades.add(fila);
                 
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
     
     
        public static boolean agregarLocalidad(String localidad) {
        
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            
            String insert = "INSERT INTO localidades (Nombre) VALUES (?)";
            PreparedStatement psi = conex.prepareStatement(insert);
           
            psi.setString(1, localidad);
            psi.executeUpdate();
            System.out.println("ACA LLEGO");
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al cargar localidad: " + e);
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
     }
}


