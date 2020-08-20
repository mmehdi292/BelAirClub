package Controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.Activite;
import Modele.OperationResponsable;

/**
 * Servlet implementation class doServlet
 */
@WebServlet("/doServlet")
public class doServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String op =  (String) request.getParameter("op");
	
		int code=0;
		double prix=0;
		String des="";
		String err="";
		try {
			 des = (String) request.getParameter("des");
			 prix = Double.parseDouble(request.getParameter("prix"));
			 code = Integer.parseInt(request.getParameter("code"));
		}
		catch(Exception e) {
			
		}
		
		OperationResponsable or =new OperationResponsable();
		boolean b = false;
		if(op.equals("Ajouter")) {
			if(or.addActivite(new Activite(code,des,prix))) b=true;
			else err="ajoute";
		}
		else if(op.equals("Modifier")) {
			if(or.modActivite(new Activite(code,des,prix),code))  b=true;
			else err="modification";
		}
		else {
			int supp = Integer.parseInt(op);
			System.out.println("int "+supp);
			if(or.delActivite(supp)) b=true;
			else err="supprition"; 
				
			}
		if(b) {
			RequestDispatcher dispatch = request.getRequestDispatcher("GererActsServlet");
			dispatch.forward(request, response);
		}
		else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/erreur.jsp?err="+err);
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
