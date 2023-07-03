import { Component, OnInit, Input } from '@angular/core';
import { Post } from '../model/post.model';
import { PostService } from '../service/post.service';

@Component({
	selector: 'app-post-list',
	templateUrl: './post-list.component.html',
	styleUrls: ['./post-list.component.scss']//
})
export class PostListComponent implements OnInit {
	pageSize: number;
	currentPage: number;
	totalSize: number;
	postList: Post[];

	constructor(
		private postService: PostService
	) {
		this.pageSize = 5;
		this.currentPage = 1;
		this.totalSize = 1;
	}

	changePage(newPage: number) {
		
	}

	ngOnInit() {
		this.postService.getPosts().subscribe(
			res => {
				this.postList = res as Post[];
			}
		);
	}
}
