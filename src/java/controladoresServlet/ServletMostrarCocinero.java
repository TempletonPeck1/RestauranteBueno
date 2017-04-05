package controladoresServlet;

import dao.camarero.restaurante.DaoCamarero;
import dao.cocinero.restaurante.DaoCocinero;
import entidades.Camarero;
import entidades.Cocinero;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMostrarCocinero extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        //ResultSet rs =DaoCamarero.verCamareros();
        ArrayList<Cocinero> list_cocinero = new ArrayList<Cocinero>();
        list_cocinero = (ArrayList<Cocinero>) DaoCocinero.listarCocinero();
        //Comienza la respuesta
        response.setContentType("text/html;charset=UTF-8");
        //Queda pendiente hacerlo pero con objetos
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de Cocineros</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Cocineros</h1>");

            for (Cocinero cocinero : list_cocinero) {
                out.println("<h1>*********************** </h1>");
                out.println("<p> Id Cocinero: " + cocinero.getIdCocinero() + "</p>");
                out.println("<p> Nombre: " + cocinero.getNombre() + "</p>");
                out.println("<p> Apellido: " + cocinero.getApellido() + "</p>");
                out.println("<p> Especialidad: " + cocinero.getEspecialidad() + "</p>");
            }

            /* while(rs.next()){
              
           out.println("<p>Id camero: "+rs.getString(1)+"</p>");
           out.println("<p> Nombre"+rs.getString(2)+"</p>");
           out.println("<p> Apellido"+rs.getString(3)+"</p>");
              
           } */
            out.println("<a href='gestion.htm'>" + "Volver al inicio" + "</a>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletMostrarCocinero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletMostrarCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletMostrarCocinero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletMostrarCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
