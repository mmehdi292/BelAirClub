<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% 
    	try{
    		RequestDispatcher dispatch;
    		if(session.getAttribute("user").equals("Responsable")){
    			dispatch = request.getRequestDispatcher("/WEB-INF/pages/EspaceResponsable.jsp");
    			dispatch.forward(request, response);
    		}
    	}
    	catch(Exception e){
    	
    	}
    
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Espace Membre|Centre Omnisport Bel Air</title>
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
				  <img src="icons/list.png" alt="La liste d'activités">
				  <h1><a href="ListeActiviteServlet">La liste d'activités</a></h1>
				</div>
				<div class="card">
				  <img src="icons/cr.png" alt="Les créneaux libres">
				  <h1><a href="CreneauxLibreServlet">Les créneaux libres</a></h1>
				</div>
			</div>
				<div class="row">
				<div class="card">
				  <img src="icons/rc.png" alt="Réserver un créneaux">
				  <h1><a href="ReserverCreneauxServlet">Réserver un créneaux</a></h1>
				</div>
				<div class="card">
					<img src="icons/liste_res.png" alt="La liste des réservations">
					<h1><a href="ConsulterListeReservationServlet">La liste des réservations</a></h1>
				  </div>
				</div>
				  <div class="row">
				  <div class="card">
					<img src="icons/cancel.png" alt="Annuler une réservation">
					<h1><a href="AnnulerReservationServlet">Annuler une réservation</a></h1>
				  </div>
			  </div> 
		</main>
		<footer>
			<div class="ft">
				<div class="left"><p>Tous les droits sont réservés © 2019-2020</p></div>
				<div class="right"><p>projet DAAW : CHAIBRASSOU MEHDI & REKIBI AHMED </p></div>
			</div>
		</footer>
    </body>
</html>