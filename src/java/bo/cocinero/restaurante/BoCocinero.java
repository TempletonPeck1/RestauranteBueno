
package bo.cocinero.restaurante;

import static dao.cocinero.restaurante.DaoCocinero.insertarCocinero;
import entidades.Cocinero;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoCocinero {
    
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
