package utilidades;

import entidades.Camarero;
import entidades.Cocinero;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static Connection conexion = null;
   // public static Statement sentencia;
    //public static ResultSet rs = null;
    //public static Camarero waiter;
    //public static Cocinero cooker;

    //Establecer conexion ------------------------------
    public static Connection abrirConexion() throws ClassNotFoundException, SQLException {

        String className = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost/restaurante";
        String user = "root";
        String password = "root";
        Class.forName(className);

        conexion = DriverManager.getConnection(url, user, password);

        if (conexion != null) {

            System.out.println("Conexion establecida");
        } else {

            System.out.println("Conexion abortada");
        }

        return conexion;
    }

    //Cerrar conexion -------------------------------------------
    public static void cerrarConexion() throws SQLException {

        if (conexion != null) {
            conexion.close();
            System.out.println("Conexion cerrada");
        } else {
            System.out.println("Se ha producido une rror en la conexion");
        }
    }
}
