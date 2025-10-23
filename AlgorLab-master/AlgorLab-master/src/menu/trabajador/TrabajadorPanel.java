package menu.trabajador;

import recursosForm.BtnRecursos;
import database.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import recursos.*;

public class TrabajadorPanel extends JPanel {

    public TrabajadorPanel(menu.Frame marco) {
        this.marco = marco;
        initComponents();
        setSize(850, 461);
        setBackground(new Color(242, 242, 242));
        initBtn();
        showTable();
        activarBotones();
    }

    private void initBtn() {
        BtnRecursos.toggleBonito(btnLock);
        BtnRecursos.btnBonito(btnInsert);
        BtnRecursos.btnBonito(btnDelete);
        BtnRecursos.btnBonito(btnUpdate);
        BtnRecursos.reescalarIconBtn(btnInsert, iconInsert, 46);
        BtnRecursos.reescalarIconBtn(btnDelete, iconDelete, 46);
        BtnRecursos.reescalarIconBtn(btnUpdate, iconUpdate, 46);
        btnInsert.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
    }

    private void activarBotones() {
        if (btnLock.isSelected()) {
            btnLock.setIcon(iconUnlock);
            btnInsert.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            tpr.btnConfirmar.setEnabled(true);
            tpr.btnBorrar.setEnabled(true);
        } else {
            btnLock.setIcon(iconLock);
            btnInsert.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            tpr.btnConfirmar.setEnabled(false);
            tpr.btnBorrar.setEnabled(false);
        }
    }

    public void showTable() {
        tablaResult.setVisible(true);
        tablaResult.setModel(bt.slqUsuario());
        tablaResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaResult.getSelectedRow();
                if (filaSeleccionada != -1) {
                    addForm();
                    String usuario = tablaResult.getValueAt(filaSeleccionada, 2).toString();
                    tpr.mostrarDatos(usuario);
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
        btnDelete = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLock = new javax.swing.JToggleButton();

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

        add(tablaScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 6, 770, 340));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 398, 43, 43));

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Insert.png"))); // NOI18N
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 398, 43, 43));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Update.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(773, 398, 43, 43));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edición");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 364, 43, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Controles de operación");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 364, 228, -1));

        btnLock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lock.png"))); // NOI18N
        btnLock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLockActionPerformed(evt);
            }
        });
        add(btnLock, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 386, 44, 43));
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if(!mostrado){
            addForm();
        }
        tpr.labelOperacion.setForeground(Color.green);
        tpr.labelOperacion.setText("INSERTAR");
        tpr.labelSueldo.setText("Sueldo");
        tpr.textFecha.setEnabled(false);
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        tpr.labelOperacion.setForeground(Color.red);
        tpr.labelOperacion.setText("Borrar");
        tpr.labelSueldo.setText("Sueldo");
        tpr.textFecha.setEnabled(true);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        tpr.labelOperacion.setForeground(Color.blue);
        tpr.labelOperacion.setText("Actualizar");
        tpr.labelSueldo.setText("Sueldo");
        tpr.textFecha.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnLockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLockActionPerformed
        activarBotones();
    }//GEN-LAST:event_btnLockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JToggleButton btnLock;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTable tablaResult;
    private javax.swing.JScrollPane tablaScroll;
    // End of variables declaration//GEN-END:variables
    ImageIcon iconLock = new ImageIcon("src/images/Lock.png");
    ImageIcon iconUnlock = new ImageIcon("src/images/UnLock.png");
    ImageIcon iconInsert = new ImageIcon("src/images/Insert.png");
    ImageIcon iconDelete = new ImageIcon("src/images/Delete.png");
    ImageIcon iconUpdate = new ImageIcon("src/images/Update.png");
    DbTrabajador bt = new DbTrabajador();
    TrabajadorPanelResultados tpr = new TrabajadorPanelResultados(this);
    menu.Frame marco;
    static boolean mostrado = false;
}
