package dao.cocinero.restaurante;

import entidades.Camarero;
import entidades.Cocinero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utilidades.Conexion;
import utilidades.ExcepcionesBD;

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

    public static void actualizarCocinero(String nombre, String apellido, String especialidad, int idCocinero) throws ClassNotFoundException, SQLException {

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
        int filasAfectadas = actualizar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);

    }

    public static void borrarCocinero(int idCocinero) throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        String consultaSQL = "delete from cocinero where idCocinero=?";
        PreparedStatement borrar = conexion.prepareStatement(consultaSQL);
        borrar.setInt(1, idCocinero);
        //Execute update devuelve el numero de filas afectadas
        int filasAfectadas = borrar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
    }

    public static ArrayList<Cocinero> listarCocinero() throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        String consultaSQL = "select idCocinero,nombre,apellido, especialidad from cocinero";
        PreparedStatement sentencia = conexion.prepareStatement(consultaSQL);
        ResultSet rs = sentencia.executeQuery(consultaSQL);
        ArrayList<Cocinero> lista_cocineros = new ArrayList<Cocinero>();
        try {
            while (rs.next()) {
                lista_cocineros.add(new Cocinero(Integer.parseInt(rs.getString("idCocinero")),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("especialidad")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ExcepcionesBD("error en la insercion de datos");
        }
        return lista_cocineros;
    }

}
