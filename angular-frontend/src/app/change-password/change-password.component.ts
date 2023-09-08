import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  form: FormGroup;
  constructor(private router: Router, 
    private formBuilder: FormBuilder,
    private postService: PostService) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      oldPassword: [''],
      newPassword: [''],
      newPasswordAgain: ['']
    });
  }

  onGoBack() {
    this.router.navigate(['/myProfile']); // Preusmjerava na "/changePassword" putanju
  }

  onSubmit() {
    if(this.form.value.newPassword !== this.form.value.newPasswordAgain){
      alert('new passwords dont match');
      return;
    }
    this.postService.changePassword(this.form.value) 
      .subscribe(data => {
        console.log(data); 
        this.router.navigate(['myProfile']);
      },
        error => {
          console.log('Creation error');
        });

  }
}
