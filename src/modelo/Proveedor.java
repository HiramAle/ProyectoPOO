package modelo;

public class Proveedor {
    private String compania;
    private String direccion;
    private long telefono;

    public Proveedor(String compania, String direccion, long telefono) {
        this.compania = compania;
        this.direccion = direccion;
        this.telefono = telefono;
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
    
}
