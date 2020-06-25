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
import modelo.Cliente;
import modelo.ClienteEstrella;
import modelo.ClientePreferente;

/**
 *
 * @author Ale
 */
public class ConsultasCliente {
    //Variables para la consulta y conexion de la base de datos
    private PreparedStatement pstmt;
    private ResultSet resultado;
    private Connection con;
    private ConexionBD objBD;
    
    //Variables para el mapaeo 
    private Cliente cliente;

    public ConsultasCliente() {
        objBD= ConexionBD.getInstance();
        objBD.conectar();
        con = objBD.getConexion();
    }
    
    //mapeo ClienteEstrella 
    public void mapClienteE() throws SQLException{
        resultado.next();
        int id = resultado.getInt("id_cliente");
        String nombre = resultado.getString("nombre");
        String apellidoP = resultado.getString("apP");
        String apellidoM = resultado.getString("apM");
        boolean promociones = false; 
        double montoHistorico = resultado.getDouble("montoHistoricoCompra");
        cliente = new ClienteEstrella(id,nombre,apellidoP,apellidoM,promociones,montoHistorico);
    }
    
    
    //Consulta ClienteEstrella
    public ClienteEstrella consultaClienteE(int id){
        cliente = null;
        try {
            pstmt = con.prepareStatement("select c.id_cliente, c.nombre, c.apP, c.apM, c.promociones, ce.montoHistoricoCompra " +
                                        "from cliente c inner join clienteestrella ce " +
                                        "on c.id_cliente = ce.id_cliente " +
                                        "where c.id_cliente = ? ");
            pstmt.setInt(1, id);
            resultado = pstmt.executeQuery();
            if (resultado != null) {
                mapClienteE();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta \n verifique el ID");            
        }finally{
           objBD.cerrar(); 
        }
        return (ClienteEstrella)cliente;
    }
    
    //Agregar Cliente Extrella
    public boolean altaClienteE (ClienteEstrella ce){
        pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO cliente (id_cliente, nombre, apP, apM, promociones) "
                    + "VALUES (?, ?, ?, ?, 0)");
            pstmt.setInt(1, ce.getId());
            pstmt.setString(2, ce.getNombre());
            pstmt.setString(3, ce.getApellidoPaterno());
            pstmt.setString(4, ce.getApellidoMaterno());
            pstmt.execute();
            pstmt = null;
            pstmt = con.prepareStatement("INSERT INTO clienteestrella (montoHistoricoCompra, id_cliente) "
                    + "VALUES (?, ?)");
            pstmt.setDouble(1, ce.getMontoHistoricoCompra());
            pstmt.setInt(2, ce.getId());
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la insercion");
            return false;
        }finally{
            objBD.cerrar();
        }
        return true;
    }
    
    //Modificar Cliente Estrella
    public boolean modicaClienteE(ClienteEstrella ce){
        try {
            pstmt = con.prepareStatement("update cliente c inner join clienteestrella ce " +
                                         "on c.id_cliente = ce.id_cliente " +
                                         "set c.nombre =?, c.apP =?, c.apM =?, ce.montoHistoricoCompra =? " +
                                         "where c.id_cliente = ?");
            
            pstmt.setString(1, ce.getNombre());
            pstmt.setString(2, ce.getApellidoPaterno());
            pstmt.setString(3, ce.getApellidoMaterno());
            pstmt.setDouble(4,ce.getMontoHistoricoCompra());
            pstmt.setInt(5, ce.getId());
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar");
            return false;
        }finally{
            objBD.cerrar();
        }
        return true;
    }
    
    //Eliminar Ambos tipos de clientes por el "on delete cascade" de la base de datos 
    public boolean eliminaCliente(int id){
        try {
            pstmt = con.prepareStatement("delete from cliente where id_cliente= ?");
            pstmt.setInt(1, id);
            pstmt.execute();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
            return false;
        }finally{
            objBD.cerrar();
        }
        return true;
    }
    
    //mapeo ClientePreferente 
    public void mapClienteP() throws SQLException{
        resultado.next();
        int id = resultado.getInt("id_cliente");
        String nombre = resultado.getString("nombre");
        String apellidoP = resultado.getString("apP");
        String apellidoM = resultado.getString("apM");
        boolean promociones = true; 
        double montoCredito = resultado.getDouble("montoCredito");
        double adeudo = resultado.getDouble("adeudo");
        cliente = new ClientePreferente(id,nombre,apellidoP,apellidoM,promociones,montoCredito,adeudo);
    }
    
    
    //Consulta ClientePreferente
    public ClientePreferente consultaClienteP(int id){
        cliente = null;
        try {
            pstmt = con.prepareStatement("select c.id_cliente, c.nombre, c.apP, c.apM, c.promociones, cp.montoCredito, cp.adeudo " +
                                        "from cliente c inner join clientepreferente cp " +
                                        "on c.id_cliente = cp.id_cliente " +
                                        "where c.id_cliente = ? ");
            pstmt.setInt(1, id);
            resultado = pstmt.executeQuery();
            if (resultado != null) {
                mapClienteP();
            }
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Error en la consulta \n verifique el ID");
        } finally{
           objBD.cerrar(); 
        }
        return (ClientePreferente)cliente;
    }
   
    //Agregar Cliente Preferente
    public boolean altaClienteP (ClientePreferente ce){
        pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO cliente (id_cliente, nombre, apP, apM, promociones) "
                    + "VALUES (?, ?, ?, ?, 1)");
            pstmt.setInt(1, ce.getId());
            pstmt.setString(2, ce.getNombre());
            pstmt.setString(3, ce.getApellidoPaterno());
            pstmt.setString(4, ce.getApellidoMaterno());
            pstmt.execute();
            pstmt = null;
            pstmt = con.prepareStatement("INSERT INTO clientepreferente (montoCredito, adeudo, id_cliente) "
                    + "VALUES (?, ?, ?)");
            pstmt.setDouble(1, ce.getMontoCredito());
            pstmt.setDouble(2, ce.getAdeudo());
            pstmt.setInt(3, ce.getId());
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar registro");
            return false;
        }finally{
            objBD.cerrar();
        }
        return true;
    }
  
    //Modificar Cliente Preferente
    public boolean modicaClienteP(ClientePreferente ce){
        try {
            pstmt = con.prepareStatement("update cliente c inner join clientepreferente ce " +
                                        "on c.id_cliente = ce.id_cliente " +
                                        "set c.nombre =? ,c.apP =? ,c.apM =? ,ce.montoCredito=?, ce.adeudo =? " +
                                        "where c.id_cliente = ? ");
            
            pstmt.setString(1, ce.getNombre());
            pstmt.setString(2, ce.getApellidoPaterno());
            pstmt.setString(3, ce.getApellidoMaterno());
            pstmt.setDouble(4,ce.getMontoCredito());
            pstmt.setDouble(5,ce.getAdeudo());
            pstmt.setInt(6, ce.getId());
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar");
            return false;
        }finally{
            objBD.cerrar();
        }
        return true;
    }
}
