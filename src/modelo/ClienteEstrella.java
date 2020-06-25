/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;

/**
 *
 * @author Ale
 */
public class ClienteEstrella extends Cliente{
    private double montoHistoricoCompra;

    public ClienteEstrella() {
        super();
    }

    public ClienteEstrella( int id, String nombre, String apellidoPaterno, String apellidoMaterno, boolean promociones,double montoHistoricoCompra) {
        super(id, promociones, nombre, apellidoPaterno, apellidoMaterno);
        this.montoHistoricoCompra = montoHistoricoCompra;
    }
    
    public double getMontoHistoricoCompra() {
        return montoHistoricoCompra;
    }

    public void setMontoHistoricoCompra(double montoHistoricoCompra) {
        this.montoHistoricoCompra = montoHistoricoCompra;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isPromociones() {
        return promociones;
    }

    @Override
    public void setPromociones(boolean promociones) {
        this.promociones = promociones;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    @Override
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Override
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    @Override
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    
    public File verCompras(){
        return null;
    }
}
