# Austin Events

## Description
This weekends project we were tasked with making an event tracker of our choosing. I chose to make a application to track local arts/musical events in Austin Texas. The user can see events and their information, create/update/delete an event.

## Route Mappings
| HTTP Verb | URI                  | Request Body |
|-----------|----------------------|--------------|
| GET       | `/api/events`    | Get all 'Events' |
| GET       | `/api/events/{id}` | Get 'Event' by id |
| POST      | `/api/events`    | Create new 'Event' |
| PUT       | `/api/events/{id}` | Update 'Event' |
| DELETE    | `/api/events/{id}` | Delete 'Event' by id |
| GET       | `/api/events/{id}/comments`    | Get all 'Comments' |
| POST       | `/api/events/{id}/comments` | Create new 'Comment' |
| DELETE      | `/api/events/{id}/comments/{cid}`    | Delete 'Comment' by id |
| GET       | `/api/events/{id}/pictures`    | Get all 'Pictures' |
| POST       | `/api/events/{id}/pictures` | Create new 'Picture' |
| DELETE      | `/api/events/{id}/pictures/{pid}`    | Delete 'Picture' by id |
| GET       | `/api/types`    | Get all 'Types' |

## Technologies Used
* Java
* JavaScript
* Spring JPA
* Spring Boot
* Git
* Gradle
* MySQL
## Database
![alt text](DB/tables.png)
## Lessons Learned
This week we learned to create a RESTful application with CRUD functionality. We also learned how to create Service classes and Repository methods to personalize the tools we already get with Spring JPA. I also learned that in order to pass the id of the event im wanting to preform any CRUD operations i need to assign the button id the index of the current event in the array of events it is added to when created. This created some what of a head ache when trying to trouble shoot, but using the console to print the values was very helpful when tracking what function i was in and what function i wasnt making it to.
