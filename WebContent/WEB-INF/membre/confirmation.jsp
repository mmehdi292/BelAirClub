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
			
			
			<h1> Confrmire le reservation </h1>
				<p>le code de comfiramtion est envory a email</p>
					<form action="AddCreneauxServlet" method="POST">	
						<label for="code">Code de confiramtion: </label><input type="text" id="code" name="codec" required>						
						<input type="submit" size="100" value="Reserver">
					</form>
			</div>
		</div>
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp"/>