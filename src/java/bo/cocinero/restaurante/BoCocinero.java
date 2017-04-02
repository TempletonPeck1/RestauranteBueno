package bo.cocinero.restaurante;

import dao.cocinero.restaurante.DaoCocinero;
import entidades.Cocinero;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoCocinero {

    public static void procesarInsertarCocinero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Cocinero cook = new Cocinero();
        cook.setIdCocinero(Integer.parseInt(request.getParameter("idCocinero")));
        cook.setNombre(request.getParameter("nombre"));
        cook.setApellido(request.getParameter("apellido"));
        cook.setEspecialidad(request.getParameter("especialidad"));
        DaoCocinero.insertarCocinero(cook.getIdCocinero(), cook.getNombre(), cook.getApellido(), cook.getEspecialidad());
       
    }

    public static void procesarActualizarCocinero(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        Cocinero cook = new Cocinero();
        cook.setNombre(request.getParameter("nombre"));
        cook.setApellido(request.getParameter("apellido"));
        cook.setEspecialidad(request.getParameter("especialidad"));
        cook.setIdCocinero(Integer.parseInt(request.getParameter("idCocinero")));
        DaoCocinero.actualizarCocinero(cook.getNombre(), cook.getApellido(), cook.getEspecialidad(), cook.getIdCocinero());
        //pendiente de volver a la vista para mostrar el resultado
        
    }

    public static void procesarBorrarCocinero(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {

        Cocinero cook = new Cocinero();
        cook.setIdCocinero(Integer.parseInt(request.getParameter("idCocinero")));
        cook.setNombre(request.getParameter("nombre"));
        cook.setApellido(request.getParameter("apellido"));
        cook.setEspecialidad(request.getParameter("especialidad"));
        DaoCocinero.borrarCocinero(cook.getIdCocinero());
        //DaoAlumno.borrarAlumno(student.getIdAlumno(), student.getNombre(), student.getApellido(), student.getCurso());
        //response.sendRedirect("mostrarAlumno.jsp");
    }

}
