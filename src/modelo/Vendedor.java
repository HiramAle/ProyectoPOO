package modelo;

import java.sql.Date;

public class Vendedor {
    //Declaracion de Variables
    private int id;
    private String nombre;
    private String app;
    private String apm;
    private String turno;
    private String horaEntrada;
    private String horaSalida;


    public Vendedor() {
       
    }
    public Vendedor(int id, String nombre,String app,String apm,String turno,String horaEntrada,String horaSalida){
        this.id=id;
        this.nombre=nombre;
        this.app=app;
        this.apm=apm;
        this.turno=turno;
        this.horaEntrada=horaEntrada;
        this.horaSalida=horaSalida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    
    
    /* Metodo comentado para que ocasion errores
    public File generaTicketVenta(){
        
        return null;
    }*/
    public Date registraHoraEntrada(){
        
        return null;
    }
    public boolean revisaBonoPuntualidad(){
        
        return false;
    }
}