import { Component } from '@angular/core';
import { EventService } from 'src/app/services/event.service';
import { Event } from 'src/app/models/event';
import { Type } from 'src/app/models/type';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  events: Event [] = [];

  newEvent: Event = new Event();

  selected: null | Event = null;

  editEvent: null | Event = null;

  showForm: boolean = false;


  constructor(private eventService: EventService) {}

  ngOnInit() {
    this.reload();
  }

  reload(){
    this.eventService.index().subscribe({
      next: (eventlist) =>{
        this.events = eventlist;
      },
      error: (ugh) =>{
        console.error(ugh);
        console.error('ERROR LOADING EVENT LIST');
      }
    });
  }

  displayEvent(dispEvent: Event){
    console.log(dispEvent);
    this.selected = dispEvent;
  }

  addEvent(addEvent: Event){
    console.log(addEvent);
    addEvent.type = new Type(1);
    console.log(addEvent);
    this.eventService.create(addEvent).subscribe({
      next: (result) => {
        this.newEvent = new Event();
        this.reload();
      },
      error: (ugh) => {
        console.error('ERROR CREATING EVENT');
        console.error(ugh);
      }
    });
  }

  updateTodo(id: number, todo: Event): void {
    this.eventService.update(id, todo).subscribe({
      next: (result) => {
        this.editEvent = null;
        this.selected = todo;
        this.reload();
      },
      error: (ugh) => {
        console.error('ERROR UPDATING EVENT');
        console.error(ugh);
      }
    });
  }

  destroy(id: number){
    this.eventService.destroy(id).subscribe({
      next: (result) => {
        this.reload();
      },
      error: (ugh) => {
        console.error('ERROR DELETING EVENT');
        console.error(ugh);
      }
    });
  }





  displayTable() {
    this.selected = null;
  }

  setEditEvent(): void {
    this.editEvent = Object.assign({}, this.selected);
  }

}
