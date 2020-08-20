package Controle;

import java.io.IOException;
import java.io.OutputStream;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import Modele.Membre;
import Modele.OperationResponsable;

/**
 * Servlet implementation class ListeMembreServlet
 */
@WebServlet(urlPatterns = "/ListeMembre.xls")
//@WebServlet("/ListeMembreServlet")
public class ListeMembreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeMembreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/Login.jsp");
			dispatch.forward(request, response);
		} else if (session.getAttribute("user").equals("Responsable")) {
			OperationResponsable or = new OperationResponsable();
			ArrayList<Membre> a = or.listeToExecl();
			try {
				HSSFWorkbook workbook = new HSSFWorkbook();
				CellStyle headerCellStyle = workbook.createCellStyle();
				HSSFFont font = workbook.createFont();
				font.setBold(true);
				headerCellStyle.setFont(font);
				headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
				CellStyle numericCellStyle = workbook.createCellStyle();
				numericCellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("0.00"));
				HSSFSheet articleSheet = workbook.createSheet("BelAirClub");
				HSSFRow row = articleSheet.createRow(0);
				HSSFCell cell;
				row.setRowStyle(headerCellStyle);
				cell = row.createCell(0);
				cell.setCellStyle(headerCellStyle);
				cell.setCellValue("Num");

				cell = row.createCell(1);
				cell.setCellStyle(headerCellStyle);
				cell.setCellValue("Nom");

				cell = row.createCell(2);
				cell.setCellStyle(headerCellStyle);
				cell.setCellValue("Prenom");

				int rowIndex = 1;
				for (Membre e : a) {
					row = articleSheet.createRow(rowIndex++);
					cell = row.createCell(0);
					cell.setCellValue(e.getNum_Membre());

					cell = row.createCell(1);
					cell.setCellValue(e.getNom());

					cell = row.createCell(2);
					cell.setCellValue(e.getPrenom());
				}

				for (int i = 0; i < 3; i++)
					articleSheet.autoSizeColumn(i);

				response.setContentType("application/vnd.ms-excel");
				try (OutputStream out = response.getOutputStream()) {
					workbook.write(out);
				}
				workbook.close();
			} catch (Exception e) {

			}

		} else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/pages/EspaceMembre.jsp");
			dispatch.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
