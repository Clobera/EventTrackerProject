console.log('script.js loaded');

window.addEventListener('load', function(e) {
	console.log('page loaded');

	init();
});

function init() {
	loadEvents();
}

function loadEvents() {
	// AJAX
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/events');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let eventsList = JSON.parse(xhr.responseText);
				console.log(eventsList);
				displayEvents(eventsList);
			}
			else {

			}
		}
	}
	xhr.send();


}

function displayEvents() {
	//DOM USE TABLE TO LIST EVENTS
}










