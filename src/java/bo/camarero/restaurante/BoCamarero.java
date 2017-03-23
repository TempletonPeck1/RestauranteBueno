
package bo.camarero.restaurante;

import dao.camarero.restaurante.DaoCamarero;
import entidades.Camarero;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoCamarero {
    
      public static void procesarPeticionCamarero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Camarero waiter = new Camarero();
        waiter.setIdCamarero(request.getParameter("idCamarero"));
        waiter.setNombre(request.getParameter("nombre"));
        waiter.setApellido(request.getParameter("apellido"));
        waiter.setEspecialidad(request.getParameter("especialidad"));
        DaoCamarero.insertarCamarero(waiter.getIdCamarero(), waiter.getNombre(), waiter.getApellido(), waiter.getEspecialidad());
        response.sendRedirect("ServletMostrarCamarero");
    }
    
}
