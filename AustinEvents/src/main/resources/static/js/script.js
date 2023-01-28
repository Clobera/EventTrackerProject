console.log('script.js loaded');
let eventsList;
window.addEventListener('load', function(e) {
	console.log('page loaded');

	init();
});

function init() {
	loadEvents();
document.getElementById('createEventBtn').addEventListener('click', function(e) {
		
		console.log('hello');
	let newEvent = {
		name: document.createEventForm.name.value,
		description: document.createEventForm.description.value,
		startDate: document.createEventForm.startDate.value,
		endDate: document.createEventForm.endDate.value,
		address: document.createEventForm.address.value,
		time: document.createEventForm.time.value,
		link: document.createEventForm.link.value,
		eventPicture: document.createEventForm.eventPicture.value,
		type:{id: document.createEventForm.type.value}
	};
	
	console.log(newEvent);
	createEvent(newEvent);
});
}

function loadEvents() {
	// AJAX
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/events');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				eventsList = JSON.parse(xhr.responseText);
				console.log(eventsList);
				displayEvents(eventsList);
			}
			else {

			}
		}
	}
	xhr.send();


}

function displayEvents(eventList) {
	//DOM USE TABLE TO LIST EVENTS detail.js/ table.js
	let tbody = document.getElementById("tableBody");
	console.log(tbody)
	for (let i = 0; i < eventList.length; i++) {
		let event = eventList[i];
		let trow = document.createElement('tr');
		tbody.appendChild(trow);
		let td = document.createElement('td');
		td.textContent = event.startDate;
		trow.appendChild(td);
		td = document.createElement('td');
		td.textContent = event.name;
		trow.appendChild(td);
		let button = document.createElement('button');
		button.textContent = 'view';
		button.id = i;
		button.addEventListener('click', getEvent)
		trow.appendChild(button);

	}

}

function getEvent(e) {
	let event = eventsList[e.target.id];
	let dispEventName = document.getElementById('eventName');
	dispEventName.textContent = event.name;
	let dispEventDate = document.getElementById('eventDate');
	let endDate;
	if (event.endDate === undefined) {
		endDate = ''
	} else {
		endDate = " - " + event.endDate;
	}
	dispEventDate.textContent = event.startDate + endDate;
	let dispEventDesc = document.getElementById('eventDescription');
	dispEventDesc.textContent = event.description;
	//let dispEventDesc = document.getElementById('eventDescription');
	//dispEventDesc.textContent = event.description;


}

function getType(e) {
	let event = eventsList[e.target.type.id];

}




function displayError(message) {
	let div = document.getElementById('eventDetails');
	div.textContent = message;
}




function createEvent(event) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/events', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {

			if (xhr.status === 200 || xhr.status === 201) {
				let event = JSON.parse(xhr.responseText);
				getEvent(event);
			}
		}
		else {
			// * On failure, or if no response text was received, put "Film not found" 
			//   in the filmData div.
			displayError("Error creating event: " + xhr.status);
		}
	}

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body
	xhr.send(JSON.stringify(event));

}






