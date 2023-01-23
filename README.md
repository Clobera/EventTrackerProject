# Austin Events

## Description
This weekends project we were tasked with making an event tracker of our choosing. I chose to make a application to track local arts/musical events in Austin Texas. The user can see events and their information, comment on an event, and post a pictures on the event.

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

## Database

## Lessons Learned
