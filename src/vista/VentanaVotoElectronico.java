/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ListaJpaController;
import controlador.PersonaJpaController;
import controlador.VotoJpaController;
import controlador.VotoNuloJpaController;
import java.awt.Image;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Lista;
import modelo.Persona;
import modelo.Usuario;
import modelo.Voto;
import modelo.VotoNulo;
import persistencia.Factory;

/**
 *
 * @author Wilmer Guzman
 */
public class VentanaVotoElectronico extends javax.swing.JFrame {

    private final Usuario usuario;
    private final Factory f;
    private final VotoJpaController vc;
    private final VotoNuloJpaController vnc;
    private final PersonaJpaController pc;
    private final ListaJpaController lc;
    private Persona persona;

    public VentanaVotoElectronico(Usuario u, Factory f) {
        this.f = f;
        this.usuario = u;
        vc = new VotoJpaController(f.getEntityManagerFactory());
        vnc = new VotoNuloJpaController(f.getEntityManagerFactory());
        pc = new PersonaJpaController(f.getEntityManagerFactory());
        lc = new ListaJpaController(f.getEntityManagerFactory());
        initComponents();
        asignarFoto("0101010101");
        this.setExtendedState(MAXIMIZED_BOTH);//
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the VentanaVotoElectronico Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new org.edisoncor.gui.panel.Panel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel9 = new javax.swing.JLabel();
        bttLista2 = new javax.swing.JButton();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        panelImage4 = new org.edisoncor.gui.panel.PanelImage();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblfoto = new javax.swing.JLabel();
        bttExit = new org.edisoncor.gui.button.ButtonIcon();
        lblNombresPersona = new javax.swing.JLabel();
        bttNulo = new javax.swing.JButton();
        panelImage6 = new org.edisoncor.gui.panel.PanelImage();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel7 = new javax.swing.JLabel();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        bttLista1 = new javax.swing.JButton();
        panelImage5 = new org.edisoncor.gui.panel.PanelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 255));
        setForeground(new java.awt.Color(0, 0, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        panel2.setForeground(new java.awt.Color(0, 0, 255));
        panel2.setColorPrimario(new java.awt.Color(0, 0, 102));
        panel2.setColorSecundario(new java.awt.Color(255, 255, 255));

        panelImage1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presidentes/0106748932.png"))); // NOI18N

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText(" LISTA \"2\"");

        bttLista2.setBackground(new java.awt.Color(0, 51, 153));
        bttLista2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        bttLista2.setForeground(new java.awt.Color(255, 255, 255));
        bttLista2.setText("ELEGIR COMO PRESIDENTE  ESTUDIANTIL");
        bttLista2.setEnabled(false);
        bttLista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttLista2ActionPerformed(evt);
            }
        });

        panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JAP.jpg"))); // NOI18N

        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
        panelImage3.setLayout(panelImage3Layout);
        panelImage3Layout.setHorizontalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );
        panelImage3Layout.setVerticalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(bttLista2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(bttLista2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 680, 410));

        panelRect1.setColorDeBorde(new java.awt.Color(255, 255, 102));
        panelRect1.setColorDeSegundoBorde(new java.awt.Color(51, 51, 255));
        panelRect1.setColorPrimario(new java.awt.Color(0, 51, 153));
        panelRect1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panelRect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo1995.png"))); // NOI18N

        javax.swing.GroupLayout panelImage4Layout = new javax.swing.GroupLayout(panelImage4);
        panelImage4.setLayout(panelImage4Layout);
        panelImage4Layout.setHorizontalGroup(
            panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );
        panelImage4Layout.setVerticalGroup(
            panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        panelRect1.add(panelImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 682, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ELECCIONES DEL CONSEJO ESTUDIANTIL 2018");
        panelRect1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 1090, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel8.setText("CONSEJO ELECTORAL");
        panelRect1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("CEDULA :");
        panelRect1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 180, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("ESTUDIANTE :");
        panelRect1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 260, 60));

        txtCedula.setBackground(new java.awt.Color(0, 0, 153));
        txtCedula.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(255, 255, 0));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        panelRect1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 296, 59));

        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panelRect1.add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, 260, 260));

        bttExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        bttExit.setText("buttonIcon1");
        bttExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttExitActionPerformed(evt);
            }
        });
        panelRect1.add(bttExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 20, 90, 70));

        lblNombresPersona.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        panelRect1.add(lblNombresPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 510, 50));

        bttNulo.setBackground(new java.awt.Color(255, 0, 0));
        bttNulo.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        bttNulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cross.gif"))); // NOI18N
        bttNulo.setText("ANULAR VOTO");
        bttNulo.setEnabled(false);
        bttNulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttNuloActionPerformed(evt);
            }
        });
        panelRect1.add(bttNulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 159, 41));

        panelImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo1995.png"))); // NOI18N

        javax.swing.GroupLayout panelImage6Layout = new javax.swing.GroupLayout(panelImage6);
        panelImage6.setLayout(panelImage6Layout);
        panelImage6Layout.setHorizontalGroup(
            panelImage6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        panelImage6Layout.setVerticalGroup(
            panelImage6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        panelRect1.add(panelImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 190, 200));

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 340));

        panel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        panel1.setForeground(new java.awt.Color(0, 0, 255));
        panel1.setColorPrimario(new java.awt.Color(0, 0, 102));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText(" LISTA \"1\"");

        panelImage2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));
        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presidentes/1400947535.png"))); // NOI18N

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );
        panelImage2Layout.setVerticalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        bttLista1.setBackground(new java.awt.Color(0, 51, 153));
        bttLista1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        bttLista1.setForeground(new java.awt.Color(255, 255, 255));
        bttLista1.setText("ELEGIR COMO PRESIDENTE ESTUDIANTIL");
        bttLista1.setEnabled(false);
        bttLista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttLista1ActionPerformed(evt);
            }
        });

        panelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CEBC.jpg"))); // NOI18N

        javax.swing.GroupLayout panelImage5Layout = new javax.swing.GroupLayout(panelImage5);
        panelImage5.setLayout(panelImage5Layout);
        panelImage5Layout.setHorizontalGroup(
            panelImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
        panelImage5Layout.setVerticalGroup(
            panelImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(panelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(147, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttLista1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttLista1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 670, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String cd = txtCedula.getText().trim();
            if (cd.length() == 10 || cd.length() == 13) {
                persona = pc.buscarPersona(cd);
                if (persona != null) {
                    if (verificarSufragio(persona)) {
                        asignarFoto(persona.getCedula());
                        lblNombresPersona.setText(persona.getApellido() + " " + persona.getNombre());
                        activarBotones();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usted ya ejerció su derecho al Voto");
                        inicializarComponentes();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado información con esta cédula");
                    inicializarComponentes();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor Ingrese un número de cédula correcto");
                inicializarComponentes();
            }
        }
//        

    }//GEN-LAST:event_txtCedulaKeyPressed

    private void bttExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttExitActionPerformed
        String ps = JOptionPane.showInputDialog("Confirme su contraseña para realizar esta acción");
        try {
            if (!ps.equals(usuario.getContrasenia())) {
                 JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
            }else{
             dispose();
            }
        } catch (NullPointerException e) {
        }
    }//GEN-LAST:event_bttExitActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != java.awt.event.KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void bttLista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttLista1ActionPerformed
        int r = JOptionPane.showConfirmDialog(null, "Confirme su voto por la Lista 1 (CEBC)");
        if (r == 0) {
            ejecutarVoto("1");
        }
    }//GEN-LAST:event_bttLista1ActionPerformed

    private void bttLista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttLista2ActionPerformed
        int r = JOptionPane.showConfirmDialog(null, "Confirme su voto por la lista 2 (JAP)");
        if (r == 0) {
            ejecutarVoto("2");
        }
    }//GEN-LAST:event_bttLista2ActionPerformed

    private void bttNuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttNuloActionPerformed
        int r = JOptionPane.showConfirmDialog(null, "Realmente desea anular el Voto");
        if (r == 0) {
            ejecutarVotoNulo();
        }
    }//GEN-LAST:event_bttNuloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIcon bttExit;
    private javax.swing.JButton bttLista1;
    private javax.swing.JButton bttLista2;
    private javax.swing.JButton bttNulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblNombresPersona;
    private javax.swing.JLabel lblfoto;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private org.edisoncor.gui.panel.PanelImage panelImage4;
    private org.edisoncor.gui.panel.PanelImage panelImage5;
    private org.edisoncor.gui.panel.PanelImage panelImage6;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables

    public void asignarFoto(String cedula) {
        this.getClass().getResource("/foto/" + cedula + ".png");
        if (this.getClass().getResource("/foto/" + cedula + ".png") == null) {
            asignarFoto("0101010101");
        } else {
           
            ImageIcon foto = new ImageIcon(this.getClass().getResource("/foto/" + cedula + ".png"));
            Image img = foto.getImage();
            Image newimg = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newicon = new ImageIcon(newimg);
            lblfoto.setIcon(newicon);
        }
    }

    public void inicializarComponentes() {
        asignarFoto("0101010101");
        lblNombresPersona.setText("");
        txtCedula.setText("");
        desactivarBotones();
    }

    public void ejecutarVotoNulo() {
        VotoNulo vn = new VotoNulo();
        vn.setIdPersona(persona);
        vn.setFechaHoraRegistro(new Date());
        vnc.create(vn);
        JOptionPane.showMessageDialog(null, "Voto registrado como Anulado");
        inicializarComponentes();
    }

    public void ejecutarVoto(String tipoLista) {
        Lista lista = lc.getLista(tipoLista);
        Voto v = new Voto();
        v.setIdPersona(persona);
        v.setIdLista(lista);
        v.setFechaHoraRegistro(new Date());
        try {
            vc.create(v);
            JOptionPane.showMessageDialog(null, "Felicidades..! Voto realizado con éxito");
            inicializarComponentes();
        } catch (Exception e) {
        }

    }

    public void activarBotones() {
        bttNulo.setEnabled(true);
        bttLista1.setEnabled(true);
        bttLista2.setEnabled(true);
    }

    public void desactivarBotones() {
        bttNulo.setEnabled(false);
        bttLista1.setEnabled(false);
        bttLista2.setEnabled(false);
    }

    public boolean verificarSufragio(Persona p) {
        int voto = persona.getVotoList().size();
        int votoNulo = persona.getVotoNuloList().size();
        if (voto == 0 && votoNulo == 0) {
            return true;
        } else {
            return false;
        }
    }

}
