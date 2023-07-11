import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Trail } from '../model/trail';

@Injectable({
  providedIn: 'root'
})
export class TrailService {

  // constructor to inject HttpClient
  constructor(private http: HttpClient) { }


  //method to check if the user is register
  public register(userName: string, password: String): Observable<any> {
    return this.http.post('http://localhost:8321/api/v1/user/register', {
      userName,
      password
    });
  }

  //method to check if the user is login
  public login(userName: string, password: String): Observable<any> {
    return this.http.post('http://localhost:8321/api/v1/user/login', {
      userName,
      password
    });
  }

  // Method to call http://localhost:8321/api/v1/clinic/trails
  getTrails(): Observable<any> {
    return this.http.get('http://localhost:8321/api/v1/trails');

  }

  addTrail(trail:Trail) {
    return this.http.post<any>('http://localhost:8321/api/v1/trail',trail);

  }

  updateTrail(trail:Trail) {
    return this.http.put<any>("http://localhost:8321/api/v1/trail/"+localStorage.getItem("id"),trail);

  }

  getTrailById(){
    return this.http.get<any>("http://localhost:8321/api/v1/trail/"+localStorage.getItem("id"));

  }


}
