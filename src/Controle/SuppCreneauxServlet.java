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

import Modele.Email;
import Modele.OperationMembre;

/**
 * Servlet implementation class SuppCreneauxServlet
 */
@WebServlet("/SuppCreneauxServlet")
public class SuppCreneauxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppCreneauxServlet() {
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
		int code=(int)session.getAttribute("code");
		int jour=(int)session.getAttribute("jour");
		int heure=(int)session.getAttribute("heure");
		int codec=Integer.parseInt(request.getParameter("codec"));
		String user = (String) session.getAttribute("user");
		System.out.println(code+" | "+jour+" | "+heure+" | "+user);
		OperationMembre om = new OperationMembre();
		Email e = new Email();
		System.out.println("uuuu");
		int c =om.getCodeConfiramation(code, jour, heure, user);
		System.out.println(codec+" ||| "+c);
		boolean b = codec==c;
		System.out.println(b);
		if(b) {
			ArrayList<String> emails =om.getEmails(code,jour,heure);
			for(String a:emails) {
				
					e.sendAnnulation(a, code, jour, heure);
					
				}
			
			b = om.annulerCreneaux(code, jour, heure, user);
		
			RequestDispatcher dispatch = request.getRequestDispatcher("ConsulterListeReservationServlet");
			dispatch.forward(request, response);
		}
		else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/erreur.jsp?err='Annulation'");
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
