import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';

import { catchError, map } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class PostService {

  constructor(
    private apiService: ApiService,
    private config: ConfigService
  ) {
  }

  getPosts() {
    return this.apiService.get(this.config.post_url);
  }
  createPost(post){
    const signupHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('jwt')
    });
    return this.apiService.post(this.config.post_url, JSON.stringify(post), signupHeaders)
    .pipe(map(() => {
      console.log('Sign up success');
    }));


   
  }

}
