<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.ArrayList"%>
<%@page import="Modele.Activite"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title> Reserver un creneau | Centre Omnisport Bel Air</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/index.css">
    </head>
    <body >
		<header>
			<jsp:include page="/WEB-INF/template/nav.jsp" />
			<jsp:include page="/WEB-INF/template/log.jsp" />
		</header>
		<main>
		<div class="row">
			<div class="card">
			
			
			<h1> Reserver un creneau</h1>
					<form action="cofirmationServlet" method="POST">	
						<label for="code">Code d'activite: </label><input type="text" id="code" name="code" required>
						<label for="Date1">Jour: </label><input type="number" id="date1" name="jour" min="1" max="7" required><br>
						<label for="Date2">Heure: </label><input type="number" id="date2" name="heure" min="1" max="8" required><br>						
						<input type="submit" size="100" value="Reserver">
					</form>
			</div>
		</div>
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp"/>