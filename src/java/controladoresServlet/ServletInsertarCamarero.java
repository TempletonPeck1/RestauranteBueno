package controladoresServlet;

import bo.camarero.restaurante.BoCamarero;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletInsertarCamarero extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

        HttpSession misession = (HttpSession) request.getSession();
        String usuario_logeado = (String) misession.getAttribute("login_usuario");
        String usuario_pass = (String) misession.getAttribute("login_password");

       
        boolean log = (boolean) misession.getAttribute("ok");

        if (log == true) {
            BoCamarero.procesarPeticionCamarero(request, response);
        } else {
            response.sendRedirect("login.html");
        }


}

@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        



} catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletInsertarCamarero.class

.getName()).log(Level.SEVERE, null, ex);
        



} catch (SQLException ex) {
            Logger.getLogger(ServletInsertarCamarero.class

.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        



} catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletInsertarCamarero.class

.getName()).log(Level.SEVERE, null, ex);
        



} catch (SQLException ex) {
            Logger.getLogger(ServletInsertarCamarero.class

.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
        public String getServletInfo() {
        return "Short description";
    }

}
