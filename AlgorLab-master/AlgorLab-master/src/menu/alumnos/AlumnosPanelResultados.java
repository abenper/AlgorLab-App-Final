package menu.alumnos;

import recursosForm.*;
import backend.*;
import database.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import recursos.*;

public class AlumnosPanelResultados extends JPanel {

    public AlumnosPanelResultados(AlumnosPanel panel) {
        this.panel = panel;
        initComponents();
        setSize(550, 463);
        setBackground(new Color(242, 242, 242));
        initText();
        initBtn();
    }

    private void initBtn() {
        BtnRecursos.btnBonito(btnAtras);
        BtnRecursos.btnBonito(btnConfirmar);
        BtnRecursos.btnBonito(btnBorrar);

        BtnRecursos.cambiarIcono(btnAtras, 40, iconAtras, iconAtrasFilled);
        BtnRecursos.reescalarIconBtn(btnConfirmar, iconConfirmar, 48);
        BtnRecursos.reescalarIconBtn(btnBorrar, iconBorrar, 48);
    }

    private void initText() {
        camposTexto.add(textNombre);
        camposTexto.add(textApellido);
        camposTexto.add(textFecha);
        camposTexto.add(textEmail);
        camposTexto.add(textContrasena);
        camposTexto.add(textCodigo);
        for (JTextField j : camposTexto){
            if(j != textEmail){
                camposValidar.validarCampo(j);
            }else{
                camposValidar.validarEmail(j);
            }
        }
    }

    public void mostrarDatos(String usuario) {
        borrarDatos();
        da.slqMostrar(usuario);
        try {
            if (da.rs.next()) {
                id = da.rs.getInt(1);
                textNombre.setText(da.rs.getString(2));
                textApellido.setText(da.rs.getString(3));
                textEmail.setText(da.rs.getString(4));
                textContrasena.setText(da.rs.getString(5));
                textCodigo.setText(da.rs.getString(6));
                comboTratamiento.setSelectedItem(da.rs.getString(7));
                comboMetodo.setSelectedItem(da.rs.getString(8));
                textFecha.setText(da.rs.getString(9));
            }
            da.cn.close();
        } catch (SQLException e) {
            System.err.println("Error mostrando datos" + e);
        }
        mostrarCursos();
        datosSet();
    }

    public void mostrarCursos() {
        da.getCursos(id);
        try {
            while (da.rs.next()) {
                int idCurso = da.rs.getInt("curso_id");
                if (idCurso == 1) {
                    chkJava.setSelected(true);
                } else if (idCurso == 2) {
                    chkCsharp.setSelected(true);
                } else if (idCurso == 3) {
                    chkPhp.setSelected(true);
                }
            }
            da.cn.close();
        } catch (SQLException e) {
            System.err.println("Error mostrando datos" + e);
        }
    }

    private void borrarDatos() {
        for (JTextField j : camposTexto) {
            j.setText("");
        }
        comboTratamiento.setSelectedIndex(2);
        comboMetodo.setSelectedIndex(0);
        chkJava.setSelected(false);
        chkCsharp.setSelected(false);
        chkPhp.setSelected(false);
    }

