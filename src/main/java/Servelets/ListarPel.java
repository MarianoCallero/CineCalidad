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

@WebServlet(name = "ListarPel", value = "/ListarPel")
public class ListarPel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PeliculaSessionBean p = (PeliculaSessionBean) request.getSession().getAttribute("Sesion");
        List <Pelicula> LisPel=p.getPeliculas();
        request.setAttribute("listPeliculas", LisPel);
        RequestDispatcher rd = request.getRequestDispatcher("MostrarPeliculas.jsp");
        rd.forward(request, response);
    }
}