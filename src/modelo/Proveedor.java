package modelo;

public class Proveedor {
    private int id;
    private String compania;
    private String direccion;
    private long telefono;

    public Proveedor(int id, String compania, String direccion, long telefono) {
        this.id = id;
        this.compania = compania;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Proveedor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
    public void surtir(Producto[] prod []){
        
    }
    
}
