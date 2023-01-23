# Austin Events

## Description
This weekends project we were tasked with making an event tracker of our choosing. I chose to make a application to track local arts/musical events in Austin Texas. The user can see events and their information, comment on an event, and post a pictures on the event.

## Route Mappings
| HTTP Verb | URI                  | Request Body | Response Body |
|-----------|----------------------|--------------|---------------|
| GET       | `/api/events`    |              | JSON of `List<TacoStand>` |
| GET       | `/api/events/{id}` |              | JSON of `TacoStand` 17 |
| POST      | `/api/events`    | JSON of a new `Event` | JSON of created `Event` |
| PUT       | `/api/events/{id}` | JSON of a new version of `TacoStand` 17 | JSON of updated `event` |
| DELETE    | `/api/events/{id}` |              | |
## Technologies Used

## Database

## Lessons Learned
