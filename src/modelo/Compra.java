package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Compra {
    private Date fecha;
    private double monto;
    private Proveedor prov;
    private ArrayList <Producto> pds = new ArrayList <Producto> () ;

    public Compra(Date fecha, double monto, Proveedor prov, ArrayList <Producto> pds) {
        this.fecha = fecha;
        this.monto = monto;
        this.prov = prov;
        this.pds = pds;
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
    
    
    
    
    
}
