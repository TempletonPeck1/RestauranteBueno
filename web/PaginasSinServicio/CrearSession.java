package controladoresServlet;

import entidades.Camarero;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CrearSession extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Creamos una sesion y la asociamos al usuario
        //En la sesion se guardan objetos, listas, variables
        HttpSession sesionRestaurante = request.getSession(true);

        Camarero ultimo_camarero = new Camarero();
        ultimo_camarero.setIdCamarero(11);
        ultimo_camarero.setNombre("Nacho");
        ultimo_camarero.setApellido("Diez");
        ultimo_camarero.setEspecialidad("Terrraza");

        //HttpSession misession = request.getSession(true);
        //Producto miproducto = new Producto(1, "telefono", 300);
        //coloca el objeto en la session
        sesionRestaurante.setAttribute("ejemploSesion", ultimo_camarero);

        PrintWriter pw = response.getWriter();
        pw.println("<html><body>Producto en session</body></html>");
        pw.println("<h2>" + sesionRestaurante.isNew() + "</h2>");
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
