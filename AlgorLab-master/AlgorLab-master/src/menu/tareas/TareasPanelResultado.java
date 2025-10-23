package menu.tareas;

import recursosForm.BtnRecursos;
import backend.BackTareas;
import java.awt.*;
import javax.swing.*;
import recursos.*;
import database.*;
import java.sql.*;

public class TareasPanelResultado extends JPanel {

    public TareasPanelResultado(TareasPanel panel) {
        this.panel = panel;
        initComponents();
        setSize(650, 446);
        setBackground(new Color(242, 242, 242));
        initBtn();
    }

    private void initBtn() {
        BtnRecursos.btnBonito(btnAtras);
        BtnRecursos.cambiarIcono(btnAtras, 40, iconAtras, iconAtrasFilled);

        BtnRecursos.cambiarColorBtn(btnInsertar, btnInsertar.getBackground());
        BtnRecursos.cambiarColorBtn(btnUpdate, btnUpdate.getBackground());
        BtnRecursos.cambiarColorBtn(btnDelete, btnDelete.getBackground());
    }

    public void mostrarDatos(int id) {
        int cursoId = 0;
        dt.sqlMostrar(id);
        this.id = id;
        try {
            if (dt.rs.next()) {
                textTitulo.setText(dt.rs.getString(1));
                areaDescripcion.setText(dt.rs.getString(2));
                sqlDate = dt.rs.getDate(3);
                utilDate = new java.util.Date(sqlDate.getTime());
                dateChooser.setDate(utilDate);
                cursoId = dt.rs.getInt(4);
            }
            dt.cn.close();
        } catch (SQLException e) {
            System.err.println("ERROR MOSTRANDO DATOS TAREA: " + e);
        }
        switch (cursoId) {
            case 2:
                comboCurso.setSelectedIndex(1);
                break;
            case 3:
                comboCurso.setSelectedIndex(2);
                break;
            default:
                comboCurso.setSelectedIndex(0);
        }
    }

    public void setDatos() {
        switch (comboCurso.getSelectedIndex()) {
            case 0:
                idCurso = 1;
                break;
            case 1:
                idCurso = 2;
                break;
            case 2:
                idCurso = 3;
                break;
            default:
        }
        utilDate = dateChooser.getDate();
        sqlDate = new java.sql.Date(utilDate.getTime());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textTitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        comboCurso = new javax.swing.JComboBox<>();
        btnAtras = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        textTitulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Título Tarea");

        areaDescripcion.setColumns(20);
        areaDescripcion.setRows(5);
        jScrollPane1.setViewportView(areaDescripcion);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Descripción");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fecha de Entrega");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Curso");

        comboCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java", "CSharp", "PHP" }));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnInsertar.setText("INSERTAR");
        btnInsertar.setBorder(null);
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.setBorder(null);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.setBorder(null);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(68, 68, 68)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        panel.removeForm();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        setDatos();
        bt = new BackTareas(idCurso, textTitulo.getText().trim(), areaDescripcion.getText().trim(), sqlDate);
        if (dt.insertarTarea(bt.getCurso_id(), bt.getTitulo(), bt.getDescripcion(), bt.getFecha())) {
            JOptionPane.showMessageDialog(null, "La tarea se ha creado con éxito", "Creando Tarea", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La tarea no se ha creado con éxito", "Creando Tarea", JOptionPane.ERROR_MESSAGE);
        }
        panel.showTable();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        setDatos();
        bt = new BackTareas(idCurso, textTitulo.getText().trim(), areaDescripcion.getText().trim(), sqlDate);
        if (dt.actualizarTarea(id, bt.getCurso_id(), bt.getTitulo(), bt.getDescripcion(), bt.getFecha())) {
            JOptionPane.showMessageDialog(null, "La tarea se ha actualizado con éxito", "Actualizando Tarea", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La tarea no se ha actualizado con éxito", "Actualizando Tarea", JOptionPane.ERROR_MESSAGE);
        }
        panel.showTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (dt.eliminarTarea(id)) {
            JOptionPane.showMessageDialog(null, "La tarea se ha eliminado con éxito", "Eliminando Tarea", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La tarea no se ha eliminado con éxito", "Eliminando Tarea", JOptionPane.ERROR_MESSAGE);
        }
        panel.showTable();
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescripcion;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboCurso;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
    ImageIcon iconAtras = new ImageIcon("src/images/Back.png");
    ImageIcon iconAtrasFilled = new ImageIcon("src/images/BackFilled.png");
    TareasPanel panel;
    DbTareas dt = new DbTareas();
    BackTareas bt;
    private int id;
    private int idCurso;
    java.sql.Date sqlDate;
    java.util.Date utilDate;
}
