<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="refresh" content="3,url=${pageContext.request.contextPath}">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/index.css">
<title>logout page</title>
</head>
<body>
<main>



<div class="row">
	<div class="card">
		<h1>a la prochaine <%=(String) request.getParameter("user")%></h1>
	</div>
	
</div>
</main>
</body>
</html>