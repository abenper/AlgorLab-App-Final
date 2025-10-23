package database;

import java.sql.*;
import javax.swing.*;
import recursos.*;
import login.*;
import menu.*;

public class DbLogin {

    public void login(Login marco, String usuario, String password) {
        String sql = "{CALL login(?, ?, ?, ?)}";

        try (Connection cn = Conexion.conecta(); CallableStatement cs = cn.prepareCall(sql)) {

            cs.setString(1, usuario);
            cs.setString(2, password);
            cs.registerOutParameter(3, Types.TINYINT);
            cs.registerOutParameter(4, Types.VARCHAR);

            cs.execute();

            boolean loginOk = cs.getBoolean(3);
            if (loginOk) {
                marco.dispose();
                LoginPanel.tratamiento = cs.getString(4);
                Frame fr = new menu.Frame();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "ERROR LOGIN", JOptionPane.ERROR_MESSAGE);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("ERROR LOGIN: " + e.getMessage());
        }
    }

    public void recuContra(String usuario, String codigo) {
        String sql = "{CALL validar_recucontra(?, ?, ?)}";
        try (Connection cn = Conexion.conecta(); CallableStatement cs = cn.prepareCall(sql)) {

            cs.setString(1, usuario);
            cs.setString(2, codigo);
            cs.registerOutParameter(3, Types.INTEGER);

            cs.execute();

            int id = cs.getInt(3);

            if (id > 0) {
                String passNueva = JOptionPane.showInputDialog(null, "Introduce tu nueva contraseña", "NUEVA CONTRASEÑA", JOptionPane.INFORMATION_MESSAGE);
                if (passNueva != null && !passNueva.trim().isEmpty()) {
                    updateContra(id, passNueva);
                } else {
                    JOptionPane.showMessageDialog(null, "La nueva contraseña no puede estar vacía.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o código incorrectos.\nPídele tu código al director", "ERROR RECUPERANDO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("ERROR RECUPERACION: " + e.getMessage());
        }
    }

    public void updateContra(int id, String passNueva) {
        String sql = "{CALL actualizar_contra(?, ?)}";
        try (Connection cn = Conexion.conecta(); CallableStatement cs = cn.prepareCall(sql)) {

            cs.setInt(1, id);
            cs.setString(2, passNueva);

            cs.executeUpdate();

            JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito", "CAMBIADA CON EXITO", JOptionPane.DEFAULT_OPTION);

        } catch (SQLException e) {
            System.err.println("ERROR UPDATEANDO CONTRASEÑA: " + e.getMessage());
        }
    }
    LoginPanel panel;
}
