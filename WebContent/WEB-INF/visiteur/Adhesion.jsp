<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Adhésion | Centre Omnisport Bel Air</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/index.css">
    </head>
    <body >
		<header>
			<nav class="indexNavBar">
				<ul>
					<li><a href="${pageContext.request.contextPath}">Accueil</a></li>
					<li><a href="ConsulterServlet">Activites Sportives</a></li>
                	<li><a href="GoToServlet?page=Adhesion">Adhesion</a></li>
				</ul>
			 </nav>
		</header>
		<main>
			<div class="row">
				<div class="card">
					<h1>Adhésion</h1>
					<form action="AdhesionServlet"  method="POST">
						<fieldset>
							<legend>Inforamation</legend>
								<label for="nom">Nom : </label><input type="text" id="nom" name="nom" required><br><br>
								<label for="prenom">Prénom : </label><input id="prenom" type="text" name="prenom" required><br><br>
								<label for="user">Nom de utilisateur : </label><input id="user" type="text" name="user" required><br><br>
								<label for="email">Email : </label><input id="email" type="email" name="email" required><br><br>
								<label for="password">Mote de Passe : </label><input id="password" type="password" name="mdp" required><br><br>
								<label for="dateNais">La date de naissance : </label><input id="dateNais" type="date" name="date" min="1950-01-01" max="2001-12-31" required><br><br>
								<label for="adresse">  Adresse :   </label><textarea id="adresse" name="Adresse" required></textarea><br><br>
						
						</fieldset>
						<fieldset>
							<legend>Document</legend>
								<label>Photo Numérique : </label><input type="file" name="pic"  required><br><br>
								<label>Pièce d'identité : </label><input type="file" name="Pidentite" required><br><br>
								<label>Document de résidence : </label><input type="file" name="Docresidence" required ><br><br>
						</fieldset>
						<input type="submit" value="Envoyer" >
						<input type="reset" value="Supprimer">
						</form>
				</div>
			</div>
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp" />