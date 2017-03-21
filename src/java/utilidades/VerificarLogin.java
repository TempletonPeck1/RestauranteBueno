package utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificarLogin {

    public static boolean comprobarLogin(String usuario, String password) throws ClassNotFoundException, SQLException {

        boolean nRegistro = false;
        String sql = "select * from logeados where usuario='" + usuario + "' and password='" + password + "'";
        Connection con = Conexion.abrirConexion();
        PreparedStatement comprobarLogin = con.prepareStatement(sql);
        //comprobarLogin.setString(1, usuario);
       //comprobarLogin.setString(2, password);

        ResultSet rs = comprobarLogin.executeQuery(sql);

        if (rs.next()) {
            //Si devuelve resultado el login es correcto
            nRegistro = true;
        }
        return nRegistro;
    }
}
