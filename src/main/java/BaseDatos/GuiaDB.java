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
    
    public ArrayList <String> resultadosConsulta = new ArrayList(); 
    
    public ArrayList buscarDNI(String dni){
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
                if (conex != null) conex.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return localidades;
    }
    

}


//                 for(String  item : resultadosConsulta) {
//                     resultadosConsulta.add(rs.getString(1));
//                 }