package Controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.OperationResponsable;

/**
 * Servlet implementation class BloquerServlet
 */
@WebServlet("/BloquerServlet")
public class BloquerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BloquerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/Login.jsp");
			dispatch.forward(request, response);
		}
		else if(session.getAttribute("user").equals("Responsable")){
			OperationResponsable or = new OperationResponsable();
			session.setAttribute("list", or.annulationUser());
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/responsable/BloquerAdhesion.jsp");
			dispatch.forward(request, response);
		}
		else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/EspaceMembre.jsp");
			dispatch.forward(request, response);
			
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
