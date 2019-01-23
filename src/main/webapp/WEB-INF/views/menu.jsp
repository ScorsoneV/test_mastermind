<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="${pageContext.request.contextPath}/resources/static/css/style.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="${pageContext.request.contextPath}/resources/static/js/validateMenu.js"></script>
<title>MasterMind</title>

</head>
<body>
	<div class="mm-template">
		<h1 class="titolo">Benvenuto in MasterMind</h1>
		<p class="settings">- Scegli le impostazioni della partita -</p>

		<form class="form-player"
			action="${pageContext.request.contextPath}/start" method="post" name="usersForm()">
			<div class="options-user">
				<div class="form-label-player">
					<label class="lbl-form">Giocatore 1</label> <input type="text"
						class="form-control" name="firstPlayer"
						placeholder="Username Giocatore 1" required="true" autofocus="">
				</div>
				<div class="form-label-player">
					<label class="lbl-form">Giocatore 2</label> <input type="text"
						class="form-control" name="secondPlayer"
						placeholder="Username Giocatore 2" value="">
					<div id="errorP" hidden>
						<label class="error-messagge">* Valore non valido</label>
					</div>
				</div>
			</div>
			<div class="input-group options-game">
				<div class="col-md-4">
					<label class="lbl-form" for="difficulty">Livello Difficoltà</label>
				</div>
				<div class="col-md-8">
					<select class="custom-select" id="difficulty" name="difficulty">
						<option value="3">3 - Facile</option>
						<option value="4">4 - Intermedio</option>
						<option value="5">5 - Difficile</option>
					</select>
				</div>
			</div>
			<button class="btn btn-lg btn-primary btn-block" onclick="compareInput()">Inizia</button>
		</form>
		<a href="${pageContext.request.contextPath}/rank"
			class="btn btn-danger">Classifica</a>
	</div>
</body>
</html>