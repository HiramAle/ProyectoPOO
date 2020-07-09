/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private Compra compra;
    //private ArrayList<Producto> pds = new ArrayList<Producto>();

    public ConsultasProductoProvedor() {
        objBD = ConexionBD.getInstance();
        objBD.conectar();
        con = objBD.getConexion();
    }

    //mapeo Proveedor
    public void mapProveedor() throws SQLException {
        //resultado.next();
        int idProveedor = resultado.getInt("id_provedor");
        String compania = resultado.getString("compañia");
        String direccion = resultado.getString("direccion");
        long telefono = resultado.getLong("telefono");
        proveedor = new Proveedor(idProveedor, compania, direccion, telefono);
    }

    //Consulta Proveedor
    public Proveedor consultaProveedor(int id) {
        proveedor = null;
        try {

            pstmt = con.prepareStatement("select * from provedor where id_provedor = ?");
            pstmt.setInt(1, id);
            resultado = pstmt.executeQuery();

            if (resultado != null) {
                resultado.next();
                mapProveedor();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No existe proveedor con ese ID");

        }
        return (Proveedor) proveedor;
    }

    //mapeo Producto
    public void mapProducto() throws SQLException {
        int idProducto = resultado.getInt("id_producto");
        String marca = resultado.getString("marca");
        String descripcion = resultado.getString("descripcion");
        double precioCompra = resultado.getDouble("precioCompra");
        double precioVentaMenudeo = resultado.getDouble("precioMayoreo");
        double precioVentaMayoreo = resultado.getDouble("precioMenudeo");
        int existencias = resultado.getInt("existencias");
        producto = new Producto(idProducto, marca, descripcion, precioCompra, precioVentaMenudeo, precioVentaMayoreo, proveedor, existencias);
    }

    //Consulta Producto
    public Producto consultaProducto(int id) {
        proveedor = null;
        try {
            pstmt = con.prepareStatement("select p.id_producto, p.marca, p.descripcion, p.precioCompra, p.precioMayoreo, p.precioMenudeo, p.existencias, pr.id_provedor, pr.compañia, pr.direccion, pr.telefono from provedor pr inner join producto p on pr.id_provedor = p.id_provedor where p.id_producto = ?");
            pstmt.setInt(1, id);
            resultado = pstmt.executeQuery();
            if (resultado != null) {
                resultado.next();
                mapProveedor();
                mapProducto();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No existe producto con ese ID");
        } finally {
            objBD.cerrar();
        }
        return (Producto) producto;
    }

    //Alta Producto
    public boolean altaProducto(Producto producto, Proveedor proveedor) {
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
    public boolean modProducto(Producto producto) {
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
        } finally {
            objBD.cerrar();
        }
        return true;
    }

    //Baja Producto
    public boolean eliminarProducto(int id) {
        try {
            pstmt = con.prepareStatement("DELETE from producto where id_producto = ?");
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No existe producto con ese ID");
            return false;
        } finally {
            objBD.cerrar();
        }
        return true;
    }

    //Consulta Compra
    public Compra consultaCompra(int id) {
        compra = null;
        try {
            pstmt = con.prepareStatement("select p.id_producto, p.marca, p.descripcion, p.precioCompra, p.precioMayoreo, p.precioMenudeo, p.existencias, p.id_provedor, pr.compañia, pr.direccion, pr.telefono,  c.id_compra, c.fecha, c.monto, cp.cantidad from producto p inner join provedor pr on p.id_provedor = pr.id_provedor inner join compra_producto cp on p.id_producto = cp.id_producto inner join compra c on c.id_compra = cp.id_compra where c.id_compra = ?");
            pstmt.setInt(1, id);
            resultado = pstmt.executeQuery();
            ArrayList<Producto> pds = new ArrayList<Producto>();
            int idCompra = 0;
            Date fecha = null;
            double monto = 0;
            int cantidad = 0;
            if (resultado != null) {
                while (resultado.next()) {
                    mapProveedor();
                    mapProducto();
                    pds.add(producto);
                    idCompra = resultado.getInt("id_compra");
                    fecha = resultado.getDate("fecha");
                    monto = resultado.getDouble("monto");
                    cantidad = resultado.getInt("cantidad");
                }
            }
            compra = new Compra(idCompra, cantidad, fecha, monto, proveedor, pds);
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No existe Compra con ese ID");
        }
        return compra;
    }

    //mapeo CompraProducto
    public void mapCompraProducto() throws SQLException {
        int idCompra = resultado.getInt("id_compra");
        int idProducto = resultado.getInt("id_producto");
        int cantidad = resultado.getInt("cantidad");
    }

    //mapeo Consulta Productos por Proveedor
    public ArrayList<Producto> arrayProductos(int id) {
        ArrayList<Producto> pro = new ArrayList<Producto>();
        try {
            pstmt = con.prepareStatement("select p.id_producto, p.marca, p.descripcion, p.precioCompra, p.precioMayoreo, p.precioMenudeo,p.existencias, p.id_provedor, pr.compañia, pr.direccion, pr.telefono from producto p inner join provedor pr on p.id_provedor = pr.id_provedor where p.id_provedor =?");
            pstmt.setInt(1, id);
            resultado = pstmt.executeQuery();

            if (resultado != null) {

                while (resultado.next()) {
                    mapProveedor();
                    mapProducto();
                    //System.out.println(producto.getMarca());
                    pro.add(producto);
                    //System.out.println(pro.get(0).getMarca());
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No existe Proveedor con ese ID");
        }
        return pro;
    }
    //Alta Compra

    public boolean altaCompra(int idCompra, Date fecha,Double monto) {
        pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO compra VALUES(?,?,?)");
            pstmt.setInt(1, idCompra);
            pstmt.setDate(2, fecha);
            pstmt.setDouble(3, monto);
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ya existe una Compra con ese ID");
            return false;
        }
        return true;
    }

    //Alta Compra_Producto
    public boolean altaCompraProducto(int idCompra, int cantidad, int idProd) {
        pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO compra_producto VALUES(?,?,?)");
            pstmt.setInt(1, idCompra);
            pstmt.setInt(2, idProd);
            pstmt.setInt(3, cantidad);
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ya existe un CompraProducto con ese ID");
            return false;
        }
        return true;
    }
    //Actualizar Existencias
    public boolean actualizarExistencias(int exist, int idProducto){
                pstmt = null;
        try {
            pstmt = con.prepareStatement("UPDATE producto set existencias = ?  where id_producto= ?;");
            pstmt.setInt(1, exist);
            pstmt.setInt(2, idProducto);
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ya existe un ERROR UPDATE con ese ID");
            return false;
        }
        return true;
    }
    
    
}
