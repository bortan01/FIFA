package Vista;

import Controlador.Conexion;
import Controlador.repositorio_equipo;
import Controlador.repositorio_liga;
import Modelo.Equipo;
import Modelo.Liga;
import com.mysql.jdbc.Connection;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Image;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Vista extends javax.swing.JFrame {

    protected String direccion = "";
    repositorio_liga repo = new repositorio_liga();
    repositorio_equipo repo_equipo = new repositorio_equipo();
    protected Conexion con = new Conexion();

    public Vista() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        Image imgagen = new ImageIcon("C:\\Users\\MIRANDA\\Desktop\\FIFA\\fifa\\src\\imagenes\\fondo.jpg").getImage().getScaledInstance(855, 390, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imgagen);
        txtFondo.setIcon(icono);

        llenar_tabla_liga();
        llenar_combo_liga();
        llenar_tabla_equipo();

    }

    public void llenar_combo_liga() {
        DefaultComboBoxModel modelo_liga = new DefaultComboBoxModel();
        combo_liga.setModel(modelo_liga);

        con.abrirConexion();
        ResultSet rs = repo.listar_liga(con.obtenerConexion());

        try {
            while (rs.next()) {
                Liga l = new Liga();
                l.setId_liga(rs.getInt(1));
                l.setNombre(rs.getString(2));
                modelo_liga.addElement(l);

            }
            con.Cerrar_conexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "problemas con el sql " + ex.getMessage());
        }

    }

    public void limpiar() {
        textNombre.setText("");
        texTemporada.setText("");
        textPais.setText("");
        txtFoto.setIcon(null);

        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnActualizar.setEnabled(true);
    }

    public void llenar_tabla_liga() {
        try {
            tablaLiga.setDefaultRenderer(Object.class, new TablaImagen());
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Pais");
            modelo.addColumn("Temporada");
            modelo.addColumn("logo");
            String nombre = null;
            String Nacionalidad = null;
            String Temporada = null;
            String id = null;

            ImageIcon icono = null;
            InputStream bits = null;
            JLabel txtLogo = null;

            con.abrirConexion();
            ResultSet rs = repo.listar_liga(con.obtenerConexion());

            while (rs.next()) {
                id = rs.getString(1);
                nombre = rs.getString(2);
                Nacionalidad = rs.getString(3);
                Temporada = rs.getString(4);
                bits = rs.getBinaryStream(5);
                if (bits != null) {
                    BufferedImage imagen = (BufferedImage) ImageIO.read(bits);
                    icono = new ImageIcon(imagen.getScaledInstance(155, 175, java.awt.Image.SCALE_SMOOTH));

                    txtLogo = new JLabel();
                    txtLogo.setIcon(icono);
                } else {
                    txtLogo = new JLabel("Sin Logo");
                }

                tablaLiga.setRowHeight(155);
                modelo.addRow(new Object[]{id, nombre, Nacionalidad, Temporada, txtLogo});
            }
            tablaLiga.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con el sql " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con la imagen Stream " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void llenar_tabla_equipo() {

        try {
            tablaEquipos.setDefaultRenderer(Object.class, new TablaImagen());
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Liga");
            modelo.addColumn("Fundacion");
            modelo.addColumn("Escudo");

            String id = null;
            String nombre = null;
            String liga = null;
            String escudo = null;
            Date fundacion = null;
            String Escudo = null;
            JLabel txtEscudo = null;

            con.abrirConexion();
            ResultSet rs = repo_equipo.listar_equipo(con.obtenerConexion());
            ImageIcon icono = null;
            InputStream bits = null;

            while (rs.next()) {
                id = rs.getString(1);
                liga = rs.getString(2);
                nombre = rs.getString(3);
                fundacion = rs.getDate(4);

                bits = rs.getBinaryStream(5);

                if (bits != null) {
                    BufferedImage imagen = (BufferedImage) ImageIO.read(bits);
                    icono = new ImageIcon(imagen.getScaledInstance(155, 175, java.awt.Image.SCALE_SMOOTH));

                    txtEscudo = new JLabel();
                    txtEscudo.setIcon(icono);
                } else {
                    txtEscudo = new JLabel("Sin Escudo");
                }

                tablaEquipos.setRowHeight(155);

                modelo.addRow(new Object[]{id, nombre, liga, fundacion, txtEscudo});

            }

            tablaEquipos.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "problemas con el sql en llenar tabla equipo " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "problemas con la imagen en llenar tabla equipo " + ex.getMessage());
        }

    }

    void CentrarCeldas(int columna) {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        tablaLiga.getColumnModel().getColumn(columna).setCellRenderer(modelocentrar);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        combo_liga = new javax.swing.JComboBox();
        nombre_equipo = new javax.swing.JTextField();
        fecha_fundacion = new com.toedter.calendar.JDateChooser();
        btn_escudo = new javax.swing.JButton();
        txtEscudo = new javax.swing.JLabel();
        btnActualizarE = new javax.swing.JButton();
        btnGuardarE = new javax.swing.JButton();
        btn_cancelarE = new javax.swing.JButton();
        btn_ModificarE = new javax.swing.JButton();
        btnEliminarE = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        txtFondo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel7.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 80, -1));

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
        jPanel7.add(txtFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 170, 180));

        tablaLiga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaLiga);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 860, 310));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel7.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 80, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel7.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 80, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel7.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 80, -1));

        btnActualizar.setText("Actulizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel7.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

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

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipos Europeos"));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Escudo");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 51, 51));
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Liga:");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 51, 51));
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Nomrbre");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 51, 51));
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Fecha Fundacion");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        combo_liga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(combo_liga, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 160, -1));
        jPanel8.add(nombre_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 160, -1));
        jPanel8.add(fecha_fundacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 160, -1));

        btn_escudo.setText("Agregar Escudo");
        btn_escudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_escudoActionPerformed(evt);
            }
        });
        jPanel8.add(btn_escudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 160, -1));
        jPanel8.add(txtEscudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 170, 180));

        btnActualizarE.setText("Actualizar");
        jPanel8.add(btnActualizarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 80, -1));

        btnGuardarE.setText("Guardar");
        btnGuardarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEActionPerformed(evt);
            }
        });
        jPanel8.add(btnGuardarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 80, -1));

        btn_cancelarE.setText("Cancelar");
        jPanel8.add(btn_cancelarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 80, -1));

        btn_ModificarE.setText("Modificar");
        jPanel8.add(btn_ModificarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 80, -1));

        btnEliminarE.setText("Eliminar");
        jPanel8.add(btnEliminarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 80, -1));

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaEquipos);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 850, 320));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Equipos", jPanel3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Home", jPanel6);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 915, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Jugadores", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 915, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Partidos", jPanel5);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 920, 610));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        direccion = "";

        limpiar();
        llenar_tabla_liga();
        llenar_combo_liga();


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = tablaLiga.getSelectedRow();
        if (fila >= 0) {
            try {
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                textNombre.setText(tablaLiga.getValueAt(fila, 1).toString());
                textPais.setText(tablaLiga.getValueAt(fila, 2).toString());
                texTemporada.setText(tablaLiga.getValueAt(fila, 3).toString());
                int id = Integer.parseInt(tablaLiga.getValueAt(fila, 0).toString());

                con.abrirConexion();
                ResultSet rs = repo.obtener_logo(con.obtenerConexion(), id);
                ImageIcon icono = null;
                InputStream bits = null;

                while (rs.next()) {
                    bits = rs.getBinaryStream(1);

                    if (bits != null) {
                        BufferedImage imagen = (BufferedImage) ImageIO.read(bits);
                        icono = new ImageIcon(imagen.getScaledInstance(155, 175, java.awt.Image.SCALE_SMOOTH));
                        txtFoto.setIcon(icono);
                    }

                }
                con.Cerrar_conexion();
            } catch (SQLException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se a seleccionado el registro");
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        textNombre.setText("");
        texTemporada.setText("");
        textPais.setText("");
        txtFoto.setIcon(null);

        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnActualizar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int fila = tablaLiga.getSelectedRow();
        if (fila >= 0) {
            int id = Integer.parseInt(tablaLiga.getValueAt(fila, 0).toString());
            con.abrirConexion();

            Liga liga = new Liga(id, textNombre.getText(), textPais.getText(), texTemporada.getText(), direccion);
            repo.modificar_liga(liga, con.obtenerConexion());
            System.out.println("la direccion actual es " + direccion);
            con.Cerrar_conexion();

            limpiar();
            llenar_tabla_liga();
        } else {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado nada");
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaLiga.getSelectedColumn();
        if (fila >= 0) {
            int id = Integer.parseInt(tablaLiga.getValueAt(fila, 0).toString());
            Liga l = new Liga();
            l.setId_liga(id);
            con.abrirConexion();
            repo.eliminar_liga(con.obtenerConexion(), l);
            con.Cerrar_conexion();
            llenar_tabla_liga();

        } else {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado fila");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEActionPerformed

        try {
            int dia = fecha_fundacion.getCalendar().get(Calendar.DAY_OF_MONTH);
            int mes = fecha_fundacion.getCalendar().get(Calendar.MONTH);
            int anio = fecha_fundacion.getCalendar().get(Calendar.YEAR) - 1900;

            Date Fecha = new java.sql.Date(anio, mes, dia);

            Liga l = (Liga) combo_liga.getSelectedItem();
            Equipo e = new Equipo(0, l.getId_liga(), nombre_equipo.getText(), Fecha, 0, direccion);
            con.abrirConexion();
            repo_equipo.guardar_equipo(con.obtenerConexion(), e);
            con.Cerrar_conexion();

        } catch (NullPointerException ex) {
            System.out.println("no ha seleccionado fecha " + ex.getMessage());
        }
        llenar_tabla_equipo();

    }//GEN-LAST:event_btnGuardarEActionPerformed

    private void btn_escudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_escudoActionPerformed
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

            txtEscudo.setIcon(icono);
        }
    }//GEN-LAST:event_btn_escudoActionPerformed

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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarE;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarE;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btn_ModificarE;
    private javax.swing.JButton btn_cancelarE;
    private javax.swing.JButton btn_escudo;
    private javax.swing.JComboBox combo_liga;
    private com.toedter.calendar.JDateChooser fecha_fundacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nombre_equipo;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTable tablaLiga;
    private javax.swing.JTextField texTemporada;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPais;
    private javax.swing.JLabel txtEscudo;
    private javax.swing.JLabel txtFondo;
    private javax.swing.JLabel txtFoto;
    // End of variables declaration//GEN-END:variables
}
