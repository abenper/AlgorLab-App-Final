package menu.entregas;

import recursosForm.BtnRecursos;
import database.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import login.*;
import recursos.*;

public class EntregasPanel extends javax.swing.JPanel {

    public EntregasPanel(menu.Frame marco) {
        this.marco = marco;
        initComponents();
        setSize(850, 461);
        setBackground(new Color(242, 242, 242));
        initBtn();
        showTable(2);
    }

    private void initBtn() {
        BtnRecursos.btnBonito(btnCSharp);
        BtnRecursos.btnBonito(btnJava);
        BtnRecursos.btnBonito(btnPhp);
        BtnRecursos.reescalarIconBtn(btnCSharp, iconCSharp, 48);
        BtnRecursos.reescalarIconBtn(btnJava, iconJava, 48);
        BtnRecursos.reescalarIconBtn(btnPhp, iconPhp, 48);
    }

    private void showTable(int idCurso) {
        tablaResult.setVisible(true);
        tablaResult.setModel(da.slqEntregas(idCurso, dt.getId(LoginPanel.usuario)));
        tablaResult.getColumnModel().getColumn(3).setMinWidth(0);
        tablaResult.getColumnModel().getColumn(3).setMaxWidth(0);
        tablaResult.getColumnModel().getColumn(3).setWidth(0);
        tablaResult.getColumnModel().getColumn(3).setPreferredWidth(0);
        tablaResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaResult.getSelectedRow();
                if (filaSeleccionada != -1) {
                    if (tablaResult.getValueAt(filaSeleccionada, 3) != null) {
                        addForm();
                        int idTarea = Integer.parseInt(tablaResult.getValueAt(filaSeleccionada, 3).toString());
                        tpr.idEntrega = idTarea;
                        tpr.mostrarDatos();
                    } else {
                        if(mostrado){
                            removeForm();
                        }
                    }
                }
            }
        });
    }

    private void addForm() {
        marco.add(tpr, BorderLayout.EAST);
        marco.setSize(1550, 500);
        tpr.setVisible(true);
        if (mostrado == false) {
            marco.setLocationRelativeTo(null);
            mostrado = true;
        }
    }

    public void removeForm() {
        tpr.setVisible(false);
        marco.setSize(1000, 500);
        marco.setLocationRelativeTo(null);
        mostrado = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablaScroll = new javax.swing.JScrollPane();
        tablaResult = new javax.swing.JTable();
        btnCSharp = new javax.swing.JButton();
        btnJava = new javax.swing.JButton();
        btnPhp = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaResult.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaResult.setGridColor(new java.awt.Color(242, 242, 242));
        tablaResult.getTableHeader().setResizingAllowed(false);
        tablaResult.getTableHeader().setReorderingAllowed(false);
        tablaScroll.setViewportView(tablaResult);

        add(tablaScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 800, 230));

        btnCSharp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CSharp.png"))); // NOI18N
        btnCSharp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSharpActionPerformed(evt);
            }
        });
        add(btnCSharp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, 50));

        btnJava.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Java.png"))); // NOI18N
        btnJava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJavaActionPerformed(evt);
            }
        });
        add(btnJava, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 60, 50));

        btnPhp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PHP.png"))); // NOI18N
        btnPhp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhpActionPerformed(evt);
            }
        });
        add(btnPhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 60, 50));

        jSeparator1.setForeground(new java.awt.Color(46, 134, 193));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 805, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTROL CURSO");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 805, -1));

        jSeparator2.setForeground(new java.awt.Color(46, 134, 193));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 805, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCSharpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSharpActionPerformed
        showTable(2);
        removeForm();
    }//GEN-LAST:event_btnCSharpActionPerformed

    private void btnJavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJavaActionPerformed
        showTable(1);
        removeForm();
    }//GEN-LAST:event_btnJavaActionPerformed

    private void btnPhpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhpActionPerformed
        showTable(3);
        removeForm();
    }//GEN-LAST:event_btnPhpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCSharp;
    private javax.swing.JButton btnJava;
    private javax.swing.JButton btnPhp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tablaResult;
    private javax.swing.JScrollPane tablaScroll;
    // End of variables declaration//GEN-END:variables
    menu.Frame marco;
    EntregasPanelResultado tpr = new EntregasPanelResultado(this);
    ImageIcon iconCSharp = new ImageIcon("src/images/CSharp.png");
    ImageIcon iconJava = new ImageIcon("src/images/Java.png");
    ImageIcon iconPhp = new ImageIcon("src/images/PHP.png");
    DbEntregas da = new DbEntregas();
    DbTrabajador dt = new DbTrabajador();
    boolean mostrado = false;

}
