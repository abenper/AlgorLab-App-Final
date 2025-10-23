package backend;

import recursos.*;


public class BackTrabajador extends BackPersonas {

    public BackTrabajador(String nombre, String apellidos, String email, String contrasena, String cod_recuperacion, EnumTratamiento tratamiento, EnumTipo tipo, int sueldo) {
        super(nombre, apellidos, email, contrasena, cod_recuperacion, tratamiento, tipo);
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    private int sueldo;
}
