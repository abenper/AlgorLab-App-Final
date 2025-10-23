package database;

import javax.swing.table.*;
import java.sql.*;
import recursos.Conexion;

public abstract class DbUsuarios {

    public abstract DefaultTableModel slqUsuario();

    public abstract ResultSet slqMostrar(String usuario);

    public abstract String[] getCamposExcluidos();

    public void concederCursos(int idUsuario, boolean java, boolean csharp, boolean php) {
        quitarCursos(idUsuario, 1);
        quitarCursos(idUsuario, 2);
        quitarCursos(idUsuario, 3);
        if (java) {
            ponerCursos(idUsuario, 1);
        }
        if (csharp) {
            ponerCursos(idUsuario, 2);
        }
        if (php) {
            ponerCursos(idUsuario, 3);
        }
    }

    public void getCursos(int idUsuario) {
        try {
            cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuarios_cursos WHERE usuario_id = ?");
            pst.setInt(1, idUsuario);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.err.println("ERROR OBTENIENDO CURSOS" + e);
        }
    }

    public void ponerCursos(int idUsuario, int idCurso) {
        try {
            Connection cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement("INSERT INTO usuarios_cursos (usuario_id, curso_id) VALUES (?, ?)");
            pst.setInt(1, idUsuario);
            pst.setInt(2, idCurso);
            pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            System.err.println("ERROR CONCEDIENDO CURSO:" + e);
        }
    }

    public void quitarCursos(int idUsuario, int idCurso) {
        try {
            Connection cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement("DELETE FROM usuarios_cursos WHERE usuario_id = ? AND curso_id = ?");
            pst.setInt(1, idUsuario);
            pst.setInt(2, idCurso);
            pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            System.err.println("ERROR QUITANDO CURSO: " + e);
        }
    }

    public int getId(String email) {
        int id = 0;
        try {
            cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement("select id from usuarios where correo = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("ERROR MOSTRANDO DATOS TRABAJADOR: " + e);
        }

        return id;
    }

    public boolean deleteUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            Connection cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            cn.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Error eliminando trabajador: " + e);
            return false;
        }
    }

    public Connection cn;
    public ResultSet rs;
}
