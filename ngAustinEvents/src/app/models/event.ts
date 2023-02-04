import { Type } from "./type";

export class Event {
  id: number;
  name: string;
  startDate: string;
  endDate: string;
  address: string;
  time: string;
  description: string;
  link: string;
  eventPicture: string;
  type: Type | null;


  constructor(id: number = 0, name: string = "", startDate: string = "", endDate: string = "", address: string = "", time: string = "", description: string = "", link: string = "", eventPicture: string = "", type: Type | null = null){
  this.id = id;
  this.name = name;
  this.startDate = startDate;
  this.endDate = endDate;
  this.address = address;
  this.time = time;
  this.description = description;
  this.link = link;
  this.eventPicture = eventPicture;
  this.type = type;
  }
}
