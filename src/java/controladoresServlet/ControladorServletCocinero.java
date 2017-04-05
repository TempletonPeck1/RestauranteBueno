package controladoresServlet;

import bo.cocinero.restaurante.BoCocinero;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControladorServletCocinero extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        //Comprobamos si el usuario esta logueado    
        HttpSession misession = (HttpSession) request.getSession();
        //String usuario_logeado = (String) misession.getAttribute("login_usuario");
        // String usuario_pass = (String) misession.getAttribute("login_password");

        boolean log = (boolean) misession.getAttribute("ok");
        //si el usuario esta logeado
        if (log == true) {
            //recupera el action del formulario
            String action = request.getParameter("action");

            if (action.contains("insertar")) {
                BoCocinero.procesarInsertarCocinero(request, response);
                response.sendRedirect("ServletMostrarCocinero");
            }

            if (action.contains("actualizar")) {
                BoCocinero.procesarActualizarCocinero(request, response);
                response.sendRedirect("ServletMostrarCocinero");
            }

            if (action.contains("borrar")) {
                BoCocinero.procesarBorrarCocinero(request, response);
                response.sendRedirect("ServletMostrarCocinero");
            }
            
        } else {

            response.sendRedirect("login.html");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorServletCocinero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorServletCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorServletCocinero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorServletCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
