/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConsultasAcceso;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.Login;

/**
 *
 * @author Ale
 */
public class AdminAcceso {
    
    
    public  boolean acceso(){
        /**
         * **
         */
        JTextField userField = new JTextField(5);
        JPasswordField passField = new JPasswordField(5);
   

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("usuario:"));
        myPanel.add(userField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("contraseña:"));
        myPanel.add(passField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Introduzca usuario y contraseña", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String user, password;
            user = userField.getText();
            password = passField.getText();
            
            System.out.println(user);
            System.out.println(password);
            
            ConsultasAcceso ac = new ConsultasAcceso();
            Login log = ac.consultaLogin(user);
            
            if(user.equals(log.getUsuario()) && password.equals(log.getContrasenia())){
                Administrador ventanaGestion = new Administrador();
                ventanaGestion.setVisible(true);
                return true;
            }
            
            JOptionPane.showMessageDialog(null, "El usuario y contraseña no coinciden", "Error de acceso", JOptionPane.WARNING_MESSAGE);
            
        }
        return false;
    }
    
}
