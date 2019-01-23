/**
 * 
 */

function compareInput() {

	var username1 = document.getElementsByName('firstPlayer')[0];
	var username2 = document.getElementsByName('secondPlayer')[0];

	if (username1 && typeof username1.value !== 'undefined'
			&& username1.value !== '') {
		if (username1.value === username2.value) {
			document.getElementById('errorP').style.display = 'block';
			alert("I due username non possono essere uguali");
			return false;
		} else {
			document.getElementById('errorP').style.display = 'none';
			return true;
		}
	}
}

function callService(){
	if(compareInput()){
		document.getElementById('usersForm').submit();
	}
}

