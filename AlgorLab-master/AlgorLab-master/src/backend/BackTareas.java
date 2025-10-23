package backend;

import java.sql.*;


public class BackTareas {
    
    public BackTareas(int curso_id, String titulo, String descripcion, java.sql.Date fecha){
        this.curso_id = curso_id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    private int curso_id;
    private String titulo;
    private String descripcion;
    private java.sql.Date fecha;
}
