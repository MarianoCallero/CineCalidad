package Servelets;

import Clases.Pelicula;
import Negocios.PeliculaSessionBean;
import Negocios.PeliculaSessionBeanRemote;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddPeli", value = "/AddPeli")
public class AddPeli extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PeliculaSessionBean p = new PeliculaSessionBean();
        String l=request.getParameter("lanzamiento");
        String n = request.getParameter("nombre");
        String d = request.getParameter("descripcion");
        HttpSession session = request.getSession();
        session.setAttribute("pelic",p);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter writer = response.getWriter();
        writer.println("Articulo Guardado");
    }
}
