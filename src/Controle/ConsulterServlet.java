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
 * Servlet implementation class ConsulterServlet
 */
@WebServlet("/ConsulterServlet")
public class ConsulterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("[Counsulter Servlet] i am in servlet");
		OperationMembre op = new OperationMembre();
		System.out.println("[Counsulter Servlet] op has been created");
		ArrayList<Activite> a =  op.consulterSansCreneaux();
		System.out.println("[Counsulter Servlet] consulterSansCreneaux has been executed");
		HttpSession session = request.getSession();
		session.setAttribute("list", a);
		System.out.println("[Counsulter Servlet] session has been created");
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/visiteur/ActivitesSportives.jsp");
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
