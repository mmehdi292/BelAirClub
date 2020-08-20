<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList"%>
     <%@page import="Modele.Membre"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Bloquer l'adhesion | Centre Omnisport Bel Air</title>
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
                <h1>Les utilisateur ayant plus que  trios annullation</h1>
                <c:choose>
					<c:when test="${empty sessionScope.list}">
					<h1>la liste vide</h1>
					</c:when>
					<c:otherwise>
					<table>
						<tr>
							<th>Num</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>User</th>
							<th>nombre d'annullation</th>
							<th>bloque</th>
						</tr>
						<c:forEach var="list" items="${sessionScope.list}">
							<tr>
							<td><c:out value="${list.getNum_Membre()}"></c:out></td>
							<td><c:out value="${list.getNom()}"></c:out></td>
							<td><c:out value="${list.getPrenom()}"></c:out></td>
							<td><c:out value="${list.getUser()}"></c:out></td>
							<td><c:out value="${list.getNum_anulation()}"></c:out></td>
							<td><a href="BlockUserServlet?user=${list.getUser()}">
							<c:choose>
							<c:when test="${list.isBlocked()==true}">desbloque</c:when>
							<c:otherwise>bloque</c:otherwise>
							</c:choose>
							</tr>
						</c:forEach>
					</table>
					</c:otherwise>
					</c:choose>
                
					
					
                </div>
            </div>
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp" />