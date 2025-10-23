package backend;

import recursos.*;

public class BackPersonas {

    public BackPersonas(String nombre, String apellidos, String email, String contrasena, String cod_recuperacion, EnumTratamiento tratamiento, EnumTipo tipo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasena = contrasena;
        this.cod_recuperacion = cod_recuperacion;
        this.tratamiento = tratamiento;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCod_recuperacion() {
        return cod_recuperacion;
    }

    public void setCod_recuperacion(String cod_recuperacion) {
        this.cod_recuperacion = cod_recuperacion;
    }

    public EnumTratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(EnumTratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public EnumTipo getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipo tipo) {
        this.tipo = tipo;
    }

    private String nombre, apellidos, email, contrasena, cod_recuperacion;
    private EnumTratamiento tratamiento;
    private EnumTipo tipo;
}
