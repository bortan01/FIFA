package Modelo;

public class Miembros {
    int id_miembros;
    int id_equipo;
    String nombre ;
    String apellido ;
    String puesto ;

    public Miembros() {
    }

    public Miembros(int id_miembros, int id_equipo, String nombre, String apellido, String puesto) {
        this.id_miembros = id_miembros;
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
    }
    
    

    public int getId_miembros() {
        return id_miembros;
    }

    public void setId_miembros(int id_miembros) {
        this.id_miembros = id_miembros;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    
    
    
}
