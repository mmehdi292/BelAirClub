package Controle;



import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Modele.Membre;
import Modele.OperationMembre;

/**
 * Servlet implementation class AdhesionServlet
 */
@WebServlet("/AdhesionServlet")
public class AdhesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdhesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatch;
		 
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String date = request.getParameter("date");
		String adresse = request.getParameter("Adresse");
		String user = request.getParameter("user");
		String passe = request.getParameter("mdp");
		String email = request.getParameter("email");
		Date date1=null;
		SimpleDateFormat d = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(date);
		try {
			date1 = d.parse(date);
		} catch (ParseException e) {
			System.out.println("ParseException");
		}
		Membre m = new Membre(nom, prenom, user, email, passe, date1, adresse);
		OperationMembre op = new OperationMembre();
		boolean b =op.Adherer(m);
		if(b) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			dispatch = request.getRequestDispatcher("/WEB-INF/pages/EspaceMembre.jsp");
			dispatch.forward(request, response);
		}
		else {
			dispatch = request.getRequestDispatcher("/WEB-INF/pages/erreur.jsp");
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
