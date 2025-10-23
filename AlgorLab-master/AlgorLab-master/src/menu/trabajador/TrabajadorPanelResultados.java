package menu.trabajador;

import recursosForm.*;
import database.*;
import backend.*;
import java.awt.*;
import javax.swing.*;
import recursos.*;
import java.sql.*;
import java.util.ArrayList;

public class TrabajadorPanelResultados extends JPanel {

    public TrabajadorPanelResultados(TrabajadorPanel panel) {
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
        camposTexto.add(textSueldo);
        for (JTextField j : camposTexto) {
            if (j == textEmail) {
                camposValidar.validarEmail(j);
            }else if(j == textSueldo) {
                camposValidar.validarCampo(j);
                camposValidar.soloNumeros(j);
            }else{
                camposValidar.validarCampo(j);
            }
        }
    }

    public void mostrarDatos(String usuario) {
        int sueldoDirector;
        borrarDatos();
        dt.slqMostrar(usuario);
        try {
            if (dt.rs.next()) {
                id = dt.rs.getInt(1);
                textNombre.setText(dt.rs.getString(2));
                textApellido.setText(dt.rs.getString(3));
                textEmail.setText(dt.rs.getString(4));
                textContrasena.setText(dt.rs.getString(5));
                textCodigo.setText(dt.rs.getString(6));
                radio = dt.rs.getString(7);
                sueldo = dt.rs.getInt(8);
                textFecha.setText(dt.rs.getString(9));
                comboTipo.setSelectedItem(dt.rs.getString(10));
            }
            dt.cn.close();
        } catch (SQLException e) {
            System.err.println("Error mostrando datos" + e);
        }
        if (comboTipo.getSelectedItem() == "Director") {
            labelSueldo.setText("Sueldo + Sobresueldo");
            sueldoDirector = sueldo + ss.sobreSueldo();
            textSueldo.setText("" + sueldoDirector);
        } else {
            labelSueldo.setText("Sueldo");
            textSueldo.setText("" + sueldo);
        }
        switch (radio) {
            case "Masculino" ->
                radioMasculino.setSelected(true);
            case "Femenino" ->
                radioFemenino.setSelected(true);
            case "Otro" ->
                radioOtro.setSelected(true);
            default -> {
            }
        }
        mostrarCursos();
        datosSet();
    }

    public void mostrarCursos() {
        dt.getCursos(id);
        try {
            while (dt.rs.next()) {
                int idCurso = dt.rs.getInt("curso_id");
                switch (idCurso) {
                    case 1 ->
                        chkJava.setSelected(true);
                    case 2 ->
                        chkCsharp.setSelected(true);
                    case 3 ->
                        chkPhp.setSelected(true);
                    default -> {
                    }
                }
            }
            dt.cn.close();
        } catch (SQLException e) {
            System.err.println("Error mostrando datos" + e);
        }
    }

    private void borrarDatos() {
        for (JTextField j : camposTexto) {
            j.setText("");
        }
        grupoTratamiento.clearSelection();
        comboTipo.setSelectedIndex(1);
        chkJava.setSelected(false);
        chkCsharp.setSelected(false);
        chkPhp.setSelected(false);
    }

