package menu.tareas;

import recursosForm.BtnRecursos;
import database.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import recursos.*;

public class TareasPanel extends javax.swing.JPanel {

    public TareasPanel(menu.Frame marco) {
        this.marco = marco;
        initComponents();
        setSize(850, 461);
        setBackground(new Color(242, 242, 242));
        initBtn();
        showTable();
    }

    private void initBtn() {
        BtnRecursos.btnBonito(btnMas);
        BtnRecursos.cambiarIcono(btnMas, 50, iconMas, iconMasRelleno);
    }

    public void showTable() {
        tablaResult.setVisible(true);
        tablaResult.setModel(dt.slqTareas());
        tablaResult.getColumnModel().getColumn(3).setMinWidth(0);
        tablaResult.getColumnModel().getColumn(3).setMaxWidth(0);
        tablaResult.getColumnModel().getColumn(3).setWidth(0);
        tablaResult.getColumnModel().getColumn(3).setPreferredWidth(0);
        tablaResult.getColumnModel().getColumn(4).setMinWidth(0);
        tablaResult.getColumnModel().getColumn(4).setMaxWidth(0);
        tablaResult.getColumnModel().getColumn(4).setWidth(0);
        tablaResult.getColumnModel().getColumn(4).setPreferredWidth(0);
        tablaResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaResult.getSelectedRow();
                if (filaSeleccionada != -1) {
                    if (tablaResult.getValueAt(filaSeleccionada, 3) != null) {
                        addForm();
                        int idTarea = Integer.parseInt(tablaResult.getValueAt(filaSeleccionada, 4).toString());
                        tpr.mostrarDatos(idTarea);
                    } else {
                        if (mostrado) {
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
        btnMas.setVisible(false);
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
        btnMas.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablaScroll = new javax.swing.JScrollPane();
        tablaResult = new javax.swing.JTable();
        btnMas = new javax.swing.JButton();

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

        add(tablaScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 720, 420));

        btnMas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Mas.png"))); // NOI18N
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });
        add(btnMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 60, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        addForm();
    }//GEN-LAST:event_btnMasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMas;
    private javax.swing.JTable tablaResult;
    private javax.swing.JScrollPane tablaScroll;
    // End of variables declaration//GEN-END:variables
    menu.Frame marco;
    TareasPanelResultado tpr = new TareasPanelResultado(this);
    ImageIcon iconMas = new ImageIcon("src/images/Mas.png");
    ImageIcon iconMasRelleno = new ImageIcon("src/images/MasRelleno.png");
    DbTareas dt = new DbTareas();
    boolean mostrado = false;
}
