<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Gérer les activités sportives | Centre Omnisport Bel Air</title>
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
					<h2>Ajouter une activité</h2>
					<form action="doServlet" method="POST">	
						<label for="des">Description: </label><input type="text" id="des" name="des" required>
						<label for="prix">Prix: </label><input type="text" id="Prix" name="prix" required><br>
						<input type="hidden" value="Ajouter"  name="op" required><br>								
						<input type="submit" value="Ajouter">
						</form>
				</div>
				<div class="card">
					<h2>Modifier une activité</h2>
					<form action="doServlet" method="POST">	
						<label for="code">Code d'activite: </label><input type="text" id="code" name="code" required>
						<label for="des">Nouveau Description: </label><input type="text" id="des" name="des" required>
						<label for="prix">Nouveau prix: </label><input type="text" id="Prix" name="prix" required><br>	
						<input type="hidden" value="Modifier"  name="op" required><br>						
						<input type="submit" value="Modifier">
						</form>
				</div>
			</div>
            <div class="row">
                <div class="card">
					<h1>les activités sportives</h1>
					<c:choose>
					<c:when test="${empty sessionScope.list}">
					<h1>la liste vide</h1>
					</c:when>
					<c:otherwise>
					<table>
						<tr>
							<th>Code</th>
							<th>Description</th>
							<th>Prix</th>
							<th>operation</th>
						</tr>
						<c:forEach var="list" items="${sessionScope.list}">
							<tr>
							<td><c:out value="${list.code}"></c:out></td>
							<td><c:out value="${list.desgnation}"></c:out></td>
							<td><c:out value="${list.prix}"></c:out></td>
							<td><a href="doServlet?op=${list.code}">Supprimer</a></td>
							</tr>
						</c:forEach>
					</table>
					</c:otherwise>
					</c:choose>
					
                </div>
            </div>
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp" />


