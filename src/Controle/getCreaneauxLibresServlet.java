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
 * Servlet implementation class getCreaneauxLibresServlet
 */
@WebServlet("/getCreaneauxLibresServlet")
public class getCreaneauxLibresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getCreaneauxLibresServlet() {
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
		int code = Integer.parseInt(request.getParameter("code"));
		int jour = Integer.parseInt(request.getParameter("jour"));
		OperationMembre op = new OperationMembre();
		int [] a = op.heureReserveCreneaux(code, jour);
		System.out.println("--------servelt");
		for(int i=0;i<a.length;i++) {
			System.out.println("heure "+i+" : " +a[i]);
		}
		session.setAttribute("list", a);
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/membre/tabCreneauxLibres.jsp");
		dispatch.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
