<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.ArrayList"%>
<%@page import="Modele.Activite"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title> Liste D'activite | Centre Omnisport Bel Air</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/index.css">
    </head>
    <body >
		<header>
			<jsp:include page="/WEB-INF/template/nav.jsp" />
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
<jsp:include page="/WEB-INF/template/footer.jsp"/>