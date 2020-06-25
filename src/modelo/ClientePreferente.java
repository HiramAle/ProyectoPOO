/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Ale
 */
public class ClientePreferente extends Cliente{
    private double montoCredito;
    private double adeudo;

    public ClientePreferente() {
        super();
    }

    public ClientePreferente(int id, String nombre, String apellidoPaterno, String apellidoMaterno, boolean promociones,double montoCredito, double adeudo) {
        super(id, promociones, nombre, apellidoPaterno, apellidoMaterno);
        this.montoCredito = montoCredito;
        this.adeudo = adeudo;
    }
    
    public double getMontoCredito() {
        return montoCredito;
    }

    public void setMontoCredito(double montoCredito) {
        this.montoCredito = montoCredito;
    }

    public double getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(double adeudo) {
        this.adeudo = adeudo;
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
    
    public boolean aumentarCredito(double porcentaje){
        return true;
    }
}
