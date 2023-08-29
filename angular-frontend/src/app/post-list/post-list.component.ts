import { Component, OnInit, Input } from '@angular/core';
import { Post } from '../model/post.model';
import { PostService } from '../service/post.service';

import {ActivatedRoute, Router} from '@angular/router';
@Component({
	selector: 'app-post-list',
	templateUrl: './post-list.component.html',
	styleUrls: ['./post-list.component.scss']//
})
export class PostListComponent implements OnInit {
	postList: Post[];
	displayedColumns: string[] = ['content', 'creationDate', 'userDisplayName', 'like', 'dislike', 'heart','likesNumber','dislikesNumber','heartsNumber'];

	constructor(
		private postService: PostService,
		private router: Router,
	) {
		
	}

	

	ngOnInit() {
		this.postService.getPosts().subscribe(
			res => {
				this.postList = res as Post[];
			}
		);
	}

	onPostClick(post) {
    
		localStorage.setItem("clickedPost", JSON.stringify(post));
		this.router.navigate(["/detailedPost"]);	
	}
	likePost(post){
		const reaction = {"type": "LIKE", "postId": post.id, "commentId":-1};

		this.postService.createReaction(reaction) .subscribe(data => 
		{
			console.log(data); 
			this.postService.getPosts().subscribe(
				res => {
					this.postList = res as Post[];
				}
			);
      	},
        error => {
          console.log('Creation error');
        });
	}

	dislikePost(post){
		const reaction = {"type": "DISLIKE", "postId": post.id, "commentId":-1};

		this.postService.createReaction(reaction) .subscribe(data => 
		{
			console.log(data); 
			this.postService.getPosts().subscribe(
				res => {
					this.postList = res as Post[];
				}
			);
      	},
        error => {
          console.log('Creation error');
        });
	}
	heartPost(post){
		const reaction = {"type": "HEART", "postId": post.id, "commentId":-1};

		this.postService.createReaction(reaction) .subscribe(data => 
		{
			console.log(data); 
			this.postService.getPosts().subscribe(
				res => {
					this.postList = res as Post[];
				}
			);
      	},
        error => {
          console.log('Creation error');
        });
	} 
}
