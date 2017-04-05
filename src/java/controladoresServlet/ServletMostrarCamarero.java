package controladoresServlet;

import dao.camarero.restaurante.DaoCamarero;
import entidades.Camarero;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMostrarCamarero extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

        //ResultSet rs =DaoCamarero.verCamareros();
        ArrayList<Camarero> list_camarero = new ArrayList<Camarero>();
        list_camarero = (ArrayList<Camarero>) DaoCamarero.listarCamareros();
        //Comienza la respuesta
        response.setContentType("text/html;charset=UTF-8");
        //Queda pendiente hacerlo pero con objetos
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de Camareros</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Camareros</h1>");

            for (Camarero camarero : list_camarero) {
                out.println("<h1>*********************** </h1>");
                out.println("<p> Id Camarero: " + camarero.getIdCamarero() + "</p>");
                out.println("<p> Nombre: " + camarero.getNombre() + "</p>");
                out.println("<p> Apellido: " + camarero.getApellido() + "</p>");
                out.println("<p> Especialidad: " + camarero.getEspecialidad() + "</p>");
            }

            /* while(rs.next()){
              
           out.println("<p>Id camero: "+rs.getString(1)+"</p>");
           out.println("<p> Nombre"+rs.getString(2)+"</p>");
           out.println("<p> Apellido"+rs.getString(3)+"</p>");
              
           } */
            
            out.println("<a href='gestion.htm'>"+"Volver al inicio"+"</a>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletMostrarCamarero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletMostrarCamarero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletMostrarCamarero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletMostrarCamarero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
