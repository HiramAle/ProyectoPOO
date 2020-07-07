package modelo;

public class Producto {
    private int id;
    private String marca;
    private String descripcion;
    private double precioCompra;
    private double precioVentaMenudeo;
    private double precioVentaMayoreo;
    private Proveedor proveedor;
    private int existencias;

    public Producto(int id, String marca, String descripcion, double precioCompra, double precioVentaMenudeo, double precioVentaMayoreo, Proveedor proveedor, int existencias) {
        this.id = id;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVentaMenudeo = precioVentaMenudeo;
        this.precioVentaMayoreo = precioVentaMayoreo;
        this.proveedor = proveedor;
        this.existencias = existencias;
    }

    public Producto() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVentaMenudeo() {
        return precioVentaMenudeo;
    }

    public void setPrecioVentaMenudeo(double precioVentaMenudeo) {
        this.precioVentaMenudeo = precioVentaMenudeo;
    }

    public double getPrecioVentaMayoreo() {
        return precioVentaMayoreo;
    }

    public void setPrecioVentaMayoreo(double precioVentaMayoreo) {
        this.precioVentaMayoreo = precioVentaMayoreo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    
    
    
    public int verExistencias(){
        return getExistencias();
    }
    
    
}
