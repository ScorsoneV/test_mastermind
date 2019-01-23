<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Giocatore ${game.currentPlayer.username}</title>
    <link href="${pageContext.request.contextPath}/resources/static/css/style.css" rel="stylesheet">
</head>
<body>
<div class="mm-template">
    <h1 class="titolo">Let's Play</h1>
    <p class="settings">- <label class="user-1">${game.currentPlayer.username}</label>, è il tuo turno! -</p>

    <form class="form-game" action="${pageContext.request.contextPath}/check" method="POST">
        <div class="box-play">
            <div class="form-label-player row box-input-ins">
                <c:forEach begin="0" end="${game.difficulty - 1}" var="index">
                    <input type="number" class="form-control box-input col-md-2" min="0" max="9" required="true"
                           name="sequenceToCheck" align="middle"/>
                </c:forEach>
            </div>
            <button class="btn btn-lg btn-success col-md-4" type="submit" value="Verifica">Verifica</button>
        </div>
    </form>
    <p class="settings"><b>Nell'ultimo tentativo:</b>
    <div>
        <div>
            <label class="user-1">Corrette nel posto giusto</label> = ${game.currentPlayer.lastAttempt.correct}
        </div>
        <div>
            <label class="user-2">Corrette nel posto sbagliato</label> = ${game.currentPlayer.lastAttempt.present}
        </div>
    </div>
    </p>

    <form class="form-player" action="${pageContext.request.contextPath}/surrender" method="GET">
        <div class="options-user">
            <div class="form-label-player">
                <button class="btn btn-lg btn-danger col-md-4" type="submit" value="Resa">Resa</button>
            </div>
        </div>
    </form>

</div>
</body>
</html>