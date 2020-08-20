package Controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.Email;
import Modele.OperationMembre;

/**
 * Servlet implementation class cofirmationServlet
 */
@WebServlet("/cofirmationServlet")
public class cofirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cofirmationServlet() {
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
			if (session.getAttribute("user") == null) {
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/Login.jsp");
				dispatch.forward(request, response);
			} else if (session.getAttribute("user").equals("Responsable")) {
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/EspaceResponsable.jsp");
				dispatch.forward(request, response);
			} else {
				int code = Integer.parseInt(request.getParameter("code"));
				int jour = Integer.parseInt(request.getParameter("jour"));
				int heure = Integer.parseInt(request.getParameter("heure"));
				String user = (String) session.getAttribute("user");
				int codereservation = randomCode(0,999999);
				OperationMembre op =new OperationMembre();
				String email = op.getEmail(user);
				Email e = new Email();
				e.sendCode(codereservation, email);
				session.setAttribute("code", code);
				session.setAttribute("jour", jour);
				session.setAttribute("heure", heure);
				session.setAttribute("user", user);
				session.setAttribute("codereservation", codereservation);
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/membre/confirmation.jsp");
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
	public int randomCode(int min,int max) {
		int x = (int)(Math.random()*((max-min)+1))+min;
		return x;
	}
}
