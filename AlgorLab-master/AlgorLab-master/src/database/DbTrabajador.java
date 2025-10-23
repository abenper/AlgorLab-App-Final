package database;

import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import recursos.*;

public class DbTrabajador extends DbUsuarios {

    @Override
    public DefaultTableModel slqUsuario() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement("show columns from usuarios");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (!Arrays.asList(getCamposExcluidos()).contains(rs.getString("Field").toLowerCase())) {
                    model.addColumn(rs.getString("Field").toUpperCase());
                }
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }

        try {
            Connection cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement("select nombre, apellidos, correo, tratamiento, fecha_registro from usuarios where tipo = 'Profesor' or tipo = 'Director'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] filas = new Object[model.getColumnCount()];
                for (int i = 0; i < model.getColumnCount(); i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("ERROR TABLA TRABAJADOR: " + e);
        }
        return model;
    }

    @Override
    public ResultSet slqMostrar(String usuario) {

        try {
            cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement("select id, nombre, apellidos, correo, contrasena, cod_recuperacion, tratamiento, sueldo, fecha_registro, tipo from usuarios where correo = ?");
            pst.setString(1, usuario);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.err.println("ERROR MOSTRANDO DATOS TRABAJADOR: " + e);
        }
        return null;
    }

    @Override
    public String[] getCamposExcluidos() {
        String[] camposExcluidos = {"id", "contrasena", "cod_recuperacion", "tipo", "metodo_pago", "sueldo"};
        return camposExcluidos;
    }

    public boolean insertTrabajador(String nombre, String apellidos, String email, String contrasena, String cod_recuperacion, EnumTratamiento tratamiento, EnumTipo tipo, int sueldo) {
        String sql = "INSERT INTO usuarios (nombre, apellidos, correo, contrasena, cod_recuperacion, "
                + "tratamiento, tipo, sueldo, fecha_registro) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
        try {
            Connection cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            pst.setString(3, email);
            pst.setString(4, contrasena);
            pst.setString(5, cod_recuperacion);
            pst.setString(6, tratamiento.toString());
            pst.setString(7, tipo.toString());
            pst.setInt(8, sueldo);
            pst.executeUpdate();
            cn.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Error Insertando Trabajador: " + e);
            return false;
        }
    }

    public boolean updateTrabajador(int id, String nombre, String apellidos, String email, String contrasena, String cod_recuperacion, EnumTratamiento tratamiento, EnumTipo tipo, int sueldo) {
        String sql = "UPDATE usuarios SET nombre = ?, apellidos = ?, correo = ?, contrasena = ?, cod_recuperacion = ?, tratamiento = ?, tipo = ?, sueldo = ? WHERE id = ?";
        try {
            Connection cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            pst.setString(3, email);
            pst.setString(4, contrasena);
            pst.setString(5, cod_recuperacion);
            pst.setString(6, tratamiento.toString());
            pst.setString(7, tipo.toString());
            pst.setInt(8, sueldo);
            pst.setInt(9, id);
            pst.executeUpdate();
            cn.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Error actualizando trabajador: " + e);
            return false;
        }
    }
}
