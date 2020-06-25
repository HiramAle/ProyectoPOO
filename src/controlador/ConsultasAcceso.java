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
import modelo.Login;

/**
 *
 * @author Ale
 */
public class ConsultasAcceso {
    private PreparedStatement pstmt;
    private ResultSet resultado;
    private Connection con;
    private ConexionBD objBD;
    
    private Login log;

    public ConsultasAcceso() {
        objBD= ConexionBD.getInstance();
        objBD.conectar();
        con = objBD.getConexion();
    }    
    
    public void mapLogin() throws SQLException{
        resultado.next();
        String id = resultado.getString("id_administrador");
        String contrasenia = resultado.getString("contrasenia");
        log = new Login(id,contrasenia);
    }
    
    public Login consultaLogin(String id){
        log = null;
        try {
            pstmt = con.prepareStatement("select id_administrador,contrasenia from accesoAdmin where id_administrador = ?");
            pstmt.setString(1, id);
            resultado = pstmt.executeQuery();
            if (resultado != null) {
                mapLogin();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta \n verifique el ID");            
        }finally{
           objBD.cerrar(); 
        }
        return log;
    }
}
