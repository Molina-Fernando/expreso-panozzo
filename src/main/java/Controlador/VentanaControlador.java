/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BaseDatos.VentanaDB;


/**
 *
 * @author defer
 */
public class VentanaControlador {
    VentanaDB db = new VentanaDB();

    public void cargarCiudad(String city){
        
        db.cargaCiudad(city);
    }
}
