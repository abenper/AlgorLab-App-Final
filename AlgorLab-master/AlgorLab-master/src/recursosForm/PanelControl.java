package recursosForm;

import javax.swing.*;
import menu.*;
import recursos.*;

public class PanelControl extends JPanel {

    
    public PanelControl() {
        initComponents();
        setSize(700, 45);
        btnClose.setIcon(ReescalarImagen.resizeIcon(iconClose, 23, 23));
        btnMinimize.setIcon(ReescalarImagen.resizeIcon(iconMinimize, 23, 23));
        initBtn();
    }
    
    private void initBtn(){
        BtnRecursos.btnBonito(btnClose);
        BtnRecursos.btnBonito(btnMinimize);
        BtnRecursos.reescalarIconBtn(btnClose, iconClose, 23);
        BtnRecursos.reescalarIconBtn(btnMinimize, iconMinimize, 23);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMinimize = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        labelBanner = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(46, 134, 193));

        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Minimize.png"))); // NOI18N
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        labelBanner.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        labelBanner.setForeground(new java.awt.Color(255, 255, 255));
        labelBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBanner.setText("LOGIN ALGORLAB");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dev-Ico30x30.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelBanner, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        marco = (Frame) SwingUtilities.windowForComponent(btnMinimize);
        marco.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel labelBanner;
    // End of variables declaration//GEN-END:variables
    ImageIcon iconClose = new ImageIcon("src/images/Close.png");
    ImageIcon iconMinimize = new ImageIcon("src/images/Minimize.png");
    Frame marco;
}
