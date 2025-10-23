package login;

import database.DbLogin;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import recursosForm.BtnRecursos;
import recursos.ReescalarImagen;

public class LoginPanel extends JPanel implements ActionListener {

    public LoginPanel(Login login) {
        this.login = login;
        initComponents();
        setSize(385, 254);
        initBtn();
    }

    public void initBtn() {
        iconos.put("retroceso", new ImageIcon("src/images/IrAtras.png"));
        iconos.put("contrasena", new ImageIcon("src/images/ContraseñaIcon.png"));
        iconos.put("recu", new ImageIcon("src/images/RecuContra.png"));
        btnEntrar.addActionListener(this);
        btnRetroceso.setVisible(false);
        BtnRecursos.btnBonito(btnRetroceso);
        btnRetroceso.setIcon(ReescalarImagen.resizeIcon(iconos.get("retroceso"), 29, 29));
        BtnRecursos.reescalarIconBtn(btnRetroceso, iconos.get("retroceso"), 29);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEntrar) {
            usuario = txtUsuario.getText().trim();
            String pass = new String(txtContrasenia.getPassword());
            DbLogin dl = new DbLogin();
            if (recuperar) {
                dl.recuContra(txtUsuario.getText().trim(), pass.trim());
            } else {
                dl.login(login, txtUsuario.getText().trim(), pass.trim());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        labelContrasena = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        labelRecuperar = new javax.swing.JLabel();
        btnRetroceso = new javax.swing.JButton();

        setBackground(new java.awt.Color(115, 174, 213));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/UsuarioIcon.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 30, 44, 50));
        add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 42, 206, 30));

        labelContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ContraseñaIcon.png"))); // NOI18N
        add(labelContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 100, 44, -1));
        add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 110, 206, 30));

        btnEntrar.setBackground(new java.awt.Color(255, 204, 102));
        btnEntrar.setText("Entrar");
        add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 159, 102, 35));

        labelRecuperar.setBackground(new java.awt.Color(218, 218, 218));
        labelRecuperar.setForeground(new java.awt.Color(255, 255, 255));
        labelRecuperar.setText("¿Has olvidado tu contraseña?");
        labelRecuperar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRecuperar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRecuperarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelRecuperarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelRecuperarMouseExited(evt);
            }
        });
        add(labelRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 206, -1, -1));

        btnRetroceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IrAtras.png"))); // NOI18N
        btnRetroceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocesoActionPerformed(evt);
            }
        });
        add(btnRetroceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 16, 30, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void labelRecuperarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRecuperarMouseClicked
        recuperar = true;
        btnRetroceso.setVisible(true);
        labelRecuperar.setVisible(false);
        labelContrasena.setIcon(iconos.get("recu"));
        btnEntrar.setText("Cambiar");
    }//GEN-LAST:event_labelRecuperarMouseClicked

    private void labelRecuperarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRecuperarMouseEntered
        setForeground(new Color(218, 218, 218));
    }//GEN-LAST:event_labelRecuperarMouseEntered

    private void labelRecuperarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRecuperarMouseExited
        setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_labelRecuperarMouseExited

    private void btnRetrocesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocesoActionPerformed
        recuperar = false;
        btnRetroceso.setVisible(false);
        labelRecuperar.setVisible(true);
        labelContrasena.setIcon(iconos.get("contrasena"));
        btnEntrar.setText("Entrar");
    }//GEN-LAST:event_btnRetrocesoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnRetroceso;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelContrasena;
    private static javax.swing.JLabel labelRecuperar;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    public static String usuario;
    public static String tratamiento;
    Login login;
    Boolean recuperar = false;
    HashMap<String, ImageIcon> iconos = new HashMap<>();
}
