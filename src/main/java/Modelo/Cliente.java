package Modelo;

public class Cliente {
    
    private int dni;
    private String nombre;
    private String domicilio;
    private String teléfono;
    private Localidad localidad; 

    public Cliente() {
    }
        
    public Cliente(int dni, String nombre, String domicilio, String teléfono, Localidad localidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.teléfono = teléfono;
        this.localidad = localidad;
    }

    public int getId() {
        return dni;
    }

    public void setId(int id) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
    
}
