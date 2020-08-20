package Controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class AnnulerServlet
 */
@WebServlet("/AnnulerServlet")
public class AnnulerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnulerServlet() {
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
		int code=Integer.parseInt(request.getParameter("code"));
		System.out.println(code);
		int jour=Integer.parseInt(request.getParameter("jour"));
		int heure=Integer.parseInt(request.getParameter("heure"));
		String user = (String) session.getAttribute("user");
		System.out.println(code+" | "+jour+" | "+heure+" | "+user);
		session.setAttribute("code", code);
		session.setAttribute("jour", jour);
		session.setAttribute("heure", heure);
		//OperationMembre om = new OperationMembre();
		//boolean b = om.annulerCreneaux(code, jour, heure, user);
		//if(b) {
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/membre/confirmationAnnulation.jsp");
			dispatch.forward(request, response);
	//	}
	//	else {
	//		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/erreur.jsp?err='Annulation'");
	//		dispatch.forward(request, response);
	//	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
