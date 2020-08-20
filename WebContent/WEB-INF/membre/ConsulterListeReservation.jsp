<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.ArrayList"%>
<%@page import="Modele.Activite"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title> Liste Des Reservations | Centre Omnisport Bel Air</title>
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
			
			
			<h1>Liste Des Reservations</h1>
					<c:choose>
					<c:when test="${empty sessionScope.list}">
					<h1>la liste vide</h1>
					</c:when>
					<c:otherwise>
					<table>
						<tr>
							<th>Code</th>
							<th>jour</th>
							<th>heure</th>
						</tr>
						<c:forEach var="list" items="${sessionScope.list}">
							<tr>
							<td><c:out value="${list[0]}"></c:out></td>
							<td><c:out value="${list[1]}"></c:out></td>
							<td><c:out value="${list[2]}"></c:out></td>
							</tr>
						</c:forEach>
					</table>
					</c:otherwise>
					</c:choose>
					
			
			
			
			
			</div>
		</div>
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp"/>