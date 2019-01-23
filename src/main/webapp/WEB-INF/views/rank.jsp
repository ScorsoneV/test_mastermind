<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/static/css/style.css" rel="stylesheet">
    <title>Classifica</title>
</head>
<body>
	<div class="mm-template">
		<h1 class="titolo">Classifica</h1>
		<div class="table-responsive">
			<table class="table">
				<thead class="thead-light">
					<tr>
				    	<th scope="col">Posizione</th>
				    	<th scope="col">Giocatore</th>
				    	<th scope="col">Punteggio</th>
		    		</tr>
				</thead>
				<tbody>
					<c:forEach items="${rank.ranking}" var="entry" varStatus="count">
						<tr>
							<th scope="row">${count.index + 1}°</th>
							<td>${entry.key}</td>
							<td>${entry.value}</td>
						</tr>
					</c:forEach> 
				</tbody>
			</table>
		</div>
		<a href="${pageContext.request.contextPath}/backToMenu" class="btn btn-danger">Torna al menu</a>
	</div>
</body>
</html>