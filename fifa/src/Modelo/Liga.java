package Modelo;
public class Liga {
    int id_liga;
    String nombre ;
    String pais;
    String temporada ;
    String Foto;

    public Liga() {
    }

    public Liga(int id_liga, String nombre, String pais, String temporada,String Foto) {
        this.id_liga = id_liga;
        this.nombre = nombre;
        this.pais = pais;
        this.temporada = temporada;
        this.Foto = Foto;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
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

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
