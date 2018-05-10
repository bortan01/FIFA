package Controlador;

import Modelo.Equipo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class repositorio_equipo {
    
    public void guardar_equipo(Connection c, Equipo e){
        try {
            String sql = "INSERT INTO equipo (id_liga, nombre, fecha_fundacion, puntos, escudo) VALUES (?, ?, ?, ?, ?)";

            File archivo = new File(e.getEscudo());
            FileInputStream imagen = new FileInputStream(archivo);
            PreparedStatement pps = (PreparedStatement) c.prepareStatement(sql);
            pps.setInt(1, e.getId_liga());
            pps.setString(2, e.getNombre());
            pps.setDate(3, (Date) e.getFecha_fundacion());
            pps.setInt(4, 0);
            pps.setBinaryStream(5, imagen, (int) archivo.length());

            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "datos gurdados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con el sql " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con la foto " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public ResultSet listar_equipo(Connection c) {
        String sql = "SELECT equipo.id_equipo,liga.nombre,equipo.nombre,equipo.fecha_fundacion,equipo.escudo FROM liga INNER JOIN equipo ON liga.id_liga = equipo.id_liga";
        ResultSet rs = null;
        try {

            PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con el sql en listar equipo" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
}
