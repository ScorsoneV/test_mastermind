<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/resources/static/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>END</title>
</head>
<body>
<div class="mm-template">
	<div class="result">
	    <c:choose>
	            <c:when test="${win==true}">
	                <h1 class="titolo">Complimenti!</h1>
	                <p class="settings"><label class="user-1">${game.currentPlayer.username}</label>, hai vinto!</p>
	            </c:when>
	            <c:otherwise>
	                <h1 class="titolo">Peccato!</h1>
	                <p class="settings"><label class="user-1">${game.currentPlayer.username}</label>, ti sei arreso!
	                    <br/>
	            </c:otherwise>
	    </c:choose>
	</div>
    <div class="form-player result-score">
        <p class="settings"><b>La sequenza era:</b></p>
        <div class="form-label-player box-input-ins row">
            <c:forEach begin="0" end="${game.difficulty - 1}" var="index">
                <input type="number" class="form-control box-input col-md-2" readonly="true"
                       disabled="true" value="${game.currentPlayer.sequence[index]}"/>
            </c:forEach>
        </div>
    </div>
    <div class="result">
        <div>
            <label class="user-2">Numero tentativi</label>: ${game.currentPlayer.numbersOfAttempt}
        </div>
        <div>
            <label class="user-1">Punteggio</label>: ${game.currentPlayer.score}
        </div>
    </div>
    <form class="form-player" action="${pageContext.request.contextPath}/back" method="GET">
        <button class="btn btn-lg btn-warning col-md-4" type="submit" value="Ricomincia">Ricomincia</button>
    </form>
</div>
</body>
</html>