<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Inserimento sequenze</title>
    <link href="${pageContext.request.contextPath}/resources/static/css/style.css" rel="stylesheet">
</head>
<body>
<div class="mm-template">
    <h1 class="titolo">Multiplayer</h1>
    <p class="settings">- Sfida il tuo avversario -</p>
    <form class="form-player" action="${pageContext.request.contextPath}/startMultiplayer" method="POST">
        <div class="options-user">
            <div class="form-label-player">
                <label class="lbl-form">
                    <label class="user-1">${game.firstPlayer.username}</label> definisci la sequenza per
                    <label class="user-2">${game.secondPlayer.username}</label>
                </label>
                <div class="row box-input-ins">
	                <c:forEach begin="0" end="${game.difficulty - 1}" var="index">
	                    <input type="password" class="form-control box-input ctr-input col-md-2" size="1" pattern="[0-9]"
	                           name="sequenceSecondPlayer"/>
	                </c:forEach>
	            </div>
            </div>
            <div class="form-label-player">
                <label class="lbl-form">
                    <label class="user-2">${game.secondPlayer.username}</label> definisci la sequenza per
                    <label class="user-1">${game.firstPlayer.username}</label>
                </label>
            <div class="row box-input-ins">
	            <c:forEach begin="0" end="${game.difficulty - 1}" var="index">
	                <input type="password" class="form-control box-input ctr-input col-md-2" size="1" pattern="[0-9]" name="sequenceFirstPlayer"/>
	            </c:forEach>
            </div>
            </div>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Inizia">Inizia</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>