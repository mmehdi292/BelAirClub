<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title> | Centre Omnisport Bel Air</title>
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
					<h1>Le nombre de d'adhésion</h1>
					<h2><%=(String) request.getParameter("nombreA")%></h2>
                  </div>
                  <div class="card">
					<h1>le nombre de réservation</h1>
					<h2><%=(String) request.getParameter("nombreR")%></h2>
                  </div>
            </div>
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp" />