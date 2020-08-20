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

import Modele.Activite;
import Modele.OperationMembre;

/**
 * Servlet implementation class ListeActiviteServlet
 */
@WebServlet("/ListeActiviteServlet")
public class ListeActiviteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeActiviteServlet() {
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
			OperationMembre op = new OperationMembre();
			ArrayList<Activite> a =  op.consulterSansCreneaux();
			session.setAttribute("list", a);
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/membre/listeActs.jsp");
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
