package dao.camarero.restaurante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletResponse;
import utilidades.Conexion;

public class DaoCamarero {

    public static void insertarCamarero(String idCamarero, String nombre, String apellido, String especialidad) throws SQLException, ClassNotFoundException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into camarero (idCamarero,nombre,apellido,especialidad) values ";
        consultaSQL += "('" + idCamarero + "','" + nombre + "','" + apellido + "','" + especialidad + "')";
        int filas = sentencia.executeUpdate(consultaSQL);
        System.out.println("Numero de filas insertadas: " + filas);
        sentencia.close();
        Conexion.cerrarConexion();
        //conexion.close();
    }

    public static ResultSet mostrarCamarero() throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "select idCamarero,nombre,apellido,especialidad from camarero";
        ResultSet lista_camareros = sentencia.executeQuery(consultaSQL);
        //Conexion.cerrarConexion();
        return lista_camareros;

    }

    public static void actualizarCamarero(String idCamarero, String nombre, String apellido, String especialidad) throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();

        String consultaSQL = "update camarero set nombre=?, apellido=?, especialidad=? where idCamarero=?";
        PreparedStatement actualizar = conexion.prepareStatement(consultaSQL);
        //los numeros son la posicion de la consulta SQL
        actualizar.setString(1, nombre);
        actualizar.setString(2, apellido);
        actualizar.setString(3, especialidad);
        actualizar.setString(4, idCamarero);
        //Execute update devuelve el numero de filas afectadas
        int filasAfectadas = actualizar.executeUpdate(consultaSQL);
        System.out.println("Filas afectadas: " + filasAfectadas);
        actualizar.close();
        conexion.close();

    }

}


//Faltan metodos update y delete
