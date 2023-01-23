# Austin Events

## Description
This weekends project we were tasked with making an event tracker of our choosing. I chose to make a application to track local arts/musical events in Austin Texas. The user can see events and their information, comment on an event, and post a pictures on the event.

## Route Mappings
| HTTP Verb | URI                  | Request Body |
|-----------|----------------------|--------------|
| GET       | `/api/events`    |              |
| GET       | `/api/events/{id}` |              |
| POST      | `/api/events`    | JSON of a new `Event` |
| PUT       | `/api/events/{id}` | JSON of a new version of `TacoStand` 17 |
| DELETE    | `/api/events/{id}` |              |
| GET       | `/api/events/{id}/comments`    |              |
| POST       | `/api/events/{id}/comments` |              |
| DELETE      | `/api/events/{id}/comments/{cid}`    | JSON of a new `Event` |
| GET       | `/api/events/{id}/pictures`    |              |
| POST       | `/api/events/{id}/pictures` |              |
| DELETE      | `/api/events/{id}/pictures/{pid}`    | JSON of a new `Event` |
| GET       | `/api/types`    |              |

## Technologies Used

## Database

## Lessons Learned
