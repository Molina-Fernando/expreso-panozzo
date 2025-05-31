/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BaseDatos.ConfiguracionDB;
import java.util.ArrayList;

/**
 *
 * @author Jeremías
 */
public class ConfiguracionControlador {
    
        public void actualizarCostos(double costoTipo1, double costoTipo2, double costoTipo3){
        new ConfiguracionDB().actualizarCostos(costoTipo1,costoTipo2, costoTipo3);
    }
    
    
    public ArrayList<Double> traerCostos() {
        return new ConfiguracionDB().obtenerCostos();
    }
}
