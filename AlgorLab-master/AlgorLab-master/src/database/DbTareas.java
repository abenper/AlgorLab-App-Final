package database;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import recursos.Conexion;

public class DbTareas {

    public DefaultTableModel slqTareas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Titulo");
        model.addColumn("Descripcion");
        model.addColumn("Fecha Entrega");
        model.addColumn("curso_id");
        model.addColumn("id");
        try {
            Connection cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement("SELECT titulo, descripcion, fecha_entrega, curso_id, id FROM tareas");
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
            System.err.println("ERROR TABLA TAREAS: " + e);
        }
        return model;
    }

    public void sqlMostrar(int idTarea) {
        try {
            cn = Conexion.conecta();
            PreparedStatement pst = cn.prepareStatement("SELECT titulo, descripcion, fecha_entrega, curso_id, id FROM tareas WHERE id = ?");
            pst.setInt(1, idTarea);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.err.println("ERROR MOSTRANDO DATOS TAREA: " + e);
        }
    }

    public boolean insertarTarea(int curso, String titulo, String descripcion, java.sql.Date fecha) {
        try {
            cn = Conexion.conecta();
            CallableStatement cst = cn.prepareCall("{CALL insertar_tarea(?, ?, ?, ?)}");
            cst.setInt(1, curso);
            cst.setString(2, titulo);
            cst.setString(3, descripcion);
            cst.setDate(4, fecha);
            cst.execute();
            cn.close();
            return true;
        } catch (SQLException e) {
            System.err.println("ERROR INSERTANDO DATOS TAREA: " + e);
        }
        return false;
    }

    public boolean actualizarTarea(int id, int curso, String titulo, String descripcion, java.sql.Date fecha) {
        try {
            cn = Conexion.conecta();
            CallableStatement cst = cn.prepareCall("{CALL update_tarea(?, ?, ?, ?, ?)}");
            cst.setInt(1, id);
            cst.setInt(2, curso);
            cst.setString(3, titulo);
            cst.setString(4, descripcion);
            cst.setDate(5, fecha);
            cst.execute();
            cn.close();
            return true;
        } catch (SQLException e) {
            System.err.println("ERROR ACTUALIZANDO TAREA: " + e);
        }
        return false;
    }

    public boolean eliminarTarea(int id) {
        try {
            cn = Conexion.conecta();
            CallableStatement cst = cn.prepareCall("{CALL delete_tarea(?)}");
            cst.setInt(1, id);
            cst.execute();
            cn.close();
            return true;
        } catch (SQLException e) {
            System.err.println("ERROR ELIMINANDO TAREA: " + e);
        }
        return false;
    }
    
    
    public ResultSet rs;
    public Connection cn;
}
