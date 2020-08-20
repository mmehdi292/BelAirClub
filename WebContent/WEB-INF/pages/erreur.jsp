<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
    	String error="";
    	try{
    		error=request.getParameter("err");
    	}
    	catch(Exception e){
    		
    	}
    %>
    <%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error page</title>
<meta http-equiv="refresh" content="3,url=${pageContext.request.contextPath}">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/index.css">
</head>
<body>
<div class="row">
	<div class="card">
		<h1>il y a un erreur de <%=error%></h1>
	</div>
	
</div>
</body>
</html>