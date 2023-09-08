import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService, UserService } from '../service';
import { Subject } from 'rxjs/Subject';
import { takeUntil } from 'rxjs/operators';
import { PostService } from '../service/post.service';
import { Post } from '../model/post.model';

interface DisplayMessage {
  msgType: string;
  msgBody: string;
}
@Component({
  selector: 'app-detailed-post',
  templateUrl: './detailed-post.component.html',
  styleUrls: ['./detailed-post.component.css']
})
export class DetailedPostComponent implements OnInit {

  title = 'View post';
  form: FormGroup;
  commentForm: FormGroup;
  selectedPost: Post;

  commentList: Comment[];
	displayedColumns: string[] = ['text', 'creationDate', 'userDisplayName', 'like', 'dislike', 'heart','likesNumber','dislikesNumber','heartsNumber',];
 

  returnUrl: string;
  private ngUnsubscribe: Subject<void> = new Subject<void>();

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private postService: PostService
  ) {

  }

  ngOnInit() {
   
    this.selectedPost = JSON.parse(localStorage.getItem("clickedPost"));
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    this.form = this.formBuilder.group({
      content: [this.selectedPost.content],
      groupId: -1
    });
    this.commentForm = this.formBuilder.group({
      newComment: ['']
    });
    this.postService.getCommentsForPost(this.selectedPost.id).subscribe(
			com => {
				this.commentList = com as Comment[];
			}
		);
  }
  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  onSubmit() {
  
    const updatedPost = {"id": this.selectedPost.id, "content": this.form.value.content}
    this.postService.updatePost(updatedPost) 
      .subscribe(data => {
        console.log(data); 
        
        //this.router.navigate([]);
      },
        error => {
         
        });
  }
  onGoBack(){
    this.router.navigate(["/posts"]);
  }


  onDelete() {
  
    this.postService.deletePost(this.selectedPost.id) 
      .subscribe(data => {
        console.log(data); 
        alert('Post deleted succesfuly')
        this.router.navigate(['/myProfile']);
      },
        error => {
         
        });
  }
  likeComment(comment){
		const reaction = {"type": "LIKE", "commentId": comment.id, "postId":-1};

		this.postService.createReaction(reaction) .subscribe(data => 
		{
			console.log(data); 
			this.postService.getCommentsForPost(this.selectedPost.id).subscribe(
        com => {
          this.commentList = com as Comment[];
        }
      );
      	},
        error => {
          console.log('Creation error');
        });
	}
  dislikeComment(comment){
		const reaction = {"type": "DISLIKE", "commentId": comment.id, "postId":-1};

		this.postService.createReaction(reaction) .subscribe(data => 
		{
			console.log(data); 
			this.postService.getCommentsForPost(this.selectedPost.id).subscribe(
        com => {
          this.commentList = com as Comment[];
        }
      );
      	},
        error => {
          console.log('Creation error');
        });
	}
  heartComment(comment){
		const reaction = {"type": "HEART", "commentId": comment.id, "postId":-1};

		this.postService.createReaction(reaction) .subscribe(data => 
		{
			console.log(data); 
			this.postService.getCommentsForPost(this.selectedPost.id).subscribe(
        com => {
          this.commentList = com as Comment[];
        }
      );
      	},
        error => {
          console.log('Creation error');
        });
	} 

  onNewComment() {
    const newComment = {"text": this.commentForm.value.newComment, "postId":this.selectedPost.id}
    this.postService.createComment(newComment) 
      .subscribe(data => {
        console.log(data); 
        this.postService.getCommentsForPost(this.selectedPost.id).subscribe(
          com => {
            this.commentList = com as Comment[];
          }
        );

      },
        error => {
          
          console.log('Creation error');
         
        });

  }

  
}
