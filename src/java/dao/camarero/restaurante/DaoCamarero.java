package dao.camarero.restaurante;

import java.sql.Connection;
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
}

//Faltan metodos update y delete