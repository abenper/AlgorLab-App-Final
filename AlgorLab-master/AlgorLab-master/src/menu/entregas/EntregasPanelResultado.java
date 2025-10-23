package menu.entregas;

import database.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;
import recursosForm.BtnRecursos;

public class EntregasPanelResultado extends JPanel {

    public EntregasPanelResultado(EntregasPanel panel) {
        initComponents();
        setSize(550, 463);
        setBackground(new Color(242, 242, 242));
        initBtn();
    }

    public void initBtn() {
        BtnRecursos.cambiarColorBtn(btnVerTarea, btnVerTarea.getBackground());
        BtnRecursos.cambiarColorBtn(btnCalificar, btnCalificar.getBackground());
    }

    public void mostrarDatos() {
        de.sqlMostrar(idEntrega);
        try {
            if (de.rs.next()) {
                textTarea.setText(de.rs.getString(1));
                textAlumno.setText(de.rs.getString(2));
                areaObservacion.setText(de.rs.getString(3));
                textCalificacion.setText(de.rs.getString(4));
                url = de.rs.getString(5);
            }
            de.cn.close();
        } catch (SQLException e) {
            System.err.println("ERROR MOSTRANDO DATOS TAREA: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        textTarea = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textAlumno = new javax.swing.JTextField();
        textCalificacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaObservacion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnCalificar = new javax.swing.JButton();
        btnVerTarea = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tarea");

        textTarea.setEditable(false);
        textTarea.setBackground(new java.awt.Color(255, 255, 255));
        textTarea.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textTarea.setBorder(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alumno");

        textAlumno.setEditable(false);
        textAlumno.setBackground(new java.awt.Color(255, 255, 255));
        textAlumno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textAlumno.setBorder(null);

        textCalificacion.setEditable(false);
        textCalificacion.setBackground(new java.awt.Color(255, 255, 255));
        textCalificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCalificacion.setBorder(null);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Calificación");

        areaObservacion.setColumns(20);
        areaObservacion.setRows(5);
        jScrollPane1.setViewportView(areaObservacion);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Observaciones Docente");

        btnCalificar.setText("Calificar");
        btnCalificar.setBorder(null);
        btnCalificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalificarActionPerformed(evt);
            }
        });

        btnVerTarea.setText("Ver Tarea");
        btnVerTarea.setBorder(null);
        btnVerTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTareaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnCalificar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(textCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalificar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTareaActionPerformed
        try {
            // Obtener la ruta al directorio "Documentos"
            String userHome = System.getProperty("user.home");
            String ruta = userHome + File.separator + "Documents" + File.separator + "GitHub" + File.separator + "AlgorLab_Web" + File.separator + url;

            File archivoPDF = new File(ruta);
            if (!archivoPDF.exists()) {
                System.out.println("El archivo no existe: " + ruta);
                return;
            }

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(archivoPDF.toURI());
            } else {
                System.out.println("Desktop no está soportado en este sistema.");
            }
        } catch (IOException e) {
            System.err.println("Error abriendo el archivo: " + e);
        }
    }//GEN-LAST:event_btnVerTareaActionPerformed

    private void btnCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalificarActionPerformed
        boolean bandera = false;
        String[] opcion = {"Aprobado", "Suspenso", "Cancelar"};

        if (areaObservacion.getText().equals("") || areaObservacion.getText().equalsIgnoreCase("sin observación")) {
            int resp = JOptionPane.showConfirmDialog(null, "El campo de observaciones esta vacío ¿Seguro que quieres continuar?", "Calificación Usuario", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (resp == 0) {
                bandera = true;
            }
        } else {
            bandera = true;
        }
        if (bandera) {
            int resp = JOptionPane.showOptionDialog(null, "Alumno: " + textAlumno.getText() + "\nTarea: " + textTarea.getText(), "Calificación Alumno", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcion, opcion[0]);
            if (resp == 0) {
                de.sqlCalificar(idEntrega, "Aprobado", areaObservacion.getText());
                mostrarDatos();
                JOptionPane.showMessageDialog(null, "Calificación actualizada con éxito", "Calificacion Actualizada", JOptionPane.INFORMATION_MESSAGE);
            } else if (resp == 1) {
                de.sqlCalificar(idEntrega, "Suspenso", areaObservacion.getText());
                mostrarDatos();
                JOptionPane.showMessageDialog(null, "Calificación actualizada con éxito", "Calificacion Actualizada", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCalificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaObservacion;
    private javax.swing.JButton btnCalificar;
    private javax.swing.JButton btnVerTarea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textAlumno;
    private javax.swing.JTextField textCalificacion;
    private javax.swing.JTextField textTarea;
    // End of variables declaration//GEN-END:variables
    DbEntregas de = new DbEntregas();
    String url = "";
    int idEntrega = 0;
}
