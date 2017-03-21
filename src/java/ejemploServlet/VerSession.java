
package ejemploServlet;

import entidades.Camarero;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class VerSession extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession misession = (HttpSession) request.getSession();

        Camarero miCamarero = (Camarero) misession.getAttribute("ejemploSesion");

        PrintWriter pw = response.getWriter();
        pw.println("<html><body>" + miCamarero.getIdCamarero() + "," + miCamarero.getNombre() + "," + miCamarero.getApellido()+","+miCamarero.getEspecialidad()+"</body></html>");
        pw.println("<h2>" + misession.getCreationTime() + "</h2>");
        pw.println("<h2>" + misession.isNew() + "</h2>");
        pw.println("<h2>" + misession.getLastAccessedTime() + "</h2>");
        pw.println("<h2>" + misession.getId()+ "</h2>");
        pw.close();

    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
