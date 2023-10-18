package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionDB {
    public static void crearDB(){
        try(Connection miCon = ConexionSGBD.conectar()){
            //Crear la base de datos
            Statement crearBD = miCon.createStatement();
            crearBD.executeUpdate("CREATE DATABASE miBD");
        }catch(SQLException ex){
            System.out.println("Error al conectar.");
        }
    }
}
