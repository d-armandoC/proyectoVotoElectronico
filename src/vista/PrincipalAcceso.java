/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import controlador.UsuarioJpaController;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Usuario;
import persistencia.Factory;

/**
 *
 * @author Diego Cale Pillco
 */


public class PrincipalAcceso extends javax.swing.JFrame {

    private final Factory f;
    private final UsuarioJpaController uc;
    private Usuario u;

    public PrincipalAcceso() {
        initComponents();
        progresoHilo.setVisible(false);
        setLocationRelativeTo(null);
        f = new Factory();
        uc = new UsuarioJpaController(f.getEntityManagerFactory());
         txtUsuario.requestFocus(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNice1 = new org.edisoncor.gui.panel.PanelNice();
        jRadioButton1 = new javax.swing.JRadioButton();
        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bttAceptar = new javax.swing.JButton();
        bttCancelar = new javax.swing.JButton();
        psPassword = new javax.swing.JPasswordField();
        progresoHilo = new javax.swing.JProgressBar();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRect1.setBackground(new java.awt.Color(204, 204, 204));
        panelRect1.setForeground(new java.awt.Color(255, 255, 255));
        panelRect1.setColorDeBorde(new java.awt.Color(255, 255, 255));
        panelRect1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panelRect1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panelRect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");
        panelRect1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");
        panelRect1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 20));

        bttAceptar.setBackground(new java.awt.Color(0, 0, 153));
        bttAceptar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        bttAceptar.setForeground(new java.awt.Color(255, 255, 255));
        bttAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/accept.png"))); // NOI18N
        bttAceptar.setText("Aceptar");
        bttAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAceptarActionPerformed(evt);
            }
        });
        panelRect1.add(bttAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 150, 60));

        bttCancelar.setBackground(new java.awt.Color(0, 0, 153));
        bttCancelar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        bttCancelar.setForeground(new java.awt.Color(255, 255, 255));
        bttCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cross.gif"))); // NOI18N
        bttCancelar.setText("Cancelar");
        bttCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCancelarActionPerformed(evt);
            }
        });
        panelRect1.add(bttCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 150, 60));

        psPassword.setBackground(new java.awt.Color(51, 51, 51));
        psPassword.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        psPassword.setForeground(new java.awt.Color(255, 255, 255));
        psPassword.setBorder(null);
        psPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        psPassword.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        psPassword.setSelectionColor(new java.awt.Color(255, 255, 204));
        psPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psPasswordActionPerformed(evt);
            }
        });
        psPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psPasswordKeyPressed(evt);
            }
        });
        panelRect1.add(psPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 250, 40));

        progresoHilo.setBackground(new java.awt.Color(255, 255, 255));
        progresoHilo.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        progresoHilo.setForeground(new java.awt.Color(0, 0, 0));
        panelRect1.add(progresoHilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 490, 30));
        panelRect1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 250, 10));
        panelRect1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 250, 10));

        txtUsuario.setBackground(new java.awt.Color(0, 0, 0));
        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setBorder(null);
        txtUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUsuario.setDisabledTextColor(new java.awt.Color(255, 255, 0));
        txtUsuario.setSelectionColor(new java.awt.Color(255, 255, 204));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        panelRect1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 250, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Captura.PNG"))); // NOI18N
        panelRect1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 380, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRect1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRect1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bttCancelarActionPerformed

    private void bttAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAceptarActionPerformed
        progresoHilo.setVisible(true);
        u = uc.validarUsuario(txtUsuario.getText(), String.valueOf(psPassword.getPassword()));
        generarTiempo(this);
        progresoHilo.setValue(1);
        progresoHilo.setStringPainted(true);
    }//GEN-LAST:event_bttAceptarActionPerformed

    private void psPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psPasswordKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            progresoHilo.setVisible(true);
            u = uc.validarUsuario(txtUsuario.getText(), String.valueOf(psPassword.getPassword()));
            generarTiempo(this);
            progresoHilo.setValue(1);
            progresoHilo.setStringPainted(true);
        }
    }//GEN-LAST:event_psPasswordKeyPressed

    private void psPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psPasswordActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
            PrincipalAcceso form = new PrincipalAcceso();
            form.setVisible(true);
        } catch (UnsupportedLookAndFeelException e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttAceptar;
    private javax.swing.JButton bttCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private org.edisoncor.gui.panel.PanelNice panelNice1;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private javax.swing.JProgressBar progresoHilo;
    private javax.swing.JPasswordField psPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    Thread tiempo;
    public int seg;

    public void generarTiempo(PrincipalAcceso parent) {
        tiempo = new Thread() {
            @Override
            public void run() {
                try {
                    for (seg = 1; seg <= 100; seg++) {
                        progresoHilo.setValue(seg);
                        Thread.sleep(8);
                    }
                    if (seg == 101) {
                        if (u != null) {
                            vista.AdministracionModulos administracionModulos = new AdministracionModulos(u, f, parent);
                            administracionModulos.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
                            limpiarCampos();
                            txtUsuario.requestFocus(true);
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        tiempo.start();
    }

    public void limpiarCampos() {
        txtUsuario.setText("");
        psPassword.setText("");
        progresoHilo.setVisible(false);
    }
}
