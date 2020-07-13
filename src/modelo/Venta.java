package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Venta {
    //Declaracion de Variables
    private java.util.Date fecha;
    private double monto;
    private Cliente cli;
    //private Producto pds[]; 
    private Vendedor ven;
    private Proveedor prov;
    //Copia de Compras
    private int cantidad;
    private ArrayList <Producto> pds = new ArrayList <Producto> () ;
    private int idVenta;
    

    public Venta(int idVenta,int cantidad,java.util.Date fecha, double monto, Proveedor prov, ArrayList <Producto> pds){
        this.idVenta=idVenta;
        this.cantidad=cantidad;
        this.fecha=fecha;
        this.monto=monto;
        this.prov=prov;
        this.pds=pds;
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

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Vendedor getVen() {
        return ven;
    }

    public void setVen(Vendedor ven) {
        this.ven = ven;
    }

    public Proveedor getProv() {
        return prov;
    }

    public void setProv(Proveedor prov) {
        this.prov = prov;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Producto> getPds() {
        return pds;
    }

    public void setPds(ArrayList<Producto> pds) {
        this.pds = pds;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    
    
    
    /* Metodo comentado para que no ocasione errores
    public File consultarDesglose(){
        
        return null;
    }
    */
}