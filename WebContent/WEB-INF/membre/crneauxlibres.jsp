<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.ArrayList"%>
<%@page import="Modele.Activite"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title> Liste des creneuax libres | Centre Omnisport Bel Air</title>
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
           	<h1>Les Crenaux Libres</h1>
           	 <c:choose>
           	 	<c:when test="${empty sessionScope.list}">
					<h1>la liste vide</h1>
				</c:when>
				<c:otherwise>
					<form action="getCreaneauxLibresServlet" method="POST">	
						<label for="code">Code d'activite: </label><input type="text" id="code" name="code" required>
						<label for="Date">Jour: </label><input type="number" id="date" name="jour" min="1" max="7" required><br>					
						<input type="submit" size="100" value="Afficher">
						</form>
				</c:otherwise>	
           	 </c:choose>
           	</div>
           	<div class="card">
                <h1>la liste des code des activite</h1>
                <c:choose>
					<c:when test="${empty sessionScope.list}">
					<h1>la liste vide</h1>
					</c:when>
					<c:otherwise>
					<table>
						<tr>
							<th>Code activite</th>
							<th>desgnation</th>
							<th>Prix</th>
						</tr>
						<c:forEach var="list" items="${sessionScope.list}">
							<tr>
							<td><c:out value="${list.getCode()}"></c:out></td>
							<td><c:out value="${list.getDesgnation()}"></c:out></td>
							<td><c:out value="${list.getPrix()}"></c:out></td>
							</tr>
						</c:forEach>
					</table>
					</c:otherwise>
					</c:choose>
                
					
					
                </div>
           	
           </div>
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp"/>