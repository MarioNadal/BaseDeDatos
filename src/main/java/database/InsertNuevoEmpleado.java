package database;

import classes.Empleado;
import libs.Leer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertNuevoEmpleado {
    public static void insertarEmpleado(){
        Empleado nuevoEmpleado = new Empleado();
        String nombreDep;
        int idDepRec=0;
        nuevoEmpleado.setIdEmpleado(Leer.introduceEntero("Inserte el número del nuevo empleado:"));
        nuevoEmpleado.setApellido(Leer.introduceString("Inserte el apellido del nuevo empleado:"));
        nombreDep = Leer.introduceString("Inserte el nombre del departamento al que pertenece:");
        try(Connection miCon = ConexionBD.conectar("mibd") ){
            //Montamos la sentencia SQL de comprobación de que el departamento existe.
            //Devolviendonos el id del departamento si existe.
            PreparedStatement pstmnt = miCon.prepareStatement("SELECT dept_no FROM departamentos WHERE dnombre = ?");
            pstmnt.setString(1,nombreDep);
            //Ejecutamos la sentencia y almacenamos el resultado en un resultSet
            ResultSet rs = pstmnt.executeQuery();
            while(rs.next()){
                idDepRec = rs.getInt("dept_no");
            }
            if(idDepRec==0){
                System.out.println("El departamento indicado no existe y el empleado no se insertará.");
            }else{
                nuevoEmpleado.setIdDep(idDepRec);
                PreparedStatement insEmpl = miCon.prepareStatement("INSERT INTO empleados(emp_no,apellido,dept_no) VALUES (?,?,?)");
                insEmpl.setInt(1,nuevoEmpleado.getIdEmpleado());
                insEmpl.setString(2,nuevoEmpleado.getApellido());
                insEmpl.setInt(3,nuevoEmpleado.getIdDep());
                insEmpl.executeUpdate();
            }
        }catch(SQLException ex){
            System.out.println("Error al conectar" + ex.getMessage());
        }
    }
}
