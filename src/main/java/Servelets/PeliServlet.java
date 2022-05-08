package Servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Negocios.PeliculaSessionBean;


/**
 * Servlet implementation class PeliServlet
 */
@WebServlet("/PeliServlet")
public class PeliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeliServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB
    PeliculaSessionBean statelessBean;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String yourName = request.getParameter("yourName");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello " + yourName + "</h1>");
		writer.close();
	}

	  protected void doGet(HttpServletRequest request,
              HttpServletResponse response) throws IOException {
			PrintWriter writer = response.getWriter();
			
			int message = statelessBean.getO();
			
			writer.println(message);
	  }
}
