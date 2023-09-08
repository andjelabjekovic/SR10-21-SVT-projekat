import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  form: FormGroup;
  constructor( private router: Router,
    private userService: UserService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,) { }

  ngOnInit() {
    
    this.userService.getLogged().subscribe(
			res => {
				this.form = this.formBuilder.group({
          id: res.id,
          firstName: res.firstName,
          lastName: res.lastName ,
          email: res.email ,
          displayName:  res.displayName ,
          description: res.description
        });
			}
		);
  }

  onMyProfile(){
    this.router.navigate(["/myProfile"]);
  }
  onSubmit() {
    
   

    this.userService.updateUser(this.form.value) 
      .subscribe(data => {
        console.log(data); 
     //   this.router.navigate(['']);
      },
        error => {
          console.log('Creation error');
        });

  }

}
