package recursos;

import java.sql.*;

public class Conexion {
    
    public static Connection conecta(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/algorlab", "root", "");
            System.out.println("Establecida con exito");
            return cn;
        }catch(SQLException e){
            System.err.println("Error de conexion" + e);
        }
        return null;
    }
}