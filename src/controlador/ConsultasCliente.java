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
import modelo.Cliente;
import modelo.ClienteEstrella;

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
    
    //mapeo CleinteEstrella 
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
            System.out.println("Error en la consulta");
            System.out.println(e.getMessage());
        } finally{
           objBD.cerrar(); 
        }
        return (ClienteEstrella)cliente;
    }
    
    //Agregar Cliente Extrella
    public boolean altaClienteE (ClienteEstrella ce){
        pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO cliente (id_cliente, nombre, apP, apM, promociones) "
                    + "VALUES (?, ?, ?, ?, 1);");
            pstmt.setInt(1, ce.getId());
            pstmt.setString(2, ce.getNombre());
            pstmt.setString(3, ce.getApellidoPaterno());
            pstmt.setString(4, ce.getApellidoMaterno());
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println("Error en el registro");
            System.out.println(e.getMessage());
            return false;
        }finally{
            objBD.cerrar();
        }
        return true;
    }
    
}
