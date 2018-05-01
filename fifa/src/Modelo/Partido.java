
package Modelo;

import java.util.Date;


public class Partido {
    int id_partido;
    int jornada;
    Date fecha;
    String estadio ;

    public Partido() {
    }

    public Partido(int id_partido, int jornada, Date fecha, String estadio) {
        this.id_partido = id_partido;
        this.jornada = jornada;
        this.fecha = fecha;
        this.estadio = estadio;
    }
    
    

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
    
    
    
}
