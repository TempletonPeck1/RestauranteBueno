package dao.administrador.restaurante;

import entidades.Administrador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilidades.Conexion;


public class DaoAdministrador {

    public static void insertarAdministrador(String usuario, String password, String nombre_administrador, String apellido_administrador) throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into logeados (usuario,password,nombre_administrador,apellido_administrador) values ";
        consultaSQL += "('" + usuario + "','" + password + "','" + nombre_administrador + "','" + apellido_administrador + "')";
        int filas = sentencia.executeUpdate(consultaSQL);
        System.out.println("Numero de filas insertadas: " + filas);
        sentencia.close();
        Conexion.cerrarConexion();

    }
    
    
    public static ResultSet mostrarAdministrador() throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "select usuario,password,nombre_administrador,apellido_administrador from logeados";
        ResultSet lista_administradores = sentencia.executeQuery(consultaSQL);
        //Conexion.cerrarConexion();
        return lista_administradores;

    }
    
    

    public static void procesarPeticionAdministrador(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        
        Administrador admin = new Administrador();
        admin.setUsuarioAdministrador(request.getParameter("usuario_administrador"));
        admin.setPasswordAdministrador(request.getParameter("password_administrador"));
        admin.setNombreAdministrador(request.getParameter("nombre_administrador"));
        admin.setApellidoAdministrador(request.getParameter("apellido_administrador"));

        insertarAdministrador(admin.getUsuarioAdministrador(), admin.getPasswordAdministrador(), admin.getNombreAdministrador(), admin.getApellidoAdministrador());
        response.sendRedirect("ServletMostrarAdministrador");
    }

}
