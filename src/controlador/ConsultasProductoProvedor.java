/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Compra;

/**
 *
 * @author Ale
 */
public class ConsultasProductoProvedor {
    //Variables para la consulta y conexion de la base de datos
    private PreparedStatement pstmt;
    private ResultSet resultado;
    private Connection con;
    private ConexionBD objBD;
    
    //Variables para el mapeo
    private Producto producto;
    private Proveedor proveedor;

    public ConsultasProductoProvedor() {
        objBD= ConexionBD.getInstance();
        objBD.conectar();
        con = objBD.getConexion();
    }    
    
    //mapeo Proveedor
    public void mapProveedor() throws SQLException{
        resultado.next();
        int id = resultado.getInt("id_provedor");
        String compania = resultado.getString("compania");
        String direccion = resultado.getString("direccion");
        long telefono = resultado.getLong("telefono");
    }
    
    //mapeo Producto
    public void mapProducto() throws SQLException {
        resultado.next();
        int id = resultado.getInt("id_producto");
        String marca = resultado.getString("marca");
        String descripcion = resultado.getString("descripcion");
        String precioCompra = resultado.getString("precioCompra");
        double precioVentaMenudeo = resultado.getDouble("precioVentaMenudeo");
        double precioVentaMayoreo = resultado.getDouble("precioVentaMayoreo");
        int existencias = resultado.getInt("existencias");
        
        //producto = new Producto(id, marca, descripcion, precioCompra, precioVentaMenudeo, precioVentaMayoreo, proveedor, existencias);
    }
    
    //Consulta Producto 
    
     
    
}
