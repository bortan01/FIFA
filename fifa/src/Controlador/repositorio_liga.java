package Controlador;

import Modelo.Liga;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class repositorio_liga {

    public void guardarLiga(Liga l, Connection c) {
        try {
            String sql = "INSERT INTO liga(nombre, pais, temporada,logo) VALUES (?,?,?,?)";

            File archivo = new File(l.getFoto());
            FileInputStream imagen = new FileInputStream(archivo);
            PreparedStatement pps = (PreparedStatement) c.prepareStatement(sql);
            pps.setString(1, l.getNombre());
            pps.setString(2, l.getPais());
            pps.setString(3, l.getTemporada());
            pps.setBinaryStream(4, imagen, (int) archivo.length());

            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "datos gurdados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con el sql " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con la foto " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void modificar_liga(Liga l, Connection c) {

        if (l.getFoto() == "") {
            try {
                String sql = "UPDATE liga SET nombre = '?', pais = '?',temporada = '?' WHERE id_liga = '2'";

                PreparedStatement pps = (PreparedStatement) c.prepareStatement(sql);
            pps.setString(1,"d");
            
            
                pps.executeUpdate();

                JOptionPane.showMessageDialog(null, "datos actualizados");
            } catch (SQLException ex) {
                Logger.getLogger(repositorio_liga.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
//                File archivo = new File(l.getFoto());
//                FileInputStream imagen;
//                try {
//                    imagen = new FileInputStream(archivo);
//                    String sql = "UPDATE liga SET nombre = '222', pais = '222',temporada = '222', logo = '"+imagen+"'  WHERE id_liga = 1;";
//                PreparedStatement pps = (PreparedStatement) c.prepareStatement(sql);
//                pps.executeUpdate();
//
//                JOptionPane.showMessageDialog(null, "datos actualizados");
        

    }

}

public ResultSet listar_liga(Connection c) {
        String sql = "SELECT liga.id_liga,liga.nombre, liga.pais,liga.temporada, liga.logo FROM liga";
        ResultSet rs = null;
        try {

            PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con el sql " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public ResultSet obtener_logo(Connection c, int id) {
        String sql = "SELECT liga.logo FROM liga WHERE id_liga = '" + id + "'";
        ResultSet rs = null;
        try {

            PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con el sql " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;

    }
}
