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
			type: { id: document.createEventForm.type.value }
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
	tbody.innerHTML = "";
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
		button.addEventListener('click', getEvent);
		trow.appendChild(button);

		button = document.createElement('button');
		button.textContent = 'delete';
		button.id = i;
		button.addEventListener('click', deleteEvent);
		trow.appendChild(button);

		button = document.createElement('button');
		button.textContent = 'update';
		button.id = i;
		button.addEventListener('click', updateEventForm);
		trow.appendChild(button);


	}

}

function updateEventForm(e) {
	let updateForm = document.getElementById('updateForm');
	updateForm.textContent = '';
	let header = document.createElement('h1');
	header.textContent = 'Update Event';
	updateForm.appendChild(header);

	let form = document.createElement('form');
	form.name = 'updateForm';
	updateForm.appendChild(form);

	let span = document.createElement('span');
	span.textContent = 'Name: ';
	form.appendChild(span);
	let input = document.createElement('input');
	input.name = 'updateName';
	form.appendChild(input);

	let br = document.createElement('br');
	form.appendChild(br);

	span = document.createElement('span');
	span.textContent = 'Start Date: ';
	form.appendChild(span);
	input = document.createElement('input');
	input.name = 'updateStartDate';
	input.type = 'date';
	form.appendChild(input);

	br = document.createElement('br');
	form.appendChild(br);

	span = document.createElement('span');
	span.textContent = 'End Date: ';
	form.appendChild(span);
	input = document.createElement('input');
	input.name = 'updateEndDate';
	input.type = 'date';
	form.appendChild(input);

	br = document.createElement('br');
	form.appendChild(br);

	span = document.createElement('span');
	span.textContent = 'Address: ';
	form.appendChild(span);
	input = document.createElement('input');
	input.name = 'updateAddress';
	form.appendChild(input);

	br = document.createElement('br');
	form.appendChild(br);

	span = document.createElement('span');
	span.textContent = 'Time: ';
	form.appendChild(span);
	input = document.createElement('input');
	input.name = 'updateTime';
	form.appendChild(input);

	br = document.createElement('br');
	form.appendChild(br);

	span = document.createElement('span');
	span.textContent = 'Description: ';
	form.appendChild(span);
	input = document.createElement('input');
	input.name = 'updateDescription';
	form.appendChild(input);

	br = document.createElement('br');
	form.appendChild(br);

	span = document.createElement('span');
	span.textContent = 'Link to Event: ';
	form.appendChild(span);
	input = document.createElement('input');
	input.name = 'updateLink';
	form.appendChild(input);

	br = document.createElement('br');
	form.appendChild(br);

	span = document.createElement('span');
	span.textContent = 'Picture of Event: ';
	form.appendChild(span);
	input = document.createElement('input');
	input.name = 'updateEventPic';
	form.appendChild(input);

	br = document.createElement('br');
	form.appendChild(br);

	let updateBtn = document.createElement('button');
	updateBtn.textContent = 'Update';
	updateBtn.id = e.target.id;
	form.id = e.target.id;
	console.log(e.target.id);
	form.appendChild(updateBtn);
	updateBtn.addEventListener('click', function(e) {
		e.preventDefault();
		console.log(document.updateForm.id);

		let updatedEvent = {
			name: document.updateForm.updateName.value,
			description: document.updateForm.updateDescription.value,
			startDate: document.updateForm.updateStartDate.value,
			endDate: document.updateForm.updateEndDate.value,
			address: document.updateForm.updateAddress.value,
			time: document.updateForm.updateTime.value,
			link: document.updateForm.updateLink.value,
			eventPicture: document.updateForm.updateEventPic.value
		};

		console.log(updatedEvent);
		let eventToUpdate = eventsList[document.updateForm.id];


		let xhr = new XMLHttpRequest();
		xhr.open('PUT', 'api/events/' + eventToUpdate.id, true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {

				if (xhr.status === 200) {
					let event = JSON.parse(xhr.responseText);
					loadEvents();
					displayError('Event Updated!');
				}
				else {
					// * On failure, or if no response text was received, put "Film not found" 
					//   in the filmData div.
					displayError("Error updating event: " + xhr.status);
				}
			}
		}

		xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body
		xhr.send(JSON.stringify(updatedEvent));

	});
}

function getEvent(e) {
	let updateDiv = document.getElementById('updateForm');
	updateDiv.textContent = '';
	let div = document.getElementById('eventDetailsDiv');
	div.textContent = '';
	let event = eventsList[e.target.id];

	let dispEventName = document.createElement('h1');
	dispEventName.textContent = event.name + " at " + event.time;
	div.appendChild(dispEventName);

	let dispEventDate = document.createElement('h3');
	let endDate;
	if (event.endDate === undefined) {
		endDate = ''
	} else {
		endDate = " - " + event.endDate;
	}
	dispEventDate.textContent = event.startDate + endDate;
	div.appendChild(dispEventDate);

	let dispPicture = document.createElement('img');
	dispPicture.src = event.eventPicture;
	div.appendChild(dispPicture);
	
	let dispAddress = document.createElement('h5');
	dispAddress.textContent = "At " + event.address;
	div.appendChild(dispAddress);

	let dispEventDesc = document.createElement('blockquote');
	dispEventDesc.textContent = event.description;
	div.appendChild(dispEventDesc);
	//let dispEventDesc = document.getElementById('eventDescription');
	//dispEventDesc.textContent = event.description;

	let form = document.createElement('form');
	div.appendChild(form);

	let button = document.createElement('button');
	button.textContent = 'delete';
	button.id = e.target.id;
	button.addEventListener('click', deleteEvent);
	form.appendChild(button);

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
				loadEvents();
				displayError('');
			}
			else {
				// * On failure, or if no response text was received, put "Film not found" 
				//   in the filmData div.
				displayError("Error creating event: " + xhr.status);
			}
		}
	}

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body
	xhr.send(JSON.stringify(event));

}


function deleteEvent(e) {
	let event = eventsList[e.target.id];
	let xhr = new XMLHttpRequest();
	console.log(event.id);
	xhr.open('DELETE', 'api/events/' + event.id, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {

			if (xhr.status === 204) {
				loadEvents();
				displayError('Event Deleted');
			}
			else {
				// * On failure, or if no response text was received, put "Film not found" 
				//   in the filmData div.
				displayError("Error deleting event: " + xhr.status);
			}
		}
	}

	//xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body
	xhr.send();

}






