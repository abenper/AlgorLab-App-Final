package login;

import recursosForm.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends FrameMovible {

    public Login() {
        initComponents();
        setSize(600, 300);
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);

        getContentPane().setLayout(new BorderLayout());

        add(pc, BorderLayout.NORTH);
        add(ll, BorderLayout.WEST);
        add(lp, BorderLayout.CENTER);

        super.hacerMovible(this, pc);
        setIconImage(super.getIconImage());

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    LoginPanel lp = new LoginPanel(this);
    LoginLogo ll = new LoginLogo();
    PanelControl pc = new PanelControl();
}
