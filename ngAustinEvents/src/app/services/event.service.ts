import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Event } from 'src/app/models/event';

@Injectable({
  providedIn: 'root',
})
export class EventService {
  url = environment.baseUrl + 'api/events';



  //METHODS
  constructor(private http: HttpClient) {}

  index(): Observable<Event[]> {
    return this.http.get<Event[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error('EventService.index(): error retrieving event list: ' + err)
        );
      })
    );
  }
//show, create, update, destroy

create(event: Event): Observable<Event> {
  return this.http.post<Event>(this.url, event).pipe(
    catchError((err: any) => {
      console.error(err);
      return throwError(
         () => new Error( 'ProductService.create(): error creating Product: ' + err )
      );
    })
  );
}


update(id: number, updates: Event): Observable<Event> {
  return this.http.put<Event>(this.url +'/'+ id, updates);
}

destroy(id: number): Observable<void> {
  return this.http.delete<void>(this.url +'/'+ id);
}







}
