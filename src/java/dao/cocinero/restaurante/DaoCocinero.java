package dao.cocinero.restaurante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilidades.Conexion;

public class DaoCocinero {

    public static void insertarCocinero(int idCocinero, String nombre, String apellido, String especialidad) throws SQLException, ClassNotFoundException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into cocinero (idCocinero,nombre,apellido,especialidad) values ";
        consultaSQL += "('" + idCocinero + "','" + nombre + "','" + apellido + "','" + especialidad + "')";
        sentencia.executeUpdate(consultaSQL);
        sentencia.close();
        Conexion.cerrarConexion();

    }

    public static ResultSet mostrarCocinero() throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "select idCocinero,nombre,apellido,especialidad from cocinero";
        ResultSet lista_cocineros = sentencia.executeQuery(consultaSQL);
        return lista_cocineros;

    }

    public static void actualizarCocinero(int idCocinero, String nombre, String apellido, String especialidad) throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();

        String consultaSQL = "update cocinero set nombre=?, apellido=?, especialidad=? where idCocinero=?";
        PreparedStatement actualizar = conexion.prepareStatement(consultaSQL);
        //los numeros son la posicion de la consulta SQL
        actualizar.setString(1, nombre);
        actualizar.setString(2, apellido);
        actualizar.setString(3, especialidad);
        actualizar.setInt(4, idCocinero);
        //Execute update devuelve el numero de filas afectadas
        int filasAfectadas = actualizar.executeUpdate(consultaSQL);
        System.out.println("Filas afectadas: " + filasAfectadas);

    }

}
