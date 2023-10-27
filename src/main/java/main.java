import database.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    //PostgreSQL
    public static void main(String[]args) {
        String guiones = "-".repeat(20);
        int menu;
        boolean salir = false;
        do{
            System.out.println(guiones);
            System.out.println("1. Crear Base de Datos");
            System.out.println("2. Crear Tabla Departamentos con departamentos iniciales");
            System.out.println("3. Crear Tabla Empleados con empleados iniciales");
            System.out.println("4. Insertar Empleados");
            System.out.println("0. Salir");
            System.out.println(guiones);
            menu = libs.Leer.introduceEntero("Introduce el número del menú: ");

            switch(menu){
                case 1 -> database.EstructuraDB.crearDB();
                case 2 -> database.EstructuraDB.crearTablasDeps();
                case 3 -> database.EstructuraDB.crearTablasEmpls();
                case 4 -> database.InsertNuevoEmpleado.insertarEmpleado();
                case 0 -> salir=true;
            }
        }while(!salir);
    }
}
