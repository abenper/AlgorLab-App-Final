package backend;

import recursos.*;

public class BackAlumnos extends BackPersonas {

    public BackAlumnos(String nombre, String apellidos, String email, String contrasena, String cod_recuperacion, EnumTratamiento tratamiento, EnumTipo tipo, EnumPago pago) {
        super(nombre, apellidos, email, contrasena, cod_recuperacion, tratamiento, tipo);
        this.pago = pago;
    }

    public EnumPago getPago() {
        return pago;
    }

    public void setPago(EnumPago pago) {
        this.pago = pago;
    }
    
    private EnumPago pago;
}
