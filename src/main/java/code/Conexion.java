package code;

import java.lang.module.InvalidModuleDescriptorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mariadb//localhost:6606/PERSONAL";
    private static final String USUARIO = "root";
    private static final String CLAVE = "admin";

    public static Connection concentar(){
        Connection conexion = null;

        try{
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        }catch(SQLException ex){
            System.out.println("Error en la conexión");
        }catch(InvalidModuleDescriptorException ex){
            System.out.println("Error PAM");
        }
        return conexion;
    }
}
