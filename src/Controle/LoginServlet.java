package Controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.OperationMembre;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String user = "Responsable";
	private static String passe = "1234";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		int l=1;
		try {
			  l = (int)session.getAttribute("co");
		}
		catch(Exception e) {
			session.setAttribute("co",1);
		}	
		
		String u = request.getParameter("user");		
		String p = request.getParameter("passe");
		
		OperationMembre op = new OperationMembre();
		if(u.equals(user)&&p.equals(passe)) {
			session.setAttribute("user",u);
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/EspaceResponsable.jsp");
			dispatch.forward(request, response);
		}
		else if(op.login(u, p)){
			session.setAttribute("user",u);
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/EspaceMembre.jsp");
			dispatch.forward(request, response);
		}
		else {	
				if((int)session.getAttribute("co")==3) {
					PrintWriter out = response.getWriter();
					out.println("<h1 style=\"color:red\">erreur</h1>");
				}
				else {
					session.setAttribute("co",++l);
					RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/Login.jsp");
					dispatch.forward(request, response);
				}	
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
