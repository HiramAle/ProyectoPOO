package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Vendedor;
import modelo.Venta;

public class ConsultasVendedorVentas {
    //Variables para la consulta y conexion de la base de datos
    private PreparedStatement pstmt;
    private ResultSet resultado;
    private Connection con;
    private ConexionBD objBD;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    
    //Variables para el mapeo
    private Producto producto;
    private Vendedor vendedor;
    private Proveedor proveedor;
    private Venta venta;
    private Cliente cliente;

    public ConsultasVendedorVentas() {
        objBD= ConexionBD.getInstance();
        objBD.conectar();
        con = objBD.getConexion();
    }
    
    //Mapeo vendedor
    public void mapVendedor() throws SQLException {
        //resultado.next();
        int idVendedor = resultado.getInt("id_vendedor");
        String nombre = resultado.getString("nombre");
        String app = resultado.getString("apP");
        String apm = resultado.getString("apM");
        String turno = resultado.getString("turno");
        String horaEntrada = resultado.getString("horaEntrada");
        String horaSalida = resultado.getString("horaSalida");
        vendedor = new Vendedor(idVendedor, nombre , app, apm,turno,horaEntrada,horaSalida);
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
    
    //Consulta Vendedor
     public Vendedor consultaVendedor(int id) {
        vendedor = null;
        try {

            pstmt = con.prepareStatement("select * from vendedor where id_vendedor = ?");
            pstmt.setInt(1, id);
            resultado = pstmt.executeQuery();

            if (resultado != null) {
                resultado.next();
                mapVendedor();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No existe vendedor con ese ID");

        }
        return (Vendedor) vendedor;
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
    //Map Cliente
      public void mapCliente(int t) throws SQLException {
        int idCli;        
        //resultado.next();
        if(t==0){ //Cliente Estrella
            idCli = resultado.getInt("id_clienteE");
        }else if(t==1){ //Cliente Preferente
            idCli = resultado.getInt("id_clienteP");
        }else{
            
        }

        cliente = new Cliente(idCli);
    }
      
      public void llenarTabla(JTable tabla,int id)throws Exception{
        pstmt=con.prepareStatement("select * from venta where id_vendedor = ?");
        pstmt.setInt(1, id);
        resultado=pstmt.executeQuery();
        rsm=resultado.getMetaData();
        ArrayList<Object[]> datos=new ArrayList<>();
        while (resultado.next()) {            
            Object[] filas=new Object[rsm.getColumnCount()];
            for (int i = 0; i < filas.length; i++) {
                filas[i]=resultado.getObject(i+1);
                
            }
            datos.add(filas);
        }
        dtm=(DefaultTableModel)tabla.getModel();
        for (int i = 0; i <datos.size(); i++) {
            dtm.addRow(datos.get(i));
        }
    }
      public boolean altaVenta(int idVenta, Date fecha,Double monto,int id_ven,int id_cli) {
        pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO venta VALUES(?,?,?,?,?)");
            pstmt.setInt(1, idVenta);
            pstmt.setDate(2, fecha);
            pstmt.setDouble(3, monto);
            pstmt.setInt(4, id_ven);
            pstmt.setInt(5, id_cli);
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }
        return true;
    }
      
    //Consulta Cliente
     public int consultaCliente(int id){
         int t=9;
        cliente = null;
        try{
            if(id!=11111){
                pstmt = con.prepareStatement("select * from clienteestrella where id_cliente = ?");
                pstmt.setInt(1, id);
                resultado = pstmt.executeQuery();
                if (resultado != null) {
                    t=1;
                }else{
                    pstmt = con.prepareStatement("select * from clientepreferente where id_cliente = ?");
                    resultado = pstmt.executeQuery();
                    t=1;
                }
            }else{
            t=0;
            }
        }catch(Exception e){
                System.out.print(e);
                JOptionPane.showMessageDialog(null, "No existe cliente con ese ID");
        }
        return t;
     }
     //Mapeo consulta de todos los productos
     public ArrayList<Producto> arrayProductos(){
         ArrayList<Producto> pro = new ArrayList<Producto>();
         try{
             pstmt = con.prepareStatement("select * from producto ");
             resultado=pstmt.executeQuery();
             if(resultado!=null){
                 while(resultado.next()){
                     mapProducto();
                     pro.add(producto);
                 }
             }
         }catch(SQLException e){
             System.out.print(e);
             JOptionPane.showMessageDialog(null,"Ocurrio un error");
         
         }finally{
             objBD.cerrar();
         }
         return pro;
     }

    public void llenarTabla2(JTable tabla, int id) throws Exception {
         pstmt=con.prepareStatement("select * from venta where id_cliente = ?");
        pstmt.setInt(1, id);
        resultado=pstmt.executeQuery();
        rsm=resultado.getMetaData();
        ArrayList<Object[]> datos=new ArrayList<>();
        while (resultado.next()) {            
            Object[] filas=new Object[rsm.getColumnCount()];
            for (int i = 0; i < filas.length; i++) {
                filas[i]=resultado.getObject(i+1);
                
            }
            datos.add(filas);
        }
        dtm=(DefaultTableModel)tabla.getModel();
        for (int i = 0; i <datos.size(); i++) {
            dtm.addRow(datos.get(i));
        }
         
    }

}
