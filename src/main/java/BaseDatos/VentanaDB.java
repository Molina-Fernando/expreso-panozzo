/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author defer
 */
public class VentanaDB {
    
     public void cargaCiudad(String nombreCiudad) {

        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String insert = "INSERT INTO localidades (Nombre) values (?)";
            
            PreparedStatement psi = conex.prepareStatement(insert);
            
            psi.setString(1, nombreCiudad);
            
            psi.executeUpdate();
                       
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
    
}
