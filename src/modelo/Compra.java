package modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Compra {
    private int idCompra;
    private Date fecha;
    private double monto;
    private Proveedor prov;
    private int cantidad;
    private ArrayList <Producto> pds = new ArrayList <Producto> () ;

    public Compra(int idCompra,int cantidad,Date fecha, double monto, Proveedor prov, ArrayList <Producto> pds) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.monto = monto;
        this.prov = prov;
        this.pds = pds;
        this.cantidad = cantidad;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Proveedor getProv() {
        return prov;
    }

    public void setProv(Proveedor prov) {
        this.prov = prov;
    }

    public ArrayList<Producto> getPds() {
        return pds;
    }

    public void setPds(ArrayList<Producto> pds) {
        this.pds = pds;
    }
    /* Metodo comentado para que no ocacione errores
    public File consultarDesglose(){
        
    }
    */
    
    
}
