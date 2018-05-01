package Modelo;

import java.util.Date;

public class Equipo {
    int id_equipo;
    int id_liga;
    String nombre;
    Date fecha_fundacion;
    int puntos ;

    public Equipo() {
    }
    
    

    public Equipo(int id_equipo, int id_liga, Date fecha_fundacion, int puntos) {
        this.id_equipo = id_equipo;
        this.id_liga = id_liga;
        this.fecha_fundacion = fecha_fundacion;
        this.puntos = puntos;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getId_liga() {
        return id_liga;
    }

    public void setId_liga(int id_liga) {
        this.id_liga = id_liga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_fundacion() {
        return fecha_fundacion;
    }

    public void setFecha_fundacion(Date fecha_fundacion) {
        this.fecha_fundacion = fecha_fundacion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
    
}
