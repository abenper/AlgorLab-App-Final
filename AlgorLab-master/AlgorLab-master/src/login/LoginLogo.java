package login;

import javax.swing.*;
import recursos.*;

public class LoginLogo extends JPanel {

    public LoginLogo() {
        initComponents();
        setSize(200, 300);
        initImages();
    }

    public void initImages() {
        labelAlgor.setIcon(ReescalarImagen.resizeIcon(iconAlgor, 155, 170));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAlgor = new javax.swing.JLabel();

        setBackground(new java.awt.Color(46, 134, 193));

        labelAlgor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AlgorLab.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelAlgor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(labelAlgor, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelAlgor;
    // End of variables declaration//GEN-END:variables
    ImageIcon iconAlgor = new ImageIcon("src/images/AlgorLab.png");
}

