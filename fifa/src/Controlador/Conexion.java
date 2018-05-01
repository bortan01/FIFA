package Controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    Connection conexion ;
    Statement stm;
    
    public void abrirConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");//para especificar ruta
            String host = "jdbc:mysql://localhost/fifa";
            String user = "root";
            String pass = "";
            conexion = (Connection) DriverManager.getConnection(host,user,pass);
           
        } catch (ClassNotFoundException ex) {
            System.out.println("clase no encontrada");
        } catch (SQLException ex) {
            System.out.println("problemas con el sql");
        }
      }
    public Connection obtenerConexion (){
    return conexion;
    }
    public void Cerrar_conexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("problemas al cerrar conexion");
        }
    }
    
    
}
