import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post.model';
import { PostService } from '../service/post.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {
	pageSize: number;
	currentPage: number;
	totalSize: number;
	postList: Post[];
	displayedColumns: string[] = ['content', 'creationDate', 'userDisplayName'];

	constructor(
		private postService: PostService,
		private router: Router
	) {
		this.pageSize = 5;
		this.currentPage = 1;
		this.totalSize = 1;
		
		
	}

	changePage(newPage: number) {
		
	}

	ngOnInit() {
		this.postService.getPostsForLogged().subscribe(
			res => {
				this.postList = res as Post[];
			}
		);
	}

	onPostClick(post) {
    
		localStorage.setItem("clickedPost", JSON.stringify(post));
		this.router.navigate(["/detailedPost"]);	
	
	}
}
