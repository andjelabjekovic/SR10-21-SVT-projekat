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
  getPostsForLogged() {
    return this.apiService.get('http://localhost:8080/api/posts/getPostsForLogged');
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
  updatePost(post){
    const signupHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('jwt')
    });
    return this.apiService.put('http://localhost:8080/api/posts', JSON.stringify(post), signupHeaders)
    .pipe(map(() => {
      console.log('Update successful');
    }));
  }
  deletePost(postId){
    const signupHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('jwt')
    });
    return this.apiService.delete('http://localhost:8080/api/posts/' + postId, signupHeaders)
    .pipe(map(() => {
      console.log('Sign up success');
    }));
  }

  createReaction(reaction){
    const signupHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('jwt')
    });
    return this.apiService.post('http://localhost:8080/api/reactions/', JSON.stringify(reaction))
    .pipe(map(() => { 
      console.log('Sign up success');
      
    },catchError((err, caught) => {
      const a = err;
      return 'EMPTY';
    })));
  }

  getCommentsForPost(postId) {
    return this.apiService.get('http://localhost:8080/api/comments/getCommentsForPost/' + postId);
  }

  createComment(comment){
    const signupHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('jwt')
    });
    return this.apiService.post('http://localhost:8080/api/comments/', JSON.stringify(comment), signupHeaders)
    .pipe(map(() => {
      console.log('Sign up success');
    }));
  }


}
