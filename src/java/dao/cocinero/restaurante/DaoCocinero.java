package dao.cocinero.restaurante;

import entidades.Cocinero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilidades.Conexion;

public class DaoCocinero {

    public static void insertarCocinero(int idCocinero, String nombre, String apellido, String especialidad) throws SQLException, ClassNotFoundException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into cocinero (idCocinero,nombre,apellido,especialidad) values ";
        consultaSQL += "('" + idCocinero + "','" + nombre + "','" + apellido + "','" + especialidad + "')";
        sentencia.executeUpdate(consultaSQL);
        sentencia.close();
        conexion.close();
    }

    public static ResultSet mostrarCocinero() throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "select idCocinero,nombre,apellido,especialidad from cocinero";
        ResultSet lista_cocineros = sentencia.executeQuery(consultaSQL);
        return lista_cocineros;

    }

    public static void procesarPeticionCocinero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Cocinero cook = new Cocinero();
        cook.setIdCocinero(Integer.parseInt(request.getParameter("idCocinero")));
        cook.setNombre(request.getParameter("nombre"));
        cook.setApellido(request.getParameter("apellido"));
        cook.setEspecialidad(request.getParameter("especialidad"));

        insertarCocinero(cook.getIdCocinero(), cook.getNombre(), cook.getApellido(), cook.getEspecialidad());
        response.sendRedirect("ServletMostrarCocinero");

    }
}
