package menu;

import recursosForm.BtnRecursos;
import database.DbMenu;
import java.awt.*;
import recursos.*;
import javax.swing.*;
import login.Login;

public class MenuDirector extends JPanel {

    public MenuDirector(Frame marco) {
        this.marco = marco;
        initComponents();
        setSize(140, 459);
        DbMenu dm = new DbMenu();
        dm.tratamiento(labelIcono, labelTratamiento, labelNombre);
        initBtn();
    }

    public void initBtn() {
        Color color = new Color(115, 174, 213);
        BtnRecursos.btnTransparente(btnTrabajador);
        BtnRecursos.btnTransparente(btnAlumnos);
        BtnRecursos.btnTransparente(btnTareas);
        BtnRecursos.btnTransparente(btnEntregas);
        BtnRecursos.cambiarColorBtn(btnTrabajador, color);
        BtnRecursos.cambiarColorBtn(btnAlumnos, color);
        BtnRecursos.cambiarColorBtn(btnTareas, color);
        BtnRecursos.cambiarColorBtn(btnEntregas, color);
        
        BtnRecursos.btnBonito(btnLogout);
        BtnRecursos.btnBonito(btnHome);
        btnHome.setIcon(ReescalarImagen.resizeIcon(iconHome, 35, 35));
        
        BtnRecursos.cambiarIcono(btnLogout, 35, iconClosedLogout, iconOpenLogout);
        BtnRecursos.cambiarIcono(btnHome, 35, iconHome, iconHomeSelected);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTrabajador = new javax.swing.JButton();
        btnTareas = new javax.swing.JButton();
        btnEntregas = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        labelIcono = new javax.swing.JLabel();
        labelTratamiento = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();

        setBackground(new java.awt.Color(46, 134, 193));

        btnTrabajador.setBackground(new java.awt.Color(115, 174, 213));
        btnTrabajador.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        btnTrabajador.setForeground(new java.awt.Color(255, 255, 255));
        btnTrabajador.setText("TRABAJADOR");
        btnTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrabajadorActionPerformed(evt);
            }
        });

        btnTareas.setBackground(new java.awt.Color(115, 174, 213));
        btnTareas.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        btnTareas.setForeground(new java.awt.Color(255, 255, 255));
        btnTareas.setText("TAREAS");
        btnTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTareasActionPerformed(evt);
            }
        });

        btnEntregas.setBackground(new java.awt.Color(115, 174, 213));
        btnEntregas.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        btnEntregas.setForeground(new java.awt.Color(255, 255, 255));
        btnEntregas.setText("ENTREGAS");
        btnEntregas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregasActionPerformed(evt);
            }
        });

        btnAlumnos.setBackground(new java.awt.Color(115, 174, 213));
        btnAlumnos.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        btnAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnAlumnos.setText("ALUMNOS");
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });

        labelIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Otro.png"))); // NOI18N

        labelTratamiento.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        labelTratamiento.setForeground(new java.awt.Color(255, 255, 255));
        labelTratamiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTratamiento.setText("Bienvenid@");

        labelNombre.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombre.setText("nombre");

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoutClosed.png"))); // NOI18N
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTratamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelIcono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEntregas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTareas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrabajador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(btnAlumnos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(labelIcono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTratamiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNombre)
                .addGap(47, 47, 47)
                .addComponent(btnTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntregas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        marco.dispose();
        Login lg = new Login();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabajadorActionPerformed
        marco.mostrarPanel(marco.trabajadorP, "MENU TRABAJADOR");
    }//GEN-LAST:event_btnTrabajadorActionPerformed

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        marco.mostrarPanel(marco.alumnosP, "MENU ALUMNOS");
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTareasActionPerformed
        marco.mostrarPanel(marco.tareasP, "MENU TAREAS");
    }//GEN-LAST:event_btnTareasActionPerformed

    private void btnEntregasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregasActionPerformed
        marco.mostrarPanel(marco.entregasP, "MENU ENTREGAS");
    }//GEN-LAST:event_btnEntregasActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        marco.mostrarPanel(marco.ip, "MENU PRINCIPAL");
    }//GEN-LAST:event_btnHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnEntregas;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTareas;
    private javax.swing.JButton btnTrabajador;
    private javax.swing.JLabel labelIcono;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTratamiento;
    // End of variables declaration//GEN-END:variables
    ImageIcon iconClosedLogout = new ImageIcon("src/images/LogoutClosed.png");
    ImageIcon iconOpenLogout = new ImageIcon("src/images/LogoutOpen.png");
    ImageIcon iconHome = new ImageIcon("src/images/Home.png");
    ImageIcon iconHomeSelected = new ImageIcon("src/images/HomeSelected.png");
    Frame marco;
}
