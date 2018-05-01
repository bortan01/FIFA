package Modelo;

public class Detalle_partido {
    int id_partido ;
    int id_equipo;
    int goles;;
    int amarillas;
    int rojas;

    public Detalle_partido() {
    }

    public Detalle_partido(int id_partido, int id_equipo, int goles, int rojas) {
        this.id_partido = id_partido;
        this.id_equipo = id_equipo;
        this.goles = goles;
        this.rojas = rojas;
    }
    
     public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAmarillas() {
        return amarillas;
    }

    public void setAmarillas(int amarillas) {
        this.amarillas = amarillas;
    }

    public int getRojas() {
        return rojas;
    }

    public void setRojas(int rojas) {
        this.rojas = rojas;
    }
    
    
}
