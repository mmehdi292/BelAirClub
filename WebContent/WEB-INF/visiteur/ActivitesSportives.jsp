<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="Modele.Creneaux"%>
<%@page import="Modele.Activite"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Activites Sportives | Centre Omnisport Bel Air</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/index.css">
    </head>
    <body >
		<header>
			<nav class="indexNavBar">
				<ul>
					<li><a href="${pageContext.request.contextPath}">Accueil</a></li>
					<li><a href="ConsulterServlet">Activites Sportives</a></li>
                	<li><a href="GoToServlet?page=Adhesion">Adhesion</a></li>
				</ul>
			 </nav>
			 <jsp:include page="/WEB-INF/template/log.jsp" />
		</header>
		
	



		<main>
		
		
		<% 
			ArrayList list = (ArrayList) session.getAttribute("list");
			for(Object r : list) {
			Activite a = (Activite) r;
			out.println();
			out.println("<div class=\"row\">");
			out.println("<div class=\"card\">");
			out.println("<h1>"+a.getDesgnation()+"</h1>");
			out.println("<h2>Code: "+a.getCode()+" | Prix: "+a.getPrix()+" DA</h2>");
			out.println("</div>");
			out.println("</div>");
			}
		%>
					
		</main>
			
<jsp:include page="/WEB-INF/template/footer.jsp" />