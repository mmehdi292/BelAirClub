<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>s'identifier | Centre Omnisport Bel Air</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/index.css">
    </head>
    <body >
		<header>
			<nav class="indexNavBar">
				<ul>
					<li><a href="GoToServlet?page=Visiteur">Espace Visiteur</a></li>
					<li><a href="GoToServlet?page=Membre">Espace Membre</a></li>
					<li><a href="GoToServlet?page=Responsable">Espace Responsable</a></li>
				</ul>
			 </nav>
		</header>
		<main>
			<div class="row">
				<div class="card">
					<h1>s'identifier</h1>	
					<form action="LoginServlet" method="POST">	
						<label for="user">Nom d'utilisateur: </label><input type="text" id="user" name="user" required>
								<label for="passe">Mote de passe: </label><input type="password" id="passe" name="passe" required>
								<br>						
								<input type="submit" value="Entre">
						</form>
				</div>
			</div>
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp" />