package Controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.OperationMembre;

/**
 * Servlet implementation class AnnulerReservationServlet
 */
@WebServlet("/AnnulerReservationServlet")
public class AnnulerReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnulerReservationServlet() {
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
			OperationMembre om = new OperationMembre();
			String user = (String)session.getAttribute("user");
			ArrayList<Object> a =om.ConsulterListeReservation(user);
			session.setAttribute("list", a);
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/membre/AnnulerReservation.jsp");
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
