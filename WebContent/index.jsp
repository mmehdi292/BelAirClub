<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="/WEB-INF/template/header.jsp" />
		<header>
			<jsp:include page="/WEB-INF/template/nav.jsp" />
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
				  <img src="icons/visitor.png" alt="Espace Visiteur">
				  <h1><a href="GoToServlet?page=Visiteur">Espace Visiteur</a></h1>
				</div>
				<div class="card">
				  <img src="icons/membre.png" alt="Espace Membre">
				  <h1><a href="GoToServlet?page=Membre">Espace Membre</a></h1>
				</div>
				<div class="card">
				  <img src="icons/admin.png" alt="Espace Responsable">
				  <h1><a href="GoToServlet?page=Responsable">Espace Responsable</a></h1>
				</div>
			  </div> 
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp" />