package Controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.OperationMembre;

/**
 * Servlet implementation class AddCreneauxServlet
 */
@WebServlet("/AddCreneauxServlet")
public class AddCreneauxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCreneauxServlet() {
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
		int code = (int) session.getAttribute("code");
		int jour = (int)  session.getAttribute("jour");
		int heure =(int)  session.getAttribute("heure");
		String user = (String) session.getAttribute("user");
		int codereservation = (int) session.getAttribute("codereservation");
		OperationMembre om = new OperationMembre();
		boolean b = false;
		if(codereservation==Integer.parseInt(request.getParameter("codec"))) {
			b = om.addCreneaux(code, jour, heure, user,codereservation);
		}
		
		if(b) {
			RequestDispatcher dispatch = request.getRequestDispatcher("ConsulterListeReservationServlet");
			dispatch.forward(request, response);
		}
		else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/erreur.jsp?error=\"code resarvation\"");
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
