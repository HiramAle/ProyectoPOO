/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ConsultasCliente;

/**
 *
 * @author Ale
 */
public class MainProvicional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*ConsultasCliente consul = new ConsultasCliente();
        ClienteEstrella clienteE = consul.consultaClienteE(18942);
        System.out.println(clienteE.getNombre() +" "+ clienteE.getApellidoPaterno()+" "+clienteE.getMontoHistoricoCompra());
        ConsultasCliente consul2 = new ConsultasCliente();
        clienteE = new  ClienteEstrella(14568, "Alejandra", "Orozco", "Aguilar", true, 450.69);
        consul2.altaClienteE(clienteE);*/
        ConsultasCliente consul2 = new ConsultasCliente();
        ClientePreferente clienteE = new  ClientePreferente (14589, "Alejandra", "Orozco", "Aguilar", true, 450.69, 6590.90);
        consul2.modicaClienteP(clienteE);
    }
    
}
