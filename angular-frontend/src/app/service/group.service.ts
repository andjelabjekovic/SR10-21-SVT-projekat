import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';

import { HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable()
export class GroupService {

  constructor(
    private apiService: ApiService,
    private config: ConfigService
  ) {
  }

  getGroups() {
    return this.apiService.get(this.config.group_url);
  }
  createGroup(group){
    const signupHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('jwt')
    });
    return this.apiService.post(this.config.group_url, JSON.stringify(group), signupHeaders)
    .pipe(map(() => {
      console.log('Sign up success');
    }));
  }
  updateGroup(group){
    const signupHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('jwt')
    });
    return this.apiService.put('http://localhost:8080/api/groups', JSON.stringify(group), signupHeaders)
    .pipe(map(() => {
      console.log('Update successful');
    }));
  }
  getGroupsForLogged() {
    return this.apiService.get('http://localhost:8080/api/groups/getGroupsForLogged');
  }
  

}
