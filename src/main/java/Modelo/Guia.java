package Modelo;
import Modelo.Cliente;
import Modelo.Localidad;
import java.time.LocalDate;
import java.util.ArrayList;

public class Guia {
    
    private int id;
    private double seguro;
    private double flete;
    private double recargo;
    private double valorDeclarado;
    private double contrareembolso;
    private LocalDate fecha;
    private Cliente remitente;  
    private Cliente destinatario;
    private Localidad localidadRemitente;
    private Localidad localidadDestinatario; 
    private ArrayList<Contenido> listaContenido;
    
    
    public Guia() {
    }

    public double getSeguro() {
        return seguro;
    }

    public void setSeguro(double seguro) {
        this.seguro = seguro;
    }

    public double getFlete() {
        return flete;
    }

    public void setFlete(double flete) {
        this.flete = flete;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public double getContrareembolso() {
        return contrareembolso;
    }

    public void setContrareembolso(double contrareembolso) {
        this.contrareembolso = contrareembolso;
    }

    public Cliente getRemitente() {
        return remitente;
    }

    public void setRemitente(Cliente remitente) {
        this.remitente = remitente;
    }

    public Cliente getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Cliente destinatario) {
        this.destinatario = destinatario;
    }

    public Localidad getLocalidadRemitente() {
        return localidadRemitente;
    }

    public void setLocalidadRemitente(Localidad localidadRemitente) {
        this.localidadRemitente = localidadRemitente;
    }

    public Localidad getLocalidadDestinatario() {
        return localidadDestinatario;
    }

    public void setLocalidadDestinatario(Localidad localidadDestinatario) {
        this.localidadDestinatario = localidadDestinatario;
    }

    public ArrayList<Contenido> getListaContenido() {
        return listaContenido;
    }

    public void setListaContenido(ArrayList<Contenido> listaContenido) {
        this.listaContenido = listaContenido;
    }
    
}
