package modelo;

public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private int telefono;
    private String servicio;
    private String estado;

    public Cliente() {
    }

    public Cliente(String nombre, String direccion, int telefono, String servicio, String estado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.servicio = servicio;
        this.estado = estado;
    }

    public Cliente(int id, String nombre, String direccion, int telefono, String servicio, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.servicio = servicio;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
