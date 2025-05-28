package Modelo;

public class Contenido {
    private int id;
    private int cantidad;
    private String descripcion;
    private float peso;
   // private Guia guia;
    private TipoEnvio tipoEnvio;

    public Contenido() {
    }
    
    public Contenido(int cantidad, String descripcion, float peso, TipoEnvio tipoEnvio) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.peso = peso;
     //   this.guia = guia;
        this.tipoEnvio = tipoEnvio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public TipoEnvio getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(TipoEnvio tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }
    
    

}
