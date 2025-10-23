package database;

import java.sql.*;
import javax.swing.*;
import login.*;
import recursos.*;

public class DbMenu {

    public String menuSelect(String usuario) {
        String tipo = "";
        String sql = "{CALL menuSelect(?, ?)}";

        try (Connection cn = Conexion.conecta(); CallableStatement cs = cn.prepareCall(sql)) {

            cs.setString(1, usuario);
            cs.registerOutParameter(2, Types.VARCHAR);

            cs.execute();

            tipo = cs.getString(2);
            cn.close();
        } catch (SQLException e) {
            System.err.println("ERROR menuSelect: " + e.getMessage());
        }

        return tipo;
    }

    public void tratamiento(JLabel lIcon, JLabel lTratamiento, JLabel lNombre) {
        ImageIcon iconOtro = new ImageIcon("src/images/Otro.png");
        ImageIcon iconMasculino = new ImageIcon("src/images/Masculino.png");
        ImageIcon iconFemenino = new ImageIcon("src/images/Femenino.png");

        if (LoginPanel.tratamiento.equalsIgnoreCase("otro")) {
            lIcon.setIcon(iconOtro);
            lTratamiento.setText("Bienvenid@");
            lNombre.setText(LoginPanel.usuario);
        } else if (LoginPanel.tratamiento.equalsIgnoreCase("masculino")) {
            lIcon.setIcon(iconMasculino);
            lTratamiento.setText("Bienvenido");
            lNombre.setText(LoginPanel.usuario);
        } else {
            lIcon.setIcon(iconFemenino);
            lTratamiento.setText("Bienvenida");
            lNombre.setText(LoginPanel.usuario);
        }
    }
}
