import { Component, OnInit } from '@angular/core';
import {UserService} from '../service/user.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor( private userService: UserService, private router: Router) { 
    
  }

  ngOnInit() {
  }

  hasSignedIn() {
    return !!localStorage.getItem("jwt");
  }

  userName() {
    return localStorage.getItem("username");
  }
	onSubmit() {
		this.router.navigate(["/myProfile"]);
	}

  onSubmitHome() {
		this.router.navigate(["/posts"]);
	}

  onSubmitCreatePost() {
		this.router.navigate(["/createPost"]);
	}
}