    public void datosSet() {
        tipo = EnumTipo.Alumno;

        switch (comboTratamiento.getSelectedIndex()) {
            case 0:
                tratamiento = EnumTratamiento.Masculino;
                break;
            case 1:
                tratamiento = EnumTratamiento.Femenino;
                break;
            default:
                tratamiento = EnumTratamiento.Otro;
        }

        switch (comboMetodo.getSelectedIndex()) {
            case 0:
                pago = EnumPago.Transferencia;
                break;
            case 1:
                pago = EnumPago.Tarjeta;
                break;
            case 2:
                pago = EnumPago.Paypal;
                break;
            default:
                pago = EnumPago.Bizum;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAtras = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        labelOperacion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textApellido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textContrasena = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboTratamiento = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboMetodo = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        chkJava = new javax.swing.JCheckBox();
        chkCsharp = new javax.swing.JCheckBox();
        chkPhp = new javax.swing.JCheckBox();

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tick.png"))); // NOI18N
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cross.png"))); // NOI18N
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Operación:");

        labelOperacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOperacion.setText("NO SELECCIONADA");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");

        textNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textNombre.setBorder(null);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Email");

        textEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textEmail.setBorder(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Apellidos");

        textApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textApellido.setBorder(null);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Contraseña");

        textContrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textContrasena.setBorder(null);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Fecha Registro");

        textFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFecha.setBorder(null);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tratamiento");

        comboTratamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otro" }));
        comboTratamiento.setBorder(null);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Código Recuperación");

        textCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCodigo.setBorder(null);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Método de Pago");

        comboMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transferencia", "Tarjeta", "Paypal", "Bizum" }));
        comboMetodo.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(46, 134, 193));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ACCESO A CURSOS");

        jSeparator2.setForeground(new java.awt.Color(46, 134, 193));

        chkJava.setText("JAVA");

        chkCsharp.setText("CSHARP");

        chkPhp.setText("PHP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(chkJava)
                .addGap(147, 147, 147)
                .addComponent(chkCsharp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkPhp)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(comboTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(textContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(comboTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkJava)
                    .addComponent(chkCsharp)
                    .addComponent(chkPhp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(6, 6, 6)
                        .addComponent(labelOperacion))
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        panel.removeForm();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Estás seguro de que borrar todos los datos del formulario?",
                "Confirmar borrado",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (opcion == JOptionPane.YES_OPTION) {
            borrarDatos();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String operacion = labelOperacion.getText().trim();
        datosSet();

        java = chkJava.isSelected();
        csharp = chkCsharp.isSelected();
        php = chkPhp.isSelected();

        ba = new BackAlumnos(
                textNombre.getText().trim(),
                textApellido.getText().trim(),
                textEmail.getText().trim(),
                textContrasena.getText().trim(),
                textCodigo.getText().trim(),
                tratamiento,
                tipo,
                pago
        );

        switch (operacion.toLowerCase()) {
            case "insertar":
                if (da.insertAlumno(ba.getNombre(), ba.getApellidos(), ba.getEmail(), ba.getContrasena(), ba.getCod_recuperacion(), ba.getTratamiento(), ba.getTipo(), ba.getPago())) {
                    JOptionPane.showMessageDialog(null, "El alumno se ha insertado con éxito.", "Insertando Alumno", JOptionPane.INFORMATION_MESSAGE);
                    id = da.getId(ba.getEmail());
                    da.concederCursos(id, java, csharp, php);
                    panel.showTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Error insertando el alumno.", "Insertando Alumno", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "actualizar":
                if (da.updateAlumno(id, ba.getNombre(), ba.getApellidos(), ba.getEmail(), ba.getContrasena(), ba.getCod_recuperacion(), ba.getTratamiento(), ba.getTipo(), ba.getPago())) {
                    JOptionPane.showMessageDialog(null, "El alumno se ha actualizado con éxito.", "Actualizando Alumno", JOptionPane.INFORMATION_MESSAGE);
                    da.concederCursos(id, java, csharp, php);
                    panel.showTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Error actualizando el alumno.", "Actualizando Alumno", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "borrar":
                int confirmacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estás seguro de que deseas eliminar al alumno?",
                        "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (da.deleteUsuario(id)) {
                        JOptionPane.showMessageDialog(null, "El alumno ha sido eliminado correctamente.", "Eliminando Alumno", JOptionPane.INFORMATION_MESSAGE);
                        da.concederCursos(id, false, false, false);
                        panel.showTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error eliminando el alumno.", "Eliminando Alumno", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "No tienes operación seleccionada.", "Error Operaciones", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    public javax.swing.JButton btnBorrar;
    public javax.swing.JButton btnConfirmar;
    private javax.swing.JCheckBox chkCsharp;
    private javax.swing.JCheckBox chkJava;
    private javax.swing.JCheckBox chkPhp;
    private javax.swing.JComboBox<String> comboMetodo;
    private javax.swing.JComboBox<String> comboTratamiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel labelOperacion;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textContrasena;
    private javax.swing.JTextField textEmail;
    public javax.swing.JTextField textFecha;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
    ImageIcon iconAtras = new ImageIcon("src/images/Back.png");
    ImageIcon iconAtrasFilled = new ImageIcon("src/images/BackFilled.png");
    ImageIcon iconConfirmar = new ImageIcon("src/images/Tick.png");
    ImageIcon iconBorrar = new ImageIcon("src/images/Cross.png");
    ArrayList<JTextField> camposTexto = new ArrayList<>();
    DbAlumno da = new DbAlumno();
    CamposValidador camposValidar = new CamposValidador();
    BackAlumnos ba;
    EnumTipo tipo;
    EnumTratamiento tratamiento;
    EnumPago pago;
    AlumnosPanel panel;
    private int id = 0;
    boolean java = false;
    boolean csharp = false;
    boolean php = false;
}
