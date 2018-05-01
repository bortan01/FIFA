package Modelo;
public class Liga {
    int id_liga;
    String nombre ;
    String pais;
    String temporada ;

    public Liga() {
    }

    public Liga(int id_liga, String nombre, String pais, String temporada) {
        this.id_liga = id_liga;
        this.nombre = nombre;
        this.pais = pais;
        this.temporada = temporada;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }
    
    
    
}
