<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<nav class="indexNavBar">
<% 

if(session.getAttribute("user")==null) {
	%>
				
				<ul>
					<li><a href="GoToServlet?page=Visiteur">Espace Visiteur</a></li>
					<li><a href="GoToServlet?page=Membre">Espace Membre</a></li>
					<li><a href="GoToServlet?page=Responsable">Espace Responsable</a></li>
				</ul>
	
	<% 
}
else if(session.getAttribute("user").equals("Responsable")){
%>

				<ul>
					<li><a href="GererActsServlet">Gérer les activités sportives</a></li>
                    <li><a href="ListeMembre.xls">La liste des membres</a></li>
                    <li><a href="BloquerServlet">Bloquer l'adhésion</a></li>
                    <li><a href="StatistiquesServlet">Statistiques</a></li>
				</ul>

<% 
}
else {
	
	%>
	
	
				<ul>
					<li><a href="ListeActiviteServlet">La liste d'activités</a></li>
					<li><a href="CreneauxLibreServlet">Les créneaux libres</a></li>
					<li><a href="ReserverCreneauxServlet">Réserver un créneaux</a></li>
					<li><a href="ConsulterListeReservationServlet">La liste des réservations</a></li>
					<li><a href="AnnulerReservationServlet">Annuler une réservation</a></li>
				</ul>
	
	
	<%
}

%>
</nav>