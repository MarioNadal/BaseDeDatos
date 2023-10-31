package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public class EstructuraDB {
    public static void crearDB(){
        try(Connection miCon = ConexionSGBD.conectar()){
            //Crear la base de datos
            Statement crearBD = miCon.createStatement();
            crearBD.executeUpdate("CREATE DATABASE mibd");
        }catch(SQLException ex){
            System.out.println("Error al conectar." + ex.getMessage());
        }
    }
    public static void crearTablasDeps(){
        try(Connection miCon = ConexionBD.conectar("mibd")){
            //Crear la tabla departamentos
            String tablaDep = "CREATE TABLE departamentos (\n" +
                    " dept_no  NUMERIC(2) NOT NULL PRIMARY KEY,\n" +
                    " dnombre  VARCHAR(15), \n" +
                    " loc      VARCHAR(15)\n" +
                    ") ";
            String addDep1 ="INSERT INTO departamentos VALUES (10,'CONTABILIDAD','SEVILLA');";
            String addDep2 ="INSERT INTO departamentos VALUES (20,'INVESTIGACIÓN','MADRID');";
            String addDep3 ="INSERT INTO departamentos VALUES (30,'VENTAS','BARCELONA');";
            String addDep4 ="INSERT INTO departamentos VALUES (40,'PRODUCCIÓN','BILBAO');";
            Statement crearTablaDep = miCon.createStatement();
            crearTablaDep.execute("DROP TABLE IF EXISTS empleados");
            crearTablaDep.execute("DROP TABLE IF EXISTS departamentos");
            crearTablaDep.execute(tablaDep);
            crearTablaDep.execute(addDep1);
            crearTablaDep.execute(addDep2);
            crearTablaDep.execute(addDep3);
            crearTablaDep.execute(addDep4);
        }catch(SQLSyntaxErrorException ex){
            System.out.println("Error en la sintaxis SQl " + ex.getMessage());
        }catch(SQLException ex){
            System.out.println("Error al conectar." + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public static void crearTablasEmpls(){
        try(Connection miCon = ConexionBD.conectar("mibd")){
            //Crear la tabla empleados
            String tablaDep = "CREATE TABLE empleados (\n" +
                    " emp_no    NUMERIC(4)  NOT NULL PRIMARY KEY,\n" +
                    " apellido  VARCHAR(10),\n" +
                    " oficio    VARCHAR(10),\n" +
                    " dir       NUMERIC,\n" +
                    " fecha_alt DATE,\n" +
                    " salario   NUMERIC(6,2),\n" +
                    " comision  NUMERIC(6,2),\n" +
                    " dept_no   NUMERIC(2) NOT NULL,\n" +
                    " CONSTRAINT FK_DEP FOREIGN KEY (dept_no) REFERENCES departamentos(dept_no)\n"+
                    ") ";
            String addDep1 = "INSERT INTO empleados VALUES (7369,'SÁNCHEZ','EMPLEADO',7902,'1990/12/17',1040,NULL,20);";
            String addDep2 = "INSERT INTO empleados VALUES (7499,'ARROYO','VENDEDOR',7698,'1990/02/20',1500,390,30);";
            String addDep3 = "INSERT INTO empleados VALUES (7521,'SALA','VENDEDOR',7698,'1991/02/22',1625,650,30);";
            String addDep4 = "INSERT INTO empleados VALUES (7566,'JIMÉNEZ','DIRECTOR',7839,'1991/04/02',2900,NULL,20);";
            String addDep5 = "INSERT INTO empleados VALUES (7654,'MARTÍN','VENDEDOR',7698,'1991/09/29',1600,1020,30);";
            String addDep6 = "INSERT INTO empleados VALUES (7698,'NEGRO','DIRECTOR',7839,'1991/05/01',3005,NULL,30);";
            String addDep7 = "INSERT INTO empleados VALUES (7782,'CEREZO','DIRECTOR',7839,'1991/06/09',2885,NULL,10);";
            String addDep8 = "INSERT INTO empleados VALUES (7788,'GIL','ANALISTA',7566,'1991/11/09',3000,NULL,20);";
            String addDep9 = "INSERT INTO empleados VALUES (7839,'REY','PRESIDENTE',NULL,'1991/11/17',4100,NULL,10);";
            String addDep10 = "INSERT INTO empleados VALUES (7844,'TOVAR','VENDEDOR',7698,'1991/09/08',1350,0,30);";
            String addDep11 = "INSERT INTO empleados VALUES (7876,'ALONSO','EMPLEADO',7788,'1991/09/23',1430,NULL,20);";
            String addDep12 = "INSERT INTO empleados VALUES (7900,'JIMENO','EMPLEADO',7698,'1991/12/03',1335,NULL,30);";
            String addDep13 = "INSERT INTO empleados VALUES (7902,'FERNÁNDEZ','ANALISTA',7566,'1991/12/03',3000,NULL,20);";
            String addDep14 = "INSERT INTO empleados VALUES (7934,'MUÑOZ','EMPLEADO',7782,'1992/01/23',1690,NULL,10);";
            Statement crearTablaDep = miCon.createStatement();
            crearTablaDep.execute("DROP TABLE IF EXISTS empleados");
            crearTablaDep.execute(tablaDep);
            crearTablaDep.execute(addDep1);
            crearTablaDep.execute(addDep2);
            crearTablaDep.execute(addDep3);
            crearTablaDep.execute(addDep4);
            crearTablaDep.execute(addDep5);
            crearTablaDep.execute(addDep6);
            crearTablaDep.execute(addDep7);
            crearTablaDep.execute(addDep8);
            crearTablaDep.execute(addDep9);
            crearTablaDep.execute(addDep10);
            crearTablaDep.execute(addDep11);
            crearTablaDep.execute(addDep12);
            crearTablaDep.execute(addDep13);
            crearTablaDep.execute(addDep14);
            /*También ser podría hacer con un Array de todos los inserts y luego:
            * for(String e : addEmps){
            *   crearTablaDep.execute(e)
            * }*/
        }catch(SQLException ex){
            System.out.println("Error al conectar." + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
