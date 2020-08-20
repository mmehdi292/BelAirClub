<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Espace Visiteur|Centre Omnisport Bel Air</title>
 
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/index.css">
    </head>
    <body>
    
		<header>
			<nav class="indexNavBar">
				<ul>
					<li><a href="${pageContext.request.contextPath}">Accueil</a></li>
					<li><a href="ConsulterServlet">Activites Sportives</a></li>
                	<li><a href="GoToServlet?page=Adhesion">Adhesion</a></li>
				</ul>
			 </nav>
			 <div class="desc">
				<div class="info">
					<div class="left">
						<img src="img/cos.jpg" width="500" height="300" />
					</div>
					<div class="right">
						<h3>Centre Omnisport</h3>
						<p>
						Centre sportif à toutes les activité sportive<br>Bienvenue
						</p>
						<form action="GoToServlet?page=Adhesion" method="POST">
    						<input type="submit" value="Etre membre" />
						</form>
					</div>
				 </div>
			 </div>
		</header>
		<main>
			<div class="row">
				<div class="card">
				  <img src="icons/human.png" alt="Espace Visiteur">
				  <h1><a href="ConsulterServlet">Activites Sportives</a></h1>
				</div>
				<div class="card">
				  <img src="icons/data.png" alt="Espace Membre">
				  <h1><a href="GoToServlet?page=Adhesion">Adhesion</a></h1>
				</div>
			  </div> 
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp" />