package database;

import java.sql.*;
import javax.swing.table.*;
import recursos.*;

public class DbEntregas {

    public DefaultTableModel slqEntregas(int idCurso, int idProfesor) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Tarea");
        model.addColumn("Alumno");
        model.addColumn("Fecha Entrega");
        model.addColumn("id_entrega");
    try {
        Connection cn = Conexion.conecta();
        PreparedStatement pst = cn.prepareStatement(
            "SELECT t.titulo AS nombre_tarea, " +
            "CONCAT(u.nombre, ' ', u.apellidos) AS nombre_alumno, " +
            "IFNULL(DATE_FORMAT(e.fecha_entrega, '%Y-%m-%d %H:%i:%s'), 'No entregada') AS estado_entrega, " +
            "e.id AS id_entrega " +
            "FROM algorlab.tareas t " +
            "JOIN algorlab.usuarios_cursos uc ON t.curso_id = uc.curso_id " +
            "JOIN algorlab.usuarios u ON uc.usuario_id = u.id AND u.tipo = 'Alumno' " +
            "LEFT JOIN algorlab.entregas e ON e.tarea_id = t.id AND e.alumno_id = u.id " +
            "WHERE t.curso_id = ? " +
            "AND EXISTS (SELECT 1 FROM usuarios_cursos uc2 WHERE uc2.curso_id = t.curso_id AND uc2.usuario_id = ?)"
        );
        pst.setInt(1, idCurso);
        pst.setInt(2, idProfesor);
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
            System.err.println("ERROR TABLA ENTREGAS: " + e);
        }
        return model;
    }

    public void sqlMostrar(int idEntrega) {
        try {
            cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT t.titulo AS nombre_tarea, "
                    + "CONCAT(u.nombre, ' ', u.apellidos) AS alumno, "
                    + "COALESCE(e.observacion_profesor, 'sin observación') AS observacion_profesor, "
                    + "e.estado AS estado_correccion, "
                    + "e.url_archivo AS url "
                    + "FROM entregas e "
                    + "JOIN tareas t ON e.tarea_id = t.id "
                    + "JOIN usuarios u ON e.alumno_id = u.id "
                    + "WHERE e.id = ?"
            );
            pst.setInt(1, idEntrega);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.err.println("ERROR MOSTRANDO DATOS ENTREGA: " + e);
        }
    }

    public void sqlCalificar(int idEntrega, String estado, String observacion) {
        try {
            
            Connection cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement("{CALL corregir_entrega(?, ?, ?)}");
            pst.setInt(1, idEntrega);
            pst.setString(2, estado);
            pst.setString(3, observacion);
            pst.executeUpdate();
            
        } catch (SQLException e) {
            
            System.err.println("ERROR INSERTANDO DATOS ENTREGA: " + e);
        }
    }

    public ResultSet rs;
    public Connection cn;
}
