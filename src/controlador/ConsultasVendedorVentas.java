package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    
    //Variables para el mapeo
    private Producto producto;
    private Vendedor vendedor;
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
    //Map Cliente
      public void mapCliente() throws SQLException {
        //resultado.next();
        int idCli = resultado.getInt("id_cliente");
        String nombre = resultado.getString("nombre");
        String app = resultado.getString("apP");
        String apm = resultado.getString("apM");
        Boolean promociones = resultado.getBoolean("promociones");
        cliente = new Cliente(idCli, nombre , app, apm,promociones);
    }
    //Consulta Cliente
     public Cliente consultaCliente(int id){
        cliente = null;
        try{
            pstmt = con.prepareStatement("select * from clienteestrella where id_clienteE = ?");
            pstmt.setInt(1, id);
            resultado = pstmt.executeQuery();

            if (resultado != null) {
                resultado.next();
                mapCliente();
            }else{
                pstmt = con.prepareStatement("select * from clientepreferente where id_clienteP = ?");
                pstmt.setInt(1, id);
                resultado = pstmt.executeQuery();
            }else{
                
            }
        }catch(Exception e){
                System.out.print(e);
                JOptionPane.showMessageDialog(null, "No existe cliente con ese ID");
        }
        return (Cliente) cliente;
     }
     

}
