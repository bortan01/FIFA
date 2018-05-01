package Controlador;

import Modelo.Liga;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class repositorio_liga {
 
    
    public void guardarLiga(Liga l, Connection c){
        try {
            String sql = "INSERT INTO liga(nombre, pais, temporada) VALUES (?,?,?)";
            
            
            PreparedStatement pps = (PreparedStatement) c.prepareStatement(sql);
           pps.setString(1, l.getNombre());
            pps.setString(2, l.getPais());
            pps.setString(3, l.getTemporada());
             pps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "datos gurdados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con el sql "+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
 
    }
}