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
                System.out.println("out");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta \n verifique el ID");            
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
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en la consulta \n verifique el ID");            
        }finally{
            objBD.cerrar();
        }
        return (Producto) producto;
    }
    
    //Alta Producto
    public boolean altaProducto (Producto producto,int idproveedor){
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
            pstmt.setInt(8, idproveedor);
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la insercion");
            return false;
        }
        return true;
    }
    


    
}
