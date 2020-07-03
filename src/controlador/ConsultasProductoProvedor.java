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
import javax.swing.JOptionPane;
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
        String compania = resultado.getString("compañia");
        String direccion = resultado.getString("direccion");
        long telefono = resultado.getLong("telefono");
        proveedor = new Proveedor(id, compania, direccion, telefono);
    }
    
    //Consulta Proveedor
    public Proveedor consultaProveedor(int id){
        proveedor = null;
        try {
            
            pstmt = con.prepareStatement("select * from provedor where id_provedor = ?");
            pstmt.setInt(1, id);
            resultado = pstmt.executeQuery();
            
            if (resultado != null) {
                mapProveedor();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No existe proveedor con ese ID");            
            
        }
        return (Proveedor)proveedor;
    }
    
    //mapeo Producto
    public void mapProducto() throws SQLException {
        //resultado.next();
        int id = resultado.getInt("id_producto");
        String marca = resultado.getString("marca");
        String descripcion = resultado.getString("descripcion");
        double precioCompra = resultado.getDouble("precioCompra");
        double precioVentaMenudeo = resultado.getDouble("precioMayoreo");
        double precioVentaMayoreo = resultado.getDouble("precioMenudeo");
        int existencias = resultado.getInt("existencias");
        producto = new Producto(id, marca, descripcion, precioCompra, precioVentaMenudeo, precioVentaMayoreo, proveedor, existencias);
    }
    
    //Consulta Producto
    public Producto consultaProducto(int id){
        producto = null;
        proveedor = null;
        try {
            pstmt = con.prepareStatement("select p.id_producto, p.marca, p.descripcion, p.precioCompra, p.precioMayoreo, p.precioMenudeo, p.existencias, pr.id_provedor, pr.compañia, pr.direccion, pr.telefono from provedor pr inner join producto p on pr.id_provedor = p.id_provedor where p.id_producto = ?");
            pstmt.setInt(1, id);
            resultado = pstmt.executeQuery();
            if (resultado != null) {
                mapProveedor(); 
                mapProducto();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No existe producto con ese ID");            
        }finally{
            objBD.cerrar();
        }
        return (Producto) producto;
    }
    
    //Alta Producto
    public boolean altaProducto (Producto producto,Proveedor proveedor){
        pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO producto VALUES (?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, producto.getId());
            pstmt.setString(2, producto.getMarca());
            pstmt.setString(3, producto.getDescripcion());
            pstmt.setDouble(4, producto.getPrecioCompra());
            pstmt.setDouble(5, producto.getPrecioVentaMayoreo());
            pstmt.setDouble(6, producto.getPrecioVentaMenudeo());
            pstmt.setInt(7, 0);
            pstmt.setInt(8, proveedor.getId());
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ya existe un producto con ese ID");
            return false;
        }
        return true;
    }
    
    //Modificar Producto
    public boolean modProducto(Producto producto){
        try {
            pstmt = con.prepareStatement("UPDATE producto set marca = ?, descripcion = ?, precioCompra = ?, precioMayoreo = ?, precioMenudeo =?,  id_provedor = ? where id_producto = ?");
            pstmt.setString(1, producto.getMarca());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setDouble(3, producto.getPrecioCompra());
            pstmt.setDouble(4, producto.getPrecioVentaMayoreo());
            pstmt.setDouble(5, producto.getPrecioVentaMenudeo());
            pstmt.setInt(6, producto.getProveedor().getId());
            pstmt.setInt(7, producto.getId());
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar");
            System.out.println(e);
            return false;
        }finally{
            objBD.cerrar();
        }
        return true;
    }
    
    //Baja Producto
    public boolean eliminarProducto (int id){
        try {
            pstmt = con.prepareStatement("DELETE from producto where id_producto = ?");
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
        //JOptionPane.showMessageDialog(null, "No existe producto con ese ID");
            return false;
        }finally{
            objBD.cerrar();
        }
        return true;
    }
    


    
}
