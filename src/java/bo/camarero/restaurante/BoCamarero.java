package bo.camarero.restaurante;

import dao.camarero.restaurante.DaoCamarero;
import entidades.Camarero;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoCamarero {

    public static void procesarInsertarCamarero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Camarero waiter = new Camarero();
        waiter.setIdCamarero(Integer.parseInt(request.getParameter("idCamarero")));
        waiter.setNombre(request.getParameter("nombre"));
        waiter.setApellido(request.getParameter("apellido"));
        waiter.setEspecialidad(request.getParameter("especialidad"));
        DaoCamarero.insertarCamarero(waiter.getIdCamarero(), waiter.getNombre(), waiter.getApellido(), waiter.getEspecialidad());

    }

    public static void procesarActualizarCamarero(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        Camarero waiter = new Camarero();
        waiter.setNombre(request.getParameter("nombre"));
        waiter.setApellido(request.getParameter("apellido"));
        waiter.setEspecialidad(request.getParameter("especialidad"));
        waiter.setIdCamarero(Integer.parseInt(request.getParameter("idCamarero")));
        DaoCamarero.actualizarCamarero(waiter.getNombre(), waiter.getApellido(), waiter.getEspecialidad(), waiter.getIdCamarero());

    }

    public static void procesarBorrarCamarero(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {

        Camarero waiter = new Camarero();
        waiter.setIdCamarero(Integer.parseInt(request.getParameter("idCamarero")));
        waiter.setNombre(request.getParameter("nombre"));
        waiter.setApellido(request.getParameter("apellido"));
        waiter.setEspecialidad(request.getParameter("especialidad"));
        DaoCamarero.borrarCamarero(waiter.getIdCamarero());
        //DaoAlumno.borrarAlumno(student.getIdAlumno(), student.getNombre(), student.getApellido(), student.getCurso());
        //response.sendRedirect("mostrarAlumno.jsp");
    }

    public static void procesarListarCamarero(HttpServletRequest request,HttpServletResponse response){
        
        try {
            Camarero waiter=new Camarero();
            DaoCamarero.listarCamareros();
            //cambiar los loooger
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BoCamarero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BoCamarero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
