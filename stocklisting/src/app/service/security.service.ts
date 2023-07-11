import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  private tokenKey = 'token';

  constructor(private http: HttpClient) {
  }

  updateToken(token: any, id: any) {
    localStorage.setItem(this.tokenKey, token);
    localStorage.setItem('pId', id);
  }

  getToken() {
    return localStorage.getItem(this.tokenKey);
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    return token != null;
  }

  removeToken() {
    localStorage.removeItem(this.tokenKey);
  }
}
