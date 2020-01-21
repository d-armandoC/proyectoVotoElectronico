/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.PersonaJpaController;
import java.util.Date;
import modelo.Persona;
import modeloTablaPersona.ModeloTablaPersona;

/**
 *
 * @author Diego Cale Pillco
 */
public class VentanaPersona extends javax.swing.JDialog {

    private final boolean modal;
    private final ModeloTablaPersona modelo;
    private final Persona p;
    private final PersonaJpaController pc;

    public VentanaPersona(java.awt.Frame parent, boolean modal, ModeloTablaPersona modelo, Persona persona, PersonaJpaController pc) {
        super(parent, modal);
        initComponents();
        this.modal = modal;
        this.modelo = modelo;
        this.p = persona;
        this.pc = pc;
        if (!this.modal) {
            fijarPersonaVista();
        }
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxCenero = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dtFecha = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        bttCancelar = new javax.swing.JButton();
        bttAceptar = new javax.swing.JButton();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jpCurso = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelRectTranslucido1.setColorDeBorde(new java.awt.Color(255, 204, 102));
        panelRectTranslucido1.setColorDeSegundoBorde(new java.awt.Color(0, 51, 204));
        panelRectTranslucido1.setColorPrimario(new java.awt.Color(0, 0, 204));
        panelRectTranslucido1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panelRectTranslucido1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRectTranslucido1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 210, 30));

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel1.setText("Nombre:");
        panelRectTranslucido1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        panelRectTranslucido1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 210, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel2.setText("Curso:");
        panelRectTranslucido1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        panelRectTranslucido1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 210, 30));
        panelRectTranslucido1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 210, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel3.setText("Cedula:");
        panelRectTranslucido1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel4.setText("Celular:");
        panelRectTranslucido1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));
        panelRectTranslucido1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 210, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel5.setText("Correo:");
        panelRectTranslucido1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        cbxCenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Masculino", "Femenino" }));
        panelRectTranslucido1.add(cbxCenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 156, 30));

        jLabel6.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel6.setText("Género:");
        panelRectTranslucido1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));
        panelRectTranslucido1.add(dtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 210, 30));

        jLabel7.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel7.setText("Fecha:");
        panelRectTranslucido1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        bttCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cross.gif"))); // NOI18N
        bttCancelar.setText("Cancelar");
        bttCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCancelarActionPerformed(evt);
            }
        });
        panelRectTranslucido1.add(bttCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, -1, 40));

        bttAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        bttAceptar.setText("Aceptar");
        bttAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAceptarActionPerformed(evt);
            }
        });
        panelRectTranslucido1.add(bttAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, 40));

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/personas.png"))); // NOI18N

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelRectTranslucido1.add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 100, 70));

        jpCurso.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        panelRectTranslucido1.add(jpCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 130, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel8.setText("Apellido:");
        panelRectTranslucido1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAceptarActionPerformed
        gestionarPersonaVista();
        limpiar();
    }//GEN-LAST:event_bttAceptarActionPerformed

    private void bttCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bttCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttAceptar;
    private javax.swing.JButton bttCancelar;
    private javax.swing.JComboBox<String> cbxCenero;
    private com.toedter.calendar.JDateChooser dtFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSpinner jpCurso;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void gestionarPersonaVista() {
        p.setNombre(txtNombre.getText());
        p.setApellido(txtApellido.getText());
        p.setCedula(txtCedula.getText());
        p.setCelular(txtCelular.getText());
        p.setCorreo(txtCorreo.getText());
        p.setGenero(cbxCenero.getSelectedIndex());
        p.setCurso(Integer.parseInt(jpCurso.getValue().toString()));
        p.setFechaNacimiento(dtFecha.getCalendar() != null ? dtFecha.getCalendar().getTime() : new Date());
        try {
            if (this.modal) {
                pc.create(p);
                modelo.addRow(p);
                dispose();
            } else {
                pc.edit(p);
                modelo.deleteRow(p);
                modelo.update(p);
                dispose();
            }
        } catch (Exception e) {
            System.out.println("Problemas en la Inserción");
        }

    }

    public int validarCampo(Integer i) {
        if (i != null) {
            return i;
        } else {
            return 0;
        }
    }

    public void fijarPersonaVista() {
        txtNombre.setText(p.getNombre());
        txtApellido.setText(p.getApellido());
        txtCedula.setText(p.getCedula());
        txtCelular.setText(p.getCelular());
        txtCorreo.setText(p.getCorreo());
        cbxCenero.setSelectedIndex(p.getGenero());
        dtFecha.setDate(p.getFechaNacimiento());
        jpCurso.setValue(validarCampo(p.getCurso()));
    }

    public void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtCelular.setText("");
        txtCorreo.setText("");
        cbxCenero.setSelectedIndex(0);
        jpCurso.setValue(0);
        dtFecha.setDate(new Date());
    }

}
