<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% 
    	try{
    		RequestDispatcher dispatch;
    		if(!session.getAttribute("user").equals("Responsable")){
    			dispatch = request.getRequestDispatcher("/WEB-INF/pages/EspaceMembre.jsp");
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
        <title>Menu Responsable | Centre Omnisport Bel Air</title>
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
                    <img src="icons/list.png" alt="Gérer les activités sportives">
                    <h1><a href="GererActsServlet">Gérer les activités sportives</a></h1>
                  </div>
                  <div class="card">
                    <img src="icons/liste_membre.png" alt="La liste des membres">
                    <h1><a href="ListeMembre.xls">La liste des membres</a></h1>
                  </div>
            </div>
			<div class="row">
				
				<div class="card">
				  <img src="icons/block-user.png" alt="Bloquer l'adhésion">
				  <h1><a href="BloquerServlet">Bloquer l'adhésion</a></h1>
				</div>
				<div class="card">
				  <img src="icons/stat.png" alt="Statistiques">
				  <h1><a href="StatistiquesServlet">Statistiques</a></h1>
				</div>
			  </div> 
		</main>
<jsp:include page="/WEB-INF/template/footer.jsp" />