    public void datosSet() {
        if (comboTipo.getSelectedIndex() == 0) {
            tipo = EnumTipo.Director;
        } else {
            tipo = EnumTipo.Profesor;
        }
        if (radioMasculino.isSelected()) {
            tratamiento = EnumTratamiento.Masculino;
        } else if (radioFemenino.isSelected()) {
            tratamiento = EnumTratamiento.Femenino;
        } else {
            tratamiento = EnumTratamiento.Otro;
        }
        sueldo = Integer.parseInt(textSueldo.getText().trim());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoTratamiento = new javax.swing.ButtonGroup();
        btnAtras = new javax.swing.JButton();
        textApellido = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textFecha = new javax.swing.JTextField();
        textContrasena = new javax.swing.JTextField();
        textCodigo = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        labelOperacion = new javax.swing.JLabel();
        labelSueldo = new javax.swing.JLabel();
        textSueldo = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        radioMasculino = new javax.swing.JRadioButton();
        radioFemenino = new javax.swing.JRadioButton();
        radioOtro = new javax.swing.JRadioButton();
        chkJava = new javax.swing.JCheckBox();
        chkCsharp = new javax.swing.JCheckBox();
        chkPhp = new javax.swing.JCheckBox();

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        textApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        textNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        textFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        textContrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        textCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCodigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        textEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Apellidos");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tratamiento");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Fecha Registro");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Email");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Contraseña");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Código Recuperación");

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

        labelSueldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSueldo.setText("Sueldo");

        textSueldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textSueldo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Director", "Profesor" }));
        comboTipo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tipo");

        jSeparator1.setForeground(new java.awt.Color(46, 134, 193));

        jSeparator2.setForeground(new java.awt.Color(46, 134, 193));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ACCESO A CURSOS");

        grupoTratamiento.add(radioMasculino);
        radioMasculino.setText("Masculino");

        grupoTratamiento.add(radioFemenino);
        radioFemenino.setText("Femenino");

        grupoTratamiento.add(radioOtro);
        radioOtro.setText("Otro");

        chkJava.setText("JAVA");

        chkCsharp.setText("CSHARP");

        chkPhp.setText("PHP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(textContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(50, 50, 50)
                                    .addComponent(labelSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(50, 50, 50)
                                    .addComponent(textSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioMasculino)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(radioFemenino)
                                        .addGap(82, 82, 82)))
                                .addComponent(radioOtro)))))
                .addGap(0, 19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(chkJava)
                .addGap(133, 133, 133)
                .addComponent(chkCsharp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkPhp)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(6, 6, 6)
                        .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addGap(9, 9, 9)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(labelSueldo))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMasculino)
                    .addComponent(radioFemenino)
                    .addComponent(radioOtro))
                .addGap(18, 18, 18)
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
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(6, 6, 6)
                        .addComponent(labelOperacion))
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        bt = new BackTrabajador(
                textNombre.getText().trim(),
                textApellido.getText().trim(),
                textEmail.getText().trim(),
                textContrasena.getText().trim(),
                textCodigo.getText().trim(),
                tratamiento,
                tipo,
                sueldo
        );
        switch (operacion.toLowerCase()) {
            case "insertar":
                if (dt.insertTrabajador(bt.getNombre(), bt.getApellidos(), bt.getEmail(), bt.getContrasena(), bt.getCod_recuperacion(), bt.getTratamiento(), bt.getTipo(), bt.getSueldo())) {
                    JOptionPane.showMessageDialog(null, "El trabajador se ha insertado con éxito.", "Insertando Trabajador", JOptionPane.INFORMATION_MESSAGE);
                    id = dt.getId(bt.getEmail());
                    dt.concederCursos(id, java, csharp, php);
                    panel.showTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Error insertando el trabajador.", "Insertando Trabajador", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "actualizar":
                if (dt.updateTrabajador(id, bt.getNombre(), bt.getApellidos(), bt.getEmail(), bt.getContrasena(), bt.getCod_recuperacion(), bt.getTratamiento(), bt.getTipo(), bt.getSueldo())) {
                    JOptionPane.showMessageDialog(null, "El trabajador se ha actualizado con éxito.", "Actualizando Trabajador", JOptionPane.INFORMATION_MESSAGE);
                    dt.concederCursos(id, java, csharp, php);
                    panel.showTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Error actualizando el trabajador.", "Actualizando Trabajador", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "borrar":
                int confirmacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estás seguro de que deseas eliminar al trabajador?",
                        "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (dt.deleteUsuario(id)) {
                        JOptionPane.showMessageDialog(null, "El trabajador ha sido eliminado correctamente.", "Eliminando Trabajador", JOptionPane.INFORMATION_MESSAGE);
                        dt.concederCursos(id, false, false, false);
                        panel.showTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error eliminando el trabajador.", "Eliminando Trabajador", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.ButtonGroup grupoTratamiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel labelOperacion;
    public javax.swing.JLabel labelSueldo;
    private javax.swing.JRadioButton radioFemenino;
    private javax.swing.JRadioButton radioMasculino;
    private javax.swing.JRadioButton radioOtro;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textContrasena;
    private javax.swing.JTextField textEmail;
    public javax.swing.JTextField textFecha;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textSueldo;
    // End of variables declaration//GEN-END:variables
    ImageIcon iconAtras = new ImageIcon("src/images/Back.png");
    ImageIcon iconAtrasFilled = new ImageIcon("src/images/BackFilled.png");
    ImageIcon iconConfirmar = new ImageIcon("src/images/Tick.png");
    ImageIcon iconBorrar = new ImageIcon("src/images/Cross.png");
    ArrayList<JTextField> camposTexto = new ArrayList<>();
    CamposValidador camposValidar = new CamposValidador();
    DbTrabajador dt = new DbTrabajador();
    BackTrabajador bt;
    SobreSueldo ss = new SubirSueldo();
    TrabajadorPanel panel;
    EnumTipo tipo;
    EnumTratamiento tratamiento;
    int sueldo = 0;
    private int id = 0;
    boolean java = false;
    boolean csharp = false;
    boolean php = false;
    String radio = "";
}
