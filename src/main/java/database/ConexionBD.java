package database;

import java.lang.module.InvalidModuleDescriptorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:postgresql://localhost:8432/";
    private static final String USUARIO = "postgres";
    private static final String CLAVE = "admin";

    public static Connection conectar(String nombreBD){
        Connection conexion = null;

        try{
            conexion = DriverManager.getConnection(URL+nombreBD, USUARIO, CLAVE);
            System.out.println("Conexión OK. ");
        }catch(SQLException ex){
            System.out.println("Error en la conexión");
        }catch(InvalidModuleDescriptorException ex){
            System.out.println("Error PAM");
        }
        return conexion;
    }
}
