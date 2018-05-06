package Vista;

import Controlador.Conexion;
import Controlador.repositorio_liga;
import Modelo.Liga;
import com.mysql.jdbc.Connection;
import java.awt.Image;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Vista extends javax.swing.JFrame {

    protected String direccion;
    repositorio_liga repo = new repositorio_liga();
    protected Conexion con = new Conexion();

    public Vista() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        Image imgagen = new ImageIcon("C:\\Users\\MIRANDA\\Desktop\\FIFA\\fifa\\src\\imagenes\\fondo.jpg").getImage().getScaledInstance(855, 390, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imgagen);
        txtFondo.setIcon(icono);

        CrearTabla();

    }

    public void CrearTabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Nombre");
            modelo.addColumn("Pais");
            modelo.addColumn("logo");
            String nombre = null;
            String Nacionalidad = null;
            
            ImageIcon icono=null;
            InputStream bits = null;
            
            con.abrirConexion();
            ResultSet rs = repo.listar_liga(con.obtenerConexion());

            while (rs.next()) {
                nombre = rs.getString(1);
                Nacionalidad = rs.getString(2);
                bits = rs.getBinaryStream(3);
                BufferedImage imagen =  (BufferedImage) ImageIO.read(bits);
                icono = new ImageIcon(imagen.getScaledInstance(155, 175, java.awt.Image.SCALE_SMOOTH));
                    
                JLabel txtFoto2 = new JLabel();
               txtFoto2.setIcon(icono);
               txtFoto.setIcon(icono);
               tablaLiga.setRowHeight(155);
               
                modelo.addRow(new Object[]{nombre,Nacionalidad,txtFoto2});
            }
            tablaLiga.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con el sql " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con la imagen Stream " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        txtFondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textPais = new javax.swing.JTextField();
        texTemporada = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtFoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLiga = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Home", jPanel6);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Ligas Europeas"));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Nombre");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 46, 73, 20));
        jPanel7.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 46, 224, -1));

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("País");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 84, 73, 20));

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Temporada");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 122, 73, 20));
        jPanel7.add(textPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 84, 224, -1));
        jPanel7.add(texTemporada, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 122, 224, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel7.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Logo");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 161, 73, 20));

        jButton1.setText("Agregar Logo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 160, 224, -1));
        jPanel7.add(txtFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 170, 180));

        tablaLiga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null"
            }
        ));
        jScrollPane1.setViewportView(tablaLiga);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 810, 130));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ligas", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Equipos", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Jugadores", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Partidos", jPanel5);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 880, 440));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FIFA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JFileChooser selector = new JFileChooser();
        selector.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de imagenX", "jpg", "png");
        selector.setFileFilter(filtro);
        int opcion = selector.showOpenDialog(this);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            // JOptionPane.showMessageDialog(this, "haz guardado");
            direccion = selector.getSelectedFile().toString();

            Image imgagen = new ImageIcon(direccion).getImage().getScaledInstance(155, 175, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icono = new ImageIcon(imgagen);

            txtFoto.setIcon(icono);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        con.abrirConexion();
        Liga liga = new Liga(0, textNombre.getText().toString(), textPais.getText().toString(), texTemporada.getText().toString(), direccion);
        repo.guardarLiga(liga, con.obtenerConexion());
        con.Cerrar_conexion();

        textNombre.setText("");
        texTemporada.setText("");
        textPais.setText("");


    }//GEN-LAST:event_btnGuardarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaLiga;
    private javax.swing.JTextField texTemporada;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPais;
    private javax.swing.JLabel txtFondo;
    private javax.swing.JLabel txtFoto;
    // End of variables declaration//GEN-END:variables
}
