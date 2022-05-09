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
    PeliculaSessionBeanRemote p = new PeliculaSessionBean();
    List<Pelicula> pelis = null;
    HttpSession pels;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String l=request.getParameter("lanzamiento");
        String n = request.getParameter("nombre");
        String d = request.getParameter("descripcion");
        p.addPeliculas(l,n,d);
        pels=request.getSession();
        pels.setAttribute("peliculas",p.getPeliculas());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter writer = response.getWriter();
        //PeliculaSessionBean p = new PeliculaSessionBean();
        String message="";
        List<Pelicula> pp = new ArrayList<Pelicula> ();
        pp=(ArrayList<Pelicula>) pels.getAttribute("Peliculas");
        for(int i=0;i<pp.size();i++){
            message = message + pp.get(i).toString() +"\n";
        }
        writer.println(message);
    }
}
