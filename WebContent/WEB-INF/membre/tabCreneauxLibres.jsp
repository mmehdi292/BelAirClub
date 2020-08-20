<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
           	<table>
           		<tr>
           			<th>Heure</th>
           			<th>resvation</th>
           		</tr>
           		<%
           		int i=1;
           		%>
           		<c:forEach var="list" items="${sessionScope.list}">
						<tr>
						<td><%out.print(i);%></td>
						<td>
							<c:choose>
								<c:when test="${list eq 0}">
									<c:out value="Libre"></c:out>
								</c:when>
								<c:otherwise>
									<c:out value="Resreve"></c:out>
								</c:otherwise>
							</c:choose>
						</td>
						</tr>
							<%i++; %>
				</c:forEach>
           	</table>
           	
           </div>
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp"/>