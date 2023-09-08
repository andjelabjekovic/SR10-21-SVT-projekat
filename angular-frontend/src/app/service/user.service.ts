import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {map} from 'rxjs/operators';

import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUsername;

  constructor(
    private apiService: ApiService,
    private config: ConfigService
  ) {
  }

  getLogged() {
    return this.apiService.get('http://localhost:8080/api/users/getLogged')
      .pipe(map(user => {
        return user;
      }));
  }

  getAll() {
    return this.apiService.get(this.config.users_url);
  }

  updateUser(user){
    const signupHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('jwt')
    });
    return this.apiService.put('http://localhost:8080/api/users', JSON.stringify(user), signupHeaders)
    .pipe(map(() => {
      console.log('Update successful');
    }));
  }

  

}
