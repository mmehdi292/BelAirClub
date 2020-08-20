package Controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoToServlet
 */
@WebServlet("/GoToServlet")
public class GoToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String page = request.getParameter("page");
		RequestDispatcher dispatch;
		switch(page) {
		case "Visiteur":
			 dispatch = request.getRequestDispatcher("/WEB-INF/pages/EspaceVisiteur.jsp");
			dispatch.forward(request, response);
		case "Membre":
			 dispatch = request.getRequestDispatcher("/WEB-INF/pages/EspaceMembre.jsp");
			dispatch.forward(request, response);
		case "Responsable":
			 dispatch = request.getRequestDispatcher("/WEB-INF/pages/EspaceResponsable.jsp");
			dispatch.forward(request, response);
		case "Activites":
			 dispatch = request.getRequestDispatcher("/WEB-INF/visiteur/ActivitesSportives.jsp");
			dispatch.forward(request, response);
		case "Adhesion":
			 dispatch = request.getRequestDispatcher("/WEB-INF/visiteur/Adhesion.jsp");
			dispatch.forward(request, response);
		case "login":
			 dispatch = request.getRequestDispatcher("/WEB-INF/pages/Login.jsp");
			dispatch.forward(request, response);
		default:;
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
