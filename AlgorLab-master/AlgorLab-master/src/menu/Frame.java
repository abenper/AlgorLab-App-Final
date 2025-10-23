package menu;

import database.DbMenu;
import recursosForm.*;
import java.awt.*;
import javax.swing.*;
import login.*;

public class Frame extends recursosForm.FrameMovible {

    public Frame() {
        initComponents();
        setSize(1000, 500);
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        pc.labelBanner.setText("MENU PRINCIPAL");
        add(pc, BorderLayout.NORTH);

        super.hacerMovible(this, pc);
        setIconImage(super.getIconImage());

        ip = new InicioPanel();
        trabajadorP = new menu.trabajador.TrabajadorPanel(this);
        alumnosP = new menu.alumnos.AlumnosPanel(this);
        tareasP = new menu.tareas.TareasPanel(this);
        entregasP = new menu.entregas.EntregasPanel(this);

        menu();
        add(ip, BorderLayout.CENTER);
    }

    public void menu() {
        String tipo = bm.menuSelect(LoginPanel.usuario);
        if (tipo.equalsIgnoreCase("director")) {
            MenuDirector md = new MenuDirector(this);
            add(md, BorderLayout.WEST);
        } else {
            MenuProfesor mp = new MenuProfesor(this);
            add(mp, BorderLayout.WEST);
        }
        setVisible(true);
    }

    public void mostrarPanel(JPanel panelMostrar, String titulo) {
        pc.labelBanner.setText(titulo);
        
        ip.setVisible(false);
        
        trabajadorP.setVisible(false);
        trabajadorP.removeForm();
        
        alumnosP.setVisible(false);
        alumnosP.removeForm();
        
        tareasP.setVisible(false);
        tareasP.removeForm();
        
        entregasP.setVisible(false);
        entregasP.removeForm();
        
        panelMostrar.setVisible(true);
        
        add(panelMostrar, BorderLayout.CENTER);
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
            .addGap(0, 659, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    DbMenu bm = new DbMenu();
    InicioPanel ip;
    public menu.trabajador.TrabajadorPanel trabajadorP;
    public menu.alumnos.AlumnosPanel alumnosP;
    public menu.tareas.TareasPanel tareasP;
    public menu.entregas.EntregasPanel entregasP;
    public PanelControl pc = new PanelControl();
}
